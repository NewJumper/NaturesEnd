package com.newjumper.naturesend.datagen.data;

import com.newjumper.naturesend.NaturesEnd;
import com.newjumper.naturesend.util.NaturesTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class NaturesBiomeTagsProvider extends BiomeTagsProvider {
    public NaturesBiomeTagsProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pProvider, ExistingFileHelper existingFileHelper) {
        super(pOutput, pProvider, NaturesEnd.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {
        tag(NaturesTags.Biomes.HAS_VILLAGE_JUNGLE).add(Biomes.JUNGLE, Biomes.BAMBOO_JUNGLE);
    }
}
