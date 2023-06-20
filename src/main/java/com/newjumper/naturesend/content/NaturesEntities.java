package com.newjumper.naturesend.content;

import com.newjumper.naturesend.NaturesEnd;
import com.newjumper.naturesend.content.entities.NaturesBoat;
import com.newjumper.naturesend.content.entities.NaturesChestBoat;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NaturesEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, NaturesEnd.MOD_ID);

    public static final RegistryObject<EntityType<NaturesBoat>> WILLOW_BOAT = ENTITIES.register("willow_boat", () -> EntityType.Builder.<NaturesBoat>of(NaturesBoat::new, MobCategory.MISC).sized(1.375f, 0.5625f).clientTrackingRange(10).build(new ResourceLocation(NaturesEnd.MOD_ID, "boat").toString()));
    public static final RegistryObject<EntityType<NaturesChestBoat>> WILLOW_CHEST_BOAT = ENTITIES.register("willow_chest_boat", () -> EntityType.Builder.<NaturesChestBoat>of(NaturesChestBoat::new, MobCategory.MISC).sized(1.375f, 0.5625f).clientTrackingRange(10).build(new ResourceLocation(NaturesEnd.MOD_ID, "chest_boat").toString()));
}
