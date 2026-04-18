package net.crazybenji.fruittrees.block.custom;

import net.crazybenji.fruittrees.block.entity.FruitTreesHangingSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import org.jetbrains.annotations.NotNull;

public class FruitTreesWallHangingSignBlock extends WallHangingSignBlock {
    public FruitTreesWallHangingSignBlock(BlockBehaviour.Properties properties, WoodType woodType) {
        super(properties, woodType);
    }

    @Override
    public @NotNull BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new FruitTreesHangingSignBlockEntity(blockPos, blockState);
    }
}