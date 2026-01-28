package net.benji.fruittrees.block;

import net.benji.fruittrees.FruitTrees;
import net.benji.fruittrees.block.custom.FruitTreesCeilingHangingSignBlock;
import net.benji.fruittrees.block.custom.FruitTreesStandingSignBlock;
import net.benji.fruittrees.block.custom.FruitTreesWallHangingSignBlock;
import net.benji.fruittrees.block.custom.FruitTreesWallSignBlock;
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
