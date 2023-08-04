package com.newjumper.naturesend.world.structures;

import com.newjumper.naturesend.NaturesEnd;
import com.newjumper.naturesend.util.NaturesTags;
import com.newjumper.naturesend.world.structures.village.JungleVillagePools;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.heightproviders.ConstantHeight;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;

import java.util.Map;

public class NaturesStructures {
    public static final ResourceKey<Structure> VILLAGE_JUNGLE = createKey("village_jungle");

    public static void bootstrap(BootstapContext<Structure> context) {
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        HolderGetter<StructureTemplatePool> pools = context.lookup(Registries.TEMPLATE_POOL);

        context.register(VILLAGE_JUNGLE, new JigsawStructure(structure(biomes.getOrThrow(NaturesTags.Biomes.HAS_VILLAGE_JUNGLE)), pools.getOrThrow(JungleVillagePools.START), 6, ConstantHeight.of(VerticalAnchor.absolute(0)), true, Heightmap.Types.WORLD_SURFACE_WG));
    }

    private static Structure.StructureSettings structure(HolderSet<Biome> biomes) {
        return new Structure.StructureSettings(biomes, Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN);
    }

    private static ResourceKey<Structure> createKey(String name) {
        return ResourceKey.create(Registries.STRUCTURE, new ResourceLocation(NaturesEnd.MOD_ID, name));
    }
}
