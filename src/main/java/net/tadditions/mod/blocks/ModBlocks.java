package net.tadditions.mod.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.client.renderers.DecorativeToyotaItemRenderer;
import net.tadditions.mod.client.renderers.SolenoidFilledItemRenderer;
import net.tadditions.mod.client.renderers.ZPFChamberBrokenItemRenderer;
import net.tadditions.mod.client.renderers.ZPFChamberItemRenderer;
import net.tadditions.mod.fluids.MFluids;
import net.tadditions.mod.helper.TAMultiblockPatterns;
import net.tadditions.mod.items.AnimatedBlockItem;
import net.tadditions.mod.items.ModItemGroups;
import net.tadditions.mod.items.ModItems;
import net.tardis.mod.blocks.*;
import net.tardis.mod.blocks.exteriors.ExteriorBlock;
import net.tardis.mod.blocks.multiblock.MultiblockPatterns;
import net.tardis.mod.itemgroups.TItemGroups;
import net.tardis.mod.items.TItems;
import net.tadditions.mod.blocks.RoundelContainer;
import net.tardis.mod.properties.Prop;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, QolMod.MOD_ID);

    public static final RegistryObject<Block> flight_event_detector = registerforblock("flight_event_detector", () -> setUpBlock(new FlightEventDetectorBlock(Prop.Blocks.BASIC_TECH.get().notSolid())));


    public static final RegistryObject<Block> barrier = registerforblock("verge_barrier", () -> setUpBlock(new VergeBarrierBlock(Prop.Blocks.BASIC_TECH.get())));
    public static final RegistryObject<Block> lightbox = registerforblock("lightbox", () -> setUpBlock(new LightBox(Prop.Blocks.BASIC_TECH.get().hardnessAndResistance(2F).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> zero_point_field_normal = registerforblockanimitem("zero_point_field_chamber", () -> setUpBlock(new ZeroPointFieldChamberBlock(Prop.Blocks.BASIC_TECH.get().notSolid().setLightLevel((state) -> {
        return 3;
    }))), new Item.Properties().group(ModItemGroups.TA).setISTER(() -> ZPFChamberItemRenderer::new));
    public static final RegistryObject<Block> zero_point_field_broken = registerforblockanimitem("zero_point_field_chamber_broken", () -> setUpBlock(new ZeroPointFieldChamberBlock(Prop.Blocks.BASIC_TECH.get().notSolid().setLightLevel((state) -> {
        return 0;
    }))), new Item.Properties().group(ModItemGroups.TA).setISTER(() -> ZPFChamberBrokenItemRenderer::new));

    public static final RegistryObject<Block> controlpanel_deco = registerforblock("decorative_control_panel", () -> setUpBlock(new ControlPanel(Prop.Blocks.BASIC_TECH.get().notSolid())));

    public static final RegistryObject<Block> weaponholder = registerforblock("katana_stand", () -> setUpBlock(new WeaponHolder(AbstractBlock.Properties.create(Material.WOOD).harvestTool(ToolType.AXE).hardnessAndResistance(2F))));

    public static final RegistryObject<Block> broken_old_ladder = registerforblock("broken_old_ladders", () -> setUpBlock(new HoloLadderBlock(Prop.Blocks.BASIC_TECH.get().notSolid())));
    public static final RegistryObject<Block> old_ladder = registerforblock("old_ladders", () -> setUpBlock(new HoloLadderBlock(Prop.Blocks.BASIC_TECH.get().notSolid())));

    public static final RegistryObject<Block> ancient_keyholder = registerforblock("ancient_keyholder", () -> setUpBlock(new DisappearDoorKeyBlock(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(-1).notSolid())));
    public static final RegistryObject<Block> ancient_door = registerforblock("ancient_door", () -> setUpBlock(new DisappearDoorBlock(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(-1).notSolid())));


    public static final RegistryObject<Block> sanguine_log = registerforblock("sanguine_log", () -> setUpBlock(new RotatedPillarBlock(Prop.Blocks.BASIC_WOOD.get())));

    public static final RegistryObject<Block> sanguine_planks = registerforblock("sanguine_planks", () -> setUpBlock(new Block(Prop.Blocks.BASIC_WOOD.get())));

    public static final RegistryObject<Block> sanguine_door = registerforblock("sanguine_door", () -> setUpBlock(new DoorBlock(Prop.Blocks.BASIC_WOOD.get().notSolid())));
    public static final RegistryObject<Block> sanguine_trapdoor = registerforblock("sanguine_trapdoor", () -> setUpBlock(new TrapDoorBlock(Prop.Blocks.BASIC_WOOD.get().notSolid())));


    public static final RegistryObject<Block> sanguine_stairs = registerforblock("sanguine_stairs", () -> setUpBlock(new StairsBlock(() -> sanguine_planks.get().getDefaultState(), AbstractBlock.Properties.from(sanguine_planks.get()))));

    public static final RegistryObject<Block> sanguine_slab = registerforblock("sanguine_slab", () -> setUpBlock(new SlabBlock(Prop.Blocks.BASIC_WOOD.get())));

    public static final RegistryObject<Block> sanguine_fence = registerforblock("sanguine_fence", () -> setUpBlock(new FenceBlock(Prop.Blocks.BASIC_WOOD.get())));
    public static final RegistryObject<Block> sanguine_fence_gate = registerforblock("sanguine_fence_gate", () -> setUpBlock(new FenceGateBlock(Prop.Blocks.BASIC_WOOD.get())));


    public static final RegistryObject<Block> scorched_log = registerforblock("scorched_log", () -> setUpBlock(new RotatedPillarBlock(Prop.Blocks.BASIC_WOOD.get())));

    public static final RegistryObject<Block> scorched_planks = registerforblock("scorched_planks", () -> setUpBlock(new Block(Prop.Blocks.BASIC_WOOD.get())));

    public static final RegistryObject<Block> scorched_stairs = registerforblock("scorched_stairs", () -> setUpBlock(new StairsBlock(() -> scorched_planks.get().getDefaultState(), AbstractBlock.Properties.from(scorched_planks.get()))));

    public static final RegistryObject<Block> scorched_slab = registerforblock("scorched_slab", () -> setUpBlock(new SlabBlock(Prop.Blocks.BASIC_WOOD.get())));

    public static final RegistryObject<Block> scorched_fence = registerforblock("scorched_fence", () -> setUpBlock(new FenceBlock(Prop.Blocks.BASIC_WOOD.get())));
    public static final RegistryObject<Block> scorched_fence_gate = registerforblock("scorched_fence_gate", () -> setUpBlock(new FenceGateBlock(Prop.Blocks.BASIC_WOOD.get())));

    public static final RegistryObject<Block> exterior_toyota_police_box = register("exterior_toyota_police_box", () -> setUpBlock(new ExteriorBlock()), false);
    public static final RegistryObject<Block> exterior_fourteenth_police_box = register("exterior_fourteenth_police_box", () -> setUpBlock(new ExteriorBlock()), false);

    public static final RegistryObject<Block> decorative_toyota_police_box = register("decorative_toyota_police_box", () -> setUpBlock(new FakeToyotaBlock(AbstractBlock.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(-1.0F, -1.0F).variableOpacity().notSolid())), false);
    public static final RegistryObject<Block> decorative_fourteenth_police_box = register("decorative_fourteenth_police_box", () -> setUpBlock(new FakeFourteenthPoliceBoxBlock(AbstractBlock.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(-1.0F, -1.0F).variableOpacity().notSolid())), false);

    public static final RegistryObject<Block> fourteenth_console = register("fourteenth_console", () -> setUpBlock(new ConsoleBlock()), false);

    public static final RegistryObject<Block> ash = registerforblock("ash", () -> setUpBlock(new SandBlock(0, Prop.Blocks.BASIC_SAND.get())));

    public static final RegistryObject<Block> dense_ash = registerforblock("dense_ash", () -> setUpBlock(new Block(Prop.Blocks.BASIC_STONE.get())));


    public static final RegistryObject<Block> mars_dust = registerforblock("mars_dust", () -> setUpBlock(new SandBlock(0, Prop.Blocks.BASIC_SAND.get())));

    public static final RegistryObject<Block> mars_rock = registerforblock("mars_rock", () -> setUpBlock(new Block(Prop.Blocks.BASIC_STONE.get())));

    public static final RegistryObject<Block> advanced_quantiscope_iron = register("advanced_quantiscope", () -> setUpBlock(new AdvQuantiscopeBlock()), ModItemGroups.TA);

    public static final RegistryObject<Block> filled_electromagnetic_solenoid_container = registerforblockanimitem("filled_electromagnetic_solenoid_container", () -> setUpBlock(new SolenoidConBlock(Prop.Blocks.BASIC_TECH.get())), new Item.Properties().group(ModItemGroups.TA).setISTER(() -> SolenoidFilledItemRenderer::new));

    public static final RegistryObject<Block> roundel_smooth_quartz_full = registerforblock("roundel/smooth_quartz_full", () -> setUpBlock(new RoundelBlock(AbstractBlock.Properties.create(Material.ROCK), SoundType.STONE, 1.25F, 4.2F)));

    public static final RegistryObject<Block> roundel_smooth_quartz_offset = registerforblock("roundel/smooth_quartz_offset", () -> setUpBlock(new RoundelBlock(AbstractBlock.Properties.create(Material.ROCK), SoundType.STONE, 1.25F, 4.2F)));

    public static final RegistryObject<Block> electromagnetic_solenoid_container = register("electromagnetic_solenoid_container", () -> setUpBlock(new SolenoidConBlock(Prop.Blocks.BASIC_TECH.get())), ModItemGroups.TA);

    public static final RegistryObject<Block> roundelcon_alabaster = register("roundelcon/alabaster", () -> setUpBlock(new RoundelContainer(AbstractBlock.Properties.create(Material.IRON).setLightLevel((state) -> {
        return 15;
    }))));



    //Planks
    public static final RegistryObject<Block> roundel_oak_planks_full = register("roundelcon/oak_planks_full", () -> setUpBlock(new RoundelContainer(AbstractBlock.Properties.create(Material.WOOD).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_oak_planks_offset = register("roundelcon/oak_planks_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.WOOD).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_spruce_planks_full = register("roundelcon/spruce_planks_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.WOOD).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_spruce_planks_offset = register("roundelcon/spruce_planks_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.WOOD).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_birch_planks_full = register("roundelcon/birch_planks_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.WOOD).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_birch_planks_offset = register("roundelcon/birch_planks_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.WOOD).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_jungle_planks_full = register("roundelcon/jungle_planks_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.WOOD).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_jungle_planks_offset = register("roundelcon/jungle_planks_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.WOOD).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_acacia_planks_full = register("roundelcon/acacia_planks_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.WOOD).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_acacia_planks_offset = register("roundelcon/acacia_planks_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.WOOD).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_dark_oak_planks_full = register("roundelcon/dark_oak_planks_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.WOOD).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_dark_oak_planks_offset = register("roundelcon/dark_oak_planks_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.WOOD).setLightLevel((state) -> {
        return 15;
    }))));

    //Stripped Wood
    public static final RegistryObject<Block> roundel_acacia_stripped_full = register("roundelcon/acacia_stripped_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.WOOD).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_acacia_stripped_offset = register("roundelcon/acacia_stripped_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.WOOD).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_birch_stripped_full = register("roundelcon/birch_stripped_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.WOOD).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_birch_stripped_offset = register("roundelcon/birch_stripped_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.WOOD).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_dark_oak_stripped_full = register("roundelcon/dark_oak_stripped_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.WOOD).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_dark_oak_stripped_offset = register("roundelcon/dark_oak_stripped_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.WOOD).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_jungle_stripped_full = register("roundelcon/jungle_stripped_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.WOOD).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_jungle_stripped_offset = register("roundelcon/jungle_stripped_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.WOOD).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_oak_stripped_full = register("roundelcon/oak_stripped_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.WOOD).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_oak_stripped_offset = register("roundelcon/oak_stripped_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.WOOD).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_spruce_stripped_full = register("roundelcon/spruce_stripped_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.WOOD).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_spruce_stripped_offset = register("roundelcon/spruce_stripped_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.WOOD).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_warped_stripped_full = register("roundelcon/warped_stripped_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.WOOD).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_warped_stripped_offset = register("roundelcon/warped_stripped_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.WOOD).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_crimson_stripped_full = register("roundelcon/crimson_stripped_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.WOOD).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_crimson_stripped_offset = register("roundelcon/crimson_stripped_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.WOOD).setLightLevel((state) -> {
        return 15;
    }))));


    //Concrete
    public static final RegistryObject<Block> roundel_white_concrete_full = register("roundelcon/white_concrete_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_white_concrete_offset = register("roundelcon/white_concrete_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_orange_concrete_full = register("roundelcon/orange_concrete_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_orange_concrete_offset = register("roundelcon/orange_concrete_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_magenta_concrete_full = register("roundelcon/magenta_concrete_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_magenta_concrete_offset = register("roundelcon/magenta_concrete_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_light_blue_concrete_full = register("roundelcon/light_blue_concrete_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_light_blue_concrete_offset = register("roundelcon/light_blue_concrete_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_yellow_concrete_full = register("roundelcon/yellow_concrete_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_yellow_concrete_offset = register("roundelcon/yellow_concrete_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_lime_concrete_full = register("roundelcon/lime_concrete_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_lime_concrete_offset = register("roundelcon/lime_concrete_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_pink_concrete_full = register("roundelcon/pink_concrete_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_pink_concrete_offset = register("roundelcon/pink_concrete_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_gray_concrete_full = register("roundelcon/gray_concrete_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_gray_concrete_offset = register("roundelcon/gray_concrete_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_light_gray_concrete_full = register("roundelcon/light_gray_concrete_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_light_gray_concrete_offset = register("roundelcon/light_gray_concrete_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_cyan_concrete_full = register("roundelcon/cyan_concrete_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_cyan_concrete_offset = register("roundelcon/cyan_concrete_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_purple_concrete_full = register("roundelcon/purple_concrete_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_purple_concrete_offset = register("roundelcon/purple_concrete_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_blue_concrete_full = register("roundelcon/blue_concrete_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_blue_concrete_offset = register("roundelcon/blue_concrete_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_brown_concrete_full = register("roundelcon/brown_concrete_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_brown_concrete_offset = register("roundelcon/brown_concrete_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_green_concrete_full = register("roundelcon/green_concrete_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_green_concrete_offset = register("roundelcon/green_concrete_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_red_concrete_full = register("roundelcon/red_concrete_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_red_concrete_offset = register("roundelcon/red_concrete_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_black_concrete_full = register("roundelcon/black_concrete_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_black_concrete_offset = register("roundelcon/black_concrete_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    //Terracotta
    public static final RegistryObject<Block> roundel_white_terracotta_full = register("roundelcon/white_terracotta_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_white_terracotta_offset = register("roundelcon/white_terracotta_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_orange_terracotta_full = register("roundelcon/orange_terracotta_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_orange_terracotta_offset = register("roundelcon/orange_terracotta_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_magenta_terracotta_full = register("roundelcon/magenta_terracotta_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_magenta_terracotta_offset = register("roundelcon/magenta_terracotta_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_light_blue_terracotta_full = register("roundelcon/light_blue_terracotta_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_light_blue_terracotta_offset = register("roundelcon/light_blue_terracotta_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_yellow_terracotta_full = register("roundelcon/yellow_terracotta_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_yellow_terracotta_offset = register("roundelcon/yellow_terracotta_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_lime_terracotta_full = register("roundelcon/lime_terracotta_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_lime_terracotta_offset = register("roundelcon/lime_terracotta_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_pink_terracotta_full = register("roundelcon/pink_terracotta_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_pink_terracotta_offset = register("roundelcon/pink_terracotta_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_gray_terracotta_full = register("roundelcon/gray_terracotta_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_gray_terracotta_offset = register("roundelcon/gray_terracotta_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_light_gray_terracotta_full = register("roundelcon/light_gray_terracotta_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_light_gray_terracotta_offset = register("roundelcon/light_gray_terracotta_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_cyan_terracotta_full = register("roundelcon/cyan_terracotta_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_cyan_terracotta_offset = register("roundelcon/cyan_terracotta_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_purple_terracotta_full = register("roundelcon/purple_terracotta_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_purple_terracotta_offset = register("roundelcon/purple_terracotta_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_blue_terracotta_full = register("roundelcon/blue_terracotta_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_blue_terracotta_offset = register("roundelcon/blue_terracotta_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_brown_terracotta_full = register("roundelcon/brown_terracotta_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_brown_terracotta_offset = register("roundelcon/brown_terracotta_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_green_terracotta_full = register("roundelcon/green_terracotta_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_green_terracotta_offset = register("roundelcon/green_terracotta_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_red_terracotta_full = register("roundelcon/red_terracotta_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_red_terracotta_offset = register("roundelcon/red_terracotta_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_black_terracotta_full = register("roundelcon/black_terracotta_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_black_terracotta_offset = register("roundelcon/black_terracotta_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    //Quartz
    public static final RegistryObject<Block> roundel_quartz = register("roundelcon/quartz", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    //Migrate roundel_quartz_pillar to roundelcon/quartz_pillar_full
    public static final RegistryObject<Block> roundel_quartz_pillar_full = register("roundelcon/quartz_pillar_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    //New to 1.16
    public static final RegistryObject<Block> roundel_quartz_pillar_offset = register("roundelcon/quartz_pillar_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_chiseled_quartz_full = register("roundelcon/chiseled_quartz_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_chiseled_quartz_offset = register("roundelcon/chiseled_quartz_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    //Coral
    public static final RegistryObject<Block> roundel_coralised = register("roundelcon/coralised", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_divider = register("roundelcon/coral_divider", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_coralised_large = register("roundelcon/coralised_large", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_coralised_small = register("roundelcon/coralised_small", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    //Stone
    public static final RegistryObject<Block> roundel_stone_bricks_full = register("roundelcon/stone_bricks_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_stone_bricks_offset = register("roundelcon/stone_bricks_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_smooth_stone_full = register("roundelcon/smooth_stone_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_smooth_stone_offset = register("roundelcon/smooth_stone_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_polished_andesite_full = register("roundelcon/polished_andesite_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_polished_andesite_offset = register("roundelcon/polished_andesite_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_polished_granite_full = register("roundelcon/polished_granite_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_polished_granite_offset = register("roundelcon/polished_granite_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_polished_diorite_full = register("roundelcon/polished_diorite_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_polished_diorite_offset = register("roundelcon/polished_diorite_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_cut_red_sandstone_full = register("roundelcon/cut_red_sandstone_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_cut_red_sandstone_offset = register("roundelcon/cut_red_sandstone_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_cut_sandstone_full = register("roundelcon/cut_sandstone_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_cut_sandstone_offset = register("roundelcon/cut_sandstone_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_sandstone_full = register("roundelcon/sandstone_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_sandstone_offset = register("roundelcon/sandstone_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    //End
    public static final RegistryObject<Block> roundel_end_stone_bricks_full = register("roundelcon/end_stone_bricks_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_end_stone_bricks_offset = register("roundelcon/end_stone_bricks_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_end_stone_full = register("roundelcon/end_stone_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_end_stone_offset = register("roundelcon/end_stone_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_purpur_bricks_full = register("roundelcon/purpur_bricks_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_purpur_bricks_offset = register("roundelcon/purpur_bricks_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_purpur_pillar_full = register("roundelcon/purpur_pillar_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_purpur_pillar_offset = register("roundelcon/purpur_pillar_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));


    //Nether
    public static final RegistryObject<Block> roundel_nether_bricks_full = register("roundelcon/nether_bricks_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_nether_bricks_offset = register("roundelcon/nether_bricks_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_nether_wart_block_full = register("roundelcon/nether_wart_block_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_nether_wart_block_offset = register("roundelcon/nether_wart_block_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_red_nether_bricks_full = register("roundelcon/red_nether_bricks_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_red_nether_bricks_offset = register("roundelcon/red_nether_bricks_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_gilded_blackstone_full = register("roundelcon/gilded_blackstone_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_gilded_blackstone_offset = register("roundelcon/gilded_blackstone_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_polished_basalt_full = register("roundelcon/polished_basalt_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_polished_basalt_offset = register("roundelcon/polished_basalt_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_polished_blackstone_bricks_full = register("roundelcon/polished_blackstone_bricks_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_polished_blackstone_bricks_offset = register("roundelcon/polished_blackstone_bricks_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundel_polished_blackstone_full = register("roundelcon/polished_blackstone_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_polished_blackstone_offset = register("roundelcon/polished_blackstone_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    //Prismarine
    public static final RegistryObject<Block> roundel_prismarine_bricks_full = register("roundelcon/prismarine_bricks_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));
    public static final RegistryObject<Block> roundel_prismarine_bricks_offset = register("roundelcon/prismarine_bricks_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    //Bone
    public static final RegistryObject<Block> roundel_bone_block_full = register("roundelcon/bone_block_full", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK, MaterialColor.SAND))));
    public static final RegistryObject<Block> roundel_bone_block_offset = register("roundelcon/bone_block_offset", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));


    //Non roundel blocks that need roundel properties
    public static final RegistryObject<Block> roundel_tech_wall_lamp = register("roundelcon/tech_wall_lamp", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> three_point_lamp = register("roundelcon/three_point_lamp", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK, MaterialColor.SAND))));
    public static final RegistryObject<Block> tungsten_blue_runner_light = register("roundelcon/tungsten_blue_runner_light", () -> setUpBlock(new RoundelContainer(Block.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundelcon_smooth_quartz_full = register("roundelcon/smooth_quartz_full", () -> setUpBlock(new RoundelContainer(AbstractBlock.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> roundelcon_smooth_quartz_offset = register("roundelcon/smooth_quartz_offset", () -> setUpBlock(new RoundelContainer(AbstractBlock.Properties.create(Material.ROCK).setLightLevel((state) -> {
        return 15;
    }))));

    public static final RegistryObject<Block> foodmaker = register("foodmaker", () -> setUpBlock(new FoodMaker()), ModItemGroups.TA);


    private static <T extends Block> T setUpBlock(T block) {
        return block;
    }

    /**
     * Registers a Block and BlockItem to the ItemGroup of your choice
     * @param <T>
     * @param id
     * @param blockSupplier
     * @param itemGroup
     * @return
     */
    private static <T extends Block> RegistryObject<T> register(String id, Supplier<T> blockSupplier, ItemGroup itemGroup){
        RegistryObject<T> registryObject = BLOCKS.register(id, blockSupplier);
        ModItems.ITEMS.register(id, () -> new BlockItem(registryObject.get(), new Item.Properties().group(itemGroup)));
        return registryObject;
    }

    private static <T extends Block> RegistryObject<T> register(String id, Supplier<T> blockSupplier, ItemGroup itemGroup, Item con){
        RegistryObject<T> registryObject = BLOCKS.register(id, blockSupplier);
        ModItems.ITEMS.register(id, () -> new BlockItem(registryObject.get(), new Item.Properties().group(itemGroup).containerItem(con)));
        return registryObject;
    }

    /**
     * Registers a Block without a BlockItem
     * <br> Use when you need a special BlockItem. The BlockItem should be registered in TItems with the same registry name as the block
     * @param <T>
     * @param id
     * @param blockSupplier
     * @return
     */
    private static <T extends Block> RegistryObject<T> registerBlockOnly(String id, Supplier<T> blockSupplier){
        RegistryObject<T> registryObject = BLOCKS.register(id, blockSupplier);
        return registryObject;
    }

    /**
     * Registers a Block and BlockItem into the FutureItemGroup
     * @param <T>
     * @param id
     * @param blockSupplier
     * @return
     */
    private static <T extends Block> RegistryObject<T> register(String id, Supplier<T> blockSupplier){
        RegistryObject<T> registryObject = BLOCKS.register(id, blockSupplier);
        ModItems.ITEMS.register(id, () -> new BlockItem(registryObject.get(), new Item.Properties().group(ModItemGroups.ROUNDELCONS)));
        return registryObject;
    }
//Blocks
    private static <T extends Block> RegistryObject<T> registerforblock(String id, Supplier<T> blockSupplier){
        RegistryObject<T> registryObject = BLOCKS.register(id, blockSupplier);
        ModItems.ITEMS.register(id, () -> new BlockItem(registryObject.get(), new Item.Properties().group(ModItemGroups.TA)));
        return registryObject;
    }

    private static <T extends Block> RegistryObject<T> registerforblockanimitem(String id, Supplier<T> blockSupplier, Item.Properties props){
        RegistryObject<T> registryObject = BLOCKS.register(id, blockSupplier);
        ModItems.ITEMS.register(id, () -> new AnimatedBlockItem(registryObject.get(), props));
        return registryObject;
    }

    /**
     * Registers a Block and registers a BlockItem depending if hasItem is true
     * <br> If hasItem is true, register a blockItem into the Future ItemGroup
     * @param <T>
     * @param id
     * @param blockSupplier
     * @param hasItem
     * @return
     */
    private static <T extends Block> RegistryObject<T>  register(String id, Supplier<T> blockSupplier, boolean hasItem){
        RegistryObject<T> registryObject = BLOCKS.register(id, blockSupplier);
        if (hasItem)
            ModItems.ITEMS.register(id, () -> new BlockItem(registryObject.get(), new Item.Properties().group(TItemGroups.FUTURE)));
        return registryObject;
    }

    private static ToIntFunction<BlockState> getLightValueLit(int lightValue) {
        return (state) -> {
            return state.get(BlockStateProperties.LIT) ? lightValue : 0;
        };
    }
}
