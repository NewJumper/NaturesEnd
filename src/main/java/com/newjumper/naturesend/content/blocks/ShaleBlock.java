package com.newjumper.naturesend.content.blocks;

import com.newjumper.naturesend.content.NaturesBlocks;
import com.newjumper.naturesend.content.NaturesItems;
import com.newjumper.naturesend.util.NaturesTags;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.Tags;

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
        if(pState.is(NaturesBlocks.SHALE.get())) {
            for(BlockState state : surroundingBlocks) {
                if(state.is(NaturesBlocks.SALT_BLOCK.get())) count++;
            }

            if((count == 1 && pRandom.nextFloat() < 0.01f) || (count == 2 && pRandom.nextFloat() < 0.03f) || (count == 3 && pRandom.nextFloat() < 0.06f) || (count > 3 && pRandom.nextFloat() < 0.1f)) {
                pLevel.setBlock(pPos, NaturesBlocks.CHLORITE_SHALE.get().defaultBlockState(), 3);
            }
        } else if(!pState.is(NaturesBlocks.RED_SHALE.get())) {
            for(BlockState state : surroundingBlocks) {
                if(state.is(Blocks.QUARTZ_BLOCK)) count++;
            }

            int multiplier = pLevel.dimensionTypeId() == BuiltinDimensionTypes.NETHER ? 2 : 1;
            if((count == 1 && pRandom.nextFloat() < 0.01f * multiplier) || (count == 2 && pRandom.nextFloat() < 0.03f * multiplier) || (count == 3 && pRandom.nextFloat() < 0.06f * multiplier) || (count > 3 && pRandom.nextFloat() < 0.1f * multiplier)) {
                if(pState.is(NaturesBlocks.CHLORITE_SHALE.get())) pLevel.setBlock(pPos, NaturesBlocks.FERROUS_SHALE.get().defaultBlockState(), 3);
                else if(pState.is(NaturesBlocks.FERROUS_SHALE.get())) pLevel.setBlock(pPos, NaturesBlocks.PURPLE_SHALE.get().defaultBlockState(), 3);
                else if(pState.is(NaturesBlocks.PURPLE_SHALE.get())) pLevel.setBlock(pPos, NaturesBlocks.RED_SHALE.get().defaultBlockState(), 3);
            }
        }
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if(pState.is(NaturesBlocks.SHALE.get()) && pPlayer.getMainHandItem().getItem() instanceof PickaxeItem) {
            int[] drops = { 1, 1, 1, 2, 2, 3 };
            popResource(pLevel, pPos, new ItemStack(NaturesItems.SHALE_PLATE.get(), drops[(int) (Math.random() * 6)]));
            pPlayer.getMainHandItem().hurtAndBreak(1, pPlayer, player -> player.broadcastBreakEvent(pHand));

            if(Math.random() < 0.6) pLevel.setBlock(pPos, NaturesBlocks.ERODED_SHALE.get().defaultBlockState(), 3);
            return InteractionResult.sidedSuccess(pLevel.isClientSide());
        } else if(!pState.is(NaturesBlocks.CHLORITE_SHALE.get()) && !pState.is(NaturesBlocks.SHALE.get())) {
            if(!pState.is(NaturesBlocks.FERROUS_SHALE.get()) && pPlayer.getMainHandItem().is(Tags.Items.RAW_MATERIALS_IRON)) {
                if(!pPlayer.isCreative()) pPlayer.getMainHandItem().shrink(1);
                if(pState.is(NaturesBlocks.RED_SHALE.get())) pLevel.setBlock(pPos, NaturesBlocks.PURPLE_SHALE.get().defaultBlockState(), 3);
                if(pState.is(NaturesBlocks.PURPLE_SHALE.get())) pLevel.setBlock(pPos, NaturesBlocks.FERROUS_SHALE.get().defaultBlockState(), 3);
                return InteractionResult.sidedSuccess(pLevel.isClientSide());
            }

            if(pState.is(NaturesBlocks.FERROUS_SHALE.get()) && pPlayer.getMainHandItem().is(NaturesTags.Items.SALTS)) {
                if(!pPlayer.isCreative()) pPlayer.getMainHandItem().shrink(1);
                pLevel.setBlock(pPos, NaturesBlocks.CHLORITE_SHALE.get().defaultBlockState(), 3);
                return InteractionResult.sidedSuccess(pLevel.isClientSide());
            }
        }

        return InteractionResult.PASS;
    }
}
