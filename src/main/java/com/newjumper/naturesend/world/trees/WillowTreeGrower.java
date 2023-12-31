package com.newjumper.naturesend.world.trees;

import com.newjumper.naturesend.world.NaturesConfiguredFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.NotNull;

public class WillowTreeGrower extends AbstractTreeGrower {
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(@NotNull RandomSource pRandom, boolean pHasFlowers) {
        return NaturesConfiguredFeatures.TREE_WILLOW;
    }
}
