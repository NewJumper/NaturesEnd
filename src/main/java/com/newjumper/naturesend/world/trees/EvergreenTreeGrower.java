package com.newjumper.naturesend.world.trees;

import com.newjumper.naturesend.world.NaturesConfiguredFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class EvergreenTreeGrower extends AbstractTreeGrower {
    @Nullable
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource pRandom, boolean pHasFlowers) {
        return pRandom.nextFloat() < 0.06f ? NaturesConfiguredFeatures.TREE_EVERGREEN_SHORT : NaturesConfiguredFeatures.TREE_EVERGREEN;
    }
}
