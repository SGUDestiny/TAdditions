package net.tadditions.mod.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.items.ModItemGroups;
import net.tadditions.mod.items.ModItems;
import net.tardis.mod.blocks.QuantiscopeBlock;
import net.tardis.mod.blocks.RoundelBlock;
import net.tardis.mod.blocks.WaypointBankBlock;
import net.tardis.mod.itemgroups.TItemGroups;
import net.tardis.mod.items.TItems;
import net.tadditions.mod.blocks.RoundelContainer;
import net.tardis.mod.properties.Prop;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, QolMod.MOD_ID);

    public static final RegistryObject<Block> tagrea_dust = registerforblock("tagrea_dust", () -> setUpBlock(new SandBlock(0, Prop.Blocks.BASIC_SAND.get())));

    public static final RegistryObject<Block> tagrea_rock = registerforblock("tagrea_rock", () -> setUpBlock(new Block(Prop.Blocks.BASIC_STONE.get())));


    public static final RegistryObject<Block> mars_dust = registerforblock("mars_dust", () -> setUpBlock(new SandBlock(0, Prop.Blocks.BASIC_SAND.get())));

    public static final RegistryObject<Block> mars_rock = registerforblock("mars_rock", () -> setUpBlock(new Block(Prop.Blocks.BASIC_STONE.get())));

    public static final RegistryObject<Block> advanced_quantiscope_iron = register("advanced_quantiscope", () -> setUpBlock(new AdvQuantiscopeBlock()), TItemGroups.MAINTENANCE);

    public static final RegistryObject<Block> electromagnetic_solenoid_container = register("electromagnetic_solenoid_container", () -> setUpBlock(new SolenoidConBlock(Prop.Blocks.BASIC_TECH.get())), TItemGroups.MAINTENANCE);

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
    
    
    
    
    
    public static final RegistryObject<Block> foodmaker = register("foodmaker", () -> setUpBlock(new FoodMaker()), TItemGroups.MAINTENANCE);


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
        ModItems.ITEMS.register(id, () -> new BlockItem(registryObject.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
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
    private static <T extends Block> RegistryObject<T> register(String id, Supplier<T> blockSupplier, boolean hasItem){
        RegistryObject<T> registryObject = BLOCKS.register(id, blockSupplier);
        if (hasItem)
            TItems.ITEMS.register(id, () -> new BlockItem(registryObject.get(), new Item.Properties().group(TItemGroups.FUTURE)));
        return registryObject;
    }

    private static ToIntFunction<BlockState> getLightValueLit(int lightValue) {
        return (state) -> {
            return state.get(BlockStateProperties.LIT) ? lightValue : 0;
        };
    }
}
