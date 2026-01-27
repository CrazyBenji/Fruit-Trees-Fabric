package net.benji.fruittrees.block.custom;

import net.benji.fruittrees.block.entity.FruitTreesHangingSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import org.jetbrains.annotations.NotNull;

public class FruitTreesCeilingHangingSignBlock extends CeilingHangingSignBlock {
    public FruitTreesCeilingHangingSignBlock(BlockBehaviour.Properties properties, WoodType woodType) {
        super(properties, woodType);
    }

    @Override
    public @NotNull BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new FruitTreesHangingSignBlockEntity(blockPos, blockState);
    }
}