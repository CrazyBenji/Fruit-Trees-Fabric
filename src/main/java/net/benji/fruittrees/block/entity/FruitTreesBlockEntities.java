package net.benji.fruittrees.block.entity;

import net.benji.fruittrees.FruitTrees;
import net.benji.fruittrees.block.FruitTreesBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class FruitTreesBlockEntities {
    public static final BlockEntityType<FruitTreesSignBlockEntity> FRUIT_TREES_SIGN_BLOCK_ENTITY = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE,
            new ResourceLocation(FruitTrees.MOD_ID, "fruit_trees_sign_entity"),
            FabricBlockEntityTypeBuilder.create(FruitTreesSignBlockEntity::new,
                    FruitTreesBlocks.MANGO_SIGN, FruitTreesBlocks.MANGO_WALL_SIGN).build());

    public static final BlockEntityType<FruitTreesHangingSignBlockEntity> FRUIT_TREES_HANGING_SIGN_BLOCK_ENTITY = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE,
            new ResourceLocation(FruitTrees.MOD_ID, "fruit_trees_hanging_sign_entity"),
            FabricBlockEntityTypeBuilder.create(FruitTreesHangingSignBlockEntity::new,
                    FruitTreesBlocks.MANGO_HANGING_SIGN, FruitTreesBlocks.MANGO_WALL_HANGING_SIGN).build(null));

    public static void registerBlockEntities() {
        FruitTrees.LOGGER.info("Registering block entities for " + FruitTrees.MOD_NAME);
    }
}
