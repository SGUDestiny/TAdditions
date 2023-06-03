package net.tadditions.mod.client.model;// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.common.util.LazyOptional;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.client.renderers.ToyotaExteriorRenderer;
import net.tadditions.mod.helper.IMDoorType;
import net.tardis.mod.client.models.LightModelRenderer;
import net.tardis.mod.client.models.exteriors.ExteriorModel;
import net.tardis.mod.client.renderers.boti.BOTIRenderer;
import net.tardis.mod.client.renderers.boti.PortalInfo;
import net.tardis.mod.client.renderers.exteriors.ExteriorRenderer;
import net.tardis.mod.client.renderers.exteriors.ModernPoliceBoxExteriorRenderer;
import net.tardis.mod.enums.EnumDoorState;
import net.tardis.mod.enums.EnumMatterState;
import net.tardis.mod.helper.TardisHelper;
import net.tardis.mod.helper.WorldHelper;
import net.tardis.mod.misc.IDoorType;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.tileentities.exteriors.ExteriorTile;

import java.util.Objects;

public class ToyotaExteriorModel extends ExteriorModel {
	private final ModelRenderer base;
	private final ModelRenderer boti;
	private final ModelRenderer lamp;
	private final LightModelRenderer lampglow;
	private final ModelRenderer door1;
	private final ModelRenderer door1right;
	private final LightModelRenderer door1rightsign;
	private final ModelRenderer door1rightwindow;
	private final ModelRenderer door1rightwindowframe;
	private final ModelRenderer door1rightwindowframe7_r1;
	private final ModelRenderer door1rightwindowframe6_r1;
	private final ModelRenderer door1rightwindowframe5_r1;
	private final ModelRenderer door1rightwindowframe4_r1;
	private final ModelRenderer door1rightwindowframe3_r1;
	private final ModelRenderer door1rightwindowframe2_r1;
	private final ModelRenderer door1rightwindowframe1_r1;
	private final LightModelRenderer door1rightwindowglass;
	private final ModelRenderer door1left;
	private final ModelRenderer door1leftwindow;
	private final ModelRenderer door1leftwindowframe;
	private final ModelRenderer door1leftwindowframe7_r1;
	private final ModelRenderer door1leftwindowframe6_r1;
	private final ModelRenderer door1leftwindowframe5_r1;
	private final ModelRenderer door1leftwindowframe4_r1;
	private final ModelRenderer door1leftwindowframe3_r1;
	private final ModelRenderer door1leftwindowframe2_r1;
	private final ModelRenderer door1leftwindowframe1_r1;
	private final LightModelRenderer door1leftwindowglass;
	private final ModelRenderer door2;
	private final ModelRenderer door2right;
	private final ModelRenderer door2rightwindow;
	private final ModelRenderer door2rightwindowframe;
	private final ModelRenderer door2rightwindowframe7_r1;
	private final ModelRenderer door2rightwindowframe6_r1;
	private final ModelRenderer door2rightwindowframe5_r1;
	private final ModelRenderer door2rightwindowframe4_r1;
	private final ModelRenderer door2rightwindowframe3_r1;
	private final ModelRenderer door2rightwindowframe2_r1;
	private final ModelRenderer door2rightwindowframe1_r1;
	private final LightModelRenderer door2rightwindowglass;
	private final ModelRenderer door2left;
	private final ModelRenderer door2leftwindow;
	private final ModelRenderer door2leftwindowframe;
	private final ModelRenderer door2leftwindowframe7_r1;
	private final ModelRenderer door2leftwindowframe6_r1;
	private final ModelRenderer door2leftwindowframe5_r1;
	private final ModelRenderer door2leftwindowframe4_r1;
	private final ModelRenderer door2leftwindowframe3_r1;
	private final ModelRenderer door2leftwindowframe2_r1;
	private final ModelRenderer door2leftwindowframe1_r1;
	private final LightModelRenderer door2leftwindowglass;
	private final ModelRenderer door3;
	private final ModelRenderer door3right;
	private final ModelRenderer door3rightwindow;
	private final ModelRenderer door3rightwindowframe;
	private final ModelRenderer door3rightwindowframe7_r1;
	private final ModelRenderer door3rightwindowframe6_r1;
	private final ModelRenderer door3rightwindowframe5_r1;
	private final ModelRenderer door3rightwindowframe4_r1;
	private final ModelRenderer door3rightwindowframe3_r1;
	private final ModelRenderer door3rightwindowframe2_r1;
	private final ModelRenderer door3rightwindowframe1_r1;
	private final LightModelRenderer door3rightwindowglass;
	private final ModelRenderer door3left;
	private final ModelRenderer door3leftwindow;
	private final ModelRenderer door3leftwindowframe;
	private final ModelRenderer door3leftwindowframe7_r1;
	private final ModelRenderer door3leftwindowframe6_r1;
	private final ModelRenderer door3leftwindowframe5_r1;
	private final ModelRenderer door3leftwindowframe4_r1;
	private final ModelRenderer door3leftwindowframe3_r1;
	private final ModelRenderer door3leftwindowframe2_r1;
	private final ModelRenderer door3leftwindowframe1_r1;
	private final LightModelRenderer door3leftwindowglass;
	private final ModelRenderer door4;
	private final ModelRenderer door4right;
	private final ModelRenderer door4rightwindow;
	private final ModelRenderer door4rightwindowframe;
	private final ModelRenderer door4rightwindowframe7_r1;
	private final ModelRenderer door4rightwindowframe6_r1;
	private final ModelRenderer door4rightwindowframe5_r1;
	private final ModelRenderer door4rightwindowframe4_r1;
	private final ModelRenderer door4rightwindowframe3_r1;
	private final ModelRenderer door4rightwindowframe2_r1;
	private final ModelRenderer door4rightwindowframe1_r1;
	private final LightModelRenderer door4rightwindowglass;
	private final ModelRenderer door4left;
	private final ModelRenderer door4leftwindow;
	private final ModelRenderer door4leftwindowframe;
	private final ModelRenderer door4leftwindowframe7_r1;
	private final ModelRenderer door4leftwindowframe6_r1;
	private final ModelRenderer door4leftwindowframe5_r1;
	private final ModelRenderer door4leftwindowframe4_r1;
	private final ModelRenderer door4leftwindowframe3_r1;
	private final ModelRenderer door4leftwindowframe2_r1;
	private final ModelRenderer door4leftwindowframe1_r1;
	private final LightModelRenderer door4leftwindowglass;

