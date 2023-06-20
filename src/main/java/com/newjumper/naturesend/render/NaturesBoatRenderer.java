package com.newjumper.naturesend.render;

import com.mojang.datafixers.util.Pair;
import com.newjumper.naturesend.NaturesEnd;
import com.newjumper.naturesend.content.NaturesBlocks;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;

@SuppressWarnings("NullableProblems")
public class NaturesBoatRenderer extends BoatRenderer {
    private final Pair<ResourceLocation, ListModel<Boat>> BOAT_RESOURCES;

    public NaturesBoatRenderer(EntityRendererProvider.Context pContext, boolean pChestBoat) {
        super(pContext, pChestBoat);
        BOAT_RESOURCES = Pair.of(new ResourceLocation(NaturesEnd.MOD_ID, "textures/entity/" + (pChestBoat ? "chest_boat" : "boat") + "/" + NaturesBlocks.WILLOW.name() + ".png"), this.createBoatModel(pContext, pChestBoat));
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
        return BOAT_RESOURCES;
    }
}
