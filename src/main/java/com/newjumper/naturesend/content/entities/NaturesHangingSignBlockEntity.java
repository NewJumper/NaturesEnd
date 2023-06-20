package com.newjumper.naturesend.content.entities;

import com.newjumper.naturesend.content.NaturesBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.HangingSignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class NaturesHangingSignBlockEntity extends HangingSignBlockEntity {
    public NaturesHangingSignBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(pPos, pBlockState);
    }

    @Override
    public @NotNull BlockEntityType<?> getType() {
        return NaturesBlockEntities.NATURES_HANGING_SIGNS.get();
    }
}
