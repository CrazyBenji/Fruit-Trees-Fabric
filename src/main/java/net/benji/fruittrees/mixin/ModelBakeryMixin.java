package net.benji.fruittrees.mixin;

import net.benji.fruittrees.FruitTrees;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.profiling.ProfilerFiller;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Map;

@Mixin(ModelBakery.class)
public abstract class ModelBakeryMixin {

    @Shadow
    protected abstract void loadTopLevel(ModelResourceLocation modelId);

    @Inject(method = "<init>", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/client/resources/model/ModelBakery;loadTopLevel(Lnet/minecraft/client/resources/model/ModelResourceLocation;)V",
            ordinal = 3, shift = At.Shift.AFTER))
    public void addModelEasterEggs(BlockColors blockColors, ProfilerFiller profilerFiller,
                                   Map<ResourceLocation, BlockModel> jsonUnbakedModels,
                                   Map<ResourceLocation, List<ModelBakery.LoadedJson>> blockStates, CallbackInfo ci) {

        this.loadTopLevel(new ModelResourceLocation(FruitTrees.MOD_ID, "pearto", "inventory"));
        this.loadTopLevel(new ModelResourceLocation(FruitTrees.MOD_ID, "bavid", "inventory"));
    }

}
