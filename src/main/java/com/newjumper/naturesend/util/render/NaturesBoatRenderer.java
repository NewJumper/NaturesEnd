package com.newjumper.naturesend.util.render;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import com.newjumper.naturesend.NaturesEnd;
import com.newjumper.naturesend.content.NaturesBlocks;
import com.newjumper.naturesend.content.entities.NaturesBoat;
import com.newjumper.naturesend.content.entities.NaturesChestBoat;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;

import java.util.Map;

@SuppressWarnings("NullableProblems")
public class NaturesBoatRenderer extends BoatRenderer {
    private final Map<String, Pair<ResourceLocation, ListModel<Boat>>> BOAT_RESOURCES;
    private final boolean HAS_CHEST;

    public NaturesBoatRenderer(EntityRendererProvider.Context pContext, boolean pChestBoat) {
        super(pContext, pChestBoat);
        this.BOAT_RESOURCES = ImmutableMap.of(NaturesBlocks.EVERGREEN.name(), Pair.of(new ResourceLocation(NaturesEnd.MOD_ID, "textures/entity/" + (pChestBoat ? "chest_boat" : "boat") + "/" + NaturesBlocks.EVERGREEN.name() + ".png"), this.createBoatModel(pContext, pChestBoat)),
                NaturesBlocks.SHADOW.name(), Pair.of(new ResourceLocation(NaturesEnd.MOD_ID, "textures/entity/" + (pChestBoat ? "chest_boat" : "boat") + "/" + NaturesBlocks.SHADOW.name() + ".png"), this.createBoatModel(pContext, pChestBoat)),
                NaturesBlocks.WILLOW.name(), Pair.of(new ResourceLocation(NaturesEnd.MOD_ID, "textures/entity/" + (pChestBoat ? "chest_boat" : "boat") + "/" + NaturesBlocks.WILLOW.name() + ".png"), this.createBoatModel(pContext, pChestBoat)));
        this.HAS_CHEST = pChestBoat;
    }

    private ListModel<Boat> createBoatModel(EntityRendererProvider.Context context, boolean chestBoat) {
        ModelLayerLocation modellayerlocation = chestBoat ?
                new ModelLayerLocation(new ResourceLocation("minecraft", "chest_boat/mangrove"), "main") :
                new ModelLayerLocation(new ResourceLocation("minecraft", "boat/mangrove"), "main");
        ModelPart modelpart = context.bakeLayer(modellayerlocation);
        return chestBoat ? new ChestBoatModel(modelpart) : new BoatModel(modelpart);
    }

    @Override
    public Pair<ResourceLocation, ListModel<Boat>> getModelWithLocation(Boat boat) {
        if(HAS_CHEST) return BOAT_RESOURCES.get(((NaturesChestBoat) boat).getWoodType());
        return BOAT_RESOURCES.get(((NaturesBoat) boat).getWoodType());
    }
}
