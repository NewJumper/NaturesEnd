package com.newjumper.naturesend.datagen.data;

import com.newjumper.naturesend.NaturesEnd;
import com.newjumper.naturesend.content.NaturesBlocks;
import com.newjumper.naturesend.content.NaturesTags;
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

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_AXE).addTag(NaturesTags.Blocks.WILLOW_LOGS).add(NaturesBlocks.WILLOW_PLANKS.get(), NaturesBlocks.WILLOW_STAIRS.get(), NaturesBlocks.WILLOW_SLAB.get(), NaturesBlocks.WILLOW_FENCE.get(), NaturesBlocks.WILLOW_FENCE_GATE.get(), NaturesBlocks.WILLOW_DOOR.get(), NaturesBlocks.WILLOW_TRAPDOOR.get(), NaturesBlocks.WILLOW_PRESSURE_PLATE.get(), NaturesBlocks.WILLOW_BUTTON.get());
        tag(BlockTags.LOGS_THAT_BURN).addTag(NaturesTags.Blocks.WILLOW_LOGS);
        tag(BlockTags.PLANKS).add(NaturesBlocks.WILLOW_PLANKS.get());
        tag(BlockTags.WOODEN_STAIRS).add(NaturesBlocks.WILLOW_STAIRS.get());
        tag(BlockTags.WOODEN_SLABS).add(NaturesBlocks.WILLOW_SLAB.get());
        tag(BlockTags.WOODEN_FENCES).add(NaturesBlocks.WILLOW_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(NaturesBlocks.WILLOW_FENCE_GATE.get());
        tag(BlockTags.WOODEN_DOORS).add(NaturesBlocks.WILLOW_DOOR.get());
        tag(BlockTags.WOODEN_TRAPDOORS).add(NaturesBlocks.WILLOW_TRAPDOOR.get());
        tag(BlockTags.WOODEN_PRESSURE_PLATES).add(NaturesBlocks.WILLOW_PRESSURE_PLATE.get());
        tag(BlockTags.WOODEN_BUTTONS).add(NaturesBlocks.WILLOW_BUTTON.get());

        tag(NaturesTags.Blocks.WILLOW_LOGS).add(NaturesBlocks.WILLOW_LOG.get(), NaturesBlocks.WILLOW_WOOD.get(), NaturesBlocks.STRIPPED_WILLOW_LOG.get(), NaturesBlocks.STRIPPED_WILLOW_WOOD.get());
    }
}
