package com.newjumper.naturesend;

import com.newjumper.naturesend.content.NaturesBlockEntities;
import com.newjumper.naturesend.content.NaturesBlocks;
import com.newjumper.naturesend.content.NaturesEntities;
import com.newjumper.naturesend.content.NaturesItems;
import com.newjumper.naturesend.datagen.assets.ENLanguageProvider;
import com.newjumper.naturesend.datagen.assets.NaturesBlockStateProvider;
import com.newjumper.naturesend.datagen.assets.NaturesItemModelProvider;
import com.newjumper.naturesend.datagen.data.*;
import com.newjumper.naturesend.util.NaturesCreativeTab;
import com.newjumper.naturesend.util.render.NaturesBoatRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(NaturesEnd.MOD_ID)
public class NaturesEnd {
    public static final String MOD_ID = "naturesend";

    public NaturesEnd() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        NaturesCreativeTab.CREATIVE_MODE_TABS.register(eventBus);
        NaturesItems.ITEMS.register(eventBus);
        NaturesBlocks.BLOCKS.register(eventBus);
        NaturesBlockEntities.BLOCK_ENTITIES.register(eventBus);
        NaturesEntities.ENTITIES.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);
        eventBus.addListener(NaturesCreativeTab::buildCreativeTab);
        eventBus.addListener(this::generateData);
    }

    private void generateData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();

        // assets
        generator.addProvider(event.includeClient(), new NaturesBlockStateProvider(packOutput, fileHelper));
        generator.addProvider(event.includeClient(), new NaturesItemModelProvider(packOutput, fileHelper));

        generator.addProvider(event.includeClient(), new ENLanguageProvider(packOutput));

        // data
        generator.addProvider(event.includeServer(), new NaturesRecipeProvider(packOutput));

        NaturesBlockTagsProvider blockTags = new NaturesBlockTagsProvider(packOutput, event.getLookupProvider(), fileHelper);
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), new NaturesItemTagsProvider(packOutput, event.getLookupProvider(), blockTags, fileHelper));

        generator.addProvider(event.includeServer(), new NaturesLootTableProvider(packOutput));

        generator.addProvider(event.includeServer(), new NaturesWorldGeneration(packOutput, event.getLookupProvider()));
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class NaturesEndClient {
        @SubscribeEvent
        public static void clientSetup(final FMLClientSetupEvent event) {
            BlockEntityRenderers.register(NaturesBlockEntities.NATURES_SIGNS.get(), SignRenderer::new);
            BlockEntityRenderers.register(NaturesBlockEntities.NATURES_HANGING_SIGNS.get(), HangingSignRenderer::new);
            EntityRenderers.register(NaturesEntities.NATURES_BOAT.get(), (context) -> new NaturesBoatRenderer(context, false));
            EntityRenderers.register(NaturesEntities.NATURES_CHEST_BOAT.get(), (context) -> new NaturesBoatRenderer(context, true));
        }
    }
}
