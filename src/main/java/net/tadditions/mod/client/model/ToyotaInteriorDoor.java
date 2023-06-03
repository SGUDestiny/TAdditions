package net.tadditions.mod.client.model;// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;
import net.tadditions.mod.QolMod;
import net.tardis.mod.cap.Capabilities;
import net.tardis.mod.client.models.LightModelRenderer;
import net.tardis.mod.client.models.interiordoors.AbstractInteriorDoorModel;
import net.tardis.mod.client.renderers.boti.BOTIRenderer;
import net.tardis.mod.client.renderers.boti.PortalInfo;
import net.tardis.mod.client.renderers.entity.DoorRenderer;
import net.tardis.mod.client.renderers.exteriors.SteamExteriorRenderer;
import net.tardis.mod.entity.DoorEntity;
import net.tardis.mod.enums.EnumDoorState;
import net.tardis.mod.helper.TardisHelper;
import net.tardis.mod.helper.WorldHelper;
import net.tardis.mod.misc.IDoorType;
import net.tardis.mod.tileentities.ConsoleTile;

public class ToyotaInteriorDoor extends AbstractInteriorDoorModel {
	public ResourceLocation TEXTURE = new ResourceLocation(QolMod.MOD_ID, "textures/exteriors/toyota_door.png");

	private final ModelRenderer Interior_doors;
	private final ModelRenderer Door_frame;
	private final ModelRenderer door3;
	private final ModelRenderer Door_3_right;
	private final ModelRenderer door_3_right_window;
	private final ModelRenderer door_3_right_window_frame;
	private final ModelRenderer Door_3_right_window_frame_6_r1;
	private final ModelRenderer Door_3_right_window_frame_5_r1;
	private final ModelRenderer Door_3_right_window_frame_5_r2;
	private final ModelRenderer Door_3_right_window_frame_4_r1;
	private final ModelRenderer Door_3_right_window_frame_3_r1;
	private final ModelRenderer Door_3_right_window_frame_2_r1;
	private final ModelRenderer Door_3_right_window_frame_1_r1;
	private final LightModelRenderer door_3_right_window_glass_glow;
	private final ModelRenderer Door_left;
	private final ModelRenderer door_3_left_window;
	private final ModelRenderer door_3_left_window_frame;
	private final ModelRenderer door_3_left_window_frame_7_r1;
	private final ModelRenderer door_3_left_window_frame_6_r1;
	private final ModelRenderer door_3_left_window_frame_5_r1;
	private final ModelRenderer door_3_left_window_frame_4_r1;
	private final ModelRenderer door_3_left_window_frame_3_r1;
	private final ModelRenderer door_3_left_window_frame_2_r1;
	private final ModelRenderer door_3_left_window_frame_1_r1;
	private final LightModelRenderer door_3_left_window_glass_glow;
	private final ModelRenderer Door_frame_accent;
	private final LightModelRenderer Door_frame_accent_glow;
	private final ModelRenderer SOTO;


