package net.crazybenji.fruittrees.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import net.crazybenji.fruittrees.FruitTrees;
import net.crazybenji.fruittrees.util.secret.FruitTreesSecretItems;
import net.crazybenji.fruittrees.util.secret.SecretItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.world.item.Item;
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
        for(SecretItem secretItem : FruitTreesSecretItems.SECRET_ITEMS) {
            Item item = secretItem.item();
            String name = secretItem.name();
            String key = secretItem.key();
            if (itemStack.is(item) && itemStack.getHoverName().getString().equals(name)) {
                return Minecraft.getInstance().getModelManager().getModel(
                        new ModelResourceLocation(FruitTrees.MOD_ID, key, "inventory"));
            }
        }

        return bakedModel;
    }

}
