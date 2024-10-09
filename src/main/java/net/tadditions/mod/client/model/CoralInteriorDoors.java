package net.tadditions.mod.client.model;// Made with Blockbench 4.10.3
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.ModelRenderer;
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

public class CoralInteriorDoors extends AbstractInteriorDoorModel {
	public ResourceLocation TEXTURE = new ResourceLocation(QolMod.MOD_ID, "textures/exteriors/coral_interior_doors.png");

	private final ModelRenderer root;
	private final ModelRenderer frame;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer label;
	private final ModelRenderer cube_r5;
	private final LightModelRenderer label_lights;
	private final ModelRenderer cube_r6;
	private final ModelRenderer doors;
	private final ModelRenderer door_r;
	private final LightModelRenderer windows1;
	private final ModelRenderer door_l;
	private final LightModelRenderer windows2;
	private final ModelRenderer SOTO;

	public CoralInteriorDoors() {
		textureWidth = 256;
		textureHeight = 256;

		root = new ModelRenderer(this);
		root.setRotationPoint(0.0F, 28.0F, 0.0F);


		frame = new ModelRenderer(this);
		frame.setRotationPoint(4.5F, -2.0F, -10.5F);
		root.addChild(frame);
		frame.setTextureOffset(223, 124).addBox(10.5F, -60.0F, -8.5F, 3.0F, 58.0F, 6.0F, 0.0F, false);
		frame.setTextureOffset(199, 124).addBox(-22.5F, -60.0F, -8.5F, 3.0F, 58.0F, 6.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(-4.5F, -63.0F, -3.5F);
		frame.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 3.1416F, 0.0F);
		cube_r1.setTextureOffset(62, 0).addBox(-17.0F, -2.0F, 0.0F, 34.0F, 4.0F, 0.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-4.5F, -63.0F, -2.5F);
		frame.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 3.1416F, 0.0F);
		cube_r2.setTextureOffset(164, 75).addBox(-18.0F, -3.0F, -1.0F, 36.0F, 1.0F, 7.0F, 0.0F, false);
		cube_r2.setTextureOffset(153, 47).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 7.0F, 0.0F, false);
		cube_r2.setTextureOffset(164, 86).addBox(-18.0F, 2.0F, -1.0F, 36.0F, 1.0F, 7.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(-39.5F, -67.0F, -2.5F);
		frame.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 3.1416F, 0.0F);
		cube_r3.setTextureOffset(152, 21).addBox(-20.0F, 2.0F, -1.0F, 3.0F, 4.0F, 7.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(-6.5F, -67.0F, -2.5F);
		frame.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 3.1416F, 0.0F);
		cube_r4.setTextureOffset(152, 34).addBox(-20.0F, 2.0F, -1.0F, 3.0F, 4.0F, 7.0F, 0.0F, false);

		label = new ModelRenderer(this);
		label.setRotationPoint(-4.5F, -64.0F, -2.5F);
		frame.addChild(label);


		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(0.5F, 1.0F, 0.0F);
		label.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, 3.1416F, 0.0F);
		cube_r5.setTextureOffset(62, 48).addBox(-13.0F, -2.0F, 0.0F, 27.0F, 4.0F, 0.0F, 0.0F, false);

		label_lights = new LightModelRenderer(this);
		label_lights.setRotationPoint(0.0F, 0.0F, 0.0F);
		label.addChild(label_lights);


		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(-0.5F, 1.0F, 0.0F);
		label_lights.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, 3.1416F, 0.0F);
		cube_r6.setTextureOffset(62, 44).addBox(-14.0F, -2.0F, 0.0F, 27.0F, 4.0F, 0.0F, 0.0F, false);

		doors = new ModelRenderer(this);
		doors.setRotationPoint(-1.0F, -6.0F, 3.0F);
		root.addChild(doors);


		door_r = new ModelRenderer(this);
		door_r.setRotationPoint(16.0F, 2.0F, -20.0F);
		doors.addChild(door_r);
		door_r.setTextureOffset(87, 60).addBox(-12.0F, -58.0F, -2.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);
		door_r.setTextureOffset(56, 68).addBox(-2.0F, -58.0F, -2.0F, 2.0F, 58.0F, 2.0F, 0.0F, false);
		door_r.setTextureOffset(94, 64).addBox(-12.0F, -44.0F, -2.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);
		door_r.setTextureOffset(112, 78).addBox(-12.5F, -50.5F, -1.9F, 11.0F, 1.0F, 1.0F, -0.25F, false);
		door_r.setTextureOffset(112, 80).addBox(-5.75F, -57.0F, -1.9F, 1.0F, 14.0F, 1.0F, -0.25F, false);
		door_r.setTextureOffset(104, 112).addBox(-9.25F, -57.0F, -1.9F, 1.0F, 14.0F, 1.0F, -0.25F, false);
		door_r.setTextureOffset(72, 112).addBox(-12.5F, -50.5F, -1.1F, 11.0F, 1.0F, 1.0F, -0.25F, false);
		door_r.setTextureOffset(96, 108).addBox(-9.25F, -57.0F, -1.1F, 1.0F, 14.0F, 1.0F, -0.25F, false);
		door_r.setTextureOffset(100, 108).addBox(-5.75F, -57.0F, -1.1F, 1.0F, 14.0F, 1.0F, -0.25F, false);
		door_r.setTextureOffset(102, 39).addBox(-12.0F, -30.0F, -2.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);
		door_r.setTextureOffset(72, 108).addBox(-12.0F, -16.0F, -2.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);
		door_r.setTextureOffset(92, 68).addBox(-12.0F, -42.0F, -1.4F, 10.0F, 40.0F, 0.0F, 0.0F, false);
		door_r.setTextureOffset(72, 68).addBox(-12.0F, -42.0F, -0.6F, 10.0F, 40.0F, 0.0F, 0.0F, false);
		door_r.setTextureOffset(111, 60).addBox(-12.0F, -2.0F, -2.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);
		door_r.setTextureOffset(48, 68).addBox(-14.0F, -58.0F, -2.0F, 2.0F, 58.0F, 2.0F, 0.0F, false);
		door_r.setTextureOffset(0, 63).addBox(-13.5F, -38.0F, -3.1F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		door_r.setTextureOffset(54, 68).addBox(-13.5F, -39.0F, -2.1F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		door_r.setTextureOffset(46, 68).addBox(-13.5F, -35.0F, -2.1F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		door_r.setTextureOffset(0, 60).addBox(-14.1F, -30.0F, -0.7F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		door_r.setTextureOffset(35, 68).addBox(-13.85F, -29.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		windows1 = new LightModelRenderer(this);
		windows1.setRotationPoint(-15.0F, -46.5F, 20.6F);
		door_r.addChild(windows1);
		windows1.setTextureOffset(102, 4).addBox(3.0F, -10.0F, -22.0F, 10.0F, 13.0F, 0.0F, 0.0F, false);
		windows1.setTextureOffset(102, 4).addBox(3.0F, -10.0F, -21.2F, 10.0F, 13.0F, 0.0F, 0.0F, false);

		door_l = new ModelRenderer(this);
		door_l.setRotationPoint(-14.0F, 2.0F, -20.0F);
		doors.addChild(door_l);
		door_l.setTextureOffset(56, 68).addBox(12.0F, -58.0F, -2.0F, 2.0F, 58.0F, 2.0F, 0.0F, false);
		door_l.setTextureOffset(87, 60).addBox(2.0F, -58.0F, -2.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);
		door_l.setTextureOffset(104, 112).addBox(4.75F, -57.0F, -1.9F, 1.0F, 14.0F, 1.0F, -0.25F, false);
		door_l.setTextureOffset(40, 68).addBox(0.0F, -58.0F, -2.0F, 2.0F, 58.0F, 2.0F, 0.0F, false);
		door_l.setTextureOffset(112, 80).addBox(8.25F, -57.0F, -1.9F, 1.0F, 14.0F, 1.0F, -0.25F, false);
		door_l.setTextureOffset(112, 78).addBox(1.5F, -50.5F, -1.9F, 11.0F, 1.0F, 1.0F, -0.25F, false);
		door_l.setTextureOffset(96, 108).addBox(4.75F, -57.0F, -1.1F, 1.0F, 14.0F, 1.0F, -0.25F, false);
		door_l.setTextureOffset(100, 108).addBox(8.25F, -57.0F, -1.1F, 1.0F, 14.0F, 1.0F, -0.25F, false);
		door_l.setTextureOffset(72, 112).addBox(1.5F, -50.5F, -1.1F, 11.0F, 1.0F, 1.0F, -0.25F, false);
		door_l.setTextureOffset(94, 64).addBox(2.0F, -44.0F, -2.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);
		door_l.setTextureOffset(102, 39).addBox(2.0F, -30.0F, -2.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);
		door_l.setTextureOffset(111, 60).addBox(2.0F, -2.0F, -2.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);
		door_l.setTextureOffset(82, 4).addBox(2.0F, -42.0F, -1.4F, 10.0F, 40.0F, 0.0F, 0.0F, false);
		door_l.setTextureOffset(62, 4).addBox(2.0F, -42.0F, -0.6F, 10.0F, 40.0F, 0.0F, 0.0F, false);
		door_l.setTextureOffset(0, 68).addBox(11.0F, -37.0F, -2.4F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		door_l.setTextureOffset(72, 108).addBox(2.0F, -16.0F, -2.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);
		door_l.setTextureOffset(64, 68).addBox(14.0F, -58.0F, -2.6F, 2.0F, 58.0F, 2.0F, 0.0F, false);
		door_l.setTextureOffset(15, 68).addBox(12.9F, -30.0F, -0.7F, 3.0F, 2.0F, 1.0F, 0.0F, false);
		door_l.setTextureOffset(112, 68).addBox(4.0F, -40.0F, -0.6F, 6.0F, 8.0F, 2.0F, 0.0F, false);
		door_l.setTextureOffset(4, 63).addBox(10.0F, -39.0F, 0.4F, 1.0F, 4.0F, 0.0F, 0.0F, false);
		door_l.setTextureOffset(0, 59).addBox(4.5F, -41.0F, 0.4F, 5.0F, 1.0F, 0.0F, 0.0F, false);

		windows2 = new LightModelRenderer(this);
		windows2.setRotationPoint(-1.0F, -46.5F, 20.6F);
		door_l.addChild(windows2);
		windows2.setTextureOffset(102, 4).addBox(3.0F, -10.0F, -22.0F, 10.0F, 13.0F, 0.0F, 0.0F, false);
		windows2.setTextureOffset(102, 4).addBox(3.0F, -10.0F, -21.2F, 10.0F, 13.0F, 0.0F, 0.0F, false);

		SOTO = new ModelRenderer(this);
		SOTO.setRotationPoint(0.0F, 0.0F, -3.0F);
		root.addChild(SOTO);
		SOTO.setTextureOffset(0, 0).addBox(-15.0F, -62.0F, -17.6F, 30.0F, 58.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void renderBones(DoorEntity door, MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay) {
		matrixStack.push();
		matrixStack.translate(0f, 0.6f, 0.11f);
		matrixStack.scale(0.6f, 0.6f, 0.6f);
		EnumDoorState state = door.getOpenState();

		switch(state) {
			case ONE:
				this.door_r.rotateAngleY = (float) Math.toRadians(
						IDoorType.EnumDoorType.MODERN_POLICE_BOX.getRotationForState(EnumDoorState.ONE)); //Only open right door, left door is closed by default

				this.door_l.rotateAngleY = (float) Math.toRadians(
						IDoorType.EnumDoorType.MODERN_POLICE_BOX.getRotationForState(EnumDoorState.CLOSED));

				break;


			case BOTH:
				this.door_r.rotateAngleY = (float) Math.toRadians(
						IDoorType.EnumDoorType.MODERN_POLICE_BOX.getRotationForState(EnumDoorState.ONE));

				this.door_l.rotateAngleY = (float) Math.toRadians(
						IDoorType.EnumDoorType.MODERN_POLICE_BOX.getRotationForState(EnumDoorState.BOTH)); //Open left door,Right door is already open

				break;


			case CLOSED://close both doors
				this.door_r.rotateAngleY = (float) Math.toRadians(
						IDoorType.EnumDoorType.MODERN_POLICE_BOX.getRotationForState(EnumDoorState.CLOSED));
				this.door_l.rotateAngleY = (float) Math.toRadians(
						IDoorType.EnumDoorType.MODERN_POLICE_BOX.getRotationForState(EnumDoorState.CLOSED));
				break;
			default:
				break;
		}
		root.render(matrixStack, buffer, packedLight, packedOverlay);
		windows1.setBright(1F);
		windows2.setBright(1F);
		label_lights.setBright(1F);
		matrixStack.pop();
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		root.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
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
						matrix.translate(0, 1.63, 0.775);
					}
					else {
						matrix.translate(0.025, 1.63, 0.84);
					}
					matrix.scale(0.55F, 0.55F, 1.1F);
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