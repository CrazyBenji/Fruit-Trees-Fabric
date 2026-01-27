package net.benji.fruittrees.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import net.benji.fruittrees.FruitTrees;
import net.benji.fruittrees.item.FruitTreesItems;
import net.benji.fruittrees.util.FruitTreesSecretItems;
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
import org.spongepowered.asm.mixin.injection.struct.InjectorGroupInfo;

import java.util.Map;

@Mixin(ItemRenderer.class)
public class ItemRendererMixin {

    @ModifyVariable(method = "render", at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel useEasterEggModel(BakedModel bakedModel, ItemStack itemStack, ItemDisplayContext itemDisplayContext, boolean leftHanded,
                                        PoseStack poseStack, MultiBufferSource multiBufferSource, int light, int overlay) {
        for(Map.Entry<Item, String> entry : FruitTreesSecretItems.secretItems.entrySet()) {
            Item item = entry.getKey();
            String name = entry.getValue();
            String key = name.toLowerCase();
            if (itemStack.is(item) && itemStack.getHoverName().getString().equals(name)) {
                return ((ItemRendererAccessor) this).fruittrees$getModels().getModelManager().getModel(
                        new ModelResourceLocation(FruitTrees.MOD_ID, key, "inventory"));
            }
        }

        return bakedModel;
    }

}
