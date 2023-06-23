package com.newjumper.naturesend.content.blocks;

import com.newjumper.naturesend.content.NaturesBlocks;
import com.newjumper.naturesend.content.NaturesItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

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

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if(pPlayer.getMainHandItem().is(ItemTags.PICKAXES)) {
            int[] drops = { 1, 1, 1, 2, 2, 3 };
            popResource(pLevel, pPos, new ItemStack(NaturesItems.SHALE_PLATE.get(), drops[(int) (Math.random() * 6)]));
            pPlayer.getMainHandItem().hurtAndBreak(1, pPlayer, player -> player.broadcastBreakEvent(pHand));

            if(Math.random() < 0.75) pLevel.setBlock(pPos, NaturesBlocks.ERODED_SHALE.get().defaultBlockState(), 3);
            return InteractionResult.sidedSuccess(pLevel.isClientSide());
        }

        return InteractionResult.PASS;
    }
}
