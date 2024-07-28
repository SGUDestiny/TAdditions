package net.tadditions.mixin;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.tadditions.mod.helper.CloakState;
import net.tadditions.mod.helper.IExteriorHelp;
import net.tardis.mod.client.renderers.exteriors.ExteriorRenderer;
import net.tardis.mod.tileentities.exteriors.ExteriorTile;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;


@Mixin(ExteriorRenderer.class)
public class ExteriorRenderMixin<T extends ExteriorTile> {


    @Redirect(method = "render(Lnet/tardis/mod/tileentities/exteriors/ExteriorTile;FLcom/mojang/blaze3d/matrix/MatrixStack;Lnet/minecraft/client/renderer/IRenderTypeBuffer;II)V",
            at = @At(value = "INVOKE", target = "Lnet/tardis/mod/client/renderers/exteriors/ExteriorRenderer;renderExterior(Lnet/tardis/mod/tileentities/exteriors/ExteriorTile;FLcom/mojang/blaze3d/matrix/MatrixStack;Lnet/minecraft/client/renderer/IRenderTypeBuffer;IIF)V"), remap = false)
    public void render(ExteriorRenderer<T> instance, T tile, float partialTicks, MatrixStack matrixStack, IRenderTypeBuffer iRenderTypeBuffer, int combinedLightIn, int combinedOverlayIn, float alpha)
    {
        if(((IExteriorHelp) tile).getCloakState() == CloakState.CLOAKING){
            alpha = (float) -Math.pow(2, ((IExteriorHelp) tile).getCloakAnimTime() / 30F)+2;
        } else if(((IExteriorHelp) tile).getCloakState() == CloakState.UNCLOAKING){
            alpha = (float) Math.pow(2, ((IExteriorHelp) tile).getCloakAnimTime() / 30F)-1;
        } else if(((IExteriorHelp) tile).getCloakState() == CloakState.CLOAKED){
            alpha = 0.0F;
        }

        instance.renderExterior(tile, partialTicks, matrixStack, iRenderTypeBuffer, combinedLightIn, combinedOverlayIn, alpha);
    }
}
