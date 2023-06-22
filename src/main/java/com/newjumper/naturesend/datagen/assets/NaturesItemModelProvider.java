package com.newjumper.naturesend.datagen.assets;

import com.newjumper.naturesend.NaturesEnd;
import com.newjumper.naturesend.content.NaturesBlocks;
import com.newjumper.naturesend.content.NaturesItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class NaturesItemModelProvider extends ItemModelProvider {
    private final ModelFile GENERATED = getExistingFile(mcLoc("item/generated"));

    public NaturesItemModelProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, NaturesEnd.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerModels() {
        blockModel(NaturesBlocks.EVERGREEN_LOG);
        blockModel(NaturesBlocks.EVERGREEN_WOOD);
        blockModel(NaturesBlocks.STRIPPED_EVERGREEN_LOG);
        blockModel(NaturesBlocks.STRIPPED_EVERGREEN_WOOD);
        blockModel(NaturesBlocks.EVERGREEN_PLANKS);
        blockModel(NaturesBlocks.EVERGREEN_STAIRS);
        blockModel(NaturesBlocks.EVERGREEN_SLAB);
        blockModel(NaturesBlocks.EVERGREEN_FENCE, "inventory");
        blockModel(NaturesBlocks.EVERGREEN_FENCE_GATE);
        blockItemModel(NaturesBlocks.EVERGREEN_DOOR, GENERATED).renderType("translucent");
        blockModel(NaturesBlocks.EVERGREEN_TRAPDOOR, "bottom");
        blockModel(NaturesBlocks.EVERGREEN_PRESSURE_PLATE);
        blockModel(NaturesBlocks.EVERGREEN_BUTTON, "inventory");
        blockModel(NaturesBlocks.EVERGREEN_LEAVES);
        getBuilder(NaturesBlocks.EVERGREEN_SAPLING.getId().getPath()).parent(GENERATED).texture("layer0", "block/" + NaturesBlocks.EVERGREEN_SAPLING.getId().getPath());

        blockModel(NaturesBlocks.WILLOW_LOG);
        blockModel(NaturesBlocks.WILLOW_WOOD);
        blockModel(NaturesBlocks.STRIPPED_WILLOW_LOG);
        blockModel(NaturesBlocks.STRIPPED_WILLOW_WOOD);
        blockModel(NaturesBlocks.WILLOW_PLANKS);
        blockModel(NaturesBlocks.WILLOW_STAIRS);
        blockModel(NaturesBlocks.WILLOW_SLAB);
        blockModel(NaturesBlocks.WILLOW_FENCE, "inventory");
        blockModel(NaturesBlocks.WILLOW_FENCE_GATE);
        blockItemModel(NaturesBlocks.WILLOW_DOOR, GENERATED).renderType("translucent");
        blockModel(NaturesBlocks.WILLOW_TRAPDOOR, "bottom");
        blockModel(NaturesBlocks.WILLOW_PRESSURE_PLATE);
        blockModel(NaturesBlocks.WILLOW_BUTTON, "inventory");
        blockModel(NaturesBlocks.WILLOW_LEAVES);
        getBuilder(NaturesBlocks.WILLOW_SAPLING.getId().getPath()).parent(GENERATED).texture("layer0", "block/" + NaturesBlocks.WILLOW_SAPLING.getId().getPath());

        blockModel(NaturesBlocks.SHALE);
        blockModel(NaturesBlocks.CHLORITE_SHALE);
        blockModel(NaturesBlocks.RED_SHALE);
        blockModel(NaturesBlocks.SALT_BLOCK);

        blockModel(NaturesBlocks.SHALE_BRICKS);
        blockModel(NaturesBlocks.SHALE_BRICK_STAIRS);
        blockModel(NaturesBlocks.SHALE_BRICK_SLAB);
        blockModel(NaturesBlocks.SHALE_BRICK_WALL, "inventory");


        itemModel(NaturesItems.EVERGREEN_SIGN, GENERATED);
        itemModel(NaturesItems.EVERGREEN_HANGING_SIGN, GENERATED);
        itemModel(NaturesItems.EVERGREEN_BOAT, GENERATED);
        itemModel(NaturesItems.EVERGREEN_CHEST_BOAT, GENERATED);
        itemModel(NaturesItems.WILLOW_SIGN, GENERATED);
        itemModel(NaturesItems.WILLOW_HANGING_SIGN, GENERATED);
        itemModel(NaturesItems.WILLOW_BOAT, GENERATED);
        itemModel(NaturesItems.WILLOW_CHEST_BOAT, GENERATED);

        itemModel(NaturesItems.SALT, GENERATED);
    }

    public void blockModel(RegistryObject<? extends Block> block) {
        withExistingParent(block.getId().getPath(), modLoc("block/" + block.getId().getPath()));
    }

    public void blockModel(RegistryObject<? extends Block> block, String suffix) {
        withExistingParent(block.getId().getPath(), modLoc("block/" + block.getId().getPath() + "_" + suffix));
    }

    public ItemModelBuilder blockItemModel(RegistryObject<? extends Block> item, ModelFile modelFile) {
        return getBuilder(item.getId().getPath()).parent(modelFile).texture("layer0", "item/" + item.getId().getPath());
    }

    public void itemModel(RegistryObject<? extends Item> item, ModelFile modelFile) {
        getBuilder(item.getId().getPath()).parent(modelFile).texture("layer0", "item/" + item.getId().getPath());
    }
}