	public ToyotaExteriorModel() {
		textureWidth = 256;
		textureHeight = 256;

        base = new ModelRenderer(this);
        base.setRotationPoint(0.0F, 24.0F, 0.0F);
        base.setTextureOffset(0, 0).addBox(-12.0F, -2.0F, -12.0F, 24.0F, 2.0F, 24.0F, 0.0F, false);
        base.setTextureOffset(0, 77).addBox(9.0F, -39.0F, -11.0F, 2.0F, 37.0F, 2.0F, 0.0F, true);
        base.setTextureOffset(42, 72).addBox(9.0F, -39.0F, 9.0F, 2.0F, 37.0F, 2.0F, 0.0F, true);
        base.setTextureOffset(42, 72).addBox(-11.0F, -39.0F, 9.0F, 2.0F, 37.0F, 2.0F, 0.0F, false);
        base.setTextureOffset(0, 77).addBox(-11.0F, -39.0F, -11.0F, 2.0F, 37.0F, 2.0F, 0.0F, false);
        base.setTextureOffset(0, 52).addBox(-9.0F, -42.5F, -9.0F, 18.0F, 2.0F, 18.0F, 0.0F, false);
        base.setTextureOffset(0, 26).addBox(-10.0F, -41.0F, -10.0F, 20.0F, 6.0F, 20.0F, 0.0F, false);
        base.setTextureOffset(72, 10).addBox(-9.0F, -39.0F, -11.0F, 18.0F, 1.0F, 2.0F, 0.0F, false);
        base.setTextureOffset(72, 10).addBox(-9.0F, -39.0F, 9.0F, 18.0F, 1.0F, 2.0F, 0.0F, false);
        base.setTextureOffset(60, 26).addBox(9.0F, -39.0F, -9.0F, 2.0F, 1.0F, 18.0F, 0.0F, false);
        base.setTextureOffset(60, 26).addBox(-11.0F, -39.0F, -9.0F, 2.0F, 1.0F, 18.0F, 0.0F, false);

        boti = new ModelRenderer(this);
        boti.setRotationPoint(0.0F, 0.0F, 0.0F);
        base.addChild(boti);
        boti.setTextureOffset(70, 70).addBox(-9.0F, -35.0F, -1.0F, 18.0F, 33.0F, 2.0F, 0.0F, false);

        lamp = new ModelRenderer(this);
        lamp.setRotationPoint(0.0F, -3.5F, 0.0F);
        base.addChild(lamp);
        lamp.setTextureOffset(114, 60).addBox(-1.5F, -40.0F, -1.5F, 3.0F, 2.0F, 3.0F, 0.0F, false);
        lamp.setTextureOffset(14, 21).addBox(-0.5F, -44.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        lamp.setTextureOffset(12, 32).addBox(-1.0F, -41.0F, -1.25F, 2.0F, 1.0F, 0.0F, 0.0F, false);
        lamp.setTextureOffset(12, 32).addBox(-1.0F, -41.0F, 1.25F, 2.0F, 1.0F, 0.0F, 0.0F, false);
        lamp.setTextureOffset(12, 30).addBox(1.25F, -41.0F, -1.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
        lamp.setTextureOffset(12, 30).addBox(-1.25F, -41.0F, -1.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
        lamp.setTextureOffset(12, 28).addBox(-1.0F, -43.25F, 1.25F, 2.0F, 1.0F, 0.0F, 0.0F, false);
        lamp.setTextureOffset(12, 28).addBox(-1.0F, -43.25F, -1.25F, 2.0F, 1.0F, 0.0F, 0.0F, false);
        lamp.setTextureOffset(12, 26).addBox(-1.25F, -43.25F, -1.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
        lamp.setTextureOffset(12, 26).addBox(1.25F, -43.25F, -1.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);

        lampglow = new LightModelRenderer(this);
        lampglow.setRotationPoint(0.0F, 0.0F, 0.0F);
        lamp.addChild(lampglow);
        lampglow.setTextureOffset(12, 26).addBox(-1.0F, -43.5F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        door1 = new ModelRenderer(this);
        door1.setRotationPoint(0.0F, 24.0F, 0.0F);
        door1.setTextureOffset(109, 104).addBox(8.5F, -35.0F, -10.5F, 1.0F, 33.0F, 1.0F, 0.0F, false);
        door1.setTextureOffset(109, 104).addBox(-9.5F, -35.0F, -10.5F, 1.0F, 33.0F, 1.0F, 0.0F, false);
        door1.setTextureOffset(72, 16).addBox(-9.5F, -36.0F, -10.5F, 19.0F, 1.0F, 1.0F, 0.0F, false);
        door1.setTextureOffset(72, 0).addBox(-9.5F, -38.5F, -12.0F, 19.0F, 3.0F, 2.0F, 0.0F, false);
        door1.setTextureOffset(82, 30).addBox(-9.0F, -38.0F, -12.125F, 18.0F, 2.0F, 0.0F, 0.0F, false);

        door1right = new ModelRenderer(this);
        door1right.setRotationPoint(-8.5F, -18.5F, -10.0F);
        door1.addChild(door1right);
        door1right.setTextureOffset(65, 110).addBox(0.0F, -16.5F, 0.0F, 1.0F, 33.0F, 1.0F, 0.0F, false);
        door1right.setTextureOffset(0, 122).addBox(1.0F, 15.5F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        door1right.setTextureOffset(44, 111).addBox(7.0F, -16.5F, 0.0F, 1.0F, 33.0F, 1.0F, 0.0F, false);
        door1right.setTextureOffset(0, 0).addBox(1.0F, 8.5F, 0.25F, 6.0F, 7.0F, 0.0F, 0.0F, false);
        door1right.setTextureOffset(0, 0).addBox(1.0F, 0.5F, 0.25F, 6.0F, 7.0F, 0.0F, 0.0F, false);
        door1right.setTextureOffset(0, 0).addBox(1.0F, -7.5F, 0.25F, 6.0F, 7.0F, 0.0F, 0.0F, false);
        door1right.setTextureOffset(0, 120).addBox(1.0F, -8.5F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        door1right.setTextureOffset(0, 124).addBox(1.0F, -16.5F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        door1right.setTextureOffset(48, 111).addBox(8.0F, -16.5F, -0.5F, 1.0F, 33.0F, 1.0F, 0.0F, false);
        door1right.setTextureOffset(0, 120).addBox(1.0F, 7.5F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        door1right.setTextureOffset(0, 120).addBox(1.0F, -0.5F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

        door1rightsign = new LightModelRenderer(this);
        door1rightsign.setRotationPoint(8.5F, 18.5F, 10.0F);
        door1right.addChild(door1rightsign);
        door1rightsign.setTextureOffset(52, 118).addBox(-7.0F, -25.5F, -9.875F, 5.0F, 6.0F, 0.0F, 0.0F, false);

        door1rightwindow = new ModelRenderer(this);
        door1rightwindow.setRotationPoint(-0.5F, 18.5F, 10.0F);
        door1right.addChild(door1rightwindow);


        door1rightwindowframe = new ModelRenderer(this);
        door1rightwindowframe.setRotationPoint(4.5F, -34.0F, -9.75F);
        door1rightwindow.addChild(door1rightwindowframe);


        door1rightwindowframe7_r1 = new ModelRenderer(this);
        door1rightwindowframe7_r1.setRotationPoint(0.0F, 0.0F, 0.25F);
        door1rightwindowframe.addChild(door1rightwindowframe7_r1);
        setRotationAngle(door1rightwindowframe7_r1, -0.7854F, 0.0F, 0.0F);
        door1rightwindowframe7_r1.setTextureOffset(130, 1).addBox(-3.0F, -0.75F, -0.25F, 6.0F, 1.0F, 1.0F, 0.0F, false);

        door1rightwindowframe6_r1 = new ModelRenderer(this);
        door1rightwindowframe6_r1.setRotationPoint(0.0F, 3.5F, 0.25F);
        door1rightwindowframe.addChild(door1rightwindowframe6_r1);
        setRotationAngle(door1rightwindowframe6_r1, -0.7854F, 0.0F, 0.0F);
        door1rightwindowframe6_r1.setTextureOffset(130, 5).addBox(-3.0F, -0.75F, -0.25F, 6.0F, 1.0F, 1.0F, 0.0F, false);

        door1rightwindowframe5_r1 = new ModelRenderer(this);
        door1rightwindowframe5_r1.setRotationPoint(0.0F, 7.0F, 0.25F);
        door1rightwindowframe.addChild(door1rightwindowframe5_r1);
        setRotationAngle(door1rightwindowframe5_r1, -0.7854F, 0.0F, 0.0F);
        door1rightwindowframe5_r1.setTextureOffset(130, 5).addBox(-3.0F, -0.75F, -0.25F, 6.0F, 1.0F, 1.0F, 0.0F, false);

        door1rightwindowframe4_r1 = new ModelRenderer(this);
        door1rightwindowframe4_r1.setRotationPoint(3.0F, 3.5F, 0.25F);
        door1rightwindowframe.addChild(door1rightwindowframe4_r1);
        setRotationAngle(door1rightwindowframe4_r1, 0.0F, -0.7854F, 0.0F);
        door1rightwindowframe4_r1.setTextureOffset(130, 0).addBox(-0.25F, -3.5F, -0.25F, 1.0F, 7.0F, 1.0F, 0.0F, false);

        door1rightwindowframe3_r1 = new ModelRenderer(this);
        door1rightwindowframe3_r1.setRotationPoint(-3.0F, 3.5F, 0.25F);
        door1rightwindowframe.addChild(door1rightwindowframe3_r1);
        setRotationAngle(door1rightwindowframe3_r1, 0.0F, -0.7854F, 0.0F);
        door1rightwindowframe3_r1.setTextureOffset(130, 0).addBox(-0.25F, -3.5F, -0.25F, 1.0F, 7.0F, 1.0F, 0.0F, false);

        door1rightwindowframe2_r1 = new ModelRenderer(this);
        door1rightwindowframe2_r1.setRotationPoint(-1.0F, 3.5F, 0.25F);
        door1rightwindowframe.addChild(door1rightwindowframe2_r1);
        setRotationAngle(door1rightwindowframe2_r1, 0.0F, -0.7854F, 0.0F);
        door1rightwindowframe2_r1.setTextureOffset(130, 0).addBox(-0.25F, -3.5F, -0.25F, 1.0F, 7.0F, 1.0F, 0.0F, false);

        door1rightwindowframe1_r1 = new ModelRenderer(this);
        door1rightwindowframe1_r1.setRotationPoint(1.0F, 3.5F, 0.25F);
        door1rightwindowframe.addChild(door1rightwindowframe1_r1);
        setRotationAngle(door1rightwindowframe1_r1, 0.0F, -0.7854F, 0.0F);
        door1rightwindowframe1_r1.setTextureOffset(130, 0).addBox(-0.25F, -3.5F, -0.25F, 1.0F, 7.0F, 1.0F, 0.0F, false);

        door1rightwindowglass = new LightModelRenderer(this);
        door1rightwindowglass.setRotationPoint(0.0F, 0.0F, 0.0F);
        door1rightwindow.addChild(door1rightwindowglass);
        door1rightwindowglass.setTextureOffset(114, 32).addBox(1.5F, -33.75F, -9.625F, 6.0F, 3.0F, 1.0F, 0.0F, false);
        door1rightwindowglass.setTextureOffset(114, 36).addBox(1.5F, -30.75F, -9.625F, 6.0F, 4.0F, 1.0F, 0.0F, false);

        door1left = new ModelRenderer(this);
        door1left.setRotationPoint(8.5F, -18.5F, -10.0F);
        door1.addChild(door1left);
        door1left.setTextureOffset(0, 122).addBox(-7.0F, 15.5F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        door1left.setTextureOffset(44, 111).addBox(-8.0F, -16.5F, 0.0F, 1.0F, 33.0F, 1.0F, 0.0F, false);
        door1left.setTextureOffset(65, 110).addBox(-1.0F, -16.5F, 0.0F, 1.0F, 33.0F, 1.0F, 0.0F, false);
        door1left.setTextureOffset(0, 120).addBox(-7.0F, 7.5F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        door1left.setTextureOffset(0, 0).addBox(-7.0F, 8.5F, 0.25F, 6.0F, 7.0F, 0.0F, 0.0F, false);
        door1left.setTextureOffset(0, 0).addBox(-7.0F, 0.5F, 0.25F, 6.0F, 7.0F, 0.0F, 0.0F, false);
        door1left.setTextureOffset(0, 120).addBox(-7.0F, -0.5F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        door1left.setTextureOffset(0, 0).addBox(-7.0F, -7.5F, 0.25F, 6.0F, 7.0F, 0.0F, 0.0F, false);
        door1left.setTextureOffset(18, 21).addBox(-5.0F, -5.0F, 0.125F, 2.0F, 2.0F, 0.0F, 0.0F, false);
        door1left.setTextureOffset(0, 120).addBox(-7.0F, -8.5F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        door1left.setTextureOffset(0, 124).addBox(-7.0F, -16.5F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

        door1leftwindow = new ModelRenderer(this);
        door1leftwindow.setRotationPoint(-8.5F, 18.5F, 10.0F);
        door1left.addChild(door1leftwindow);


        door1leftwindowframe = new ModelRenderer(this);
        door1leftwindowframe.setRotationPoint(4.5F, -34.0F, -9.75F);
        door1leftwindow.addChild(door1leftwindowframe);


        door1leftwindowframe7_r1 = new ModelRenderer(this);
        door1leftwindowframe7_r1.setRotationPoint(0.0F, 0.0F, 0.25F);
        door1leftwindowframe.addChild(door1leftwindowframe7_r1);
        setRotationAngle(door1leftwindowframe7_r1, -0.7854F, 0.0F, 0.0F);
        door1leftwindowframe7_r1.setTextureOffset(130, 1).addBox(-3.0F, -0.75F, -0.25F, 6.0F, 1.0F, 1.0F, 0.0F, false);

        door1leftwindowframe6_r1 = new ModelRenderer(this);
        door1leftwindowframe6_r1.setRotationPoint(0.0F, 3.5F, 0.25F);
        door1leftwindowframe.addChild(door1leftwindowframe6_r1);
        setRotationAngle(door1leftwindowframe6_r1, -0.7854F, 0.0F, 0.0F);
        door1leftwindowframe6_r1.setTextureOffset(130, 5).addBox(-3.0F, -0.75F, -0.25F, 6.0F, 1.0F, 1.0F, 0.0F, false);

        door1leftwindowframe5_r1 = new ModelRenderer(this);
        door1leftwindowframe5_r1.setRotationPoint(0.0F, 7.0F, 0.25F);
        door1leftwindowframe.addChild(door1leftwindowframe5_r1);
        setRotationAngle(door1leftwindowframe5_r1, -0.7854F, 0.0F, 0.0F);
        door1leftwindowframe5_r1.setTextureOffset(130, 5).addBox(-3.0F, -0.75F, -0.25F, 6.0F, 1.0F, 1.0F, 0.0F, false);

        door1leftwindowframe4_r1 = new ModelRenderer(this);
        door1leftwindowframe4_r1.setRotationPoint(3.0F, 3.5F, 0.25F);
        door1leftwindowframe.addChild(door1leftwindowframe4_r1);
        setRotationAngle(door1leftwindowframe4_r1, 0.0F, -0.7854F, 0.0F);
        door1leftwindowframe4_r1.setTextureOffset(130, 0).addBox(-0.25F, -3.5F, -0.25F, 1.0F, 7.0F, 1.0F, 0.0F, false);

        door1leftwindowframe3_r1 = new ModelRenderer(this);
        door1leftwindowframe3_r1.setRotationPoint(-3.0F, 3.5F, 0.25F);
        door1leftwindowframe.addChild(door1leftwindowframe3_r1);
        setRotationAngle(door1leftwindowframe3_r1, 0.0F, -0.7854F, 0.0F);
        door1leftwindowframe3_r1.setTextureOffset(130, 0).addBox(-0.25F, -3.5F, -0.25F, 1.0F, 7.0F, 1.0F, 0.0F, false);

        door1leftwindowframe2_r1 = new ModelRenderer(this);
        door1leftwindowframe2_r1.setRotationPoint(-1.0F, 3.5F, 0.25F);
        door1leftwindowframe.addChild(door1leftwindowframe2_r1);
        setRotationAngle(door1leftwindowframe2_r1, 0.0F, -0.7854F, 0.0F);
        door1leftwindowframe2_r1.setTextureOffset(130, 0).addBox(-0.25F, -3.5F, -0.25F, 1.0F, 7.0F, 1.0F, 0.0F, false);

        door1leftwindowframe1_r1 = new ModelRenderer(this);
        door1leftwindowframe1_r1.setRotationPoint(1.0F, 3.5F, 0.25F);
        door1leftwindowframe.addChild(door1leftwindowframe1_r1);
        setRotationAngle(door1leftwindowframe1_r1, 0.0F, -0.7854F, 0.0F);
        door1leftwindowframe1_r1.setTextureOffset(130, 0).addBox(-0.25F, -3.5F, -0.25F, 1.0F, 7.0F, 1.0F, 0.0F, false);

        door1leftwindowglass = new LightModelRenderer(this);
        door1leftwindowglass.setRotationPoint(0.0F, 0.0F, 0.0F);
        door1leftwindow.addChild(door1leftwindowglass);
        door1leftwindowglass.setTextureOffset(114, 32).addBox(1.5F, -33.75F, -9.625F, 6.0F, 3.0F, 1.0F, 0.0F, false);
        door1leftwindowglass.setTextureOffset(114, 36).addBox(1.5F, -30.75F, -9.625F, 6.0F, 4.0F, 1.0F, 0.0F, false);

        door2 = new ModelRenderer(this);
        door2.setRotationPoint(0.0F, 24.0F, 0.0F);
        setRotationAngle(door2, 0.0F, -1.5708F, 0.0F);
        door2.setTextureOffset(109, 104).addBox(8.5F, -35.0F, -10.5F, 1.0F, 33.0F, 1.0F, 0.0F, false);
        door2.setTextureOffset(109, 104).addBox(-9.5F, -35.0F, -10.5F, 1.0F, 33.0F, 1.0F, 0.0F, false);
        door2.setTextureOffset(72, 16).addBox(-9.5F, -36.0F, -10.5F, 19.0F, 1.0F, 1.0F, 0.0F, false);
        door2.setTextureOffset(72, 0).addBox(-9.5F, -38.5F, -12.0F, 19.0F, 3.0F, 2.0F, 0.0F, false);
        door2.setTextureOffset(82, 30).addBox(-9.0F, -38.0F, -12.125F, 18.0F, 2.0F, 0.0F, 0.0F, false);

        door2right = new ModelRenderer(this);
        door2right.setRotationPoint(0.0F, 0.0F, 0.0F);
        door2.addChild(door2right);
        door2right.setTextureOffset(65, 110).addBox(-8.5F, -35.0F, -10.0F, 1.0F, 33.0F, 1.0F, 0.0F, false);
        door2right.setTextureOffset(0, 122).addBox(-7.5F, -3.0F, -10.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        door2right.setTextureOffset(44, 111).addBox(-1.5F, -35.0F, -10.0F, 1.0F, 33.0F, 1.0F, 0.0F, false);
        door2right.setTextureOffset(0, 0).addBox(-7.5F, -10.0F, -9.75F, 6.0F, 7.0F, 0.0F, 0.0F, false);
        door2right.setTextureOffset(0, 0).addBox(-7.5F, -18.0F, -9.75F, 6.0F, 7.0F, 0.0F, 0.0F, false);
        door2right.setTextureOffset(0, 0).addBox(-7.5F, -26.0F, -9.75F, 6.0F, 7.0F, 0.0F, 0.0F, false);
        door2right.setTextureOffset(0, 120).addBox(-7.5F, -27.0F, -10.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        door2right.setTextureOffset(0, 124).addBox(-7.5F, -35.0F, -10.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        door2right.setTextureOffset(48, 111).addBox(-0.5F, -35.0F, -10.5F, 1.0F, 33.0F, 1.0F, 0.0F, false);
        door2right.setTextureOffset(0, 120).addBox(-7.5F, -11.0F, -10.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        door2right.setTextureOffset(0, 120).addBox(-7.5F, -19.0F, -10.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

        door2rightwindow = new ModelRenderer(this);
        door2rightwindow.setRotationPoint(-9.0F, 0.0F, 0.0F);
        door2right.addChild(door2rightwindow);


        door2rightwindowframe = new ModelRenderer(this);
        door2rightwindowframe.setRotationPoint(4.5F, -34.0F, -9.75F);
        door2rightwindow.addChild(door2rightwindowframe);


        door2rightwindowframe7_r1 = new ModelRenderer(this);
        door2rightwindowframe7_r1.setRotationPoint(0.0F, 0.0F, 0.25F);
        door2rightwindowframe.addChild(door2rightwindowframe7_r1);
        setRotationAngle(door2rightwindowframe7_r1, -0.7854F, 0.0F, 0.0F);
        door2rightwindowframe7_r1.setTextureOffset(130, 1).addBox(-3.0F, -0.75F, -0.25F, 6.0F, 1.0F, 1.0F, 0.0F, false);

        door2rightwindowframe6_r1 = new ModelRenderer(this);
        door2rightwindowframe6_r1.setRotationPoint(0.0F, 3.5F, 0.25F);
        door2rightwindowframe.addChild(door2rightwindowframe6_r1);
        setRotationAngle(door2rightwindowframe6_r1, -0.7854F, 0.0F, 0.0F);
        door2rightwindowframe6_r1.setTextureOffset(130, 5).addBox(-3.0F, -0.75F, -0.25F, 6.0F, 1.0F, 1.0F, 0.0F, false);

        door2rightwindowframe5_r1 = new ModelRenderer(this);
        door2rightwindowframe5_r1.setRotationPoint(0.0F, 7.0F, 0.25F);
        door2rightwindowframe.addChild(door2rightwindowframe5_r1);
        setRotationAngle(door2rightwindowframe5_r1, -0.7854F, 0.0F, 0.0F);
        door2rightwindowframe5_r1.setTextureOffset(130, 5).addBox(-3.0F, -0.75F, -0.25F, 6.0F, 1.0F, 1.0F, 0.0F, false);

        door2rightwindowframe4_r1 = new ModelRenderer(this);
        door2rightwindowframe4_r1.setRotationPoint(3.0F, 3.5F, 0.25F);
        door2rightwindowframe.addChild(door2rightwindowframe4_r1);
        setRotationAngle(door2rightwindowframe4_r1, 0.0F, -0.7854F, 0.0F);
        door2rightwindowframe4_r1.setTextureOffset(130, 0).addBox(-0.25F, -3.5F, -0.25F, 1.0F, 7.0F, 1.0F, 0.0F, false);

        door2rightwindowframe3_r1 = new ModelRenderer(this);
        door2rightwindowframe3_r1.setRotationPoint(-3.0F, 3.5F, 0.25F);
        door2rightwindowframe.addChild(door2rightwindowframe3_r1);
        setRotationAngle(door2rightwindowframe3_r1, 0.0F, -0.7854F, 0.0F);
        door2rightwindowframe3_r1.setTextureOffset(130, 0).addBox(-0.25F, -3.5F, -0.25F, 1.0F, 7.0F, 1.0F, 0.0F, false);

        door2rightwindowframe2_r1 = new ModelRenderer(this);
        door2rightwindowframe2_r1.setRotationPoint(-1.0F, 3.5F, 0.25F);
        door2rightwindowframe.addChild(door2rightwindowframe2_r1);
        setRotationAngle(door2rightwindowframe2_r1, 0.0F, -0.7854F, 0.0F);
        door2rightwindowframe2_r1.setTextureOffset(130, 0).addBox(-0.25F, -3.5F, -0.25F, 1.0F, 7.0F, 1.0F, 0.0F, false);

        door2rightwindowframe1_r1 = new ModelRenderer(this);
        door2rightwindowframe1_r1.setRotationPoint(1.0F, 3.5F, 0.25F);
        door2rightwindowframe.addChild(door2rightwindowframe1_r1);
        setRotationAngle(door2rightwindowframe1_r1, 0.0F, -0.7854F, 0.0F);
        door2rightwindowframe1_r1.setTextureOffset(130, 0).addBox(-0.25F, -3.5F, -0.25F, 1.0F, 7.0F, 1.0F, 0.0F, false);

        door2rightwindowglass = new LightModelRenderer(this);
        door2rightwindowglass.setRotationPoint(0.0F, 0.0F, 0.0F);
        door2rightwindow.addChild(door2rightwindowglass);
        door2rightwindowglass.setTextureOffset(114, 32).addBox(1.5F, -33.75F, -9.625F, 6.0F, 3.0F, 1.0F, 0.0F, false);
        door2rightwindowglass.setTextureOffset(114, 36).addBox(1.5F, -30.75F, -9.625F, 6.0F, 4.0F, 1.0F, 0.0F, false);

        door2left = new ModelRenderer(this);
        door2left.setRotationPoint(0.0F, 0.0F, 0.0F);
        door2.addChild(door2left);
        door2left.setTextureOffset(0, 122).addBox(1.5F, -3.0F, -10.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        door2left.setTextureOffset(44, 111).addBox(0.5F, -35.0F, -10.0F, 1.0F, 33.0F, 1.0F, 0.0F, false);
        door2left.setTextureOffset(65, 110).addBox(7.5F, -35.0F, -10.0F, 1.0F, 33.0F, 1.0F, 0.0F, false);
        door2left.setTextureOffset(0, 120).addBox(1.5F, -11.0F, -10.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        door2left.setTextureOffset(0, 0).addBox(1.5F, -10.0F, -9.75F, 6.0F, 7.0F, 0.0F, 0.0F, false);
        door2left.setTextureOffset(0, 0).addBox(1.5F, -18.0F, -9.75F, 6.0F, 7.0F, 0.0F, 0.0F, false);
        door2left.setTextureOffset(0, 120).addBox(1.5F, -19.0F, -10.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        door2left.setTextureOffset(0, 0).addBox(1.5F, -26.0F, -9.75F, 6.0F, 7.0F, 0.0F, 0.0F, false);
        door2left.setTextureOffset(0, 120).addBox(1.5F, -27.0F, -10.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        door2left.setTextureOffset(0, 124).addBox(1.5F, -35.0F, -10.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

        door2leftwindow = new ModelRenderer(this);
        door2leftwindow.setRotationPoint(0.0F, 0.0F, 0.0F);
        door2left.addChild(door2leftwindow);


        door2leftwindowframe = new ModelRenderer(this);
        door2leftwindowframe.setRotationPoint(4.5F, -34.0F, -9.75F);
        door2leftwindow.addChild(door2leftwindowframe);


        door2leftwindowframe7_r1 = new ModelRenderer(this);
        door2leftwindowframe7_r1.setRotationPoint(0.0F, 0.0F, 0.25F);
        door2leftwindowframe.addChild(door2leftwindowframe7_r1);
        setRotationAngle(door2leftwindowframe7_r1, -0.7854F, 0.0F, 0.0F);
        door2leftwindowframe7_r1.setTextureOffset(130, 1).addBox(-3.0F, -0.75F, -0.25F, 6.0F, 1.0F, 1.0F, 0.0F, false);

        door2leftwindowframe6_r1 = new ModelRenderer(this);
        door2leftwindowframe6_r1.setRotationPoint(0.0F, 3.5F, 0.25F);
        door2leftwindowframe.addChild(door2leftwindowframe6_r1);
        setRotationAngle(door2leftwindowframe6_r1, -0.7854F, 0.0F, 0.0F);
        door2leftwindowframe6_r1.setTextureOffset(130, 5).addBox(-3.0F, -0.75F, -0.25F, 6.0F, 1.0F, 1.0F, 0.0F, false);

        door2leftwindowframe5_r1 = new ModelRenderer(this);
        door2leftwindowframe5_r1.setRotationPoint(0.0F, 7.0F, 0.25F);
        door2leftwindowframe.addChild(door2leftwindowframe5_r1);
        setRotationAngle(door2leftwindowframe5_r1, -0.7854F, 0.0F, 0.0F);
        door2leftwindowframe5_r1.setTextureOffset(130, 5).addBox(-3.0F, -0.75F, -0.25F, 6.0F, 1.0F, 1.0F, 0.0F, false);

        door2leftwindowframe4_r1 = new ModelRenderer(this);
        door2leftwindowframe4_r1.setRotationPoint(3.0F, 3.5F, 0.25F);
        door2leftwindowframe.addChild(door2leftwindowframe4_r1);
        setRotationAngle(door2leftwindowframe4_r1, 0.0F, -0.7854F, 0.0F);
        door2leftwindowframe4_r1.setTextureOffset(130, 0).addBox(-0.25F, -3.5F, -0.25F, 1.0F, 7.0F, 1.0F, 0.0F, false);

        door2leftwindowframe3_r1 = new ModelRenderer(this);
        door2leftwindowframe3_r1.setRotationPoint(-3.0F, 3.5F, 0.25F);
        door2leftwindowframe.addChild(door2leftwindowframe3_r1);
        setRotationAngle(door2leftwindowframe3_r1, 0.0F, -0.7854F, 0.0F);
        door2leftwindowframe3_r1.setTextureOffset(130, 0).addBox(-0.25F, -3.5F, -0.25F, 1.0F, 7.0F, 1.0F, 0.0F, false);

        door2leftwindowframe2_r1 = new ModelRenderer(this);
        door2leftwindowframe2_r1.setRotationPoint(-1.0F, 3.5F, 0.25F);
        door2leftwindowframe.addChild(door2leftwindowframe2_r1);
        setRotationAngle(door2leftwindowframe2_r1, 0.0F, -0.7854F, 0.0F);
        door2leftwindowframe2_r1.setTextureOffset(130, 0).addBox(-0.25F, -3.5F, -0.25F, 1.0F, 7.0F, 1.0F, 0.0F, false);

        door2leftwindowframe1_r1 = new ModelRenderer(this);
        door2leftwindowframe1_r1.setRotationPoint(1.0F, 3.5F, 0.25F);
        door2leftwindowframe.addChild(door2leftwindowframe1_r1);
        setRotationAngle(door2leftwindowframe1_r1, 0.0F, -0.7854F, 0.0F);
        door2leftwindowframe1_r1.setTextureOffset(130, 0).addBox(-0.25F, -3.5F, -0.25F, 1.0F, 7.0F, 1.0F, 0.0F, false);

        door2leftwindowglass = new LightModelRenderer(this);
        door2leftwindowglass.setRotationPoint(0.0F, 0.0F, 0.0F);
        door2leftwindow.addChild(door2leftwindowglass);
        door2leftwindowglass.setTextureOffset(114, 32).addBox(1.5F, -33.75F, -9.625F, 6.0F, 3.0F, 1.0F, 0.0F, false);
        door2leftwindowglass.setTextureOffset(114, 36).addBox(1.5F, -30.75F, -9.625F, 6.0F, 4.0F, 1.0F, 0.0F, false);

        door3 = new ModelRenderer(this);
        door3.setRotationPoint(0.0F, 24.0F, 0.0F);
        setRotationAngle(door3, 0.0F, 3.1416F, 0.0F);
        door3.setTextureOffset(109, 104).addBox(8.5F, -35.0F, -10.5F, 1.0F, 33.0F, 1.0F, 0.0F, false);
        door3.setTextureOffset(72, 0).addBox(-9.5F, -38.5F, -12.0F, 19.0F, 3.0F, 2.0F, 0.0F, false);
        door3.setTextureOffset(109, 104).addBox(-9.5F, -35.0F, -10.5F, 1.0F, 33.0F, 1.0F, 0.0F, false);
        door3.setTextureOffset(72, 16).addBox(-9.5F, -36.0F, -10.5F, 19.0F, 1.0F, 1.0F, 0.0F, false);
        door3.setTextureOffset(82, 30).addBox(-9.0F, -38.0F, -12.125F, 18.0F, 2.0F, 0.0F, 0.0F, false);

        door3right = new ModelRenderer(this);
        door3right.setRotationPoint(0.0F, 0.0F, 0.0F);
        door3.addChild(door3right);
        door3right.setTextureOffset(65, 110).addBox(-8.5F, -35.0F, -10.0F, 1.0F, 33.0F, 1.0F, 0.0F, false);
        door3right.setTextureOffset(0, 122).addBox(-7.5F, -3.0F, -10.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        door3right.setTextureOffset(44, 111).addBox(-1.5F, -35.0F, -10.0F, 1.0F, 33.0F, 1.0F, 0.0F, false);
        door3right.setTextureOffset(0, 0).addBox(-7.5F, -10.0F, -9.75F, 6.0F, 7.0F, 0.0F, 0.0F, false);
        door3right.setTextureOffset(0, 0).addBox(-7.5F, -18.0F, -9.75F, 6.0F, 7.0F, 0.0F, 0.0F, false);
        door3right.setTextureOffset(0, 0).addBox(-7.5F, -26.0F, -9.75F, 6.0F, 7.0F, 0.0F, 0.0F, false);
        door3right.setTextureOffset(0, 120).addBox(-7.5F, -27.0F, -10.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        door3right.setTextureOffset(0, 124).addBox(-7.5F, -35.0F, -10.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        door3right.setTextureOffset(48, 111).addBox(-0.5F, -35.0F, -10.5F, 1.0F, 33.0F, 1.0F, 0.0F, false);
        door3right.setTextureOffset(0, 120).addBox(-7.5F, -11.0F, -10.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        door3right.setTextureOffset(0, 120).addBox(-7.5F, -19.0F, -10.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

        door3rightwindow = new ModelRenderer(this);
        door3rightwindow.setRotationPoint(-9.0F, 0.0F, 0.0F);
        door3right.addChild(door3rightwindow);


        door3rightwindowframe = new ModelRenderer(this);
        door3rightwindowframe.setRotationPoint(4.5F, -34.0F, -9.75F);
        door3rightwindow.addChild(door3rightwindowframe);


        door3rightwindowframe7_r1 = new ModelRenderer(this);
        door3rightwindowframe7_r1.setRotationPoint(0.0F, 0.0F, 0.25F);
        door3rightwindowframe.addChild(door3rightwindowframe7_r1);
        setRotationAngle(door3rightwindowframe7_r1, -0.7854F, 0.0F, 0.0F);
        door3rightwindowframe7_r1.setTextureOffset(130, 1).addBox(-3.0F, -0.75F, -0.25F, 6.0F, 1.0F, 1.0F, 0.0F, false);

        door3rightwindowframe6_r1 = new ModelRenderer(this);
        door3rightwindowframe6_r1.setRotationPoint(0.0F, 3.5F, 0.25F);
        door3rightwindowframe.addChild(door3rightwindowframe6_r1);
        setRotationAngle(door3rightwindowframe6_r1, -0.7854F, 0.0F, 0.0F);
        door3rightwindowframe6_r1.setTextureOffset(130, 5).addBox(-3.0F, -0.75F, -0.25F, 6.0F, 1.0F, 1.0F, 0.0F, false);

        door3rightwindowframe5_r1 = new ModelRenderer(this);
        door3rightwindowframe5_r1.setRotationPoint(0.0F, 7.0F, 0.25F);
        door3rightwindowframe.addChild(door3rightwindowframe5_r1);
        setRotationAngle(door3rightwindowframe5_r1, -0.7854F, 0.0F, 0.0F);
        door3rightwindowframe5_r1.setTextureOffset(130, 5).addBox(-3.0F, -0.75F, -0.25F, 6.0F, 1.0F, 1.0F, 0.0F, false);

        door3rightwindowframe4_r1 = new ModelRenderer(this);
        door3rightwindowframe4_r1.setRotationPoint(3.0F, 3.5F, 0.25F);
        door3rightwindowframe.addChild(door3rightwindowframe4_r1);
        setRotationAngle(door3rightwindowframe4_r1, 0.0F, -0.7854F, 0.0F);
        door3rightwindowframe4_r1.setTextureOffset(130, 0).addBox(-0.25F, -3.5F, -0.25F, 1.0F, 7.0F, 1.0F, 0.0F, false);

        door3rightwindowframe3_r1 = new ModelRenderer(this);
        door3rightwindowframe3_r1.setRotationPoint(-3.0F, 3.5F, 0.25F);
        door3rightwindowframe.addChild(door3rightwindowframe3_r1);
        setRotationAngle(door3rightwindowframe3_r1, 0.0F, -0.7854F, 0.0F);
        door3rightwindowframe3_r1.setTextureOffset(130, 0).addBox(-0.25F, -3.5F, -0.25F, 1.0F, 7.0F, 1.0F, 0.0F, false);

        door3rightwindowframe2_r1 = new ModelRenderer(this);
        door3rightwindowframe2_r1.setRotationPoint(-1.0F, 3.5F, 0.25F);
        door3rightwindowframe.addChild(door3rightwindowframe2_r1);
        setRotationAngle(door3rightwindowframe2_r1, 0.0F, -0.7854F, 0.0F);
        door3rightwindowframe2_r1.setTextureOffset(130, 0).addBox(-0.25F, -3.5F, -0.25F, 1.0F, 7.0F, 1.0F, 0.0F, false);

        door3rightwindowframe1_r1 = new ModelRenderer(this);
        door3rightwindowframe1_r1.setRotationPoint(1.0F, 3.5F, 0.25F);
        door3rightwindowframe.addChild(door3rightwindowframe1_r1);
        setRotationAngle(door3rightwindowframe1_r1, 0.0F, -0.7854F, 0.0F);
        door3rightwindowframe1_r1.setTextureOffset(130, 0).addBox(-0.25F, -3.5F, -0.25F, 1.0F, 7.0F, 1.0F, 0.0F, false);

        door3rightwindowglass = new LightModelRenderer(this);
        door3rightwindowglass.setRotationPoint(0.0F, 0.0F, 0.0F);
        door3rightwindow.addChild(door3rightwindowglass);
        door3rightwindowglass.setTextureOffset(114, 32).addBox(1.5F, -33.75F, -9.625F, 6.0F, 3.0F, 1.0F, 0.0F, false);
        door3rightwindowglass.setTextureOffset(114, 36).addBox(1.5F, -30.75F, -9.625F, 6.0F, 4.0F, 1.0F, 0.0F, false);

        door3left = new ModelRenderer(this);
        door3left.setRotationPoint(0.0F, 0.0F, 0.0F);
        door3.addChild(door3left);
        door3left.setTextureOffset(0, 122).addBox(1.5F, -3.0F, -10.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        door3left.setTextureOffset(44, 111).addBox(0.5F, -35.0F, -10.0F, 1.0F, 33.0F, 1.0F, 0.0F, false);
        door3left.setTextureOffset(65, 110).addBox(7.5F, -35.0F, -10.0F, 1.0F, 33.0F, 1.0F, 0.0F, false);
        door3left.setTextureOffset(0, 120).addBox(1.5F, -11.0F, -10.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        door3left.setTextureOffset(0, 0).addBox(1.5F, -10.0F, -9.75F, 6.0F, 7.0F, 0.0F, 0.0F, false);
        door3left.setTextureOffset(0, 0).addBox(1.5F, -18.0F, -9.75F, 6.0F, 7.0F, 0.0F, 0.0F, false);
        door3left.setTextureOffset(0, 120).addBox(1.5F, -19.0F, -10.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        door3left.setTextureOffset(0, 0).addBox(1.5F, -26.0F, -9.75F, 6.0F, 7.0F, 0.0F, 0.0F, false);
        door3left.setTextureOffset(0, 120).addBox(1.5F, -27.0F, -10.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        door3left.setTextureOffset(0, 124).addBox(1.5F, -35.0F, -10.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

        door3leftwindow = new ModelRenderer(this);
        door3leftwindow.setRotationPoint(0.0F, 0.0F, 0.0F);
        door3left.addChild(door3leftwindow);


        door3leftwindowframe = new ModelRenderer(this);
        door3leftwindowframe.setRotationPoint(4.5F, -34.0F, -9.75F);
        door3leftwindow.addChild(door3leftwindowframe);


        door3leftwindowframe7_r1 = new ModelRenderer(this);
        door3leftwindowframe7_r1.setRotationPoint(0.0F, 0.0F, 0.25F);
        door3leftwindowframe.addChild(door3leftwindowframe7_r1);
        setRotationAngle(door3leftwindowframe7_r1, -0.7854F, 0.0F, 0.0F);
        door3leftwindowframe7_r1.setTextureOffset(130, 1).addBox(-3.0F, -0.75F, -0.25F, 6.0F, 1.0F, 1.0F, 0.0F, false);

        door3leftwindowframe6_r1 = new ModelRenderer(this);
        door3leftwindowframe6_r1.setRotationPoint(0.0F, 3.5F, 0.25F);
        door3leftwindowframe.addChild(door3leftwindowframe6_r1);
        setRotationAngle(door3leftwindowframe6_r1, -0.7854F, 0.0F, 0.0F);
        door3leftwindowframe6_r1.setTextureOffset(130, 5).addBox(-3.0F, -0.75F, -0.25F, 6.0F, 1.0F, 1.0F, 0.0F, false);

        door3leftwindowframe5_r1 = new ModelRenderer(this);
        door3leftwindowframe5_r1.setRotationPoint(0.0F, 7.0F, 0.25F);
        door3leftwindowframe.addChild(door3leftwindowframe5_r1);
        setRotationAngle(door3leftwindowframe5_r1, -0.7854F, 0.0F, 0.0F);
        door3leftwindowframe5_r1.setTextureOffset(130, 5).addBox(-3.0F, -0.75F, -0.25F, 6.0F, 1.0F, 1.0F, 0.0F, false);

        door3leftwindowframe4_r1 = new ModelRenderer(this);
        door3leftwindowframe4_r1.setRotationPoint(3.0F, 3.5F, 0.25F);
        door3leftwindowframe.addChild(door3leftwindowframe4_r1);
        setRotationAngle(door3leftwindowframe4_r1, 0.0F, -0.7854F, 0.0F);
        door3leftwindowframe4_r1.setTextureOffset(130, 0).addBox(-0.25F, -3.5F, -0.25F, 1.0F, 7.0F, 1.0F, 0.0F, false);

        door3leftwindowframe3_r1 = new ModelRenderer(this);
        door3leftwindowframe3_r1.setRotationPoint(-3.0F, 3.5F, 0.25F);
        door3leftwindowframe.addChild(door3leftwindowframe3_r1);
        setRotationAngle(door3leftwindowframe3_r1, 0.0F, -0.7854F, 0.0F);
        door3leftwindowframe3_r1.setTextureOffset(130, 0).addBox(-0.25F, -3.5F, -0.25F, 1.0F, 7.0F, 1.0F, 0.0F, false);

        door3leftwindowframe2_r1 = new ModelRenderer(this);
        door3leftwindowframe2_r1.setRotationPoint(-1.0F, 3.5F, 0.25F);
        door3leftwindowframe.addChild(door3leftwindowframe2_r1);
        setRotationAngle(door3leftwindowframe2_r1, 0.0F, -0.7854F, 0.0F);
        door3leftwindowframe2_r1.setTextureOffset(130, 0).addBox(-0.25F, -3.5F, -0.25F, 1.0F, 7.0F, 1.0F, 0.0F, false);

        door3leftwindowframe1_r1 = new ModelRenderer(this);
        door3leftwindowframe1_r1.setRotationPoint(1.0F, 3.5F, 0.25F);
        door3leftwindowframe.addChild(door3leftwindowframe1_r1);
        setRotationAngle(door3leftwindowframe1_r1, 0.0F, -0.7854F, 0.0F);
        door3leftwindowframe1_r1.setTextureOffset(130, 0).addBox(-0.25F, -3.5F, -0.25F, 1.0F, 7.0F, 1.0F, 0.0F, false);

        door3leftwindowglass = new LightModelRenderer(this);
        door3leftwindowglass.setRotationPoint(0.0F, 0.0F, 0.0F);
        door3leftwindow.addChild(door3leftwindowglass);
        door3leftwindowglass.setTextureOffset(114, 32).addBox(1.5F, -33.75F, -9.625F, 6.0F, 3.0F, 1.0F, 0.0F, false);
        door3leftwindowglass.setTextureOffset(114, 36).addBox(1.5F, -30.75F, -9.625F, 6.0F, 4.0F, 1.0F, 0.0F, false);

        door4 = new ModelRenderer(this);
        door4.setRotationPoint(0.0F, 24.0F, 0.0F);
        setRotationAngle(door4, 0.0F, 1.5708F, 0.0F);
        door4.setTextureOffset(109, 104).addBox(8.5F, -35.0F, -10.5F, 1.0F, 33.0F, 1.0F, 0.0F, false);
        door4.setTextureOffset(109, 104).addBox(-9.5F, -35.0F, -10.5F, 1.0F, 33.0F, 1.0F, 0.0F, false);
        door4.setTextureOffset(72, 16).addBox(-9.5F, -36.0F, -10.5F, 19.0F, 1.0F, 1.0F, 0.0F, false);
        door4.setTextureOffset(72, 0).addBox(-9.5F, -38.5F, -12.0F, 19.0F, 3.0F, 2.0F, 0.0F, false);
        door4.setTextureOffset(82, 30).addBox(-9.0F, -38.0F, -12.125F, 18.0F, 2.0F, 0.0F, 0.0F, false);

        door4right = new ModelRenderer(this);
        door4right.setRotationPoint(0.0F, 0.0F, 0.0F);
        door4.addChild(door4right);
        door4right.setTextureOffset(65, 110).addBox(-8.5F, -35.0F, -10.0F, 1.0F, 33.0F, 1.0F, 0.0F, false);
        door4right.setTextureOffset(0, 122).addBox(-7.5F, -3.0F, -10.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        door4right.setTextureOffset(44, 111).addBox(-1.5F, -35.0F, -10.0F, 1.0F, 33.0F, 1.0F, 0.0F, false);
        door4right.setTextureOffset(0, 0).addBox(-7.5F, -10.0F, -9.75F, 6.0F, 7.0F, 0.0F, 0.0F, false);
        door4right.setTextureOffset(0, 0).addBox(-7.5F, -18.0F, -9.75F, 6.0F, 7.0F, 0.0F, 0.0F, false);
        door4right.setTextureOffset(0, 0).addBox(-7.5F, -26.0F, -9.75F, 6.0F, 7.0F, 0.0F, 0.0F, false);
        door4right.setTextureOffset(0, 120).addBox(-7.5F, -27.0F, -10.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        door4right.setTextureOffset(0, 124).addBox(-7.5F, -35.0F, -10.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        door4right.setTextureOffset(48, 111).addBox(-0.5F, -35.0F, -10.5F, 1.0F, 33.0F, 1.0F, 0.0F, false);
        door4right.setTextureOffset(0, 120).addBox(-7.5F, -11.0F, -10.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        door4right.setTextureOffset(0, 120).addBox(-7.5F, -19.0F, -10.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

        door4rightwindow = new ModelRenderer(this);
        door4rightwindow.setRotationPoint(-9.0F, 0.0F, 0.0F);
        door4right.addChild(door4rightwindow);


        door4rightwindowframe = new ModelRenderer(this);
        door4rightwindowframe.setRotationPoint(4.5F, -34.0F, -9.75F);
        door4rightwindow.addChild(door4rightwindowframe);


        door4rightwindowframe7_r1 = new ModelRenderer(this);
        door4rightwindowframe7_r1.setRotationPoint(0.0F, 0.0F, 0.25F);
        door4rightwindowframe.addChild(door4rightwindowframe7_r1);
        setRotationAngle(door4rightwindowframe7_r1, -0.7854F, 0.0F, 0.0F);
        door4rightwindowframe7_r1.setTextureOffset(130, 1).addBox(-3.0F, -0.75F, -0.25F, 6.0F, 1.0F, 1.0F, 0.0F, false);

        door4rightwindowframe6_r1 = new ModelRenderer(this);
        door4rightwindowframe6_r1.setRotationPoint(0.0F, 3.5F, 0.25F);
        door4rightwindowframe.addChild(door4rightwindowframe6_r1);
        setRotationAngle(door4rightwindowframe6_r1, -0.7854F, 0.0F, 0.0F);
        door4rightwindowframe6_r1.setTextureOffset(130, 5).addBox(-3.0F, -0.75F, -0.25F, 6.0F, 1.0F, 1.0F, 0.0F, false);

        door4rightwindowframe5_r1 = new ModelRenderer(this);
        door4rightwindowframe5_r1.setRotationPoint(0.0F, 7.0F, 0.25F);
        door4rightwindowframe.addChild(door4rightwindowframe5_r1);
        setRotationAngle(door4rightwindowframe5_r1, -0.7854F, 0.0F, 0.0F);
        door4rightwindowframe5_r1.setTextureOffset(130, 4).addBox(-3.0F, -0.75F, -0.25F, 6.0F, 1.0F, 1.0F, 0.0F, false);

        door4rightwindowframe4_r1 = new ModelRenderer(this);
        door4rightwindowframe4_r1.setRotationPoint(3.0F, 3.5F, 0.25F);
        door4rightwindowframe.addChild(door4rightwindowframe4_r1);
        setRotationAngle(door4rightwindowframe4_r1, 0.0F, -0.7854F, 0.0F);
        door4rightwindowframe4_r1.setTextureOffset(130, 0).addBox(-0.25F, -3.5F, -0.25F, 1.0F, 7.0F, 1.0F, 0.0F, false);

        door4rightwindowframe3_r1 = new ModelRenderer(this);
        door4rightwindowframe3_r1.setRotationPoint(-3.0F, 3.5F, 0.25F);
        door4rightwindowframe.addChild(door4rightwindowframe3_r1);
        setRotationAngle(door4rightwindowframe3_r1, 0.0F, -0.7854F, 0.0F);
        door4rightwindowframe3_r1.setTextureOffset(130, 0).addBox(-0.25F, -3.5F, -0.25F, 1.0F, 7.0F, 1.0F, 0.0F, false);

        door4rightwindowframe2_r1 = new ModelRenderer(this);
        door4rightwindowframe2_r1.setRotationPoint(-1.0F, 3.5F, 0.25F);
        door4rightwindowframe.addChild(door4rightwindowframe2_r1);
        setRotationAngle(door4rightwindowframe2_r1, 0.0F, -0.7854F, 0.0F);
        door4rightwindowframe2_r1.setTextureOffset(130, 0).addBox(-0.25F, -3.5F, -0.25F, 1.0F, 7.0F, 1.0F, 0.0F, false);

        door4rightwindowframe1_r1 = new ModelRenderer(this);
        door4rightwindowframe1_r1.setRotationPoint(1.0F, 3.5F, 0.25F);
        door4rightwindowframe.addChild(door4rightwindowframe1_r1);
        setRotationAngle(door4rightwindowframe1_r1, 0.0F, -0.7854F, 0.0F);
        door4rightwindowframe1_r1.setTextureOffset(130, 0).addBox(-0.25F, -3.5F, -0.25F, 1.0F, 7.0F, 1.0F, 0.0F, false);

        door4rightwindowglass = new LightModelRenderer(this);
        door4rightwindowglass.setRotationPoint(0.0F, 0.0F, 0.0F);
        door4rightwindow.addChild(door4rightwindowglass);
        door4rightwindowglass.setTextureOffset(114, 32).addBox(1.5F, -33.75F, -9.625F, 6.0F, 3.0F, 1.0F, 0.0F, false);
        door4rightwindowglass.setTextureOffset(114, 36).addBox(1.5F, -30.75F, -9.625F, 6.0F, 4.0F, 1.0F, 0.0F, false);

        door4left = new ModelRenderer(this);
        door4left.setRotationPoint(0.0F, 0.0F, 0.0F);
        door4.addChild(door4left);
        door4left.setTextureOffset(0, 122).addBox(1.5F, -3.0F, -10.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        door4left.setTextureOffset(44, 111).addBox(0.5F, -35.0F, -10.0F, 1.0F, 33.0F, 1.0F, 0.0F, false);
        door4left.setTextureOffset(65, 110).addBox(7.5F, -35.0F, -10.0F, 1.0F, 33.0F, 1.0F, 0.0F, false);
        door4left.setTextureOffset(0, 120).addBox(1.5F, -11.0F, -10.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        door4left.setTextureOffset(0, 0).addBox(1.5F, -10.0F, -9.75F, 6.0F, 7.0F, 0.0F, 0.0F, false);
        door4left.setTextureOffset(0, 0).addBox(1.5F, -18.0F, -9.75F, 6.0F, 7.0F, 0.0F, 0.0F, false);
        door4left.setTextureOffset(0, 120).addBox(1.5F, -19.0F, -10.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        door4left.setTextureOffset(0, 0).addBox(1.5F, -26.0F, -9.75F, 6.0F, 7.0F, 0.0F, 0.0F, false);
        door4left.setTextureOffset(0, 120).addBox(1.5F, -27.0F, -10.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        door4left.setTextureOffset(0, 124).addBox(1.5F, -35.0F, -10.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

        door4leftwindow = new ModelRenderer(this);
        door4leftwindow.setRotationPoint(0.0F, 0.0F, 0.0F);
        door4left.addChild(door4leftwindow);


        door4leftwindowframe = new ModelRenderer(this);
        door4leftwindowframe.setRotationPoint(4.5F, -34.0F, -9.75F);
        door4leftwindow.addChild(door4leftwindowframe);


        door4leftwindowframe7_r1 = new ModelRenderer(this);
        door4leftwindowframe7_r1.setRotationPoint(0.0F, 0.0F, 0.25F);
        door4leftwindowframe.addChild(door4leftwindowframe7_r1);
        setRotationAngle(door4leftwindowframe7_r1, -0.7854F, 0.0F, 0.0F);
        door4leftwindowframe7_r1.setTextureOffset(130, 1).addBox(-3.0F, -0.75F, -0.25F, 6.0F, 1.0F, 1.0F, 0.0F, false);

        door4leftwindowframe6_r1 = new ModelRenderer(this);
        door4leftwindowframe6_r1.setRotationPoint(0.0F, 3.5F, 0.25F);
        door4leftwindowframe.addChild(door4leftwindowframe6_r1);
        setRotationAngle(door4leftwindowframe6_r1, -0.7854F, 0.0F, 0.0F);
        door4leftwindowframe6_r1.setTextureOffset(130, 5).addBox(-3.0F, -0.75F, -0.25F, 6.0F, 1.0F, 1.0F, 0.0F, false);

        door4leftwindowframe5_r1 = new ModelRenderer(this);
        door4leftwindowframe5_r1.setRotationPoint(0.0F, 7.0F, 0.25F);
        door4leftwindowframe.addChild(door4leftwindowframe5_r1);
        setRotationAngle(door4leftwindowframe5_r1, -0.7854F, 0.0F, 0.0F);
        door4leftwindowframe5_r1.setTextureOffset(130, 4).addBox(-3.0F, -0.75F, -0.25F, 6.0F, 1.0F, 1.0F, 0.0F, false);

        door4leftwindowframe4_r1 = new ModelRenderer(this);
        door4leftwindowframe4_r1.setRotationPoint(3.0F, 3.5F, 0.25F);
        door4leftwindowframe.addChild(door4leftwindowframe4_r1);
        setRotationAngle(door4leftwindowframe4_r1, 0.0F, -0.7854F, 0.0F);
        door4leftwindowframe4_r1.setTextureOffset(130, 0).addBox(-0.25F, -3.5F, -0.25F, 1.0F, 7.0F, 1.0F, 0.0F, false);

        door4leftwindowframe3_r1 = new ModelRenderer(this);
        door4leftwindowframe3_r1.setRotationPoint(-3.0F, 3.5F, 0.25F);
        door4leftwindowframe.addChild(door4leftwindowframe3_r1);
        setRotationAngle(door4leftwindowframe3_r1, 0.0F, -0.7854F, 0.0F);
        door4leftwindowframe3_r1.setTextureOffset(130, 0).addBox(-0.25F, -3.5F, -0.25F, 1.0F, 7.0F, 1.0F, 0.0F, false);

        door4leftwindowframe2_r1 = new ModelRenderer(this);
        door4leftwindowframe2_r1.setRotationPoint(-1.0F, 3.5F, 0.25F);
        door4leftwindowframe.addChild(door4leftwindowframe2_r1);
        setRotationAngle(door4leftwindowframe2_r1, 0.0F, -0.7854F, 0.0F);
        door4leftwindowframe2_r1.setTextureOffset(130, 0).addBox(-0.25F, -3.5F, -0.25F, 1.0F, 7.0F, 1.0F, 0.0F, false);

        door4leftwindowframe1_r1 = new ModelRenderer(this);
        door4leftwindowframe1_r1.setRotationPoint(1.0F, 3.5F, 0.25F);
        door4leftwindowframe.addChild(door4leftwindowframe1_r1);
        setRotationAngle(door4leftwindowframe1_r1, 0.0F, -0.7854F, 0.0F);
        door4leftwindowframe1_r1.setTextureOffset(130, 0).addBox(-0.25F, -3.5F, -0.25F, 1.0F, 7.0F, 1.0F, 0.0F, false);

        door4leftwindowglass = new LightModelRenderer(this);
        door4leftwindowglass.setRotationPoint(0.0F, 0.0F, 0.0F);
        door4leftwindow.addChild(door4leftwindowglass);
        door4leftwindowglass.setTextureOffset(114, 32).addBox(1.5F, -33.75F, -9.625F, 6.0F, 3.0F, 1.0F, 0.0F, false);
        door4leftwindowglass.setTextureOffset(114, 36).addBox(1.5F, -30.75F, -9.625F, 6.0F, 4.0F, 1.0F, 0.0F, false);
    }

	@Override
	public void renderBones(ExteriorTile exterior, float scale, MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float alpha) {
		EnumDoorState state = exterior.getOpen();
		switch (state) {
			case ONE:
				this.door1left.rotateAngleY = (float) Math.toRadians(
						IMDoorType.EnumDoorType.TOYOTA.getRotationForState(EnumDoorState.ONE)); //Only open right door, left door is closed by default
				this.door1right.rotateAngleY = (float) Math.toRadians(
						IMDoorType.EnumDoorType.TOYOTA.getRotationForState(EnumDoorState.CLOSED));
				break;
			case BOTH:
				this.door1left.rotateAngleY = (float) Math.toRadians(
						IMDoorType.EnumDoorType.TOYOTA.getRotationForState(EnumDoorState.ONE));
				this.door1right.rotateAngleY = (float) Math.toRadians(
						IMDoorType.EnumDoorType.TOYOTA.getRotationForState(EnumDoorState.BOTH)); //Open left door,Right door is already open
				break;
			case CLOSED://close both doors
				this.door1left.rotateAngleY = (float) Math.toRadians(
						IMDoorType.EnumDoorType.TOYOTA.getRotationForState(EnumDoorState.CLOSED));
				this.door1right.rotateAngleY = (float) Math.toRadians(
						IMDoorType.EnumDoorType.TOYOTA.getRotationForState(EnumDoorState.CLOSED));
				break;
			default:
				break;
		}
		base.render(matrixStack, buffer, packedLight, packedOverlay,1,1,1, alpha);
		door1.render(matrixStack, buffer, packedLight, packedOverlay,1,1,1, alpha);
		door2.render(matrixStack, buffer, packedLight, packedOverlay,1,1,1, alpha);
		door3.render(matrixStack, buffer, packedLight, packedOverlay,1,1,1, alpha);
		door4.render(matrixStack, buffer, packedLight, packedOverlay,1,1,1, alpha);

        lampglow.setBright(exterior.getLightLevel());
        door1leftwindowglass.setBright(exterior.getLightLevel());
        door1rightwindowglass.setBright(exterior.getLightLevel());
        door2leftwindowglass.setBright(exterior.getLightLevel());
        door2rightwindowglass.setBright(exterior.getLightLevel());
        door3leftwindowglass.setBright(exterior.getLightLevel());
        door3rightwindowglass.setBright(exterior.getLightLevel());
        door4leftwindowglass.setBright(exterior.getLightLevel());
        door4rightwindowglass.setBright(exterior.getLightLevel());
        door1rightsign.setBright(exterior.getLightLevel());
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		base.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		door1.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		door2.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		door3.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		door4.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void renderBoti(ExteriorTile exterior, float scale, MatrixStack matrixStack, IVertexBuilder buffer,
						   int packedLight, int packedOverlay, float alpha) {
		if(exterior.getBotiWorld() != null && exterior.getMatterState() == EnumMatterState.SOLID && exterior.getOpen() != EnumDoorState.CLOSED) {
			PortalInfo info = new PortalInfo();
			info.setPosition(exterior.getPos());
			info.setWorldShell(exterior.getBotiWorld());
			info.setTranslate(matrix -> {
                matrix.rotate(Vector3f.YP.rotationDegrees(WorldHelper.getAngleFromFacing(exterior.getBotiWorld().getPortalDirection())));
                matrix.translate(-0.47f, -0.53f, -1.15f);
				ExteriorRenderer.applyTransforms(matrix, exterior);
			});
			info.setTranslatePortal(matrix -> {
				matrix.translate(0, 0, 0);
				matrix.rotate(Vector3f.XP.rotationDegrees(180));
				matrix.rotate(Vector3f.YP.rotationDegrees(180));
                matrix.translate(-0.55f, 0.2, 0f);
			});

			info.setRenderPortal((matrix, buf) -> {
				matrix.push();
				matrix.scale(1.1F, 1.1F, 1.1F);
                matrix.translate(0.0f, 0, 0);
                this.boti.render(matrix, buf.getBuffer(RenderType.getEntityCutout(ToyotaExteriorRenderer.TEXTURE)), packedLight, packedOverlay);
				matrix.pop();
			});

			info.setRenderDoor((matrix, buf) -> {
				matrix.push();
                matrix.translate(0.03f, -1.68f, 0.55f);
				matrix.scale(1.1F, 1.1F, 1.05F);
				this.door1.render(matrix, buf.getBuffer(RenderType.getEntityCutout(ToyotaExteriorRenderer.TEXTURE)), packedLight, packedOverlay);
				matrix.pop();
			});

            BOTIRenderer.addPortal(info);
		}
	}

    public float emission(ExteriorTile tile){
        float x;
        if(tile.getWorld() != null){
            x = -tile.getWorld().getLight(tile.getPos());
        } else x = tile.getLightLevel();
    return x;
      }
}