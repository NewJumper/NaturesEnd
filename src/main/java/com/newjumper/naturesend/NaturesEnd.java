package com.newjumper.naturesend;

import com.newjumper.naturesend.content.NaturesBlocks;
import com.newjumper.naturesend.content.NaturesItems;
import com.newjumper.naturesend.datagen.assets.ENLanguageProvider;
import com.newjumper.naturesend.datagen.assets.NaturesBlockStateProvider;
import com.newjumper.naturesend.datagen.assets.NaturesItemModelProvider;
import com.newjumper.naturesend.datagen.data.NaturesBlockTagsProvider;
import com.newjumper.naturesend.datagen.data.NaturesItemTagsProvider;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@Mod(NaturesEnd.MOD_ID)
public class NaturesEnd {
    public static final String MOD_ID = "naturesend";
    private static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);
    private static final RegistryObject<CreativeModeTab> NATURES_END = CREATIVE_MODE_TABS.register("natures_end", () -> CreativeModeTab.builder().title(Component.translatable("itemGroup." + MOD_ID)).icon(() -> new ItemStack(NaturesBlocks.WILLOW_LOG.get())).build());

    public NaturesEnd() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        CREATIVE_MODE_TABS.register(eventBus);
        NaturesItems.ITEMS.register(eventBus);
        NaturesBlocks.BLOCKS.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);
        eventBus.addListener(this::buildCreativeTab);
        eventBus.addListener(this::generateData);
    }

    private void buildCreativeTab(BuildCreativeModeTabContentsEvent event) {
        if(event.getTab() == NATURES_END.get()) {
            NaturesBlocks.BLOCKS.getEntries().forEach(event::accept);
        }
    }

    private void generateData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();

        generator.addProvider(event.includeClient(), new NaturesBlockStateProvider(packOutput, fileHelper));
        generator.addProvider(event.includeClient(), new NaturesItemModelProvider(packOutput, fileHelper));

        generator.addProvider(event.includeClient(), new ENLanguageProvider(packOutput));

        NaturesBlockTagsProvider blockTags = new NaturesBlockTagsProvider(packOutput, event.getLookupProvider(), fileHelper);
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), new NaturesItemTagsProvider(packOutput, event.getLookupProvider(), blockTags, fileHelper));

    }
}
