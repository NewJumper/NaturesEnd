package com.newjumper.naturesend.datagen.assets;

import com.newjumper.naturesend.NaturesEnd;
import com.newjumper.naturesend.content.NaturesBlocks;
import com.newjumper.naturesend.content.NaturesItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.BlockItem;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.RegistryObject;

public class ENLanguageProvider extends LanguageProvider {
    public ENLanguageProvider(PackOutput output) {
        super(output, NaturesEnd.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("itemGroup." + NaturesEnd.MOD_ID, "Nature's End");
        add("entity." + NaturesEnd.MOD_ID + ".natures_chest_boat", "Boat with Chest");

        NaturesBlocks.BLOCKS.getEntries().forEach(block -> add(block, "block"));
        NaturesItems.ITEMS.getEntries().stream().filter(item -> !(item.get() instanceof BlockItem)).forEach(item -> add(item, "item"));
    }

    private void add(RegistryObject<?> entry, String prefix) {
        if(filter(entry)) return;
        String key = entry.getId().getPath();
        add(prefix + "." + NaturesEnd.MOD_ID + "." + key, convertToName(key));
    }

    private boolean filter(RegistryObject<?> entry) {
        return entry == NaturesBlocks.WILLOW_WALL_SIGN ||
                entry == NaturesBlocks.WILLOW_WALL_HANGING_SIGN;
    }

    private String convertToName(String key) {
        StringBuilder builder = new StringBuilder(key.substring(0, 1).toUpperCase() + key.substring(1));
        for(int i = 1; i < builder.length(); i++) {
            if(builder.charAt(i) == '_') {
                builder.deleteCharAt(i);
                builder.replace(i, i + 1, " " + Character.toUpperCase(builder.charAt(i)));
            }
        }

        String name = builder.toString();
        if(name.contains("Chest")) name = name.replace("Chest ", "") + " With Chest";
        if(name.contains(" Block")) name = "Block of " + name.replace(" Block", "");

        return name;
    }
}
