package com.newjumper.naturesend.content;

import com.newjumper.naturesend.NaturesEnd;
import com.newjumper.naturesend.content.entities.NaturesHangingSignBlockEntity;
import com.newjumper.naturesend.content.entities.NaturesSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.grower.OakTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("NullableProblems")
public class NaturesBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, NaturesEnd.MOD_ID);

    private static final BlockSetType WILLOW_SET = BlockSetType.register(new BlockSetType("willow"));
    public static final WoodType WILLOW = WoodType.register(new WoodType("willow", WILLOW_SET));
    public static final RegistryObject<RotatedPillarBlock> WILLOW_LOG = register("willow_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<RotatedPillarBlock> WILLOW_WOOD = register("willow_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_WILLOW_LOG = register("stripped_willow_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_WILLOW_WOOD = register("stripped_willow_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> WILLOW_PLANKS = register("willow_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<StairBlock> WILLOW_STAIRS = register("willow_stairs", () -> new StairBlock(() -> WILLOW_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));
    public static final RegistryObject<SlabBlock> WILLOW_SLAB = register("willow_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));
    public static final RegistryObject<FenceBlock> WILLOW_FENCE = register("willow_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));
    public static final RegistryObject<FenceGateBlock> WILLOW_FENCE_GATE = register("willow_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE), WILLOW));
    public static final RegistryObject<DoorBlock> WILLOW_DOOR = register("willow_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), WILLOW_SET));
    public static final RegistryObject<TrapDoorBlock> WILLOW_TRAPDOOR = register("willow_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), WILLOW_SET));
    public static final RegistryObject<PressurePlateBlock> WILLOW_PRESSURE_PLATE = register("willow_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), WILLOW_SET));
    public static final RegistryObject<ButtonBlock> WILLOW_BUTTON = register("willow_button", () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), WILLOW_SET, 30, true));
    public static final RegistryObject<LeavesBlock> WILLOW_LEAVES = register("willow_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<SaplingBlock> WILLOW_SAPLING = register("willow_sapling", () -> new SaplingBlock(new OakTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<StandingSignBlock> WILLOW_SIGN = BLOCKS.register("willow_sign", () -> new StandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), WILLOW) {
        @Override
        public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
            return new NaturesSignBlockEntity(pPos, pState);
        }
    });
    public static final RegistryObject<WallSignBlock> WILLOW_WALL_SIGN = BLOCKS.register("willow_wall_sign", () -> new WallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN).lootFrom(WILLOW_SIGN), WILLOW) {
        @Override
        public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
            return new NaturesSignBlockEntity(pPos, pState);
        }
    });
    public static final RegistryObject<CeilingHangingSignBlock> WILLOW_HANGING_SIGN = BLOCKS.register("willow_hanging_sign", () -> new CeilingHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), WILLOW) {
        @Override
        public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
            return new NaturesHangingSignBlockEntity(pPos, pState);
        }
    });
    public static final RegistryObject<WallHangingSignBlock> WILLOW_WALL_HANGING_SIGN = BLOCKS.register("willow_wall_hanging_sign", () -> new WallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN).lootFrom(WILLOW_HANGING_SIGN), WILLOW) {
        @Override
        public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
            return new NaturesHangingSignBlockEntity(pPos, pState);
        }
    });

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> pBlock) {
        RegistryObject<T> block = BLOCKS.register(name, pBlock);
        NaturesItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }
}
