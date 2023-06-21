package com.newjumper.naturesend.world;

import com.newjumper.naturesend.NaturesEnd;
import com.newjumper.naturesend.content.NaturesBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.MegaPineFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

public class NaturesConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREE_EVERGREEN = registerKey("evergreen");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREE_EVERGREEN_SHORT = registerKey("evergreen_short");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        FeatureUtils.register(context, TREE_EVERGREEN, Feature.TREE, createEvergreen(17, 4, 6, 17, 21).build());
        FeatureUtils.register(context, TREE_EVERGREEN_SHORT, Feature.TREE, createEvergreen(9, 3, 5, 9, 12).build());
    }

    private static TreeConfiguration.TreeConfigurationBuilder createEvergreen(int trunkHeight, int heightRandA, int heightRandB, int foliageHeightMin, int foliageHeightMax) {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(NaturesBlocks.EVERGREEN_LOG.get()), new StraightTrunkPlacer(trunkHeight, heightRandA, heightRandB), BlockStateProvider.simple(NaturesBlocks.EVERGREEN_LEAVES.get()), new MegaPineFoliagePlacer(ConstantInt.of(1), ConstantInt.of(0), UniformInt.of(foliageHeightMin, foliageHeightMax)), new TwoLayersFeatureSize(0, 0, 0)).ignoreVines();
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(NaturesEnd.MOD_ID, name));
    }
}
