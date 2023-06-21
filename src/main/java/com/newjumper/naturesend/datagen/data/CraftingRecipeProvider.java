package com.newjumper.naturesend.datagen.data;

import com.newjumper.naturesend.content.NaturesBlocks;
import com.newjumper.naturesend.content.NaturesItems;
import com.newjumper.naturesend.util.NaturesTags;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.*;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class CraftingRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public CraftingRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> pWriter) {
        addWoodenRecipes(pWriter, NaturesTags.Items.EVERGREEN_LOGS, NaturesBlocks.STRIPPED_EVERGREEN_LOG, NaturesBlocks.EVERGREEN_PLANKS, NaturesBlocks.EVERGREEN_STAIRS, NaturesBlocks.EVERGREEN_SLAB, NaturesBlocks.EVERGREEN_FENCE, NaturesBlocks.EVERGREEN_FENCE_GATE, NaturesBlocks.EVERGREEN_DOOR, NaturesBlocks.EVERGREEN_TRAPDOOR, NaturesBlocks.EVERGREEN_PRESSURE_PLATE, NaturesBlocks.EVERGREEN_BUTTON, NaturesItems.EVERGREEN_SIGN, NaturesItems.EVERGREEN_HANGING_SIGN, NaturesItems.EVERGREEN_BOAT, NaturesItems.EVERGREEN_CHEST_BOAT);
        addWoodenRecipes(pWriter, NaturesTags.Items.WILLOW_LOGS, NaturesBlocks.STRIPPED_WILLOW_LOG, NaturesBlocks.WILLOW_PLANKS, NaturesBlocks.WILLOW_STAIRS, NaturesBlocks.WILLOW_SLAB, NaturesBlocks.WILLOW_FENCE, NaturesBlocks.WILLOW_FENCE_GATE, NaturesBlocks.WILLOW_DOOR, NaturesBlocks.WILLOW_TRAPDOOR, NaturesBlocks.WILLOW_PRESSURE_PLATE, NaturesBlocks.WILLOW_BUTTON, NaturesItems.WILLOW_SIGN, NaturesItems.WILLOW_HANGING_SIGN, NaturesItems.WILLOW_BOAT, NaturesItems.WILLOW_CHEST_BOAT);
    }

    private void addWoodenRecipes(Consumer<FinishedRecipe> writer, TagKey<Item> logs, RegistryObject<RotatedPillarBlock> strippedLog, RegistryObject<Block> planks, RegistryObject<StairBlock> stairs, RegistryObject<SlabBlock> slabs, RegistryObject<FenceBlock> fence, RegistryObject<FenceGateBlock> fenceGate, RegistryObject<DoorBlock> door, RegistryObject<TrapDoorBlock> trapDoor, RegistryObject<PressurePlateBlock> pressurePlate, RegistryObject<ButtonBlock> button, RegistryObject<Item> sign, RegistryObject<Item> hangingSign, RegistryObject<Item> boat, RegistryObject<Item> chestBoat) {
        planksFromLogs(writer, planks.get(), logs, 4);
        stairBuilder(stairs.get(), Ingredient.of(planks.get())).unlockedBy("has_planks", has(planks.get())).save(writer);
        slab(writer, RecipeCategory.BUILDING_BLOCKS, slabs.get(), planks.get());
        fenceBuilder(fence.get(), Ingredient.of(planks.get())).unlockedBy("has_planks", has(planks.get())).save(writer);
        fenceGateBuilder(fenceGate.get(), Ingredient.of(planks.get())).unlockedBy("has_planks", has(planks.get())).save(writer);
        doorBuilder(door.get(), Ingredient.of(planks.get())).unlockedBy("has_planks", has(planks.get())).save(writer);
        trapdoorBuilder(trapDoor.get(), Ingredient.of(planks.get())).unlockedBy("has_planks", has(planks.get())).save(writer);
        pressurePlate(writer, pressurePlate.get(), planks.get());
        buttonBuilder(button.get(), Ingredient.of(planks.get())).unlockedBy("has_planks", has(planks.get())).save(writer);
        signBuilder(sign.get(), Ingredient.of(planks.get())).unlockedBy("has_planks", has(planks.get())).save(writer);
        hangingSign(writer, hangingSign.get(), strippedLog.get());
        woodenBoat(writer, boat.get(), planks.get());
        chestBoat(writer, chestBoat.get(), boat.get());
    }
}
