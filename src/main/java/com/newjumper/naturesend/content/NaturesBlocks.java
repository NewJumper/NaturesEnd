package com.newjumper.naturesend.content;

import com.newjumper.naturesend.NaturesEnd;
import com.newjumper.naturesend.content.blocks.*;
import com.newjumper.naturesend.content.entities.NaturesHangingSignBlockEntity;
import com.newjumper.naturesend.content.entities.NaturesSignBlockEntity;
import com.newjumper.naturesend.world.trees.EvergreenTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.grower.OakTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("NullableProblems")
public class NaturesBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, NaturesEnd.MOD_ID);

    private static final BlockSetType EVERGREEN_SET = BlockSetType.register(new BlockSetType("evergreen"));
    public static final WoodType EVERGREEN = WoodType.register(new WoodType("evergreen", EVERGREEN_SET));
    public static final RegistryObject<RotatedPillarBlock> EVERGREEN_LOG = register("evergreen_log", () -> new RotatedFlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).mapColor(state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MapColor.COLOR_LIGHT_GRAY : MapColor.DEEPSLATE), 5, 5));
    public static final RegistryObject<RotatedPillarBlock> EVERGREEN_WOOD = register("evergreen_wood", () -> new RotatedFlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).mapColor(MapColor.DEEPSLATE), 5, 5));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_EVERGREEN_LOG = register("stripped_evergreen_log", () -> new RotatedFlammableBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.COLOR_LIGHT_GRAY), 5, 5));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_EVERGREEN_WOOD = register("stripped_evergreen_wood", () -> new RotatedFlammableBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.COLOR_LIGHT_GRAY), 5, 5));
    public static final RegistryObject<Block> EVERGREEN_PLANKS = register("evergreen_planks", () -> new FlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).mapColor(MapColor.COLOR_LIGHT_GRAY), 20, 5));
    public static final RegistryObject<StairBlock> EVERGREEN_STAIRS = register("evergreen_stairs", () -> new FlammableStairBlock(() -> EVERGREEN_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS).mapColor(MapColor.COLOR_LIGHT_GRAY), 20, 5));
    public static final RegistryObject<SlabBlock> EVERGREEN_SLAB = register("evergreen_slab", () -> new FlammableSlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB).mapColor(MapColor.COLOR_LIGHT_GRAY), 20, 5));
    public static final RegistryObject<FenceBlock> EVERGREEN_FENCE = register("evergreen_fence", () -> new FlammableFenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE).mapColor(MapColor.COLOR_LIGHT_GRAY), 20, 5));
    public static final RegistryObject<FenceGateBlock> EVERGREEN_FENCE_GATE = register("evergreen_fence_gate", () -> new FlammableFenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE).mapColor(MapColor.COLOR_LIGHT_GRAY), EVERGREEN, 20, 5));
    public static final RegistryObject<DoorBlock> EVERGREEN_DOOR = register("evergreen_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).mapColor(MapColor.COLOR_LIGHT_GRAY), EVERGREEN_SET));
    public static final RegistryObject<TrapDoorBlock> EVERGREEN_TRAPDOOR = register("evergreen_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).mapColor(MapColor.COLOR_LIGHT_GRAY), EVERGREEN_SET));
    public static final RegistryObject<PressurePlateBlock> EVERGREEN_PRESSURE_PLATE = register("evergreen_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE).mapColor(MapColor.COLOR_LIGHT_GRAY), EVERGREEN_SET));
    public static final RegistryObject<ButtonBlock> EVERGREEN_BUTTON = register("evergreen_button", () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), EVERGREEN_SET, 30, true));
    public static final RegistryObject<LeavesBlock> EVERGREEN_LEAVES = register("evergreen_leaves", () -> new FlammableLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES), 60, 30));
    public static final RegistryObject<SaplingBlock> EVERGREEN_SAPLING = register("evergreen_sapling", () -> new SaplingBlock(new EvergreenTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<StandingSignBlock> EVERGREEN_SIGN = BLOCKS.register("evergreen_sign", () -> new StandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).mapColor(MapColor.COLOR_LIGHT_GRAY), EVERGREEN) {
        @Override
        public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
            return new NaturesSignBlockEntity(pPos, pState);
        }
    });
    public static final RegistryObject<WallSignBlock> EVERGREEN_WALL_SIGN = BLOCKS.register("evergreen_wall_sign", () -> new WallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN).lootFrom(EVERGREEN_SIGN).mapColor(MapColor.COLOR_LIGHT_GRAY), EVERGREEN) {
        @Override
        public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
            return new NaturesSignBlockEntity(pPos, pState);
        }
    });
    public static final RegistryObject<CeilingHangingSignBlock> EVERGREEN_HANGING_SIGN = BLOCKS.register("evergreen_hanging_sign", () -> new CeilingHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN).mapColor(MapColor.COLOR_LIGHT_GRAY), EVERGREEN) {
        @Override
        public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
            return new NaturesHangingSignBlockEntity(pPos, pState);
        }
    });
    public static final RegistryObject<WallHangingSignBlock> EVERGREEN_WALL_HANGING_SIGN = BLOCKS.register("evergreen_wall_hanging_sign", () -> new WallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN).lootFrom(EVERGREEN_HANGING_SIGN).mapColor(MapColor.COLOR_LIGHT_GRAY), EVERGREEN) {
        @Override
        public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
            return new NaturesHangingSignBlockEntity(pPos, pState);
        }
    });

    private static final BlockSetType WILLOW_SET = BlockSetType.register(new BlockSetType("willow"));
    public static final WoodType WILLOW = WoodType.register(new WoodType("willow", WILLOW_SET));
    public static final RegistryObject<RotatedPillarBlock> WILLOW_LOG = register("willow_log", () -> new RotatedFlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).mapColor(state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MapColor.COLOR_ORANGE : MapColor.TERRACOTTA_ORANGE), 5, 5));
    public static final RegistryObject<RotatedPillarBlock> WILLOW_WOOD = register("willow_wood", () -> new RotatedFlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).mapColor(MapColor.TERRACOTTA_ORANGE), 5, 5));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_WILLOW_LOG = register("stripped_willow_log", () -> new RotatedFlammableBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.COLOR_ORANGE), 5, 5));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_WILLOW_WOOD = register("stripped_willow_wood", () -> new RotatedFlammableBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.COLOR_ORANGE), 5, 5));
    public static final RegistryObject<Block> WILLOW_PLANKS = register("willow_planks", () -> new FlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).mapColor(MapColor.COLOR_ORANGE), 20, 5));
    public static final RegistryObject<StairBlock> WILLOW_STAIRS = register("willow_stairs", () -> new FlammableStairBlock(() -> WILLOW_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS).mapColor(MapColor.COLOR_ORANGE), 20, 5));
    public static final RegistryObject<SlabBlock> WILLOW_SLAB = register("willow_slab", () -> new FlammableSlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB).mapColor(MapColor.COLOR_ORANGE), 20, 5));
    public static final RegistryObject<FenceBlock> WILLOW_FENCE = register("willow_fence", () -> new FlammableFenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE).mapColor(MapColor.COLOR_ORANGE), 20, 5));
    public static final RegistryObject<FenceGateBlock> WILLOW_FENCE_GATE = register("willow_fence_gate", () -> new FlammableFenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE).mapColor(MapColor.COLOR_ORANGE), WILLOW, 20, 5));
    public static final RegistryObject<DoorBlock> WILLOW_DOOR = register("willow_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).mapColor(MapColor.COLOR_ORANGE), WILLOW_SET));
    public static final RegistryObject<TrapDoorBlock> WILLOW_TRAPDOOR = register("willow_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).mapColor(MapColor.COLOR_ORANGE), WILLOW_SET));
    public static final RegistryObject<PressurePlateBlock> WILLOW_PRESSURE_PLATE = register("willow_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE).mapColor(MapColor.COLOR_ORANGE), WILLOW_SET));
    public static final RegistryObject<ButtonBlock> WILLOW_BUTTON = register("willow_button", () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), WILLOW_SET, 30, true));
    public static final RegistryObject<LeavesBlock> WILLOW_LEAVES = register("willow_leaves", () -> new FlammableLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES), 60, 30));
    public static final RegistryObject<SaplingBlock> WILLOW_SAPLING = register("willow_sapling", () -> new SaplingBlock(new OakTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<StandingSignBlock> WILLOW_SIGN = BLOCKS.register("willow_sign", () -> new StandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).mapColor(MapColor.COLOR_ORANGE), WILLOW) {
        @Override
        public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
            return new NaturesSignBlockEntity(pPos, pState);
        }
    });
    public static final RegistryObject<WallSignBlock> WILLOW_WALL_SIGN = BLOCKS.register("willow_wall_sign", () -> new WallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN).lootFrom(WILLOW_SIGN).mapColor(MapColor.COLOR_ORANGE), WILLOW) {
        @Override
        public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
            return new NaturesSignBlockEntity(pPos, pState);
        }
    });
    public static final RegistryObject<CeilingHangingSignBlock> WILLOW_HANGING_SIGN = BLOCKS.register("willow_hanging_sign", () -> new CeilingHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN).mapColor(MapColor.COLOR_ORANGE), WILLOW) {
        @Override
        public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
            return new NaturesHangingSignBlockEntity(pPos, pState);
        }
    });
    public static final RegistryObject<WallHangingSignBlock> WILLOW_WALL_HANGING_SIGN = BLOCKS.register("willow_wall_hanging_sign", () -> new WallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN).lootFrom(WILLOW_HANGING_SIGN).mapColor(MapColor.COLOR_ORANGE), WILLOW) {
        @Override
        public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
            return new NaturesHangingSignBlockEntity(pPos, pState);
        }
    });

    public static final RegistryObject<Block> SHALE = register("shale", () -> new Block(BlockBehaviour.Properties.of().strength(4f, 7).mapColor(MapColor.COLOR_GRAY).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CHLORITE_SHALE = register("chlorite_shale", () -> new Block(BlockBehaviour.Properties.of().strength(1.5f, 6).mapColor(MapColor.DIRT).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RED_SHALE = register("red_shale", () -> new Block(BlockBehaviour.Properties.of().strength(2.5f, 6.5f).mapColor(MapColor.COLOR_RED).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SALT_BLOCK = register("salt_block", () -> new Block(BlockBehaviour.Properties.of().strength(0.5f).sound(SoundType.SAND).mapColor(MapColor.TERRACOTTA_WHITE)));

    public static final RegistryObject<Block> SHALE_BRICKS = register("shale_bricks", () -> new Block(BlockBehaviour.Properties.of().strength(4f, 9).mapColor(MapColor.COLOR_GRAY).requiresCorrectToolForDrops()));
    public static final RegistryObject<StairBlock> SHALE_BRICK_STAIRS = register("shale_brick_stairs", () -> new StairBlock(() -> SHALE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.of().strength(4f, 9).mapColor(MapColor.COLOR_GRAY).requiresCorrectToolForDrops()));
    public static final RegistryObject<SlabBlock> SHALE_BRICK_SLAB = register("shale_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().strength(4f, 9).mapColor(MapColor.COLOR_GRAY).requiresCorrectToolForDrops()));
    public static final RegistryObject<WallBlock> SHALE_BRICK_WALL = register("shale_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.of().strength(4f, 9).mapColor(MapColor.COLOR_GRAY).requiresCorrectToolForDrops()));

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> pBlock) {
        RegistryObject<T> block = BLOCKS.register(name, pBlock);
        NaturesItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }
}
