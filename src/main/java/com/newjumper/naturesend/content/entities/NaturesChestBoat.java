package com.newjumper.naturesend.content.entities;

import com.newjumper.naturesend.content.NaturesEntities;
import com.newjumper.naturesend.content.NaturesItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

@SuppressWarnings("NullableProblems")
public class NaturesChestBoat extends ChestBoat {
    private static final EntityDataAccessor<String> WOOD_TYPE = SynchedEntityData.defineId(NaturesChestBoat.class, EntityDataSerializers.STRING);

    public NaturesChestBoat(EntityType<? extends Boat> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public NaturesChestBoat(Level level, double x, double y, double z, String woodType) {
        this(NaturesEntities.NATURES_CHEST_BOAT.get(), level);
        this.setPos(x, y, z);
        this.xo = x;
        this.yo = y;
        this.zo = z;
        this.entityData.set(WOOD_TYPE, woodType);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(WOOD_TYPE, "willow");
    }

    @Override
    public Item getDropItem() {
        return switch(getWoodType()) {
            default -> NaturesItems.EVERGREEN_CHEST_BOAT.get();
            case "shadow" -> NaturesItems.SHADOW_CHEST_BOAT.get();
            case "willow" -> NaturesItems.WILLOW_CHEST_BOAT.get();
        };
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putString("Type", this.getWoodType());
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.setWoodType(pCompound.getString("Type"));
    }

    public String getWoodType() {
        return this.entityData.get(WOOD_TYPE);
    }

    public void setWoodType(String woodType) {
        this.entityData.set(WOOD_TYPE, woodType);
    }

    @Override
    public ItemStack getPickResult() {
        return new ItemStack(this.getDropItem());
    }
}
