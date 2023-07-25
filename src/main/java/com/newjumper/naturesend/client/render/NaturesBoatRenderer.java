package com.newjumper.naturesend.client.render;

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
import net.minecraft.world.level.block.state.properties.WoodType;

import java.util.Map;

@SuppressWarnings("NullableProblems")
public class NaturesBoatRenderer extends BoatRenderer {
    public static final ModelLayerLocation NATURES_BOAT_MODEL = new ModelLayerLocation(new ResourceLocation(NaturesEnd.MOD_ID, "boat"), "main");
    public static final ModelLayerLocation NATURES_CHEST_BOAT_MODEL = new ModelLayerLocation(new ResourceLocation(NaturesEnd.MOD_ID, "chest_boat"), "main");
    private final Map<String, Pair<ResourceLocation, ListModel<Boat>>> BOAT_RESOURCES;
    private final boolean HAS_CHEST;

    public NaturesBoatRenderer(EntityRendererProvider.Context pContext, boolean pChestBoat) {
        super(pContext, pChestBoat);
        this.BOAT_RESOURCES = ImmutableMap.of(NaturesBlocks.EVERGREEN.name(), boatTexture(pContext, pChestBoat, NaturesBlocks.EVERGREEN), NaturesBlocks.SHADOW.name(), boatTexture(pContext, pChestBoat, NaturesBlocks.SHADOW), NaturesBlocks.WILLOW.name(), boatTexture(pContext, pChestBoat, NaturesBlocks.WILLOW));
        this.HAS_CHEST = pChestBoat;
    }

    private Pair<ResourceLocation, ListModel<Boat>> boatTexture(EntityRendererProvider.Context context, boolean chestBoat, WoodType woodType) {
        ModelPart modelpart = context.bakeLayer(chestBoat ? NATURES_CHEST_BOAT_MODEL : NATURES_BOAT_MODEL);
        return Pair.of(new ResourceLocation(NaturesEnd.MOD_ID, "textures/entity/" + (chestBoat ? "chest_boat" : "boat") + "/" + woodType.name() + ".png"), chestBoat ? new ChestBoatModel(modelpart) : new BoatModel(modelpart));
    }

    @Override
    public Pair<ResourceLocation, ListModel<Boat>> getModelWithLocation(Boat boat) {
        if(HAS_CHEST) return BOAT_RESOURCES.get(((NaturesChestBoat) boat).getWoodType());
        return BOAT_RESOURCES.get(((NaturesBoat) boat).getWoodType());
    }
}
