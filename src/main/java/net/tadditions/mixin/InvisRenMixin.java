package net.tadditions.mixin;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.tadditions.mod.items.ModItems;
import net.tardis.mod.client.renderers.InvisEntityRenderer;
import net.tardis.mod.entity.ControlEntity;
import net.tardis.mod.helper.PlayerHelper;
import net.tardis.mod.items.TItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(InvisEntityRenderer.class)
public class InvisRenMixin extends EntityRenderer<Entity> {


    protected InvisRenMixin(EntityRendererManager p_i46179_1_) {
        super(p_i46179_1_);
    }

    protected void renderName(Entity entity, ITextComponent displayNameIn, MatrixStack matrixStackIn,
                              IRenderTypeBuffer bufferIn, int packedLightIn) {
        matrixStackIn.push();
        if(entity instanceof ControlEntity &&
                Minecraft.getInstance().objectMouseOver instanceof EntityRayTraceResult && PlayerHelper.isInEitherHand(Minecraft.getInstance().player, TItems.MANUAL.get()) || Minecraft.getInstance().objectMouseOver instanceof EntityRayTraceResult && PlayerHelper.isInEitherHand(Minecraft.getInstance().player, ModItems.ARCANE_GUIDEBOOK.get()))
            if(((EntityRayTraceResult)Minecraft.getInstance().objectMouseOver).getEntity() == entity) {
                matrixStackIn.translate(0, -0.2F, 0);
                super.renderName(entity, entity.getDisplayName(), matrixStackIn, bufferIn, packedLightIn);
            }
        matrixStackIn.pop();
    }

    @Shadow
    public ResourceLocation getEntityTexture(Entity entity) {
        return null;
    }
}
