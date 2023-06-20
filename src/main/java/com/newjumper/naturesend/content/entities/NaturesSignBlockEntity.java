package com.newjumper.naturesend.content.entities;

import com.newjumper.naturesend.content.NaturesBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class NaturesSignBlockEntity extends SignBlockEntity {
    public NaturesSignBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(pPos, pBlockState);
    }

    @Override
    public @NotNull BlockEntityType<?> getType() {
        return NaturesBlockEntities.NATURES_SIGNS.get();
    }
}
