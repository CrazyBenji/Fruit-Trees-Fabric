package net.benji.fruittrees.block.custom;

import net.benji.fruittrees.block.FruitTreesBlocks;
import net.minecraft.world.level.block.AttachedStemBlock;
import net.minecraft.world.level.block.StemBlock;
import net.minecraft.world.level.block.StemGrownBlock;
import org.jetbrains.annotations.NotNull;

public class CantaloupeBlock extends StemGrownBlock {
    public CantaloupeBlock(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull StemBlock getStem() {
        return (StemBlock) FruitTreesBlocks.CANTALOUPE_STEM;
    }

    @Override
    public @NotNull AttachedStemBlock getAttachedStem() {
        return (AttachedStemBlock) FruitTreesBlocks.ATTACHED_CANTALOUPE_STEM;
    }
}
