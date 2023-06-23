package com.newjumper.naturesend.datagen.data;

import com.newjumper.naturesend.NaturesEnd;
import com.newjumper.naturesend.content.NaturesBlocks;
import com.newjumper.naturesend.util.NaturesTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class NaturesBlockTagsProvider extends BlockTagsProvider {
    public NaturesBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper exFileHelper) {
        super(output, lookupProvider, NaturesEnd.MOD_ID, exFileHelper);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_AXE).addTags(NaturesTags.Blocks.EVERGREEN_LOGS, NaturesTags.Blocks.WILLOW_LOGS)
                .add(NaturesBlocks.EVERGREEN_PLANKS.get(), NaturesBlocks.EVERGREEN_STAIRS.get(), NaturesBlocks.EVERGREEN_SLAB.get(), NaturesBlocks.EVERGREEN_FENCE.get(), NaturesBlocks.EVERGREEN_FENCE_GATE.get(), NaturesBlocks.EVERGREEN_DOOR.get(), NaturesBlocks.EVERGREEN_TRAPDOOR.get(), NaturesBlocks.EVERGREEN_PRESSURE_PLATE.get(), NaturesBlocks.EVERGREEN_BUTTON.get(),
                NaturesBlocks.WILLOW_PLANKS.get(), NaturesBlocks.WILLOW_STAIRS.get(), NaturesBlocks.WILLOW_SLAB.get(), NaturesBlocks.WILLOW_FENCE.get(), NaturesBlocks.WILLOW_FENCE_GATE.get(), NaturesBlocks.WILLOW_DOOR.get(), NaturesBlocks.WILLOW_TRAPDOOR.get(), NaturesBlocks.WILLOW_PRESSURE_PLATE.get(), NaturesBlocks.WILLOW_BUTTON.get());
        tag(BlockTags.MINEABLE_WITH_HOE).add(NaturesBlocks.EVERGREEN_LEAVES.get(), NaturesBlocks.WILLOW_LEAVES.get());
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(NaturesBlocks.SHALE.get(), NaturesBlocks.ERODED_SHALE.get(), NaturesBlocks.CHLORITE_SHALE.get(), NaturesBlocks.RED_SHALE.get(), NaturesBlocks.SHALE_BRICKS.get(), NaturesBlocks.SHALE_BRICK_STAIRS.get(), NaturesBlocks.SHALE_BRICK_SLAB.get(), NaturesBlocks.SHALE_BRICK_WALL.get());
        tag(BlockTags.MINEABLE_WITH_SHOVEL).add(NaturesBlocks.SALT_BLOCK.get());
        tag(BlockTags.LOGS_THAT_BURN).addTags(NaturesTags.Blocks.EVERGREEN_LOGS, NaturesTags.Blocks.WILLOW_LOGS);
        tag(BlockTags.PLANKS).add(NaturesBlocks.EVERGREEN_PLANKS.get(), NaturesBlocks.WILLOW_PLANKS.get());
        tag(BlockTags.WOODEN_STAIRS).add(NaturesBlocks.EVERGREEN_STAIRS.get(), NaturesBlocks.WILLOW_STAIRS.get());
        tag(BlockTags.WOODEN_SLABS).add(NaturesBlocks.EVERGREEN_SLAB.get(), NaturesBlocks.WILLOW_SLAB.get());
        tag(BlockTags.WOODEN_FENCES).add(NaturesBlocks.EVERGREEN_FENCE.get(), NaturesBlocks.WILLOW_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(NaturesBlocks.EVERGREEN_FENCE_GATE.get(), NaturesBlocks.WILLOW_FENCE_GATE.get());
        tag(BlockTags.WOODEN_DOORS).add(NaturesBlocks.EVERGREEN_DOOR.get(), NaturesBlocks.WILLOW_DOOR.get());
        tag(BlockTags.WOODEN_TRAPDOORS).add(NaturesBlocks.EVERGREEN_TRAPDOOR.get(), NaturesBlocks.WILLOW_TRAPDOOR.get());
        tag(BlockTags.WOODEN_PRESSURE_PLATES).add(NaturesBlocks.EVERGREEN_PRESSURE_PLATE.get(), NaturesBlocks.WILLOW_PRESSURE_PLATE.get());
        tag(BlockTags.WOODEN_BUTTONS).add(NaturesBlocks.EVERGREEN_BUTTON.get(), NaturesBlocks.WILLOW_BUTTON.get());
        tag(BlockTags.LEAVES).add(NaturesBlocks.EVERGREEN_LEAVES.get(), NaturesBlocks.WILLOW_LEAVES.get());
        tag(BlockTags.SAPLINGS).add(NaturesBlocks.EVERGREEN_SAPLING.get(), NaturesBlocks.WILLOW_SAPLING.get());
        tag(BlockTags.STANDING_SIGNS).add(NaturesBlocks.EVERGREEN_SIGN.get(), NaturesBlocks.WILLOW_SIGN.get());
        tag(BlockTags.WALL_SIGNS).add(NaturesBlocks.EVERGREEN_WALL_SIGN.get(), NaturesBlocks.WILLOW_WALL_SIGN.get());
        tag(BlockTags.CEILING_HANGING_SIGNS).add(NaturesBlocks.EVERGREEN_HANGING_SIGN.get(), NaturesBlocks.WILLOW_HANGING_SIGN.get());
        tag(BlockTags.WALL_HANGING_SIGNS).add(NaturesBlocks.EVERGREEN_WALL_HANGING_SIGN.get(), NaturesBlocks.WILLOW_WALL_HANGING_SIGN.get());
        tag(BlockTags.STAIRS).add(NaturesBlocks.SHALE_BRICK_STAIRS.get());
        tag(BlockTags.SLABS).add(NaturesBlocks.SHALE_BRICK_SLAB.get());
        tag(BlockTags.WALLS).add(NaturesBlocks.SHALE_BRICK_WALL.get());

        tag(NaturesTags.Blocks.EVERGREEN_LOGS).add(NaturesBlocks.EVERGREEN_LOG.get(), NaturesBlocks.EVERGREEN_WOOD.get(), NaturesBlocks.STRIPPED_EVERGREEN_LOG.get(), NaturesBlocks.STRIPPED_EVERGREEN_WOOD.get());
        tag(NaturesTags.Blocks.WILLOW_LOGS).add(NaturesBlocks.WILLOW_LOG.get(), NaturesBlocks.WILLOW_WOOD.get(), NaturesBlocks.STRIPPED_WILLOW_LOG.get(), NaturesBlocks.STRIPPED_WILLOW_WOOD.get());
    }
}
