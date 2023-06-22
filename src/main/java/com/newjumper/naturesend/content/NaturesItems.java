package com.newjumper.naturesend.content;

import com.newjumper.naturesend.NaturesEnd;
import com.newjumper.naturesend.content.items.NaturesBoatItem;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NaturesItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NaturesEnd.MOD_ID);

    public static final RegistryObject<Item> EVERGREEN_SIGN = ITEMS.register("evergreen_sign", () -> new SignItem(new Item.Properties().stacksTo(16), NaturesBlocks.EVERGREEN_SIGN.get(), NaturesBlocks.EVERGREEN_WALL_SIGN.get()));
    public static final RegistryObject<Item> EVERGREEN_HANGING_SIGN = ITEMS.register("evergreen_hanging_sign", () -> new HangingSignItem(NaturesBlocks.EVERGREEN_HANGING_SIGN.get(), NaturesBlocks.EVERGREEN_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> EVERGREEN_BOAT = ITEMS.register("evergreen_boat", () -> new NaturesBoatItem(false, new Item.Properties().stacksTo(1), NaturesBlocks.EVERGREEN));
    public static final RegistryObject<Item> EVERGREEN_CHEST_BOAT = ITEMS.register("evergreen_chest_boat", () -> new NaturesBoatItem(true, new Item.Properties().stacksTo(1), NaturesBlocks.EVERGREEN));

    public static final RegistryObject<Item> WILLOW_SIGN = ITEMS.register("willow_sign", () -> new SignItem(new Item.Properties().stacksTo(16), NaturesBlocks.WILLOW_SIGN.get(), NaturesBlocks.WILLOW_WALL_SIGN.get()));
    public static final RegistryObject<Item> WILLOW_HANGING_SIGN = ITEMS.register("willow_hanging_sign", () -> new HangingSignItem(NaturesBlocks.WILLOW_HANGING_SIGN.get(), NaturesBlocks.WILLOW_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> WILLOW_BOAT = ITEMS.register("willow_boat", () -> new NaturesBoatItem(false, new Item.Properties().stacksTo(1), NaturesBlocks.WILLOW));
    public static final RegistryObject<Item> WILLOW_CHEST_BOAT = ITEMS.register("willow_chest_boat", () -> new NaturesBoatItem(true, new Item.Properties().stacksTo(1), NaturesBlocks.WILLOW));

    public static final RegistryObject<Item> SHALE_PLATE = ITEMS.register("shale_plate", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SALT = ITEMS.register("salt", () -> new Item(new Item.Properties()));
}
