package com.newjumper.naturesend.world.structures;

import com.newjumper.naturesend.NaturesEnd;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;

public class NaturesStructureSets {
    public static final  ResourceKey<StructureSet> VILLAGES = createKey("villages");

    public static void bootstrap(BootstapContext<StructureSet> context) {
        HolderGetter<Structure> structures = context.lookup(Registries.STRUCTURE);
        context.register(VILLAGES, new StructureSet(structures.getOrThrow(NaturesStructures.VILLAGE_JUNGLE), new RandomSpreadStructurePlacement(24, 8, RandomSpreadType.LINEAR, 26085576)));
    }

    public static ResourceKey<StructureSet> createKey(String name) {
        return ResourceKey.create(Registries.STRUCTURE_SET, new ResourceLocation(NaturesEnd.MOD_ID, name));
    }
}
