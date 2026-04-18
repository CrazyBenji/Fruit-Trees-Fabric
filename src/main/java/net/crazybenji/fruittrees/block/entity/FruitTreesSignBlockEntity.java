package net.crazybenji.fruittrees.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class FruitTreesSignBlockEntity extends SignBlockEntity {
    public FruitTreesSignBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(blockPos, blockState);
    }

    @Override
    public @NotNull BlockEntityType<?> getType() {
        return FruitTreesBlockEntities.FRUIT_TREES_SIGN_BLOCK_ENTITY;
    }
}