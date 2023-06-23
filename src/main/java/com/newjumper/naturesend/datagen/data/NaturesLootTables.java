package com.newjumper.naturesend.datagen.data;

import com.newjumper.naturesend.content.NaturesBlocks;
import com.newjumper.naturesend.content.NaturesItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NaturesLootTables extends BlockLootSubProvider {
    private static final Set<Item> EXPLOSION_RESISTANT = Stream.of(Blocks.DRAGON_EGG, Blocks.BEACON, Blocks.CONDUIT, Blocks.SKELETON_SKULL, Blocks.WITHER_SKELETON_SKULL, Blocks.PLAYER_HEAD, Blocks.ZOMBIE_HEAD, Blocks.CREEPER_HEAD, Blocks.DRAGON_HEAD, Blocks.PIGLIN_HEAD, Blocks.SHULKER_BOX, Blocks.BLACK_SHULKER_BOX, Blocks.BLUE_SHULKER_BOX, Blocks.BROWN_SHULKER_BOX, Blocks.CYAN_SHULKER_BOX, Blocks.GRAY_SHULKER_BOX, Blocks.GREEN_SHULKER_BOX, Blocks.LIGHT_BLUE_SHULKER_BOX, Blocks.LIGHT_GRAY_SHULKER_BOX, Blocks.LIME_SHULKER_BOX, Blocks.MAGENTA_SHULKER_BOX, Blocks.ORANGE_SHULKER_BOX, Blocks.PINK_SHULKER_BOX, Blocks.PURPLE_SHULKER_BOX, Blocks.RED_SHULKER_BOX, Blocks.WHITE_SHULKER_BOX, Blocks.YELLOW_SHULKER_BOX).map(ItemLike::asItem).collect(Collectors.toSet());

    protected NaturesLootTables() {
        super(EXPLOSION_RESISTANT, FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(NaturesBlocks.EVERGREEN_LOG.get());
        dropSelf(NaturesBlocks.EVERGREEN_WOOD.get());
        dropSelf(NaturesBlocks.STRIPPED_EVERGREEN_LOG.get());
        dropSelf(NaturesBlocks.STRIPPED_EVERGREEN_WOOD.get());
        dropSelf(NaturesBlocks.EVERGREEN_PLANKS.get());
        dropSelf(NaturesBlocks.EVERGREEN_STAIRS.get());
        add(NaturesBlocks.EVERGREEN_SLAB.get(), this::createSlabItemTable);
        dropSelf(NaturesBlocks.EVERGREEN_FENCE.get());
        dropSelf(NaturesBlocks.EVERGREEN_FENCE_GATE.get());
        add(NaturesBlocks.EVERGREEN_DOOR.get(), this::createDoorTable);
        dropSelf(NaturesBlocks.EVERGREEN_TRAPDOOR.get());
        dropSelf(NaturesBlocks.EVERGREEN_PRESSURE_PLATE.get());
        dropSelf(NaturesBlocks.EVERGREEN_BUTTON.get());
        add(NaturesBlocks.EVERGREEN_LEAVES.get(), (block) -> this.createLeavesDrops(block, NaturesBlocks.EVERGREEN_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        dropSelf(NaturesBlocks.EVERGREEN_SAPLING.get());
        dropSelf(NaturesBlocks.EVERGREEN_SIGN.get());
        dropSelf(NaturesBlocks.EVERGREEN_HANGING_SIGN.get());

        dropSelf(NaturesBlocks.WILLOW_LOG.get());
        dropSelf(NaturesBlocks.WILLOW_WOOD.get());
        dropSelf(NaturesBlocks.STRIPPED_WILLOW_LOG.get());
        dropSelf(NaturesBlocks.STRIPPED_WILLOW_WOOD.get());
        dropSelf(NaturesBlocks.WILLOW_PLANKS.get());
        dropSelf(NaturesBlocks.WILLOW_STAIRS.get());
        add(NaturesBlocks.WILLOW_SLAB.get(), this::createSlabItemTable);
        dropSelf(NaturesBlocks.WILLOW_FENCE.get());
        dropSelf(NaturesBlocks.WILLOW_FENCE_GATE.get());
        add(NaturesBlocks.WILLOW_DOOR.get(), this::createDoorTable);
        dropSelf(NaturesBlocks.WILLOW_TRAPDOOR.get());
        dropSelf(NaturesBlocks.WILLOW_PRESSURE_PLATE.get());
        dropSelf(NaturesBlocks.WILLOW_BUTTON.get());
        add(NaturesBlocks.WILLOW_LEAVES.get(), (block) -> this.createLeavesDrops(block, NaturesBlocks.WILLOW_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        dropSelf(NaturesBlocks.WILLOW_SAPLING.get());
        dropSelf(NaturesBlocks.WILLOW_SIGN.get());
        dropSelf(NaturesBlocks.WILLOW_HANGING_SIGN.get());

        dropSelf(NaturesBlocks.SHALE.get());
        dropSelf(NaturesBlocks.ERODED_SHALE.get());
        dropSelf(NaturesBlocks.CHLORITE_SHALE.get());
        dropSelf(NaturesBlocks.RED_SHALE.get());
        add(NaturesBlocks.SALT_BLOCK.get(), (block) -> this.createSingleItemTableWithSilkTouch(block, NaturesItems.SALT.get(), ConstantValue.exactly(4)));

        dropSelf(NaturesBlocks.SHALE_BRICKS.get());
        dropSelf(NaturesBlocks.SHALE_BRICK_STAIRS.get());
        add(NaturesBlocks.SHALE_BRICK_SLAB.get(), this::createSlabItemTable);
        dropSelf(NaturesBlocks.SHALE_BRICK_WALL.get());
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return NaturesBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
