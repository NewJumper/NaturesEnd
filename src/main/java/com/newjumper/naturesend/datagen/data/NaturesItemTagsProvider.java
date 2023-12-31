package com.newjumper.naturesend.datagen.data;

import com.newjumper.naturesend.NaturesEnd;
import com.newjumper.naturesend.content.NaturesItems;
import com.newjumper.naturesend.util.NaturesTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class NaturesItemTagsProvider extends ItemTagsProvider {
    public NaturesItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookup, TagsProvider<Block> blockTags, ExistingFileHelper exFileHelper) {
        super(output, lookup, blockTags.contentsGetter(), NaturesEnd.MOD_ID, exFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {
        copy(BlockTags.LOGS_THAT_BURN, ItemTags.LOGS_THAT_BURN);
        copy(BlockTags.PLANKS, ItemTags.PLANKS);
        copy(BlockTags.WOODEN_STAIRS, ItemTags.WOODEN_STAIRS);
        copy(BlockTags.WOODEN_SLABS, ItemTags.WOODEN_SLABS);
        copy(BlockTags.WOODEN_FENCES, ItemTags.WOODEN_FENCES);
        copy(BlockTags.FENCE_GATES, ItemTags.FENCE_GATES);
        copy(BlockTags.WOODEN_DOORS, ItemTags.WOODEN_DOORS);
        copy(BlockTags.WOODEN_TRAPDOORS, ItemTags.WOODEN_TRAPDOORS);
        copy(BlockTags.WOODEN_PRESSURE_PLATES, ItemTags.WOODEN_PRESSURE_PLATES);
        copy(BlockTags.WOODEN_BUTTONS, ItemTags.WOODEN_BUTTONS);
        copy(BlockTags.LEAVES, ItemTags.LEAVES);
        copy(BlockTags.SAPLINGS, ItemTags.SAPLINGS);
        copy(BlockTags.STANDING_SIGNS, ItemTags.SIGNS);
        copy(BlockTags.CEILING_HANGING_SIGNS, ItemTags.HANGING_SIGNS);
        copy(BlockTags.STAIRS, ItemTags.STAIRS);
        copy(BlockTags.SLABS, ItemTags.SLABS);
        copy(BlockTags.WALLS, ItemTags.WALLS);

        copy(NaturesTags.Blocks.EVERGREEN_LOGS, NaturesTags.Items.EVERGREEN_LOGS);
        copy(NaturesTags.Blocks.SHADOW_LOGS, NaturesTags.Items.SHADOW_LOGS);
        copy(NaturesTags.Blocks.WILLOW_LOGS, NaturesTags.Items.WILLOW_LOGS);

        tag(ItemTags.BOATS).add(NaturesItems.EVERGREEN_BOAT.get(), NaturesItems.SHADOW_BOAT.get(), NaturesItems.WILLOW_BOAT.get());
        tag(ItemTags.CHEST_BOATS).add(NaturesItems.EVERGREEN_CHEST_BOAT.get(), NaturesItems.SHADOW_CHEST_BOAT.get(), NaturesItems.WILLOW_CHEST_BOAT.get());

        tag(NaturesTags.Items.SALTS).add(NaturesItems.SALT.get());
    }
}
