package net.tadditions.mod.client.model;// Made with Blockbench 4.9.3
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.tadditions.mod.tileentity.FourteenthConsoleTile;
import net.tardis.mod.client.models.consoles.AbstractConsoleEntityModel;

public class FourteenthConsoleModel extends AbstractConsoleEntityModel<FourteenthConsoleTile> {
	private final ModelRenderer root;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;
	private final ModelRenderer cube_r10;
	private final ModelRenderer cube_r11;
	private final ModelRenderer cube_r12;
	private final ModelRenderer cube_r13;
	private final ModelRenderer cube_r14;
	private final ModelRenderer cube_r15;
	private final ModelRenderer cube_r16;
	private final ModelRenderer cube_r17;
	private final ModelRenderer cube_r18;
	private final ModelRenderer cube_r19;
	private final ModelRenderer cube_r20;
	private final ModelRenderer cube_r21;
	private final ModelRenderer cube_r22;
	private final ModelRenderer cube_r23;
	private final ModelRenderer cube_r24;
	private final ModelRenderer cube_r25;
	private final ModelRenderer cube_r26;
	private final ModelRenderer cube_r27;
	private final ModelRenderer cube_r28;
	private final ModelRenderer cube_r29;
	private final ModelRenderer cube_r30;
	private final ModelRenderer caps;
	private final ModelRenderer cube_r31;
	private final ModelRenderer cube_r32;
	private final ModelRenderer cube_r33;
	private final ModelRenderer cube_r34;
	private final ModelRenderer cube_r35;
	private final ModelRenderer cube_r36;
	private final ModelRenderer cube_r37;
	private final ModelRenderer cube_r38;
	private final ModelRenderer cube_r39;
	private final ModelRenderer cube_r40;
	private final ModelRenderer cube_r41;
	private final ModelRenderer monitor_circle;
	private final ModelRenderer bone2;
	private final ModelRenderer cube_r42;
	private final ModelRenderer bone3;
	private final ModelRenderer cube_r43;
	private final ModelRenderer bone4;
	private final ModelRenderer cube_r44;
	private final ModelRenderer bone5;
	private final ModelRenderer cube_r45;
	private final ModelRenderer bone6;
	private final ModelRenderer cube_r46;
	private final ModelRenderer bone7;
	private final ModelRenderer cube_r47;
	private final ModelRenderer bone8;
	private final ModelRenderer cube_r48;
	private final ModelRenderer cube_r49;
	private final ModelRenderer cube_r50;
	private final ModelRenderer cube_r51;
	private final ModelRenderer cube_r52;
	private final ModelRenderer cube_r53;
	private final ModelRenderer cube_r54;
	private final ModelRenderer monitor;
	private final ModelRenderer cube_r55;
	private final ModelRenderer cube_r56;
	private final ModelRenderer cube_r57;
	private final ModelRenderer cube_r58;
	private final ModelRenderer cube_r59;
	private final ModelRenderer screen;
	private final ModelRenderer cube_r60;
	private final ModelRenderer side1;
	private final ModelRenderer cube_r61;
	private final ModelRenderer cube_r62;
	private final ModelRenderer cube_r63;
	private final ModelRenderer cube_r64;
	private final ModelRenderer cube_r65;
	private final ModelRenderer cube_r66;
	private final ModelRenderer cube_r67;
	private final ModelRenderer tank;
	private final ModelRenderer cube_r68;
	private final ModelRenderer cube_r69;
	private final ModelRenderer cube_r70;
	private final ModelRenderer tank_lights;
	private final ModelRenderer cube_r71;
	private final ModelRenderer tank_lever;
	private final ModelRenderer tank_switch;
	private final ModelRenderer microscope;
	private final ModelRenderer cube_r72;
	private final ModelRenderer cube_r73;
	private final ModelRenderer microscope_glasses;
	private final ModelRenderer cube_r74;
	private final ModelRenderer controls1;
	private final ModelRenderer rotary_switches_group_1;
	private final ModelRenderer lights_group;
	private final ModelRenderer button_group1;
	private final ModelRenderer button_group2;
	private final ModelRenderer controller;
	private final ModelRenderer cube_r75;
	private final ModelRenderer cube_r76;
	private final ModelRenderer cube_r77;
	private final ModelRenderer cube_r78;
	private final ModelRenderer cube_r79;
	private final ModelRenderer cube_r80;
	private final ModelRenderer cube_r81;
	private final ModelRenderer cube_r82;
	private final ModelRenderer joystic;
	private final ModelRenderer button_group3;
	private final ModelRenderer button_group4;
	private final ModelRenderer side2;
	private final ModelRenderer cube_r83;
	private final ModelRenderer cube_r84;
	private final ModelRenderer cube_r85;
	private final ModelRenderer cube_r86;
	private final ModelRenderer cube_r87;
	private final ModelRenderer cube_r88;
	private final ModelRenderer cube_r89;
	private final ModelRenderer cube_r90;
	private final ModelRenderer cube_r91;
	private final ModelRenderer cube_r92;
	private final ModelRenderer controls2;
	private final ModelRenderer cube_r93;
	private final ModelRenderer cube_r94;
	private final ModelRenderer cube_r95;
	private final ModelRenderer lights2;
	private final ModelRenderer lights2_group1;
	private final ModelRenderer cube_r96;
	private final ModelRenderer lights2_group2;
	private final ModelRenderer cube_r97;
	private final ModelRenderer spinny_switch1;
	private final ModelRenderer spinny_switch2;
	private final ModelRenderer spinny_switch3;
	private final ModelRenderer spinny_switch4;
	private final ModelRenderer communicator;
	private final ModelRenderer cube_r98;
	private final ModelRenderer cube_r99;
	private final ModelRenderer cube_r100;
	private final ModelRenderer cube_r101;
	private final ModelRenderer cube_r102;
	private final ModelRenderer cube_r103;
	private final ModelRenderer cube_r104;
	private final ModelRenderer cube_r105;
	private final ModelRenderer cube_r106;
	private final ModelRenderer lights_group2;
	private final ModelRenderer cube_r107;
	private final ModelRenderer communicator_lights1;
	private final ModelRenderer cube_r108;
	private final ModelRenderer communicator_lights2;
	private final ModelRenderer cube_r109;
	private final ModelRenderer communicator_lights3;
	private final ModelRenderer cube_r110;
	private final ModelRenderer bone16;
	private final ModelRenderer cube_r111;
	private final ModelRenderer side3;
	private final ModelRenderer cube_r112;
	private final ModelRenderer cube_r113;
	private final ModelRenderer cube_r114;
	private final ModelRenderer cube_r115;
	private final ModelRenderer controls3;
	private final ModelRenderer cube_r116;
	private final ModelRenderer cube_r117;
	private final ModelRenderer cube_r118;
	private final ModelRenderer cube_r119;
	private final ModelRenderer levers;
	private final ModelRenderer cube_r120;
	private final ModelRenderer cube_r121;
	private final ModelRenderer cube_r122;
	private final ModelRenderer cube_r123;
	private final ModelRenderer cube_r124;
	private final ModelRenderer cube_r125;
	private final ModelRenderer cube_r126;
	private final ModelRenderer demat_lever;
	private final ModelRenderer cube_r127;
	private final ModelRenderer cube_r128;
	private final ModelRenderer handbrake;
	private final ModelRenderer cube_r129;
	private final ModelRenderer lever;
	private final ModelRenderer cube_r130;
	private final ModelRenderer telepathic_circuit;
	private final ModelRenderer cube_r131;
	private final ModelRenderer telepathic_circuit_lights;
	private final ModelRenderer cube_r132;
	private final ModelRenderer lights3;
	private final ModelRenderer cube_r133;
	private final ModelRenderer lights3_group1;
	private final ModelRenderer cube_r134;
	private final ModelRenderer lights3_group2;
	private final ModelRenderer cube_r135;
	private final ModelRenderer lights3_group3;
	private final ModelRenderer cube_r136;
	private final ModelRenderer speed_lights;
	private final ModelRenderer cube_r137;
	private final ModelRenderer speed_light1;
	private final ModelRenderer cube_r138;
	private final ModelRenderer speed_light2;
	private final ModelRenderer cube_r139;
	private final ModelRenderer speed_light3;
	private final ModelRenderer cube_r140;
	private final ModelRenderer speed_light4;
	private final ModelRenderer cube_r141;
	private final ModelRenderer speed_light5;
	private final ModelRenderer cube_r142;
	private final ModelRenderer side4;
	private final ModelRenderer cube_r143;
	private final ModelRenderer cube_r144;
	private final ModelRenderer cube_r145;
	private final ModelRenderer controls4;
	private final ModelRenderer cube_r146;
	private final ModelRenderer cube_r147;
	private final ModelRenderer lights_group5;
	private final ModelRenderer cube_r148;
	private final ModelRenderer cube_r149;
	private final ModelRenderer coffee_machine;
	private final ModelRenderer cube_r150;
	private final ModelRenderer cube_r151;
	private final ModelRenderer cube_r152;
	private final ModelRenderer cube_r153;
	private final ModelRenderer cube_r154;
	private final ModelRenderer cube_r155;
	private final ModelRenderer cube_r156;
	private final ModelRenderer cube_r157;
	private final ModelRenderer cube_r158;
	private final ModelRenderer cube_r159;
	private final ModelRenderer sonic_port;
	private final ModelRenderer cable;
	private final ModelRenderer cube_r160;
	private final ModelRenderer cube_r161;
	private final ModelRenderer cube_r162;
	private final ModelRenderer cube_r163;
	private final ModelRenderer cube_r164;
	private final ModelRenderer cube_r165;
	private final ModelRenderer cube_r166;
	private final ModelRenderer cube_r167;
	private final ModelRenderer side5;
	private final ModelRenderer cube_r168;
	private final ModelRenderer cube_r169;
	private final ModelRenderer cube_r170;
	private final ModelRenderer cube_r171;
	private final ModelRenderer cube_r172;
	private final ModelRenderer cube_r173;
	private final ModelRenderer cube_r174;
	private final ModelRenderer cube_r175;
	private final ModelRenderer cube_r176;
	private final ModelRenderer cube_r177;
	private final ModelRenderer cube_r178;
	private final ModelRenderer cube_r179;
	private final ModelRenderer vertical_switch_lights1;
	private final ModelRenderer cube_r180;
	private final ModelRenderer vertical_switch_lights2;
	private final ModelRenderer cube_r181;
	private final ModelRenderer vertical_switch1;
	private final ModelRenderer cube_r182;
	private final ModelRenderer vertical_switch2;
	private final ModelRenderer cube_r183;
	private final ModelRenderer vertical_switch3;
	private final ModelRenderer cube_r184;
	private final ModelRenderer vertical_switch4;
	private final ModelRenderer cube_r185;
	private final ModelRenderer vertical_switch5;
	private final ModelRenderer cube_r186;
	private final ModelRenderer vertical_switch6;
	private final ModelRenderer cube_r187;
	private final ModelRenderer contols5;
	private final ModelRenderer cube_r188;
	private final ModelRenderer cube_r189;
	private final ModelRenderer cube_r190;
	private final ModelRenderer cube_r191;
	private final ModelRenderer cube_r192;
	private final ModelRenderer cube_r193;
	private final ModelRenderer cube_r194;
	private final ModelRenderer cube_r195;
	private final ModelRenderer lights4;
	private final ModelRenderer lights4_group1;
	private final ModelRenderer cube_r196;
	private final ModelRenderer lights4_group2;
	private final ModelRenderer cube_r197;
	private final ModelRenderer lights4_group3;
	private final ModelRenderer cube_r198;
	private final ModelRenderer indicator;
	private final ModelRenderer cube_r199;
	private final ModelRenderer lights_group3;
	private final ModelRenderer cube_r200;
	private final ModelRenderer side6;
	private final ModelRenderer cube_r201;
	private final ModelRenderer cube_r202;
	private final ModelRenderer cube_r203;
	private final ModelRenderer x_button;
	private final ModelRenderer cube_r204;
	private final ModelRenderer cube_r205;
	private final ModelRenderer cube_r206;
	private final ModelRenderer cube_r207;
	private final ModelRenderer cube_r208;
	private final ModelRenderer cube_r209;
	private final ModelRenderer x_button_light;
	private final ModelRenderer cube_r210;
	private final ModelRenderer y_button;
	private final ModelRenderer cube_r211;
	private final ModelRenderer cube_r212;
	private final ModelRenderer cube_r213;
	private final ModelRenderer cube_r214;
	private final ModelRenderer cube_r215;
	private final ModelRenderer cube_r216;
	private final ModelRenderer y_button_light;
	private final ModelRenderer cube_r217;
	private final ModelRenderer z_button;
	private final ModelRenderer cube_r218;
	private final ModelRenderer cube_r219;
	private final ModelRenderer cube_r220;
	private final ModelRenderer cube_r221;
	private final ModelRenderer cube_r222;
	private final ModelRenderer cube_r223;
	private final ModelRenderer z_button_light;
	private final ModelRenderer cube_r224;
	private final ModelRenderer increment_button;
	private final ModelRenderer cube_r225;
	private final ModelRenderer cube_r226;
	private final ModelRenderer cube_r227;
	private final ModelRenderer cube_r228;
	private final ModelRenderer cube_r229;
	private final ModelRenderer cube_r230;
	private final ModelRenderer increment_button_light;
	private final ModelRenderer cube_r231;
	private final ModelRenderer buttons_cables;
	private final ModelRenderer cube_r232;
	private final ModelRenderer cube_r233;
	private final ModelRenderer cube_r234;
	private final ModelRenderer cube_r235;
	private final ModelRenderer cube_r236;
	private final ModelRenderer cube_r237;
	private final ModelRenderer cube_r238;
	private final ModelRenderer cube_r239;
	private final ModelRenderer vent1;
	private final ModelRenderer cube_r240;
	private final ModelRenderer cube_r241;
	private final ModelRenderer vent2;
	private final ModelRenderer cube_r242;
	private final ModelRenderer cube_r243;
	private final ModelRenderer controls6;
	private final ModelRenderer cube_r244;
	private final ModelRenderer lights_group4;
	private final ModelRenderer cube_r245;
	private final ModelRenderer stabilizers;
	private final ModelRenderer cube_r246;
	private final ModelRenderer stabilizers_lights;
	private final ModelRenderer cube_r247;
	private final ModelRenderer rotor;
	private final ModelRenderer cube_r248;
	private final ModelRenderer cube_r249;
	private final ModelRenderer cube_r250;
	private final ModelRenderer cube_r251;
	private final ModelRenderer cube_r252;
	private final ModelRenderer cube_r253;
	private final ModelRenderer cube_r254;
	private final ModelRenderer cube_r255;
	private final ModelRenderer cube_r256;
	private final ModelRenderer cube_r257;
	private final ModelRenderer cube_r258;
	private final ModelRenderer cube_r259;
	private final ModelRenderer cube_r260;
	private final ModelRenderer cube_r261;
	private final ModelRenderer cube_r262;
	private final ModelRenderer cube_r263;
	private final ModelRenderer cube_r264;
	private final ModelRenderer cube_r265;
	private final ModelRenderer cube_r266;
	private final ModelRenderer cube_r267;
	private final ModelRenderer cube_r268;
	private final ModelRenderer cube_r269;
	private final ModelRenderer cube_r270;
	private final ModelRenderer cube_r271;
	private final ModelRenderer cube_r272;
	private final ModelRenderer cube_r273;
	private final ModelRenderer cube_r274;
	private final ModelRenderer cube_r275;
	private final ModelRenderer cube_r276;
	private final ModelRenderer cube_r277;
	private final ModelRenderer cube_r278;
	private final ModelRenderer cube_r279;
	private final ModelRenderer cube_r280;
	private final ModelRenderer cube_r281;
	private final ModelRenderer cube_r282;
	private final ModelRenderer cube_r283;
	private final ModelRenderer cube_r284;
	private final ModelRenderer cube_r285;
	private final ModelRenderer cube_r286;
	private final ModelRenderer cube_r287;
	private final ModelRenderer cube_r288;
	private final ModelRenderer cube_r289;
	private final ModelRenderer cube_r290;
	private final ModelRenderer cube_r291;
	private final ModelRenderer cube_r292;
	private final ModelRenderer cube_r293;
	private final ModelRenderer cube_r294;
	private final ModelRenderer cube_r295;
	private final ModelRenderer cube_r296;
	private final ModelRenderer cube_r297;
	private final ModelRenderer cube_r298;
	private final ModelRenderer cube_r299;
	private final ModelRenderer cube_r300;
	private final ModelRenderer cube_r301;
	private final ModelRenderer bone;
	private final ModelRenderer cube_r302;
	private final ModelRenderer cube_r303;
	private final ModelRenderer cube_r304;
	private final ModelRenderer cube_r305;
	private final ModelRenderer cube_r306;
	private final ModelRenderer rotor_lights;
	private final ModelRenderer cube_r307;
	private final ModelRenderer cube_r308;
	private final ModelRenderer cube_r309;
	private final ModelRenderer cube_r310;
	private final ModelRenderer cube_r311;
	private final ModelRenderer cube_r312;
	private final ModelRenderer caps_bottom;
	private final ModelRenderer rotor_cap_bottom1;
	private final ModelRenderer rotor_cap_bottom2;
	private final ModelRenderer rotor_cap_bottom3;
	private final ModelRenderer rotor_cap_bottom4;
	private final ModelRenderer rotor_cap_bottom5;
	private final ModelRenderer rotor_cap_bottom6;
	private final ModelRenderer caps_top;
	private final ModelRenderer rotor_cap_top;
	private final ModelRenderer rotor_cap_top2;
	private final ModelRenderer rotor_cap_top3;
	private final ModelRenderer rotor_cap_top4;
	private final ModelRenderer rotor_cap_top5;
	private final ModelRenderer rotor_cap_top6;
	private final ModelRenderer rotor_glass;
	private final ModelRenderer cube_r313;
	private final ModelRenderer cube_r314;
	private final ModelRenderer cube_r315;
	private final ModelRenderer cube_r316;
	private final ModelRenderer cube_r317;
	private final ModelRenderer cube_r318;
	private final ModelRenderer rotor_glass_parts;
	private final ModelRenderer rotor_core;
	private final ModelRenderer bone10;
	private final ModelRenderer bone9;
	private final ModelRenderer cube_r319;
	private final ModelRenderer cube_r320;
	private final ModelRenderer cube_r321;
	private final ModelRenderer cube_r322;
	private final ModelRenderer cube_r323;
	private final ModelRenderer cube_r324;
	private final ModelRenderer bone11;
	private final ModelRenderer cube_r325;
	private final ModelRenderer cube_r326;
	private final ModelRenderer cube_r327;
	private final ModelRenderer cube_r328;
	private final ModelRenderer cube_r329;
	private final ModelRenderer cube_r330;
	private final ModelRenderer bone12;
	private final ModelRenderer cube_r331;
	private final ModelRenderer cube_r332;
	private final ModelRenderer cube_r333;
	private final ModelRenderer cube_r334;
	private final ModelRenderer cube_r335;
	private final ModelRenderer cube_r336;
	private final ModelRenderer bone13;
	private final ModelRenderer cube_r337;
	private final ModelRenderer cube_r338;
	private final ModelRenderer cube_r339;
	private final ModelRenderer cube_r340;
	private final ModelRenderer cube_r341;
	private final ModelRenderer cube_r342;
	private final ModelRenderer bone14;
	private final ModelRenderer cube_r343;
	private final ModelRenderer cube_r344;
	private final ModelRenderer cube_r345;
	private final ModelRenderer cube_r346;
	private final ModelRenderer cube_r347;
	private final ModelRenderer cube_r348;
	private final ModelRenderer bone15;
	private final ModelRenderer cube_r349;
	private final ModelRenderer cube_r350;
	private final ModelRenderer cube_r351;
	private final ModelRenderer cube_r352;
	private final ModelRenderer cube_r353;
	private final ModelRenderer cube_r354;

