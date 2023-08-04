package com.newjumper.naturesend.datagen.data;

import com.newjumper.naturesend.NaturesEnd;
import com.newjumper.naturesend.world.NaturesConfiguredFeatures;
import com.newjumper.naturesend.world.NaturesPlacedFeatures;
import com.newjumper.naturesend.world.structures.NaturesStructureSets;
import com.newjumper.naturesend.world.structures.NaturesStructures;
import com.newjumper.naturesend.world.structures.village.JungleVillagePools;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class NaturesWorldGeneration extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, NaturesConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, NaturesPlacedFeatures::bootstrap)
            .add(Registries.STRUCTURE, NaturesStructures::bootstrap)
            .add(Registries.STRUCTURE_SET, NaturesStructureSets::bootstrap)
            .add(Registries.TEMPLATE_POOL, JungleVillagePools::bootstrap);

    public NaturesWorldGeneration(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(NaturesEnd.MOD_ID));
    }
}
