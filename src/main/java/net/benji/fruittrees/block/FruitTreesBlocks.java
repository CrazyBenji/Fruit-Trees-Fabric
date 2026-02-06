package net.benji.fruittrees.block;

import net.benji.fruittrees.FruitTrees;
import net.benji.fruittrees.block.custom.*;
import net.benji.fruittrees.item.FruitTreesItems;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Function;

public class FruitTreesBlocks {
    public static final Block MANGO_LEAVES = leavesBlock("mango_leaves");
    public static final Block FLOWERING_MANGO_LEAVES = leavesBlock("flowering_mango_leaves");
    //public static final Block MANGO_SAPLING = null;
    //public static final Block POTTED_MANGO_SAPLING = flowerPotBlock("potted_mango_sapling", MANGO_SAPLING);

    public static final Block POMEGRANATE_LEAVES = leavesBlock("pomegranate_leaves");
    public static final Block FLOWERING_POMEGRANATE_LEAVES = leavesBlock("flowering_pomnegranate_sapling");
    //public static final Block POMEGRANATE_SAPLING = null;
    //public static final Block POTTED_POMEGRANATE_SAPLING = flowerPotBlock("potted_pomegranate_sapling", POMEGRANATE_SAPLING);

    public static final Block PINEAPPLE_LEAVES = leavesBlock("pineapple_leaves");
    public static final Block FLOWERING_PINEAPPLE_LEAVES = leavesBlock("flowering_pineapple_leaves");
    //public static final Block PINEAPPLE_SAPLING = null;
    //public static final Block POTTED_PINEAPPLE_SAPLING = flowerPotBlock("potted_pineapple_sapling", PINEAPPLE_SAPLING);

    public static final Block DRAGON_FRUIT_LEAVES = leavesBlock("dragon_fruit_leaves");
    public static final Block FLOWERING_DRAGON_FRUIT_LEAVES = leavesBlock("flowering_dragon_fruit_leaves");
    //public static final Block DRAGON_FRUIT_SAPLING = null;
    //public static final Block POTTED_DRAGON_FRUIT_SAPLING = flowerPotBlock("potted_dragon_fruit_sapling", DRAGON_FRUIT_SAPLING);

    public static final Block PEAR_LEAVES = leavesBlock("pear_leaves");
    public static final Block FLOWERING_PEAR_LEAVES = leavesBlock("flowering_pear_leaves");
    //public static final Block PEAR_SAPLING = null;
    //public static final Block POTTED_PEAR_SAPLING = flowerPotBlock("potted_pear_sapling", PEAR_SAPLING);

    public static final Block HONEYDEW = registerBlock(
            "honeydew",
            HoneydewBlock::new,
            BlockBehaviour.Properties.copy(Blocks.MELON)
    );
    public static final Block HONEYDEW_STEM = registerBlock(
            "honeydew_stem",
            properties -> new StemBlock((StemGrownBlock) HONEYDEW, () -> FruitTreesItems.HONEYDEW_SEEDS, properties),
            BlockBehaviour.Properties.copy(Blocks.MELON_STEM)
    );
    public static final Block ATTACHED_HONEYDEW_STEM = registerBlock(
            "attached_honeydew_stem",
            properties -> new AttachedStemBlock((StemGrownBlock) HONEYDEW, () -> FruitTreesItems.HONEYDEW_SEEDS, properties),
            BlockBehaviour.Properties.copy(Blocks.ATTACHED_MELON_STEM)
    );

    public static final Block CANTALOUPE = registerBlock(
            "cantaloupe",
            CantaloupeBlock::new,
            BlockBehaviour.Properties.copy(Blocks.MELON)
    );
    public static final Block CANTALOUPE_STEM = registerBlock(
            "cantaloupe_stem",
            properties -> new StemBlock((StemGrownBlock) CANTALOUPE, () -> FruitTreesItems.CANTALOUPE_SEEDS, properties),
            BlockBehaviour.Properties.copy(Blocks.MELON_STEM)
    );
    public static final Block ATTACHED_CANTALOUPE_STEM = registerBlock(
            "attached_cantaloupe_stem",
            properties -> new AttachedStemBlock((StemGrownBlock) CANTALOUPE, () -> FruitTreesItems.CANTALOUPE_SEEDS, properties),
            BlockBehaviour.Properties.copy(Blocks.ATTACHED_MELON_STEM)
    );