	public FourteenthConsoleModel() {
		textureWidth = 1024;
		textureHeight = 1024;

		root = new ModelRenderer(this);
		root.setRotationPoint(0.0F, 10.0F, 0.0F);
		root.setTextureOffset(248, 236).addBox(-39.0F, -19.0F, 63.55F, 78.0F, 3.0F, 4.0F, 0.0F, false);
		root.setTextureOffset(165, 123).addBox(-39.0F, -26.0F, 63.55F, 78.0F, 3.0F, 4.0F, 0.0F, false);
		root.setTextureOffset(248, 299).addBox(-37.0F, -23.0F, 61.0859F, 74.0F, 4.0F, 3.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, -20.0F, 0.0F);
		root.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 1.0472F, 0.0F);
		cube_r1.setTextureOffset(248, 264).addBox(-37.0F, -3.0F, 61.0859F, 74.0F, 4.0F, 3.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0.0F, -20.0F, 0.0F);
		root.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 2.0944F, 0.0F);
		cube_r2.setTextureOffset(248, 271).addBox(-37.0F, -3.0F, 61.0859F, 74.0F, 4.0F, 3.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(0.0F, -20.0F, 0.0F);
		root.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 3.1416F, 0.0F);
		cube_r3.setTextureOffset(248, 278).addBox(-37.0F, -3.0F, 61.0859F, 74.0F, 4.0F, 3.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(0.0F, -20.0F, 0.0F);
		root.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, -2.0944F, 0.0F);
		cube_r4.setTextureOffset(248, 285).addBox(-37.0F, -3.0F, 61.0859F, 74.0F, 4.0F, 3.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(0.0F, -20.0F, 0.0F);
		root.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, -1.0472F, 0.0F);
		cube_r5.setTextureOffset(248, 292).addBox(-37.0F, -3.0F, 61.0859F, 74.0F, 4.0F, 3.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(0.0F, -24.5F, 0.0F);
		root.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, 2.0944F, 0.0F);
		cube_r6.setTextureOffset(248, 250).addBox(-39.0F, -1.5F, 63.55F, 78.0F, 3.0F, 4.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(0.0F, -24.5F, 0.0F);
		root.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0F, 3.1416F, 0.0F);
		cube_r7.setTextureOffset(165, 157).addBox(-39.0F, -1.5F, 63.55F, 78.0F, 3.0F, 4.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(-41.1451F, -26.3915F, -52.2841F);
		root.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.3644F, -0.9308F, -0.5439F);
		cube_r8.setTextureOffset(248, 257).addBox(-6.4F, -1.5F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r8.setTextureOffset(479, 81).addBox(-6.0F, -1.5F, -1.5F, 27.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(-33.9911F, -30.7177F, -41.0545F);
		root.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.3644F, -0.9308F, -0.5439F);
		cube_r9.setTextureOffset(510, 162).addBox(-6.0F, 1.5F, -1.5F, 13.0F, 7.0F, 2.0F, 0.0F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(-58.7258F, -28.7091F, -9.1795F);
		root.addChild(cube_r10);
		setRotationAngle(cube_r10, 3.0408F, 0.0415F, 2.8272F);
		cube_r10.setTextureOffset(386, 437).addBox(-13.5F, 1.5F, -1.5F, 13.0F, 7.0F, 2.0F, 0.0F, false);
		cube_r10.setTextureOffset(6, 0).addBox(12.9F, -1.5F, -1.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		cube_r10.setTextureOffset(479, 86).addBox(-13.5F, -1.5F, -1.5F, 27.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(-37.9599F, -34.4263F, -22.0015F);
		root.addChild(cube_r11);
		setRotationAngle(cube_r11, -2.9234F, -1.0472F, 3.1416F);
		cube_r11.setTextureOffset(0, 357).addBox(0.0F, 0.0F, -24.0F, 17.0F, 9.0F, 24.0F, 0.0F, false);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(-46.0967F, -38.0552F, -26.7847F);
		root.addChild(cube_r12);
		setRotationAngle(cube_r12, -2.9234F, -1.0472F, 3.1416F);
		cube_r12.setTextureOffset(333, 337).addBox(-16.7782F, 1.5F, -34.0F, 17.0F, 9.0F, 24.0F, 0.0F, false);

		cube_r13 = new ModelRenderer(this);
		cube_r13.setRotationPoint(-21.44F, -26.6946F, -49.2434F);
		root.addChild(cube_r13);
		setRotationAngle(cube_r13, 2.7925F, -1.0472F, 3.1416F);
		cube_r13.setTextureOffset(165, 130).addBox(15.0F, -7.5F, -2.0F, 17.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r14 = new ModelRenderer(this);
		cube_r14.setRotationPoint(-27.1798F, -26.3526F, -41.1811F);
		root.addChild(cube_r14);
		setRotationAngle(cube_r14, 2.7925F, -1.0472F, 3.1416F);
		cube_r14.setTextureOffset(443, 10).addBox(22.0F, -7.5F, -3.0F, 17.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r15 = new ModelRenderer(this);
		cube_r15.setRotationPoint(-73.268F, -24.5F, -4.1962F);
		root.addChild(cube_r15);
		setRotationAngle(cube_r15, 0.0F, -2.0944F, 0.0F);
		cube_r15.setTextureOffset(248, 243).addBox(-72.0F, -1.5F, -2.0F, 78.0F, 3.0F, 4.0F, 0.0F, false);

		cube_r16 = new ModelRenderer(this);
		cube_r16.setRotationPoint(53.9571F, -24.6529F, 31.1521F);
		root.addChild(cube_r16);
		setRotationAngle(cube_r16, 2.8362F, 1.0472F, 0.0F);
		cube_r16.setTextureOffset(337, 144).addBox(-22.0F, -1.0F, -5.5F, 44.0F, 1.0F, 11.0F, 0.0F, false);

		cube_r17 = new ModelRenderer(this);
		cube_r17.setRotationPoint(0.0F, -24.5F, 0.0F);
		root.addChild(cube_r17);
		setRotationAngle(cube_r17, 0.0F, 1.0472F, 0.0F);
		cube_r17.setTextureOffset(344, 181).addBox(-22.0F, 1.5F, 63.55F, 44.0F, 4.0F, 4.0F, 0.0F, false);
		cube_r17.setTextureOffset(192, 488).addBox(-39.0F, -1.5F, 63.55F, 17.0F, 3.0F, 4.0F, 0.0F, false);

		cube_r18 = new ModelRenderer(this);
		cube_r18.setRotationPoint(61.476F, -27.4976F, 11.2767F);
		root.addChild(cube_r18);
		setRotationAngle(cube_r18, -0.0602F, -0.1639F, 0.354F);
		cube_r18.setTextureOffset(156, 308).addBox(-2.5F, -1.5F, 1.0F, 11.0F, 3.0F, 1.0F, 0.0F, false);
		cube_r18.setTextureOffset(436, 181).addBox(-2.5F, 0.5F, 1.0F, 4.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r19 = new ModelRenderer(this);
		cube_r19.setRotationPoint(61.4764F, -24.5F, 11.2768F);
		root.addChild(cube_r19);
		setRotationAngle(cube_r19, 0.0F, -0.1745F, 0.0F);
		cube_r19.setTextureOffset(464, 366).addBox(-3.5F, -1.5F, 1.0F, 12.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r20 = new ModelRenderer(this);
		cube_r20.setRotationPoint(48.0816F, -28.6947F, 28.8042F);
		root.addChild(cube_r20);
		setRotationAngle(cube_r20, -0.3491F, 1.0472F, 0.0F);
		cube_r20.setTextureOffset(450, 138).addBox(-18.5F, -1.5F, 1.0F, 20.0F, 4.0F, 1.0F, 0.0F, false);

		cube_r21 = new ModelRenderer(this);
		cube_r21.setRotationPoint(53.986F, -28.6947F, 18.5775F);
		root.addChild(cube_r21);
		setRotationAngle(cube_r21, -0.3491F, 1.0472F, 0.0F);
		cube_r21.setTextureOffset(406, 487).addBox(-11.5F, -1.5F, 1.0F, 20.0F, 4.0F, 1.0F, 0.0F, false);

		cube_r22 = new ModelRenderer(this);
		cube_r22.setRotationPoint(72.018F, -24.5F, 6.3612F);
		root.addChild(cube_r22);
		setRotationAngle(cube_r22, 0.0F, 1.0472F, 0.0F);
		cube_r22.setTextureOffset(80, 441).addBox(-8.5F, -1.5F, -2.0F, 17.0F, 3.0F, 4.0F, 0.0F, false);

		cube_r23 = new ModelRenderer(this);
		cube_r23.setRotationPoint(40.2841F, -26.5579F, 47.3394F);
		root.addChild(cube_r23);
		setRotationAngle(cube_r23, -2.7545F, 0.8036F, -2.6264F);
		cube_r23.setTextureOffset(148, 261).addBox(-1.5F, -0.5F, 1.0F, 4.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r23.setTextureOffset(51, 436).addBox(-8.5F, -2.5F, 1.0F, 11.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r24 = new ModelRenderer(this);
		cube_r24.setRotationPoint(40.5042F, -24.5F, 47.6018F);
		root.addChild(cube_r24);
		setRotationAngle(cube_r24, 0.0F, 2.2689F, 0.0F);
		cube_r24.setTextureOffset(451, 430).addBox(-8.5F, -1.5F, 1.0F, 12.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r25 = new ModelRenderer(this);
		cube_r25.setRotationPoint(0.0F, -24.5F, 0.0F);
		root.addChild(cube_r25);
		setRotationAngle(cube_r25, 0.0F, -1.0472F, 0.0F);
		cube_r25.setTextureOffset(165, 89).addBox(-39.0F, -1.5F, 63.55F, 78.0F, 3.0F, 4.0F, 0.0F, false);

		cube_r26 = new ModelRenderer(this);
		cube_r26.setRotationPoint(-20.7654F, -17.0F, -27.0F);
		root.addChild(cube_r26);
		setRotationAngle(cube_r26, 0.0F, 1.0472F, 0.0F);
		cube_r26.setTextureOffset(165, 56).addBox(-52.0F, -2.0F, 95.0333F, 78.0F, 3.0F, 4.0F, 0.0F, false);

		cube_r27 = new ModelRenderer(this);
		cube_r27.setRotationPoint(-33.7654F, -17.0F, 4.4833F);
		root.addChild(cube_r27);
		setRotationAngle(cube_r27, 0.0F, 2.0944F, 0.0F);
		cube_r27.setTextureOffset(248, 257).addBox(-52.0F, -2.0F, 95.0333F, 78.0F, 3.0F, 4.0F, 0.0F, false);

		cube_r28 = new ModelRenderer(this);
		cube_r28.setRotationPoint(-13.0F, -17.0F, 31.4833F);
		root.addChild(cube_r28);
		setRotationAngle(cube_r28, 0.0F, 3.1416F, 0.0F);
		cube_r28.setTextureOffset(198, 164).addBox(-52.0F, -2.0F, 95.0333F, 78.0F, 3.0F, 4.0F, 0.0F, false);

		cube_r29 = new ModelRenderer(this);
		cube_r29.setRotationPoint(20.7654F, -17.0F, 27.0F);
		root.addChild(cube_r29);
		setRotationAngle(cube_r29, 0.0F, -2.0944F, 0.0F);
		cube_r29.setTextureOffset(248, 222).addBox(-52.0F, -2.0F, 95.0333F, 78.0F, 3.0F, 4.0F, 0.0F, false);

		cube_r30 = new ModelRenderer(this);
		cube_r30.setRotationPoint(33.7654F, -17.0F, -4.4833F);
		root.addChild(cube_r30);
		setRotationAngle(cube_r30, 0.0F, -1.0472F, 0.0F);
		cube_r30.setTextureOffset(248, 229).addBox(-52.0F, -2.0F, 95.0333F, 78.0F, 3.0F, 4.0F, 0.0F, false);

		caps = new ModelRenderer(this);
		caps.setRotationPoint(0.0F, -14.0F, 0.0F);
		root.addChild(caps);
		

		cube_r31 = new ModelRenderer(this);
		cube_r31.setRotationPoint(-42.2254F, -20.9377F, -19.0F);
		caps.addChild(cube_r31);
		setRotationAngle(cube_r31, 0.0F, -1.5708F, 0.1745F);
		cube_r31.setTextureOffset(499, 44).addBox(18.0F, -1.3F, -9.4F, 2.0F, 2.0F, 12.0F, 0.0F, false);

		cube_r32 = new ModelRenderer(this);
		cube_r32.setRotationPoint(-32.909F, -21.0F, -19.0F);
		caps.addChild(cube_r32);
		setRotationAngle(cube_r32, -2.9671F, -1.0472F, 3.1416F);
		cube_r32.setTextureOffset(193, 431).addBox(-18.0F, -1.0F, -8.0F, 36.0F, 1.0F, 3.0F, 0.0F, false);
		cube_r32.setTextureOffset(198, 66).addBox(-17.0F, -1.0F, -9.0F, 34.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r32.setTextureOffset(332, 218).addBox(-22.0F, -1.0F, -1.0F, 44.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r32.setTextureOffset(401, 371).addBox(-21.0F, -1.0F, -3.0F, 42.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r32.setTextureOffset(412, 238).addBox(-20.0F, -1.0F, -5.0F, 40.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r33 = new ModelRenderer(this);
		cube_r33.setRotationPoint(-4.6582F, -20.9377F, -46.0683F);
		caps.addChild(cube_r33);
		setRotationAngle(cube_r33, -2.9671F, -0.5236F, 3.1416F);
		cube_r33.setTextureOffset(377, 499).addBox(18.0F, -1.3F, -9.4F, 2.0F, 2.0F, 12.0F, 0.0F, false);

		cube_r34 = new ModelRenderer(this);
		cube_r34.setRotationPoint(37.5672F, -20.9377F, -27.0683F);
		caps.addChild(cube_r34);
		setRotationAngle(cube_r34, -2.9671F, 0.5236F, 3.1416F);
		cube_r34.setTextureOffset(487, 499).addBox(18.0F, -1.3F, -9.4F, 2.0F, 2.0F, 12.0F, 0.0F, false);

		cube_r35 = new ModelRenderer(this);
		cube_r35.setRotationPoint(32.909F, -21.0F, -19.0F);
		caps.addChild(cube_r35);
		setRotationAngle(cube_r35, -2.9671F, 1.0472F, 3.1416F);
		cube_r35.setTextureOffset(112, 432).addBox(-18.0F, -1.0F, -8.0F, 36.0F, 1.0F, 3.0F, 0.0F, false);
		cube_r35.setTextureOffset(176, 353).addBox(-17.0F, -1.0F, -9.0F, 34.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r35.setTextureOffset(357, 53).addBox(-22.0F, -1.0F, -1.0F, 44.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r35.setTextureOffset(401, 374).addBox(-21.0F, -1.0F, -3.0F, 42.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r35.setTextureOffset(333, 427).addBox(-20.0F, -1.0F, -5.0F, 40.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r36 = new ModelRenderer(this);
		cube_r36.setRotationPoint(42.2254F, -20.9377F, 19.0F);
		caps.addChild(cube_r36);
		setRotationAngle(cube_r36, 0.0F, 1.5708F, -0.1745F);
		cube_r36.setTextureOffset(393, 501).addBox(18.0F, -1.3F, -9.4F, 2.0F, 2.0F, 12.0F, 0.0F, false);

		cube_r37 = new ModelRenderer(this);
		cube_r37.setRotationPoint(32.909F, -21.0F, 19.0F);
		caps.addChild(cube_r37);
		setRotationAngle(cube_r37, 0.1745F, 1.0472F, 0.0F);
		cube_r37.setTextureOffset(333, 433).addBox(-18.0F, -1.0F, -8.0F, 36.0F, 1.0F, 3.0F, 0.0F, false);
		cube_r37.setTextureOffset(176, 355).addBox(-17.0F, -1.0F, -9.0F, 34.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r37.setTextureOffset(362, 168).addBox(-22.0F, -1.0F, -1.0F, 44.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r37.setTextureOffset(402, 293).addBox(-21.0F, -1.0F, -3.0F, 42.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r37.setTextureOffset(417, 427).addBox(-20.0F, -1.0F, -5.0F, 40.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r38 = new ModelRenderer(this);
		cube_r38.setRotationPoint(4.6582F, -20.9377F, 46.0683F);
		caps.addChild(cube_r38);
		setRotationAngle(cube_r38, 0.1745F, 0.5236F, 0.0F);
		cube_r38.setTextureOffset(503, 501).addBox(18.0F, -1.3F, -9.4F, 2.0F, 2.0F, 12.0F, 0.0F, false);

		cube_r39 = new ModelRenderer(this);
		cube_r39.setRotationPoint(0.0F, -21.0F, 38.0F);
		caps.addChild(cube_r39);
		setRotationAngle(cube_r39, 0.1745F, 0.0F, 0.0F);
		cube_r39.setTextureOffset(187, 435).addBox(-18.0F, -1.0F, -8.0F, 36.0F, 1.0F, 3.0F, 0.0F, false);
		cube_r39.setTextureOffset(402, 304).addBox(-17.0F, -1.0F, -9.0F, 34.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r39.setTextureOffset(364, 189).addBox(-22.0F, -1.0F, -1.0F, 44.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r39.setTextureOffset(402, 301).addBox(-21.0F, -1.0F, -3.0F, 42.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r39.setTextureOffset(112, 429).addBox(-20.0F, -1.0F, -5.0F, 40.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r40 = new ModelRenderer(this);
		cube_r40.setRotationPoint(-37.5672F, -20.9377F, 27.0683F);
		caps.addChild(cube_r40);
		setRotationAngle(cube_r40, 0.1745F, -0.5236F, 0.0F);
		cube_r40.setTextureOffset(0, 504).addBox(18.0F, -1.3F, -9.4F, 2.0F, 2.0F, 12.0F, 0.0F, false);

		cube_r41 = new ModelRenderer(this);
		cube_r41.setRotationPoint(-32.909F, -21.0F, 19.0F);
		caps.addChild(cube_r41);
		setRotationAngle(cube_r41, 0.1745F, -1.0472F, 0.0F);
		cube_r41.setTextureOffset(112, 436).addBox(-18.0F, -1.0F, -8.0F, 36.0F, 1.0F, 3.0F, 0.0F, false);
		cube_r41.setTextureOffset(412, 241).addBox(-17.0F, -1.0F, -9.0F, 34.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r41.setTextureOffset(391, 345).addBox(-22.0F, -1.0F, -1.0F, 44.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r41.setTextureOffset(198, 409).addBox(-21.0F, -1.0F, -3.0F, 42.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r41.setTextureOffset(333, 430).addBox(-20.0F, -1.0F, -5.0F, 40.0F, 1.0F, 2.0F, 0.0F, false);

		monitor_circle = new ModelRenderer(this);
		monitor_circle.setRotationPoint(0.0F, -29.0F, 0.0F);
		root.addChild(monitor_circle);
		

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, 0.0F, 0.0F);
		monitor_circle.addChild(bone2);
		

		cube_r42 = new ModelRenderer(this);
		cube_r42.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone2.addChild(cube_r42);
		setRotationAngle(cube_r42, 0.0873F, 0.5236F, 0.0F);
		cube_r42.setTextureOffset(473, 512).addBox(-0.5F, -2.7F, 21.3F, 1.0F, 2.0F, 12.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(0.0F, 0.0F, 0.0F);
		monitor_circle.addChild(bone3);
		setRotationAngle(bone3, 0.0F, 1.0472F, 0.0F);
		

		cube_r43 = new ModelRenderer(this);
		cube_r43.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone3.addChild(cube_r43);
		setRotationAngle(cube_r43, 0.0873F, 0.5236F, 0.0F);
		cube_r43.setTextureOffset(447, 512).addBox(-0.5F, -2.7F, 21.3F, 1.0F, 2.0F, 12.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(0.0F, 0.0F, 0.0F);
		monitor_circle.addChild(bone4);
		setRotationAngle(bone4, 0.0F, 2.0944F, 0.0F);
		

		cube_r44 = new ModelRenderer(this);
		cube_r44.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone4.addChild(cube_r44);
		setRotationAngle(cube_r44, 0.0873F, 0.5236F, 0.0F);
		cube_r44.setTextureOffset(332, 512).addBox(-0.5F, -2.7F, 21.3F, 1.0F, 2.0F, 12.0F, 0.0F, false);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(0.0F, 0.0F, 0.0F);
		monitor_circle.addChild(bone5);
		setRotationAngle(bone5, 0.0F, -1.0472F, 0.0F);
		

		cube_r45 = new ModelRenderer(this);
		cube_r45.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone5.addChild(cube_r45);
		setRotationAngle(cube_r45, 0.0873F, 0.5236F, 0.0F);
		cube_r45.setTextureOffset(306, 512).addBox(-0.5F, -2.7F, 21.3F, 1.0F, 2.0F, 12.0F, 0.0F, false);

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(0.0F, 0.0F, 0.0F);
		monitor_circle.addChild(bone6);
		setRotationAngle(bone6, 0.0F, -2.0944F, 0.0F);
		

		cube_r46 = new ModelRenderer(this);
		cube_r46.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone6.addChild(cube_r46);
		setRotationAngle(cube_r46, 0.0873F, 0.5236F, 0.0F);
		cube_r46.setTextureOffset(104, 510).addBox(-0.5F, -2.7F, 21.3F, 1.0F, 2.0F, 12.0F, 0.0F, false);

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(0.0F, 0.0F, 0.0F);
		monitor_circle.addChild(bone7);
		setRotationAngle(bone7, 0.0F, 3.1416F, 0.0F);
		

		cube_r47 = new ModelRenderer(this);
		cube_r47.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone7.addChild(cube_r47);
		setRotationAngle(cube_r47, 0.0873F, 0.5236F, 0.0F);
		cube_r47.setTextureOffset(471, 493).addBox(-0.5F, -2.7F, 21.3F, 1.0F, 2.0F, 12.0F, 0.0F, false);

		bone8 = new ModelRenderer(this);
		bone8.setRotationPoint(0.0F, -1.8F, 0.0F);
		monitor_circle.addChild(bone8);
		bone8.setTextureOffset(497, 377).addBox(-10.0F, -6.0F, 23.1421F, 20.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r48 = new ModelRenderer(this);
		cube_r48.setRotationPoint(0.1005F, 0.0F, 0.1005F);
		bone8.addChild(cube_r48);
		setRotationAngle(cube_r48, 0.0F, 0.7854F, 0.0F);
		cube_r48.setTextureOffset(494, 304).addBox(-10.0F, -6.0F, 23.0F, 20.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r49 = new ModelRenderer(this);
		cube_r49.setRotationPoint(0.1421F, 0.0F, 0.0F);
		bone8.addChild(cube_r49);
		setRotationAngle(cube_r49, 0.0F, 1.5708F, 0.0F);
		cube_r49.setTextureOffset(494, 308).addBox(-10.0F, -6.0F, 23.0F, 20.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r50 = new ModelRenderer(this);
		cube_r50.setRotationPoint(0.1005F, 0.0F, -0.1005F);
		bone8.addChild(cube_r50);
		setRotationAngle(cube_r50, 0.0F, 2.3562F, 0.0F);
		cube_r50.setTextureOffset(494, 312).addBox(-10.0F, -6.0F, 23.0F, 20.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r51 = new ModelRenderer(this);
		cube_r51.setRotationPoint(0.0F, 0.0F, -0.1421F);
		bone8.addChild(cube_r51);
		setRotationAngle(cube_r51, 0.0F, 3.1416F, 0.0F);
		cube_r51.setTextureOffset(495, 343).addBox(-10.0F, -6.0F, 23.0F, 20.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r52 = new ModelRenderer(this);
		cube_r52.setRotationPoint(-0.1005F, 0.0F, -0.1005F);
		bone8.addChild(cube_r52);
		setRotationAngle(cube_r52, 0.0F, -2.3562F, 0.0F);
		cube_r52.setTextureOffset(495, 415).addBox(-10.0F, -6.0F, 23.0F, 20.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r53 = new ModelRenderer(this);
		cube_r53.setRotationPoint(-0.1421F, 0.0F, 0.0F);
		bone8.addChild(cube_r53);
		setRotationAngle(cube_r53, 0.0F, -1.5708F, 0.0F);
		cube_r53.setTextureOffset(495, 419).addBox(-10.0F, -6.0F, 23.0F, 20.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r54 = new ModelRenderer(this);
		cube_r54.setRotationPoint(-0.1005F, 0.0F, 0.1005F);
		bone8.addChild(cube_r54);
		setRotationAngle(cube_r54, 0.0F, -0.7854F, 0.0F);
		cube_r54.setTextureOffset(497, 373).addBox(-10.0F, -6.0F, 23.0F, 20.0F, 3.0F, 1.0F, 0.0F, false);

		monitor = new ModelRenderer(this);
		monitor.setRotationPoint(24.1421F, -6.0F, 10.0F);
		bone8.addChild(monitor);
		setRotationAngle(monitor, 0.0F, 0.7854F, 0.0F);
		monitor.setTextureOffset(165, 21).addBox(-12.0F, 0.0F, 0.0F, 4.0F, 2.0F, 1.0F, 0.0F, false);
		monitor.setTextureOffset(186, 13).addBox(-12.0F, -9.0F, -1.0F, 4.0F, 9.0F, 2.0F, 0.0F, false);

		cube_r55 = new ModelRenderer(this);
		cube_r55.setRotationPoint(-10.0F, -10.7362F, 7.5175F);
		monitor.addChild(cube_r55);
		setRotationAngle(cube_r55, -1.5708F, 0.0F, 0.0F);
		cube_r55.setTextureOffset(494, 239).addBox(-10.0F, -3.0F, -15.0F, 19.0F, 2.0F, 2.0F, 0.0F, false);
		cube_r55.setTextureOffset(391, 348).addBox(-11.0F, -3.0F, -13.0F, 2.0F, 1.0F, 12.0F, 0.0F, false);
		cube_r55.setTextureOffset(505, 149).addBox(8.0F, -3.0F, -13.0F, 2.0F, 1.0F, 12.0F, 0.0F, false);
		cube_r55.setTextureOffset(174, 276).addBox(-14.0F, -3.0F, -7.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r55.setTextureOffset(174, 273).addBox(12.0F, -3.0F, -7.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r55.setTextureOffset(165, 150).addBox(12.0F, -3.0F, -5.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r55.setTextureOffset(0, 175).addBox(-15.0F, -3.0F, -5.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r55.setTextureOffset(8, 224).addBox(10.0F, -3.0F, -11.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r55.setTextureOffset(8, 221).addBox(-12.0F, -3.0F, -11.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r55.setTextureOffset(165, 78).addBox(-13.0F, -3.0F, -9.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
		cube_r55.setTextureOffset(165, 102).addBox(10.0F, -3.0F, -9.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
		cube_r55.setTextureOffset(487, 28).addBox(-10.0F, -3.0F, -1.0F, 20.0F, 2.0F, 2.0F, 0.0F, false);
		cube_r55.setTextureOffset(408, 258).addBox(-2.0F, -1.0F, -1.0F, 4.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r55.setTextureOffset(449, 53).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r56 = new ModelRenderer(this);
		cube_r56.setRotationPoint(1.2961F, -8.4981F, 7.7427F);
		monitor.addChild(cube_r56);
		setRotationAngle(cube_r56, -1.9003F, 0.1172F, 0.3295F);
		cube_r56.setTextureOffset(136, 322).addBox(0.0F, -7.5F, -1.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		cube_r56.setTextureOffset(166, 207).addBox(-6.0F, -8.5F, -1.0F, 6.0F, 6.0F, 1.0F, 0.0F, false);

		cube_r57 = new ModelRenderer(this);
		cube_r57.setRotationPoint(-21.2961F, -8.4981F, 7.7427F);
		monitor.addChild(cube_r57);
		setRotationAngle(cube_r57, -1.9003F, -0.1172F, -0.3295F);
		cube_r57.setTextureOffset(165, 35).addBox(-1.0F, -7.5F, -1.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		cube_r57.setTextureOffset(0, 206).addBox(0.0F, -8.5F, -1.0F, 6.0F, 6.0F, 1.0F, 0.0F, false);

		cube_r58 = new ModelRenderer(this);
		cube_r58.setRotationPoint(-10.0F, -11.1385F, 9.2358F);
		monitor.addChild(cube_r58);
		setRotationAngle(cube_r58, -1.9199F, 0.0F, 0.0F);
		cube_r58.setTextureOffset(303, 437).addBox(-2.0F, -6.0F, -1.4F, 4.0F, 4.0F, 2.0F, 0.0F, false);
		cube_r58.setTextureOffset(0, 203).addBox(-3.0F, -7.0F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r58.setTextureOffset(450, 89).addBox(-4.0F, -6.0F, 0.0F, 8.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r58.setTextureOffset(316, 132).addBox(-6.0F, -4.0F, 0.0F, 12.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r59 = new ModelRenderer(this);
		cube_r59.setRotationPoint(-10.0F, -9.7704F, 4.0405F);
		monitor.addChild(cube_r59);
		setRotationAngle(cube_r59, -1.2217F, 0.0F, 0.0F);
		cube_r59.setTextureOffset(20, 34).addBox(-2.0F, -3.0F, -1.0F, 4.0F, 8.0F, 2.0F, 0.0F, false);

		screen = new ModelRenderer(this);
		screen.setRotationPoint(-10.5F, -17.7362F, 9.0175F);
		monitor.addChild(screen);
		

		cube_r60 = new ModelRenderer(this);
		cube_r60.setRotationPoint(0.5F, 7.0F, -1.5F);
		screen.addChild(cube_r60);
		setRotationAngle(cube_r60, -1.5708F, 0.0F, 0.0F);
		cube_r60.setTextureOffset(269, 429).addBox(-11.0F, -2.0F, -13.0F, 21.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r60.setTextureOffset(301, 96).addBox(-12.0F, -2.0F, -11.0F, 23.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r60.setTextureOffset(450, 49).addBox(-14.0F, -2.0F, -7.0F, 27.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r60.setTextureOffset(481, 475).addBox(-13.0F, -2.0F, -9.0F, 25.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r60.setTextureOffset(150, 371).addBox(-15.0F, -2.0F, -5.0F, 29.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r60.setTextureOffset(481, 478).addBox(-13.0F, -2.0F, -3.0F, 25.0F, 1.0F, 2.0F, 0.0F, false);

		side1 = new ModelRenderer(this);
		side1.setRotationPoint(0.0F, -25.8315F, 0.0F);
		root.addChild(side1);
		side1.setTextureOffset(332, 210).addBox(-32.0F, -3.8824F, 53.6609F, 64.0F, 7.0F, 1.0F, 0.0F, false);
		side1.setTextureOffset(450, 53).addBox(-4.0F, -7.1685F, 25.9808F, 19.0F, 7.0F, 11.0F, 0.0F, false);

		cube_r61 = new ModelRenderer(this);
		cube_r61.setRotationPoint(31.3391F, -4.5746F, 54.281F);
		side1.addChild(cube_r61);
		setRotationAngle(cube_r61, 0.0F, 0.5236F, 0.0F);
		cube_r61.setTextureOffset(172, 179).addBox(-1.0F, -0.5F, -1.5F, 2.0F, 5.0F, 1.0F, 0.0F, false);

		cube_r62 = new ModelRenderer(this);
		cube_r62.setRotationPoint(36.0358F, -1.5446F, 62.4159F);
		side1.addChild(cube_r62);
		setRotationAngle(cube_r62, -0.3142F, 0.5236F, 0.0F);
		cube_r62.setTextureOffset(136, 279).addBox(-1.0F, -0.3F, -10.5F, 2.0F, 1.0F, 16.0F, 0.0F, false);

		cube_r63 = new ModelRenderer(this);
		cube_r63.setRotationPoint(-30.5F, -2.7531F, 59.1029F);
		side1.addChild(cube_r63);
		setRotationAngle(cube_r63, -0.3491F, 0.0F, 0.0F);
		cube_r63.setTextureOffset(248, 245).addBox(-0.5F, -0.6F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r64 = new ModelRenderer(this);
		cube_r64.setRotationPoint(-30.5F, -2.7531F, 59.1029F);
		side1.addChild(cube_r64);
		setRotationAngle(cube_r64, -0.4754F, 0.7268F, -0.3295F);
		cube_r64.setTextureOffset(177, 107).addBox(-1.0F, -0.4F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r65 = new ModelRenderer(this);
		cube_r65.setRotationPoint(-18.5F, -8.6013F, 54.6175F);
		side1.addChild(cube_r65);
		setRotationAngle(cube_r65, -0.8845F, 0.1396F, -0.1682F);
		cube_r65.setTextureOffset(165, 84).addBox(-1.5F, -2.4F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r65.setTextureOffset(165, 91).addBox(-1.5F, -3.4F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r65.setTextureOffset(165, 96).addBox(-0.5F, -1.4F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r66 = new ModelRenderer(this);
		cube_r66.setRotationPoint(-34.5F, -7.1819F, 51.3702F);
		side1.addChild(cube_r66);
		setRotationAngle(cube_r66, -0.8727F, 0.0F, 0.0F);
		cube_r66.setTextureOffset(180, 35).addBox(51.5F, -10.3F, 0.5F, 1.0F, 4.0F, 1.0F, -0.2F, false);
		cube_r66.setTextureOffset(0, 124).addBox(51.0F, -6.5F, 0.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
		cube_r66.setTextureOffset(76, 400).addBox(49.5F, -2.5F, -1.5F, 5.0F, 16.0F, 5.0F, 0.0F, false);
		cube_r66.setTextureOffset(330, 7).addBox(14.0F, -4.5F, -1.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
		cube_r66.setTextureOffset(165, 0).addBox(18.5F, -1.5F, 3.5F, 31.0F, 1.0F, 0.0F, 0.0F, false);
		cube_r66.setTextureOffset(198, 101).addBox(18.5F, -1.5F, -1.5F, 31.0F, 1.0F, 0.0F, 0.0F, false);
		cube_r66.setTextureOffset(165, 35).addBox(13.5F, -1.5F, -1.5F, 5.0F, 15.0F, 5.0F, 0.0F, false);

		cube_r67 = new ModelRenderer(this);
		cube_r67.setRotationPoint(0.0F, 0.0F, 0.0F);
		side1.addChild(cube_r67);
		setRotationAngle(cube_r67, -0.3491F, 0.0F, 0.0F);
		cube_r67.setTextureOffset(0, 221).addBox(-38.0F, -23.0014F, 49.0969F, 76.0F, 1.0F, 14.0F, 0.0F, false);

		tank = new ModelRenderer(this);
		tank.setRotationPoint(-3.0F, 0.0F, 43.0F);
		side1.addChild(tank);
		

		cube_r68 = new ModelRenderer(this);
		cube_r68.setRotationPoint(-20.0F, -0.0309F, -0.0314F);
		tank.addChild(cube_r68);
		setRotationAngle(cube_r68, -1.5708F, 0.0F, 0.0F);
		cube_r68.setTextureOffset(377, 513).addBox(9.0F, -3.5F, -3.5F, 2.0F, 22.0F, 3.0F, 0.0F, false);
		cube_r68.setTextureOffset(130, 514).addBox(29.0F, -3.5F, -3.5F, 2.0F, 22.0F, 3.0F, 0.0F, false);

		cube_r69 = new ModelRenderer(this);
		cube_r69.setRotationPoint(0.0F, -6.9309F, 0.5686F);
		tank.addChild(cube_r69);
		setRotationAngle(cube_r69, -0.7854F, 0.0F, 0.0F);
		cube_r69.setTextureOffset(450, 83).addBox(-2.5F, -5.5F, -2.5F, 5.0F, 1.0F, 5.0F, 0.0F, false);
		cube_r69.setTextureOffset(333, 437).addBox(-11.0F, -4.5F, -4.5F, 22.0F, 9.0F, 9.0F, 0.0F, false);

		cube_r70 = new ModelRenderer(this);
		cube_r70.setRotationPoint(12.0F, -6.9309F, 0.5686F);
		tank.addChild(cube_r70);
		setRotationAngle(cube_r70, -1.5708F, 0.0F, 0.0F);
		cube_r70.setTextureOffset(20, 102).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 4.0F, 4.0F, 0.0F, false);

		tank_lights = new ModelRenderer(this);
		tank_lights.setRotationPoint(0.0F, -6.9309F, 0.5686F);
		tank.addChild(tank_lights);
		

		cube_r71 = new ModelRenderer(this);
		cube_r71.setRotationPoint(0.0F, 0.0F, 0.0F);
		tank_lights.addChild(cube_r71);
		setRotationAngle(cube_r71, -0.7854F, 0.0F, 0.0F);
		cube_r71.setTextureOffset(136, 236).addBox(-6.0F, -4.5F, -4.5F, 12.0F, 9.0F, 9.0F, 0.0F, false);

		tank_lever = new ModelRenderer(this);
		tank_lever.setRotationPoint(13.0F, -6.9309F, 0.5686F);
		tank.addChild(tank_lever);
		tank_lever.setTextureOffset(288, 337).addBox(0.0F, -1.5F, -1.5F, 2.0F, 3.0F, 3.0F, 0.0F, false);
		tank_lever.setTextureOffset(189, 1).addBox(0.0F, -11.5F, -1.0F, 2.0F, 10.0F, 2.0F, 0.0F, false);
		tank_lever.setTextureOffset(177, 83).addBox(0.0F, -11.8F, -1.0F, 2.0F, 1.0F, 2.0F, -0.1F, false);

		tank_switch = new ModelRenderer(this);
		tank_switch.setRotationPoint(0.0F, -10.82F, 4.4577F);
		tank.addChild(tank_switch);
		setRotationAngle(tank_switch, -0.7854F, 0.0F, 0.0F);
		tank_switch.setTextureOffset(202, 439).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		tank_switch.setTextureOffset(412, 261).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		microscope = new ModelRenderer(this);
		microscope.setRotationPoint(28.0F, 0.0F, 45.0F);
		side1.addChild(microscope);
		microscope.setTextureOffset(512, 264).addBox(-3.0F, -4.0F, -10.0F, 4.0F, 4.0F, 9.0F, 0.0F, false);
		microscope.setTextureOffset(29, 442).addBox(-13.0F, -4.0F, -14.0F, 14.0F, 4.0F, 4.0F, 0.0F, false);

		cube_r72 = new ModelRenderer(this);
		cube_r72.setRotationPoint(-1.0F, -6.3071F, 0.3526F);
		microscope.addChild(cube_r72);
		setRotationAngle(cube_r72, 0.3491F, 0.0F, 0.0F);
		cube_r72.setTextureOffset(191, 167).addBox(-1.0F, 1.5F, 6.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r72.setTextureOffset(118, 441).addBox(-4.0F, 1.5F, 6.5F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		cube_r72.setTextureOffset(467, 312).addBox(1.0F, 1.5F, 6.5F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		cube_r72.setTextureOffset(409, 233).addBox(-3.0F, -2.5F, 6.5F, 6.0F, 1.0F, 3.0F, 0.0F, false);
		cube_r72.setTextureOffset(0, 136).addBox(-4.0F, -2.5F, 6.5F, 1.0F, 4.0F, 4.0F, 0.0F, false);
		cube_r72.setTextureOffset(165, 13).addBox(3.0F, -2.5F, 6.5F, 1.0F, 4.0F, 4.0F, 0.0F, false);
		cube_r72.setTextureOffset(333, 404).addBox(-4.0F, -2.5F, 4.5F, 8.0F, 5.0F, 2.0F, 0.0F, false);
		cube_r72.setTextureOffset(0, 213).addBox(-2.0F, -2.0F, 1.5F, 4.0F, 4.0F, 3.0F, 0.0F, false);

		cube_r73 = new ModelRenderer(this);
		cube_r73.setRotationPoint(-1.0F, -0.1365F, -3.4963F);
		microscope.addChild(cube_r73);
		setRotationAngle(cube_r73, 0.8727F, 0.0F, 0.0F);
		cube_r73.setTextureOffset(156, 296).addBox(-2.0F, -2.0F, 1.5F, 4.0F, 4.0F, 8.0F, 0.0F, false);

		microscope_glasses = new ModelRenderer(this);
		microscope_glasses.setRotationPoint(-1.0F, -6.3071F, 0.3526F);
		microscope.addChild(microscope_glasses);
		

		cube_r74 = new ModelRenderer(this);
		cube_r74.setRotationPoint(0.0F, 0.0F, 0.0F);
		microscope_glasses.addChild(cube_r74);
		setRotationAngle(cube_r74, 0.3491F, 0.0F, 0.0F);
		cube_r74.setTextureOffset(381, 455).addBox(-2.5F, -1.0F, 5.5F, 5.0F, 2.0F, 1.0F, 0.0F, false);

		controls1 = new ModelRenderer(this);
		controls1.setRotationPoint(0.0F, 0.0F, 64.0F);
		side1.addChild(controls1);
		

		rotary_switches_group_1 = new ModelRenderer(this);
		rotary_switches_group_1.setRotationPoint(27.0F, -1.4019F, -0.6001F);
		controls1.addChild(rotary_switches_group_1);
		setRotationAngle(rotary_switches_group_1, -0.3491F, 0.0F, 0.0F);
		rotary_switches_group_1.setTextureOffset(58, 357).addBox(-14.0F, -0.3F, -7.5F, 17.0F, 2.0F, 7.0F, 0.0F, false);
		rotary_switches_group_1.setTextureOffset(86, 488).addBox(-14.0F, -0.3F, -0.3F, 17.0F, 2.0F, 2.0F, 0.0F, false);
		rotary_switches_group_1.setTextureOffset(379, 478).addBox(-13.0F, -1.3F, -6.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		rotary_switches_group_1.setTextureOffset(298, 479).addBox(-9.0F, -1.3F, -6.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		rotary_switches_group_1.setTextureOffset(479, 327).addBox(-5.0F, -1.3F, -6.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		rotary_switches_group_1.setTextureOffset(388, 479).addBox(-1.0F, -1.3F, -6.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);

		lights_group = new ModelRenderer(this);
		lights_group.setRotationPoint(0.0F, 0.0F, 0.0F);
		rotary_switches_group_1.addChild(lights_group);
		lights_group.setTextureOffset(337, 138).addBox(-2.0F, -0.8F, -7.3F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		lights_group.setTextureOffset(337, 138).addBox(-6.0F, -0.8F, -7.3F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		lights_group.setTextureOffset(337, 138).addBox(-10.0F, -0.8F, -7.3F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		lights_group.setTextureOffset(310, 358).addBox(1.0F, -1.3F, 0.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		lights_group.setTextureOffset(18, 359).addBox(-1.0F, -1.3F, 0.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		lights_group.setTextureOffset(310, 358).addBox(-3.0F, -1.3F, 0.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		lights_group.setTextureOffset(18, 359).addBox(-5.0F, -1.3F, 0.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		lights_group.setTextureOffset(18, 359).addBox(-7.0F, -1.3F, 0.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		lights_group.setTextureOffset(310, 358).addBox(-9.0F, -1.3F, 0.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		lights_group.setTextureOffset(18, 359).addBox(-11.0F, -1.3F, 0.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		lights_group.setTextureOffset(310, 358).addBox(-13.0F, -1.3F, 0.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		button_group1 = new ModelRenderer(this);
		button_group1.setRotationPoint(10.5F, -1.4019F, -0.6001F);
		controls1.addChild(button_group1);
		setRotationAngle(button_group1, -0.3491F, 0.0F, 0.0F);
		button_group1.setTextureOffset(306, 364).addBox(-4.0F, -0.6F, 0.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		button_group1.setTextureOffset(126, 427).addBox(-4.5F, -0.6F, -1.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		button_group1.setTextureOffset(112, 427).addBox(-5.0F, -0.6F, -2.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		button_group1.setTextureOffset(450, 71).addBox(-4.5F, -0.6F, -3.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		button_group1.setTextureOffset(248, 324).addBox(-3.0F, -0.6F, -4.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		button_group1.setTextureOffset(450, 104).addBox(-4.5F, -0.3F, 0.5F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		button_group1.setTextureOffset(363, 455).addBox(-5.0F, -0.3F, -1.5F, 7.0F, 1.0F, 2.0F, 0.0F, false);
		button_group1.setTextureOffset(462, 214).addBox(-5.5F, -0.3F, -2.5F, 7.0F, 1.0F, 2.0F, 0.0F, false);
		button_group1.setTextureOffset(337, 49).addBox(-5.0F, -0.3F, -3.5F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		button_group1.setTextureOffset(187, 432).addBox(-3.5F, -0.3F, -4.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		button_group2 = new ModelRenderer(this);
		button_group2.setRotationPoint(2.5F, -1.4019F, -0.6001F);
		controls1.addChild(button_group2);
		setRotationAngle(button_group2, -0.3491F, 0.0F, 0.0F);
		button_group2.setTextureOffset(156, 279).addBox(-3.0F, -0.6F, -2.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		button_group2.setTextureOffset(169, 243).addBox(-4.0F, -0.6F, -6.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		button_group2.setTextureOffset(302, 381).addBox(-5.5F, -0.6F, -5.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		button_group2.setTextureOffset(377, 331).addBox(-5.0F, -0.6F, -4.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		button_group2.setTextureOffset(408, 251).addBox(-4.5F, -0.6F, -3.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		button_group2.setTextureOffset(410, 270).addBox(-3.5F, -0.3F, -1.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		button_group2.setTextureOffset(332, 207).addBox(-5.0F, -0.3F, -2.5F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		button_group2.setTextureOffset(400, 283).addBox(-5.5F, -0.3F, -4.5F, 7.0F, 1.0F, 2.0F, 0.0F, false);
		button_group2.setTextureOffset(453, 120).addBox(-6.0F, -0.3F, -5.5F, 7.0F, 1.0F, 2.0F, 0.0F, false);
		button_group2.setTextureOffset(387, 312).addBox(-4.5F, -0.3F, -6.5F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		controller = new ModelRenderer(this);
		controller.setRotationPoint(-6.8646F, -2.8465F, -6.908F);
		controls1.addChild(controller);
		

		cube_r75 = new ModelRenderer(this);
		cube_r75.setRotationPoint(0.0F, 0.0F, 0.0F);
		controller.addChild(cube_r75);
		setRotationAngle(cube_r75, -0.711F, -1.0191F, 0.6328F);
		cube_r75.setTextureOffset(462, 254).addBox(0.0F, -1.0F, -1.0F, 7.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r76 = new ModelRenderer(this);
		cube_r76.setRotationPoint(-3.2707F, 0.0F, 0.0F);
		controller.addChild(cube_r76);
		setRotationAngle(cube_r76, -0.711F, 1.0191F, -0.6328F);
		cube_r76.setTextureOffset(467, 108).addBox(-7.0F, -1.0F, -1.0F, 7.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r77 = new ModelRenderer(this);
		cube_r77.setRotationPoint(42.9063F, 1.3268F, 5.9845F);
		controller.addChild(cube_r77);
		setRotationAngle(cube_r77, -0.3491F, 0.0F, 0.0F);
		cube_r77.setTextureOffset(337, 102).addBox(-46.0F, -0.2F, -2.5F, 5.0F, 1.0F, 3.0F, 0.0F, false);

		cube_r78 = new ModelRenderer(this);
		cube_r78.setRotationPoint(40.823F, 1.3268F, 5.9845F);
		controller.addChild(cube_r78);
		setRotationAngle(cube_r78, -0.3491F, 0.0F, 0.0F);
		cube_r78.setTextureOffset(459, 128).addBox(-46.0F, -0.2F, -2.5F, 5.0F, 1.0F, 3.0F, 0.0F, false);

		cube_r79 = new ModelRenderer(this);
		cube_r79.setRotationPoint(40.823F, 1.6689F, 6.9242F);
		controller.addChild(cube_r79);
		setRotationAngle(cube_r79, -0.3491F, 0.0F, 0.0F);
		cube_r79.setTextureOffset(407, 354).addBox(-45.0F, -0.2F, -7.5F, 3.0F, 1.0F, 4.0F, 0.0F, false);

		cube_r80 = new ModelRenderer(this);
		cube_r80.setRotationPoint(42.9063F, 1.6689F, 6.9242F);
		controller.addChild(cube_r80);
		setRotationAngle(cube_r80, -0.3491F, 0.0F, 0.0F);
		cube_r80.setTextureOffset(303, 432).addBox(-45.0F, -0.2F, -7.5F, 3.0F, 1.0F, 4.0F, 0.0F, false);

		cube_r81 = new ModelRenderer(this);
		cube_r81.setRotationPoint(-1.6354F, 1.2566F, 6.3763F);
		controller.addChild(cube_r81);
		setRotationAngle(cube_r81, -0.3491F, 0.0F, 0.0F);
		cube_r81.setTextureOffset(177, 78).addBox(-4.5F, -1.5F, -1.8F, 2.0F, 3.0F, 2.0F, -0.25F, false);
		cube_r81.setTextureOffset(136, 313).addBox(2.5F, -1.5F, -1.8F, 2.0F, 2.0F, 2.0F, -0.25F, false);

		cube_r82 = new ModelRenderer(this);
		cube_r82.setRotationPoint(45.8646F, 0.7605F, 4.4285F);
		controller.addChild(cube_r82);
		setRotationAngle(cube_r82, -0.3491F, 0.0F, 0.0F);
		cube_r82.setTextureOffset(156, 293).addBox(-53.0F, -0.2F, 1.5F, 11.0F, 1.0F, 1.0F, 0.0F, false);

		joystic = new ModelRenderer(this);
		joystic.setRotationPoint(-1.6354F, 0.1656F, 3.2216F);
		controller.addChild(joystic);
		setRotationAngle(joystic, -0.3491F, 0.0F, 0.0F);
		joystic.setTextureOffset(0, 221).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 5.0F, 1.0F, -0.35F, false);
		joystic.setTextureOffset(314, 337).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 1.0F, 1.0F, -0.05F, false);

		button_group3 = new ModelRenderer(this);
		button_group3.setRotationPoint(-15.5F, -1.4019F, -0.6001F);
		controls1.addChild(button_group3);
		setRotationAngle(button_group3, -0.3491F, 0.0F, 0.0F);
		button_group3.setTextureOffset(166, 196).addBox(-3.0F, -0.6F, -2.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		button_group3.setTextureOffset(408, 243).addBox(-4.5F, -0.6F, -3.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		button_group3.setTextureOffset(361, 331).addBox(-5.0F, -0.6F, -4.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		button_group3.setTextureOffset(0, 438).addBox(-4.5F, -0.6F, -5.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		button_group3.setTextureOffset(0, 144).addBox(-4.0F, -0.6F, -6.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		button_group3.setTextureOffset(0, 130).addBox(-3.5F, -0.3F, -1.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		button_group3.setTextureOffset(0, 201).addBox(-5.0F, -0.3F, -2.5F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		button_group3.setTextureOffset(329, 93).addBox(-5.0F, -0.3F, -5.5F, 7.0F, 1.0F, 2.0F, 0.0F, false);
		button_group3.setTextureOffset(58, 378).addBox(-5.5F, -0.3F, -4.5F, 7.0F, 1.0F, 2.0F, 0.0F, false);
		button_group3.setTextureOffset(20, 76).addBox(-4.5F, -0.3F, -6.5F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		button_group4 = new ModelRenderer(this);
		button_group4.setRotationPoint(-23.5F, -1.4019F, -0.6001F);
		controls1.addChild(button_group4);
		setRotationAngle(button_group4, -0.3491F, 0.0F, 0.0F);
		button_group4.setTextureOffset(170, 319).addBox(-4.0F, -0.6F, 0.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		button_group4.setTextureOffset(253, 426).addBox(-4.5F, -0.6F, -1.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		button_group4.setTextureOffset(68, 396).addBox(-5.0F, -0.6F, -2.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		button_group4.setTextureOffset(439, 121).addBox(-4.5F, -0.6F, -3.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		button_group4.setTextureOffset(174, 279).addBox(-3.0F, -0.6F, -4.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		button_group4.setTextureOffset(20, 110).addBox(-4.5F, -0.3F, 0.5F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		button_group4.setTextureOffset(451, 434).addBox(-5.0F, -0.3F, -1.5F, 7.0F, 1.0F, 2.0F, 0.0F, false);
		button_group4.setTextureOffset(105, 453).addBox(-5.5F, -0.3F, -2.5F, 7.0F, 1.0F, 2.0F, 0.0F, false);
		button_group4.setTextureOffset(330, 14).addBox(-5.0F, -0.3F, -3.5F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		button_group4.setTextureOffset(0, 396).addBox(-3.5F, -0.3F, -4.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		side2 = new ModelRenderer(this);
		side2.setRotationPoint(0.0F, -25.8315F, 0.0F);
		root.addChild(side2);
		setRotationAngle(side2, 0.0F, -1.0472F, 0.0F);
		side2.setTextureOffset(337, 107).addBox(-32.0F, -3.8824F, 53.6609F, 64.0F, 7.0F, 1.0F, 0.0F, false);

		cube_r83 = new ModelRenderer(this);
		cube_r83.setRotationPoint(32.3391F, -4.5746F, 56.013F);
		side2.addChild(cube_r83);
		setRotationAngle(cube_r83, 0.0F, 0.5236F, 0.0F);
		cube_r83.setTextureOffset(11, 179).addBox(-1.0F, -0.5F, -3.5F, 2.0F, 5.0F, 1.0F, 0.0F, false);

		cube_r84 = new ModelRenderer(this);
		cube_r84.setRotationPoint(36.0358F, -1.5446F, 62.4159F);
		side2.addChild(cube_r84);
		setRotationAngle(cube_r84, -0.3142F, 0.5236F, 0.0F);
		cube_r84.setTextureOffset(118, 497).addBox(-1.0F, -0.3F, -10.5F, 2.0F, 1.0F, 16.0F, 0.0F, false);

		cube_r85 = new ModelRenderer(this);
		cube_r85.setRotationPoint(16.2937F, 0.0148F, 0.0407F);
		side2.addChild(cube_r85);
		setRotationAngle(cube_r85, -0.3491F, 0.0F, 0.0F);
		cube_r85.setTextureOffset(499, 58).addBox(-16.5F, -23.5014F, 35.0969F, 14.0F, 2.0F, 4.0F, 0.0F, false);

		cube_r86 = new ModelRenderer(this);
		cube_r86.setRotationPoint(0.7063F, 0.0148F, 0.0407F);
		side2.addChild(cube_r86);
		setRotationAngle(cube_r86, -0.3491F, 0.0F, 0.0F);
		cube_r86.setTextureOffset(500, 91).addBox(-14.5F, -23.5014F, 35.0969F, 14.0F, 2.0F, 4.0F, 0.0F, false);

		cube_r87 = new ModelRenderer(this);
		cube_r87.setRotationPoint(12.9108F, -9.435F, 41.3292F);
		side2.addChild(cube_r87);
		setRotationAngle(cube_r87, -0.6595F, -0.9786F, 0.5716F);
		cube_r87.setTextureOffset(277, 459).addBox(0.0F, -0.5F, -1.0F, 26.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r88 = new ModelRenderer(this);
		cube_r88.setRotationPoint(-12.9108F, -9.435F, 41.3292F);
		side2.addChild(cube_r88);
		setRotationAngle(cube_r88, -0.6595F, 0.9786F, -0.5716F);
		cube_r88.setTextureOffset(451, 161).addBox(-26.0F, -0.5F, -1.0F, 26.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r89 = new ModelRenderer(this);
		cube_r89.setRotationPoint(0.0F, 0.0F, 0.0F);
		side2.addChild(cube_r89);
		setRotationAngle(cube_r89, -0.3491F, 0.0F, 0.0F);
		cube_r89.setTextureOffset(150, 366).addBox(-15.5F, -23.5014F, 39.0969F, 31.0F, 2.0F, 3.0F, 0.0F, false);
		cube_r89.setTextureOffset(436, 149).addBox(-17.0F, -23.5014F, 42.0969F, 34.0F, 2.0F, 3.0F, 0.0F, false);
		cube_r89.setTextureOffset(409, 377).addBox(-19.0F, -23.5014F, 45.0969F, 38.0F, 2.0F, 4.0F, 0.0F, false);
		cube_r89.setTextureOffset(399, 296).addBox(-21.0F, -23.5014F, 49.0969F, 42.0F, 2.0F, 3.0F, 0.0F, false);
		cube_r89.setTextureOffset(358, 163).addBox(-22.5F, -23.5014F, 52.0969F, 45.0F, 2.0F, 3.0F, 0.0F, false);
		cube_r89.setTextureOffset(142, 450).addBox(-18.5F, -23.7014F, 54.0969F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		cube_r89.setTextureOffset(344, 171).addBox(-24.0F, -23.5014F, 55.0969F, 48.0F, 2.0F, 3.0F, 0.0F, false);
		cube_r89.setTextureOffset(165, 63).addBox(-26.0F, -23.5014F, 58.0969F, 52.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r89.setTextureOffset(166, 192).addBox(-38.0F, -23.0014F, 49.0969F, 76.0F, 1.0F, 14.0F, 0.0F, false);

		cube_r90 = new ModelRenderer(this);
		cube_r90.setRotationPoint(-16.5F, -8.6609F, 63.5017F);
		side2.addChild(cube_r90);
		setRotationAngle(cube_r90, -0.6109F, 0.0F, 0.0F);
		cube_r90.setTextureOffset(29, 21).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r90.setTextureOffset(177, 102).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r91 = new ModelRenderer(this);
		cube_r91.setRotationPoint(-17.0F, -8.9477F, 63.0921F);
		side2.addChild(cube_r91);
		setRotationAngle(cube_r91, -0.6109F, 0.0F, 0.0F);
		cube_r91.setTextureOffset(205, 361).addBox(-0.5F, -4.5F, -0.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r92 = new ModelRenderer(this);
		cube_r92.setRotationPoint(-16.5F, -5.435F, 61.6753F);
		side2.addChild(cube_r92);
		setRotationAngle(cube_r92, -0.3491F, 0.0F, 0.0F);
		cube_r92.setTextureOffset(165, 111).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		controls2 = new ModelRenderer(this);
		controls2.setRotationPoint(0.0F, 0.0F, 0.0F);
		side2.addChild(controls2);
		

		cube_r93 = new ModelRenderer(this);
		cube_r93.setRotationPoint(-23.5F, -1.9319F, 62.5286F);
		controls2.addChild(cube_r93);
		setRotationAngle(cube_r93, -0.4015F, -0.5052F, 0.2027F);
		cube_r93.setTextureOffset(437, 175).addBox(-1.5F, -0.5F, -7.6F, 3.0F, 1.0F, 9.0F, 0.0F, false);

		cube_r94 = new ModelRenderer(this);
		cube_r94.setRotationPoint(23.5F, -1.9319F, 62.5286F);
		controls2.addChild(cube_r94);
		setRotationAngle(cube_r94, -0.4015F, 0.5052F, -0.2027F);
		cube_r94.setTextureOffset(459, 17).addBox(-1.5F, -0.5F, -7.6F, 3.0F, 1.0F, 9.0F, 0.0F, false);

		cube_r95 = new ModelRenderer(this);
		cube_r95.setRotationPoint(0.0F, 0.0F, 0.0F);
		controls2.addChild(cube_r95);
		setRotationAngle(cube_r95, -0.3491F, 0.0F, 0.0F);
		cube_r95.setTextureOffset(248, 319).addBox(-11.5F, -24.0014F, 48.0969F, 1.0F, 1.0F, 7.0F, 0.0F, false);
		cube_r95.setTextureOffset(248, 327).addBox(10.5F, -24.0014F, 48.0969F, 1.0F, 1.0F, 7.0F, 0.0F, false);
		cube_r95.setTextureOffset(450, 115).addBox(-9.5F, -24.0014F, 48.0969F, 9.0F, 1.0F, 4.0F, 0.0F, false);
		cube_r95.setTextureOffset(291, 489).addBox(0.5F, -24.0014F, 48.0969F, 9.0F, 1.0F, 4.0F, 0.0F, false);
		cube_r95.setTextureOffset(304, 100).addBox(-11.5F, -24.5014F, 58.0969F, 23.0F, 1.0F, 1.0F, 0.0F, false);

		lights2 = new ModelRenderer(this);
		lights2.setRotationPoint(0.0F, 0.0F, 0.0F);
		controls2.addChild(lights2);
		

		lights2_group1 = new ModelRenderer(this);
		lights2_group1.setRotationPoint(0.0F, 0.0F, 0.0F);
		lights2.addChild(lights2_group1);
		

		cube_r96 = new ModelRenderer(this);
		cube_r96.setRotationPoint(0.0F, 0.0F, 0.0F);
		lights2_group1.addChild(cube_r96);
		setRotationAngle(cube_r96, -0.3491F, 0.0F, 0.0F);
		cube_r96.setTextureOffset(310, 358).addBox(-2.0F, -24.5014F, 54.0969F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r96.setTextureOffset(310, 358).addBox(-6.0F, -24.5014F, 54.0969F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r96.setTextureOffset(310, 358).addBox(-10.0F, -24.5014F, 54.0969F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r96.setTextureOffset(18, 359).addBox(1.0F, -24.5014F, 54.0969F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r96.setTextureOffset(18, 359).addBox(5.0F, -24.5014F, 54.0969F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r96.setTextureOffset(18, 359).addBox(7.0F, -24.5014F, 54.0969F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		lights2_group2 = new ModelRenderer(this);
		lights2_group2.setRotationPoint(0.0F, 0.0F, 0.0F);
		lights2.addChild(lights2_group2);
		

		cube_r97 = new ModelRenderer(this);
		cube_r97.setRotationPoint(0.0F, 0.0F, 0.0F);
		lights2_group2.addChild(cube_r97);
		setRotationAngle(cube_r97, -0.3491F, 0.0F, 0.0F);
		cube_r97.setTextureOffset(310, 358).addBox(-8.0F, -24.5014F, 54.0969F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r97.setTextureOffset(18, 359).addBox(9.0F, -24.5014F, 54.0969F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r97.setTextureOffset(18, 359).addBox(3.0F, -24.5014F, 54.0969F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r97.setTextureOffset(310, 358).addBox(-4.0F, -24.5014F, 54.0969F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		spinny_switch1 = new ModelRenderer(this);
		spinny_switch1.setRotationPoint(20.5F, -4.1118F, 58.0011F);
		controls2.addChild(spinny_switch1);
		setRotationAngle(spinny_switch1, -2.7437F, -0.4891F, 2.9466F);
		spinny_switch1.setTextureOffset(344, 181).addBox(-0.5F, -0.2F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		spinny_switch1.setTextureOffset(325, 157).addBox(-0.5F, -1.2F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		spinny_switch1.setTextureOffset(344, 178).addBox(-0.5F, -2.2F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		spinny_switch2 = new ModelRenderer(this);
		spinny_switch2.setRotationPoint(23.5F, -2.4017F, 62.6996F);
		controls2.addChild(spinny_switch2);
		setRotationAngle(spinny_switch2, -0.3819F, -0.4084F, 0.1582F);
		spinny_switch2.setTextureOffset(347, 58).addBox(-0.5F, -0.2F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		spinny_switch2.setTextureOffset(205, 357).addBox(-0.5F, -1.2F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		spinny_switch2.setTextureOffset(176, 346).addBox(-0.5F, -2.2F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		spinny_switch3 = new ModelRenderer(this);
		spinny_switch3.setRotationPoint(-20.5F, -4.1118F, 58.0011F);
		controls2.addChild(spinny_switch3);
		setRotationAngle(spinny_switch3, -2.3813F, 1.0515F, -2.4514F);
		spinny_switch3.setTextureOffset(344, 183).addBox(-0.5F, -0.2F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		spinny_switch3.setTextureOffset(257, 327).addBox(-0.5F, -1.2F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		spinny_switch3.setTextureOffset(355, 53).addBox(-0.5F, -2.2F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		spinny_switch4 = new ModelRenderer(this);
		spinny_switch4.setRotationPoint(-23.5F, -2.4017F, 62.6996F);
		controls2.addChild(spinny_switch4);
		setRotationAngle(spinny_switch4, -2.5462F, -0.9149F, 2.6489F);
		spinny_switch4.setTextureOffset(347, 56).addBox(-0.5F, -0.2F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		spinny_switch4.setTextureOffset(99, 357).addBox(-0.5F, -1.2F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		spinny_switch4.setTextureOffset(345, 206).addBox(-0.5F, -2.2F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		communicator = new ModelRenderer(this);
		communicator.setRotationPoint(13.7937F, -10.0654F, 41.059F);
		controls2.addChild(communicator);
		

		cube_r98 = new ModelRenderer(this);
		cube_r98.setRotationPoint(11.2063F, 8.1937F, 22.5119F);
		communicator.addChild(cube_r98);
		setRotationAngle(cube_r98, -0.3491F, 0.0F, 0.0F);
		cube_r98.setTextureOffset(450, 98).addBox(-27.5F, -2.7F, -22.25F, 5.0F, 3.0F, 3.0F, 0.0F, false);
		cube_r98.setTextureOffset(136, 304).addBox(-26.5F, -2.7F, -23.15F, 3.0F, 3.0F, 5.0F, 0.0F, false);
		cube_r98.setTextureOffset(86, 480).addBox(-31.0F, -0.1F, -23.75F, 12.0F, 2.0F, 6.0F, 0.0F, false);
		cube_r98.setTextureOffset(298, 463).addBox(-31.0F, -0.4F, -17.5F, 12.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r99 = new ModelRenderer(this);
		cube_r99.setRotationPoint(-4.2937F, 1.6536F, 9.09F);
		communicator.addChild(cube_r99);
		setRotationAngle(cube_r99, -0.7289F, -0.2651F, 0.2298F);
		cube_r99.setTextureOffset(467, 327).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 2.0F, 3.0F, 0.0F, false);

		cube_r100 = new ModelRenderer(this);
		cube_r100.setRotationPoint(-23.2937F, 1.6536F, 9.09F);
		communicator.addChild(cube_r100);
		setRotationAngle(cube_r100, -0.7576F, 0.3615F, -0.3229F);
		cube_r100.setTextureOffset(408, 463).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 2.0F, 3.0F, 0.0F, false);

		cube_r101 = new ModelRenderer(this);
		cube_r101.setRotationPoint(-4.2937F, 0.4913F, 6.1491F);
		communicator.addChild(cube_r101);
		setRotationAngle(cube_r101, -0.6981F, 0.0F, 0.0F);
		cube_r101.setTextureOffset(393, 405).addBox(-21.5F, -1.0F, 0.5F, 5.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r101.setTextureOffset(139, 409).addBox(-2.5F, -1.0F, 0.5F, 5.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r102 = new ModelRenderer(this);
		cube_r102.setRotationPoint(-13.7937F, 3.1646F, 5.508F);
		communicator.addChild(cube_r102);
		setRotationAngle(cube_r102, -0.3491F, 0.0F, 0.0F);
		cube_r102.setTextureOffset(0, 90).addBox(-12.0F, -5.7F, -5.5F, 1.0F, 4.0F, 3.0F, 0.0F, false);
		cube_r102.setTextureOffset(24, 56).addBox(7.0F, -5.7F, -5.5F, 1.0F, 4.0F, 3.0F, 0.0F, false);
		cube_r102.setTextureOffset(407, 348).addBox(-11.0F, -4.7F, -6.5F, 3.0F, 2.0F, 4.0F, 0.0F, false);
		cube_r102.setTextureOffset(68, 390).addBox(8.0F, -4.7F, -6.5F, 3.0F, 2.0F, 4.0F, 0.0F, false);
		cube_r102.setTextureOffset(0, 56).addBox(11.0F, -5.7F, -5.5F, 1.0F, 4.0F, 3.0F, 0.0F, false);
		cube_r102.setTextureOffset(24, 22).addBox(-8.0F, -5.7F, -5.5F, 1.0F, 4.0F, 3.0F, 0.0F, false);
		cube_r102.setTextureOffset(150, 400).addBox(7.0F, -6.7F, -4.5F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r102.setTextureOffset(0, 393).addBox(-12.0F, -6.7F, -4.5F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r102.setTextureOffset(150, 403).addBox(-9.0F, -6.7F, -4.5F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r102.setTextureOffset(400, 276).addBox(10.0F, -6.7F, -4.5F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r103 = new ModelRenderer(this);
		cube_r103.setRotationPoint(-13.7937F, 2.6947F, 5.679F);
		communicator.addChild(cube_r103);
		setRotationAngle(cube_r103, -0.3491F, 0.0F, 0.0F);
		cube_r103.setTextureOffset(29, 450).addBox(-12.0F, -4.5F, -2.5F, 5.0F, 4.0F, 3.0F, 0.0F, false);
		cube_r103.setTextureOffset(0, 449).addBox(7.0F, -4.5F, -2.5F, 5.0F, 4.0F, 3.0F, 0.0F, false);

		cube_r104 = new ModelRenderer(this);
		cube_r104.setRotationPoint(-13.7937F, 2.3192F, 5.4948F);
		communicator.addChild(cube_r104);
		setRotationAngle(cube_r104, -0.3491F, 0.0F, 0.0F);
		cube_r104.setTextureOffset(202, 439).addBox(7.0F, -1.0F, -5.5F, 5.0F, 2.0F, 11.0F, 0.0F, false);
		cube_r104.setTextureOffset(165, 13).addBox(-12.0F, -1.0F, -5.5F, 5.0F, 2.0F, 11.0F, 0.0F, false);

		cube_r105 = new ModelRenderer(this);
		cube_r105.setRotationPoint(-29.7937F, 2.4657F, 9.6982F);
		communicator.addChild(cube_r105);
		setRotationAngle(cube_r105, -0.5152F, 0.8036F, -0.387F);
		cube_r105.setTextureOffset(136, 296).addBox(1.0F, 0.0F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r105.setTextureOffset(257, 319).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r106 = new ModelRenderer(this);
		cube_r106.setRotationPoint(2.2063F, 2.4657F, 9.6982F);
		communicator.addChild(cube_r106);
		setRotationAngle(cube_r106, -0.3646F, -0.2865F, 0.1074F);
		cube_r106.setTextureOffset(145, 296).addBox(-3.0F, 0.0F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r106.setTextureOffset(136, 317).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		lights_group2 = new ModelRenderer(this);
		lights_group2.setRotationPoint(-13.7937F, -0.015F, 7.8793F);
		communicator.addChild(lights_group2);
		

		cube_r107 = new ModelRenderer(this);
		cube_r107.setRotationPoint(0.0F, 0.0F, 0.0F);
		lights_group2.addChild(cube_r107);
		setRotationAngle(cube_r107, -0.6981F, 0.0F, 0.0F);
		cube_r107.setTextureOffset(337, 138).addBox(11.0F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r107.setTextureOffset(310, 358).addBox(7.0F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r107.setTextureOffset(310, 358).addBox(-8.0F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r107.setTextureOffset(337, 138).addBox(-12.0F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		communicator_lights1 = new ModelRenderer(this);
		communicator_lights1.setRotationPoint(11.2063F, 8.1937F, 22.5119F);
		communicator.addChild(communicator_lights1);
		

		cube_r108 = new ModelRenderer(this);
		cube_r108.setRotationPoint(0.0F, 0.0F, 0.0F);
		communicator_lights1.addChild(cube_r108);
		setRotationAngle(cube_r108, -0.3491F, 0.0F, 0.0F);
		cube_r108.setTextureOffset(349, 63).addBox(-23.25F, -0.9F, -17.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r108.setTextureOffset(348, 89).addBox(-24.75F, -0.9F, -17.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r108.setTextureOffset(333, 355).addBox(-29.25F, -0.9F, -17.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r108.setTextureOffset(58, 357).addBox(-30.75F, -0.9F, -17.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r108.setTextureOffset(351, 337).addBox(-20.25F, -0.9F, -17.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r108.setTextureOffset(349, 65).addBox(-24.75F, -0.9F, -15.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r108.setTextureOffset(351, 341).addBox(-20.25F, -0.9F, -14.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		communicator_lights2 = new ModelRenderer(this);
		communicator_lights2.setRotationPoint(11.2063F, 8.1937F, 22.5119F);
		communicator.addChild(communicator_lights2);
		

		cube_r109 = new ModelRenderer(this);
		cube_r109.setRotationPoint(0.0F, 0.0F, 0.0F);
		communicator_lights2.addChild(cube_r109);
		setRotationAngle(cube_r109, -0.3491F, 0.0F, 0.0F);
		cube_r109.setTextureOffset(349, 68).addBox(-23.25F, -0.9F, -15.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r109.setTextureOffset(349, 95).addBox(-23.25F, -0.9F, -14.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r109.setTextureOffset(333, 341).addBox(-21.75F, -0.9F, -15.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r109.setTextureOffset(350, 59).addBox(-27.75F, -0.9F, -15.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r109.setTextureOffset(350, 57).addBox(-27.75F, -0.9F, -17.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r109.setTextureOffset(165, 13).addBox(-26.25F, -0.9F, -17.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r109.setTextureOffset(350, 98).addBox(-27.75F, -0.9F, -14.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r109.setTextureOffset(353, 355).addBox(-29.25F, -0.9F, -15.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r109.setTextureOffset(353, 357).addBox(-30.75F, -0.9F, -14.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		communicator_lights3 = new ModelRenderer(this);
		communicator_lights3.setRotationPoint(13.7063F, 8.1937F, 22.5119F);
		communicator.addChild(communicator_lights3);
		

		cube_r110 = new ModelRenderer(this);
		cube_r110.setRotationPoint(0.0F, 0.0F, 0.0F);
		communicator_lights3.addChild(cube_r110);
		setRotationAngle(cube_r110, -0.3491F, 0.0F, 0.0F);
		cube_r110.setTextureOffset(333, 357).addBox(-33.25F, -0.9F, -15.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r110.setTextureOffset(0, 357).addBox(-31.75F, -0.9F, -14.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r110.setTextureOffset(342, 0).addBox(-24.25F, -0.9F, -14.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r110.setTextureOffset(349, 70).addBox(-27.25F, -0.9F, -14.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r110.setTextureOffset(29, 165).addBox(-28.75F, -0.9F, -14.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r110.setTextureOffset(351, 339).addBox(-22.75F, -0.9F, -15.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r110.setTextureOffset(165, 15).addBox(-28.75F, -0.9F, -15.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r110.setTextureOffset(176, 340).addBox(-24.25F, -0.9F, -17.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone16 = new ModelRenderer(this);
		bone16.setRotationPoint(-24.0F, -1.1F, 42.0F);
		side2.addChild(bone16);
		

		cube_r111 = new ModelRenderer(this);
		cube_r111.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone16.addChild(cube_r111);
		setRotationAngle(cube_r111, 0.0F, 1.0472F, 0.0F);
		cube_r111.setTextureOffset(165, 58).addBox(-3.5F, -10.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.2F, false);
		cube_r111.setTextureOffset(165, 89).addBox(-3.5F, -9.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r111.setTextureOffset(330, 0).addBox(-5.0F, -8.0F, -2.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
		cube_r111.setTextureOffset(0, 22).addBox(-7.0F, -5.0F, -4.0F, 8.0F, 3.0F, 8.0F, 0.0F, false);
		cube_r111.setTextureOffset(0, 56).addBox(-7.0F, -2.0F, -4.0F, 8.0F, 3.0F, 8.0F, 0.0F, false);
		cube_r111.setTextureOffset(153, 1).addBox(-9.0F, -2.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		side3 = new ModelRenderer(this);
		side3.setRotationPoint(0.0F, -25.8315F, 0.0F);
		root.addChild(side3);
		setRotationAngle(side3, 0.0F, -2.0944F, 0.0F);
		side3.setTextureOffset(330, 18).addBox(-32.0F, -3.8824F, 53.6609F, 64.0F, 7.0F, 1.0F, 0.0F, false);

		cube_r112 = new ModelRenderer(this);
		cube_r112.setRotationPoint(32.8391F, -4.5746F, 56.879F);
		side3.addChild(cube_r112);
		setRotationAngle(cube_r112, 0.0F, 0.5236F, 0.0F);
		cube_r112.setTextureOffset(0, 179).addBox(-1.0F, -0.5F, -4.5F, 2.0F, 5.0F, 1.0F, 0.0F, false);

		cube_r113 = new ModelRenderer(this);
		cube_r113.setRotationPoint(36.0358F, -1.5446F, 62.4159F);
		side3.addChild(cube_r113);
		setRotationAngle(cube_r113, -0.3142F, 0.5236F, 0.0F);
		cube_r113.setTextureOffset(228, 496).addBox(-1.0F, -0.3F, -10.5F, 2.0F, 1.0F, 16.0F, 0.0F, false);

		cube_r114 = new ModelRenderer(this);
		cube_r114.setRotationPoint(1.0F, -4.1042F, -11.2763F);
		side3.addChild(cube_r114);
		setRotationAngle(cube_r114, -0.3491F, 0.0F, 0.0F);
		cube_r114.setTextureOffset(166, 192).addBox(-39.0F, -23.0014F, 61.0969F, 76.0F, 1.0F, 14.0F, 0.0F, false);

		cube_r115 = new ModelRenderer(this);
		cube_r115.setRotationPoint(0.0F, 5.9858F, 64.5104F);
		side3.addChild(cube_r115);
		setRotationAngle(cube_r115, -0.2618F, 0.0F, 0.0F);
		cube_r115.setTextureOffset(399, 288).addBox(-21.0F, -6.5F, -15.0F, 42.0F, 1.0F, 4.0F, 0.0F, false);
		cube_r115.setTextureOffset(269, 63).addBox(-19.0F, -6.5F, -19.0F, 38.0F, 1.0F, 4.0F, 0.0F, false);
		cube_r115.setTextureOffset(436, 144).addBox(-17.0F, -6.5F, -23.0F, 34.0F, 1.0F, 4.0F, 0.0F, false);
		cube_r115.setTextureOffset(248, 306).addBox(-28.0F, -6.5F, -11.0F, 56.0F, 1.0F, 12.0F, 0.0F, false);

		controls3 = new ModelRenderer(this);
		controls3.setRotationPoint(0.0F, 5.9858F, 64.5104F);
		side3.addChild(controls3);
		

		cube_r116 = new ModelRenderer(this);
		cube_r116.setRotationPoint(-29.0F, -7.2444F, 1.9411F);
		controls3.addChild(cube_r116);
		setRotationAngle(cube_r116, -0.2618F, 0.0F, 0.0F);
		cube_r116.setTextureOffset(136, 240).addBox(9.5F, -1.6F, -12.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		cube_r116.setTextureOffset(136, 236).addBox(14.0F, -1.6F, -12.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		cube_r116.setTextureOffset(183, 179).addBox(18.5F, -1.6F, -12.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		cube_r116.setTextureOffset(482, 384).addBox(9.0F, 0.4F, -13.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		cube_r116.setTextureOffset(379, 482).addBox(13.5F, 0.4F, -13.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		cube_r116.setTextureOffset(361, 482).addBox(18.0F, 0.4F, -13.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		cube_r116.setTextureOffset(334, 473).addBox(23.0F, -0.3F, -4.5F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		cube_r116.setTextureOffset(298, 470).addBox(27.5F, -0.3F, -4.5F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		cube_r116.setTextureOffset(352, 480).addBox(41.0F, 0.0F, -10.5F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		cube_r116.setTextureOffset(307, 481).addBox(45.0F, 0.0F, -10.5F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		cube_r116.setTextureOffset(277, 468).addBox(32.0F, -0.3F, -4.5F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		cube_r116.setTextureOffset(408, 458).addBox(18.2F, -0.3F, -17.6F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		cube_r116.setTextureOffset(435, 458).addBox(36.9F, -0.3F, -17.6F, 3.0F, 2.0F, 3.0F, 0.0F, false);

		cube_r117 = new ModelRenderer(this);
		cube_r117.setRotationPoint(8.8F, -10.4797F, -10.1329F);
		controls3.addChild(cube_r117);
		setRotationAngle(cube_r117, -0.2706F, -0.2527F, 0.0692F);
		cube_r117.setTextureOffset(288, 360).addBox(-0.4F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r117.setTextureOffset(334, 482).addBox(-1.4F, 0.0F, -1.5F, 3.0F, 1.0F, 3.0F, 0.0F, false);

		cube_r118 = new ModelRenderer(this);
		cube_r118.setRotationPoint(13.75F, -10.1918F, -11.763F);
		controls3.addChild(cube_r118);
		setRotationAngle(cube_r118, -0.3257F, -0.6286F, 0.196F);
		cube_r118.setTextureOffset(4, 7).addBox(0.0F, -0.8F, -1.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r118.setTextureOffset(183, 174).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r119 = new ModelRenderer(this);
		cube_r119.setRotationPoint(17.25F, -10.1918F, -11.763F);
		controls3.addChild(cube_r119);
		setRotationAngle(cube_r119, -0.2739F, 0.2947F, -0.0814F);
		cube_r119.setTextureOffset(0, 7).addBox(0.0F, -0.8F, -1.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r119.setTextureOffset(183, 183).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		levers = new ModelRenderer(this);
		levers.setRotationPoint(0.0F, -9.0F, -12.0F);
		controls3.addChild(levers);
		

		cube_r120 = new ModelRenderer(this);
		cube_r120.setRotationPoint(5.0F, -0.8927F, 6.4379F);
		levers.addChild(cube_r120);
		setRotationAngle(cube_r120, -1.309F, 0.0F, 0.0F);
		cube_r120.setTextureOffset(165, 145).addBox(0.0F, -0.5F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		cube_r120.setTextureOffset(116, 480).addBox(-4.4F, -0.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);
		cube_r120.setTextureOffset(452, 175).addBox(-8.6F, -0.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);
		cube_r120.setTextureOffset(12, 170).addBox(-12.0F, -0.5F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r121 = new ModelRenderer(this);
		cube_r121.setRotationPoint(5.0F, -3.6957F, 2.2206F);
		levers.addChild(cube_r121);
		setRotationAngle(cube_r121, -0.2618F, 0.0F, 0.0F);
		cube_r121.setTextureOffset(165, 78).addBox(0.0F, -0.5F, 1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
		cube_r121.setTextureOffset(306, 337).addBox(-4.4F, -0.5F, 1.0F, 3.0F, 4.0F, 2.0F, 0.0F, false);
		cube_r121.setTextureOffset(238, 343).addBox(-8.6F, -0.5F, 1.0F, 3.0F, 4.0F, 2.0F, 0.0F, false);
		cube_r121.setTextureOffset(165, 102).addBox(-12.0F, -0.5F, 1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		cube_r122 = new ModelRenderer(this);
		cube_r122.setRotationPoint(5.0F, -2.3416F, 5.6014F);
		levers.addChild(cube_r122);
		setRotationAngle(cube_r122, -0.7854F, 0.0F, 0.0F);
		cube_r122.setTextureOffset(156, 296).addBox(0.0F, -0.5F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		cube_r122.setTextureOffset(288, 343).addBox(-4.4F, -0.5F, -1.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);
		cube_r122.setTextureOffset(325, 56).addBox(-8.6F, -0.5F, -1.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);
		cube_r122.setTextureOffset(156, 300).addBox(-12.0F, -0.5F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r123 = new ModelRenderer(this);
		cube_r123.setRotationPoint(5.0F, -3.8344F, 1.703F);
		levers.addChild(cube_r123);
		setRotationAngle(cube_r123, -0.2618F, 0.0F, 0.0F);
		cube_r123.setTextureOffset(170, 312).addBox(0.0F, -0.5F, -1.0F, 2.0F, 4.0F, 3.0F, 0.0F, false);
		cube_r123.setTextureOffset(248, 306).addBox(-4.4F, -0.5F, -1.0F, 3.0F, 4.0F, 3.0F, 0.0F, false);
		cube_r123.setTextureOffset(391, 348).addBox(-8.6F, -0.5F, -1.0F, 3.0F, 4.0F, 3.0F, 0.0F, false);
		cube_r123.setTextureOffset(337, 144).addBox(-12.0F, -0.5F, -1.0F, 2.0F, 4.0F, 3.0F, 0.0F, false);

		cube_r124 = new ModelRenderer(this);
		cube_r124.setRotationPoint(5.0F, -3.8344F, 0.03F);
		levers.addChild(cube_r124);
		setRotationAngle(cube_r124, 0.2618F, 0.0F, 0.0F);
		cube_r124.setTextureOffset(172, 295).addBox(0.0F, -0.5F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		cube_r124.setTextureOffset(306, 343).addBox(-4.4F, -0.5F, -1.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);
		cube_r124.setTextureOffset(337, 151).addBox(-8.6F, -0.5F, -1.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);
		cube_r124.setTextureOffset(172, 299).addBox(-12.0F, -0.5F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r125 = new ModelRenderer(this);
		cube_r125.setRotationPoint(5.0F, -2.9979F, -1.4189F);
		levers.addChild(cube_r125);
		setRotationAngle(cube_r125, 0.7854F, 0.0F, 0.0F);
		cube_r125.setTextureOffset(165, 136).addBox(0.0F, -0.5F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		cube_r125.setTextureOffset(450, 56).addBox(-4.4F, -0.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);
		cube_r125.setTextureOffset(457, 448).addBox(-8.6F, -0.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);
		cube_r125.setTextureOffset(0, 170).addBox(-12.0F, -0.5F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r126 = new ModelRenderer(this);
		cube_r126.setRotationPoint(19.0F, 1.7556F, 13.9411F);
		levers.addChild(cube_r126);
		setRotationAngle(cube_r126, -0.2618F, 0.0F, 0.0F);
		cube_r126.setTextureOffset(142, 440).addBox(-26.0F, 0.5F, -16.5F, 14.0F, 1.0F, 9.0F, 0.0F, false);
		cube_r126.setTextureOffset(0, 99).addBox(-26.0F, 0.0F, -8.0F, 14.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r126.setTextureOffset(0, 133).addBox(-26.0F, 0.0F, -17.0F, 14.0F, 1.0F, 1.0F, 0.0F, false);

		demat_lever = new ModelRenderer(this);
		demat_lever.setRotationPoint(4.3F, -0.8673F, 2.2206F);
		levers.addChild(demat_lever);
		setRotationAngle(demat_lever, 1.0472F, 0.0F, 0.0F);
		

		cube_r127 = new ModelRenderer(this);
		cube_r127.setRotationPoint(-4.4F, -3.4549F, 1.0163F);
		demat_lever.addChild(cube_r127);
		setRotationAngle(cube_r127, -0.2618F, 0.0F, 0.0F);
		cube_r127.setTextureOffset(257, 323).addBox(3.4F, -6.6998F, -1.0875F, 2.0F, 1.0F, 2.0F, -0.1F, false);

		cube_r128 = new ModelRenderer(this);
		cube_r128.setRotationPoint(-4.3F, -3.6222F, 1.1647F);
		demat_lever.addChild(cube_r128);
		setRotationAngle(cube_r128, -0.2618F, 0.0F, 0.0F);
		cube_r128.setTextureOffset(28, 146).addBox(3.8F, -1.1998F, -0.6875F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		cube_r128.setTextureOffset(0, 22).addBox(3.3F, -6.1998F, -1.1875F, 2.0F, 5.0F, 2.0F, 0.0F, false);

		handbrake = new ModelRenderer(this);
		handbrake.setRotationPoint(-4.3F, -0.8673F, 2.2206F);
		levers.addChild(handbrake);
		setRotationAngle(handbrake, -1.0472F, 0.0F, 0.0F);
		

		cube_r129 = new ModelRenderer(this);
		cube_r129.setRotationPoint(4.3F, -3.6222F, 1.1647F);
		handbrake.addChild(cube_r129);
		setRotationAngle(cube_r129, -0.2618F, 0.0F, 0.0F);
		cube_r129.setTextureOffset(176, 264).addBox(-4.8F, -1.1998F, -0.6875F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		cube_r129.setTextureOffset(408, 433).addBox(-5.3F, -6.4998F, -1.1875F, 2.0F, 1.0F, 2.0F, -0.1F, false);
		cube_r129.setTextureOffset(24, 90).addBox(-5.3F, -6.1998F, -1.1875F, 2.0F, 5.0F, 2.0F, 0.0F, false);

		lever = new ModelRenderer(this);
		lever.setRotationPoint(0.0F, -0.8673F, 2.2206F);
		levers.addChild(lever);
		setRotationAngle(lever, -0.9163F, 0.0F, 0.0F);
		

		cube_r130 = new ModelRenderer(this);
		cube_r130.setRotationPoint(0.0F, -3.6222F, 1.1647F);
		lever.addChild(cube_r130);
		setRotationAngle(cube_r130, -0.2618F, 0.0F, 0.0F);
		cube_r130.setTextureOffset(176, 68).addBox(-1.0F, -4.1998F, -1.1875F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		cube_r130.setTextureOffset(174, 192).addBox(-0.5F, -1.1998F, -0.6875F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		telepathic_circuit = new ModelRenderer(this);
		telepathic_circuit.setRotationPoint(-29.0F, -7.2444F, 1.9411F);
		controls3.addChild(telepathic_circuit);
		

		cube_r131 = new ModelRenderer(this);
		cube_r131.setRotationPoint(0.0F, 0.0F, 0.0F);
		telepathic_circuit.addChild(cube_r131);
		setRotationAngle(cube_r131, -0.2618F, 0.0F, 0.0F);
		cube_r131.setTextureOffset(205, 357).addBox(8.0F, 0.7F, -8.0F, 13.0F, 1.0F, 8.0F, 0.0F, false);

		telepathic_circuit_lights = new ModelRenderer(this);
		telepathic_circuit_lights.setRotationPoint(0.0F, 0.0F, 0.0F);
		telepathic_circuit.addChild(telepathic_circuit_lights);
		

		cube_r132 = new ModelRenderer(this);
		cube_r132.setRotationPoint(0.0F, 0.0F, 0.0F);
		telepathic_circuit_lights.addChild(cube_r132);
		setRotationAngle(cube_r132, -0.2618F, 0.0F, 0.0F);
		cube_r132.setTextureOffset(136, 313).addBox(8.0F, 0.8F, -8.0F, 13.0F, 1.0F, 8.0F, 0.0F, false);

		lights3 = new ModelRenderer(this);
		lights3.setRotationPoint(0.0F, -7.2444F, 1.9411F);
		controls3.addChild(lights3);
		

		cube_r133 = new ModelRenderer(this);
		cube_r133.setRotationPoint(0.0F, 0.0F, 0.0F);
		lights3.addChild(cube_r133);
		setRotationAngle(cube_r133, -0.2618F, 0.0F, 0.0F);
		cube_r133.setTextureOffset(0, 166).addBox(9.0F, 0.8F, -7.0F, 13.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r133.setTextureOffset(136, 322).addBox(7.0F, 0.7F, -5.0F, 17.0F, 1.0F, 5.0F, 0.0F, false);

		lights3_group1 = new ModelRenderer(this);
		lights3_group1.setRotationPoint(0.0F, 0.0F, 0.0F);
		lights3.addChild(lights3_group1);
		

		cube_r134 = new ModelRenderer(this);
		cube_r134.setRotationPoint(0.0F, 0.0F, 0.0F);
		lights3_group1.addChild(cube_r134);
		setRotationAngle(cube_r134, -0.2618F, 0.0F, 0.0F);
		cube_r134.setTextureOffset(157, 275).addBox(18.0F, 0.7F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r134.setTextureOffset(330, 0).addBox(20.0F, 0.2F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r134.setTextureOffset(248, 329).addBox(18.0F, 0.2F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r134.setTextureOffset(175, 324).addBox(12.0F, 0.7F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r134.setTextureOffset(248, 327).addBox(10.0F, 0.2F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r134.setTextureOffset(248, 259).addBox(8.0F, 0.7F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		lights3_group2 = new ModelRenderer(this);
		lights3_group2.setRotationPoint(0.0F, 0.0F, 0.0F);
		lights3.addChild(lights3_group2);
		

		cube_r135 = new ModelRenderer(this);
		cube_r135.setRotationPoint(0.0F, 0.0F, 0.0F);
		lights3_group2.addChild(cube_r135);
		setRotationAngle(cube_r135, -0.2618F, 0.0F, 0.0F);
		cube_r135.setTextureOffset(330, 2).addBox(22.0F, 0.2F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r135.setTextureOffset(251, 328).addBox(14.0F, 0.2F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r135.setTextureOffset(176, 328).addBox(12.0F, 0.2F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r135.setTextureOffset(175, 260).addBox(22.0F, 0.7F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r135.setTextureOffset(311, 132).addBox(16.0F, 0.7F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		lights3_group3 = new ModelRenderer(this);
		lights3_group3.setRotationPoint(0.0F, 0.0F, 0.0F);
		lights3.addChild(lights3_group3);
		

		cube_r136 = new ModelRenderer(this);
		cube_r136.setRotationPoint(0.0F, 0.0F, 0.0F);
		lights3_group3.addChild(cube_r136);
		setRotationAngle(cube_r136, -0.2618F, 0.0F, 0.0F);
		cube_r136.setTextureOffset(176, 271).addBox(20.0F, 0.7F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r136.setTextureOffset(329, 60).addBox(16.0F, 0.2F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r136.setTextureOffset(325, 125).addBox(8.0F, 0.2F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r136.setTextureOffset(325, 123).addBox(10.0F, 0.7F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r136.setTextureOffset(175, 322).addBox(14.0F, 0.7F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		speed_lights = new ModelRenderer(this);
		speed_lights.setRotationPoint(-29.0F, -7.2444F, 1.9411F);
		controls3.addChild(speed_lights);
		

		cube_r137 = new ModelRenderer(this);
		cube_r137.setRotationPoint(0.0F, 0.0F, 0.0F);
		speed_lights.addChild(cube_r137);
		setRotationAngle(cube_r137, -0.2618F, 0.0F, 0.0F);
		cube_r137.setTextureOffset(352, 471).addBox(39.5F, -0.3F, -21.5F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		cube_r137.setTextureOffset(307, 472).addBox(33.5F, -0.3F, -21.5F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		cube_r137.setTextureOffset(408, 468).addBox(27.5F, -0.3F, -21.5F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		cube_r137.setTextureOffset(452, 473).addBox(21.5F, -0.3F, -21.5F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		cube_r137.setTextureOffset(325, 471).addBox(15.5F, -0.3F, -21.5F, 3.0F, 2.0F, 3.0F, 0.0F, false);

		speed_light1 = new ModelRenderer(this);
		speed_light1.setRotationPoint(0.0F, 0.0F, 0.0F);
		speed_lights.addChild(speed_light1);
		

		cube_r138 = new ModelRenderer(this);
		cube_r138.setRotationPoint(0.0F, 0.0F, 0.0F);
		speed_light1.addChild(cube_r138);
		setRotationAngle(cube_r138, -0.2618F, 0.0F, 0.0F);
		cube_r138.setTextureOffset(333, 373).addBox(40.0F, -0.5F, -21.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		speed_light2 = new ModelRenderer(this);
		speed_light2.setRotationPoint(0.0F, 0.0F, 0.0F);
		speed_lights.addChild(speed_light2);
		

		cube_r139 = new ModelRenderer(this);
		cube_r139.setRotationPoint(0.0F, 0.0F, 0.0F);
		speed_light2.addChild(cube_r139);
		setRotationAngle(cube_r139, -0.2618F, 0.0F, 0.0F);
		cube_r139.setTextureOffset(333, 370).addBox(34.0F, -0.5F, -21.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		speed_light3 = new ModelRenderer(this);
		speed_light3.setRotationPoint(0.0F, 0.0F, 0.0F);
		speed_lights.addChild(speed_light3);
		

		cube_r140 = new ModelRenderer(this);
		cube_r140.setRotationPoint(0.0F, 0.0F, 0.0F);
		speed_light3.addChild(cube_r140);
		setRotationAngle(cube_r140, -0.2618F, 0.0F, 0.0F);
		cube_r140.setTextureOffset(239, 361).addBox(28.0F, -0.5F, -21.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		speed_light4 = new ModelRenderer(this);
		speed_light4.setRotationPoint(0.0F, 0.0F, 0.0F);
		speed_lights.addChild(speed_light4);
		

		cube_r141 = new ModelRenderer(this);
		cube_r141.setRotationPoint(0.0F, 0.0F, 0.0F);
		speed_light4.addChild(cube_r141);
		setRotationAngle(cube_r141, -0.2618F, 0.0F, 0.0F);
		cube_r141.setTextureOffset(99, 361).addBox(22.0F, -0.5F, -21.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		speed_light5 = new ModelRenderer(this);
		speed_light5.setRotationPoint(0.0F, 0.0F, 0.0F);
		speed_lights.addChild(speed_light5);
		

		cube_r142 = new ModelRenderer(this);
		cube_r142.setRotationPoint(0.0F, 0.0F, 0.0F);
		speed_light5.addChild(cube_r142);
		setRotationAngle(cube_r142, -0.2618F, 0.0F, 0.0F);
		cube_r142.setTextureOffset(257, 331).addBox(16.0F, -0.5F, -21.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		side4 = new ModelRenderer(this);
		side4.setRotationPoint(0.0F, -25.8315F, 0.0F);
		root.addChild(side4);
		setRotationAngle(side4, 0.0F, 3.1416F, 0.0F);
		side4.setTextureOffset(329, 123).addBox(-32.0F, -3.8824F, 53.6609F, 64.0F, 8.0F, 1.0F, 0.0F, false);
		side4.setTextureOffset(0, 124).addBox(12.0F, -1.1F, 38.0F, 8.0F, 1.0F, 8.0F, 0.0F, false);
		side4.setTextureOffset(329, 56).addBox(24.0F, -1.1F, 45.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);
		side4.setTextureOffset(20, 68).addBox(25.5F, -6.1F, 46.5F, 3.0F, 5.0F, 3.0F, 0.0F, false);
		side4.setTextureOffset(28, 153).addBox(26.5F, -10.9F, 47.5F, 1.0F, 5.0F, 1.0F, -0.2F, false);
		side4.setTextureOffset(165, 68).addBox(25.0F, -9.1F, 44.5F, 1.0F, 3.0F, 3.0F, 0.0F, false);
		side4.setTextureOffset(166, 191).addBox(25.0F, -9.1F, 47.25F, 1.0F, 3.0F, 2.0F, 0.0F, false);
		side4.setTextureOffset(24, 124).addBox(25.0F, -9.1F, 49.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
		side4.setTextureOffset(0, 90).addBox(-20.0F, -1.1F, 38.0F, 8.0F, 1.0F, 8.0F, 0.0F, false);
		side4.setTextureOffset(301, 423).addBox(-29.0F, -1.1F, 44.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		side4.setTextureOffset(337, 68).addBox(-29.0F, -5.1F, 44.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		side4.setTextureOffset(12, 175).addBox(-28.0F, -6.1F, 45.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		side4.setTextureOffset(223, 439).addBox(-28.5F, -4.1F, 44.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		cube_r143 = new ModelRenderer(this);
		cube_r143.setRotationPoint(34.8391F, -4.5746F, 60.3431F);
		side4.addChild(cube_r143);
		setRotationAngle(cube_r143, 0.0F, 0.5236F, 0.0F);
		cube_r143.setTextureOffset(177, 145).addBox(-1.0F, -0.5F, -8.5F, 2.0F, 5.0F, 1.0F, 0.0F, false);

		cube_r144 = new ModelRenderer(this);
		cube_r144.setRotationPoint(36.0358F, -1.5446F, 62.4159F);
		side4.addChild(cube_r144);
		setRotationAngle(cube_r144, -0.3142F, 0.5236F, 0.0F);
		cube_r144.setTextureOffset(451, 495).addBox(-1.0F, -0.3F, -10.5F, 2.0F, 1.0F, 16.0F, 0.0F, false);

		cube_r145 = new ModelRenderer(this);
		cube_r145.setRotationPoint(0.0F, 0.0F, 0.0F);
		side4.addChild(cube_r145);
		setRotationAngle(cube_r145, -0.3491F, 0.0F, 0.0F);
		cube_r145.setTextureOffset(166, 192).addBox(-38.0F, -23.0014F, 49.0969F, 76.0F, 1.0F, 14.0F, 0.0F, false);

		controls4 = new ModelRenderer(this);
		controls4.setRotationPoint(0.0F, 0.0F, 0.0F);
		side4.addChild(controls4);
		controls4.setTextureOffset(148, 254).addBox(14.0F, -9.9119F, 53.6543F, 4.0F, 6.0F, 1.0F, 0.0F, false);
		controls4.setTextureOffset(169, 236).addBox(-18.0F, -9.9119F, 53.6543F, 4.0F, 6.0F, 1.0F, 0.0F, false);

		cube_r146 = new ModelRenderer(this);
		cube_r146.setRotationPoint(0.0F, -4.8891F, 56.2662F);
		controls4.addChild(cube_r146);
		setRotationAngle(cube_r146, 0.1745F, 0.0F, 0.0F);
		cube_r146.setTextureOffset(6, 36).addBox(-16.5F, -2.4F, 2.3F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r146.setTextureOffset(18, 357).addBox(15.5F, -2.4F, 2.3F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r146.setTextureOffset(202, 444).addBox(14.0F, -5.4F, 1.3F, 4.0F, 4.0F, 1.0F, 0.0F, false);
		cube_r146.setTextureOffset(179, 440).addBox(-18.0F, -5.4F, 1.3F, 4.0F, 4.0F, 1.0F, 0.0F, false);
		cube_r146.setTextureOffset(453, 417).addBox(14.0F, -5.4F, 2.3F, 4.0F, 4.0F, 2.0F, 0.0F, false);
		cube_r146.setTextureOffset(453, 411).addBox(-18.0F, -5.4F, 2.3F, 4.0F, 4.0F, 2.0F, 0.0F, false);
		cube_r146.setTextureOffset(18, 136).addBox(-18.0F, -5.4F, -1.7F, 4.0F, 7.0F, 3.0F, 0.0F, false);
		cube_r146.setTextureOffset(408, 223).addBox(-17.5F, -4.9F, -7.7F, 3.0F, 3.0F, 6.0F, 0.0F, false);
		cube_r146.setTextureOffset(402, 274).addBox(14.5F, -4.9F, -7.7F, 3.0F, 3.0F, 6.0F, 0.0F, false);
		cube_r146.setTextureOffset(0, 191).addBox(14.0F, -5.4F, -1.7F, 4.0F, 7.0F, 3.0F, 0.0F, false);

		cube_r147 = new ModelRenderer(this);
		cube_r147.setRotationPoint(0.0F, 0.0F, 0.0F);
		controls4.addChild(cube_r147);
		setRotationAngle(cube_r147, -0.3491F, 0.0F, 0.0F);
		cube_r147.setTextureOffset(183, 170).addBox(-9.5F, -25.8014F, 53.5969F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		cube_r147.setTextureOffset(177, 115).addBox(7.5F, -25.8014F, 53.5969F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		cube_r147.setTextureOffset(166, 260).addBox(-10.0F, -23.8014F, 53.0969F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		cube_r147.setTextureOffset(165, 167).addBox(-6.0F, -23.4014F, 58.5969F, 12.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r147.setTextureOffset(325, 89).addBox(-6.5F, -23.6014F, 52.5969F, 10.0F, 1.0F, 3.0F, 0.0F, false);
		cube_r147.setTextureOffset(6, 34).addBox(5.0F, -24.4014F, 53.5969F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r147.setTextureOffset(165, 74).addBox(4.5F, -23.4014F, 53.0969F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r147.setTextureOffset(148, 275).addBox(7.0F, -23.8014F, 53.0969F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		cube_r147.setTextureOffset(462, 277).addBox(-11.0F, -23.3014F, 52.0969F, 22.0F, 1.0F, 8.0F, 0.0F, false);

		lights_group5 = new ModelRenderer(this);
		lights_group5.setRotationPoint(27.0F, 0.0F, 0.0F);
		controls4.addChild(lights_group5);
		

		cube_r148 = new ModelRenderer(this);
		cube_r148.setRotationPoint(-27.0F, 0.0F, 0.0F);
		lights_group5.addChild(cube_r148);
		setRotationAngle(cube_r148, -0.3491F, 0.0F, 0.0F);
		cube_r148.setTextureOffset(361, 334).addBox(-6.0F, -23.6014F, 56.5969F, 12.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r148.setTextureOffset(248, 252).addBox(-9.0F, -24.0014F, 58.0969F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r149 = new ModelRenderer(this);
		cube_r149.setRotationPoint(0.0F, 0.0F, 0.0F);
		lights_group5.addChild(cube_r149);
		setRotationAngle(cube_r149, -0.3491F, 0.0F, 0.0F);
		cube_r149.setTextureOffset(248, 250).addBox(-19.0F, -24.0014F, 58.0969F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		coffee_machine = new ModelRenderer(this);
		coffee_machine.setRotationPoint(0.0F, -4.1685F, 33.1051F);
		controls4.addChild(coffee_machine);
		coffee_machine.setTextureOffset(421, 511).addBox(-5.5F, -8.0F, 11.8564F, 11.0F, 13.0F, 2.0F, 0.0F, false);
		coffee_machine.setTextureOffset(288, 358).addBox(-4.5F, -7.0F, 8.1244F, 9.0F, 2.0F, 4.0F, 0.0F, false);

		cube_r150 = new ModelRenderer(this);
		cube_r150.setRotationPoint(0.0F, 0.5F, 4.3301F);
		coffee_machine.addChild(cube_r150);
		setRotationAngle(cube_r150, 0.0F, -1.0472F, 0.0F);
		cube_r150.setTextureOffset(512, 32).addBox(-4.5F, -7.5F, 3.7942F, 9.0F, 2.0F, 4.0F, 0.0F, false);

		cube_r151 = new ModelRenderer(this);
		cube_r151.setRotationPoint(0.0F, 0.5F, 4.3301F);
		coffee_machine.addChild(cube_r151);
		setRotationAngle(cube_r151, 0.0F, -2.0944F, 0.0F);
		cube_r151.setTextureOffset(510, 64).addBox(-4.5F, -7.5F, 3.7942F, 9.0F, 2.0F, 4.0F, 0.0F, false);

		cube_r152 = new ModelRenderer(this);
		cube_r152.setRotationPoint(0.0F, 0.5F, 4.3301F);
		coffee_machine.addChild(cube_r152);
		setRotationAngle(cube_r152, 0.0F, 3.1416F, 0.0F);
		cube_r152.setTextureOffset(464, 360).addBox(-4.5F, -7.5F, 3.7942F, 9.0F, 2.0F, 4.0F, 0.0F, false);

		cube_r153 = new ModelRenderer(this);
		cube_r153.setRotationPoint(0.0F, 0.5F, 4.3301F);
		coffee_machine.addChild(cube_r153);
		setRotationAngle(cube_r153, 0.0F, 2.0944F, 0.0F);
		cube_r153.setTextureOffset(459, 306).addBox(-4.5F, -7.5F, 3.7942F, 9.0F, 2.0F, 4.0F, 0.0F, false);

		cube_r154 = new ModelRenderer(this);
		cube_r154.setRotationPoint(0.0F, 0.5F, 4.3301F);
		coffee_machine.addChild(cube_r154);
		setRotationAngle(cube_r154, 0.0F, 1.0472F, 0.0F);
		cube_r154.setTextureOffset(372, 306).addBox(-4.5F, -7.5F, 3.7942F, 9.0F, 2.0F, 4.0F, 0.0F, false);

		cube_r155 = new ModelRenderer(this);
		cube_r155.setRotationPoint(8.134F, -6.0F, 7.2942F);
		coffee_machine.addChild(cube_r155);
		setRotationAngle(cube_r155, 0.0F, 1.0472F, 0.0F);
		cube_r155.setTextureOffset(28, 511).addBox(-7.0F, -2.0F, -1.0F, 11.0F, 13.0F, 2.0F, 0.0F, false);

		cube_r156 = new ModelRenderer(this);
		cube_r156.setRotationPoint(6.634F, -6.0F, -1.2321F);
		coffee_machine.addChild(cube_r156);
		setRotationAngle(cube_r156, 0.0F, 2.0944F, 0.0F);
		cube_r156.setTextureOffset(54, 511).addBox(-7.0F, -2.0F, -1.0F, 11.0F, 13.0F, 2.0F, 0.0F, false);

		cube_r157 = new ModelRenderer(this);
		cube_r157.setRotationPoint(-1.5F, -6.0F, -4.1962F);
		coffee_machine.addChild(cube_r157);
		setRotationAngle(cube_r157, 0.0F, 3.1416F, 0.0F);
		cube_r157.setTextureOffset(152, 512).addBox(-7.0F, -2.0F, -1.0F, 11.0F, 13.0F, 2.0F, 0.0F, false);

		cube_r158 = new ModelRenderer(this);
		cube_r158.setRotationPoint(-8.134F, -6.0F, 1.366F);
		coffee_machine.addChild(cube_r158);
		setRotationAngle(cube_r158, 0.0F, -2.0944F, 0.0F);
		cube_r158.setTextureOffset(178, 512).addBox(-7.0F, -2.0F, -1.0F, 11.0F, 13.0F, 2.0F, 0.0F, false);

		cube_r159 = new ModelRenderer(this);
		cube_r159.setRotationPoint(-6.634F, -6.0F, 9.8923F);
		coffee_machine.addChild(cube_r159);
		setRotationAngle(cube_r159, 0.0F, -1.0472F, 0.0F);
		cube_r159.setTextureOffset(204, 512).addBox(-7.0F, -2.0F, -1.0F, 11.0F, 13.0F, 2.0F, 0.0F, false);

		sonic_port = new ModelRenderer(this);
		sonic_port.setRotationPoint(0.0F, 1.5F, 4.3301F);
		coffee_machine.addChild(sonic_port);
		sonic_port.setTextureOffset(435, 464).addBox(-4.5F, -7.5F, -4.0F, 9.0F, 1.0F, 8.0F, 0.0F, false);

		cable = new ModelRenderer(this);
		cable.setRotationPoint(0.0F, 0.0F, 0.0F);
		side4.addChild(cable);
		

		cube_r160 = new ModelRenderer(this);
		cube_r160.setRotationPoint(6.5189F, 1.141F, 40.7892F);
		cable.addChild(cube_r160);
		setRotationAngle(cube_r160, 0.0F, 0.829F, 0.0F);
		cube_r160.setTextureOffset(408, 245).addBox(9.7F, -3.5F, -9.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);

		cube_r161 = new ModelRenderer(this);
		cube_r161.setRotationPoint(-11.9844F, -5.0733F, 36.7648F);
		cable.addChild(cube_r161);
		setRotationAngle(cube_r161, -2.4435F, 0.5672F, 3.1416F);
		cube_r161.setTextureOffset(136, 296).addBox(0.0F, 0.0F, -7.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);

		cube_r162 = new ModelRenderer(this);
		cube_r162.setRotationPoint(-7.8434F, -4.7026F, 29.3342F);
		cable.addChild(cube_r162);
		setRotationAngle(cube_r162, 3.098F, 0.5672F, 3.1416F);
		cube_r162.setTextureOffset(176, 73).addBox(-0.5F, 0.0F, -8.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		cube_r163 = new ModelRenderer(this);
		cube_r163.setRotationPoint(-9.0914F, -3.4633F, 31.2931F);
		cable.addChild(cube_r163);
		setRotationAngle(cube_r163, 2.7053F, 0.5672F, 3.1416F);
		cube_r163.setTextureOffset(165, 68).addBox(-0.5F, 0.0F, -3.5F, 1.0F, 1.0F, 9.0F, 0.0F, false);

		cube_r164 = new ModelRenderer(this);
		cube_r164.setRotationPoint(0.637F, -1.7925F, 27.32F);
		cable.addChild(cube_r164);
		setRotationAngle(cube_r164, 0.0F, 1.5708F, -0.0873F);
		cube_r164.setTextureOffset(361, 319).addBox(-0.5F, 0.0F, -7.5F, 1.0F, 1.0F, 14.0F, 0.0F, false);

		cube_r165 = new ModelRenderer(this);
		cube_r165.setRotationPoint(11.8155F, -7.3214F, 35.9251F);
		cable.addChild(cube_r165);
		setRotationAngle(cube_r165, 0.5236F, 0.2618F, 0.0F);
		cube_r165.setTextureOffset(166, 192).addBox(-0.5F, 1.4F, -7.5F, 1.0F, 1.0F, 6.0F, 0.0F, false);

		cube_r166 = new ModelRenderer(this);
		cube_r166.setRotationPoint(12.4263F, -5.455F, 38.2046F);
		cable.addChild(cube_r166);
		setRotationAngle(cube_r166, -0.8727F, 0.2618F, 0.0F);
		cube_r166.setTextureOffset(0, 221).addBox(-0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);

		cube_r167 = new ModelRenderer(this);
		cube_r167.setRotationPoint(12.1649F, -4.6866F, 37.2289F);
		cable.addChild(cube_r167);
		setRotationAngle(cube_r167, -0.0873F, 0.2618F, 0.0F);
		cube_r167.setTextureOffset(410, 265).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);

		side5 = new ModelRenderer(this);
		side5.setRotationPoint(0.0F, -25.8315F, 0.0F);
		root.addChild(side5);
		setRotationAngle(side5, 0.0F, 2.0944F, 0.0F);
		side5.setTextureOffset(330, 26).addBox(-32.0F, -3.8824F, 53.6609F, 64.0F, 7.0F, 1.0F, 0.0F, false);

		cube_r168 = new ModelRenderer(this);
		cube_r168.setRotationPoint(39.3391F, -4.5746F, 68.1374F);
		side5.addChild(cube_r168);
		setRotationAngle(cube_r168, 0.0F, 0.5236F, 0.0F);
		cube_r168.setTextureOffset(177, 136).addBox(-1.0F, -0.5F, -17.5F, 2.0F, 5.0F, 1.0F, 0.0F, false);

		cube_r169 = new ModelRenderer(this);
		cube_r169.setRotationPoint(4.081F, -3.21F, 58.5498F);
		side5.addChild(cube_r169);
		setRotationAngle(cube_r169, -0.6869F, 0.9779F, -0.6666F);
		cube_r169.setTextureOffset(0, 34).addBox(-23.9161F, -2.4682F, -28.3304F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r169.setTextureOffset(0, 157).addBox(-9.5161F, 0.5318F, -28.3304F, 13.0F, 7.0F, 2.0F, 0.0F, false);
		cube_r169.setTextureOffset(462, 243).addBox(-23.5161F, -2.4682F, -28.3304F, 27.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r170 = new ModelRenderer(this);
		cube_r170.setRotationPoint(4.081F, -3.21F, 58.5498F);
		side5.addChild(cube_r170);
		setRotationAngle(cube_r170, -0.6869F, -0.9779F, 0.6666F);
		cube_r170.setTextureOffset(0, 0).addBox(19.3318F, -1.939F, -21.0167F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		cube_r170.setTextureOffset(511, 0).addBox(-7.0682F, 1.061F, -21.0167F, 13.0F, 7.0F, 2.0F, 0.0F, false);
		cube_r170.setTextureOffset(481, 470).addBox(-7.0682F, -1.939F, -21.0167F, 27.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r171 = new ModelRenderer(this);
		cube_r171.setRotationPoint(0.0F, -2.1487F, 33.8679F);
		side5.addChild(cube_r171);
		setRotationAngle(cube_r171, 0.2618F, 0.0F, 0.0F);
		cube_r171.setTextureOffset(219, 337).addBox(-0.0649F, -4.5F, -17.0F, 20.0F, 9.0F, 29.0F, 0.0F, false);
		cube_r171.setTextureOffset(107, 328).addBox(-19.9351F, -4.5F, -17.0F, 20.0F, 9.0F, 29.0F, 0.0F, false);

		cube_r172 = new ModelRenderer(this);
		cube_r172.setRotationPoint(4.081F, -3.21F, 58.5498F);
		side5.addChild(cube_r172);
		setRotationAngle(cube_r172, -0.3927F, 0.0F, 0.0F);
		cube_r172.setTextureOffset(80, 448).addBox(-24.0161F, -0.4494F, -15.6161F, 20.0F, 3.0F, 2.0F, 0.0F, false);
		cube_r172.setTextureOffset(112, 422).addBox(-4.1459F, -0.4494F, -15.6161F, 20.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r173 = new ModelRenderer(this);
		cube_r173.setRotationPoint(36.0358F, -1.5446F, 62.4159F);
		side5.addChild(cube_r173);
		setRotationAngle(cube_r173, -0.3142F, 0.5236F, 0.0F);
		cube_r173.setTextureOffset(495, 222).addBox(-1.0F, -0.3F, -10.5F, 2.0F, 1.0F, 16.0F, 0.0F, false);

		cube_r174 = new ModelRenderer(this);
		cube_r174.setRotationPoint(0.0F, 0.0F, 0.0F);
		side5.addChild(cube_r174);
		setRotationAngle(cube_r174, -0.3491F, 0.0F, 0.0F);
		cube_r174.setTextureOffset(357, 121).addBox(-20.0F, -23.0014F, 40.0969F, 40.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r174.setTextureOffset(391, 340).addBox(-21.0F, -23.0014F, 41.0969F, 42.0F, 1.0F, 4.0F, 0.0F, false);
		cube_r174.setTextureOffset(344, 176).addBox(-23.0F, -23.0014F, 45.0969F, 46.0F, 1.0F, 4.0F, 0.0F, false);
		cube_r174.setTextureOffset(166, 207).addBox(-38.0F, -23.0014F, 49.0969F, 76.0F, 1.0F, 14.0F, 0.0F, false);

		cube_r175 = new ModelRenderer(this);
		cube_r175.setRotationPoint(4.1569F, -8.9616F, 44.0917F);
		side5.addChild(cube_r175);
		setRotationAngle(cube_r175, -0.3819F, -0.4084F, 0.1582F);
		cube_r175.setTextureOffset(363, 458).addBox(12.0F, -0.5F, -2.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);

		cube_r176 = new ModelRenderer(this);
		cube_r176.setRotationPoint(-4.1569F, -8.9616F, 44.0917F);
		side5.addChild(cube_r176);
		setRotationAngle(cube_r176, -0.3819F, 0.4084F, -0.1582F);
		cube_r176.setTextureOffset(408, 253).addBox(-14.0F, -0.5F, -2.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);

		cube_r177 = new ModelRenderer(this);
		cube_r177.setRotationPoint(3.6905F, -7.9F, 47.0086F);
		side5.addChild(cube_r177);
		setRotationAngle(cube_r177, -0.3491F, 0.0F, 0.0F);
		cube_r177.setTextureOffset(443, 15).addBox(-4.0F, -0.5F, 0.0F, 18.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r178 = new ModelRenderer(this);
		cube_r178.setRotationPoint(-3.6905F, -7.9F, 47.0086F);
		side5.addChild(cube_r178);
		setRotationAngle(cube_r178, -0.3491F, 0.0F, 0.0F);
		cube_r178.setTextureOffset(447, 154).addBox(-14.0F, -0.5F, 0.0F, 18.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r179 = new ModelRenderer(this);
		cube_r179.setRotationPoint(0.0F, -7.0021F, 49.4755F);
		side5.addChild(cube_r179);
		setRotationAngle(cube_r179, -0.3491F, 0.0F, 0.0F);
		cube_r179.setTextureOffset(248, 243).addBox(11.5F, -2.5F, -0.3F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r179.setTextureOffset(248, 238).addBox(-12.5F, -2.5F, -0.3F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r179.setTextureOffset(209, 371).addBox(-13.0F, -1.5F, -1.8F, 2.0F, 1.0F, 3.0F, 0.0F, false);
		cube_r179.setTextureOffset(179, 445).addBox(11.0F, -1.5F, -1.8F, 2.0F, 1.0F, 3.0F, 0.0F, false);
		cube_r179.setTextureOffset(442, 156).addBox(-16.0F, -0.5F, -2.0F, 32.0F, 1.0F, 4.0F, 0.0F, false);

		vertical_switch_lights1 = new ModelRenderer(this);
		vertical_switch_lights1.setRotationPoint(0.0F, -7.0021F, 49.4755F);
		side5.addChild(vertical_switch_lights1);
		

		cube_r180 = new ModelRenderer(this);
		cube_r180.setRotationPoint(0.0F, 0.0F, 0.0F);
		vertical_switch_lights1.addChild(cube_r180);
		setRotationAngle(cube_r180, -0.3491F, 0.0F, 0.0F);
		cube_r180.setTextureOffset(350, 102).addBox(5.75F, -1.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r180.setTextureOffset(165, 56).addBox(3.25F, -1.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r180.setTextureOffset(244, 349).addBox(-4.25F, -1.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r180.setTextureOffset(244, 351).addBox(-6.75F, -1.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		vertical_switch_lights2 = new ModelRenderer(this);
		vertical_switch_lights2.setRotationPoint(0.0F, -7.0021F, 49.4755F);
		side5.addChild(vertical_switch_lights2);
		

		cube_r181 = new ModelRenderer(this);
		cube_r181.setRotationPoint(0.0F, 0.0F, 0.0F);
		vertical_switch_lights2.addChild(cube_r181);
		setRotationAngle(cube_r181, -0.3491F, 0.0F, 0.0F);
		cube_r181.setTextureOffset(350, 50).addBox(0.75F, -1.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r181.setTextureOffset(248, 236).addBox(-1.75F, -1.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		vertical_switch1 = new ModelRenderer(this);
		vertical_switch1.setRotationPoint(6.25F, -7.814F, 48.7068F);
		side5.addChild(vertical_switch1);
		

		cube_r182 = new ModelRenderer(this);
		cube_r182.setRotationPoint(-6.25F, 0.8119F, 0.7687F);
		vertical_switch1.addChild(cube_r182);
		setRotationAngle(cube_r182, -0.3491F, 0.0F, 0.0F);
		cube_r182.setTextureOffset(147, 304).addBox(5.75F, -3.0F, -1.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		vertical_switch2 = new ModelRenderer(this);
		vertical_switch2.setRotationPoint(3.75F, -7.814F, 48.7068F);
		side5.addChild(vertical_switch2);
		

		cube_r183 = new ModelRenderer(this);
		cube_r183.setRotationPoint(-3.75F, 0.8119F, 0.7687F);
		vertical_switch2.addChild(cube_r183);
		setRotationAngle(cube_r183, -0.3491F, 0.0F, 0.0F);
		cube_r183.setTextureOffset(148, 279).addBox(3.25F, -3.0F, -1.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		vertical_switch3 = new ModelRenderer(this);
		vertical_switch3.setRotationPoint(1.25F, -7.814F, 48.7068F);
		side5.addChild(vertical_switch3);
		

		cube_r184 = new ModelRenderer(this);
		cube_r184.setRotationPoint(-1.25F, 0.8119F, 0.7687F);
		vertical_switch3.addChild(cube_r184);
		setRotationAngle(cube_r184, -0.3491F, 0.0F, 0.0F);
		cube_r184.setTextureOffset(148, 289).addBox(0.75F, -3.0F, -1.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		vertical_switch4 = new ModelRenderer(this);
		vertical_switch4.setRotationPoint(-1.25F, -7.814F, 48.7068F);
		side5.addChild(vertical_switch4);
		

		cube_r185 = new ModelRenderer(this);
		cube_r185.setRotationPoint(1.25F, 0.8119F, 0.7687F);
		vertical_switch4.addChild(cube_r185);
		setRotationAngle(cube_r185, -0.3491F, 0.0F, 0.0F);
		cube_r185.setTextureOffset(148, 284).addBox(-1.75F, -3.0F, -1.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		vertical_switch5 = new ModelRenderer(this);
		vertical_switch5.setRotationPoint(-3.75F, -7.814F, 48.7068F);
		side5.addChild(vertical_switch5);
		

		cube_r186 = new ModelRenderer(this);
		cube_r186.setRotationPoint(3.75F, 0.8119F, 0.7687F);
		vertical_switch5.addChild(cube_r186);
		setRotationAngle(cube_r186, -0.3491F, 0.0F, 0.0F);
		cube_r186.setTextureOffset(136, 304).addBox(-4.25F, -3.0F, -1.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		vertical_switch6 = new ModelRenderer(this);
		vertical_switch6.setRotationPoint(-6.25F, -7.814F, 48.7068F);
		side5.addChild(vertical_switch6);
		

		cube_r187 = new ModelRenderer(this);
		cube_r187.setRotationPoint(6.25F, 0.8119F, 0.7687F);
		vertical_switch6.addChild(cube_r187);
		setRotationAngle(cube_r187, -0.3491F, 0.0F, 0.0F);
		cube_r187.setTextureOffset(248, 319).addBox(-6.75F, -3.0F, -1.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		contols5 = new ModelRenderer(this);
		contols5.setRotationPoint(0.0F, -7.0021F, 49.4755F);
		side5.addChild(contols5);
		

		cube_r188 = new ModelRenderer(this);
		cube_r188.setRotationPoint(15.0F, -2.864F, -6.4068F);
		contols5.addChild(cube_r188);
		setRotationAngle(cube_r188, -0.3491F, 0.0F, 0.0F);
		cube_r188.setTextureOffset(388, 475).addBox(-39.0F, 0.0F, 16.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		cube_r188.setTextureOffset(298, 475).addBox(6.0F, 0.0F, 16.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		cube_r188.setTextureOffset(16, 184).addBox(6.5F, 0.0F, 13.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r188.setTextureOffset(181, 73).addBox(-37.5F, 0.0F, 13.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r188.setTextureOffset(248, 224).addBox(2.5F, 0.0F, 17.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r188.setTextureOffset(248, 222).addBox(-33.5F, 0.0F, 17.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r188.setTextureOffset(248, 231).addBox(-29.5F, 0.0F, 22.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r188.setTextureOffset(248, 229).addBox(-1.5F, 0.0F, 22.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r188.setTextureOffset(325, 476).addBox(-35.0F, 0.0F, 21.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		cube_r188.setTextureOffset(56, 476).addBox(2.0F, 0.0F, 21.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		cube_r188.setTextureOffset(333, 417).addBox(-28.0F, 0.0F, 10.0F, 5.0F, 1.0F, 5.0F, 0.0F, false);
		cube_r188.setTextureOffset(333, 411).addBox(-7.0F, 0.0F, 10.0F, 5.0F, 1.0F, 5.0F, 0.0F, false);
		cube_r188.setTextureOffset(248, 439).addBox(-24.0F, 0.7F, 17.0F, 3.0F, 1.0F, 8.0F, 0.0F, false);
		cube_r188.setTextureOffset(451, 383).addBox(-9.0F, 0.7F, 17.0F, 3.0F, 1.0F, 8.0F, 0.0F, false);
		cube_r188.setTextureOffset(393, 412).addBox(-14.0F, 0.0F, 10.0F, 5.0F, 1.0F, 5.0F, 0.0F, false);
		cube_r188.setTextureOffset(393, 418).addBox(-21.0F, 0.0F, 10.0F, 5.0F, 1.0F, 5.0F, 0.0F, false);

		cube_r189 = new ModelRenderer(this);
		cube_r189.setRotationPoint(-25.0F, 5.6603F, 14.9667F);
		contols5.addChild(cube_r189);
		setRotationAngle(cube_r189, -0.3646F, 0.2865F, -0.1074F);
		cube_r189.setTextureOffset(136, 299).addBox(1.0F, -0.7F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r189.setTextureOffset(177, 111).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r190 = new ModelRenderer(this);
		cube_r190.setRotationPoint(25.0F, 5.6603F, 14.9667F);
		contols5.addChild(cube_r190);
		setRotationAngle(cube_r190, -0.4942F, -0.7654F, 0.3572F);
		cube_r190.setTextureOffset(145, 299).addBox(-3.0F, -0.7F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r190.setTextureOffset(239, 357).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r191 = new ModelRenderer(this);
		cube_r191.setRotationPoint(-4.0F, 5.4291F, 13.4545F);
		contols5.addChild(cube_r191);
		setRotationAngle(cube_r191, -0.2519F, -0.2443F, -0.7543F);
		cube_r191.setTextureOffset(172, 170).addBox(-1.0F, -1.0F, -3.5F, 2.0F, 2.0F, 7.0F, 0.0F, false);

		cube_r192 = new ModelRenderer(this);
		cube_r192.setRotationPoint(-2.0F, 5.4291F, 13.4545F);
		contols5.addChild(cube_r192);
		setRotationAngle(cube_r192, -0.2519F, -0.2443F, -0.7543F);
		cube_r192.setTextureOffset(0, 179).addBox(-1.0F, -1.0F, -3.5F, 2.0F, 2.0F, 7.0F, 0.0F, false);

		cube_r193 = new ModelRenderer(this);
		cube_r193.setRotationPoint(4.0F, 5.4291F, 13.4545F);
		contols5.addChild(cube_r193);
		setRotationAngle(cube_r193, -0.2519F, 0.2443F, 0.7543F);
		cube_r193.setTextureOffset(172, 179).addBox(-1.0F, -1.0F, -3.5F, 2.0F, 2.0F, 7.0F, 0.0F, false);

		cube_r194 = new ModelRenderer(this);
		cube_r194.setRotationPoint(2.0F, 5.4291F, 13.4545F);
		contols5.addChild(cube_r194);
		setRotationAngle(cube_r194, -0.2519F, 0.2443F, 0.7543F);
		cube_r194.setTextureOffset(399, 265).addBox(-1.0F, -1.0F, -3.5F, 2.0F, 2.0F, 7.0F, 0.0F, false);

		cube_r195 = new ModelRenderer(this);
		cube_r195.setRotationPoint(0.0F, 5.4291F, 13.4545F);
		contols5.addChild(cube_r195);
		setRotationAngle(cube_r195, -0.2519F, -0.2443F, -0.7543F);
		cube_r195.setTextureOffset(139, 400).addBox(-1.0F, -1.0F, -3.5F, 2.0F, 2.0F, 7.0F, 0.0F, false);

		lights4 = new ModelRenderer(this);
		lights4.setRotationPoint(15.0F, -2.864F, -6.4068F);
		contols5.addChild(lights4);
		

		lights4_group1 = new ModelRenderer(this);
		lights4_group1.setRotationPoint(0.0F, 0.0F, 0.0F);
		lights4.addChild(lights4_group1);
		

		cube_r196 = new ModelRenderer(this);
		cube_r196.setRotationPoint(0.0F, 0.0F, 0.0F);
		lights4_group1.addChild(cube_r196);
		setRotationAngle(cube_r196, -0.3491F, 0.0F, 0.0F);
		cube_r196.setTextureOffset(165, 98).addBox(-22.25F, 0.5F, 17.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r196.setTextureOffset(28, 104).addBox(-23.75F, 0.5F, 21.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r196.setTextureOffset(0, 138).addBox(-7.25F, -0.1F, 23.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r196.setTextureOffset(165, 157).addBox(-8.75F, -0.1F, 19.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r196.setTextureOffset(0, 136).addBox(-7.25F, 0.5F, 17.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		lights4_group2 = new ModelRenderer(this);
		lights4_group2.setRotationPoint(0.0F, 0.0F, 0.0F);
		lights4.addChild(lights4_group2);
		

		cube_r197 = new ModelRenderer(this);
		cube_r197.setRotationPoint(0.0F, 0.0F, 0.0F);
		lights4_group2.addChild(cube_r197);
		setRotationAngle(cube_r197, -0.3491F, 0.0F, 0.0F);
		cube_r197.setTextureOffset(6, 136).addBox(-7.25F, 0.5F, 19.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r197.setTextureOffset(165, 123).addBox(-8.75F, -0.1F, 17.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r197.setTextureOffset(165, 159).addBox(-22.25F, -0.1F, 21.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r197.setTextureOffset(171, 15).addBox(-22.25F, -0.1F, 23.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r197.setTextureOffset(29, 136).addBox(-7.25F, -0.1F, 21.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r197.setTextureOffset(6, 104).addBox(-23.75F, -0.1F, 17.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		lights4_group3 = new ModelRenderer(this);
		lights4_group3.setRotationPoint(0.0F, 0.0F, 0.0F);
		lights4.addChild(lights4_group3);
		

		cube_r198 = new ModelRenderer(this);
		cube_r198.setRotationPoint(0.0F, 0.0F, 0.0F);
		lights4_group3.addChild(cube_r198);
		setRotationAngle(cube_r198, -0.3491F, 0.0F, 0.0F);
		cube_r198.setTextureOffset(171, 13).addBox(-8.75F, 0.5F, 23.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r198.setTextureOffset(170, 68).addBox(-8.75F, 0.5F, 21.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r198.setTextureOffset(165, 125).addBox(-22.25F, 0.5F, 19.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r198.setTextureOffset(20, 104).addBox(-23.75F, -0.1F, 19.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r198.setTextureOffset(29, 123).addBox(-23.75F, 0.5F, 23.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		indicator = new ModelRenderer(this);
		indicator.setRotationPoint(15.0F, -2.864F, -6.4068F);
		contols5.addChild(indicator);
		

		cube_r199 = new ModelRenderer(this);
		cube_r199.setRotationPoint(0.0F, 0.0F, 0.0F);
		indicator.addChild(cube_r199);
		setRotationAngle(cube_r199, -0.3491F, 0.0F, 0.0F);
		cube_r199.setTextureOffset(445, 44).addBox(-28.0F, 0.4F, 10.0F, 26.0F, 0.0F, 5.0F, 0.0F, false);

		lights_group3 = new ModelRenderer(this);
		lights_group3.setRotationPoint(15.0F, -2.864F, -6.4068F);
		contols5.addChild(lights_group3);
		

		cube_r200 = new ModelRenderer(this);
		cube_r200.setRotationPoint(0.0F, 0.0F, 0.0F);
		lights_group3.addChild(cube_r200);
		setRotationAngle(cube_r200, -0.3491F, 0.0F, 0.0F);
		cube_r200.setTextureOffset(29, 57).addBox(5.0F, 0.7F, 9.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r200.setTextureOffset(29, 55).addBox(-36.0F, 0.7F, 9.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r200.setTextureOffset(6, 68).addBox(2.0F, 0.7F, 11.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r200.setTextureOffset(0, 68).addBox(-33.0F, 0.7F, 11.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r200.setTextureOffset(29, 68).addBox(-31.0F, 0.7F, 14.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r200.setTextureOffset(0, 36).addBox(0.0F, 0.7F, 14.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r200.setTextureOffset(6, 70).addBox(-2.0F, 0.7F, 16.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r200.setTextureOffset(0, 70).addBox(-29.0F, 0.7F, 16.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r200.setTextureOffset(6, 102).addBox(-3.0F, 0.7F, 19.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r200.setTextureOffset(0, 102).addBox(-28.0F, 0.7F, 19.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r200.setTextureOffset(28, 102).addBox(-27.0F, 0.7F, 22.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r200.setTextureOffset(20, 102).addBox(-4.0F, 0.7F, 22.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		side6 = new ModelRenderer(this);
		side6.setRotationPoint(0.0F, -25.8315F, 0.0F);
		root.addChild(side6);
		setRotationAngle(side6, 0.0F, 1.0472F, 0.0F);
		side6.setTextureOffset(337, 74).addBox(-32.0F, -3.8824F, 53.6609F, 64.0F, 7.0F, 1.0F, 0.0F, false);

		cube_r201 = new ModelRenderer(this);
		cube_r201.setRotationPoint(40.8391F, -4.5746F, 70.7354F);
		side6.addChild(cube_r201);
		setRotationAngle(cube_r201, 0.0F, 0.5236F, 0.0F);
		cube_r201.setTextureOffset(172, 170).addBox(-1.0F, -0.5F, -20.5F, 2.0F, 5.0F, 1.0F, 0.0F, false);

		cube_r202 = new ModelRenderer(this);
		cube_r202.setRotationPoint(36.0358F, -1.5446F, 62.4159F);
		side6.addChild(cube_r202);
		setRotationAngle(cube_r202, -0.3142F, 0.5236F, 0.0F);
		cube_r202.setTextureOffset(136, 296).addBox(-1.0F, -0.3F, -10.5F, 2.0F, 1.0F, 16.0F, 0.0F, false);

		cube_r203 = new ModelRenderer(this);
		cube_r203.setRotationPoint(0.0F, 0.0F, 0.0F);
		side6.addChild(cube_r203);
		setRotationAngle(cube_r203, -0.3491F, 0.0F, 0.0F);
		cube_r203.setTextureOffset(165, 96).addBox(-33.0F, -23.0014F, 49.0969F, 66.0F, 1.0F, 4.0F, 0.0F, false);
		cube_r203.setTextureOffset(165, 26).addBox(-33.5F, -23.0014F, 53.0969F, 14.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r203.setTextureOffset(16, 507).addBox(-35.0F, -23.0014F, 55.0969F, 15.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r203.setTextureOffset(16, 504).addBox(-35.9F, -23.0014F, 57.0969F, 15.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r203.setTextureOffset(130, 493).addBox(-36.55F, -23.0014F, 59.0969F, 15.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r203.setTextureOffset(165, 164).addBox(-38.0F, -23.0014F, 61.0969F, 16.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r203.setTextureOffset(165, 29).addBox(19.5F, -23.0014F, 53.0969F, 14.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r203.setTextureOffset(508, 144).addBox(20.0F, -23.0014F, 55.0969F, 15.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r203.setTextureOffset(509, 423).addBox(20.9F, -23.0014F, 57.0969F, 15.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r203.setTextureOffset(202, 452).addBox(21.55F, -23.0014F, 59.0969F, 15.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r203.setTextureOffset(499, 426).addBox(22.0F, -23.0014F, 61.0969F, 16.0F, 1.0F, 2.0F, 0.0F, false);

		x_button = new ModelRenderer(this);
		x_button.setRotationPoint(21.134F, -6.32F, 48.1665F);
		side6.addChild(x_button);
		setRotationAngle(x_button, -0.2618F, 0.0F, 0.0F);
		x_button.setTextureOffset(284, 409).addBox(-4.0F, -0.68F, 3.0656F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		x_button.setTextureOffset(515, 227).addBox(-4.0F, -0.08F, -0.9344F, 8.0F, 1.0F, 4.0F, 0.0F, false);

		cube_r204 = new ModelRenderer(this);
		cube_r204.setRotationPoint(1.6797F, 0.42F, -0.3683F);
		x_button.addChild(cube_r204);
		setRotationAngle(cube_r204, 0.0F, -1.0472F, 0.0F);
		cube_r204.setTextureOffset(515, 50).addBox(-4.5F, -0.5F, -1.3905F, 8.0F, 1.0F, 4.0F, 0.0F, false);
		cube_r204.setTextureOffset(408, 221).addBox(-4.5F, -1.1F, -2.3905F, 8.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r205 = new ModelRenderer(this);
		cube_r205.setRotationPoint(-0.5882F, 0.42F, -0.3683F);
		x_button.addChild(cube_r205);
		setRotationAngle(cube_r205, -3.1416F, -1.0472F, 3.1416F);
		cube_r205.setTextureOffset(515, 222).addBox(-3.9542F, -0.5F, -1.6642F, 8.0F, 1.0F, 4.0F, 0.0F, false);

		cube_r206 = new ModelRenderer(this);
		cube_r206.setRotationPoint(-1.4542F, -0.18F, -7.7965F);
		x_button.addChild(cube_r206);
		setRotationAngle(cube_r206, 0.0F, 0.0F, 0.0F);
		cube_r206.setTextureOffset(74, 378).addBox(-0.0458F, -0.5F, 2.3358F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r207 = new ModelRenderer(this);
		cube_r207.setRotationPoint(-6.9542F, -0.18F, 1.7298F);
		x_button.addChild(cube_r207);
		setRotationAngle(cube_r207, 0.0F, -1.0472F, 0.0F);
		cube_r207.setTextureOffset(24, 130).addBox(0.5F, -0.5F, -2.3905F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r208 = new ModelRenderer(this);
		cube_r208.setRotationPoint(8.0458F, -0.18F, 1.7298F);
		x_button.addChild(cube_r208);
		setRotationAngle(cube_r208, -3.1416F, -1.0472F, 3.1416F);
		cube_r208.setTextureOffset(333, 437).addBox(1.0458F, -0.5F, 2.3358F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r209 = new ModelRenderer(this);
		cube_r209.setRotationPoint(-0.5882F, -0.18F, -0.3683F);
		x_button.addChild(cube_r209);
		setRotationAngle(cube_r209, -3.1416F, -1.0472F, 3.1416F);
		cube_r209.setTextureOffset(288, 364).addBox(-3.9542F, -0.5F, 2.3358F, 8.0F, 1.0F, 1.0F, 0.0F, false);

		x_button_light = new ModelRenderer(this);
		x_button_light.setRotationPoint(0.0F, -0.68F, 0.0656F);
		x_button.addChild(x_button_light);
		

		cube_r210 = new ModelRenderer(this);
		cube_r210.setRotationPoint(0.0F, 0.0F, 0.0F);
		x_button_light.addChild(cube_r210);
		setRotationAngle(cube_r210, 0.0F, 0.7854F, 0.0F);
		cube_r210.setTextureOffset(391, 355).addBox(-1.3F, -0.5F, -1.7F, 3.0F, 2.0F, 3.0F, 0.0F, false);

		y_button = new ModelRenderer(this);
		y_button.setRotationPoint(9.134F, -7.32F, 48.1665F);
		side6.addChild(y_button);
		setRotationAngle(y_button, -2.7925F, 0.0F, -3.1416F);
		y_button.setTextureOffset(344, 189).addBox(-4.0F, -0.68F, 3.0656F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		y_button.setTextureOffset(515, 45).addBox(-4.0F, -0.08F, -0.9344F, 8.0F, 1.0F, 4.0F, 0.0F, false);

		cube_r211 = new ModelRenderer(this);
		cube_r211.setRotationPoint(1.6797F, 0.42F, -0.3683F);
		y_button.addChild(cube_r211);
		setRotationAngle(cube_r211, 0.0F, -1.0472F, 0.0F);
		cube_r211.setTextureOffset(514, 277).addBox(-4.5F, -0.5F, -1.3905F, 8.0F, 1.0F, 4.0F, 0.0F, false);
		cube_r211.setTextureOffset(337, 53).addBox(-4.5F, -1.1F, -2.3905F, 8.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r212 = new ModelRenderer(this);
		cube_r212.setRotationPoint(-0.5882F, 0.42F, -0.3683F);
		y_button.addChild(cube_r212);
		setRotationAngle(cube_r212, -3.1416F, -1.0472F, 3.1416F);
		cube_r212.setTextureOffset(515, 40).addBox(-3.9542F, -0.5F, -1.6642F, 8.0F, 1.0F, 4.0F, 0.0F, false);

		cube_r213 = new ModelRenderer(this);
		cube_r213.setRotationPoint(-1.4542F, -0.18F, -7.7965F);
		y_button.addChild(cube_r213);
		setRotationAngle(cube_r213, 0.0F, 0.0F, 0.0F);
		cube_r213.setTextureOffset(345, 93).addBox(-0.0458F, -0.5F, 2.3358F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r214 = new ModelRenderer(this);
		cube_r214.setRotationPoint(-6.9542F, -0.18F, 1.7298F);
		y_button.addChild(cube_r214);
		setRotationAngle(cube_r214, 0.0F, -1.0472F, 0.0F);
		cube_r214.setTextureOffset(82, 372).addBox(0.5F, -0.5F, -2.3905F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r215 = new ModelRenderer(this);
		cube_r215.setRotationPoint(8.0458F, -0.18F, 1.7298F);
		y_button.addChild(cube_r215);
		setRotationAngle(cube_r215, -3.1416F, -1.0472F, 3.1416F);
		cube_r215.setTextureOffset(333, 376).addBox(1.0458F, -0.5F, 2.3358F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r216 = new ModelRenderer(this);
		cube_r216.setRotationPoint(-0.5882F, -0.18F, -0.3683F);
		y_button.addChild(cube_r216);
		setRotationAngle(cube_r216, -3.1416F, -1.0472F, 3.1416F);
		cube_r216.setTextureOffset(311, 130).addBox(-3.9542F, -0.5F, 2.3358F, 8.0F, 1.0F, 1.0F, 0.0F, false);

		y_button_light = new ModelRenderer(this);
		y_button_light.setRotationPoint(0.0F, -0.68F, 0.0656F);
		y_button.addChild(y_button_light);
		

		cube_r217 = new ModelRenderer(this);
		cube_r217.setRotationPoint(0.0F, 0.0F, 0.0F);
		y_button_light.addChild(cube_r217);
		setRotationAngle(cube_r217, 0.0F, 0.7854F, 0.0F);
		cube_r217.setTextureOffset(223, 445).addBox(-1.3F, -0.5F, -1.7F, 3.0F, 2.0F, 3.0F, 0.0F, false);

		z_button = new ModelRenderer(this);
		z_button.setRotationPoint(-2.866F, -6.32F, 48.1665F);
		side6.addChild(z_button);
		setRotationAngle(z_button, -0.1309F, 0.0F, 0.0F);
		z_button.setTextureOffset(172, 188).addBox(-4.0F, -0.68F, 3.0656F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		z_button.setTextureOffset(74, 503).addBox(-4.0F, -0.08F, -0.9344F, 8.0F, 1.0F, 4.0F, 0.0F, false);

		cube_r218 = new ModelRenderer(this);
		cube_r218.setRotationPoint(1.6797F, 0.42F, -0.3683F);
		z_button.addChild(cube_r218);
		setRotationAngle(cube_r218, 0.0F, -1.0472F, 0.0F);
		cube_r218.setTextureOffset(0, 375).addBox(-4.5F, -0.5F, -1.3905F, 8.0F, 1.0F, 4.0F, 0.0F, false);
		cube_r218.setTextureOffset(0, 188).addBox(-4.5F, -1.1F, -2.3905F, 8.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r219 = new ModelRenderer(this);
		cube_r219.setRotationPoint(-0.5882F, 0.42F, -0.3683F);
		z_button.addChild(cube_r219);
		setRotationAngle(cube_r219, -3.1416F, -1.0472F, 3.1416F);
		cube_r219.setTextureOffset(74, 498).addBox(-3.9542F, -0.5F, -1.6642F, 8.0F, 1.0F, 4.0F, 0.0F, false);

		cube_r220 = new ModelRenderer(this);
		cube_r220.setRotationPoint(-1.4542F, -0.18F, -7.7965F);
		z_button.addChild(cube_r220);
		setRotationAngle(cube_r220, 0.0F, 0.0F, 0.0F);
		cube_r220.setTextureOffset(177, 142).addBox(-0.0458F, -0.5F, 2.3358F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r221 = new ModelRenderer(this);
		cube_r221.setRotationPoint(-6.9542F, -0.18F, 1.7298F);
		z_button.addChild(cube_r221);
		setRotationAngle(cube_r221, 0.0F, -1.0472F, 0.0F);
		cube_r221.setTextureOffset(177, 151).addBox(0.5F, -0.5F, -2.3905F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r222 = new ModelRenderer(this);
		cube_r222.setRotationPoint(8.0458F, -0.18F, 1.7298F);
		z_button.addChild(cube_r222);
		setRotationAngle(cube_r222, -3.1416F, -1.0472F, 3.1416F);
		cube_r222.setTextureOffset(331, 337).addBox(1.0458F, -0.5F, 2.3358F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r223 = new ModelRenderer(this);
		cube_r223.setRotationPoint(-0.5882F, -0.18F, -0.3683F);
		z_button.addChild(cube_r223);
		setRotationAngle(cube_r223, -3.1416F, -1.0472F, 3.1416F);
		cube_r223.setTextureOffset(165, 154).addBox(-3.9542F, -0.5F, 2.3358F, 8.0F, 1.0F, 1.0F, 0.0F, false);

		z_button_light = new ModelRenderer(this);
		z_button_light.setRotationPoint(0.0F, -0.68F, 0.0656F);
		z_button.addChild(z_button_light);
		

		cube_r224 = new ModelRenderer(this);
		cube_r224.setRotationPoint(0.0F, 0.0F, 0.0F);
		z_button_light.addChild(cube_r224);
		setRotationAngle(cube_r224, 0.0F, 0.7854F, 0.0F);
		cube_r224.setTextureOffset(303, 443).addBox(-1.3F, -0.5F, -1.7F, 3.0F, 2.0F, 3.0F, 0.0F, false);

		increment_button = new ModelRenderer(this);
		increment_button.setRotationPoint(-13.866F, -7.32F, 48.1665F);
		side6.addChild(increment_button);
		setRotationAngle(increment_button, -2.7925F, 0.0F, -3.1416F);
		increment_button.setTextureOffset(198, 426).addBox(-4.0F, -0.68F, 3.0656F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		increment_button.setTextureOffset(387, 515).addBox(-4.0F, -0.08F, -0.9344F, 8.0F, 1.0F, 4.0F, 0.0F, false);

		cube_r225 = new ModelRenderer(this);
		cube_r225.setRotationPoint(1.6797F, 0.42F, -0.3683F);
		increment_button.addChild(cube_r225);
		setRotationAngle(cube_r225, 0.0F, -1.0472F, 0.0F);
		cube_r225.setTextureOffset(515, 232).addBox(-4.5F, -0.5F, -1.3905F, 8.0F, 1.0F, 4.0F, 0.0F, false);
		cube_r225.setTextureOffset(333, 423).addBox(-4.5F, -1.1F, -2.3905F, 8.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r226 = new ModelRenderer(this);
		cube_r226.setRotationPoint(-0.5882F, 0.42F, -0.3683F);
		increment_button.addChild(cube_r226);
		setRotationAngle(cube_r226, -3.1416F, -1.0472F, 3.1416F);
		cube_r226.setTextureOffset(333, 355).addBox(-3.9542F, -0.5F, -1.6642F, 8.0F, 1.0F, 4.0F, 0.0F, false);

		cube_r227 = new ModelRenderer(this);
		cube_r227.setRotationPoint(-1.4542F, -0.18F, -7.7965F);
		increment_button.addChild(cube_r227);
		setRotationAngle(cube_r227, 0.0F, 0.0F, 0.0F);
		cube_r227.setTextureOffset(165, 108).addBox(-0.0458F, -0.5F, 2.3358F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r228 = new ModelRenderer(this);
		cube_r228.setRotationPoint(-6.9542F, -0.18F, 1.7298F);
		increment_button.addChild(cube_r228);
		setRotationAngle(cube_r228, 0.0F, -1.0472F, 0.0F);
		cube_r228.setTextureOffset(165, 117).addBox(0.5F, -0.5F, -2.3905F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r229 = new ModelRenderer(this);
		cube_r229.setRotationPoint(8.0458F, -0.18F, 1.7298F);
		increment_button.addChild(cube_r229);
		setRotationAngle(cube_r229, -3.1416F, -1.0472F, 3.1416F);
		cube_r229.setTextureOffset(262, 435).addBox(1.0458F, -0.5F, 2.3358F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r230 = new ModelRenderer(this);
		cube_r230.setRotationPoint(-0.5882F, -0.18F, -0.3683F);
		increment_button.addChild(cube_r230);
		setRotationAngle(cube_r230, -3.1416F, -1.0472F, 3.1416F);
		cube_r230.setTextureOffset(165, 120).addBox(-3.9542F, -0.5F, 2.3358F, 8.0F, 1.0F, 1.0F, 0.0F, false);

		increment_button_light = new ModelRenderer(this);
		increment_button_light.setRotationPoint(0.0F, -0.68F, 0.0656F);
		increment_button.addChild(increment_button_light);
		

		cube_r231 = new ModelRenderer(this);
		cube_r231.setRotationPoint(0.0F, 0.0F, 0.0F);
		increment_button_light.addChild(cube_r231);
		setRotationAngle(cube_r231, 0.0F, 0.7854F, 0.0F);
		cube_r231.setTextureOffset(248, 313).addBox(-1.3F, -0.5F, -1.7F, 3.0F, 2.0F, 3.0F, 0.0F, false);

		buttons_cables = new ModelRenderer(this);
		buttons_cables.setRotationPoint(0.0F, 0.0F, 0.0F);
		side6.addChild(buttons_cables);
		

		cube_r232 = new ModelRenderer(this);
		cube_r232.setRotationPoint(-8.5F, -2.1758F, 46.6547F);
		buttons_cables.addChild(cube_r232);
		setRotationAngle(cube_r232, -0.2411F, -0.2549F, -0.798F);
		cube_r232.setTextureOffset(0, 0).addBox(-4.6F, -5.4F, -5.0F, 5.0F, 12.0F, 10.0F, 0.0F, false);

		cube_r233 = new ModelRenderer(this);
		cube_r233.setRotationPoint(-16.5F, -2.1758F, 46.6547F);
		buttons_cables.addChild(cube_r233);
		setRotationAngle(cube_r233, -0.2622F, 0.2332F, 0.7109F);
		cube_r233.setTextureOffset(0, 136).addBox(-1.5F, -4.0F, -5.0F, 4.0F, 11.0F, 10.0F, 0.0F, false);

		cube_r234 = new ModelRenderer(this);
		cube_r234.setRotationPoint(2.5F, -2.1758F, 46.6547F);
		buttons_cables.addChild(cube_r234);
		setRotationAngle(cube_r234, -0.2411F, -0.2549F, -0.798F);
		cube_r234.setTextureOffset(0, 34).addBox(-4.6F, -5.4F, -5.0F, 5.0F, 12.0F, 10.0F, 0.0F, false);

		cube_r235 = new ModelRenderer(this);
		cube_r235.setRotationPoint(-5.5F, -2.1758F, 46.6547F);
		buttons_cables.addChild(cube_r235);
		setRotationAngle(cube_r235, -0.2622F, 0.2332F, 0.7109F);
		cube_r235.setTextureOffset(148, 254).addBox(-1.5F, -4.0F, -5.0F, 4.0F, 11.0F, 10.0F, 0.0F, false);

		cube_r236 = new ModelRenderer(this);
		cube_r236.setRotationPoint(14.5F, -2.1758F, 46.6547F);
		buttons_cables.addChild(cube_r236);
		setRotationAngle(cube_r236, -0.2411F, -0.2549F, -0.798F);
		cube_r236.setTextureOffset(0, 68).addBox(-4.6F, -5.4F, -5.0F, 5.0F, 12.0F, 10.0F, 0.0F, false);

		cube_r237 = new ModelRenderer(this);
		cube_r237.setRotationPoint(6.5F, -2.1758F, 46.6547F);
		buttons_cables.addChild(cube_r237);
		setRotationAngle(cube_r237, -0.2622F, 0.2332F, 0.7109F);
		cube_r237.setTextureOffset(288, 337).addBox(-1.5F, -4.0F, -5.0F, 4.0F, 11.0F, 10.0F, 0.0F, false);

		cube_r238 = new ModelRenderer(this);
		cube_r238.setRotationPoint(17.5F, -2.1758F, 46.6547F);
		buttons_cables.addChild(cube_r238);
		setRotationAngle(cube_r238, -0.2622F, 0.2332F, 0.7109F);
		cube_r238.setTextureOffset(349, 498).addBox(-1.5F, -4.0F, -5.0F, 4.0F, 11.0F, 10.0F, 0.0F, false);

		cube_r239 = new ModelRenderer(this);
		cube_r239.setRotationPoint(25.5F, -2.1758F, 46.6547F);
		buttons_cables.addChild(cube_r239);
		setRotationAngle(cube_r239, -0.2411F, -0.2549F, -0.798F);
		cube_r239.setTextureOffset(0, 102).addBox(-4.6F, -5.4F, -5.0F, 5.0F, 12.0F, 10.0F, 0.0F, false);

		vent1 = new ModelRenderer(this);
		vent1.setRotationPoint(34.5F, -1.4019F, 63.3999F);
		side6.addChild(vent1);
		vent1.setTextureOffset(440, 185).addBox(-11.0F, -0.6F, -2.0F, 7.0F, 1.0F, 3.0F, 0.0F, false);
		vent1.setTextureOffset(0, 102).addBox(-5.0F, -5.6F, -3.0F, 1.0F, 5.0F, 4.0F, 0.0F, false);
		vent1.setTextureOffset(198, 419).addBox(-11.0F, -5.2319F, -4.7588F, 7.0F, 5.0F, 2.0F, 0.0F, false);
		vent1.setTextureOffset(0, 68).addBox(-11.0F, -5.6F, -3.0F, 1.0F, 5.0F, 4.0F, 0.0F, false);
		vent1.setTextureOffset(462, 251).addBox(-11.0F, -6.6F, -1.0F, 7.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r240 = new ModelRenderer(this);
		cube_r240.setRotationPoint(-2.0F, -1.5595F, -0.2296F);
		vent1.addChild(cube_r240);
		setRotationAngle(cube_r240, 0.3491F, 0.0F, 0.0F);
		cube_r240.setTextureOffset(167, 450).addBox(-9.0F, -5.0F, -3.0F, 7.0F, 1.0F, 4.0F, 0.0F, false);

		cube_r241 = new ModelRenderer(this);
		cube_r241.setRotationPoint(-6.5F, -0.2308F, -1.0897F);
		vent1.addChild(cube_r241);
		setRotationAngle(cube_r241, -0.6109F, 0.0F, 0.0F);
		cube_r241.setTextureOffset(15, 5).addBox(-3.5F, -1.5F, -3.5F, 5.0F, 0.0F, 5.0F, 0.0F, false);

		vent2 = new ModelRenderer(this);
		vent2.setRotationPoint(-19.5F, -1.4019F, 63.3999F);
		side6.addChild(vent2);
		vent2.setTextureOffset(139, 416).addBox(-11.0F, -0.6F, -2.0F, 7.0F, 1.0F, 3.0F, 0.0F, false);
		vent2.setTextureOffset(0, 34).addBox(-5.0F, -5.6F, -3.0F, 1.0F, 5.0F, 4.0F, 0.0F, false);
		vent2.setTextureOffset(198, 412).addBox(-11.0F, -5.2319F, -4.7588F, 7.0F, 5.0F, 2.0F, 0.0F, false);
		vent2.setTextureOffset(0, 0).addBox(-11.0F, -5.6F, -3.0F, 1.0F, 5.0F, 4.0F, 0.0F, false);
		vent2.setTextureOffset(462, 248).addBox(-11.0F, -6.6F, -1.0F, 7.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r242 = new ModelRenderer(this);
		cube_r242.setRotationPoint(-8.5F, -2.0331F, -1.0485F);
		vent2.addChild(cube_r242);
		setRotationAngle(cube_r242, -0.6109F, 0.0F, 0.0F);
		cube_r242.setTextureOffset(15, 0).addBox(-1.5F, 0.0F, -2.5F, 5.0F, 0.0F, 5.0F, 0.0F, false);

		cube_r243 = new ModelRenderer(this);
		cube_r243.setRotationPoint(-2.0F, -1.5595F, -0.2296F);
		vent2.addChild(cube_r243);
		setRotationAngle(cube_r243, 0.3491F, 0.0F, 0.0F);
		cube_r243.setTextureOffset(248, 449).addBox(-9.0F, -5.0F, -3.0F, 7.0F, 1.0F, 4.0F, 0.0F, false);

		controls6 = new ModelRenderer(this);
		controls6.setRotationPoint(0.0F, 2.8315F, 67.55F);
		side6.addChild(controls6);
		setRotationAngle(controls6, 0.0436F, 0.0F, 0.0F);
		

		cube_r244 = new ModelRenderer(this);
		cube_r244.setRotationPoint(-1.0F, -1.2817F, -0.5977F);
		controls6.addChild(cube_r244);
		setRotationAngle(cube_r244, -0.3491F, 0.0F, 0.0F);
		cube_r244.setTextureOffset(165, 141).addBox(17.0F, -1.8F, -5.5F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r244.setTextureOffset(158, 377).addBox(9.0F, -1.8F, -5.5F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r244.setTextureOffset(158, 374).addBox(13.0F, -1.8F, -5.5F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r244.setTextureOffset(467, 332).addBox(8.5F, -0.8F, -6.0F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		cube_r244.setTextureOffset(363, 463).addBox(12.5F, -0.8F, -6.0F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		cube_r244.setTextureOffset(465, 217).addBox(16.5F, -0.8F, -6.0F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		cube_r244.setTextureOffset(330, 9).addBox(6.5F, 0.4F, -0.9F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r244.setTextureOffset(330, 7).addBox(5.0F, 0.4F, -0.9F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r244.setTextureOffset(0, 361).addBox(6.5F, 0.4F, -2.9F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r244.setTextureOffset(310, 360).addBox(5.0F, 0.4F, -2.9F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r244.setTextureOffset(176, 330).addBox(6.5F, 0.4F, -4.9F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r244.setTextureOffset(330, 157).addBox(5.0F, 0.4F, -4.9F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r244.setTextureOffset(248, 331).addBox(6.5F, 0.4F, -6.9F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r244.setTextureOffset(251, 330).addBox(5.0F, 0.4F, -6.9F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r244.setTextureOffset(176, 332).addBox(5.0F, 0.4F, -8.9F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r244.setTextureOffset(251, 332).addBox(6.5F, 0.4F, -8.9F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r244.setTextureOffset(352, 476).addBox(-9.5F, 0.0F, -6.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		cube_r244.setTextureOffset(476, 450).addBox(-13.5F, 0.0F, -6.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		cube_r244.setTextureOffset(325, 480).addBox(-17.5F, 0.0F, -6.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);

		lights_group4 = new ModelRenderer(this);
		lights_group4.setRotationPoint(-1.0F, -1.2817F, -0.5977F);
		controls6.addChild(lights_group4);
		

		cube_r245 = new ModelRenderer(this);
		cube_r245.setRotationPoint(0.0F, 0.0F, 0.0F);
		lights_group4.addChild(cube_r245);
		setRotationAngle(cube_r245, -0.3491F, 0.0F, 0.0F);
		cube_r245.setTextureOffset(158, 380).addBox(19.5F, 0.3F, -1.5F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r245.setTextureOffset(0, 390).addBox(-19.5F, 0.3F, -1.5F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r245.setTextureOffset(176, 336).addBox(15.5F, 0.7F, -2.7F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r245.setTextureOffset(176, 334).addBox(11.5F, 0.7F, -2.7F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r245.setTextureOffset(337, 84).addBox(-10.5F, 0.7F, -2.7F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r245.setTextureOffset(337, 115).addBox(-14.5F, 0.7F, -2.7F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		stabilizers = new ModelRenderer(this);
		stabilizers.setRotationPoint(-1.0F, -1.2817F, -0.5977F);
		controls6.addChild(stabilizers);
		

		cube_r246 = new ModelRenderer(this);
		cube_r246.setRotationPoint(0.0F, 0.0F, 0.0F);
		stabilizers.addChild(cube_r246);
		setRotationAngle(cube_r246, -0.3491F, 0.0F, 0.0F);
		cube_r246.setTextureOffset(165, 111).addBox(2.0F, 0.2F, -7.5F, 2.0F, 1.0F, 8.0F, 0.0F, false);
		cube_r246.setTextureOffset(165, 136).addBox(-0.5F, 0.2F, -7.5F, 2.0F, 1.0F, 8.0F, 0.0F, false);
		cube_r246.setTextureOffset(165, 145).addBox(-3.0F, 0.2F, -7.5F, 2.0F, 1.0F, 8.0F, 0.0F, false);
		cube_r246.setTextureOffset(0, 170).addBox(-5.5F, 0.2F, -7.5F, 2.0F, 1.0F, 8.0F, 0.0F, false);

		stabilizers_lights = new ModelRenderer(this);
		stabilizers_lights.setRotationPoint(0.0F, 0.0F, 0.0F);
		stabilizers.addChild(stabilizers_lights);
		

		cube_r247 = new ModelRenderer(this);
		cube_r247.setRotationPoint(0.0F, 0.0F, 0.0F);
		stabilizers_lights.addChild(cube_r247);
		setRotationAngle(cube_r247, -0.3491F, 0.0F, 0.0F);
		cube_r247.setTextureOffset(337, 68).addBox(2.5F, 0.1F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r247.setTextureOffset(347, 60).addBox(0.0F, 0.1F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r247.setTextureOffset(337, 70).addBox(-2.5F, 0.1F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r247.setTextureOffset(337, 82).addBox(-5.0F, 0.1F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		rotor = new ModelRenderer(this);
		rotor.setRotationPoint(0.0F, 6.0F, 0.0F);
		root.addChild(rotor);
		rotor.setTextureOffset(165, 1).addBox(-33.0F, -32.0F, -57.1577F, 66.0F, 1.0F, 33.0F, 0.0F, false);
		rotor.setTextureOffset(479, 71).addBox(-13.0F, -6.5F, 18.5167F, 26.0F, 6.0F, 4.0F, 0.0F, false);
		rotor.setTextureOffset(391, 306).addBox(-15.0F, -37.0F, 17.9808F, 30.0F, 26.0F, 8.0F, 0.0F, false);
		rotor.setTextureOffset(303, 496).addBox(-11.0F, -11.0F, 18.0526F, 22.0F, 15.0F, 1.0F, 0.0F, false);
		rotor.setTextureOffset(494, 286).addBox(-6.5F, -61.0F, -0.7417F, 13.0F, 6.0F, 12.0F, 0.0F, false);
		rotor.setTextureOffset(48, 480).addBox(-6.5F, -176.0F, -0.7417F, 13.0F, 6.0F, 12.0F, 0.0F, false);
		rotor.setTextureOffset(325, 337).addBox(2.5F, -170.0F, -1.0F, 2.0F, 109.0F, 2.0F, 0.25F, false);
		rotor.setTextureOffset(317, 337).addBox(-4.5F, -170.0F, -1.0F, 2.0F, 109.0F, 2.0F, 0.25F, false);

		cube_r248 = new ModelRenderer(this);
		cube_r248.setRotationPoint(9.384F, -171.0F, 4.2631F);
		rotor.addChild(cube_r248);
		setRotationAngle(cube_r248, 0.0F, 1.0472F, 0.0F);
		cube_r248.setTextureOffset(486, 481).addBox(-7.5F, -5.0F, -11.0F, 13.0F, 6.0F, 12.0F, 0.0F, false);
		cube_r248.setTextureOffset(487, 10).addBox(-7.5F, 110.0F, -11.0F, 13.0F, 6.0F, 12.0F, 0.0F, false);

		cube_r249 = new ModelRenderer(this);
		cube_r249.setRotationPoint(-8.384F, -171.0F, 5.9952F);
		rotor.addChild(cube_r249);
		setRotationAngle(cube_r249, 0.0F, -1.0472F, 0.0F);
		cube_r249.setTextureOffset(0, 486).addBox(-7.5F, -5.0F, -11.0F, 13.0F, 6.0F, 12.0F, 0.0F, false);
		cube_r249.setTextureOffset(417, 493).addBox(-7.5F, 110.0F, -11.0F, 13.0F, 6.0F, 12.0F, 0.0F, false);

		cube_r250 = new ModelRenderer(this);
		cube_r250.setRotationPoint(-9.384F, -171.0F, -4.2631F);
		rotor.addChild(cube_r250);
		setRotationAngle(cube_r250, -3.1416F, -1.0472F, 3.1416F);
		cube_r250.setTextureOffset(485, 452).addBox(-7.5F, -5.0F, -11.0F, 13.0F, 6.0F, 12.0F, 0.0F, false);

		cube_r251 = new ModelRenderer(this);
		cube_r251.setRotationPoint(-1.0F, -171.0F, -10.2583F);
		rotor.addChild(cube_r251);
		setRotationAngle(cube_r251, -3.1416F, 0.0F, 3.1416F);
		cube_r251.setTextureOffset(484, 108).addBox(-7.5F, -5.0F, -11.0F, 13.0F, 6.0F, 12.0F, 0.0F, false);

		cube_r252 = new ModelRenderer(this);
		cube_r252.setRotationPoint(8.384F, -171.0F, -5.9952F);
		rotor.addChild(cube_r252);
		setRotationAngle(cube_r252, -3.1416F, 1.0472F, 3.1416F);
		cube_r252.setTextureOffset(482, 384).addBox(-7.5F, -5.0F, -11.0F, 13.0F, 6.0F, 12.0F, 0.0F, false);

		cube_r253 = new ModelRenderer(this);
		cube_r253.setRotationPoint(-9.384F, -56.0F, -4.2631F);
		rotor.addChild(cube_r253);
		setRotationAngle(cube_r253, -3.1416F, -1.0472F, 3.1416F);
		cube_r253.setTextureOffset(493, 126).addBox(-7.5F, -5.0F, -11.0F, 13.0F, 6.0F, 12.0F, 0.0F, false);

		cube_r254 = new ModelRenderer(this);
		cube_r254.setRotationPoint(-1.0F, -56.0F, -10.2583F);
		rotor.addChild(cube_r254);
		setRotationAngle(cube_r254, -3.1416F, 0.0F, 3.1416F);
		cube_r254.setTextureOffset(491, 190).addBox(-7.5F, -5.0F, -11.0F, 13.0F, 6.0F, 12.0F, 0.0F, false);

		cube_r255 = new ModelRenderer(this);
		cube_r255.setRotationPoint(8.384F, -56.0F, -5.9952F);
		rotor.addChild(cube_r255);
		setRotationAngle(cube_r255, -3.1416F, 1.0472F, 3.1416F);
		cube_r255.setTextureOffset(253, 489).addBox(-7.5F, -5.0F, -11.0F, 13.0F, 6.0F, 12.0F, 0.0F, false);

		cube_r256 = new ModelRenderer(this);
		cube_r256.setRotationPoint(9.134F, -37.0F, 17.8205F);
		rotor.addChild(cube_r256);
		setRotationAngle(cube_r256, 0.0F, 0.5236F, 0.0F);
		cube_r256.setTextureOffset(372, 312).addBox(-2.0F, -3.0F, -1.0F, 6.0F, 3.0F, 3.0F, 0.0F, false);
		cube_r256.setTextureOffset(166, 199).addBox(-1.0F, -6.0F, -1.0F, 4.0F, 3.0F, 3.0F, 0.0F, false);

		cube_r257 = new ModelRenderer(this);
		cube_r257.setRotationPoint(20.0F, -37.0F, 1.0F);
		rotor.addChild(cube_r257);
		setRotationAngle(cube_r257, 0.0F, 1.5708F, 0.0F);
		cube_r257.setTextureOffset(50, 450).addBox(-2.0F, -3.0F, -1.0F, 6.0F, 3.0F, 3.0F, 0.0F, false);
		cube_r257.setTextureOffset(166, 214).addBox(-1.0F, -6.0F, -1.0F, 4.0F, 3.0F, 3.0F, 0.0F, false);

		cube_r258 = new ModelRenderer(this);
		cube_r258.setRotationPoint(10.866F, -37.0F, -16.8205F);
		rotor.addChild(cube_r258);
		setRotationAngle(cube_r258, -3.1416F, 0.5236F, 3.1416F);
		cube_r258.setTextureOffset(451, 392).addBox(-2.0F, -3.0F, -1.0F, 6.0F, 3.0F, 3.0F, 0.0F, false);
		cube_r258.setTextureOffset(166, 222).addBox(-1.0F, -6.0F, -1.0F, 4.0F, 3.0F, 3.0F, 0.0F, false);

		cube_r259 = new ModelRenderer(this);
		cube_r259.setRotationPoint(-9.134F, -37.0F, -17.8205F);
		rotor.addChild(cube_r259);
		setRotationAngle(cube_r259, -3.1416F, -0.5236F, 3.1416F);
		cube_r259.setTextureOffset(451, 398).addBox(-2.0F, -3.0F, -1.0F, 6.0F, 3.0F, 3.0F, 0.0F, false);
		cube_r259.setTextureOffset(0, 228).addBox(-1.0F, -6.0F, -1.0F, 4.0F, 3.0F, 3.0F, 0.0F, false);

		cube_r260 = new ModelRenderer(this);
		cube_r260.setRotationPoint(-20.0F, -37.0F, -1.0F);
		rotor.addChild(cube_r260);
		setRotationAngle(cube_r260, 0.0F, -1.5708F, 0.0F);
		cube_r260.setTextureOffset(460, 27).addBox(-2.0F, -3.0F, -1.0F, 6.0F, 3.0F, 3.0F, 0.0F, false);
		cube_r260.setTextureOffset(166, 228).addBox(-1.0F, -6.0F, -1.0F, 4.0F, 3.0F, 3.0F, 0.0F, false);

		cube_r261 = new ModelRenderer(this);
		cube_r261.setRotationPoint(-10.866F, -37.0F, 16.8205F);
		rotor.addChild(cube_r261);
		setRotationAngle(cube_r261, 0.0F, -0.5236F, 0.0F);
		cube_r261.setTextureOffset(462, 208).addBox(-2.0F, -3.0F, -1.0F, 6.0F, 3.0F, 3.0F, 0.0F, false);
		cube_r261.setTextureOffset(166, 254).addBox(-1.0F, -6.0F, -1.0F, 4.0F, 3.0F, 3.0F, 0.0F, false);

		cube_r262 = new ModelRenderer(this);
		cube_r262.setRotationPoint(17.2514F, -44.0018F, 3.6093F);
		rotor.addChild(cube_r262);
		setRotationAngle(cube_r262, -0.2618F, 1.0472F, 0.0F);
		cube_r262.setTextureOffset(451, 442).addBox(-7.5F, -17.1F, -3.8F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		cube_r262.setTextureOffset(156, 275).addBox(-8.5F, -10.1F, -4.8F, 6.0F, 12.0F, 6.0F, 0.0F, false);

		cube_r263 = new ModelRenderer(this);
		cube_r263.setRotationPoint(11.7514F, -44.0018F, -13.1355F);
		rotor.addChild(cube_r263);
		setRotationAngle(cube_r263, 2.8798F, 1.0472F, 3.1416F);
		cube_r263.setTextureOffset(80, 453).addBox(-7.5F, -17.1F, -3.8F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		cube_r263.setTextureOffset(333, 337).addBox(-8.5F, -10.1F, -4.8F, 6.0F, 12.0F, 6.0F, 0.0F, false);

		cube_r264 = new ModelRenderer(this);
		cube_r264.setRotationPoint(-5.5F, -44.0018F, -16.7448F);
		rotor.addChild(cube_r264);
		setRotationAngle(cube_r264, 2.8798F, 0.0F, -3.1416F);
		cube_r264.setTextureOffset(459, 123).addBox(-7.5F, -17.1F, -3.8F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		cube_r264.setTextureOffset(0, 357).addBox(-8.5F, -10.1F, -4.8F, 6.0F, 12.0F, 6.0F, 0.0F, false);

		cube_r265 = new ModelRenderer(this);
		cube_r265.setRotationPoint(-17.2514F, -44.0018F, -3.6093F);
		rotor.addChild(cube_r265);
		setRotationAngle(cube_r265, 2.8798F, -1.0472F, -3.1416F);
		cube_r265.setTextureOffset(277, 463).addBox(-7.5F, -17.1F, -3.8F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		cube_r265.setTextureOffset(258, 507).addBox(-8.5F, -10.1F, -4.8F, 6.0F, 12.0F, 6.0F, 0.0F, false);

		cube_r266 = new ModelRenderer(this);
		cube_r266.setRotationPoint(-11.7514F, -44.0018F, 13.1355F);
		rotor.addChild(cube_r266);
		setRotationAngle(cube_r266, -0.2618F, -1.0472F, 0.0F);
		cube_r266.setTextureOffset(462, 257).addBox(-7.5F, -17.1F, -3.8F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		cube_r266.setTextureOffset(282, 507).addBox(-8.5F, -10.1F, -4.8F, 6.0F, 12.0F, 6.0F, 0.0F, false);

		cube_r267 = new ModelRenderer(this);
		cube_r267.setRotationPoint(5.5F, -44.0018F, 16.7448F);
		rotor.addChild(cube_r267);
		setRotationAngle(cube_r267, -0.2618F, 0.0F, 0.0F);
		cube_r267.setTextureOffset(451, 437).addBox(-7.5F, -17.1F, -3.8F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		cube_r267.setTextureOffset(80, 510).addBox(-8.5F, -10.1F, -4.8F, 6.0F, 12.0F, 6.0F, 0.0F, false);

		cube_r268 = new ModelRenderer(this);
		cube_r268.setRotationPoint(1.3301F, -173.0F, 0.7679F);
		rotor.addChild(cube_r268);
		setRotationAngle(cube_r268, 0.0F, -0.5236F, 0.0F);
		cube_r268.setTextureOffset(445, 175).addBox(7.1865F, -19.0F, -8.5F, 6.0F, 16.0F, 17.0F, 0.0F, false);
		cube_r268.setTextureOffset(406, 458).addBox(7.1865F, 118.0F, -8.5F, 6.0F, 12.0F, 17.0F, 0.0F, false);

		cube_r269 = new ModelRenderer(this);
		cube_r269.setRotationPoint(1.3301F, -173.0F, -0.7679F);
		rotor.addChild(cube_r269);
		setRotationAngle(cube_r269, 0.0F, 0.5236F, 0.0F);
		cube_r269.setTextureOffset(0, 442).addBox(7.1865F, -19.0F, -8.5F, 6.0F, 16.0F, 17.0F, 0.0F, false);
		cube_r269.setTextureOffset(248, 459).addBox(7.1865F, 118.0F, -8.5F, 6.0F, 12.0F, 17.0F, 0.0F, false);

		cube_r270 = new ModelRenderer(this);
		cube_r270.setRotationPoint(0.0F, -173.0F, -1.5359F);
		rotor.addChild(cube_r270);
		setRotationAngle(cube_r270, 0.0F, 1.5708F, 0.0F);
		cube_r270.setTextureOffset(51, 441).addBox(7.1865F, -19.0F, -8.5F, 6.0F, 16.0F, 17.0F, 0.0F, false);
		cube_r270.setTextureOffset(452, 464).addBox(7.1865F, 118.0F, -8.5F, 6.0F, 12.0F, 17.0F, 0.0F, false);

		cube_r271 = new ModelRenderer(this);
		cube_r271.setRotationPoint(-1.3301F, -173.0F, -0.7679F);
		rotor.addChild(cube_r271);
		setRotationAngle(cube_r271, -3.1416F, 0.5236F, -3.1416F);
		cube_r271.setTextureOffset(113, 440).addBox(7.1865F, -19.0F, -8.5F, 6.0F, 16.0F, 17.0F, 0.0F, false);

		cube_r272 = new ModelRenderer(this);
		cube_r272.setRotationPoint(-1.3301F, -173.0F, 0.7679F);
		rotor.addChild(cube_r272);
		setRotationAngle(cube_r272, -3.1416F, -0.5236F, -3.1416F);
		cube_r272.setTextureOffset(219, 439).addBox(7.1865F, -19.0F, -8.5F, 6.0F, 16.0F, 17.0F, 0.0F, false);

		cube_r273 = new ModelRenderer(this);
		cube_r273.setRotationPoint(0.0F, -173.0F, 1.5359F);
		rotor.addChild(cube_r273);
		setRotationAngle(cube_r273, 0.0F, -1.5708F, 0.0F);
		cube_r273.setTextureOffset(173, 439).addBox(7.1865F, -19.0F, -8.5F, 6.0F, 16.0F, 17.0F, 0.0F, false);
		cube_r273.setTextureOffset(466, 331).addBox(7.1865F, 118.0F, -8.5F, 6.0F, 12.0F, 17.0F, 0.0F, false);

		cube_r274 = new ModelRenderer(this);
		cube_r274.setRotationPoint(-1.3301F, -40.0F, 0.7679F);
		rotor.addChild(cube_r274);
		setRotationAngle(cube_r274, -3.1416F, -0.5236F, -3.1416F);
		cube_r274.setTextureOffset(466, 248).addBox(7.1865F, -15.0F, -8.5F, 6.0F, 12.0F, 17.0F, 0.0F, false);

		cube_r275 = new ModelRenderer(this);
		cube_r275.setRotationPoint(-1.3301F, -40.0F, -0.7679F);
		rotor.addChild(cube_r275);
		setRotationAngle(cube_r275, -3.1416F, 0.5236F, -3.1416F);
		cube_r275.setTextureOffset(465, 208).addBox(7.1865F, -15.0F, -8.5F, 6.0F, 12.0F, 17.0F, 0.0F, false);

		cube_r276 = new ModelRenderer(this);
		cube_r276.setRotationPoint(0.0F, -40.0F, 0.0F);
		rotor.addChild(cube_r276);
		setRotationAngle(cube_r276, 0.0F, 1.5708F, 0.0F);
		cube_r276.setTextureOffset(447, 437).addBox(14.1865F, -3.0F, -10.5F, 4.0F, 6.0F, 21.0F, 0.0F, false);

		cube_r277 = new ModelRenderer(this);
		cube_r277.setRotationPoint(0.0F, -40.0F, 0.0F);
		rotor.addChild(cube_r277);
		setRotationAngle(cube_r277, -3.1416F, 0.5236F, 3.1416F);
		cube_r277.setTextureOffset(450, 71).addBox(14.1865F, -3.0F, -10.5F, 4.0F, 6.0F, 21.0F, 0.0F, false);

		cube_r278 = new ModelRenderer(this);
		cube_r278.setRotationPoint(0.0F, -40.0F, 0.0F);
		rotor.addChild(cube_r278);
		setRotationAngle(cube_r278, -3.1416F, -0.5236F, 3.1416F);
		cube_r278.setTextureOffset(138, 452).addBox(14.1865F, -3.0F, -10.5F, 4.0F, 6.0F, 21.0F, 0.0F, false);

		cube_r279 = new ModelRenderer(this);
		cube_r279.setRotationPoint(0.0F, -40.0F, 0.0F);
		rotor.addChild(cube_r279);
		setRotationAngle(cube_r279, 0.0F, -1.5708F, 0.0F);
		cube_r279.setTextureOffset(76, 453).addBox(14.1865F, -3.0F, -10.5F, 4.0F, 6.0F, 21.0F, 0.0F, false);

		cube_r280 = new ModelRenderer(this);
		cube_r280.setRotationPoint(0.0F, -40.0F, 0.0F);
		rotor.addChild(cube_r280);
		setRotationAngle(cube_r280, 0.0F, -0.5236F, 0.0F);
		cube_r280.setTextureOffset(453, 384).addBox(14.1865F, -3.0F, -10.5F, 4.0F, 6.0F, 21.0F, 0.0F, false);

		cube_r281 = new ModelRenderer(this);
		cube_r281.setRotationPoint(0.0F, -40.0F, 0.0F);
		rotor.addChild(cube_r281);
		setRotationAngle(cube_r281, 0.0F, 0.5236F, 0.0F);
		cube_r281.setTextureOffset(455, 111).addBox(14.1865F, -3.0F, -10.5F, 4.0F, 6.0F, 21.0F, 0.0F, false);

		cube_r282 = new ModelRenderer(this);
		cube_r282.setRotationPoint(6.0F, 2.0F, -3.4641F);
		rotor.addChild(cube_r282);
		setRotationAngle(cube_r282, 0.0F, -1.0472F, 0.0F);
		cube_r282.setTextureOffset(198, 496).addBox(-11.0F, -13.0F, 24.9808F, 22.0F, 15.0F, 1.0F, 0.0F, false);

		cube_r283 = new ModelRenderer(this);
		cube_r283.setRotationPoint(6.0F, 2.0F, 3.4641F);
		rotor.addChild(cube_r283);
		setRotationAngle(cube_r283, -3.1416F, -1.0472F, 3.1416F);
		cube_r283.setTextureOffset(152, 496).addBox(-11.0F, -13.0F, 24.9808F, 22.0F, 15.0F, 1.0F, 0.0F, false);

		cube_r284 = new ModelRenderer(this);
		cube_r284.setRotationPoint(0.0F, 2.0F, 6.9282F);
		rotor.addChild(cube_r284);
		setRotationAngle(cube_r284, -3.1416F, 0.0F, 3.1416F);
		cube_r284.setTextureOffset(495, 327).addBox(-11.0F, -13.0F, 24.9808F, 22.0F, 15.0F, 1.0F, 0.0F, false);

		cube_r285 = new ModelRenderer(this);
		cube_r285.setRotationPoint(-6.0F, 2.0F, 3.4641F);
		rotor.addChild(cube_r285);
		setRotationAngle(cube_r285, -3.1416F, 1.0472F, 3.1416F);
		cube_r285.setTextureOffset(495, 248).addBox(-11.0F, -13.0F, 24.9808F, 22.0F, 15.0F, 1.0F, 0.0F, false);

		cube_r286 = new ModelRenderer(this);
		cube_r286.setRotationPoint(-6.0F, 2.0F, -3.4641F);
		rotor.addChild(cube_r286);
		setRotationAngle(cube_r286, 0.0F, 1.0472F, 0.0F);
		cube_r286.setTextureOffset(192, 472).addBox(-11.0F, -13.0F, 24.9808F, 22.0F, 15.0F, 1.0F, 0.0F, false);

		cube_r287 = new ModelRenderer(this);
		cube_r287.setRotationPoint(0.4019F, 5.0F, 1.0359F);
		rotor.addChild(cube_r287);
		setRotationAngle(cube_r287, 0.0F, -1.0472F, 0.0F);
		cube_r287.setTextureOffset(476, 440).addBox(-14.0981F, -11.5F, 18.3468F, 26.0F, 6.0F, 4.0F, 0.0F, false);

		cube_r288 = new ModelRenderer(this);
		cube_r288.setRotationPoint(-0.6962F, 5.0F, 0.866F);
		rotor.addChild(cube_r288);
		setRotationAngle(cube_r288, -3.1416F, -1.0472F, 3.1416F);
		cube_r288.setTextureOffset(476, 430).addBox(-14.0981F, -11.5F, 18.3468F, 26.0F, 6.0F, 4.0F, 0.0F, false);

		cube_r289 = new ModelRenderer(this);
		cube_r289.setRotationPoint(-1.0981F, 5.0F, -0.1699F);
		rotor.addChild(cube_r289);
		setRotationAngle(cube_r289, -3.1416F, 0.0F, 3.1416F);
		cube_r289.setTextureOffset(0, 476).addBox(-14.0981F, -11.5F, 18.3468F, 26.0F, 6.0F, 4.0F, 0.0F, false);

		cube_r290 = new ModelRenderer(this);
		cube_r290.setRotationPoint(-0.4019F, 5.0F, -1.0359F);
		rotor.addChild(cube_r290);
		setRotationAngle(cube_r290, -3.1416F, 1.0472F, 3.1416F);
		cube_r290.setTextureOffset(467, 317).addBox(-14.0981F, -11.5F, 18.3468F, 26.0F, 6.0F, 4.0F, 0.0F, false);

		cube_r291 = new ModelRenderer(this);
		cube_r291.setRotationPoint(0.6962F, 5.0F, -0.866F);
		rotor.addChild(cube_r291);
		setRotationAngle(cube_r291, 0.0F, 1.0472F, 0.0F);
		cube_r291.setTextureOffset(467, 98).addBox(-14.0981F, -11.5F, 18.3468F, 26.0F, 6.0F, 4.0F, 0.0F, false);

		cube_r292 = new ModelRenderer(this);
		cube_r292.setRotationPoint(-5.2154F, -39.0F, -5.0718F);
		rotor.addChild(cube_r292);
		setRotationAngle(cube_r292, 0.0F, -1.0472F, 0.0F);
		cube_r292.setTextureOffset(0, 390).addBox(-8.0F, 2.0F, 16.0F, 30.0F, 26.0F, 8.0F, 0.0F, false);

		cube_r293 = new ModelRenderer(this);
		cube_r293.setRotationPoint(1.7846F, -39.0F, -7.0526F);
		rotor.addChild(cube_r293);
		setRotationAngle(cube_r293, -3.1416F, -1.0472F, 3.1416F);
		cube_r293.setTextureOffset(234, 375).addBox(-8.0F, 2.0F, 16.0F, 30.0F, 26.0F, 8.0F, 0.0F, false);

		cube_r294 = new ModelRenderer(this);
		cube_r294.setRotationPoint(7.0F, -39.0F, -1.9808F);
		rotor.addChild(cube_r294);
		setRotationAngle(cube_r294, -3.1416F, 0.0F, 3.1416F);
		cube_r294.setTextureOffset(158, 375).addBox(-8.0F, 2.0F, 16.0F, 30.0F, 26.0F, 8.0F, 0.0F, false);

		cube_r295 = new ModelRenderer(this);
		cube_r295.setRotationPoint(5.2154F, -39.0F, 5.0718F);
		rotor.addChild(cube_r295);
		setRotationAngle(cube_r295, -3.1416F, 1.0472F, 3.1416F);
		cube_r295.setTextureOffset(333, 370).addBox(-8.0F, 2.0F, 16.0F, 30.0F, 26.0F, 8.0F, 0.0F, false);

		cube_r296 = new ModelRenderer(this);
		cube_r296.setRotationPoint(-1.7846F, -39.0F, 7.0526F);
		rotor.addChild(cube_r296);
		setRotationAngle(cube_r296, 0.0F, 1.0472F, 0.0F);
		cube_r296.setTextureOffset(82, 366).addBox(-8.0F, 2.0F, 16.0F, 30.0F, 26.0F, 8.0F, 0.0F, false);

		cube_r297 = new ModelRenderer(this);
		cube_r297.setRotationPoint(0.8686F, -30.0F, -2.8109F);
		rotor.addChild(cube_r297);
		setRotationAngle(cube_r297, 0.0F, -1.0472F, 0.0F);
		cube_r297.setTextureOffset(0, 136).addBox(-31.0F, -2.0F, -55.0F, 66.0F, 1.0F, 33.0F, 0.0F, false);

		cube_r298 = new ModelRenderer(this);
		cube_r298.setRotationPoint(2.8686F, -30.0F, -0.6532F);
		rotor.addChild(cube_r298);
		setRotationAngle(cube_r298, -3.1416F, -1.0472F, 3.1416F);
		cube_r298.setTextureOffset(0, 102).addBox(-31.0F, -2.0F, -55.0F, 66.0F, 1.0F, 33.0F, 0.0F, false);

		cube_r299 = new ModelRenderer(this);
		cube_r299.setRotationPoint(2.0F, -30.0F, 2.1577F);
		rotor.addChild(cube_r299);
		setRotationAngle(cube_r299, -3.1416F, 0.0F, 3.1416F);
		cube_r299.setTextureOffset(0, 68).addBox(-31.0F, -2.0F, -55.0F, 66.0F, 1.0F, 33.0F, 0.0F, false);

		cube_r300 = new ModelRenderer(this);
		cube_r300.setRotationPoint(-0.8686F, -30.0F, 2.8109F);
		rotor.addChild(cube_r300);
		setRotationAngle(cube_r300, -3.1416F, 1.0472F, 3.1416F);
		cube_r300.setTextureOffset(0, 34).addBox(-31.0F, -2.0F, -55.0F, 66.0F, 1.0F, 33.0F, 0.0F, false);

		cube_r301 = new ModelRenderer(this);
		cube_r301.setRotationPoint(-2.8686F, -30.0F, 0.6532F);
		rotor.addChild(cube_r301);
		setRotationAngle(cube_r301, 0.0F, 1.0472F, 0.0F);
		cube_r301.setTextureOffset(0, 0).addBox(-31.0F, -2.0F, -55.0F, 66.0F, 1.0F, 33.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 4.0F, 0.0F);
		rotor.addChild(bone);
		bone.setTextureOffset(443, 0).addBox(-14.0F, 0.0F, 18.2487F, 28.0F, 4.0F, 6.0F, 0.0F, false);

		cube_r302 = new ModelRenderer(this);
		cube_r302.setRotationPoint(-4.5814F, -24.0F, -5.4378F);
		bone.addChild(cube_r302);
		setRotationAngle(cube_r302, 0.0F, -1.0472F, 0.0F);
		cube_r302.setTextureOffset(176, 343).addBox(-7.0F, 24.0F, 17.0F, 28.0F, 4.0F, 6.0F, 0.0F, false);

		cube_r303 = new ModelRenderer(this);
		cube_r303.setRotationPoint(2.4186F, -24.0F, -6.6865F);
		bone.addChild(cube_r303);
		setRotationAngle(cube_r303, -3.1416F, -1.0472F, 3.1416F);
		cube_r303.setTextureOffset(450, 34).addBox(-7.0F, 24.0F, 17.0F, 28.0F, 4.0F, 6.0F, 0.0F, false);

		cube_r304 = new ModelRenderer(this);
		cube_r304.setRotationPoint(7.0F, -24.0F, -1.2487F);
		bone.addChild(cube_r304);
		setRotationAngle(cube_r304, -3.1416F, 0.0F, 3.1416F);
		cube_r304.setTextureOffset(265, 449).addBox(-7.0F, 24.0F, 17.0F, 28.0F, 4.0F, 6.0F, 0.0F, false);

		cube_r305 = new ModelRenderer(this);
		cube_r305.setRotationPoint(4.5814F, -24.0F, 5.4378F);
		bone.addChild(cube_r305);
		setRotationAngle(cube_r305, -3.1416F, 1.0472F, 3.1416F);
		cube_r305.setTextureOffset(395, 448).addBox(-7.0F, 24.0F, 17.0F, 28.0F, 4.0F, 6.0F, 0.0F, false);

		cube_r306 = new ModelRenderer(this);
		cube_r306.setRotationPoint(-2.4186F, -24.0F, 6.6865F);
		bone.addChild(cube_r306);
		setRotationAngle(cube_r306, 0.0F, 1.0472F, 0.0F);
		cube_r306.setTextureOffset(448, 165).addBox(-7.0F, 24.0F, 17.0F, 28.0F, 4.0F, 6.0F, 0.0F, false);

		rotor_lights = new ModelRenderer(this);
		rotor_lights.setRotationPoint(-17.2514F, -44.0018F, -3.6093F);
		rotor.addChild(rotor_lights);
		

		cube_r307 = new ModelRenderer(this);
		cube_r307.setRotationPoint(0.0F, 0.0F, 0.0F);
		rotor_lights.addChild(cube_r307);
		setRotationAngle(cube_r307, 2.8798F, -1.0472F, -3.1416F);
		cube_r307.setTextureOffset(512, 347).addBox(-8.5F, -16.1F, -4.8F, 6.0F, 6.0F, 6.0F, 0.0F, false);

		cube_r308 = new ModelRenderer(this);
		cube_r308.setRotationPoint(11.7514F, 0.0F, -13.1355F);
		rotor_lights.addChild(cube_r308);
		setRotationAngle(cube_r308, 2.8798F, 0.0F, -3.1416F);
		cube_r308.setTextureOffset(320, 512).addBox(-8.5F, -16.1F, -4.8F, 6.0F, 6.0F, 6.0F, 0.0F, false);

		cube_r309 = new ModelRenderer(this);
		cube_r309.setRotationPoint(29.0029F, 0.0F, -9.5263F);
		rotor_lights.addChild(cube_r309);
		setRotationAngle(cube_r309, 2.8798F, 1.0472F, 3.1416F);
		cube_r309.setTextureOffset(51, 424).addBox(-8.5F, -16.1F, -4.8F, 6.0F, 6.0F, 6.0F, 0.0F, false);

		cube_r310 = new ModelRenderer(this);
		cube_r310.setRotationPoint(34.5029F, 0.0F, 7.2185F);
		rotor_lights.addChild(cube_r310);
		setRotationAngle(cube_r310, -0.2618F, 1.0472F, 0.0F);
		cube_r310.setTextureOffset(58, 366).addBox(-8.5F, -16.1F, -4.8F, 6.0F, 6.0F, 6.0F, 0.0F, false);

		cube_r311 = new ModelRenderer(this);
		cube_r311.setRotationPoint(5.5F, 0.0F, 16.7448F);
		rotor_lights.addChild(cube_r311);
		setRotationAngle(cube_r311, -0.2618F, -1.0472F, 0.0F);
		cube_r311.setTextureOffset(461, 512).addBox(-8.5F, -16.1F, -4.8F, 6.0F, 6.0F, 6.0F, 0.0F, false);

		cube_r312 = new ModelRenderer(this);
		cube_r312.setRotationPoint(22.7514F, 0.0F, 20.3541F);
		rotor_lights.addChild(cube_r312);
		setRotationAngle(cube_r312, -0.2618F, 0.0F, 0.0F);
		cube_r312.setTextureOffset(230, 513).addBox(-8.5F, -16.1F, -4.8F, 6.0F, 6.0F, 6.0F, 0.0F, false);

		caps_bottom = new ModelRenderer(this);
		caps_bottom.setRotationPoint(0.0F, -61.0F, 0.0F);
		rotor.addChild(caps_bottom);
		

		rotor_cap_bottom1 = new ModelRenderer(this);
		rotor_cap_bottom1.setRotationPoint(5.0F, 0.0F, 8.6603F);
		caps_bottom.addChild(rotor_cap_bottom1);
		setRotationAngle(rotor_cap_bottom1, 0.0F, 0.5236F, 0.0F);
		rotor_cap_bottom1.setTextureOffset(0, 442).addBox(-3.0F, -4.5F, -1.0F, 6.0F, 5.0F, 2.0F, 0.0F, false);
		rotor_cap_bottom1.setTextureOffset(169, 479).addBox(-2.0F, -6.5F, -1.0F, 4.0F, 2.0F, 2.0F, 0.0F, false);

		rotor_cap_bottom2 = new ModelRenderer(this);
		rotor_cap_bottom2.setRotationPoint(-5.0F, 0.0F, 8.6603F);
		caps_bottom.addChild(rotor_cap_bottom2);
		setRotationAngle(rotor_cap_bottom2, 0.0F, -0.5236F, 0.0F);
		rotor_cap_bottom2.setTextureOffset(0, 431).addBox(-3.0F, -4.5F, -1.0F, 6.0F, 5.0F, 2.0F, 0.0F, false);
		rotor_cap_bottom2.setTextureOffset(130, 479).addBox(-2.0F, -6.5F, -1.0F, 4.0F, 2.0F, 2.0F, 0.0F, false);

		rotor_cap_bottom3 = new ModelRenderer(this);
		rotor_cap_bottom3.setRotationPoint(-10.0F, 0.0F, 0.0F);
		caps_bottom.addChild(rotor_cap_bottom3);
		setRotationAngle(rotor_cap_bottom3, 0.0F, -1.5708F, 0.0F);
		rotor_cap_bottom3.setTextureOffset(0, 424).addBox(-3.0F, -4.5F, -1.0F, 6.0F, 5.0F, 2.0F, 0.0F, false);
		rotor_cap_bottom3.setTextureOffset(362, 478).addBox(-2.0F, -6.5F, -1.0F, 4.0F, 2.0F, 2.0F, 0.0F, false);

		rotor_cap_bottom4 = new ModelRenderer(this);
		rotor_cap_bottom4.setRotationPoint(-5.0F, 0.0F, -8.6603F);
		caps_bottom.addChild(rotor_cap_bottom4);
		setRotationAngle(rotor_cap_bottom4, 3.1416F, -0.5236F, -3.1416F);
		rotor_cap_bottom4.setTextureOffset(253, 419).addBox(-3.0F, -4.5F, -1.0F, 6.0F, 5.0F, 2.0F, 0.0F, false);
		rotor_cap_bottom4.setTextureOffset(335, 478).addBox(-2.0F, -6.5F, -1.0F, 4.0F, 2.0F, 2.0F, 0.0F, false);

		rotor_cap_bottom5 = new ModelRenderer(this);
		rotor_cap_bottom5.setRotationPoint(5.0F, 0.0F, -8.6603F);
		caps_bottom.addChild(rotor_cap_bottom5);
		setRotationAngle(rotor_cap_bottom5, -3.1416F, 0.5236F, 3.1416F);
		rotor_cap_bottom5.setTextureOffset(301, 416).addBox(-3.0F, -4.5F, -1.0F, 6.0F, 5.0F, 2.0F, 0.0F, false);
		rotor_cap_bottom5.setTextureOffset(308, 477).addBox(-2.0F, -6.5F, -1.0F, 4.0F, 2.0F, 2.0F, 0.0F, false);

		rotor_cap_bottom6 = new ModelRenderer(this);
		rotor_cap_bottom6.setRotationPoint(10.0F, 0.0F, 0.0F);
		caps_bottom.addChild(rotor_cap_bottom6);
		setRotationAngle(rotor_cap_bottom6, 0.0F, 1.5708F, 0.0F);
		rotor_cap_bottom6.setTextureOffset(253, 412).addBox(-3.0F, -4.5F, -1.0F, 6.0F, 5.0F, 2.0F, 0.0F, false);
		rotor_cap_bottom6.setTextureOffset(476, 454).addBox(-2.0F, -6.5F, -1.0F, 4.0F, 2.0F, 2.0F, 0.0F, false);

		caps_top = new ModelRenderer(this);
		caps_top.setRotationPoint(0.0F, -170.0F, 0.0F);
		rotor.addChild(caps_top);
		setRotationAngle(caps_top, 0.0F, 0.0F, -3.1416F);
		

		rotor_cap_top = new ModelRenderer(this);
		rotor_cap_top.setRotationPoint(5.0F, 0.0F, 8.6603F);
		caps_top.addChild(rotor_cap_top);
		setRotationAngle(rotor_cap_top, 0.0F, 0.5236F, 0.0F);
		rotor_cap_top.setTextureOffset(301, 409).addBox(-3.0F, -4.5F, -1.0F, 6.0F, 5.0F, 2.0F, 0.0F, false);
		rotor_cap_top.setTextureOffset(379, 474).addBox(-2.0F, -6.5F, -1.0F, 4.0F, 2.0F, 2.0F, 0.0F, false);

		rotor_cap_top2 = new ModelRenderer(this);
		rotor_cap_top2.setRotationPoint(-5.0F, 0.0F, 8.6603F);
		caps_top.addChild(rotor_cap_top2);
		setRotationAngle(rotor_cap_top2, 0.0F, -0.5236F, 0.0F);
		rotor_cap_top2.setTextureOffset(226, 375).addBox(-3.0F, -4.5F, -1.0F, 6.0F, 5.0F, 2.0F, 0.0F, false);
		rotor_cap_top2.setTextureOffset(362, 474).addBox(-2.0F, -6.5F, -1.0F, 4.0F, 2.0F, 2.0F, 0.0F, false);

		rotor_cap_top3 = new ModelRenderer(this);
		rotor_cap_top3.setRotationPoint(-10.0F, 0.0F, 0.0F);
		caps_top.addChild(rotor_cap_top3);
		setRotationAngle(rotor_cap_top3, 0.0F, -1.5708F, 0.0F);
		rotor_cap_top3.setTextureOffset(337, 42).addBox(-3.0F, -4.5F, -1.0F, 6.0F, 5.0F, 2.0F, 0.0F, false);
		rotor_cap_top3.setTextureOffset(474, 183).addBox(-2.0F, -6.5F, -1.0F, 4.0F, 2.0F, 2.0F, 0.0F, false);

		rotor_cap_top4 = new ModelRenderer(this);
		rotor_cap_top4.setRotationPoint(-5.0F, 0.0F, -8.6603F);
		caps_top.addChild(rotor_cap_top4);
		setRotationAngle(rotor_cap_top4, 3.1416F, -0.5236F, -3.1416F);
		rotor_cap_top4.setTextureOffset(337, 35).addBox(-3.0F, -4.5F, -1.0F, 6.0F, 5.0F, 2.0F, 0.0F, false);
		rotor_cap_top4.setTextureOffset(474, 179).addBox(-2.0F, -6.5F, -1.0F, 4.0F, 2.0F, 2.0F, 0.0F, false);

		rotor_cap_top5 = new ModelRenderer(this);
		rotor_cap_top5.setRotationPoint(5.0F, 0.0F, -8.6603F);
		caps_top.addChild(rotor_cap_top5);
		setRotationAngle(rotor_cap_top5, -3.1416F, 0.5236F, 3.1416F);
		rotor_cap_top5.setTextureOffset(332, 199).addBox(-3.0F, -4.5F, -1.0F, 6.0F, 5.0F, 2.0F, 0.0F, false);
		rotor_cap_top5.setTextureOffset(474, 175).addBox(-2.0F, -6.5F, -1.0F, 4.0F, 2.0F, 2.0F, 0.0F, false);

		rotor_cap_top6 = new ModelRenderer(this);
		rotor_cap_top6.setRotationPoint(10.0F, 0.0F, 0.0F);
		caps_top.addChild(rotor_cap_top6);
		setRotationAngle(rotor_cap_top6, 0.0F, 1.5708F, 0.0F);
		rotor_cap_top6.setTextureOffset(332, 192).addBox(-3.0F, -4.5F, -1.0F, 6.0F, 5.0F, 2.0F, 0.0F, false);
		rotor_cap_top6.setTextureOffset(242, 472).addBox(-2.0F, -6.5F, -1.0F, 4.0F, 2.0F, 2.0F, 0.0F, false);

		rotor_glass = new ModelRenderer(this);
		rotor_glass.setRotationPoint(0.0F, 0.0F, 0.0F);
		rotor.addChild(rotor_glass);
		

		cube_r313 = new ModelRenderer(this);
		cube_r313.setRotationPoint(-1.3301F, -52.0F, 0.7679F);
		rotor_glass.addChild(cube_r313);
		setRotationAngle(cube_r313, -3.1416F, -0.5236F, -3.1416F);
		cube_r313.setTextureOffset(180, 205).addBox(13.1865F, -124.0F, -8.5F, 0.0F, 121.0F, 17.0F, 0.0F, false);

		cube_r314 = new ModelRenderer(this);
		cube_r314.setRotationPoint(-1.3301F, -52.0F, -0.7679F);
		rotor_glass.addChild(cube_r314);
		setRotationAngle(cube_r314, -3.1416F, 0.5236F, -3.1416F);
		cube_r314.setTextureOffset(214, 205).addBox(13.1865F, -124.0F, -8.5F, 0.0F, 121.0F, 17.0F, 0.0F, false);

		cube_r315 = new ModelRenderer(this);
		cube_r315.setRotationPoint(0.0F, -52.0F, -1.5359F);
		rotor_glass.addChild(cube_r315);
		setRotationAngle(cube_r315, 0.0F, 1.5708F, 0.0F);
		cube_r315.setTextureOffset(0, 219).addBox(13.1865F, -124.0F, -8.5F, 0.0F, 121.0F, 17.0F, 0.0F, false);

		cube_r316 = new ModelRenderer(this);
		cube_r316.setRotationPoint(1.3301F, -52.0F, -0.7679F);
		rotor_glass.addChild(cube_r316);
		setRotationAngle(cube_r316, 0.0F, 0.5236F, 0.0F);
		cube_r316.setTextureOffset(34, 219).addBox(13.1865F, -124.0F, -8.5F, 0.0F, 121.0F, 17.0F, 0.0F, false);

		cube_r317 = new ModelRenderer(this);
		cube_r317.setRotationPoint(1.3301F, -52.0F, 0.7679F);
		rotor_glass.addChild(cube_r317);
		setRotationAngle(cube_r317, 0.0F, -0.5236F, 0.0F);
		cube_r317.setTextureOffset(68, 219).addBox(13.1865F, -124.0F, -8.5F, 0.0F, 121.0F, 17.0F, 0.0F, false);

		cube_r318 = new ModelRenderer(this);
		cube_r318.setRotationPoint(0.0F, -52.0F, 1.5359F);
		rotor_glass.addChild(cube_r318);
		setRotationAngle(cube_r318, 0.0F, -1.5708F, 0.0F);
		cube_r318.setTextureOffset(102, 219).addBox(13.1865F, -124.0F, -8.5F, 0.0F, 121.0F, 17.0F, 0.0F, false);

		rotor_glass_parts = new ModelRenderer(this);
		rotor_glass_parts.setRotationPoint(0.0F, -55.0F, 0.0F);
		rotor.addChild(rotor_glass_parts);
		rotor_glass_parts.setTextureOffset(76, 400).addBox(-10.5F, -57.0F, -10.5F, 21.0F, 1.0F, 21.0F, 0.0F, false);
		rotor_glass_parts.setTextureOffset(399, 243).addBox(-10.5F, -53.0F, -10.5F, 21.0F, 1.0F, 21.0F, 0.0F, false);
		rotor_glass_parts.setTextureOffset(333, 405).addBox(-10.0F, -49.0F, -10.0F, 20.0F, 1.0F, 20.0F, 0.0F, false);
		rotor_glass_parts.setTextureOffset(141, 409).addBox(-9.5F, -45.0F, -9.5F, 19.0F, 1.0F, 19.0F, 0.0F, false);
		rotor_glass_parts.setTextureOffset(199, 412).addBox(-9.0F, -41.0F, -9.0F, 18.0F, 1.0F, 18.0F, 0.0F, false);
		rotor_glass_parts.setTextureOffset(0, 424).addBox(-8.5F, -37.0F, -8.5F, 17.0F, 1.0F, 17.0F, 0.0F, false);
		rotor_glass_parts.setTextureOffset(253, 412).addBox(-8.0F, -33.0F, -8.0F, 16.0F, 1.0F, 16.0F, 0.0F, false);
		rotor_glass_parts.setTextureOffset(318, 455).addBox(-7.5F, -29.0F, -7.5F, 15.0F, 1.0F, 15.0F, 0.0F, false);
		rotor_glass_parts.setTextureOffset(474, 175).addBox(-7.0F, -25.0F, -7.0F, 14.0F, 1.0F, 14.0F, 0.0F, false);
		rotor_glass_parts.setTextureOffset(130, 479).addBox(-6.5F, -21.0F, -6.5F, 13.0F, 1.0F, 13.0F, 0.0F, false);
		rotor_glass_parts.setTextureOffset(38, 498).addBox(-6.0F, -17.0F, -6.0F, 12.0F, 1.0F, 12.0F, 0.0F, false);
		rotor_glass_parts.setTextureOffset(497, 360).addBox(-6.0F, -13.0F, -6.0F, 12.0F, 1.0F, 12.0F, 0.0F, false);
		rotor_glass_parts.setTextureOffset(401, 349).addBox(-10.5F, -61.0F, -10.5F, 21.0F, 1.0F, 21.0F, 0.0F, false);
		rotor_glass_parts.setTextureOffset(399, 265).addBox(-10.5F, -65.0F, -10.5F, 21.0F, 1.0F, 21.0F, 0.0F, false);
		rotor_glass_parts.setTextureOffset(388, 383).addBox(-10.5F, -69.0F, -10.5F, 21.0F, 1.0F, 21.0F, 0.0F, false);
		rotor_glass_parts.setTextureOffset(393, 406).addBox(-10.0F, -73.0F, -10.0F, 20.0F, 1.0F, 20.0F, 0.0F, false);
		rotor_glass_parts.setTextureOffset(408, 218).addBox(-9.5F, -77.0F, -9.5F, 19.0F, 1.0F, 19.0F, 0.0F, false);
		rotor_glass_parts.setTextureOffset(58, 422).addBox(-9.0F, -81.0F, -9.0F, 18.0F, 1.0F, 18.0F, 0.0F, false);
		rotor_glass_parts.setTextureOffset(400, 430).addBox(-8.5F, -85.0F, -8.5F, 17.0F, 1.0F, 17.0F, 0.0F, false);
		rotor_glass_parts.setTextureOffset(255, 432).addBox(-8.0F, -89.0F, -8.0F, 16.0F, 1.0F, 16.0F, 0.0F, false);
		rotor_glass_parts.setTextureOffset(363, 458).addBox(-7.5F, -93.0F, -7.5F, 15.0F, 1.0F, 15.0F, 0.0F, false);
		rotor_glass_parts.setTextureOffset(453, 411).addBox(-7.0F, -97.0F, -7.0F, 14.0F, 1.0F, 14.0F, 0.0F, false);
		rotor_glass_parts.setTextureOffset(494, 208).addBox(-6.5F, -101.0F, -6.5F, 13.0F, 1.0F, 13.0F, 0.0F, false);
		rotor_glass_parts.setTextureOffset(86, 497).addBox(-6.0F, -105.0F, -6.0F, 12.0F, 1.0F, 12.0F, 0.0F, false);
		rotor_glass_parts.setTextureOffset(495, 402).addBox(-6.0F, -109.0F, -6.0F, 12.0F, 1.0F, 12.0F, 0.0F, false);

		rotor_core = new ModelRenderer(this);
		rotor_core.setRotationPoint(0.0F, -115.5F, 0.0F);
		rotor.addChild(rotor_core);
		rotor_core.setTextureOffset(136, 254).addBox(-1.5F, -19.0F, -1.5F, 3.0F, 38.0F, 3.0F, 0.0F, false);

		bone10 = new ModelRenderer(this);
		bone10.setRotationPoint(0.0F, -16.2375F, 0.0F);
		root.addChild(bone10);
		

		bone9 = new ModelRenderer(this);
		bone9.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone10.addChild(bone9);
		

		cube_r319 = new ModelRenderer(this);
		cube_r319.setRotationPoint(28.1755F, 3.4335F, 46.8014F);
		bone9.addChild(cube_r319);
		setRotationAngle(cube_r319, 0.1833F, 0.5236F, 0.0F);
		cube_r319.setTextureOffset(377, 325).addBox(-2.0F, -1.0F, -5.0F, 2.0F, 1.0F, 5.0F, 0.0F, false);

		cube_r320 = new ModelRenderer(this);
		cube_r320.setRotationPoint(25.7174F, 4.3446F, 42.5438F);
		bone9.addChild(cube_r320);
		setRotationAngle(cube_r320, 0.1134F, 0.5236F, 0.0F);
		cube_r320.setTextureOffset(352, 474).addBox(-2.0F, -1.0F, -23.0F, 2.0F, 1.0F, 23.0F, 0.0F, false);

		cube_r321 = new ModelRenderer(this);
		cube_r321.setRotationPoint(39.5636F, 0.2325F, 66.5262F);
		bone9.addChild(cube_r321);
		setRotationAngle(cube_r321, 0.1396F, 0.5236F, 0.0F);
		cube_r321.setTextureOffset(379, 475).addBox(-2.0F, -1.0F, -23.0F, 2.0F, 1.0F, 23.0F, 0.0F, false);

		cube_r322 = new ModelRenderer(this);
		cube_r322.setRotationPoint(0.0F, 4.1217F, 37.3936F);
		bone9.addChild(cube_r322);
		setRotationAngle(cube_r322, -0.2182F, 0.0F, -3.1416F);
		cube_r322.setTextureOffset(198, 130).addBox(-27.0F, -1.1F, 5.0F, 54.0F, 1.0F, 5.0F, 0.0F, false);

		cube_r323 = new ModelRenderer(this);
		cube_r323.setRotationPoint(38.0F, 0.3282F, 71.2651F);
		bone9.addChild(cube_r323);
		setRotationAngle(cube_r323, -0.1309F, 0.0F, -3.1416F);
		cube_r323.setTextureOffset(337, 89).addBox(14.0F, 0.0F, -46.0F, 48.0F, 1.0F, 17.0F, 0.0F, false);

		cube_r324 = new ModelRenderer(this);
		cube_r324.setRotationPoint(38.0F, 0.1278F, 67.1586F);
		bone9.addChild(cube_r324);
		setRotationAngle(cube_r324, -0.1309F, 0.0F, -3.1416F);
		cube_r324.setTextureOffset(172, 171).addBox(0.0F, 0.0F, -20.0F, 76.0F, 1.0F, 20.0F, 0.0F, false);

		bone11 = new ModelRenderer(this);
		bone11.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone10.addChild(bone11);
		setRotationAngle(bone11, 0.0F, -1.0472F, 0.0F);
		

		cube_r325 = new ModelRenderer(this);
		cube_r325.setRotationPoint(28.1755F, 3.4335F, 46.8014F);
		bone11.addChild(cube_r325);
		setRotationAngle(cube_r325, 0.1833F, 0.5236F, 0.0F);
		cube_r325.setTextureOffset(377, 319).addBox(-2.0F, -1.0F, -5.0F, 2.0F, 1.0F, 5.0F, 0.0F, false);

		cube_r326 = new ModelRenderer(this);
		cube_r326.setRotationPoint(25.7174F, 4.3446F, 42.5438F);
		bone11.addChild(cube_r326);
		setRotationAngle(cube_r326, 0.1134F, 0.5236F, 0.0F);
		cube_r326.setTextureOffset(325, 472).addBox(-2.0F, -1.0F, -23.0F, 2.0F, 1.0F, 23.0F, 0.0F, false);

		cube_r327 = new ModelRenderer(this);
		cube_r327.setRotationPoint(39.5636F, 0.2325F, 66.5262F);
		bone11.addChild(cube_r327);
		setRotationAngle(cube_r327, 0.1396F, 0.5236F, 0.0F);
		cube_r327.setTextureOffset(103, 473).addBox(-2.0F, -1.0F, -23.0F, 2.0F, 1.0F, 23.0F, 0.0F, false);

		cube_r328 = new ModelRenderer(this);
		cube_r328.setRotationPoint(0.0F, 4.1217F, 37.3936F);
		bone11.addChild(cube_r328);
		setRotationAngle(cube_r328, -0.2182F, 0.0F, -3.1416F);
		cube_r328.setTextureOffset(198, 130).addBox(-27.0F, -1.1F, 5.0F, 54.0F, 1.0F, 5.0F, 0.0F, false);

		cube_r329 = new ModelRenderer(this);
		cube_r329.setRotationPoint(38.0F, 0.3282F, 71.2651F);
		bone11.addChild(cube_r329);
		setRotationAngle(cube_r329, -0.1309F, 0.0F, -3.1416F);
		cube_r329.setTextureOffset(337, 89).addBox(14.0F, 0.0F, -46.0F, 48.0F, 1.0F, 17.0F, 0.0F, false);

		cube_r330 = new ModelRenderer(this);
		cube_r330.setRotationPoint(38.0F, 0.1278F, 67.1586F);
		bone11.addChild(cube_r330);
		setRotationAngle(cube_r330, -0.1309F, 0.0F, -3.1416F);
		cube_r330.setTextureOffset(172, 171).addBox(0.0F, 0.0F, -20.0F, 76.0F, 1.0F, 20.0F, 0.0F, false);

		bone12 = new ModelRenderer(this);
		bone12.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone10.addChild(bone12);
		setRotationAngle(bone12, 0.0F, -2.0944F, 0.0F);
		

		cube_r331 = new ModelRenderer(this);
		cube_r331.setRotationPoint(28.1755F, 3.4335F, 46.8014F);
		bone12.addChild(cube_r331);
		setRotationAngle(cube_r331, 0.1833F, 0.5236F, 0.0F);
		cube_r331.setTextureOffset(302, 375).addBox(-2.0F, -1.0F, -5.0F, 2.0F, 1.0F, 5.0F, 0.0F, false);

		cube_r332 = new ModelRenderer(this);
		cube_r332.setRotationPoint(25.7174F, 4.3446F, 42.5438F);
		bone12.addChild(cube_r332);
		setRotationAngle(cube_r332, 0.1134F, 0.5236F, 0.0F);
		cube_r332.setTextureOffset(165, 472).addBox(-2.0F, -1.0F, -23.0F, 2.0F, 1.0F, 23.0F, 0.0F, false);

		cube_r333 = new ModelRenderer(this);
		cube_r333.setRotationPoint(39.5636F, 0.2325F, 66.5262F);
		bone12.addChild(cube_r333);
		setRotationAngle(cube_r333, 0.1396F, 0.5236F, 0.0F);
		cube_r333.setTextureOffset(215, 472).addBox(-2.0F, -1.0F, -23.0F, 2.0F, 1.0F, 23.0F, 0.0F, false);

		cube_r334 = new ModelRenderer(this);
		cube_r334.setRotationPoint(0.0F, 4.1217F, 37.3936F);
		bone12.addChild(cube_r334);
		setRotationAngle(cube_r334, -0.2182F, 0.0F, -3.1416F);
		cube_r334.setTextureOffset(198, 130).addBox(-27.0F, -1.1F, 5.0F, 54.0F, 1.0F, 5.0F, 0.0F, false);

		cube_r335 = new ModelRenderer(this);
		cube_r335.setRotationPoint(38.0F, 0.3282F, 71.2651F);
		bone12.addChild(cube_r335);
		setRotationAngle(cube_r335, -0.1309F, 0.0F, -3.1416F);
		cube_r335.setTextureOffset(337, 89).addBox(14.0F, 0.0F, -46.0F, 48.0F, 1.0F, 17.0F, 0.0F, false);

		cube_r336 = new ModelRenderer(this);
		cube_r336.setRotationPoint(38.0F, 0.1278F, 67.1586F);
		bone12.addChild(cube_r336);
		setRotationAngle(cube_r336, -0.1309F, 0.0F, -3.1416F);
		cube_r336.setTextureOffset(172, 171).addBox(0.0F, 0.0F, -20.0F, 76.0F, 1.0F, 20.0F, 0.0F, false);

		bone13 = new ModelRenderer(this);
		bone13.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone10.addChild(bone13);
		setRotationAngle(bone13, 0.0F, 3.1416F, 0.0F);
		

		cube_r337 = new ModelRenderer(this);
		cube_r337.setRotationPoint(28.1755F, 3.4335F, 46.8014F);
		bone13.addChild(cube_r337);
		setRotationAngle(cube_r337, 0.1833F, 0.5236F, 0.0F);
		cube_r337.setTextureOffset(76, 366).addBox(-2.0F, -1.0F, -5.0F, 2.0F, 1.0F, 5.0F, 0.0F, false);

		cube_r338 = new ModelRenderer(this);
		cube_r338.setRotationPoint(25.7174F, 4.3446F, 42.5438F);
		bone13.addChild(cube_r338);
		setRotationAngle(cube_r338, 0.1134F, 0.5236F, 0.0F);
		cube_r338.setTextureOffset(470, 360).addBox(-2.0F, -1.0F, -23.0F, 2.0F, 1.0F, 23.0F, 0.0F, false);

		cube_r339 = new ModelRenderer(this);
		cube_r339.setRotationPoint(39.5636F, 0.2325F, 66.5262F);
		bone13.addChild(cube_r339);
		setRotationAngle(cube_r339, 0.1396F, 0.5236F, 0.0F);
		cube_r339.setTextureOffset(298, 471).addBox(-2.0F, -1.0F, -23.0F, 2.0F, 1.0F, 23.0F, 0.0F, false);

		cube_r340 = new ModelRenderer(this);
		cube_r340.setRotationPoint(0.0F, 4.1217F, 37.3936F);
		bone13.addChild(cube_r340);
		setRotationAngle(cube_r340, -0.2182F, 0.0F, -3.1416F);
		cube_r340.setTextureOffset(198, 130).addBox(-27.0F, -1.1F, 5.0F, 54.0F, 1.0F, 5.0F, 0.0F, false);

		cube_r341 = new ModelRenderer(this);
		cube_r341.setRotationPoint(38.0F, 0.3282F, 71.2651F);
		bone13.addChild(cube_r341);
		setRotationAngle(cube_r341, -0.1309F, 0.0F, -3.1416F);
		cube_r341.setTextureOffset(337, 89).addBox(14.0F, 0.0F, -46.0F, 48.0F, 1.0F, 17.0F, 0.0F, false);

		cube_r342 = new ModelRenderer(this);
		cube_r342.setRotationPoint(38.0F, 0.1278F, 67.1586F);
		bone13.addChild(cube_r342);
		setRotationAngle(cube_r342, -0.1309F, 0.0F, -3.1416F);
		cube_r342.setTextureOffset(172, 171).addBox(0.0F, 0.0F, -20.0F, 76.0F, 1.0F, 20.0F, 0.0F, false);

		bone14 = new ModelRenderer(this);
		bone14.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone10.addChild(bone14);
		setRotationAngle(bone14, 0.0F, 2.0944F, 0.0F);
		

		cube_r343 = new ModelRenderer(this);
		cube_r343.setRotationPoint(28.1755F, 3.4335F, 46.8014F);
		bone14.addChild(cube_r343);
		setRotationAngle(cube_r343, 0.1833F, 0.5236F, 0.0F);
		cube_r343.setTextureOffset(361, 325).addBox(-2.0F, -1.0F, -5.0F, 2.0F, 1.0F, 5.0F, 0.0F, false);

		cube_r344 = new ModelRenderer(this);
		cube_r344.setRotationPoint(25.7174F, 4.3446F, 42.5438F);
		bone14.addChild(cube_r344);
		setRotationAngle(cube_r344, 0.1134F, 0.5236F, 0.0F);
		cube_r344.setTextureOffset(271, 465).addBox(-2.0F, -1.0F, -23.0F, 2.0F, 1.0F, 23.0F, 0.0F, false);

		cube_r345 = new ModelRenderer(this);
		cube_r345.setRotationPoint(39.5636F, 0.2325F, 66.5262F);
		bone14.addChild(cube_r345);
		setRotationAngle(cube_r345, 0.1396F, 0.5236F, 0.0F);
		cube_r345.setTextureOffset(467, 293).addBox(-2.0F, -1.0F, -23.0F, 2.0F, 1.0F, 23.0F, 0.0F, false);

		cube_r346 = new ModelRenderer(this);
		cube_r346.setRotationPoint(0.0F, 4.1217F, 37.3936F);
		bone14.addChild(cube_r346);
		setRotationAngle(cube_r346, -0.2182F, 0.0F, -3.1416F);
		cube_r346.setTextureOffset(198, 130).addBox(-27.0F, -1.1F, 5.0F, 54.0F, 1.0F, 5.0F, 0.0F, false);

		cube_r347 = new ModelRenderer(this);
		cube_r347.setRotationPoint(38.0F, 0.3282F, 71.2651F);
		bone14.addChild(cube_r347);
		setRotationAngle(cube_r347, -0.1309F, 0.0F, -3.1416F);
		cube_r347.setTextureOffset(337, 89).addBox(14.0F, 0.0F, -46.0F, 48.0F, 1.0F, 17.0F, 0.0F, false);

		cube_r348 = new ModelRenderer(this);
		cube_r348.setRotationPoint(38.0F, 0.1278F, 67.1586F);
		bone14.addChild(cube_r348);
		setRotationAngle(cube_r348, -0.1309F, 0.0F, -3.1416F);
		cube_r348.setTextureOffset(172, 171).addBox(0.0F, 0.0F, -20.0F, 76.0F, 1.0F, 20.0F, 0.0F, false);

		bone15 = new ModelRenderer(this);
		bone15.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone10.addChild(bone15);
		setRotationAngle(bone15, 0.0F, 1.0472F, 0.0F);
		

		cube_r349 = new ModelRenderer(this);
		cube_r349.setRotationPoint(28.1755F, 3.4335F, 46.8014F);
		bone15.addChild(cube_r349);
		setRotationAngle(cube_r349, 0.1833F, 0.5236F, 0.0F);
		cube_r349.setTextureOffset(361, 319).addBox(-2.0F, -1.0F, -5.0F, 2.0F, 1.0F, 5.0F, 0.0F, false);

		cube_r350 = new ModelRenderer(this);
		cube_r350.setRotationPoint(25.7174F, 4.3446F, 42.5438F);
		bone15.addChild(cube_r350);
		setRotationAngle(cube_r350, 0.1134F, 0.5236F, 0.0F);
		cube_r350.setTextureOffset(23, 452).addBox(-2.0F, -1.0F, -23.0F, 2.0F, 1.0F, 23.0F, 0.0F, false);

		cube_r351 = new ModelRenderer(this);
		cube_r351.setRotationPoint(39.5636F, 0.2325F, 66.5262F);
		bone15.addChild(cube_r351);
		setRotationAngle(cube_r351, 0.1396F, 0.5236F, 0.0F);
		cube_r351.setTextureOffset(460, 10).addBox(-2.0F, -1.0F, -23.0F, 2.0F, 1.0F, 23.0F, 0.0F, false);

		cube_r352 = new ModelRenderer(this);
		cube_r352.setRotationPoint(0.0F, 4.1217F, 37.3936F);
		bone15.addChild(cube_r352);
		setRotationAngle(cube_r352, -0.2182F, 0.0F, -3.1416F);
		cube_r352.setTextureOffset(198, 130).addBox(-27.0F, -1.1F, 5.0F, 54.0F, 1.0F, 5.0F, 0.0F, false);

		cube_r353 = new ModelRenderer(this);
		cube_r353.setRotationPoint(38.0F, 0.3282F, 71.2651F);
		bone15.addChild(cube_r353);
		setRotationAngle(cube_r353, -0.1309F, 0.0F, -3.1416F);
		cube_r353.setTextureOffset(337, 89).addBox(14.0F, 0.0F, -46.0F, 48.0F, 1.0F, 17.0F, 0.0F, false);

		cube_r354 = new ModelRenderer(this);
		cube_r354.setRotationPoint(38.0F, 0.1278F, 67.1586F);
		bone15.addChild(cube_r354);
		setRotationAngle(cube_r354, -0.1309F, 0.0F, -3.1416F);
		cube_r354.setTextureOffset(172, 171).addBox(0.0F, 0.0F, -20.0F, 76.0F, 1.0F, 20.0F, 0.0F, false);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void render(FourteenthConsoleTile tileEntity, float scale, MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(matrixStack, buffer, packedLight, packedOverlay,1,1,1, alpha);
		matrixStack.push();

		matrixStack.pop();
	}
}