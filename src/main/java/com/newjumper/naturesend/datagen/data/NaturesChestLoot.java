package com.newjumper.naturesend.datagen.data;

import com.newjumper.naturesend.NaturesEnd;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.function.BiConsumer;

public class NaturesChestLoot implements LootTableSubProvider {
    public static final ResourceLocation VILLAGE_JUNGLE_HOUSE = new ResourceLocation(NaturesEnd.MOD_ID, "chests/village/village_jungle_house");

    @Override
    public void generate(BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
        consumer.accept(VILLAGE_JUNGLE_HOUSE, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(UniformGenerator.between(3, 6)).add(LootItem.lootTableItem(Blocks.BAMBOO).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 9)))).add(LootItem.lootTableItem(Blocks.JUNGLE_LOG).setWeight(9).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6)))).add(LootItem.lootTableItem(Blocks.JUNGLE_SAPLING).setWeight(7).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 5)))).add(LootItem.lootTableItem(Items.POTATO).setWeight(7).apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 6)))).add(LootItem.lootTableItem(Blocks.VINE).setWeight(7).apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 3)))).add(LootItem.lootTableItem(Blocks.MOSS_BLOCK).setWeight(6).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4)))).add(LootItem.lootTableItem(Items.CARROT).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 6)))).add(LootItem.lootTableItem(Blocks.FERN).setWeight(3)).add(LootItem.lootTableItem(Items.MELON_SEEDS).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6)))).add(LootItem.lootTableItem(Items.COCOA_BEANS).setWeight(2).apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 5)))).add(LootItem.lootTableItem(Items.EMERALD).setWeight(2).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4)))).add(LootItem.lootTableItem(Items.BEETROOT_SOUP).setWeight(1))));
    }
}
