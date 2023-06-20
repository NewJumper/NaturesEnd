package com.newjumper.naturesend.content;

import com.newjumper.naturesend.NaturesEnd;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class NaturesTags {
    public static class Blocks {
        public static final TagKey<Block> EVERGREEN_LOGS = tag("evergreen_logs");
        public static final TagKey<Block> WILLOW_LOGS = tag("willow_logs");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(NaturesEnd.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> EVERGREEN_LOGS = tag("evergreen_logs");
        public static final TagKey<Item> WILLOW_LOGS = tag("willow_logs");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(NaturesEnd.MOD_ID, name));
        }
    }
}
