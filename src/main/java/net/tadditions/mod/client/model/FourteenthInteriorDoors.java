package net.tadditions.mod.client.model;// Made with Blockbench 4.9.3
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
import net.tardis.mod.entity.DoorEntity;
import net.tardis.mod.enums.EnumDoorState;
import net.tardis.mod.helper.TardisHelper;
import net.tardis.mod.helper.WorldHelper;
import net.tardis.mod.misc.IDoorType;
import net.tardis.mod.tileentities.ConsoleTile;

public class FourteenthInteriorDoors extends AbstractInteriorDoorModel {
	public ResourceLocation TEXTURE = new ResourceLocation(QolMod.MOD_ID, "textures/exteriors/fourteenthinteriordoors.png");

	private final ModelRenderer Root;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer Doors;
	private final ModelRenderer Door_R;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer Handle;
	private final ModelRenderer cube_r5;
	private final LightModelRenderer windows;
	private final ModelRenderer cube_r6;
	private final LightModelRenderer windows3;
	private final ModelRenderer cube_r7;
	private final ModelRenderer Door_L;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;
	private final ModelRenderer Label;
	private final ModelRenderer cube_r10;
	private final LightModelRenderer windows2;
	private final ModelRenderer cube_r11;
	private final LightModelRenderer windows4;
	private final ModelRenderer cube_r12;
	private final ModelRenderer phone;
	private final ModelRenderer cube_r13;
	private final ModelRenderer cube_r14;
	private final ModelRenderer cube_r15;
	private final ModelRenderer cube_r16;
	private final ModelRenderer cube_r17;
	private final ModelRenderer Soto;

