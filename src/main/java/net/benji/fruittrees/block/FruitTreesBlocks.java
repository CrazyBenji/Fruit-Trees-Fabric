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

    // Mango Blocks
    public static final Block MANGO_LOG = registerLogBlock(
            "mango_log",
            MANGO_MAP_COLOR
    );
    public static final Block STRIPPED_MANGO_LOG = registerLogBlock(
            "stripped_mango_log",
            MANGO_MAP_COLOR
    );
    public static final Block MANGO_WOOD = registerLogBlock(
            "mango_wood",
            MANGO_MAP_COLOR
    );
    public static final Block STRIPPED_MANGO_WOOD = registerLogBlock(
            "stripped_mango_wood",
            MANGO_MAP_COLOR
    );
    public static final Block MANGO_PLANKS = registerPlankLikeBlock(
            "mango_planks",
            Block::new,
            MANGO_MAP_COLOR
    );
    public static final Block MANGO_SLAB = registerPlankLikeBlock(
            "mango_slab",
            SlabBlock::new,
            MANGO_MAP_COLOR
    );
    public static final Block MANGO_STAIRS = registerPlankLikeBlock(
            "mango_stairs",
            properties -> new StairBlock(MANGO_PLANKS.defaultBlockState(), properties),
            MANGO_MAP_COLOR
    );
    public static final Block MANGO_FENCE = registerPlankLikeBlock(
            "mango_fence",
            FenceBlock::new,
            MANGO_MAP_COLOR
    );
    public static final Block MANGO_FENCE_GATE = registerFenceGateBlock(
            "mango_fence_gate",
            FruitTreesWoodTypes.MANGO,
            MANGO_MAP_COLOR
    );
    public static final Block MANGO_DOOR = registerDoorBlock(
            "mango_door",
            FruitTreesBlockSetTypes.MANGO,
            MANGO_MAP_COLOR
    );
    public static final Block MANGO_TRAPDOOR = registerTrapDoorBlock(
            "mango_trapdoor",
            FruitTreesBlockSetTypes.MANGO,
            MANGO_MAP_COLOR
    );
    public static final Block MANGO_BUTTON = registerButtonBlock(
            "mango_button",
            FruitTreesBlockSetTypes.MANGO
    );
    public static final Block MANGO_PRESSURE_PLATE = registerPressurePlateBlock(
            "mango_pressure_plate",
            FruitTreesBlockSetTypes.MANGO,
            MANGO_MAP_COLOR
    );
    public static final Block MANGO_SIGN = registerSignBlock(
            "mango_sign",
            FruitTreesWoodTypes.MANGO,
            MANGO_MAP_COLOR
    );
    public static final Block MANGO_WALL_SIGN = registerWallSignBlock(
            "mango_wall_sign",
            FruitTreesWoodTypes.MANGO,
            MANGO_MAP_COLOR,
            MANGO_SIGN
            );
    public static final Block MANGO_HANGING_SIGN = registerHangingSignBlock(
            "mango_hanging_sign",
            FruitTreesWoodTypes.MANGO,
            MANGO_MAP_COLOR
    );
    public static final Block MANGO_WALL_HANGING_SIGN = registerWallHangingSignBlock(
            "mango_wall_hanging_sign",
            FruitTreesWoodTypes.MANGO,
            MANGO_MAP_COLOR,
            MANGO_HANGING_SIGN
    );

    public static Block registerLogBlock(String name, MapColor color) {
        return registerBlock(name,
                RotatedPillarBlock::new,
                BlockBehaviour.Properties.of()
                .mapColor(color)
                .instrument(NoteBlockInstrument.BASS)
                .strength(2.0F)
                .sound(SoundType.WOOD)
                .ignitedByLava());
    }

    public static Block registerPlankLikeBlock(String name, Function<BlockBehaviour.Properties, Block> blockFactory, MapColor color) {
        return registerBlock(name,
                blockFactory,
                BlockBehaviour.Properties.of()
                        .mapColor(color)
                        .instrument(NoteBlockInstrument.BASS)
                        .strength(2.0F, 3.0F)
                        .sound(SoundType.WOOD)
                        .ignitedByLava());
    }

    public static Block registerFenceGateBlock(String name, WoodType woodType, MapColor color) {
        return registerBlock(name,
                properties -> new FenceGateBlock(properties, woodType),
                BlockBehaviour.Properties.of()
                        .mapColor(color)
                        .forceSolidOn()
                        .instrument(NoteBlockInstrument.BASS)
                        .strength(2.0F, 3.0F)
                        .ignitedByLava());
    }

    public static Block registerDoorBlock(String name, BlockSetType blockSetType, MapColor color) {
        return registerBlock(name,
                properties -> new DoorBlock(properties, blockSetType),
                BlockBehaviour.Properties.of()
                        .mapColor(color)
                        .instrument(NoteBlockInstrument.BASS)
                        .strength(3.0F)
                        .noOcclusion()
                        .ignitedByLava()
                        .pushReaction(PushReaction.DESTROY));
    }

    public static Block registerTrapDoorBlock(String name, BlockSetType blockSetType, MapColor color) {
        return registerBlock(name,
                properties -> new TrapDoorBlock(properties, blockSetType),
                BlockBehaviour.Properties.of()
                        .mapColor(color)
                        .instrument(NoteBlockInstrument.BASS)
                        .strength(3.0F)
                        .noOcclusion()
                        .isValidSpawn(Blocks::never)
                        .ignitedByLava());
    }

    public static Block registerButtonBlock(String name, BlockSetType blockSetType) {
        return registerBlock(name,
                properties -> new ButtonBlock(properties, blockSetType, 30, true),
                BlockBehaviour.Properties.of()
                        .noCollission()
                        .strength(0.5F)
                        .pushReaction(PushReaction.DESTROY));
    }

    public static Block registerPressurePlateBlock(String name, BlockSetType blockSetType, MapColor color) {
        return registerBlock(name,
                properties -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, properties, blockSetType),
                BlockBehaviour.Properties.of()
                        .mapColor(color)
                        .forceSolidOn()
                        .instrument(NoteBlockInstrument.BASS)
                        .noCollission()
                        .strength(0.5F)
                        .ignitedByLava()
                        .pushReaction(PushReaction.DESTROY));
    }

    public static Block registerSignBlock(String name, WoodType woodType, MapColor color) {
        return registerBlock(name,
                properties -> new FruitTreesStandingSignBlock(properties, woodType),
                BlockBehaviour.Properties.of()
                        .mapColor(color)
                        .forceSolidOn()
                        .instrument(NoteBlockInstrument.BASS)
                        .noCollission()
                        .strength(1.0F)
                        .ignitedByLava(),
                false);
    }

    public static Block registerWallSignBlock(String name, WoodType woodType, MapColor color, Block dropsLike) {
        return registerBlock(name,
                properties -> new FruitTreesWallSignBlock(properties, woodType),
                BlockBehaviour.Properties.of()
                        .mapColor(color)
                        .forceSolidOn()
                        .instrument(NoteBlockInstrument.BASS)
                        .noCollission()
                        .strength(1.0F)
                        .dropsLike(dropsLike)
                        .ignitedByLava(),
                false);
    }

    public static Block registerHangingSignBlock(String name, WoodType woodType, MapColor color) {
        return registerBlock(name,
                properties -> new FruitTreesCeilingHangingSignBlock(properties, woodType),
                BlockBehaviour.Properties.of()
                        .mapColor(color)
                        .forceSolidOn()
                        .instrument(NoteBlockInstrument.BASS)
                        .noCollission()
                        .strength(1.0F)
                        .ignitedByLava(),
                false);
    }

    public static Block registerWallHangingSignBlock(String name, WoodType woodType, MapColor color, Block dropsLike) {
        return registerBlock(name,
                properties -> new FruitTreesWallHangingSignBlock(properties, woodType),
                BlockBehaviour.Properties.of()
                        .mapColor(color)
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
