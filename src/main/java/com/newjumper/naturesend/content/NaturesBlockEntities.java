package com.newjumper.naturesend.content;

import com.newjumper.naturesend.NaturesEnd;
import com.newjumper.naturesend.content.entities.NaturesHangingSignBlockEntity;
import com.newjumper.naturesend.content.entities.NaturesSignBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NaturesBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, NaturesEnd.MOD_ID);

    public static final RegistryObject<BlockEntityType<NaturesSignBlockEntity>> NATURES_SIGNS = BLOCK_ENTITIES.register("natures_signs", () -> BlockEntityType.Builder.of(NaturesSignBlockEntity::new, NaturesBlocks.EVERGREEN_SIGN.get(), NaturesBlocks.EVERGREEN_WALL_SIGN.get(), NaturesBlocks.WILLOW_SIGN.get(), NaturesBlocks.WILLOW_WALL_SIGN.get()).build(null));
    public static final RegistryObject<BlockEntityType<NaturesHangingSignBlockEntity>> NATURES_HANGING_SIGNS = BLOCK_ENTITIES.register("natures_hanging_signs", () -> BlockEntityType.Builder.of(NaturesHangingSignBlockEntity::new, NaturesBlocks.EVERGREEN_HANGING_SIGN.get(), NaturesBlocks.EVERGREEN_WALL_HANGING_SIGN.get(), NaturesBlocks.WILLOW_HANGING_SIGN.get(), NaturesBlocks.WILLOW_WALL_HANGING_SIGN.get()).build(null));
}
