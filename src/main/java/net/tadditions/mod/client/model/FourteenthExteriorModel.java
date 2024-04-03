package net.tadditions.mod.client.model;// Made with Blockbench 4.9.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
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

public class FourteenthExteriorModel extends ExteriorModel {
	private final ModelRenderer Root;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer Doors;
	private final ModelRenderer Door_R;
	private final ModelRenderer cube_r6;
	private final ModelRenderer Handle;
	private final ModelRenderer cube_r7;
	private final LightModelRenderer windows;
	private final ModelRenderer cube_r8;
	private final ModelRenderer Door_L;
	private final ModelRenderer cube_r9;
	private final ModelRenderer Label;
	private final ModelRenderer cube_r10;
	private final LightModelRenderer windows2;
	private final ModelRenderer cube_r11;
	private final LightModelRenderer windows3;
	private final ModelRenderer cube_r12;
	private final ModelRenderer cube_r13;
	private final LightModelRenderer Lamp;
	private final ModelRenderer BOTI;

	public FourteenthExteriorModel() {
		textureWidth = 512;
		textureHeight = 512;

		Root = new ModelRenderer(this);
		Root.setRotationPoint(0.0F, 2.0F, 0.0F);
		Root.setTextureOffset(48, 127).addBox(16.0F, -52.0F, 16.0F, 4.0F, 70.0F, 4.0F, 0.0F, false);
		Root.setTextureOffset(1, 5).addBox(-1.0F, -68.0F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		Root.setTextureOffset(1, 50).addBox(-2.0F, -67.0F, -2.0F, 4.0F, 2.0F, 4.0F, 0.0F, false);
		Root.setTextureOffset(35, -3).addBox(-2.2F, -66.0F, -2.0F, 0.0F, 2.0F, 4.0F, 0.0F, false);
		Root.setTextureOffset(35, 1).addBox(-2.0F, -66.0F, 2.2F, 4.0F, 2.0F, 0.0F, 0.0F, false);
		Root.setTextureOffset(35, 1).addBox(-2.0F, -66.0F, -2.2F, 4.0F, 2.0F, 0.0F, 0.0F, false);
		Root.setTextureOffset(35, -3).addBox(2.2F, -66.0F, -2.0F, 0.0F, 2.0F, 4.0F, 0.0F, false);
		Root.setTextureOffset(35, -3).addBox(2.2F, -60.0F, -2.0F, 0.0F, 2.0F, 4.0F, 0.0F, false);
		Root.setTextureOffset(35, 1).addBox(-2.0F, -60.0F, 2.2F, 4.0F, 2.0F, 0.0F, 0.0F, false);
		Root.setTextureOffset(35, -3).addBox(-2.2F, -60.0F, -2.0F, 0.0F, 2.0F, 4.0F, 0.0F, false);
		Root.setTextureOffset(35, 1).addBox(-2.0F, -60.0F, -2.2F, 4.0F, 2.0F, 0.0F, 0.0F, false);
		Root.setTextureOffset(2, 26).addBox(-2.0F, -59.0F, -2.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		Root.setTextureOffset(0, 63).addBox(-3.0F, -58.0F, -3.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);
		Root.setTextureOffset(104, 91).addBox(-15.0F, -57.0F, -15.0F, 30.0F, 2.0F, 30.0F, 0.0F, false);
		Root.setTextureOffset(0, 90).addBox(-17.0F, -55.0F, -17.0F, 34.0F, 2.0F, 34.0F, 0.0F, false);
		Root.setTextureOffset(0, 49).addBox(-19.0F, -53.0F, -19.0F, 38.0F, 2.0F, 38.0F, 0.0F, false);
		Root.setTextureOffset(48, 127).addBox(-20.0F, -52.0F, 16.0F, 4.0F, 70.0F, 4.0F, 0.0F, false);
		Root.setTextureOffset(48, 127).addBox(16.0F, -52.0F, -20.0F, 4.0F, 70.0F, 4.0F, 0.0F, false);
		Root.setTextureOffset(48, 127).addBox(-20.0F, -52.0F, -20.0F, 4.0F, 70.0F, 4.0F, 0.0F, false);
		Root.setTextureOffset(1, 0).addBox(-22.0F, 18.0F, -22.0F, 44.0F, 4.0F, 44.0F, 0.0F, false);
		Root.setTextureOffset(37, 127).addBox(16.0F, -43.0F, -16.0F, 2.0F, 61.0F, 2.0F, 0.0F, false);
		Root.setTextureOffset(67, 127).addBox(16.0F, -43.0F, 14.0F, 2.0F, 61.0F, 2.0F, 0.0F, false);
		Root.setTextureOffset(67, 127).addBox(-18.0F, -43.0F, -16.0F, 2.0F, 61.0F, 2.0F, 0.0F, false);
		Root.setTextureOffset(0, 1).addBox(-18.0F, 14.0F, -14.0F, 2.0F, 4.0F, 11.0F, 0.0F, false);
		Root.setTextureOffset(0, 1).addBox(16.0F, 14.0F, -14.0F, 2.0F, 4.0F, 11.0F, 0.0F, false);
		Root.setTextureOffset(0, 1).addBox(-18.0F, 14.0F, 3.0F, 2.0F, 4.0F, 11.0F, 0.0F, false);
		Root.setTextureOffset(0, 1).addBox(16.0F, 14.0F, 3.0F, 2.0F, 4.0F, 11.0F, 0.0F, false);
		Root.setTextureOffset(37, 127).addBox(-18.0F, -43.0F, 14.0F, 2.0F, 61.0F, 2.0F, 0.0F, false);
		Root.setTextureOffset(67, 127).addBox(-18.0F, -43.0F, 1.0F, 2.0F, 61.0F, 2.0F, 0.0F, false);
		Root.setTextureOffset(37, 127).addBox(16.0F, -43.0F, 1.0F, 2.0F, 61.0F, 2.0F, 0.0F, false);
		Root.setTextureOffset(67, 127).addBox(16.0F, -43.0F, -3.0F, 2.0F, 61.0F, 2.0F, 0.0F, false);
		Root.setTextureOffset(37, 127).addBox(-18.0F, -43.0F, -3.0F, 2.0F, 61.0F, 2.0F, 0.0F, false);
		Root.setTextureOffset(26, 127).addBox(-18.6F, -43.0F, -1.0F, 2.0F, 61.0F, 2.0F, 0.0F, false);
		Root.setTextureOffset(26, 127).addBox(16.6F, -43.0F, -1.0F, 2.0F, 61.0F, 2.0F, 0.0F, false);
		Root.setTextureOffset(78, 178).addBox(-18.0F, 0.0F, -14.0F, 2.0F, 2.0F, 11.0F, 0.0F, false);
		Root.setTextureOffset(78, 178).addBox(-18.0F, 0.0F, 3.0F, 2.0F, 2.0F, 11.0F, 0.0F, false);
		Root.setTextureOffset(78, 178).addBox(16.0F, 0.0F, 3.0F, 2.0F, 2.0F, 11.0F, 0.0F, false);
		Root.setTextureOffset(78, 178).addBox(16.0F, 0.0F, -14.0F, 2.0F, 2.0F, 11.0F, 0.0F, false);
		Root.setTextureOffset(78, 162).addBox(-18.0F, -14.0F, -14.0F, 2.0F, 2.0F, 11.0F, 0.0F, false);
		Root.setTextureOffset(78, 162).addBox(-18.0F, -14.0F, 3.0F, 2.0F, 2.0F, 11.0F, 0.0F, false);
		Root.setTextureOffset(78, 162).addBox(16.0F, -14.0F, 3.0F, 2.0F, 2.0F, 11.0F, 0.0F, false);
		Root.setTextureOffset(78, 162).addBox(16.0F, -14.0F, -14.0F, 2.0F, 2.0F, 11.0F, 0.0F, false);
		Root.setTextureOffset(180, -2).addBox(17.4F, -40.0F, -14.0F, 0.0F, 54.0F, 11.0F, 0.0F, false);
		Root.setTextureOffset(180, -2).addBox(17.4F, -40.0F, 3.0F, 0.0F, 54.0F, 11.0F, 0.0F, false);
		Root.setTextureOffset(78, 146).addBox(16.0F, -28.0F, -14.0F, 2.0F, 2.0F, 11.0F, 0.0F, false);
		Root.setTextureOffset(78, 146).addBox(16.0F, -28.0F, 3.0F, 2.0F, 2.0F, 11.0F, 0.0F, false);
		Root.setTextureOffset(78, 146).addBox(-18.0F, -28.0F, 3.0F, 2.0F, 2.0F, 11.0F, 0.0F, false);
		Root.setTextureOffset(78, 146).addBox(-18.0F, -28.0F, -14.0F, 2.0F, 2.0F, 11.0F, 0.0F, false);
		Root.setTextureOffset(78, 129).addBox(-18.0F, -43.0F, -14.0F, 2.0F, 3.0F, 11.0F, 0.0F, false);
		Root.setTextureOffset(78, 129).addBox(-18.0F, -43.0F, 3.0F, 2.0F, 3.0F, 11.0F, 0.0F, false);
		Root.setTextureOffset(78, 129).addBox(16.0F, -43.0F, 3.0F, 2.0F, 3.0F, 11.0F, 0.0F, false);
		Root.setTextureOffset(78, 129).addBox(16.0F, -43.0F, -14.0F, 2.0F, 3.0F, 11.0F, 0.0F, false);
		Root.setTextureOffset(116, 51).addBox(17.0F, -44.0F, -16.0F, 2.0F, 1.0F, 32.0F, 0.0F, false);
		Root.setTextureOffset(116, 51).addBox(-19.0F, -44.0F, -16.0F, 2.0F, 1.0F, 32.0F, 0.0F, false);
		Root.setTextureOffset(82, 175).addBox(18.5F, -45.0F, -16.0F, 1.0F, 1.0F, 32.0F, 0.0F, false);
		Root.setTextureOffset(82, 175).addBox(-19.5F, -45.0F, -16.0F, 1.0F, 1.0F, 32.0F, 0.0F, false);
		Root.setTextureOffset(109, 128).addBox(-21.6F, -51.0F, -18.0F, 3.0F, 6.0F, 36.0F, 0.0F, false);
		Root.setTextureOffset(128, 165).addBox(-21.65F, -50.0F, -14.0F, 0.0F, 4.0F, 28.0F, 0.0F, false);
		Root.setTextureOffset(109, 128).addBox(18.6F, -51.0F, -18.0F, 3.0F, 6.0F, 36.0F, 0.0F, false);
		Root.setTextureOffset(128, 165).addBox(21.65F, -50.0F, -14.0F, 0.0F, 4.0F, 28.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, -60.5F, 0.0F);
		Root.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 1.5708F, 0.0F);
		cube_r1.setTextureOffset(128, 165).addBox(-21.65F, 10.5F, -14.0F, 0.0F, 4.0F, 28.0F, 0.0F, false);
		cube_r1.setTextureOffset(109, 128).addBox(-21.6F, 9.5F, -18.0F, 3.0F, 6.0F, 36.0F, 0.0F, false);
		cube_r1.setTextureOffset(128, 165).addBox(21.65F, 10.5F, -14.0F, 0.0F, 4.0F, 28.0F, 0.0F, false);
		cube_r1.setTextureOffset(109, 128).addBox(18.6F, 9.5F, -18.0F, 3.0F, 6.0F, 36.0F, 0.0F, false);
		cube_r1.setTextureOffset(82, 175).addBox(-19.5F, 15.5F, -16.0F, 1.0F, 1.0F, 32.0F, 0.0F, false);
		cube_r1.setTextureOffset(82, 175).addBox(18.5F, 15.5F, -16.0F, 1.0F, 1.0F, 32.0F, 0.0F, false);
		cube_r1.setTextureOffset(116, 51).addBox(-19.0F, 16.5F, -16.0F, 2.0F, 1.0F, 32.0F, 0.0F, false);
		cube_r1.setTextureOffset(116, 51).addBox(16.0F, 16.5F, -16.0F, 3.0F, 1.0F, 32.0F, 0.0F, false);
		cube_r1.setTextureOffset(78, 129).addBox(-18.0F, 17.5F, 3.0F, 2.0F, 3.0F, 11.0F, 0.0F, false);
		cube_r1.setTextureOffset(78, 129).addBox(-18.0F, 17.5F, -14.0F, 2.0F, 3.0F, 11.0F, 0.0F, false);
		cube_r1.setTextureOffset(78, 146).addBox(-18.0F, 32.5F, -14.0F, 2.0F, 2.0F, 11.0F, 0.0F, false);
		cube_r1.setTextureOffset(78, 146).addBox(-18.0F, 32.5F, 3.0F, 2.0F, 2.0F, 11.0F, 0.0F, false);
		cube_r1.setTextureOffset(78, 162).addBox(-18.0F, 46.5F, 3.0F, 2.0F, 2.0F, 11.0F, 0.0F, false);
		cube_r1.setTextureOffset(78, 162).addBox(-18.0F, 46.5F, -14.0F, 2.0F, 2.0F, 11.0F, 0.0F, false);
		cube_r1.setTextureOffset(78, 178).addBox(-18.0F, 60.5F, 3.0F, 2.0F, 2.0F, 11.0F, 0.0F, false);
		cube_r1.setTextureOffset(78, 178).addBox(-18.0F, 60.5F, -14.0F, 2.0F, 2.0F, 11.0F, 0.0F, false);
		cube_r1.setTextureOffset(0, 1).addBox(-18.0F, 74.5F, 3.0F, 2.0F, 4.0F, 11.0F, 0.0F, false);
		cube_r1.setTextureOffset(0, 1).addBox(-18.0F, 74.5F, -14.0F, 2.0F, 4.0F, 11.0F, 0.0F, false);
		cube_r1.setTextureOffset(37, 127).addBox(-18.0F, 17.5F, 14.0F, 2.0F, 61.0F, 2.0F, 0.0F, false);
		cube_r1.setTextureOffset(67, 127).addBox(-18.0F, 17.5F, 1.0F, 2.0F, 61.0F, 2.0F, 0.0F, false);
		cube_r1.setTextureOffset(26, 127).addBox(-18.6F, 17.5F, -1.0F, 2.0F, 61.0F, 2.0F, 0.0F, false);
		cube_r1.setTextureOffset(37, 127).addBox(-18.0F, 17.5F, -3.0F, 2.0F, 61.0F, 2.0F, 0.0F, false);
		cube_r1.setTextureOffset(67, 127).addBox(-18.0F, 17.5F, -16.0F, 2.0F, 61.0F, 2.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-8.5F, -13.0F, 17.4F);
		Root.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, -1.5708F, 0.0F);
		cube_r2.setTextureOffset(180, -2).addBox(0.0F, -27.0F, -5.5F, 0.0F, 54.0F, 11.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(8.5F, -13.0F, 17.4F);
		Root.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, -1.5708F, 0.0F);
		cube_r3.setTextureOffset(180, -2).addBox(0.0F, -27.0F, -5.5F, 0.0F, 54.0F, 11.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(-17.4F, -13.0F, 8.5F);
		Root.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 3.1416F, 0.0F);
		cube_r4.setTextureOffset(180, -2).addBox(0.0F, -27.0F, -5.5F, 0.0F, 54.0F, 11.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(-17.4F, -13.0F, -8.5F);
		Root.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, 3.1416F, 0.0F);
		cube_r5.setTextureOffset(180, -2).addBox(0.0F, -27.0F, -5.5F, 0.0F, 54.0F, 11.0F, 0.0F, false);

		Doors = new ModelRenderer(this);
		Doors.setRotationPoint(0.0F, 0.0F, 0.0F);
		Root.addChild(Doors);
		

		Door_R = new ModelRenderer(this);
		Door_R.setRotationPoint(16.0F, 18.0F, -16.0F);
		Doors.addChild(Door_R);
		

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(-16.0F, -74.5F, 16.0F);
		Door_R.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, 1.5708F, 0.0F);
		cube_r6.setTextureOffset(78, 129).addBox(16.0F, 13.5F, 3.0F, 2.0F, 3.0F, 11.0F, 0.0F, false);
		cube_r6.setTextureOffset(78, 146).addBox(16.0F, 28.5F, 3.0F, 2.0F, 2.0F, 11.0F, 0.0F, false);
		cube_r6.setTextureOffset(180, -2).addBox(17.4F, 16.5F, 3.0F, 0.0F, 54.0F, 11.0F, 0.0F, false);
		cube_r6.setTextureOffset(78, 162).addBox(16.0F, 42.5F, 3.0F, 2.0F, 2.0F, 11.0F, 0.0F, false);
		cube_r6.setTextureOffset(78, 178).addBox(16.0F, 56.5F, 3.0F, 2.0F, 2.0F, 11.0F, 0.0F, false);
		cube_r6.setTextureOffset(67, 127).addBox(16.0F, 13.5F, 14.0F, 2.0F, 61.0F, 2.0F, 0.0F, false);
		cube_r6.setTextureOffset(13, 126).addBox(16.0F, 13.5F, 0.0F, 2.0F, 61.0F, 3.0F, 0.0F, false);
		cube_r6.setTextureOffset(0, 1).addBox(16.0F, 70.5F, 3.0F, 2.0F, 4.0F, 11.0F, 0.0F, false);

