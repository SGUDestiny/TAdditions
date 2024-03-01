package net.tadditions.mixin;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraftforge.common.util.LazyOptional;
import net.tadditions.mod.helper.IConsoleHelp;
import net.tardis.mod.client.renderers.exteriors.ExteriorRenderer;
import net.tardis.mod.enums.EnumMatterState;
import net.tardis.mod.helper.PlayerHelper;
import net.tardis.mod.helper.TardisHelper;
import net.tardis.mod.items.TItems;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.tileentities.exteriors.ExteriorTile;
import org.spongepowered.asm.mixin.Mixin;


@Mixin(ExteriorRenderer.class)
public class ExteriorRenderMixin<T extends ExteriorTile> {

    public void render(T tile, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
        matrixStackIn.push();

        LazyOptional<ConsoleTile> console = TardisHelper.getConsole(tile.getWorld().getServer(), tile.getInteriorDimensionKey());

        ExteriorRenderer.applyTransforms(matrixStackIn, tile);

        float alpha = 1.0F;
        if(tile.getMatterState() != EnumMatterState.SOLID){
            if(tile.getExteriorAnimation() != null){
                alpha = tile.getExteriorAnimation().getAlpha();
            }
        }
        if(console != null && ((IConsoleHelp) console).getCloakState()){
            alpha = 0.0F;
        }

        ((ExteriorRenderer) (Object) this).renderExterior(tile, partialTicks, matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn, alpha);

        matrixStackIn.pop();

        //Debug

        if(Minecraft.getInstance().player != null && PlayerHelper.InEitherHand(Minecraft.getInstance().player, stack -> stack.getItem() == TItems.DEBUG.get())) {
            matrixStackIn.push();
            matrixStackIn.translate(0,0,0);
            IRenderTypeBuffer.Impl buffer = Minecraft.getInstance().getRenderTypeBuffers().getBufferSource();
            IVertexBuilder builder = buffer.getBuffer(RenderType.getLines());
            WorldRenderer.drawBoundingBox(matrixStackIn, builder, tile.getDoorAABB(), 1.0F, 0.0F, 0.0F, 0.75F);
            matrixStackIn.pop();
        }

    }

}