    public static final Block BLUEBERRY_BUSH = registerBlock(
            "blueberry_bush",
            properties -> new DynamicBushBlock(properties, () -> FruitTreesItems.BLUEBERRIES),
            BlockBehaviour.Properties.copy(Blocks.SWEET_BERRY_BUSH),
            false
    );
    public static final Block CRANBERRY_BUSH = registerBlock(
            "cranberry_bush",
            properties -> new DynamicBushBlock(properties, () -> FruitTreesItems.CRANBERRIES),
            BlockBehaviour.Properties.copy(Blocks.SWEET_BERRY_BUSH),
            false
    );
    public static final Block HOT_PEPPER_BUSH = registerBlock(
            "hot_pepper_bush",
            properties -> new DynamicBushBlock(properties, () -> FruitTreesItems.HOT_PEPPER, () -> FruitTreesItems.HOT_PEPPER_SEEDS),
            BlockBehaviour.Properties.copy(Blocks.SWEET_BERRY_BUSH),
            false
    );

    public static Block logBlock(String key, MapColor mapColor) {
        return registerBlock(key,
                RotatedPillarBlock::new,
                BlockBehaviour.Properties.of()
                .mapColor(mapColor)
                .instrument(NoteBlockInstrument.BASS)
                .strength(2.0F)
                .sound(SoundType.WOOD)
                .ignitedByLava());
    }

    public static Block plankLikeBlock(String key, Function<BlockBehaviour.Properties, Block> blockFactory, MapColor mapColor) {
        return registerBlock(key,
                blockFactory,
                BlockBehaviour.Properties.of()
                        .mapColor(mapColor)
                        .instrument(NoteBlockInstrument.BASS)
                        .strength(2.0F, 3.0F)
                        .sound(SoundType.WOOD)
                        .ignitedByLava());
    }

    public static Block fenceGateBlock(String key, WoodType woodType, MapColor mapColor) {
        return registerBlock(key,
                properties -> new FenceGateBlock(properties, woodType),
                BlockBehaviour.Properties.of()
                        .mapColor(mapColor)
                        .forceSolidOn()
                        .instrument(NoteBlockInstrument.BASS)
                        .strength(2.0F, 3.0F)
                        .ignitedByLava());
    }

    public static Block doorBlock(String key, BlockSetType blockSetType, MapColor mapColor) {
        return registerBlock(key,
                properties -> new DoorBlock(properties, blockSetType),
                BlockBehaviour.Properties.of()
                        .mapColor(mapColor)
                        .instrument(NoteBlockInstrument.BASS)
                        .strength(3.0F)
                        .noOcclusion()
                        .ignitedByLava()
                        .pushReaction(PushReaction.DESTROY));
    }

    public static Block trapDoorBlock(String key, BlockSetType blockSetType, MapColor mapColor) {
        return registerBlock(key,
                properties -> new TrapDoorBlock(properties, blockSetType),
                BlockBehaviour.Properties.of()
                        .mapColor(mapColor)
                        .instrument(NoteBlockInstrument.BASS)
                        .strength(3.0F)
                        .noOcclusion()
                        .isValidSpawn(Blocks::never)
                        .ignitedByLava());
    }

    public static Block buttonBlock(String key, BlockSetType blockSetType) {
        return registerBlock(key,
                properties -> new ButtonBlock(properties, blockSetType, 30, true),
                BlockBehaviour.Properties.of()
                        .noCollission()
                        .strength(0.5F)
                        .pushReaction(PushReaction.DESTROY));
    }

