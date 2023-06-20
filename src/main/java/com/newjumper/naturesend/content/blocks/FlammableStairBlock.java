package com.newjumper.naturesend.content.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public class FlammableStairBlock extends StairBlock {
    private final int FLAMMABILITY;
    private final int SPREAD;

    public FlammableStairBlock(Supplier<BlockState> state, Properties properties, int flammability, int spread) {
        super(state, properties);
        this.FLAMMABILITY = flammability;
        this.SPREAD = spread;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return FLAMMABILITY;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return SPREAD;
    }
}
