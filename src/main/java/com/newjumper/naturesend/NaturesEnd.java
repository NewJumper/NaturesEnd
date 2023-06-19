package com.newjumper.naturesend;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@Mod(NaturesEnd.MOD_ID)
public class NaturesEnd {
    public static final String MOD_ID = "naturesend";
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);
    public static final RegistryObject<CreativeModeTab> NATURES_END = CREATIVE_MODE_TABS.register("natures_end", () -> CreativeModeTab.builder().icon(Items.OAK_SAPLING::getDefaultInstance).build());

    public NaturesEnd() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        CREATIVE_MODE_TABS.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);
        eventBus.addListener(this::buildCreativeTab);
    }

    private void buildCreativeTab(BuildCreativeModeTabContentsEvent event) {
        if(event.getTab() == NATURES_END.get()) {
            event.accept(ItemStack.EMPTY);
        }
    }
}
