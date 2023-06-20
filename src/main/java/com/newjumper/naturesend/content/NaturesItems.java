package com.newjumper.naturesend.content;

import com.newjumper.naturesend.NaturesEnd;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NaturesItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NaturesEnd.MOD_ID);

    public static final RegistryObject<Item> WILLOW_SIGN = ITEMS.register("willow_sign", () -> new SignItem(new Item.Properties().stacksTo(16), NaturesBlocks.WILLOW_SIGN.get(), NaturesBlocks.WILLOW_WALL_SIGN.get()));
}
