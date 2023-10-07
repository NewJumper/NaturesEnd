package com.newjumper.naturesend.world.structures.village;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Either;
import com.mojang.datafixers.util.Pair;
import com.newjumper.naturesend.NaturesEnd;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.data.worldgen.ProcessorLists;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.pools.SinglePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

import java.util.List;
import java.util.function.Function;

public class JungleVillagePools {
    public static final ResourceKey<StructureTemplatePool> START = createKey("village/jungle/town_centers");
    private static final ResourceKey<StructureTemplatePool> END = createKey("village/jungle/terminators");
    private static final Holder<StructureProcessorList> EMPTY = Holder.direct(new StructureProcessorList(List.of()));

    public static void bootstrap(BootstapContext<StructureTemplatePool> context) {
        HolderGetter<StructureTemplatePool> pools = context.lookup(Registries.TEMPLATE_POOL);
        Holder<StructureTemplatePool> empty = pools.getOrThrow(Pools.EMPTY);
        Holder<StructureTemplatePool> terminator = pools.getOrThrow(END);
        Holder<StructureProcessorList> mossy = context.lookup(Registries.PROCESSOR_LIST).getOrThrow(ProcessorLists.MOSSIFY_20_PERCENT);

        context.register(START, new StructureTemplatePool(empty, ImmutableList.of(Pair.of(location("village/jungle/town_centers/jungle_fountain_1", mossy), 1), Pair.of(location("village/jungle/town_centers/jungle_meeting_point_1", mossy), 1), Pair.of(location("village/jungle/town_centers/jungle_meeting_point_2", mossy), 1), Pair.of(location("village/jungle/town_centers/jungle_meeting_point_3", mossy), 1)), StructureTemplatePool.Projection.RIGID));
        context.register(END, new StructureTemplatePool(empty, ImmutableList.of(Pair.of(location("village/jungle/terminators/terminator_1"), 1), Pair.of(location("village/jungle/terminators/terminator_2"), 1), Pair.of(location("village/jungle/terminators/terminator_3"), 1), Pair.of(location("village/jungle/terminators/terminator_4"), 1)), StructureTemplatePool.Projection.TERRAIN_MATCHING));
        context.register(createKey("village/jungle/streets"), new StructureTemplatePool(terminator, ImmutableList.of(Pair.of(location("village/jungle/streets/corner_1"), 2), Pair.of(location("village/jungle/streets/corner_2"), 2), Pair.of(location("village/jungle/streets/corner_3"), 2), Pair.of(location("village/jungle/streets/straight_1"), 4), Pair.of(location("village/jungle/streets/straight_2"), 4), Pair.of(location("village/jungle/streets/straight_3"), 7), Pair.of(location("village/jungle/streets/straight_4"), 7), Pair.of(location("village/jungle/streets/straight_5"), 3), Pair.of(location("village/jungle/streets/straight_6"), 4), Pair.of(location("village/jungle/streets/crossroad_1"), 2), Pair.of(location("village/jungle/streets/crossroad_2"), 1), Pair.of(location("village/jungle/streets/crossroad_3"), 2), Pair.of(location("village/jungle/streets/crossroad_4"), 2), Pair.of(location("village/jungle/streets/crossroad_5"), 2), Pair.of(location("village/jungle/streets/crossroad_6"), 2), Pair.of(location("village/jungle/streets/turn_1"), 3)), StructureTemplatePool.Projection.TERRAIN_MATCHING));
        context.register(createKey("village/jungle/houses"), new StructureTemplatePool(terminator, ImmutableList.of(Pair.of(location("village/jungle/houses/jungle_small_house_1", mossy), 1), Pair.of(location("village/jungle/houses/jungle_small_house_2", mossy), 1), Pair.of(location("village/jungle/houses/jungle_small_house_3", mossy), 1), Pair.of(location("village/jungle/houses/jungle_small_house_4", mossy), 1), Pair.of(location("village/jungle/houses/jungle_small_house_5", mossy), 1), Pair.of(location("village/jungle/houses/jungle_small_house_6", mossy), 1), Pair.of(location("village/jungle/houses/jungle_medium_house_1", mossy), 1), Pair.of(location("village/jungle/houses/jungle_medium_house_2", mossy), 1), Pair.of(location("village/jungle/houses/jungle_big_house_1", mossy), 1), Pair.of(location("village/jungle/houses/jungle_armorer_house_1", mossy), 1), Pair.of(location("village/jungle/houses/jungle_butcher_shop_1", mossy), 1), Pair.of(location("village/jungle/houses/jungle_cartographer_1", mossy), 1), Pair.of(location("village/jungle/houses/jungle_fisher_cottage_1", mossy), 1), Pair.of(location("village/jungle/houses/jungle_library_1", mossy), 1), Pair.of(location("village/jungle/houses/jungle_masons_house_1", mossy), 1), Pair.of(location("village/jungle/houses/jungle_tannery_1", mossy), 1), Pair.of(location("village/jungle/houses/jungle_temple_1", mossy), 1), Pair.of(location("village/jungle/houses/jungle_toolsmith_1", mossy), 1), Pair.of(location("village/jungle/houses/jungle_weaponsmith_1", mossy), 1), Pair.of(location("village/jungle/houses/jungle_farm_1", mossy), 1), Pair.of(location("village/jungle/houses/jungle_farm_2", mossy), 1), Pair.of(location("village/jungle/houses/jungle_animal_pen_1", mossy), 1), Pair.of(location("village/jungle/houses/jungle_animal_pen_2", mossy), 1), Pair.of(location("village/jungle/houses/jungle_animal_pen_3", mossy), 1), Pair.of(location("village/jungle/houses/jungle_accessory_1", mossy), 1), Pair.of(StructurePoolElement.empty(), 6)), StructureTemplatePool.Projection.RIGID));
        context.register(createKey("village/jungle/animals"), new StructureTemplatePool(empty, ImmutableList.of(Pair.of(location("village/jungle/animals/panda"), 1), Pair.of(location("village/jungle/animals/ocelot"), 1)), StructureTemplatePool.Projection.RIGID));
        context.register(createKey("village/jungle/armor"), new StructureTemplatePool(empty, ImmutableList.of(Pair.of(location("village/jungle/armor/armor_1"), 1), Pair.of(location("village/jungle/armor/armor_2"), 1), Pair.of(location("village/jungle/armor/armor_3"), 1), Pair.of(location("village/jungle/armor/armor_4"), 1), Pair.of(location("village/jungle/armor/armor_5"), 1), Pair.of(location("village/jungle/armor/armor_6"), 1), Pair.of(location("village/jungle/armor/armor_7"), 1), Pair.of(location("village/jungle/armor/armor_8"), 1), Pair.of(location("village/jungle/armor/armor_9"), 1)), StructureTemplatePool.Projection.RIGID));
    }

    public static Function<StructureTemplatePool.Projection, SinglePoolElement> location(String name, Holder<StructureProcessorList> processor) {
        return (projection) -> new SinglePoolElement(Either.left(new ResourceLocation(NaturesEnd.MOD_ID, name)), processor, projection) {};
    }
    
    public static Function<StructureTemplatePool.Projection, SinglePoolElement> location(String name) {
        return (projection) -> new SinglePoolElement(Either.left(new ResourceLocation(NaturesEnd.MOD_ID, name)), EMPTY, projection) {};
    }

    public static ResourceKey<StructureTemplatePool> createKey(String name) {
        return ResourceKey.create(Registries.TEMPLATE_POOL, new ResourceLocation(NaturesEnd.MOD_ID, name));
    }
}
