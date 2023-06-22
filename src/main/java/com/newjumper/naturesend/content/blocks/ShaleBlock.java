package com.newjumper.naturesend.content.blocks;

import com.newjumper.naturesend.content.NaturesBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

@SuppressWarnings({"deprecation", "NullableProblems"})
public class ShaleBlock extends Block {
    public ShaleBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        List<BlockState> surroundingBlocks = List.of(pLevel.getBlockState(pPos.above()), pLevel.getBlockState(pPos.below()), pLevel.getBlockState(pPos.north()), pLevel.getBlockState(pPos.east()), pLevel.getBlockState(pPos.south()), pLevel.getBlockState(pPos.west()));
        int count = 0;
        for(BlockState state : surroundingBlocks) {
            if(state.is(NaturesBlocks.SALT_BLOCK.get())) count++;
        }

        if((count == 1 && pRandom.nextFloat() < 0.01f) || (count == 2 && pRandom.nextFloat() < 0.03f) || (count == 3 && pRandom.nextFloat() < 0.06f) || (count > 3 && pRandom.nextFloat() < 0.1f)) {
            pLevel.setBlock(pPos, NaturesBlocks.CHLORITE_SHALE.get().defaultBlockState(), 3);
        }
    }
}
