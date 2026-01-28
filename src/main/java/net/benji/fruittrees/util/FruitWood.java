package net.benji.fruittrees.util;

import net.benji.fruittrees.block.FruitTreesBlocks;
import net.benji.fruittrees.item.FruitTreesItems;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;

public class FruitWood {
    public final Block LOG;
    public final Block STRIPPED_LOG;
    public final Block WOOD;
    public final Block STRIPPED_WOOD;
    public final Block PLANKS;
    public final Block SLAB;
    public final Block STAIRS;
    public final Block FENCE;
    public final Block FENCE_GATE;
    public final Block DOOR;
    public final Block TRAPDOOR;
    public final Block BUTTON;
    public final Block PRESSURE_PLATE;
    public final Block SIGN;
    public final Block WALL_SIGN;
    public final Block HANGING_SIGN;
    public final Block WALL_HANGING_SIGN;
    public final Item SIGN_ITEM;
    public final Item HANGING_SIGN_ITEM;
    public final BlockFamily FAMILY;
    public final TagKey<Item> LOGS_ITEM;
    public final TagKey<Block> LOGS_BLOCK;

    @SuppressWarnings("unused")
    public FruitWood(Block log, Block strippedLog, Block wood, Block strippedWood, Block planks, Block slab,
                     Block stairs, Block fence, Block fenceGate, Block door, Block trapdoor, Block button,
                     Block pressurePlate, Block sign, Block wallSign, Block hangingSign, Block wallHangingSign, Item signItem,
                     Item hangingSignItem, TagKey<Item> logsItem, TagKey<Block> logsBlock) {
        this.LOG = log;
        this.STRIPPED_LOG = strippedLog;
        this.WOOD = wood;
        this.STRIPPED_WOOD = strippedWood;
        this.PLANKS = planks;
        this.SLAB = slab;
        this.STAIRS = stairs;
        this.FENCE = fence;
        this.FENCE_GATE = fenceGate;
        this.DOOR = door;
        this.TRAPDOOR = trapdoor;
        this.BUTTON = button;
        this.PRESSURE_PLATE = pressurePlate;
        this.SIGN = sign;
        this.WALL_SIGN = wallSign;
        this.HANGING_SIGN = hangingSign;
        this.WALL_HANGING_SIGN = wallHangingSign;
        this.SIGN_ITEM = signItem;
        this.HANGING_SIGN_ITEM = hangingSignItem;

        this.FAMILY = createFamily();

        this.LOGS_ITEM = logsItem;
        this.LOGS_BLOCK = logsBlock;
    }

    public FruitWood(String fruitKey, MapColor mapColor, WoodType woodType, BlockSetType blockSetType) {
        this.LOG = FruitTreesBlocks.logBlock(fruitKey + "_log", mapColor);
        this.STRIPPED_LOG = FruitTreesBlocks.logBlock("stripped_" + fruitKey + "_log", mapColor);
        this.WOOD = FruitTreesBlocks.logBlock(fruitKey + "_wood", mapColor);
        this.STRIPPED_WOOD = FruitTreesBlocks.logBlock("stripped_" + fruitKey + "_wood", mapColor);
        this.PLANKS = FruitTreesBlocks.plankLikeBlock(fruitKey + "_planks", Block::new, mapColor);
        this.SLAB = FruitTreesBlocks.plankLikeBlock(fruitKey + "_slab", SlabBlock::new, mapColor);
        this.STAIRS = FruitTreesBlocks.plankLikeBlock(fruitKey + "_stairs", properties -> new StairBlock(this.PLANKS.defaultBlockState(), properties), mapColor);
        this.FENCE = FruitTreesBlocks.plankLikeBlock(fruitKey + "_fence", FenceBlock::new, mapColor);
        this.FENCE_GATE = FruitTreesBlocks.fenceGateBlock(fruitKey + "_fence_gate", woodType, mapColor);
        this.DOOR = FruitTreesBlocks.doorBlock(fruitKey + "_door", blockSetType, mapColor);
        this.TRAPDOOR = FruitTreesBlocks.trapDoorBlock(fruitKey + "_trapdoor", blockSetType, mapColor);
        this.BUTTON = FruitTreesBlocks.buttonBlock(fruitKey + "_button", blockSetType);
        this.PRESSURE_PLATE = FruitTreesBlocks.pressurePlateBlock(fruitKey + "_pressure_plate", blockSetType, mapColor);
        this.SIGN = FruitTreesBlocks.signBlock(fruitKey + "_sign", woodType, mapColor);
        this.WALL_SIGN = FruitTreesBlocks.wallSignBlock(fruitKey + "_wall_sign", woodType, mapColor, this.SIGN);
        this.HANGING_SIGN = FruitTreesBlocks.hangingSignBlock(fruitKey + "_hanging_sign", woodType, mapColor);
        this.WALL_HANGING_SIGN = FruitTreesBlocks.wallHangingSignBlock(fruitKey + "_wall_hanging_sign", woodType, mapColor, this.HANGING_SIGN);
        this.SIGN_ITEM = FruitTreesItems.registerItem(
                fruitKey + "_sign",
                properties -> new SignItem(properties, this.SIGN, this.WALL_SIGN),
                new Item.Properties().stacksTo(16)
        );
        this.HANGING_SIGN_ITEM = FruitTreesItems.registerItem(
                fruitKey + "_hanging_sign",
                properties -> new HangingSignItem(this.HANGING_SIGN, this.WALL_HANGING_SIGN, properties),
                new Item.Properties().stacksTo(16)
        );

        this.FAMILY = createFamily();
        this.LOGS_ITEM = FruitTreesTags.Items.createTag(fruitKey + "_logs");
        this.LOGS_BLOCK = FruitTreesTags.Blocks.createTag(fruitKey +"_logs");
    }

    private BlockFamily createFamily() {
        return new BlockFamily.Builder(this.PLANKS)
                .slab(this.SLAB)
                .stairs(this.STAIRS)
                .fence(this.FENCE)
                .fenceGate(this.FENCE_GATE)
                .door(this.DOOR)
                .trapdoor(this.TRAPDOOR)
                .button(this.BUTTON)
                .pressurePlate(this.PRESSURE_PLATE)
                .sign(this.SIGN, this.WALL_SIGN)
                .recipeGroupPrefix("wooden")
                .recipeUnlockedBy(RecipeProvider.getHasName(this.PLANKS))
                .getFamily();
    }
}
