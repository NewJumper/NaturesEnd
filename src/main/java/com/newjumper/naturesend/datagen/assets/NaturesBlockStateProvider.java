package com.newjumper.naturesend.datagen.assets;

import com.newjumper.naturesend.NaturesEnd;
import com.newjumper.naturesend.content.NaturesBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class NaturesBlockStateProvider extends BlockStateProvider {
    public NaturesBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, NaturesEnd.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        logBlock(NaturesBlocks.EVERGREEN_LOG.get());
        axisBlock(NaturesBlocks.EVERGREEN_WOOD.get(), blockLoc(NaturesBlocks.EVERGREEN_LOG), blockLoc(NaturesBlocks.EVERGREEN_LOG));
        logBlock(NaturesBlocks.STRIPPED_EVERGREEN_LOG.get());
        axisBlock(NaturesBlocks.STRIPPED_EVERGREEN_WOOD.get(), blockLoc(NaturesBlocks.STRIPPED_EVERGREEN_LOG), blockLoc(NaturesBlocks.STRIPPED_EVERGREEN_LOG));
        simpleBlock(NaturesBlocks.EVERGREEN_PLANKS.get());
        stairsBlock(NaturesBlocks.EVERGREEN_STAIRS.get(), blockLoc(NaturesBlocks.EVERGREEN_PLANKS));
        slabBlock(NaturesBlocks.EVERGREEN_SLAB.get(), blockLoc(NaturesBlocks.EVERGREEN_PLANKS), blockLoc(NaturesBlocks.EVERGREEN_PLANKS));
        fenceBlock(NaturesBlocks.EVERGREEN_FENCE, blockLoc(NaturesBlocks.EVERGREEN_PLANKS));
        fenceGateBlock(NaturesBlocks.EVERGREEN_FENCE_GATE.get(), blockLoc(NaturesBlocks.EVERGREEN_PLANKS));
        doorBlock(NaturesBlocks.EVERGREEN_DOOR.get(), blockLoc(NaturesBlocks.EVERGREEN_DOOR, "bottom"), blockLoc(NaturesBlocks.EVERGREEN_DOOR, "top"));
        trapdoorBlock(NaturesBlocks.EVERGREEN_TRAPDOOR.get(), blockLoc(NaturesBlocks.EVERGREEN_TRAPDOOR), true);
        pressurePlateBlock(NaturesBlocks.EVERGREEN_PRESSURE_PLATE.get(), blockLoc(NaturesBlocks.EVERGREEN_PLANKS));
        buttonBlock(NaturesBlocks.EVERGREEN_BUTTON, blockLoc(NaturesBlocks.EVERGREEN_PLANKS));
        simpleBlock(NaturesBlocks.EVERGREEN_LEAVES.get(), models().cubeAll(NaturesBlocks.EVERGREEN_LEAVES.getId().getPath(), blockLoc(NaturesBlocks.EVERGREEN_LEAVES)).renderType("cutout"));
        simpleBlock(NaturesBlocks.EVERGREEN_SAPLING.get(), models().cross(NaturesBlocks.EVERGREEN_SAPLING.getId().getPath(), blockLoc(NaturesBlocks.EVERGREEN_SAPLING)).renderType("cutout"));
        signBlock(NaturesBlocks.EVERGREEN_SIGN.get(), NaturesBlocks.EVERGREEN_WALL_SIGN.get(), blockLoc(NaturesBlocks.EVERGREEN_PLANKS));
        simpleBlock(NaturesBlocks.EVERGREEN_HANGING_SIGN.get(), models().sign(NaturesBlocks.EVERGREEN_HANGING_SIGN.getId().getPath(), blockLoc(NaturesBlocks.STRIPPED_EVERGREEN_LOG)));
        simpleBlock(NaturesBlocks.EVERGREEN_WALL_HANGING_SIGN.get(), models().sign(NaturesBlocks.EVERGREEN_HANGING_SIGN.getId().getPath(), blockLoc(NaturesBlocks.STRIPPED_EVERGREEN_LOG)));

        logBlock(NaturesBlocks.SHADOW_LOG.get());
        axisBlock(NaturesBlocks.SHADOW_WOOD.get(), blockLoc(NaturesBlocks.SHADOW_LOG), blockLoc(NaturesBlocks.SHADOW_LOG));
        logBlock(NaturesBlocks.STRIPPED_SHADOW_LOG.get());
        axisBlock(NaturesBlocks.STRIPPED_SHADOW_WOOD.get(), blockLoc(NaturesBlocks.STRIPPED_SHADOW_LOG), blockLoc(NaturesBlocks.STRIPPED_SHADOW_LOG));
        simpleBlock(NaturesBlocks.SHADOW_PLANKS.get());
        stairsBlock(NaturesBlocks.SHADOW_STAIRS.get(), blockLoc(NaturesBlocks.SHADOW_PLANKS));
        slabBlock(NaturesBlocks.SHADOW_SLAB.get(), blockLoc(NaturesBlocks.SHADOW_PLANKS), blockLoc(NaturesBlocks.SHADOW_PLANKS));
        fenceBlock(NaturesBlocks.SHADOW_FENCE, blockLoc(NaturesBlocks.SHADOW_PLANKS));
        fenceGateBlock(NaturesBlocks.SHADOW_FENCE_GATE.get(), blockLoc(NaturesBlocks.SHADOW_PLANKS));
        doorBlock(NaturesBlocks.SHADOW_DOOR.get(), blockLoc(NaturesBlocks.SHADOW_DOOR, "bottom"), blockLoc(NaturesBlocks.SHADOW_DOOR, "top"));
        trapdoorBlock(NaturesBlocks.SHADOW_TRAPDOOR.get(), blockLoc(NaturesBlocks.SHADOW_TRAPDOOR), true);
        pressurePlateBlock(NaturesBlocks.SHADOW_PRESSURE_PLATE.get(), blockLoc(NaturesBlocks.SHADOW_PLANKS));
        buttonBlock(NaturesBlocks.SHADOW_BUTTON, blockLoc(NaturesBlocks.SHADOW_PLANKS));
        signBlock(NaturesBlocks.SHADOW_SIGN.get(), NaturesBlocks.SHADOW_WALL_SIGN.get(), blockLoc(NaturesBlocks.SHADOW_PLANKS));
        simpleBlock(NaturesBlocks.SHADOW_HANGING_SIGN.get(), models().sign(NaturesBlocks.SHADOW_HANGING_SIGN.getId().getPath(), blockLoc(NaturesBlocks.STRIPPED_SHADOW_LOG)));
        simpleBlock(NaturesBlocks.SHADOW_WALL_HANGING_SIGN.get(), models().sign(NaturesBlocks.SHADOW_HANGING_SIGN.getId().getPath(), blockLoc(NaturesBlocks.STRIPPED_SHADOW_LOG)));

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
        simpleBlock(NaturesBlocks.WILLOW_HANGING_SIGN.get(), models().sign(NaturesBlocks.WILLOW_HANGING_SIGN.getId().getPath(), blockLoc(NaturesBlocks.STRIPPED_WILLOW_LOG)));
        simpleBlock(NaturesBlocks.WILLOW_WALL_HANGING_SIGN.get(), models().sign(NaturesBlocks.WILLOW_HANGING_SIGN.getId().getPath(), blockLoc(NaturesBlocks.STRIPPED_WILLOW_LOG)));

        simpleBlock(NaturesBlocks.SHALE.get());
        simpleBlock(NaturesBlocks.ERODED_SHALE.get());
        simpleBlock(NaturesBlocks.CHLORITE_SHALE.get());
        simpleBlock(NaturesBlocks.FERROUS_SHALE.get());
        simpleBlock(NaturesBlocks.PURPLE_SHALE.get());
        simpleBlock(NaturesBlocks.RED_SHALE.get());
        simpleBlock(NaturesBlocks.SALT_BLOCK.get());

        simpleBlock(NaturesBlocks.SHALE_BRICKS.get());
        stairsBlock(NaturesBlocks.SHALE_BRICK_STAIRS.get(), blockLoc(NaturesBlocks.SHALE_BRICKS));
        slabBlock(NaturesBlocks.SHALE_BRICK_SLAB.get(), blockLoc(NaturesBlocks.SHALE_BRICKS), blockLoc(NaturesBlocks.SHALE_BRICKS));
        wallBlock(NaturesBlocks.SHALE_BRICK_WALL, blockLoc(NaturesBlocks.SHALE_BRICKS));
    }

    private void fenceBlock(RegistryObject<FenceBlock> block, ResourceLocation texture) {
        super.fenceBlock(block.get(), texture);
        models().fenceInventory(block.getId().getPath() + "_inventory", texture);
    }

    public void buttonBlock(RegistryObject<ButtonBlock> block, ResourceLocation texture) {
        super.buttonBlock(block.get(), texture);
        models().buttonInventory(block.getId().getPath() + "_inventory", texture);
    }

    public void wallBlock(RegistryObject<WallBlock> block, ResourceLocation texture) {
        super.wallBlock(block.get(), texture);
        models().wallInventory(block.getId().getPath() + "_inventory", texture);
    }

    private ResourceLocation blockLoc(RegistryObject<? extends Block> block) {
        return super.modLoc("block/" + block.getId().getPath());
    }

    public ResourceLocation blockLoc(RegistryObject<? extends Block> block, String suffix) {
        return super.modLoc("block/" + block.getId().getPath() + "_" + suffix);
    }
}