	public ToyotaInteriorDoor() {
		textureWidth = 256;
		textureHeight = 256;

		Interior_doors = new ModelRenderer(this);
		Interior_doors.setRotationPoint(0.0F, 24.0F, 0.0F);


		Door_frame = new ModelRenderer(this);
		Door_frame.setRotationPoint(0.0F, 0.0F, 0.0F);
		Interior_doors.addChild(Door_frame);
		Door_frame.setTextureOffset(42, 72).addBox(9.0F, -37.0F, 0.0F, 2.0F, 37.0F, 2.0F, 0.0F, true);
		Door_frame.setTextureOffset(42, 72).addBox(-11.0F, -37.0F, 0.0F, 2.0F, 37.0F, 2.0F, 0.0F, false);
		Door_frame.setTextureOffset(72, 10).addBox(-9.0F, -37.0F, 0.0F, 18.0F, 1.0F, 2.0F, 0.0F, false);

		door3 = new ModelRenderer(this);
		door3.setRotationPoint(0.0F, 0.0F, 0.0F);
		Interior_doors.addChild(door3);
		setRotationAngle(door3, 0.0F, 3.1416F, 0.0F);
		door3.setTextureOffset(82, 30).addBox(-9.0F, -36.0F, -2.625F, 18.0F, 2.0F, 0.0F, 0.0F, false);
		door3.setTextureOffset(72, 0).addBox(-9.5F, -36.5F, -2.5F, 19.0F, 3.0F, 2.0F, 0.0F, false);
		door3.setTextureOffset(109, 104).addBox(8.5F, -33.0F, -1.5F, 1.0F, 33.0F, 1.0F, 0.0F, false);
		door3.setTextureOffset(109, 104).addBox(-9.5F, -33.0F, -1.5F, 1.0F, 33.0F, 1.0F, 0.0F, false);
		door3.setTextureOffset(109, 104).addBox(-9.5F, -33.0F, -0.75F, 1.0F, 33.0F, 1.0F, 0.0F, false);
		door3.setTextureOffset(72, 16).addBox(-9.5F, -34.0F, -1.5F, 19.0F, 1.0F, 1.0F, 0.0F, false);
		door3.setTextureOffset(72, 16).addBox(-9.5F, -34.0F, -1.5F, 19.0F, 1.0F, 1.0F, 0.0F, false);

		Door_3_right = new ModelRenderer(this);
		Door_3_right.setRotationPoint(-8.5F, -16.5F, -1.0F);
		door3.addChild(Door_3_right);
		Door_3_right.setTextureOffset(65, 110).addBox(0.0F, -16.5F, 0.0F, 1.0F, 33.0F, 1.0F, 0.0F, false);
		Door_3_right.setTextureOffset(0, 122).addBox(1.0F, 15.5F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Door_3_right.setTextureOffset(44, 111).addBox(7.0F, -16.5F, 0.0F, 1.0F, 33.0F, 1.0F, 0.0F, false);
		Door_3_right.setTextureOffset(0, 0).addBox(1.0F, 8.5F, 0.25F, 6.0F, 7.0F, 0.0F, 0.0F, false);
		Door_3_right.setTextureOffset(122, 111).addBox(1.0F, 8.5F, 1.5F, 6.0F, 7.0F, 0.0F, 0.0F, false);
		Door_3_right.setTextureOffset(0, 0).addBox(1.0F, 0.5F, 0.25F, 6.0F, 7.0F, 0.0F, 0.0F, false);
		Door_3_right.setTextureOffset(122, 111).addBox(1.0F, 0.5F, 1.5F, 6.0F, 7.0F, 0.0F, 0.0F, false);
		Door_3_right.setTextureOffset(0, 0).addBox(1.0F, -7.5F, 0.25F, 6.0F, 7.0F, 0.0F, 0.0F, false);
		Door_3_right.setTextureOffset(122, 111).addBox(1.0F, -7.5F, 1.5F, 6.0F, 7.0F, 0.0F, 0.0F, false);
		Door_3_right.setTextureOffset(155, 33).addBox(1.5F, -7.0F, 0.125F, 5.0F, 6.0F, 0.0F, 0.0F, false);
		Door_3_right.setTextureOffset(146, 132).addBox(3.0F, -5.0F, 1.625F, 2.0F, 2.0F, 0.0F, 0.0F, false);
		Door_3_right.setTextureOffset(0, 120).addBox(1.0F, -8.5F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Door_3_right.setTextureOffset(0, 124).addBox(1.0F, -16.5F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Door_3_right.setTextureOffset(48, 111).addBox(8.0F, -16.5F, -0.5F, 1.0F, 33.0F, 1.0F, 0.0F, false);
		Door_3_right.setTextureOffset(0, 120).addBox(1.0F, 7.5F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Door_3_right.setTextureOffset(0, 120).addBox(1.0F, -0.5F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Door_3_right.setTextureOffset(176, 222).addBox(8.0F, -16.5F, 0.5F, 1.0F, 33.0F, 1.0F, 0.0F, false);
		Door_3_right.setTextureOffset(172, 222).addBox(7.0F, -16.5F, 0.75F, 1.0F, 33.0F, 1.0F, 0.0F, false);
		Door_3_right.setTextureOffset(128, 231).addBox(1.0F, -8.5F, 0.75F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Door_3_right.setTextureOffset(128, 235).addBox(1.0F, -16.5F, 0.75F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Door_3_right.setTextureOffset(193, 221).addBox(0.0F, -16.5F, 0.75F, 1.0F, 33.0F, 1.0F, 0.0F, false);
		Door_3_right.setTextureOffset(128, 233).addBox(1.0F, 15.5F, 0.75F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Door_3_right.setTextureOffset(128, 231).addBox(1.0F, 7.5F, 0.75F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Door_3_right.setTextureOffset(128, 231).addBox(1.0F, -0.5F, 0.75F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		door_3_right_window = new ModelRenderer(this);
		door_3_right_window.setRotationPoint(-0.5F, 16.5F, 1.0F);
		Door_3_right.addChild(door_3_right_window);


		door_3_right_window_frame = new ModelRenderer(this);
		door_3_right_window_frame.setRotationPoint(4.5F, -34.0F, -9.75F);
		door_3_right_window.addChild(door_3_right_window_frame);


		Door_3_right_window_frame_6_r1 = new ModelRenderer(this);
		Door_3_right_window_frame_6_r1.setRotationPoint(0.0F, 0.0F, 0.25F);
		door_3_right_window_frame.addChild(Door_3_right_window_frame_6_r1);
		setRotationAngle(Door_3_right_window_frame_6_r1, -0.7854F, 0.0F, 0.0F);
		Door_3_right_window_frame_6_r1.setTextureOffset(130, 1).addBox(-3.0F, -5.6997F, 7.5282F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		Door_3_right_window_frame_5_r1 = new ModelRenderer(this);
		Door_3_right_window_frame_5_r1.setRotationPoint(0.0F, 3.5F, 0.25F);
		door_3_right_window_frame.addChild(Door_3_right_window_frame_5_r1);
		setRotationAngle(Door_3_right_window_frame_5_r1, -0.7854F, 0.0F, 0.0F);
		Door_3_right_window_frame_5_r1.setTextureOffset(130, 5).addBox(-3.0F, -5.6997F, 7.5282F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		Door_3_right_window_frame_5_r2 = new ModelRenderer(this);
		Door_3_right_window_frame_5_r2.setRotationPoint(0.0F, 7.0F, 0.25F);
		door_3_right_window_frame.addChild(Door_3_right_window_frame_5_r2);
		setRotationAngle(Door_3_right_window_frame_5_r2, -0.7854F, 0.0F, 0.0F);
		Door_3_right_window_frame_5_r2.setTextureOffset(130, 5).addBox(-3.0F, -5.6997F, 7.5282F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		Door_3_right_window_frame_4_r1 = new ModelRenderer(this);
		Door_3_right_window_frame_4_r1.setRotationPoint(3.0F, 3.5F, 0.25F);
		door_3_right_window_frame.addChild(Door_3_right_window_frame_4_r1);
		setRotationAngle(Door_3_right_window_frame_4_r1, 0.0F, -0.7854F, 0.0F);
		Door_3_right_window_frame_4_r1.setTextureOffset(130, 0).addBox(6.114F, -1.5F, 6.114F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		Door_3_right_window_frame_3_r1 = new ModelRenderer(this);
		Door_3_right_window_frame_3_r1.setRotationPoint(-3.0F, 3.5F, 0.25F);
		door_3_right_window_frame.addChild(Door_3_right_window_frame_3_r1);
		setRotationAngle(Door_3_right_window_frame_3_r1, 0.0F, -0.7854F, 0.0F);
		Door_3_right_window_frame_3_r1.setTextureOffset(130, 0).addBox(6.114F, -1.5F, 6.114F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		Door_3_right_window_frame_2_r1 = new ModelRenderer(this);
		Door_3_right_window_frame_2_r1.setRotationPoint(-1.0F, 3.5F, 0.25F);
		door_3_right_window_frame.addChild(Door_3_right_window_frame_2_r1);
		setRotationAngle(Door_3_right_window_frame_2_r1, 0.0F, -0.7854F, 0.0F);
		Door_3_right_window_frame_2_r1.setTextureOffset(130, 0).addBox(6.114F, -1.5F, 6.114F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		Door_3_right_window_frame_1_r1 = new ModelRenderer(this);
		Door_3_right_window_frame_1_r1.setRotationPoint(1.0F, 3.5F, 0.25F);
		door_3_right_window_frame.addChild(Door_3_right_window_frame_1_r1);
		setRotationAngle(Door_3_right_window_frame_1_r1, 0.0F, -0.7854F, 0.0F);
		Door_3_right_window_frame_1_r1.setTextureOffset(130, 0).addBox(6.114F, -1.5F, 6.114F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		door_3_right_window_glass_glow = new LightModelRenderer(this);
		door_3_right_window_glass_glow.setRotationPoint(0.0F, 0.0F, 0.0F);
		door_3_right_window.addChild(door_3_right_window_glass_glow);
		door_3_right_window_glass_glow.setTextureOffset(114, 32).addBox(1.5F, -31.75F, -0.625F, 6.0F, 3.0F, 1.0F, 0.0F, false);
		door_3_right_window_glass_glow.setTextureOffset(114, 36).addBox(1.5F, -28.75F, -0.625F, 6.0F, 4.0F, 1.0F, 0.0F, false);

		Door_left = new ModelRenderer(this);
		Door_left.setRotationPoint(8.5F, -16.5F, -1.0F);
		door3.addChild(Door_left);
		Door_left.setTextureOffset(0, 122).addBox(-7.0F, 15.5F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Door_left.setTextureOffset(44, 111).addBox(-8.0F, -16.5F, 0.0F, 1.0F, 33.0F, 1.0F, 0.0F, false);
		Door_left.setTextureOffset(65, 110).addBox(-1.0F, -16.5F, 0.0F, 1.0F, 33.0F, 1.0F, 0.0F, false);
		Door_left.setTextureOffset(0, 120).addBox(-7.0F, 7.5F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Door_left.setTextureOffset(0, 0).addBox(-7.0F, 8.5F, 0.25F, 6.0F, 7.0F, 0.0F, 0.0F, false);
		Door_left.setTextureOffset(122, 111).addBox(-7.0F, 8.5F, 1.5F, 6.0F, 7.0F, 0.0F, 0.0F, false);
		Door_left.setTextureOffset(0, 0).addBox(-7.0F, 0.5F, 0.25F, 6.0F, 7.0F, 0.0F, 0.0F, false);
		Door_left.setTextureOffset(122, 111).addBox(-7.0F, 0.5F, 1.5F, 6.0F, 7.0F, 0.0F, 0.0F, false);
		Door_left.setTextureOffset(0, 0).addBox(-7.0F, -7.5F, 0.25F, 6.0F, 7.0F, 0.0F, 0.0F, false);
		Door_left.setTextureOffset(122, 111).addBox(-7.0F, -7.5F, 1.5F, 6.0F, 7.0F, 0.0F, 0.0F, false);
		Door_left.setTextureOffset(0, 120).addBox(-7.0F, -0.5F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Door_left.setTextureOffset(23, 176).addBox(-7.0F, -7.5F, -1.75F, 6.0F, 7.0F, 2.0F, 0.0F, false);
		Door_left.setTextureOffset(7, 0).addBox(-5.0F, -5.0F, 0.125F, 2.0F, 2.0F, 0.0F, 0.0F, false);
		Door_left.setTextureOffset(0, 120).addBox(-7.0F, -8.5F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Door_left.setTextureOffset(0, 124).addBox(-7.0F, -16.5F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Door_left.setTextureOffset(193, 221).addBox(-1.0F, -16.5F, 0.75F, 1.0F, 33.0F, 1.0F, 0.0F, false);
		Door_left.setTextureOffset(128, 231).addBox(-7.0F, 7.5F, 0.75F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Door_left.setTextureOffset(128, 233).addBox(-7.0F, 15.5F, 0.75F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Door_left.setTextureOffset(172, 222).addBox(-8.0F, -16.5F, 1.0F, 1.0F, 33.0F, 1.0F, 0.0F, false);
		Door_left.setTextureOffset(128, 231).addBox(-7.0F, -0.5F, 0.75F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Door_left.setTextureOffset(128, 231).addBox(-7.0F, -8.5F, 0.75F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Door_left.setTextureOffset(128, 235).addBox(-7.0F, -16.5F, 0.75F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Door_left.setTextureOffset(180, 229).addBox(-6.5F, -7.0F, 1.61F, 5.0F, 6.0F, 0.0F, 0.0F, false);

		door_3_left_window = new ModelRenderer(this);
		door_3_left_window.setRotationPoint(-8.5F, 16.5F, 1.0F);
		Door_left.addChild(door_3_left_window);


		door_3_left_window_frame = new ModelRenderer(this);
		door_3_left_window_frame.setRotationPoint(4.5F, -34.0F, -9.75F);
		door_3_left_window.addChild(door_3_left_window_frame);


		door_3_left_window_frame_7_r1 = new ModelRenderer(this);
		door_3_left_window_frame_7_r1.setRotationPoint(0.0F, 0.0F, 0.25F);
		door_3_left_window_frame.addChild(door_3_left_window_frame_7_r1);
		setRotationAngle(door_3_left_window_frame_7_r1, -0.7854F, 0.0F, 0.0F);
		door_3_left_window_frame_7_r1.setTextureOffset(130, 1).addBox(-3.0F, -5.6997F, 7.5282F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		door_3_left_window_frame_6_r1 = new ModelRenderer(this);
		door_3_left_window_frame_6_r1.setRotationPoint(0.0F, 3.5F, 0.25F);
		door_3_left_window_frame.addChild(door_3_left_window_frame_6_r1);
		setRotationAngle(door_3_left_window_frame_6_r1, -0.7854F, 0.0F, 0.0F);
		door_3_left_window_frame_6_r1.setTextureOffset(130, 5).addBox(-3.0F, -5.6997F, 7.5282F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		door_3_left_window_frame_5_r1 = new ModelRenderer(this);
		door_3_left_window_frame_5_r1.setRotationPoint(0.0F, 7.0F, 0.25F);
		door_3_left_window_frame.addChild(door_3_left_window_frame_5_r1);
		setRotationAngle(door_3_left_window_frame_5_r1, -0.7854F, 0.0F, 0.0F);
		door_3_left_window_frame_5_r1.setTextureOffset(130, 5).addBox(-3.0F, -5.6997F, 7.5282F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		door_3_left_window_frame_4_r1 = new ModelRenderer(this);
		door_3_left_window_frame_4_r1.setRotationPoint(3.0F, 3.5F, 0.25F);
		door_3_left_window_frame.addChild(door_3_left_window_frame_4_r1);
		setRotationAngle(door_3_left_window_frame_4_r1, 0.0F, -0.7854F, 0.0F);
		door_3_left_window_frame_4_r1.setTextureOffset(130, 0).addBox(6.114F, -1.5F, 6.114F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		door_3_left_window_frame_3_r1 = new ModelRenderer(this);
		door_3_left_window_frame_3_r1.setRotationPoint(-3.0F, 3.5F, 0.25F);
		door_3_left_window_frame.addChild(door_3_left_window_frame_3_r1);
		setRotationAngle(door_3_left_window_frame_3_r1, 0.0F, -0.7854F, 0.0F);
		door_3_left_window_frame_3_r1.setTextureOffset(130, 0).addBox(6.114F, -1.5F, 6.114F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		door_3_left_window_frame_2_r1 = new ModelRenderer(this);
		door_3_left_window_frame_2_r1.setRotationPoint(-1.0F, 3.5F, 0.25F);
		door_3_left_window_frame.addChild(door_3_left_window_frame_2_r1);
		setRotationAngle(door_3_left_window_frame_2_r1, 0.0F, -0.7854F, 0.0F);
		door_3_left_window_frame_2_r1.setTextureOffset(130, 0).addBox(6.114F, -1.5F, 6.114F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		door_3_left_window_frame_1_r1 = new ModelRenderer(this);
		door_3_left_window_frame_1_r1.setRotationPoint(1.0F, 3.5F, 0.25F);
		door_3_left_window_frame.addChild(door_3_left_window_frame_1_r1);
		setRotationAngle(door_3_left_window_frame_1_r1, 0.0F, -0.7854F, 0.0F);
		door_3_left_window_frame_1_r1.setTextureOffset(130, 0).addBox(6.114F, -1.5F, 6.114F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		door_3_left_window_glass_glow = new LightModelRenderer(this);
		door_3_left_window_glass_glow.setRotationPoint(0.0F, 0.0F, 0.0F);
		door_3_left_window.addChild(door_3_left_window_glass_glow);
		door_3_left_window_glass_glow.setTextureOffset(114, 32).addBox(1.5F, -31.75F, -0.625F, 6.0F, 3.0F, 1.0F, 0.0F, false);
		door_3_left_window_glass_glow.setTextureOffset(114, 36).addBox(1.5F, -28.75F, -0.625F, 6.0F, 4.0F, 1.0F, 0.0F, false);

		Door_frame_accent = new ModelRenderer(this);
		Door_frame_accent.setRotationPoint(0.0F, 0.0F, 0.0F);
		Interior_doors.addChild(Door_frame_accent);
		Door_frame_accent.setTextureOffset(8, 153).addBox(-12.0F, -39.0F, 0.0F, 24.0F, 1.0F, 2.0F, 0.0F, false);
		Door_frame_accent.setTextureOffset(0, 151).addBox(-13.0F, -39.0F, 0.0F, 1.0F, 39.0F, 2.0F, 0.0F, false);
		Door_frame_accent.setTextureOffset(0, 151).addBox(12.0F, -39.0F, 0.0F, 1.0F, 39.0F, 2.0F, 0.0F, false);

		Door_frame_accent_glow = new LightModelRenderer(this);
		Door_frame_accent_glow.setRotationPoint(0.0F, 0.0F, 0.0F);
		Door_frame_accent.addChild(Door_frame_accent_glow);
		Door_frame_accent_glow.setTextureOffset(9, 157).addBox(11.0F, -38.0F, 0.0F, 1.0F, 38.0F, 2.0F, 0.0F, false);
		Door_frame_accent_glow.setTextureOffset(23, 160).addBox(-11.0F, -38.0F, 0.0F, 22.0F, 1.0F, 2.0F, 0.0F, false);
		Door_frame_accent_glow.setTextureOffset(9, 157).addBox(-12.0F, -38.0F, 0.0F, 1.0F, 38.0F, 2.0F, 0.0F, false);

		SOTO = new ModelRenderer(this);
		SOTO.setRotationPoint(0.0F, 0.0F, 0.0F);
		Interior_doors.addChild(SOTO);
		SOTO.setTextureOffset(70, 70).addBox(-9.0F, -33.0F, -2.0F, 18.0F, 33.0F, 2.0F, 0.0F, false);
	}

		@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Interior_doors.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void renderBones(DoorEntity door, MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay) {
		matrixStack.push();
		matrixStack.translate(0, 1.5, -0.5f);
		matrixStack.scale(1.1f, 1.1f, 1.1f);
		EnumDoorState state = door.getOpenState();

		switch(state) {
			case ONE:
				this.Door_3_right.rotateAngleY = (float) Math.toRadians(
						IDoorType.EnumDoorType.MODERN_POLICE_BOX.getRotationForState(EnumDoorState.ONE)); //Only open right door, left door is closed by default

				this.Door_left.rotateAngleY = (float) Math.toRadians(
						IDoorType.EnumDoorType.MODERN_POLICE_BOX.getRotationForState(EnumDoorState.CLOSED));

				break;


			case BOTH:
				this.Door_3_right.rotateAngleY = (float) Math.toRadians(
						IDoorType.EnumDoorType.MODERN_POLICE_BOX.getRotationForState(EnumDoorState.ONE));

				this.Door_left.rotateAngleY = (float) Math.toRadians(
						IDoorType.EnumDoorType.MODERN_POLICE_BOX.getRotationForState(EnumDoorState.BOTH)); //Open left door,Right door is already open

				break;


			case CLOSED://close both doors
				this.Door_3_right.rotateAngleY = (float) Math.toRadians(
						IDoorType.EnumDoorType.MODERN_POLICE_BOX.getRotationForState(EnumDoorState.CLOSED));
				this.Door_left.rotateAngleY = (float) Math.toRadians(
						IDoorType.EnumDoorType.MODERN_POLICE_BOX.getRotationForState(EnumDoorState.CLOSED));
				break;
			default:
				break;
		}
		door3.render(matrixStack, buffer, packedLight, packedOverlay);
		Door_frame.render(matrixStack, buffer, packedLight, packedOverlay);
		Door_frame_accent.render(matrixStack, buffer, packedLight, packedOverlay);
		Door_frame_accent_glow.setBright(1F);
		door_3_right_window_glass_glow.setBright(1F);
		door_3_left_window_glass_glow.setBright(1F);
		matrixStack.pop();
	}

	@Override
	public void renderBoti(DoorEntity door, MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay) {
		if(Minecraft.getInstance().world != null && door.getOpenState() != EnumDoorState.CLOSED){
			Minecraft.getInstance().world.getCapability(Capabilities.TARDIS_DATA).ifPresent(data -> {
				matrixStack.push();
				PortalInfo info = new PortalInfo();
				info.setPosition(door.getPositionVec());
				info.setWorldShell(data.getBotiWorld());

				info.setTranslate(matrix -> {
					matrix.scale(1f, 1f, 1.3f);
					matrix.translate(0, -1.4f, -0.4f);
					DoorRenderer.applyTranslations(matrix, door.rotationYaw - 180, door.getHorizontalFacing());
				});
				info.setTranslatePortal(matrix -> {
                    matrix.rotate(Vector3f.YP.rotationDegrees(WorldHelper.getAngleFromFacing(data.getBotiWorld().getPortalDirection())));
                    matrix.rotate(Vector3f.ZN.rotationDegrees(180));
					matrix.translate(-0.5f, -0.5f, 0.0);
				});

				info.setRenderPortal((matrix, impl) -> {
					matrix.push();
					matrix.translate(0,0,0);
					matrix.scale(1.1F, 1.1F, 1.1F);
					this.SOTO.render(matrix, impl.getBuffer(RenderType.getEntityCutout(this.getTexture())), packedLight, packedOverlay);
					matrix.pop();
				});

				BOTIRenderer.addPortal(info);
				matrixStack.pop();
			});
		}
	}

	@Override
	public ResourceLocation getTexture() {
		ConsoleTile tile = TardisHelper.getConsoleInWorld(Minecraft.getInstance().world).orElse(null);
		if (tile != null) {
			int index = tile.getExteriorManager().getExteriorVariant();
			if (tile.getExteriorType().getVariants() != null && index < tile.getExteriorType().getVariants().length)
				return tile.getExteriorType().getVariants()[index].getInteriorDoorTexture();
		}
		return TEXTURE;
	}
}