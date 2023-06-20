package com.newjumper.naturesend.content.blocks;

import com.newjumper.naturesend.content.entities.NaturesSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class NaturesWallSignBlock extends WallSignBlock {
    public NaturesWallSignBlock(Properties pProperties, WoodType pType) {
        super(pProperties, pType);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new NaturesSignBlockEntity(pPos, pState);
    }
}
