package net.crazybenji.fruittrees.block.custom;

import net.crazybenji.fruittrees.block.FruitTreesBlocks;
import net.minecraft.world.level.block.AttachedStemBlock;
import net.minecraft.world.level.block.StemBlock;
import net.minecraft.world.level.block.StemGrownBlock;
import org.jetbrains.annotations.NotNull;

public class HoneydewBlock extends StemGrownBlock {

    public HoneydewBlock(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull StemBlock getStem() {
        return (StemBlock) FruitTreesBlocks.HONEYDEW_STEM;
    }

    @Override
    public @NotNull AttachedStemBlock getAttachedStem() {
        return (AttachedStemBlock) FruitTreesBlocks.ATTACHED_HONEYDEW_STEM;
    }
}