		Handle = new ModelRenderer(this);
		Handle.setRotationPoint(-16.0F, -16.5F, 16.0F);
		Door_R.addChild(Handle);
		

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(0.0F, 0.0F, 0.0F);
		Handle.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0F, 1.5708F, 0.0F);
		cube_r7.setTextureOffset(40, 8).addBox(17.1F, -17.5F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r7.setTextureOffset(3, 3).addBox(18.1F, -16.5F, 1.5F, 1.0F, 0.0F, 1.0F, 0.0F, false);
		cube_r7.setTextureOffset(12, 19).addBox(19.1F, -16.5F, 1.5F, 0.0F, 4.0F, 1.0F, 0.0F, false);
		cube_r7.setTextureOffset(3, 3).addBox(18.1F, -12.5F, 1.5F, 1.0F, 0.0F, 1.0F, 0.0F, false);
		cube_r7.setTextureOffset(34, 8).addBox(17.1F, -12.5F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		windows = new LightModelRenderer(this);
		windows.setRotationPoint(-16.0F, -46.5F, 16.0F);
		Door_R.addChild(windows);
		

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(0.0F, 0.0F, 0.0F);
		windows.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.0F, 1.5708F, 0.0F);
		cube_r8.setTextureOffset(19, 18).addBox(17.45F, -10.2F, 10.9F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		cube_r8.setTextureOffset(19, 18).addBox(17.45F, -10.2F, 7.5F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		cube_r8.setTextureOffset(19, 18).addBox(17.45F, -10.2F, 4.1F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		cube_r8.setTextureOffset(19, 18).addBox(17.45F, -4.8F, 4.1F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		cube_r8.setTextureOffset(19, 18).addBox(17.45F, -4.8F, 7.5F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		cube_r8.setTextureOffset(19, 18).addBox(17.45F, -4.8F, 10.9F, 0.0F, 4.0F, 2.0F, 0.0F, false);

		Door_L = new ModelRenderer(this);
		Door_L.setRotationPoint(-16.0F, 18.0F, -16.0F);
		Doors.addChild(Door_L);
		

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(16.0F, -74.5F, 16.0F);
		Door_L.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.0F, 1.5708F, 0.0F);
		cube_r9.setTextureOffset(78, 129).addBox(16.0F, 13.5F, -14.0F, 2.0F, 3.0F, 11.0F, 0.0F, false);
		cube_r9.setTextureOffset(78, 146).addBox(16.0F, 28.5F, -14.0F, 2.0F, 2.0F, 11.0F, 0.0F, false);
		cube_r9.setTextureOffset(3, 9).addBox(17.5F, 35.5F, -14.0F, 1.0F, 0.0F, 1.0F, 0.0F, false);
		cube_r9.setTextureOffset(0, 9).addBox(17.5F, 37.5F, -14.0F, 1.0F, 0.0F, 1.0F, 0.0F, false);
		cube_r9.setTextureOffset(15, 20).addBox(18.5F, 35.5F, -14.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r9.setTextureOffset(22, 8).addBox(16.5F, 37.5F, -14.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r9.setTextureOffset(28, 8).addBox(16.5F, 34.5F, -14.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r9.setTextureOffset(180, -2).addBox(17.4F, 16.5F, -14.0F, 0.0F, 54.0F, 11.0F, 0.0F, false);
		cube_r9.setTextureOffset(78, 162).addBox(16.0F, 42.5F, -14.0F, 2.0F, 2.0F, 11.0F, 0.0F, false);
		cube_r9.setTextureOffset(78, 178).addBox(16.0F, 56.5F, -14.0F, 2.0F, 2.0F, 11.0F, 0.0F, false);
		cube_r9.setTextureOffset(37, 127).addBox(16.0F, 13.5F, -16.0F, 2.0F, 61.0F, 2.0F, 0.0F, false);
		cube_r9.setTextureOffset(26, 127).addBox(16.6F, 13.5F, -1.0F, 2.0F, 61.0F, 2.0F, 0.0F, false);
		cube_r9.setTextureOffset(0, 1).addBox(16.0F, 70.5F, -14.0F, 2.0F, 4.0F, 11.0F, 0.0F, false);
		cube_r9.setTextureOffset(0, 126).addBox(16.0F, 13.5F, -3.0F, 2.0F, 61.0F, 3.0F, 0.0F, false);

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

		windows3 = new LightModelRenderer(this);
		windows3.setRotationPoint(0.0F, -28.5F, 0.0F);
		Root.addChild(windows3);
		windows3.setTextureOffset(19, 18).addBox(17.45F, -4.8F, 10.899F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		windows3.setTextureOffset(19, 18).addBox(17.45F, -10.2F, 10.899F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		windows3.setTextureOffset(19, 18).addBox(17.45F, -10.2F, 7.499F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		windows3.setTextureOffset(19, 18).addBox(17.45F, -4.8F, 7.499F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		windows3.setTextureOffset(19, 18).addBox(17.45F, -4.8F, -9.501F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		windows3.setTextureOffset(19, 18).addBox(17.45F, -4.8F, -6.101F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		windows3.setTextureOffset(19, 18).addBox(17.45F, -10.2F, -6.101F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		windows3.setTextureOffset(19, 18).addBox(17.45F, -10.2F, -9.501F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		windows3.setTextureOffset(19, 18).addBox(17.45F, -4.8F, -12.901F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		windows3.setTextureOffset(19, 18).addBox(17.45F, -10.2F, -12.901F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		windows3.setTextureOffset(19, 18).addBox(17.45F, -10.2F, 4.099F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		windows3.setTextureOffset(19, 18).addBox(17.45F, -4.8F, 4.099F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		windows3.setTextureOffset(19, 18).addBox(-17.45F, -4.8F, -12.901F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		windows3.setTextureOffset(19, 18).addBox(-17.45F, -10.2F, -12.901F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		windows3.setTextureOffset(19, 18).addBox(-17.45F, -10.2F, -9.501F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		windows3.setTextureOffset(19, 18).addBox(-17.45F, -10.2F, -6.101F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		windows3.setTextureOffset(19, 18).addBox(-17.45F, -4.8F, -6.101F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		windows3.setTextureOffset(19, 18).addBox(-17.45F, -4.8F, -9.501F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		windows3.setTextureOffset(19, 18).addBox(-17.45F, -4.8F, 4.099F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		windows3.setTextureOffset(19, 18).addBox(-17.45F, -4.8F, 7.499F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		windows3.setTextureOffset(19, 18).addBox(-17.45F, -4.8F, 10.899F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		windows3.setTextureOffset(19, 18).addBox(-17.45F, -10.2F, 10.899F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		windows3.setTextureOffset(19, 18).addBox(-17.45F, -10.2F, 7.499F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		windows3.setTextureOffset(19, 18).addBox(-17.45F, -10.2F, 4.099F, 0.0F, 4.0F, 2.0F, 0.0F, false);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(0.0F, 0.0F, 0.0F);
		windows3.addChild(cube_r12);
		setRotationAngle(cube_r12, 0.0F, 1.5708F, 0.0F);
		cube_r12.setTextureOffset(19, 18).addBox(-17.45F, -10.2F, -6.1F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		cube_r12.setTextureOffset(19, 18).addBox(-17.45F, -4.8F, -6.1F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		cube_r12.setTextureOffset(19, 18).addBox(-17.45F, -4.8F, -9.5F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		cube_r12.setTextureOffset(19, 18).addBox(-17.45F, -4.8F, -12.9F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		cube_r12.setTextureOffset(19, 18).addBox(-17.45F, -10.2F, -12.9F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		cube_r12.setTextureOffset(19, 18).addBox(-17.45F, -10.2F, -9.5F, 0.0F, 4.0F, 2.0F, 0.0F, false);

		cube_r13 = new ModelRenderer(this);
		cube_r13.setRotationPoint(8.5F, -5.5F, 17.45F);
		windows3.addChild(cube_r13);
		setRotationAngle(cube_r13, 0.0F, -1.5708F, 0.0F);
		cube_r13.setTextureOffset(19, 18).addBox(0.0F, -4.7F, 2.4F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		cube_r13.setTextureOffset(19, 18).addBox(0.0F, 0.7F, 2.4F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		cube_r13.setTextureOffset(19, 18).addBox(0.0F, 0.7F, -1.0F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		cube_r13.setTextureOffset(19, 18).addBox(0.0F, -4.7F, -1.0F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		cube_r13.setTextureOffset(19, 18).addBox(0.0F, -4.7F, -4.4F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		cube_r13.setTextureOffset(19, 18).addBox(0.0F, 0.7F, -4.4F, 0.0F, 4.0F, 2.0F, 0.0F, false);

		Lamp = new LightModelRenderer(this);
		Lamp.setRotationPoint(0.0F, -52.0F, 0.0F);
		Root.addChild(Lamp);
		Lamp.setTextureOffset(2, 32).addBox(-2.0F, -13.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);

		BOTI = new ModelRenderer(this);
		BOTI.setRotationPoint(0.0F, 18.0F, -16.0F);
		Root.addChild(BOTI);
		BOTI.setTextureOffset(236, 32).addBox(-16.0F, -61.0F, -0.001F, 32.0F, 61.0F, 0.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Root.render(matrixStack, buffer, packedLight, packedOverlay,1,1,1, alpha);
	}

	@Override
	public void renderBones(ExteriorTile exterior, float scale, MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float alpha) {
		EnumDoorState state = exterior.getOpen();
		switch (state) {
			case ONE:
				this.Door_R.rotateAngleY = (float) Math.toRadians(
						IMDoorType.EnumDoorType.FOURTEENTH.getRotationForState(EnumDoorState.ONE)); //Only open right door, left door is closed by default
				this.Door_L.rotateAngleY = (float) Math.toRadians(
						IMDoorType.EnumDoorType.FOURTEENTH.getRotationForState(EnumDoorState.CLOSED));
				break;
			case BOTH:
				this.Door_R.rotateAngleY = (float) Math.toRadians(
						IMDoorType.EnumDoorType.FOURTEENTH.getRotationForState(EnumDoorState.ONE));
				this.Door_L.rotateAngleY = (float) Math.toRadians(
						IMDoorType.EnumDoorType.FOURTEENTH.getRotationForState(EnumDoorState.BOTH)); //Open left door,Right door is already open
				break;
			case CLOSED://close both doors
				this.Door_R.rotateAngleY = (float) Math.toRadians(
						IMDoorType.EnumDoorType.FOURTEENTH.getRotationForState(EnumDoorState.CLOSED));
				this.Door_L.rotateAngleY = (float) Math.toRadians(
						IMDoorType.EnumDoorType.FOURTEENTH.getRotationForState(EnumDoorState.CLOSED));
				break;
			default:
				break;
		}
		Root.render(matrixStack, buffer, packedLight, packedOverlay,1,1,1, alpha);
		Lamp.setBright(exterior.getLightLevel());
		windows.setBright(exterior.getLightLevel());
		windows2.setBright(exterior.getLightLevel());
		windows3.setBright(exterior.getLightLevel());
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
				this.Doors.render(matrix, buf.getBuffer(RenderType.getEntityCutout(FourteenthExteriorRender.TEXTURE)), packedLight, packedOverlay);
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