    public static Block pressurePlateBlock(String key, BlockSetType blockSetType, MapColor mapColor) {
        return registerBlock(key,
                properties -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, properties, blockSetType),
                BlockBehaviour.Properties.of()
                        .mapColor(mapColor)
                        .forceSolidOn()
                        .instrument(NoteBlockInstrument.BASS)
                        .noCollission()
                        .strength(0.5F)
                        .ignitedByLava()
                        .pushReaction(PushReaction.DESTROY));
    }

    public static Block signBlock(String key, WoodType woodType, MapColor mapColor) {
        return registerBlock(key,
                properties -> new FruitTreesStandingSignBlock(properties, woodType),
                BlockBehaviour.Properties.of()
                        .mapColor(mapColor)
                        .forceSolidOn()
                        .instrument(NoteBlockInstrument.BASS)
                        .noCollission()
                        .strength(1.0F)
                        .ignitedByLava(),
                false);
    }

    public static Block wallSignBlock(String key, WoodType woodType, MapColor mapColor, Block dropsLike) {
        return registerBlock(key,
                properties -> new FruitTreesWallSignBlock(properties, woodType),
                BlockBehaviour.Properties.of()
                        .mapColor(mapColor)
                        .forceSolidOn()
                        .instrument(NoteBlockInstrument.BASS)
                        .noCollission()
                        .strength(1.0F)
                        .dropsLike(dropsLike)
                        .ignitedByLava(),
                false);
    }

    public static Block hangingSignBlock(String key, WoodType woodType, MapColor mapColor) {
        return registerBlock(key,
                properties -> new FruitTreesCeilingHangingSignBlock(properties, woodType),
                BlockBehaviour.Properties.of()
                        .mapColor(mapColor)
                        .forceSolidOn()
                        .instrument(NoteBlockInstrument.BASS)
                        .noCollission()
                        .strength(1.0F)
                        .ignitedByLava(),
                false);
    }

    public static Block wallHangingSignBlock(String key, WoodType woodType, MapColor mapColor, Block dropsLike) {
        return registerBlock(key,
                properties -> new FruitTreesWallHangingSignBlock(properties, woodType),
                BlockBehaviour.Properties.of()
                        .mapColor(mapColor)
                        .forceSolidOn()
                        .instrument(NoteBlockInstrument.BASS)
                        .noCollission()
                        .strength(1.0F)
                        .ignitedByLava()
                        .dropsLike(dropsLike),
                false);
    }

    public static Block leavesBlock(String key) {
        return registerBlock(
                key,
                LeavesBlock::new,
                BlockBehaviour.Properties.of()
                        .mapColor(MapColor.PLANT)
                        .strength(0.2F)
                        .randomTicks()
                        .sound(SoundType.GRASS)
                        .noOcclusion()
                        .isValidSpawn(Blocks::ocelotOrParrot)
                        .isSuffocating(Blocks::never)
                        .isViewBlocking(Blocks::never)
                        .ignitedByLava()
                        .pushReaction(PushReaction.DESTROY)
                        .isRedstoneConductor(Blocks::never)
        );
    }

    public static Block flowerPotBlock(String key, Block saplingBlock) {
        return registerBlock(
                key,
                properties -> new FlowerPotBlock(saplingBlock, properties),
                BlockBehaviour.Properties.of()
                        .instabreak()
                        .noOcclusion()
                        .pushReaction(PushReaction.DESTROY),
                false
        );
    }

    public static Block registerBlock(String key, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties) {
        return registerBlock(key, blockFactory, properties, true);
    }

    public static Block registerBlock(String key, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties, boolean registerItem) {
        ResourceLocation resourceLocation = new ResourceLocation(FruitTrees.MOD_ID, key);
        Block block = blockFactory.apply(properties);
        if (registerItem) {
            BlockItem blockItem = new BlockItem(block, new Item.Properties());
            Registry.register(BuiltInRegistries.ITEM, resourceLocation, blockItem);
        }

        return Registry.register(BuiltInRegistries.BLOCK, resourceLocation, block);
    }

    public static void registerBlocks() {
        FruitTrees.LOGGER.info("Registering blocks for " + FruitTrees.MOD_NAME);
    }
}
