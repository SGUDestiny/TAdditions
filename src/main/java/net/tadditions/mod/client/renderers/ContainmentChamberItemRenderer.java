package net.tadditions.mod.client.renderers;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.tadditions.mod.client.model.BrokenContainmentChamberItemModel;
import net.tadditions.mod.client.model.ContainmentChamberItemModel;
import net.tadditions.mod.items.AnimatedBlockItem;
import net.tadditions.mod.items.ContainmentChamberItem;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.util.Color;
import software.bernie.geckolib3.geo.render.built.GeoModel;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;
import software.bernie.geckolib3.util.EModelRenderCycle;

import javax.annotation.Nullable;
import java.util.Collections;

public class ContainmentChamberItemRenderer extends GeoItemRenderer<ContainmentChamberItem> {
    public ContainmentChamberItemRenderer() {
        super(new ContainmentChamberItemModel());
    }

    @Override
    public void render(ContainmentChamberItem animatable, MatrixStack stack, IRenderTypeBuffer bufferIn, int packedLightIn, ItemStack itemStack) {
        this.currentItemStack = itemStack;
        BrokenContainmentChamberItemModel brokenModel = new BrokenContainmentChamberItemModel();
        ContainmentChamberItemModel notBrokenModel = new ContainmentChamberItemModel();
        GeoModel model = animatable.getBroken(itemStack) ? brokenModel.getModel(brokenModel.getModelLocation(animatable)) : notBrokenModel.getModel(notBrokenModel.getModelLocation(animatable));
        //GeoModel model = this.modelProvider.getModel(this.modelProvider.getModelLocation(animatable));
        AnimationEvent itemEvent = new AnimationEvent(animatable, 0.0F, 0.0F, Minecraft.getInstance().getRenderPartialTicks(), false, Collections.singletonList(itemStack));
        this.modelProvider.setCustomAnimations(animatable, this.getUniqueID(animatable), itemEvent);
        this.dispatchedMat = stack.getLast().getMatrix().copy();
        this.setCurrentModelRenderCycle(EModelRenderCycle.INITIAL);
        stack.push();
        stack.translate(0.0, 0.009999999776482582, 0.0);
        stack.translate(0.5, 0.5, 0.5);
        Minecraft.getInstance().textureManager.bindTexture(this.getTextureLocation(animatable));
        Color renderColor = this.getRenderColor(animatable, 0.0F, stack, bufferIn, (IVertexBuilder)null, packedLightIn);
        RenderType renderType = this.getRenderType(animatable, 0.0F, stack, bufferIn, (IVertexBuilder)null, packedLightIn, this.getTextureLocation(animatable));
        this.render(model, animatable, 0.0F, renderType, stack, bufferIn, (IVertexBuilder)null, packedLightIn, OverlayTexture.NO_OVERLAY, (float)renderColor.getRed() / 255.0F, (float)renderColor.getGreen() / 255.0F, (float)renderColor.getBlue() / 255.0F, (float)renderColor.getAlpha() / 255.0F);
        stack.pop();    }

    @Override
    public RenderType getRenderType(ContainmentChamberItem animatable, float partialTicks, MatrixStack stack, @Nullable IRenderTypeBuffer renderTypeBuffer, @Nullable IVertexBuilder vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
        return RenderType.getEntityTranslucent(textureLocation);
    }


}
