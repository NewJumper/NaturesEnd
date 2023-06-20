package com.newjumper.naturesend.datagen.assets;

import com.newjumper.naturesend.NaturesEnd;
import com.newjumper.naturesend.content.NaturesBlocks;
import net.minecraft.data.PackOutput;
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
        blockModel(NaturesBlocks.WILLOW_LOG);
        blockModel(NaturesBlocks.WILLOW_WOOD);
        blockModel(NaturesBlocks.STRIPPED_WILLOW_LOG);
        blockModel(NaturesBlocks.STRIPPED_WILLOW_WOOD);
        blockModel(NaturesBlocks.WILLOW_PLANKS);
        blockModel(NaturesBlocks.WILLOW_STAIRS);
        blockModel(NaturesBlocks.WILLOW_SLAB);
        blockModel(NaturesBlocks.WILLOW_FENCE, "inventory");
        blockModel(NaturesBlocks.WILLOW_FENCE_GATE);
        itemModel(NaturesBlocks.WILLOW_DOOR, GENERATED).renderType("translucent");
        blockModel(NaturesBlocks.WILLOW_TRAPDOOR, "bottom");
        blockModel(NaturesBlocks.WILLOW_PRESSURE_PLATE);
        blockModel(NaturesBlocks.WILLOW_BUTTON, "inventory");
    }

    public void blockModel(RegistryObject<? extends Block> block) {
        withExistingParent(block.getId().getPath(), modLoc("block/" + block.getId().getPath()));
    }

    public void blockModel(RegistryObject<? extends Block> block, String suffix) {
        withExistingParent(block.getId().getPath(), modLoc("block/" + block.getId().getPath() + "_" + suffix));
    }

    public ItemModelBuilder itemModel(RegistryObject<? extends Block> item, ModelFile modelFile) {
        return getBuilder(item.getId().getPath()).parent(modelFile).texture("layer0", "item/" + item.getId().getPath());
    }
}
