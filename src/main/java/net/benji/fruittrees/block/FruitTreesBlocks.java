package net.benji.fruittrees.block;

import net.benji.fruittrees.FruitTrees;
import net.benji.fruittrees.block.custom.FruitTreesCeilingHangingSignBlock;
import net.benji.fruittrees.block.custom.FruitTreesStandingSignBlock;
import net.benji.fruittrees.block.custom.FruitTreesWallHangingSignBlock;
import net.benji.fruittrees.block.custom.FruitTreesWallSignBlock;
import net.benji.fruittrees.util.FruitTreesBlockSetTypes;
import net.benji.fruittrees.util.FruitTreesWoodTypes;
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
    public static final MapColor MANGO_MAP_COLOR = MapColor.TERRACOTTA_YELLOW;
    public static final MapColor POMEGRANATE_MAP_COLOR = MapColor.COLOR_PURPLE;

    // Mango Blocks
    public static final Block MANGO_LOG = logBlock(
            "mango_log",
            MANGO_MAP_COLOR
    );
    public static final Block STRIPPED_MANGO_LOG = logBlock(
            "stripped_mango_log",
            MANGO_MAP_COLOR
    );
    public static final Block MANGO_WOOD = logBlock(
            "mango_wood",
            MANGO_MAP_COLOR
    );
    public static final Block STRIPPED_MANGO_WOOD = logBlock(
            "stripped_mango_wood",
            MANGO_MAP_COLOR
    );
    public static final Block MANGO_PLANKS = plankLikeBlock(
            "mango_planks",
            Block::new,
            MANGO_MAP_COLOR
    );
    public static final Block MANGO_SLAB = plankLikeBlock(
            "mango_slab",
            SlabBlock::new,
            MANGO_MAP_COLOR
    );
    public static final Block MANGO_STAIRS = plankLikeBlock(
            "mango_stairs",
            properties -> new StairBlock(MANGO_PLANKS.defaultBlockState(), properties),
            MANGO_MAP_COLOR
    );
    public static final Block MANGO_FENCE = plankLikeBlock(
            "mango_fence",
            FenceBlock::new,
            MANGO_MAP_COLOR
    );
    public static final Block MANGO_FENCE_GATE = fenceGateBlock(
            "mango_fence_gate",
            FruitTreesWoodTypes.MANGO,
            MANGO_MAP_COLOR
    );
    public static final Block MANGO_DOOR = doorBlock(
            "mango_door",
            FruitTreesBlockSetTypes.MANGO,
            MANGO_MAP_COLOR
    );
    public static final Block MANGO_TRAPDOOR = trapDoorBlock(
            "mango_trapdoor",
            FruitTreesBlockSetTypes.MANGO,
            MANGO_MAP_COLOR
    );
    public static final Block MANGO_BUTTON = buttonBlock(
            "mango_button",
            FruitTreesBlockSetTypes.MANGO
    );
    public static final Block MANGO_PRESSURE_PLATE = pressurePlateBlock(
            "mango_pressure_plate",
            FruitTreesBlockSetTypes.MANGO,
            MANGO_MAP_COLOR
    );
    public static final Block MANGO_SIGN = signBlock(
            "mango_sign",
            FruitTreesWoodTypes.MANGO,
            MANGO_MAP_COLOR
    );
    public static final Block MANGO_WALL_SIGN = wallSignBlock(
            "mango_wall_sign",
            FruitTreesWoodTypes.MANGO,
            MANGO_MAP_COLOR,
            MANGO_SIGN
            );
    public static final Block MANGO_HANGING_SIGN = hangingSignBlock(
            "mango_hanging_sign",
            FruitTreesWoodTypes.MANGO,
            MANGO_MAP_COLOR
    );
    public static final Block MANGO_WALL_HANGING_SIGN = wallHangingSignBlock(
            "mango_wall_hanging_sign",
            FruitTreesWoodTypes.MANGO,
            MANGO_MAP_COLOR,
            MANGO_HANGING_SIGN
    );

    // Pomegranate Blocks
    private static final Block[] POMEGRANATE_BLOCKS = registerFruitWood("pomegranate", POMEGRANATE_MAP_COLOR, FruitTreesWoodTypes.POMEGRANATE, FruitTreesBlockSetTypes.POMEGRANATE);
    public static final Block POMEGRANATE_LOG = POMEGRANATE_BLOCKS[0];
    public static final Block STRIPPED_POMEGRANATE_LOG = POMEGRANATE_BLOCKS[1];
    public static final Block POMEGRANATE_WOOD = POMEGRANATE_BLOCKS[2];
    public static final Block STRIPPED_POMEGRANATE_WOOD = POMEGRANATE_BLOCKS[3];
    public static final Block POMEGRANATE_PLANKS = POMEGRANATE_BLOCKS[4];
    public static final Block POMEGRANATE_SLAB = POMEGRANATE_BLOCKS[5];
    public static final Block POMEGRANATE_STAIRS = POMEGRANATE_BLOCKS[6];
    public static final Block POMEGRANATE_FENCE = POMEGRANATE_BLOCKS[7];
    public static final Block POMEGRANATE_FENCE_GATE = POMEGRANATE_BLOCKS[8];
    public static final Block POMEGRANATE_DOOR = POMEGRANATE_BLOCKS[9];
    public static final Block POMEGRANATE_TRAPDOOR = POMEGRANATE_BLOCKS[10];
    public static final Block POMEGRANATE_BUTTON = POMEGRANATE_BLOCKS[11];
    public static final Block POMEGRANATE_PRESSURE_PLATE = POMEGRANATE_BLOCKS[12];
    public static final Block POMEGRANATE_SIGN = POMEGRANATE_BLOCKS[13];
    public static final Block POMEGRANATE_WALL_SIGN = POMEGRANATE_BLOCKS[14];
    public static final Block POMEGRANATE_HANGING_SIGN = POMEGRANATE_BLOCKS[15];
    public static final Block POMEGRANATE_WALL_HANGING_SIGN = POMEGRANATE_BLOCKS[16];

    // Provides a template for my Fruit Wood Type
    public static Block[] registerFruitWood(String fruitName, MapColor mapColor, WoodType woodType, BlockSetType blockSetType) {
        Block[] fruitBlocks = new Block[17];
        fruitBlocks[0] = logBlock(fruitName + "_log", mapColor);
        fruitBlocks[1] = logBlock("stripped_" + fruitName + "_log", mapColor);
        fruitBlocks[2] = logBlock(fruitName + "_wood", mapColor);
        fruitBlocks[3] = logBlock("stripped_" + fruitName + "_wood", mapColor);
        fruitBlocks[4] = plankLikeBlock(fruitName + "_planks", Block::new, mapColor);
        fruitBlocks[5] = plankLikeBlock(fruitName + "_slab", SlabBlock::new, mapColor);
        fruitBlocks[6] = plankLikeBlock(fruitName + "_stairs", properties -> new StairBlock(fruitBlocks[4].defaultBlockState(), properties), mapColor);
        fruitBlocks[7] = plankLikeBlock(fruitName + "_fence", FenceBlock::new, mapColor);
        fruitBlocks[8] = fenceGateBlock(fruitName + "_fence_gate", woodType, mapColor);
        fruitBlocks[9] = doorBlock(fruitName + "_door", blockSetType, mapColor);
        fruitBlocks[10] = trapDoorBlock(fruitName + "_trapdoor", blockSetType, mapColor);
        fruitBlocks[11] = buttonBlock(fruitName + "_button", blockSetType);
        fruitBlocks[12] = pressurePlateBlock(fruitName + "_pressure_plate", blockSetType, mapColor);
        fruitBlocks[13] = signBlock(fruitName + "_sign", woodType, mapColor);
        fruitBlocks[14] = wallSignBlock(fruitName + "_wall_sign", woodType, mapColor, fruitBlocks[13]);
        fruitBlocks[15] = hangingSignBlock(fruitName + "_hanging_sign", woodType, mapColor);
        fruitBlocks[16] = wallHangingSignBlock(fruitName + "_wall_hanging_sign", woodType, mapColor, fruitBlocks[15]);

        return fruitBlocks;
    }

    public static Block logBlock(String name, MapColor mapColor) {
        return registerBlock(name,
                RotatedPillarBlock::new,
                BlockBehaviour.Properties.of()
                .mapColor(mapColor)
                .instrument(NoteBlockInstrument.BASS)
                .strength(2.0F)
                .sound(SoundType.WOOD)
                .ignitedByLava());
    }

    public static Block plankLikeBlock(String name, Function<BlockBehaviour.Properties, Block> blockFactory, MapColor mapColor) {
        return registerBlock(name,
                blockFactory,
                BlockBehaviour.Properties.of()
                        .mapColor(mapColor)
                        .instrument(NoteBlockInstrument.BASS)
                        .strength(2.0F, 3.0F)
                        .sound(SoundType.WOOD)
                        .ignitedByLava());
    }

    public static Block fenceGateBlock(String name, WoodType woodType, MapColor mapColor) {
        return registerBlock(name,
                properties -> new FenceGateBlock(properties, woodType),
                BlockBehaviour.Properties.of()
                        .mapColor(mapColor)
                        .forceSolidOn()
                        .instrument(NoteBlockInstrument.BASS)
                        .strength(2.0F, 3.0F)
                        .ignitedByLava());
    }

    public static Block doorBlock(String name, BlockSetType blockSetType, MapColor mapColor) {
        return registerBlock(name,
                properties -> new DoorBlock(properties, blockSetType),
                BlockBehaviour.Properties.of()
                        .mapColor(mapColor)
                        .instrument(NoteBlockInstrument.BASS)
                        .strength(3.0F)
                        .noOcclusion()
                        .ignitedByLava()
                        .pushReaction(PushReaction.DESTROY));
    }

    public static Block trapDoorBlock(String name, BlockSetType blockSetType, MapColor mapColor) {
        return registerBlock(name,
                properties -> new TrapDoorBlock(properties, blockSetType),
                BlockBehaviour.Properties.of()
                        .mapColor(mapColor)
                        .instrument(NoteBlockInstrument.BASS)
                        .strength(3.0F)
                        .noOcclusion()
                        .isValidSpawn(Blocks::never)
                        .ignitedByLava());
    }

    public static Block buttonBlock(String name, BlockSetType blockSetType) {
        return registerBlock(name,
                properties -> new ButtonBlock(properties, blockSetType, 30, true),
                BlockBehaviour.Properties.of()
                        .noCollission()
                        .strength(0.5F)
                        .pushReaction(PushReaction.DESTROY));
    }

    public static Block pressurePlateBlock(String name, BlockSetType blockSetType, MapColor mapColor) {
        return registerBlock(name,
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

    public static Block signBlock(String name, WoodType woodType, MapColor mapColor) {
        return registerBlock(name,
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

    public static Block wallSignBlock(String name, WoodType woodType, MapColor mapColor, Block dropsLike) {
        return registerBlock(name,
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

    public static Block hangingSignBlock(String name, WoodType woodType, MapColor mapColor) {
        return registerBlock(name,
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

    public static Block wallHangingSignBlock(String name, WoodType woodType, MapColor mapColor, Block dropsLike) {
        return registerBlock(name,
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

    public static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties) {
        return registerBlock(name, blockFactory, properties, true);
    }

    public static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties, boolean registerItem) {
        ResourceLocation resourceLocation = new ResourceLocation(FruitTrees.MOD_ID, name);
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