	public FourteenthInteriorDoors() {
		textureWidth = 512;
		textureHeight = 512;

		Root = new ModelRenderer(this);
		Root.setRotationPoint(0.0F, 6.0F, 0.0F);
		Root.setTextureOffset(47, 78).addBox(16.0F, -52.0F, -2.0F, 4.0F, 70.0F, 4.0F, 0.0F, false);
		Root.setTextureOffset(47, 78).addBox(-20.0F, -52.0F, -2.0F, 4.0F, 70.0F, 4.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, -60.5F, 16.0F);
		Root.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 1.5708F, 0.0F);
		cube_r1.setTextureOffset(112, 56).addBox(12.35F, 10.5F, -14.0F, 0.0F, 4.0F, 28.0F, 0.0F, false);
		cube_r1.setTextureOffset(118, 95).addBox(14.5F, 15.5F, -16.0F, 1.0F, 1.0F, 32.0F, 0.0F, false);
		cube_r1.setTextureOffset(108, 0).addBox(15.0F, 16.5F, -16.0F, 3.0F, 1.0F, 32.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0.0F, -60.5F, 18.0F);
		Root.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 1.5708F, 0.0F);
		cube_r2.setTextureOffset(102, 37).addBox(14.4F, 9.5F, -18.0F, 3.0F, 6.0F, 36.0F, 0.0F, false);

		Doors = new ModelRenderer(this);
		Doors.setRotationPoint(0.0F, 0.0F, 16.0F);
		Root.addChild(Doors);
		

		Door_R = new ModelRenderer(this);
		Door_R.setRotationPoint(16.0F, 18.0F, -16.0F);
		Doors.addChild(Door_R);
		Door_R.setTextureOffset(16, 4).addBox(-15.0F, -39.0F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Door_R.setTextureOffset(17, 0).addBox(-15.0F, -39.0F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(-16.0F, -74.5F, 16.0F);
		Door_R.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 1.5708F, 0.0F);
		cube_r3.setTextureOffset(80, 95).addBox(16.0F, 13.5F, 3.0F, 2.0F, 3.0F, 11.0F, 0.0F, false);
		cube_r3.setTextureOffset(80, 112).addBox(16.0F, 28.5F, 3.0F, 2.0F, 2.0F, 11.0F, 0.0F, false);
		cube_r3.setTextureOffset(55, -5).addBox(17.4F, 16.5F, 3.0F, 0.0F, 54.0F, 11.0F, 0.0F, false);
		cube_r3.setTextureOffset(80, 128).addBox(16.0F, 42.5F, 3.0F, 2.0F, 2.0F, 11.0F, 0.0F, false);
		cube_r3.setTextureOffset(80, 144).addBox(16.0F, 56.5F, 3.0F, 2.0F, 2.0F, 11.0F, 0.0F, false);
		cube_r3.setTextureOffset(69, 93).addBox(16.0F, 13.5F, 14.0F, 2.0F, 61.0F, 2.0F, 0.0F, false);
		cube_r3.setTextureOffset(13, 78).addBox(16.0F, 13.5F, 1.0F, 2.0F, 61.0F, 2.0F, 0.0F, false);
		cube_r3.setTextureOffset(0, 1).addBox(16.0F, 70.5F, 3.0F, 2.0F, 4.0F, 11.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(-7.5F, -31.0F, -0.4F);
		Door_R.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 1.5708F, 0.0F);
		cube_r4.setTextureOffset(81, -5).addBox(0.0F, -27.0F, -5.5F, 0.0F, 54.0F, 11.0F, 0.0F, false);

		Handle = new ModelRenderer(this);
		Handle.setRotationPoint(-16.0F, -16.5F, 16.0F);
		Door_R.addChild(Handle);
		

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(0.0F, 0.0F, 0.0F);
		Handle.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, 1.5708F, 0.0F);
		cube_r5.setTextureOffset(40, 8).addBox(17.1F, -17.5F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r5.setTextureOffset(6, 9).addBox(18.1F, -16.5F, 1.5F, 1.0F, 0.0F, 1.0F, 0.0F, false);
		cube_r5.setTextureOffset(12, 19).addBox(19.1F, -16.5F, 1.5F, 0.0F, 4.0F, 1.0F, 0.0F, false);
		cube_r5.setTextureOffset(6, 9).addBox(18.1F, -12.5F, 1.5F, 1.0F, 0.0F, 1.0F, 0.0F, false);
		cube_r5.setTextureOffset(34, 8).addBox(17.1F, -12.5F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		windows = new LightModelRenderer(this);
		windows.setRotationPoint(-16.0F, -46.5F, 16.0F);
		Door_R.addChild(windows);
		

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(0.0F, 0.0F, 0.0F);
		windows.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, 1.5708F, 0.0F);
		cube_r6.setTextureOffset(19, 18).addBox(17.45F, -10.2F, 10.9F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		cube_r6.setTextureOffset(19, 18).addBox(17.45F, -10.2F, 7.5F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		cube_r6.setTextureOffset(19, 18).addBox(17.45F, -10.2F, 4.1F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		cube_r6.setTextureOffset(19, 18).addBox(17.45F, -4.8F, 4.1F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		cube_r6.setTextureOffset(19, 18).addBox(17.45F, -4.8F, 7.5F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		cube_r6.setTextureOffset(19, 18).addBox(17.45F, -4.8F, 10.9F, 0.0F, 4.0F, 2.0F, 0.0F, false);

		windows3 = new LightModelRenderer(this);
		windows3.setRotationPoint(-7.5F, -52.0F, -0.35F);
		Door_R.addChild(windows3);
		

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(0.0F, 0.0F, 0.0F);
		windows3.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0F, 1.5708F, 0.0F);
		cube_r7.setTextureOffset(19, 18).addBox(0.0F, -4.7F, 2.4F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		cube_r7.setTextureOffset(19, 18).addBox(0.0F, -4.7F, -1.0F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		cube_r7.setTextureOffset(19, 18).addBox(0.0F, -4.7F, -4.4F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		cube_r7.setTextureOffset(19, 18).addBox(0.0F, 0.7F, -4.4F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		cube_r7.setTextureOffset(19, 18).addBox(0.0F, 0.7F, -1.0F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		cube_r7.setTextureOffset(19, 18).addBox(0.0F, 0.7F, 2.4F, 0.0F, 4.0F, 2.0F, 0.0F, false);

		Door_L = new ModelRenderer(this);
		Door_L.setRotationPoint(-16.0F, 18.0F, -16.0F);
		Doors.addChild(Door_L);
		Door_L.setTextureOffset(22, 1).addBox(13.0F, -39.0F, -0.5F, 4.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(16.0F, -74.5F, 16.0F);
		Door_L.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.0F, 1.5708F, 0.0F);
		cube_r8.setTextureOffset(80, 95).addBox(16.0F, 13.5F, -14.0F, 2.0F, 3.0F, 11.0F, 0.0F, false);
		cube_r8.setTextureOffset(80, 112).addBox(16.0F, 28.5F, -14.0F, 2.0F, 2.0F, 11.0F, 0.0F, false);
		cube_r8.setTextureOffset(3, 9).addBox(17.5F, 35.5F, -14.0F, 1.0F, 0.0F, 1.0F, 0.0F, false);
		cube_r8.setTextureOffset(0, 9).addBox(17.5F, 37.5F, -14.0F, 1.0F, 0.0F, 1.0F, 0.0F, false);
		cube_r8.setTextureOffset(15, 20).addBox(18.5F, 35.5F, -14.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r8.setTextureOffset(22, 8).addBox(16.5F, 37.5F, -14.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r8.setTextureOffset(28, 8).addBox(16.5F, 34.5F, -14.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r8.setTextureOffset(55, -5).addBox(17.4F, 16.5F, -14.0F, 0.0F, 54.0F, 11.0F, 0.0F, false);
		cube_r8.setTextureOffset(80, 128).addBox(16.0F, 42.5F, -14.0F, 2.0F, 2.0F, 11.0F, 0.0F, false);
		cube_r8.setTextureOffset(80, 144).addBox(16.0F, 56.5F, -14.0F, 2.0F, 2.0F, 11.0F, 0.0F, false);
		cube_r8.setTextureOffset(36, 78).addBox(16.0F, 13.5F, -16.0F, 2.0F, 61.0F, 2.0F, 0.0F, false);
		cube_r8.setTextureOffset(25, 78).addBox(16.6F, 13.5F, -1.0F, 2.0F, 61.0F, 2.0F, 0.0F, false);
		cube_r8.setTextureOffset(0, 1).addBox(16.0F, 70.5F, -14.0F, 2.0F, 4.0F, 11.0F, 0.0F, false);
		cube_r8.setTextureOffset(0, 78).addBox(16.0F, 13.5F, -3.0F, 2.0F, 61.0F, 2.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(7.5F, -31.0F, -0.4F);
		Door_L.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.0F, 1.5708F, 0.0F);
		cube_r9.setTextureOffset(81, -5).addBox(0.0F, -27.0F, -5.5F, 0.0F, 54.0F, 11.0F, 0.0F, false);

		Label = new ModelRenderer(this);
		Label.setRotationPoint(16.0F, -46.5F, 16.0F);
		Door_L.addChild(Label);
		

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(0.0F, 0.0F, 0.0F);
		Label.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.0F, 1.5708F, 0.0F);
		cube_r10.setTextureOffset(28, 23).addBox(17.5F, 4.5F, -12.5F, 0.0F, 8.0F, 8.0F, 0.0F, false);
		cube_r10.setTextureOffset(26, 8).addBox(17.45F, 3.5F, -13.0F, 0.0F, 10.0F, 9.0F, 0.0F, false);

		windows2 = new LightModelRenderer(this);
		windows2.setRotationPoint(16.0F, -46.5F, 16.0F);
		Door_L.addChild(windows2);
		

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(0.0F, 0.0F, 0.0F);
		windows2.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.0F, 1.5708F, 0.0F);
		cube_r11.setTextureOffset(19, 18).addBox(17.45F, -4.8F, -6.1F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		cube_r11.setTextureOffset(19, 18).addBox(17.45F, -4.8F, -12.9F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		cube_r11.setTextureOffset(19, 18).addBox(17.45F, -10.2F, -12.9F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		cube_r11.setTextureOffset(19, 18).addBox(17.45F, -10.2F, -9.5F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		cube_r11.setTextureOffset(19, 18).addBox(17.45F, -10.2F, -6.1F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		cube_r11.setTextureOffset(19, 18).addBox(17.45F, -4.8F, -9.5F, 0.0F, 4.0F, 2.0F, 0.0F, false);

		windows4 = new LightModelRenderer(this);
		windows4.setRotationPoint(7.5F, -52.0F, -0.35F);
		Door_L.addChild(windows4);
		

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(0.0F, 0.0F, 0.0F);
		windows4.addChild(cube_r12);
		setRotationAngle(cube_r12, 0.0F, 1.5708F, 0.0F);
		cube_r12.setTextureOffset(19, 18).addBox(0.0F, 0.7F, 2.4F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		cube_r12.setTextureOffset(19, 18).addBox(0.0F, 0.7F, -4.4F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		cube_r12.setTextureOffset(19, 18).addBox(0.0F, -4.7F, -4.4F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		cube_r12.setTextureOffset(19, 18).addBox(0.0F, -4.7F, -1.0F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		cube_r12.setTextureOffset(19, 18).addBox(0.0F, -4.7F, 2.4F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		cube_r12.setTextureOffset(19, 18).addBox(0.0F, 0.7F, -1.0F, 0.0F, 4.0F, 2.0F, 0.0F, false);

		phone = new ModelRenderer(this);
		phone.setRotationPoint(16.0F, -46.5F, 16.0F);
		Door_L.addChild(phone);
		phone.setTextureOffset(1, 48).addBox(-10.5F, 5.5F, -16.4F, 4.0F, 6.0F, 1.0F, 0.0F, false);
		phone.setTextureOffset(2, 73).addBox(-13.5F, 6.5F, -16.4F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		phone.setTextureOffset(0, 43).addBox(-10.5F, 3.5F, -16.4F, 4.0F, 2.0F, 2.0F, 0.0F, false);
		phone.setTextureOffset(18, 54).addBox(-13.7F, 3.5F, -16.4F, 3.0F, 3.0F, 2.0F, 0.0F, false);
		phone.setTextureOffset(18, 54).addBox(-13.7F, 10.5F, -16.4F, 3.0F, 3.0F, 2.0F, 0.0F, false);
		phone.setTextureOffset(20, 61).addBox(-13.2F, 4.5F, -14.4F, 2.0F, 8.0F, 1.0F, 0.0F, false);
		phone.setTextureOffset(0, 43).addBox(-10.5F, 11.5F, -16.4F, 4.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r13 = new ModelRenderer(this);
		cube_r13.setRotationPoint(-8.5F, 7.0F, -14.8F);
		phone.addChild(cube_r13);
		setRotationAngle(cube_r13, 0.0F, 0.0F, -1.5708F);
		cube_r13.setTextureOffset(13, 52).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r14 = new ModelRenderer(this);
		cube_r14.setRotationPoint(-8.5F, 10.0F, -14.8F);
		phone.addChild(cube_r14);
		setRotationAngle(cube_r14, 0.0F, 0.0F, -1.5708F);
		cube_r14.setTextureOffset(13, 52).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r15 = new ModelRenderer(this);
		cube_r15.setRotationPoint(-8.5F, 10.0F, -14.9F);
		phone.addChild(cube_r15);
		setRotationAngle(cube_r15, 0.0F, 0.0F, -0.7854F);
		cube_r15.setTextureOffset(17, 48).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r16 = new ModelRenderer(this);
		cube_r16.setRotationPoint(-8.5F, 7.0F, -14.9F);
		phone.addChild(cube_r16);
		setRotationAngle(cube_r16, 0.0F, 0.0F, -2.3562F);
		cube_r16.setTextureOffset(17, 48).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r17 = new ModelRenderer(this);
		cube_r17.setRotationPoint(-10.0F, 20.5F, -15.4F);
		phone.addChild(cube_r17);
		setRotationAngle(cube_r17, 0.0F, 3.1416F, 0.0F);
		cube_r17.setTextureOffset(1, 57).addBox(-3.25F, -7.0F, 0.0F, 7.0F, 14.0F, 0.0F, 0.0F, false);

		Soto = new ModelRenderer(this);
		Soto.setRotationPoint(0.0F, 18.0F, -1.0F);
		Root.addChild(Soto);
		Soto.setTextureOffset(187, 3).addBox(-16.0F, -61.0F, -1.0F, 32.0F, 61.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Root.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void renderBones(DoorEntity door, MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay) {
		matrixStack.push();
		matrixStack.translate(0, 0.675, -0.5f);
		matrixStack.scale(0.55f, 0.55f, 0.55f);
		EnumDoorState state = door.getOpenState();

		switch(state) {
			case ONE:
				this.Door_R.rotateAngleY = (float) Math.toRadians(
						IDoorType.EnumDoorType.MODERN_POLICE_BOX.getRotationForState(EnumDoorState.ONE)); //Only open right door, left door is closed by default

				this.Door_L.rotateAngleY = (float) Math.toRadians(
						IDoorType.EnumDoorType.MODERN_POLICE_BOX.getRotationForState(EnumDoorState.CLOSED));

				break;


			case BOTH:
				this.Door_R.rotateAngleY = (float) Math.toRadians(
						IDoorType.EnumDoorType.MODERN_POLICE_BOX.getRotationForState(EnumDoorState.ONE));

				this.Door_L.rotateAngleY = (float) Math.toRadians(
						IDoorType.EnumDoorType.MODERN_POLICE_BOX.getRotationForState(EnumDoorState.BOTH)); //Open left door,Right door is already open

				break;


			case CLOSED://close both doors
				this.Door_R.rotateAngleY = (float) Math.toRadians(
						IDoorType.EnumDoorType.MODERN_POLICE_BOX.getRotationForState(EnumDoorState.CLOSED));
				this.Door_L.rotateAngleY = (float) Math.toRadians(
						IDoorType.EnumDoorType.MODERN_POLICE_BOX.getRotationForState(EnumDoorState.CLOSED));
				break;
			default:
				break;
		}
		Root.render(matrixStack, buffer, packedLight, packedOverlay);
		windows.setBright(1F);
		windows2.setBright(1F);
		windows3.setBright(1F);
		windows4.setBright(1F);
		matrixStack.pop();
	}

	@Override
	public void renderBoti(DoorEntity door, MatrixStack matrixStack, IVertexBuilder buffer, int packedLight,
						   int packedOverlay) {
		if(Minecraft.getInstance().world != null && door.getOpenState() != EnumDoorState.CLOSED){
			Minecraft.getInstance().world.getCapability(Capabilities.TARDIS_DATA).ifPresent(data -> {
				matrixStack.push();
				PortalInfo info = new PortalInfo();
				info.setPosition(door.getPositionVec());
				info.setWorldShell(data.getBotiWorld());

				info.setTranslate(matrix -> {

					matrix.scale(1.1f, 1.1f, 1.2f);
					matrix.translate(0.025, 0, 0);
					DoorRenderer.applyTranslations(matrix, door.rotationYaw - 180, door.getHorizontalFacing());
				});
				info.setTranslatePortal(matrix -> {
					matrix.rotate(Vector3f.ZN.rotationDegrees(180));
					matrix.rotate(Vector3f.YP.rotationDegrees(WorldHelper.getAngleFromFacing(data.getBotiWorld().getPortalDirection())));
					matrix.translate(-0.5, -1.75, -0.5);
				});

				info.setRenderPortal((matrix, impl) -> {
					matrix.push();
					if(door.rotationYaw==90.0){
						matrix.translate(0, 1, -0.45);
					}
					else {
						matrix.translate(0, 1, -0.39);
					}
					matrix.scale(0.55F, 0.55F, 1.1F);
					this.Soto.render(matrix, impl.getBuffer(RenderType.getEntityCutout(this.getTexture())), packedLight, packedOverlay);
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