package net.tadditions.mod.client.model;// Made with Blockbench 4.10.3
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.vector.Vector3f;
import net.tadditions.mod.client.renderers.FourteenthExteriorRender;
import net.tadditions.mod.helper.IMDoorType;
import net.tardis.mod.client.models.LightModelRenderer;
import net.tardis.mod.client.models.exteriors.ExteriorModel;
import net.tardis.mod.client.renderers.boti.BOTIRenderer;
import net.tardis.mod.client.renderers.boti.PortalInfo;
import net.tardis.mod.client.renderers.exteriors.ExteriorRenderer;
import net.tardis.mod.enums.EnumDoorState;
import net.tardis.mod.enums.EnumMatterState;
import net.tardis.mod.helper.WorldHelper;
import net.tardis.mod.tileentities.exteriors.ExteriorTile;

public class CoralExteriorModel extends ExteriorModel {
	private final ModelRenderer root;
	private final ModelRenderer base;
	private final ModelRenderer lamp;
	private final LightModelRenderer lamp_light;
	private final ModelRenderer side1;
	private final ModelRenderer doors;
	private final ModelRenderer door_l;
	private final LightModelRenderer windows2;
	private final ModelRenderer door_r;
	private final LightModelRenderer windows1;
	private final ModelRenderer side2;
	private final LightModelRenderer windows3;
	private final ModelRenderer side3;
	private final LightModelRenderer windows;
	private final ModelRenderer side4;
	private final LightModelRenderer windows4;
	private final ModelRenderer BOTI;

