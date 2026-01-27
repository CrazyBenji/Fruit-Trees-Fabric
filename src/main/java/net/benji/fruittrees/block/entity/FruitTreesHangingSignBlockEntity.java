package net.benji.fruittrees.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.HangingSignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class FruitTreesHangingSignBlockEntity extends HangingSignBlockEntity {
    public FruitTreesHangingSignBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(blockPos, blockState);
    }

    @Override
    public @NotNull BlockEntityType<?> getType() {
        return FruitTreesBlockEntities.FRUIT_TREES_HANGING_SIGN_BLOCK_ENTITY;
    }
}