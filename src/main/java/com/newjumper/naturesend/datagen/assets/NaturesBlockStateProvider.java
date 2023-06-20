package com.newjumper.naturesend.datagen.assets;

import com.newjumper.naturesend.NaturesEnd;
import com.newjumper.naturesend.content.NaturesBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class NaturesBlockStateProvider extends BlockStateProvider {
    public NaturesBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, NaturesEnd.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        logBlock(NaturesBlocks.WILLOW_LOG.get());
        axisBlock(NaturesBlocks.WILLOW_WOOD.get(), blockLoc(NaturesBlocks.WILLOW_LOG), blockLoc(NaturesBlocks.WILLOW_LOG));
        logBlock(NaturesBlocks.STRIPPED_WILLOW_LOG.get());
        axisBlock(NaturesBlocks.STRIPPED_WILLOW_WOOD.get(), blockLoc(NaturesBlocks.STRIPPED_WILLOW_LOG), blockLoc(NaturesBlocks.STRIPPED_WILLOW_LOG));
        simpleBlock(NaturesBlocks.WILLOW_PLANKS.get());
        stairsBlock(NaturesBlocks.WILLOW_STAIRS.get(), blockLoc(NaturesBlocks.WILLOW_PLANKS));
        slabBlock(NaturesBlocks.WILLOW_SLAB.get(), blockLoc(NaturesBlocks.WILLOW_PLANKS), blockLoc(NaturesBlocks.WILLOW_PLANKS));
        fenceBlock(NaturesBlocks.WILLOW_FENCE, blockLoc(NaturesBlocks.WILLOW_PLANKS));
        fenceGateBlock(NaturesBlocks.WILLOW_FENCE_GATE.get(), blockLoc(NaturesBlocks.WILLOW_PLANKS));
        doorBlockWithRenderType(NaturesBlocks.WILLOW_DOOR.get(), blockLoc(NaturesBlocks.WILLOW_DOOR, "bottom"), blockLoc(NaturesBlocks.WILLOW_DOOR, "top"), "translucent");
        trapdoorBlockWithRenderType(NaturesBlocks.WILLOW_TRAPDOOR.get(), blockLoc(NaturesBlocks.WILLOW_TRAPDOOR), true, "translucent");
        pressurePlateBlock(NaturesBlocks.WILLOW_PRESSURE_PLATE.get(), blockLoc(NaturesBlocks.WILLOW_PLANKS));
        buttonBlock(NaturesBlocks.WILLOW_BUTTON, blockLoc(NaturesBlocks.WILLOW_PLANKS));
        simpleBlock(NaturesBlocks.WILLOW_LEAVES.get(), models().cubeAll(NaturesBlocks.WILLOW_LEAVES.getId().getPath(), blockLoc(NaturesBlocks.WILLOW_LEAVES)).renderType("cutout"));
        simpleBlock(NaturesBlocks.WILLOW_SAPLING.get(), models().cross(NaturesBlocks.WILLOW_SAPLING.getId().getPath(), blockLoc(NaturesBlocks.WILLOW_SAPLING)).renderType("cutout"));
        signBlock(NaturesBlocks.WILLOW_SIGN.get(), NaturesBlocks.WILLOW_WALL_SIGN.get(), blockLoc(NaturesBlocks.WILLOW_PLANKS));
    }

    private ResourceLocation blockLoc(RegistryObject<? extends Block> block) {
        return super.modLoc("block/" + block.getId().getPath());
    }

    public ResourceLocation blockLoc(RegistryObject<? extends Block> block, String suffix) {
        return super.modLoc("block/" + block.getId().getPath() + "_" + suffix);
    }

    private void fenceBlock(RegistryObject<FenceBlock> block, ResourceLocation texture) {
        super.fenceBlock(block.get(), texture);
        models().fenceInventory(block.getId().getPath() + "_inventory", texture);
    }

    public void buttonBlock(RegistryObject<ButtonBlock> block, ResourceLocation texture) {
        super.buttonBlock(block.get(), texture);
        models().buttonInventory(block.getId().getPath() + "_inventory", texture);
    }
}
