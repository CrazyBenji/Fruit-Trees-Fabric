package net.benji.fruittrees.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import net.benji.fruittrees.FruitTrees;
import net.benji.fruittrees.item.FruitTreesItems;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemRenderer.class)
public class ItemRendererMixin {

    @ModifyVariable(method = "render", at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel useEasterEggModel(BakedModel bakedModel, ItemStack itemStack, ItemDisplayContext itemDisplayContext, boolean leftHanded,
                                        PoseStack poseStack, MultiBufferSource multiBufferSource, int light, int overlay) {
        if (itemStack.is(FruitTreesItems.PEAR) && itemStack.getHoverName().getString().equals("Pearto")) {
            return ((ItemRendererAccessor) this).fruittrees$getModels().getModelManager().getModel(
                    new ModelResourceLocation(FruitTrees.MOD_ID, "pearto", "inventory"));
        }
        if (itemStack.is(FruitTreesItems.PINEAPPLE) && itemStack.getHoverName().getString().equals("Bavid")) {
            return ((ItemRendererAccessor) this).fruittrees$getModels().getModelManager().getModel(
                    new ModelResourceLocation(FruitTrees.MOD_ID, "bavid", "inventory"));
        }
        return bakedModel;
    }

}
