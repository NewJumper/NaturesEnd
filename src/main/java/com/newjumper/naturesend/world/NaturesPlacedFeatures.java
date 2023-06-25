package com.newjumper.naturesend.world;

import com.newjumper.naturesend.NaturesEnd;
import com.newjumper.naturesend.content.NaturesBlocks;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class NaturesPlacedFeatures {
    public static final ResourceKey<PlacedFeature> EVERGREEN = createKey("evergreen");
    public static final ResourceKey<PlacedFeature> EVERGREEN_SHORT = createKey("evergreen_short");
    public static final ResourceKey<PlacedFeature> WILLOW = createKey("willow");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> feature = context.lookup(Registries.CONFIGURED_FEATURE);
        PlacementUtils.register(context, EVERGREEN, feature.getOrThrow(NaturesConfiguredFeatures.TREE_EVERGREEN), PlacementUtils.filteredByBlockSurvival(NaturesBlocks.EVERGREEN_SAPLING.get()));
        PlacementUtils.register(context, EVERGREEN_SHORT, feature.getOrThrow(NaturesConfiguredFeatures.TREE_EVERGREEN_SHORT), PlacementUtils.filteredByBlockSurvival(NaturesBlocks.EVERGREEN_SAPLING.get()));
        PlacementUtils.register(context, WILLOW, feature.getOrThrow(NaturesConfiguredFeatures.TREE_WILLOW), PlacementUtils.filteredByBlockSurvival(NaturesBlocks.WILLOW_SAPLING.get()));
    }

    private static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(NaturesEnd.MOD_ID, name));
    }
}
