package com.newjumper.naturesend.content.blocks;

import com.newjumper.naturesend.content.NaturesBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

public class RotatedFlammableBlock extends RotatedPillarBlock {
    private final int FLAMMABILITY;
    private final int SPREAD;

    public RotatedFlammableBlock(Properties pProperties, int flammability, int spread) {
        super(pProperties);
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

    @Override
    public BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        if(toolAction == ToolActions.AXE_STRIP) {
            if(state.is(NaturesBlocks.WILLOW_LOG.get())) return NaturesBlocks.STRIPPED_WILLOW_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            if(state.is(NaturesBlocks.WILLOW_WOOD.get())) return NaturesBlocks.STRIPPED_WILLOW_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
        }

        return super.getToolModifiedState(state, context, toolAction, simulate);
    }
}
