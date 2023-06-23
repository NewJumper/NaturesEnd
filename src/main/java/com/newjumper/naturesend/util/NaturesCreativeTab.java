package com.newjumper.naturesend.util;

import com.newjumper.naturesend.NaturesEnd;
import com.newjumper.naturesend.content.NaturesBlocks;
import com.newjumper.naturesend.content.NaturesItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class NaturesCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NaturesEnd.MOD_ID);
    public static final RegistryObject<CreativeModeTab> NATURES_END = CREATIVE_MODE_TABS.register("natures_end", () -> CreativeModeTab.builder().title(Component.translatable("itemGroup." + NaturesEnd.MOD_ID)).icon(() -> new ItemStack(NaturesBlocks.WILLOW_LOG.get())).build());

    public static void buildCreativeTab(BuildCreativeModeTabContentsEvent event) {
        if(event.getTab() == NATURES_END.get()) {
            event.accept(NaturesBlocks.EVERGREEN_LOG);
            event.accept(NaturesBlocks.EVERGREEN_WOOD);
            event.accept(NaturesBlocks.STRIPPED_EVERGREEN_LOG);
            event.accept(NaturesBlocks.STRIPPED_EVERGREEN_WOOD);
            event.accept(NaturesBlocks.EVERGREEN_PLANKS);
            event.accept(NaturesBlocks.EVERGREEN_STAIRS);
            event.accept(NaturesBlocks.EVERGREEN_SLAB);
            event.accept(NaturesBlocks.EVERGREEN_FENCE);
            event.accept(NaturesBlocks.EVERGREEN_FENCE_GATE);
            event.accept(NaturesBlocks.EVERGREEN_DOOR);
            event.accept(NaturesBlocks.EVERGREEN_TRAPDOOR);
            event.accept(NaturesBlocks.EVERGREEN_PRESSURE_PLATE);
            event.accept(NaturesBlocks.EVERGREEN_BUTTON);
            event.accept(NaturesBlocks.EVERGREEN_LEAVES);
            event.accept(NaturesBlocks.EVERGREEN_SAPLING);
            event.accept(NaturesItems.EVERGREEN_SIGN);
            event.accept(NaturesItems.EVERGREEN_HANGING_SIGN);
            event.accept(NaturesItems.EVERGREEN_BOAT);
            event.accept(NaturesItems.EVERGREEN_CHEST_BOAT);

            event.accept(NaturesBlocks.WILLOW_LOG);
            event.accept(NaturesBlocks.WILLOW_WOOD);
            event.accept(NaturesBlocks.STRIPPED_WILLOW_LOG);
            event.accept(NaturesBlocks.STRIPPED_WILLOW_WOOD);
            event.accept(NaturesBlocks.WILLOW_PLANKS);
            event.accept(NaturesBlocks.WILLOW_STAIRS);
            event.accept(NaturesBlocks.WILLOW_SLAB);
            event.accept(NaturesBlocks.WILLOW_FENCE);
            event.accept(NaturesBlocks.WILLOW_FENCE_GATE);
            event.accept(NaturesBlocks.WILLOW_DOOR);
            event.accept(NaturesBlocks.WILLOW_TRAPDOOR);
            event.accept(NaturesBlocks.WILLOW_PRESSURE_PLATE);
            event.accept(NaturesBlocks.WILLOW_BUTTON);
            event.accept(NaturesBlocks.WILLOW_LEAVES);
            event.accept(NaturesBlocks.WILLOW_SAPLING);
            event.accept(NaturesItems.WILLOW_SIGN);
            event.accept(NaturesItems.WILLOW_HANGING_SIGN);
            event.accept(NaturesItems.WILLOW_BOAT);
            event.accept(NaturesItems.WILLOW_CHEST_BOAT);

            event.accept(NaturesBlocks.SHALE);
            event.accept(NaturesBlocks.ERODED_SHALE);
            event.accept(NaturesBlocks.CHLORITE_SHALE);
            event.accept(NaturesBlocks.FERROUS_SHALE);
            event.accept(NaturesBlocks.PURPLE_SHALE);
            event.accept(NaturesBlocks.RED_SHALE);
            event.accept(NaturesBlocks.SALT_BLOCK);
            event.accept(NaturesBlocks.SHALE_BRICKS);
            event.accept(NaturesBlocks.SHALE_BRICK_STAIRS);
            event.accept(NaturesBlocks.SHALE_BRICK_SLAB);
            event.accept(NaturesBlocks.SHALE_BRICK_WALL);

            event.accept(NaturesItems.SHALE_PLATE);
            event.accept(NaturesItems.SALT);
        }
    }
}
