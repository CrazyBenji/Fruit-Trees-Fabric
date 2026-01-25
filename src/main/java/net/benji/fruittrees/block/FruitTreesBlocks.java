package net.benji.fruittrees.block;

import net.benji.fruittrees.FruitTrees;
import net.benji.fruittrees.util.FruitTreesBlockSetTypes;
import net.benji.fruittrees.util.FruitTreesWoodTypes;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Function;

public class FruitTreesBlocks {
    // Mango Blocks
    public static final Block MANGO_LOG = registerWoodBlock("mango_log",
            RotatedPillarBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(blockState -> blockState.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MapColor.COLOR_YELLOW : MapColor.TERRACOTTA_YELLOW)
                    .strength(2.0F));
    public static final Block STRIPPED_MANGO_LOG = registerWoodBlock("stripped_mango_log",
            RotatedPillarBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_YELLOW)
                    .strength(2.0F));
    public static final Block MANGO_WOOD = registerWoodBlock("mango_wood",
            RotatedPillarBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.TERRACOTTA_YELLOW)
                    .strength(2.0F));
    public static final Block STRIPPED_MANGO_WOOD = registerWoodBlock("stripped_mango_wood",
            RotatedPillarBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_YELLOW)
                    .strength(2.0F));
    public static final Block MANGO_PLANKS = registerWoodBlock("mango_planks",
            Block::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_YELLOW)
                    .strength(2.0F, 3.0F));
    public static final Block MANGO_SLAB = registerWoodBlock("mango_slab",
            SlabBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_YELLOW)
                    .strength(2.0F, 3.0F));
    public static final Block MANGO_STAIRS = registerBlock("mango_stairs",
            properties -> new StairBlock(MANGO_PLANKS.defaultBlockState(), properties),
            BlockBehaviour.Properties.copy(MANGO_PLANKS));
    public static final Block MANGO_FENCE = registerWoodBlock("mango_fence",
            FenceBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MANGO_PLANKS.defaultMapColor())
                    .strength(2.0F, 3.0F));
    public static final Block MANGO_FENCE_GATE = registerWoodBlock("mango_fence_gate",
            properties -> new FenceGateBlock(properties, FruitTreesWoodTypes.MANGO),
            BlockBehaviour.Properties.of()
                    .mapColor(MANGO_PLANKS.defaultMapColor())
                    .forceSolidOn()
                    .strength(2.0F, 3.0F));
    public static final Block MANGO_DOOR = registerBlock("mango_door",
            properties -> new DoorBlock(properties, FruitTreesBlockSetTypes.MANGO),
            BlockBehaviour.Properties.of()
                    .mapColor(MANGO_PLANKS.defaultMapColor())
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(3.0F)
                    .noOcclusion()
                    .ignitedByLava()
                    .pushReaction(PushReaction.DESTROY));
    public static final Block MANGO_TRAPDOOR = registerBlock("mango_trapdoor",
            properties -> new TrapDoorBlock(properties, FruitTreesBlockSetTypes.MANGO),
            BlockBehaviour.Properties.of()
                    .mapColor(MANGO_PLANKS.defaultMapColor())
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(3.0F)
                    .noOcclusion()
                    .isValidSpawn(Blocks::never)
                    .ignitedByLava());
    public static final Block MANGO_BUTTON = registerBlock("mango_button",
            properties -> new ButtonBlock(properties, FruitTreesBlockSetTypes.MANGO, 30, true),
            BlockBehaviour.Properties.of()
                    .noOcclusion()
                    .strength(0.5F)
                    .pushReaction(PushReaction.DESTROY));
    public static final Block MANGO_PRESSURE_PLATE = registerBlock("mango_pressure_plate",
            properties -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, properties, FruitTreesBlockSetTypes.MANGO),
            BlockBehaviour.Properties.of()
                    .mapColor(MANGO_PLANKS.defaultMapColor())
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollission()
                    .strength(0.5F)
                    .ignitedByLava()
                    .pushReaction(PushReaction.DESTROY));

    public static Block registerWoodBlock(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties) {
        properties.instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).ignitedByLava();
        return registerBlock(name, blockFactory, properties);
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
