package net.tadditions.mod.client.renderers;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.vector.Vector3f;
import net.tadditions.mod.items.ModItems;
import net.tadditions.mod.tileentity.WeaponHolderBE;
import net.tardis.mod.client.models.LightModelRenderer;
import net.tardis.mod.helper.WorldHelper;
import net.tardis.mod.misc.WorldText;
import net.tardis.mod.tileentities.machines.NeutronicSpectrometerTile;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WeaponHolderRenderer extends TileEntityRenderer<WeaponHolderBE> {



    public WeaponHolderRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
    }

    @Override
    public void render(WeaponHolderBE tile, float partialTicks, MatrixStack matrix, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
        matrix.push();

        ItemStack weapon = tile.getWeapon();
        if(weapon.getItem() == ModItems.MURASAMA.get()){
            matrix.push();

            matrix.translate(0.5, 0.5, 0.5);
            matrix.rotate(Vector3f.ZN.rotationDegrees(180));
            matrix.rotate(Vector3f.XN.rotationDegrees(91));
            matrix.rotate(WorldHelper.getStandardRotationFor(tile.getBlockState()));
            if(tile.getBlockState().get(BlockStateProperties.HORIZONTAL_FACING) == Direction.SOUTH){
                matrix.rotate(Vector3f.ZP.rotationDegrees(270));
                matrix.rotate(Vector3f.YP.rotationDegrees(270));
            }
            if(tile.getBlockState().get(BlockStateProperties.HORIZONTAL_FACING) == Direction.WEST){
                matrix.rotate(Vector3f.XP.rotationDegrees(180));
                matrix.rotate(Vector3f.YP.rotationDegrees(180));
                matrix.rotate(Vector3f.ZN.rotationDegrees(1));
            }
            if(tile.getBlockState().get(BlockStateProperties.HORIZONTAL_FACING) == Direction.NORTH){
                matrix.rotate(Vector3f.ZN.rotationDegrees(450));
                matrix.rotate(Vector3f.YP.rotationDegrees(450));
            }
            matrix.translate(0.28f, 0.02f, 0);
            matrix.scale(1F, 1F, 1F);
            Minecraft.getInstance().getItemRenderer().renderItem(weapon, ItemCameraTransforms.TransformType.NONE, combinedLightIn, combinedOverlayIn, matrix, bufferIn);
            matrix.pop();
        }

        matrix.scale(0.5F, 0.5F, 0.5F);
        matrix.pop();
    }
}
