package com.newjumper.naturesend.datagen.data;

import com.google.common.collect.ImmutableList;
import com.newjumper.naturesend.NaturesEnd;
import com.newjumper.naturesend.content.NaturesBlocks;
import com.newjumper.naturesend.content.NaturesItems;
import com.newjumper.naturesend.util.NaturesTags;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.*;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Consumer;

public class NaturesRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public NaturesRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> pWriter) {
        addCraftingRecipes(pWriter);
        addSmeltingRecipes(pWriter);
        addStonecuttingRecipes(pWriter);
    }

    public void addCraftingRecipes(Consumer<FinishedRecipe> writer) {
        addWoodenRecipes(writer, NaturesTags.Items.EVERGREEN_LOGS, NaturesBlocks.STRIPPED_EVERGREEN_LOG, NaturesBlocks.EVERGREEN_PLANKS, NaturesBlocks.EVERGREEN_STAIRS, NaturesBlocks.EVERGREEN_SLAB, NaturesBlocks.EVERGREEN_FENCE, NaturesBlocks.EVERGREEN_FENCE_GATE, NaturesBlocks.EVERGREEN_DOOR, NaturesBlocks.EVERGREEN_TRAPDOOR, NaturesBlocks.EVERGREEN_PRESSURE_PLATE, NaturesBlocks.EVERGREEN_BUTTON, NaturesItems.EVERGREEN_SIGN, NaturesItems.EVERGREEN_HANGING_SIGN, NaturesItems.EVERGREEN_BOAT, NaturesItems.EVERGREEN_CHEST_BOAT);
        addWoodenRecipes(writer, NaturesTags.Items.WILLOW_LOGS, NaturesBlocks.STRIPPED_WILLOW_LOG, NaturesBlocks.WILLOW_PLANKS, NaturesBlocks.WILLOW_STAIRS, NaturesBlocks.WILLOW_SLAB, NaturesBlocks.WILLOW_FENCE, NaturesBlocks.WILLOW_FENCE_GATE, NaturesBlocks.WILLOW_DOOR, NaturesBlocks.WILLOW_TRAPDOOR, NaturesBlocks.WILLOW_PRESSURE_PLATE, NaturesBlocks.WILLOW_BUTTON, NaturesItems.WILLOW_SIGN, NaturesItems.WILLOW_HANGING_SIGN, NaturesItems.WILLOW_BOAT, NaturesItems.WILLOW_CHEST_BOAT);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, NaturesBlocks.SHALE.get(), 8).requires(Items.COAL).requires(Blocks.MUD, 4).requires(Blocks.CLAY, 4).unlockedBy("has_mud", has(Blocks.MUD)).unlockedBy("has_clay", has(Blocks.CLAY)).save(writer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, NaturesBlocks.SHALE_BRICKS.get(), 4).define('#', NaturesBlocks.SHALE.get()).pattern("##").pattern("##").unlockedBy(getHasName(NaturesBlocks.SHALE.get()), has(NaturesBlocks.SHALE.get())).save(writer);
        stairBuilder(NaturesBlocks.SHALE_BRICK_STAIRS.get(), Ingredient.of(NaturesBlocks.SHALE_BRICKS.get())).unlockedBy("has_shale_bricks", has(NaturesBlocks.SHALE_BRICKS.get())).save(writer);
        slab(writer, RecipeCategory.BUILDING_BLOCKS, NaturesBlocks.SHALE_BRICK_SLAB.get(), NaturesBlocks.SHALE_BRICKS.get());
        wall(writer, RecipeCategory.BUILDING_BLOCKS, NaturesBlocks.SHALE_BRICK_WALL.get(), NaturesBlocks.SHALE_BRICKS.get());
    }

    public void addSmeltingRecipes(Consumer<FinishedRecipe> writer) {
        final ImmutableList<ItemLike> NON_CARBON_SHALE = ImmutableList.of(NaturesBlocks.CHLORITE_SHALE.get(), NaturesBlocks.FERROUS_SHALE.get(), NaturesBlocks.PURPLE_SHALE.get(), NaturesBlocks.RED_SHALE.get());

        smelting(NaturesBlocks.SHALE.get(), RecipeCategory.BUILDING_BLOCKS, Blocks.DEEPSLATE, 0.1f, "deepslate", writer);
        smelting(NaturesBlocks.ERODED_SHALE.get(), RecipeCategory.BUILDING_BLOCKS, Blocks.STONE, 0.1f, "stone", writer);
        smelting(NON_CARBON_SHALE, RecipeCategory.BUILDING_BLOCKS, NaturesBlocks.SHALE.get(), 0.1f, "shale", writer);
    }

    private void smelting(List<ItemLike> ingredients, RecipeCategory category, ItemLike result, float experience, String group, Consumer<FinishedRecipe> consumer) {
        for(ItemLike item : ingredients) smelting(item, category, result, experience, group, consumer);
    }

    private void smelting(ItemLike ingredient, RecipeCategory category, ItemLike result, float experience, String group, Consumer<FinishedRecipe> consumer) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient), category, result, experience, 200).group(group).unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer, new ResourceLocation(NaturesEnd.MOD_ID, getSmeltingRecipeName(result) + getItemName(ingredient)));
    }

    public void addStonecuttingRecipes(Consumer<FinishedRecipe> writer) {
        stonecuttingRecipe(writer, RecipeCategory.BUILDING_BLOCKS, NaturesBlocks.SHALE_BRICKS.get(), NaturesBlocks.SHALE.get());
        stonecuttingRecipe(writer, RecipeCategory.BUILDING_BLOCKS, NaturesBlocks.SHALE_BRICK_STAIRS.get(), NaturesBlocks.SHALE.get());
        stonecuttingRecipe(writer, RecipeCategory.BUILDING_BLOCKS, NaturesBlocks.SHALE_BRICK_STAIRS.get(), NaturesBlocks.SHALE_BRICKS.get());
        stonecuttingRecipe(writer, RecipeCategory.BUILDING_BLOCKS, NaturesBlocks.SHALE_BRICK_SLAB.get(), NaturesBlocks.SHALE.get(), 2);
        stonecuttingRecipe(writer, RecipeCategory.BUILDING_BLOCKS, NaturesBlocks.SHALE_BRICK_SLAB.get(), NaturesBlocks.SHALE_BRICKS.get(), 2);
        stonecuttingRecipe(writer, RecipeCategory.BUILDING_BLOCKS, NaturesBlocks.SHALE_BRICK_WALL.get(), NaturesBlocks.SHALE.get());
        stonecuttingRecipe(writer, RecipeCategory.BUILDING_BLOCKS, NaturesBlocks.SHALE_BRICK_WALL.get(), NaturesBlocks.SHALE_BRICKS.get());
    }

    private void stonecuttingRecipe(Consumer<FinishedRecipe> writer, RecipeCategory category, ItemLike result, ItemLike ingredient) {
        stonecuttingRecipe(writer, category, result, ingredient, 1);
    }

    private void stonecuttingRecipe(Consumer<FinishedRecipe> writer, RecipeCategory category, ItemLike result, ItemLike ingredient, int count) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ingredient), category, result, count).unlockedBy(getHasName(ingredient), has(ingredient)).save(writer, new ResourceLocation(NaturesEnd.MOD_ID,getConversionRecipeName(result, ingredient) + "_stonecutting"));
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