	public CoralExteriorModel() {
		textureWidth = 256;
		textureHeight = 256;

		root = new ModelRenderer(this);
		root.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		base = new ModelRenderer(this);
		base.setRotationPoint(2.0F, -87.5F, -2.0F);
		root.addChild(base);
		base.setTextureOffset(0, 0).addBox(-24.0F, 83.5F, -20.0F, 44.0F, 4.0F, 44.0F, 0.0F, false);
		base.setTextureOffset(0, 48).addBox(-21.0F, 16.5F, -17.0F, 38.0F, 2.0F, 38.0F, 0.0F, false);
		base.setTextureOffset(0, 88).addBox(-19.0F, 13.0F, -15.0F, 34.0F, 4.0F, 34.0F, 0.0F, false);
		base.setTextureOffset(102, 88).addBox(-17.0F, 11.0F, -13.0F, 30.0F, 2.0F, 30.0F, 0.0F, false);
		base.setTextureOffset(0, 63).addBox(-5.0F, 9.0F, -1.0F, 6.0F, 2.0F, 6.0F, 0.0F, false);
		base.setTextureOffset(14, 55).addBox(-5.0F, 6.6F, -1.0F, 6.0F, 2.0F, 6.0F, -0.8F, false);
		base.setTextureOffset(14, 55).addBox(-5.0F, 4.2F, -1.0F, 6.0F, 2.0F, 6.0F, -0.8F, false);
		base.setTextureOffset(0, 71).addBox(-5.0F, 3.0F, -1.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);
		base.setTextureOffset(24, 40).addBox(-3.5F, 2.0F, 0.5F, 3.0F, 1.0F, 3.0F, 0.0F, false);

		lamp = new ModelRenderer(this);
		lamp.setRotationPoint(-0.5F, 6.5F, 0.5F);
		base.addChild(lamp);
		lamp.setTextureOffset(0, 99).addBox(-4.0F, -2.5F, -1.0F, 5.0F, 5.0F, 5.0F, 0.0F, false);

		lamp_light = new LightModelRenderer(this);
		lamp_light.setRotationPoint(-0.5F, 9.5F, 0.5F);
		lamp.addChild(lamp_light);
		lamp_light.setTextureOffset(0, 88).addBox(-3.5F, -12.5F, -1.5F, 5.0F, 6.0F, 5.0F, -0.5F, false);

		side1 = new ModelRenderer(this);
		side1.setRotationPoint(0.0F, 0.0F, 0.0F);
		root.addChild(side1);
		side1.setTextureOffset(160, 162).addBox(16.0F, -71.0F, -20.0F, 4.0F, 67.0F, 4.0F, 0.0F, false);
		side1.setTextureOffset(20, 48).addBox(14.0F, -74.0F, -18.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
		side1.setTextureOffset(60, 166).addBox(15.0F, -64.0F, -19.0F, 4.0F, 60.0F, 4.0F, 0.0F, false);
		side1.setTextureOffset(114, 56).addBox(-15.0F, -63.0F, -19.0F, 30.0F, 1.0F, 3.0F, 0.0F, false);
		side1.setTextureOffset(114, 48).addBox(-18.0F, -69.0F, -21.0F, 36.0F, 6.0F, 2.0F, 0.0F, false);

		doors = new ModelRenderer(this);
		doors.setRotationPoint(-1.0F, -6.0F, 4.0F);
		side1.addChild(doors);
		

		door_l = new ModelRenderer(this);
		door_l.setRotationPoint(-14.0F, 2.0F, -20.0F);
		doors.addChild(door_l);
		door_l.setTextureOffset(92, 166).addBox(12.0F, -58.0F, -2.0F, 2.0F, 58.0F, 2.0F, 0.0F, false);
		door_l.setTextureOffset(0, 40).addBox(2.0F, -58.0F, -2.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);
		door_l.setTextureOffset(40, 0).addBox(4.75F, -57.0F, -1.9F, 1.0F, 14.0F, 1.0F, -0.25F, false);
		door_l.setTextureOffset(84, 166).addBox(0.0F, -58.0F, -2.0F, 2.0F, 58.0F, 2.0F, 0.0F, false);
		door_l.setTextureOffset(40, 15).addBox(8.25F, -57.0F, -1.9F, 1.0F, 14.0F, 1.0F, -0.25F, false);
		door_l.setTextureOffset(102, 96).addBox(1.5F, -50.5F, -1.9F, 11.0F, 1.0F, 1.0F, -0.25F, false);
		door_l.setTextureOffset(0, 78).addBox(2.0F, -44.0F, -2.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);
		door_l.setTextureOffset(0, 82).addBox(2.0F, -30.0F, -2.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);
		door_l.setTextureOffset(102, 92).addBox(2.0F, -2.0F, -2.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);
		door_l.setTextureOffset(0, 0).addBox(2.0F, -42.0F, -1.4F, 10.0F, 40.0F, 0.0F, 0.0F, false);
		door_l.setTextureOffset(40, 30).addBox(11.0F, -37.0F, -2.4F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		door_l.setTextureOffset(102, 88).addBox(2.0F, -16.0F, -2.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);
		door_l.setTextureOffset(76, 166).addBox(14.0F, -58.0F, -2.6F, 2.0F, 58.0F, 2.0F, 0.0F, false);

		windows2 = new LightModelRenderer(this);
		windows2.setRotationPoint(-1.0F, -46.5F, 20.6F);
		door_l.addChild(windows2);
		windows2.setTextureOffset(0, 48).addBox(3.0F, -10.0F, -22.0F, 10.0F, 13.0F, 0.0F, 0.0F, false);

		door_r = new ModelRenderer(this);
		door_r.setRotationPoint(16.0F, 2.0F, -20.0F);
		doors.addChild(door_r);
		door_r.setTextureOffset(0, 40).addBox(-12.0F, -58.0F, -2.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);
		door_r.setTextureOffset(92, 166).addBox(-2.0F, -58.0F, -2.0F, 2.0F, 58.0F, 2.0F, 0.0F, false);
		door_r.setTextureOffset(0, 78).addBox(-12.0F, -44.0F, -2.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);
		door_r.setTextureOffset(102, 96).addBox(-12.5F, -50.5F, -1.9F, 11.0F, 1.0F, 1.0F, -0.25F, false);
		door_r.setTextureOffset(40, 15).addBox(-5.75F, -57.0F, -1.9F, 1.0F, 14.0F, 1.0F, -0.25F, false);
		door_r.setTextureOffset(40, 0).addBox(-9.25F, -57.0F, -1.9F, 1.0F, 14.0F, 1.0F, -0.25F, false);
		door_r.setTextureOffset(0, 82).addBox(-12.0F, -30.0F, -2.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);
		door_r.setTextureOffset(102, 88).addBox(-12.0F, -16.0F, -2.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);
		door_r.setTextureOffset(20, 0).addBox(-12.0F, -42.0F, -1.4F, 10.0F, 40.0F, 0.0F, 0.0F, false);
		door_r.setTextureOffset(102, 92).addBox(-12.0F, -2.0F, -2.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);
		door_r.setTextureOffset(124, 166).addBox(-14.0F, -58.0F, -2.0F, 2.0F, 58.0F, 2.0F, 0.0F, false);
		door_r.setTextureOffset(39, 39).addBox(-13.5F, -38.0F, -3.1F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		door_r.setTextureOffset(33, 40).addBox(-13.5F, -39.0F, -2.1F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		door_r.setTextureOffset(22, 40).addBox(-13.5F, -35.0F, -2.1F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		windows1 = new LightModelRenderer(this);
		windows1.setRotationPoint(-15.0F, -46.5F, 20.6F);
		door_r.addChild(windows1);
		windows1.setTextureOffset(0, 48).addBox(3.0F, -10.0F, -22.0F, 10.0F, 13.0F, 0.0F, 0.0F, false);

		side2 = new ModelRenderer(this);
		side2.setRotationPoint(0.0F, 0.0F, 0.0F);
		root.addChild(side2);
		setRotationAngle(side2, 0.0F, -1.5708F, 0.0F);
		side2.setTextureOffset(102, 92).addBox(3.0F, -6.0F, -18.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);
		side2.setTextureOffset(112, 126).addBox(-13.0F, -46.0F, -17.4F, 26.0F, 40.0F, 0.0F, 0.0F, false);
		side2.setTextureOffset(102, 92).addBox(-13.0F, -6.0F, -18.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);
		side2.setTextureOffset(102, 88).addBox(3.0F, -20.0F, -18.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);
		side2.setTextureOffset(102, 88).addBox(-13.0F, -20.0F, -18.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);
		side2.setTextureOffset(0, 82).addBox(-13.0F, -34.0F, -18.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);
		side2.setTextureOffset(0, 82).addBox(3.0F, -34.0F, -18.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);
		side2.setTextureOffset(0, 78).addBox(-13.0F, -48.0F, -18.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);
		side2.setTextureOffset(0, 78).addBox(3.0F, -48.0F, -18.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);
		side2.setTextureOffset(40, 0).addBox(5.75F, -61.0F, -17.9F, 1.0F, 14.0F, 1.0F, -0.25F, false);
		side2.setTextureOffset(40, 15).addBox(9.25F, -61.0F, -17.9F, 1.0F, 14.0F, 1.0F, -0.25F, false);
		side2.setTextureOffset(102, 96).addBox(2.5F, -54.5F, -17.9F, 11.0F, 1.0F, 1.0F, -0.25F, false);
		side2.setTextureOffset(102, 96).addBox(-13.5F, -54.5F, -17.9F, 11.0F, 1.0F, 1.0F, -0.25F, false);
		side2.setTextureOffset(40, 15).addBox(-6.75F, -61.0F, -17.9F, 1.0F, 14.0F, 1.0F, -0.25F, false);
		side2.setTextureOffset(40, 0).addBox(-10.25F, -61.0F, -17.9F, 1.0F, 14.0F, 1.0F, -0.25F, false);
		side2.setTextureOffset(0, 40).addBox(-13.0F, -62.0F, -18.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);
		side2.setTextureOffset(0, 40).addBox(3.0F, -62.0F, -18.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);
		side2.setTextureOffset(116, 166).addBox(-3.0F, -62.0F, -18.0F, 2.0F, 58.0F, 2.0F, 0.0F, false);
		side2.setTextureOffset(92, 166).addBox(13.0F, -62.0F, -18.0F, 2.0F, 58.0F, 2.0F, 0.0F, false);
		side2.setTextureOffset(84, 166).addBox(-15.0F, -62.0F, -18.0F, 2.0F, 58.0F, 2.0F, 0.0F, false);
		side2.setTextureOffset(108, 166).addBox(1.0F, -62.0F, -18.0F, 2.0F, 58.0F, 2.0F, 0.0F, false);
		side2.setTextureOffset(100, 166).addBox(-1.0F, -62.0F, -18.6F, 2.0F, 58.0F, 2.0F, 0.0F, false);
		side2.setTextureOffset(160, 162).addBox(16.0F, -71.0F, -20.0F, 4.0F, 67.0F, 4.0F, 0.0F, false);
		side2.setTextureOffset(20, 48).addBox(14.0F, -74.0F, -18.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
		side2.setTextureOffset(60, 166).addBox(15.0F, -64.0F, -19.0F, 4.0F, 60.0F, 4.0F, 0.0F, false);
		side2.setTextureOffset(114, 56).addBox(-15.0F, -63.0F, -19.0F, 30.0F, 1.0F, 3.0F, 0.0F, false);
		side2.setTextureOffset(114, 48).addBox(-18.0F, -69.0F, -21.0F, 36.0F, 6.0F, 2.0F, 0.0F, false);

		windows3 = new LightModelRenderer(this);
		windows3.setRotationPoint(-16.0F, -50.5F, 4.6F);
		side2.addChild(windows3);
		windows3.setTextureOffset(114, 60).addBox(3.0F, -10.0F, -22.0F, 26.0F, 13.0F, 0.0F, 0.0F, false);

		side3 = new ModelRenderer(this);
		side3.setRotationPoint(0.0F, 0.0F, 0.0F);
		root.addChild(side3);
		setRotationAngle(side3, 0.0F, 3.1416F, 0.0F);
		side3.setTextureOffset(102, 92).addBox(3.0F, -6.0F, -18.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);
		side3.setTextureOffset(60, 126).addBox(-13.0F, -46.0F, -17.4F, 26.0F, 40.0F, 0.0F, 0.0F, false);
		side3.setTextureOffset(102, 92).addBox(-13.0F, -6.0F, -18.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);
		side3.setTextureOffset(102, 88).addBox(3.0F, -20.0F, -18.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);
		side3.setTextureOffset(102, 88).addBox(-13.0F, -20.0F, -18.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);
		side3.setTextureOffset(0, 82).addBox(-13.0F, -34.0F, -18.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);
		side3.setTextureOffset(0, 82).addBox(3.0F, -34.0F, -18.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);
		side3.setTextureOffset(0, 78).addBox(-13.0F, -48.0F, -18.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);
		side3.setTextureOffset(0, 78).addBox(3.0F, -48.0F, -18.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);
		side3.setTextureOffset(40, 0).addBox(5.75F, -61.0F, -17.9F, 1.0F, 14.0F, 1.0F, -0.25F, false);
		side3.setTextureOffset(40, 15).addBox(9.25F, -61.0F, -17.9F, 1.0F, 14.0F, 1.0F, -0.25F, false);
		side3.setTextureOffset(102, 96).addBox(2.5F, -54.5F, -17.9F, 11.0F, 1.0F, 1.0F, -0.25F, false);
		side3.setTextureOffset(102, 96).addBox(-13.5F, -54.5F, -17.9F, 11.0F, 1.0F, 1.0F, -0.25F, false);
		side3.setTextureOffset(40, 15).addBox(-6.75F, -61.0F, -17.9F, 1.0F, 14.0F, 1.0F, -0.25F, false);
		side3.setTextureOffset(40, 0).addBox(-10.25F, -61.0F, -17.9F, 1.0F, 14.0F, 1.0F, -0.25F, false);
		side3.setTextureOffset(0, 40).addBox(-13.0F, -62.0F, -18.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);
		side3.setTextureOffset(0, 40).addBox(3.0F, -62.0F, -18.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);
		side3.setTextureOffset(92, 166).addBox(-3.0F, -62.0F, -18.0F, 2.0F, 58.0F, 2.0F, 0.0F, false);
		side3.setTextureOffset(92, 166).addBox(13.0F, -62.0F, -18.0F, 2.0F, 58.0F, 2.0F, 0.0F, false);
		side3.setTextureOffset(84, 166).addBox(-15.0F, -62.0F, -18.0F, 2.0F, 58.0F, 2.0F, 0.0F, false);
		side3.setTextureOffset(84, 166).addBox(1.0F, -62.0F, -18.0F, 2.0F, 58.0F, 2.0F, 0.0F, false);
		side3.setTextureOffset(76, 166).addBox(-1.0F, -62.0F, -18.6F, 2.0F, 58.0F, 2.0F, 0.0F, false);
		side3.setTextureOffset(160, 162).addBox(16.0F, -71.0F, -20.0F, 4.0F, 67.0F, 4.0F, 0.0F, false);
		side3.setTextureOffset(20, 48).addBox(14.0F, -74.0F, -18.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
		side3.setTextureOffset(60, 166).addBox(15.0F, -64.0F, -19.0F, 4.0F, 60.0F, 4.0F, 0.0F, false);
		side3.setTextureOffset(114, 56).addBox(-15.0F, -63.0F, -19.0F, 30.0F, 1.0F, 3.0F, 0.0F, false);
		side3.setTextureOffset(114, 48).addBox(-18.0F, -69.0F, -21.0F, 36.0F, 6.0F, 2.0F, 0.0F, false);

		windows = new LightModelRenderer(this);
		windows.setRotationPoint(-16.0F, -50.5F, 4.6F);
		side3.addChild(windows);
		windows.setTextureOffset(114, 60).addBox(3.0F, -10.0F, -22.0F, 26.0F, 13.0F, 0.0F, 0.0F, false);

		side4 = new ModelRenderer(this);
		side4.setRotationPoint(0.0F, 0.0F, 0.0F);
		root.addChild(side4);
		setRotationAngle(side4, 0.0F, 1.5708F, 0.0F);
		side4.setTextureOffset(102, 92).addBox(3.0F, -6.0F, -18.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);
		side4.setTextureOffset(60, 126).addBox(-13.0F, -46.0F, -17.4F, 26.0F, 40.0F, 0.0F, 0.0F, false);
		side4.setTextureOffset(102, 92).addBox(-13.0F, -6.0F, -18.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);
		side4.setTextureOffset(102, 88).addBox(3.0F, -20.0F, -18.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);
		side4.setTextureOffset(102, 88).addBox(-13.0F, -20.0F, -18.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);
		side4.setTextureOffset(0, 82).addBox(-13.0F, -34.0F, -18.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);
		side4.setTextureOffset(0, 82).addBox(3.0F, -34.0F, -18.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);
		side4.setTextureOffset(0, 78).addBox(-13.0F, -48.0F, -18.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);
		side4.setTextureOffset(0, 78).addBox(3.0F, -48.0F, -18.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);
		side4.setTextureOffset(40, 0).addBox(5.75F, -61.0F, -17.9F, 1.0F, 14.0F, 1.0F, -0.25F, false);
		side4.setTextureOffset(40, 15).addBox(9.25F, -61.0F, -17.9F, 1.0F, 14.0F, 1.0F, -0.25F, false);
		side4.setTextureOffset(102, 96).addBox(2.5F, -54.5F, -17.9F, 11.0F, 1.0F, 1.0F, -0.25F, false);
		side4.setTextureOffset(102, 96).addBox(-13.5F, -54.5F, -17.9F, 11.0F, 1.0F, 1.0F, -0.25F, false);
		side4.setTextureOffset(40, 15).addBox(-6.75F, -61.0F, -17.9F, 1.0F, 14.0F, 1.0F, -0.25F, false);
		side4.setTextureOffset(40, 0).addBox(-10.25F, -61.0F, -17.9F, 1.0F, 14.0F, 1.0F, -0.25F, false);
		side4.setTextureOffset(0, 40).addBox(-13.0F, -62.0F, -18.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);
		side4.setTextureOffset(0, 40).addBox(3.0F, -62.0F, -18.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);
		side4.setTextureOffset(92, 166).addBox(-3.0F, -62.0F, -18.0F, 2.0F, 58.0F, 2.0F, 0.0F, false);
		side4.setTextureOffset(92, 166).addBox(13.0F, -62.0F, -18.0F, 2.0F, 58.0F, 2.0F, 0.0F, false);
		side4.setTextureOffset(84, 166).addBox(-15.0F, -62.0F, -18.0F, 2.0F, 58.0F, 2.0F, 0.0F, false);
		side4.setTextureOffset(84, 166).addBox(1.0F, -62.0F, -18.0F, 2.0F, 58.0F, 2.0F, 0.0F, false);
		side4.setTextureOffset(76, 166).addBox(-1.0F, -62.0F, -18.6F, 2.0F, 58.0F, 2.0F, 0.0F, false);
		side4.setTextureOffset(160, 162).addBox(16.0F, -71.0F, -20.0F, 4.0F, 67.0F, 4.0F, 0.0F, false);
		side4.setTextureOffset(20, 48).addBox(14.0F, -74.0F, -18.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
		side4.setTextureOffset(60, 166).addBox(15.0F, -64.0F, -19.0F, 4.0F, 60.0F, 4.0F, 0.0F, false);
		side4.setTextureOffset(114, 56).addBox(-15.0F, -63.0F, -19.0F, 30.0F, 1.0F, 3.0F, 0.0F, false);
		side4.setTextureOffset(114, 48).addBox(-18.0F, -69.0F, -21.0F, 36.0F, 6.0F, 2.0F, 0.0F, false);

		windows4 = new LightModelRenderer(this);
		windows4.setRotationPoint(-16.0F, -50.5F, 4.6F);
		side4.addChild(windows4);
		windows4.setTextureOffset(114, 60).addBox(3.0F, -10.0F, -22.0F, 26.0F, 13.0F, 0.0F, 0.0F, false);

		BOTI = new ModelRenderer(this);
		BOTI.setRotationPoint(0.0F, 0.0F, 0.0F);
		root.addChild(BOTI);
		BOTI.setTextureOffset(0, 126).addBox(-15.0F, -62.0F, -16.001F, 30.0F, 58.0F, 0.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		root.render(matrixStack, buffer, packedLight, packedOverlay,1,1,1, alpha);
	}

	@Override
	public void renderBones(ExteriorTile exterior, float scale, MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float alpha) {
		EnumDoorState state = exterior.getOpen();
		switch (state) {
			case ONE:
				this.door_r.rotateAngleY = (float) Math.toRadians(
						IMDoorType.EnumDoorType.CORAL.getRotationForState(EnumDoorState.ONE)); //Only open right door, left door is closed by default
				this.door_l.rotateAngleY = (float) Math.toRadians(
						IMDoorType.EnumDoorType.CORAL.getRotationForState(EnumDoorState.CLOSED));
				break;
			case BOTH:
				this.door_r.rotateAngleY = (float) Math.toRadians(
						IMDoorType.EnumDoorType.CORAL.getRotationForState(EnumDoorState.ONE));
				this.door_l.rotateAngleY = (float) Math.toRadians(
						IMDoorType.EnumDoorType.CORAL.getRotationForState(EnumDoorState.BOTH)); //Open left door,Right door is already open
				break;
			case CLOSED://close both doors
				this.door_r.rotateAngleY = (float) Math.toRadians(
						IMDoorType.EnumDoorType.CORAL.getRotationForState(EnumDoorState.CLOSED));
				this.door_l.rotateAngleY = (float) Math.toRadians(
						IMDoorType.EnumDoorType.CORAL.getRotationForState(EnumDoorState.CLOSED));
				break;
			default:
				break;
		}
		root.render(matrixStack, buffer, packedLight, packedOverlay,1,1,1, alpha);
		lamp_light.setBright(exterior.getLightLevel());
		windows.setBright(exterior.getLightLevel());
		windows1.setBright(exterior.getLightLevel());
		windows2.setBright(exterior.getLightLevel());
		windows3.setBright(exterior.getLightLevel());
		windows4.setBright(exterior.getLightLevel());
	}

	@Override
	public void renderBoti(ExteriorTile exterior, float scale, MatrixStack matrixStack, IVertexBuilder buffer,
						   int packedLight, int packedOverlay, float alpha) {
		if (exterior.getBotiWorld() != null && exterior.getMatterState() == EnumMatterState.SOLID && exterior.getOpen() != EnumDoorState.CLOSED) {
			PortalInfo info = new PortalInfo();
			info.setPosition(exterior.getPos());
			info.setWorldShell(exterior.getBotiWorld());
			info.setTranslate(matrix -> {
				if(exterior.getBlockState().get(BlockStateProperties.HORIZONTAL_FACING) == Direction.NORTH){
					matrix.translate(-0.5, 0.25, -0.51);
				}
				if(exterior.getBlockState().get(BlockStateProperties.HORIZONTAL_FACING) == Direction.SOUTH){
					matrix.translate(-0.5, 0.25, -0.49);
				}
				if(exterior.getBlockState().get(BlockStateProperties.HORIZONTAL_FACING) == Direction.WEST){
					matrix.translate(-0.51, 0.25, -0.5);
				}
				if(exterior.getBlockState().get(BlockStateProperties.HORIZONTAL_FACING) == Direction.EAST){
					matrix.translate(-0.49, 0.25, -0.5);
				}
				ExteriorRenderer.applyTransforms(matrix, exterior);
			});
			info.setTranslatePortal(matrix -> {
				matrix.translate(0, 0.2, 0);
				matrix.rotate(Vector3f.XP.rotationDegrees(180));
				matrix.rotate(Vector3f.YP.rotationDegrees(180));
				matrix.rotate(Vector3f.YP.rotationDegrees(WorldHelper.getAngleFromFacing(exterior.getBotiWorld().getPortalDirection())));
				matrix.translate(-0.5, -0.5, -0.45);
			});

			info.setRenderPortal((matrix, buf) -> {
				matrix.push();
				matrix.scale(0.55F, 0.55F, 0.55F);
				this.BOTI.render(matrix, buf.getBuffer(RenderType.getEntityCutout(FourteenthExteriorRender.TEXTURE)), packedLight, packedOverlay);
				matrix.pop();
			});

			info.setRenderDoor((matrix, buf) -> {
				matrix.push();
				matrix.scale(0.55F, 0.55F, 0.55F);
				this.doors.render(matrix, buf.getBuffer(RenderType.getEntityCutout(FourteenthExteriorRender.TEXTURE)), packedLight, packedOverlay);
				matrix.pop();
			});

			BOTIRenderer.addPortal(info);

		}
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}