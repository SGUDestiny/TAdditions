package net.tadditions.mod.items;

import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.IModBusEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.client.renderers.DematRenderer;
import net.tadditions.mod.client.renderers.FluidLinkRenderer;
import net.tadditions.mod.client.renderers.ImpulseKeyRenderer;
import net.tadditions.mod.sound.MSounds;
import net.tardis.mod.constants.TardisConstants;
import net.tardis.mod.itemgroups.TItemGroups;
import net.tardis.mod.items.ArtronCapacitorItem;
import net.tardis.mod.items.ArtronItemStackBatteryItem;
import net.tardis.mod.items.TardisPartItem;
import net.tardis.mod.properties.Prop;
import software.bernie.example.client.renderer.item.PistolRender;

import java.util.concurrent.Callable;
import java.util.function.Supplier;


public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, QolMod.MOD_ID);

    public static final RegistryObject<Item> IMPULSE_KEY = ITEMS.register("impulse_key", () -> createItem(new CoreKeyItem(Prop.Items.ONE.get().group(ItemGroup.MISC).isImmuneToFire().setISTER(() -> ImpulseKeyRenderer::new))));
    public static final RegistryObject<Item> UPGRADES_MANUAL = ITEMS.register("upgrades_manual", () -> createItem(new UpgradeManualItem()));
    public static final RegistryObject<Item> ULTRA_HIGH_CAPACITY_ARTRON_CAPACITOR = ITEMS.register("artron_capacitor_ultra",
            () -> new ArtronCapacitorItem(1024F, 0.5F));
    public static final RegistryObject<Item> ULTRA_HIGH_RECHARGE_ARTRON_CAPACITOR = ITEMS.register("artron_capacitor_speed",
            () -> new ArtronCapacitorItem(128F, 4));
    public static final RegistryObject<Item> ARTRON_CAPACITOR_TEMPORAL = ITEMS.register("artron_capacitor_temporal",
            () -> new ArtronCapacitorItem(1536F, 6.5F));
    public static final RegistryObject<Item> ARTRON_BATTERY_ULTRA = ITEMS.register("artron_battery_ultra", () -> createItem(new ArtronItemStackBatteryItem(3.5F, 0.4F, 6000F, false)));
    public static final RegistryObject<Item> ARTRON_BATTERY_ARTRON_SYPHON = ITEMS.register("artron_battery_speed", () -> createItem(new ArtronItemStackBatteryItem(6F, 0.1F, 750F, false)));
    public static final RegistryObject<Item> ARTRON_BATTERY_TEMPORAL_SYPHON = ITEMS.register("artron_battery_temporal", () -> createItem(new ArtronItemStackBatteryItem(7.5F, 0.17F, 9000F, false)));
    public static final RegistryObject<Item> THERMAL_PROTECTION_UPGRADE = ITEMS.register("upgrades/thermal_protection", () -> createItem(new TardisPartItem(TardisConstants.Part.PartType.UPGRADE, false, false, TardisConstants.Translations.TEMPORAL_GRACE)));
    public static final RegistryObject<Item> FOODCUBE = ITEMS.register("foodcube", () -> createItem(new Item((new Item.Properties()).group(ItemGroup.FOOD).food(new Food.Builder().hunger(3).saturation(3F).build()))));
    public static final RegistryObject<Item> EC2_UPGRADE = ITEMS.register("upgrades/ec2", () -> createItem(new TardisPartItem(TardisConstants.Part.PartType.UPGRADE, false, false, TardisConstants.Translations.TEMPORAL_GRACE)));
    public static final RegistryObject<Item> NOBADOMEN_UPGRADE = ITEMS.register("upgrades/goodomen", () -> createItem(new TardisPartItem(TardisConstants.Part.PartType.UPGRADE, false, false, TardisConstants.Translations.TEMPORAL_GRACE)));
    public static final RegistryObject<Item> ZR2_UPGRADE = ITEMS.register("upgrades/zr2", () -> createItem(new TardisPartItem(TardisConstants.Part.PartType.UPGRADE, false, false, TardisConstants.Translations.TEMPORAL_GRACE)));
    public static final RegistryObject<Item> FRAME_UPGRADE = ITEMS.register("upgrades/frame_stabilizer", () -> createItem(new TardisPartItem(TardisConstants.Part.PartType.UPGRADE, false, false, new TranslationTextComponent("item." + QolMod.MOD_ID + ".subsystem.stabilizers"))));
    public static final RegistryObject<Item> MURASAMA = ITEMS.register("murasama", () -> createItem(new Murasama(MItemTier.MURASAMA, 1,-2f, new Item.Properties().group(ItemGroup.COMBAT).isImmuneToFire())));
    public static final RegistryObject<Item> ONEUSEREMOTE = ITEMS.register("onetimeremote", () -> createItem(new OneUseRemoteItem(Prop.Items.ONE.get().group(TItemGroups.MAIN))));
    public static final RegistryObject<Item> BOOS_UPGRADE = ITEMS.register("data_drive", () -> createItem(new VergeOpener(Prop.Items.ONE.get().group(TItemGroups.MAINTENANCE))));
    public static final RegistryObject<Item> AEON_CRYSTAL = ITEMS.register("aeon_crystal", () -> createItem(new Item(Prop.Items.SIXTY_FOUR.get().group(TItemGroups.MAINTENANCE))));
    public static final RegistryObject<Item> UNDEADLOCKER = ITEMS.register("undeadlocker", () -> createItem(new UndeadLocker()));
    public static final RegistryObject<Item> data_crystal = ITEMS.register("data_crystal", () -> createItem(new Item(Prop.Items.SIXTY_FOUR.get().group(TItemGroups.MAINTENANCE))));
    public static final RegistryObject<Item> QUANTUM_EXOTIC_MATTER= ITEMS.register("quantum_entangled_exotic_matter", () -> createItem(new QuantumExoticMatterItem(Prop.Items.SIXTY_FOUR.get().group(TItemGroups.MAINTENANCE))));
    public static final RegistryObject<Item> MUSICDISK1 = ITEMS.register("dusty_music_disc_fallen_flame", () -> createItem(new MusicDiscItem(1, () -> MSounds.DISC1.get(), new Item.Properties().maxStackSize(1).group(ItemGroup.MISC))));
    public static final RegistryObject<Item> MUSICDISK2 = ITEMS.register("dusty_music_disc_madmans_lullaby", () -> createItem(new MusicDiscItem(1, () -> MSounds.DISC2.get(), new Item.Properties().maxStackSize(1).group(ItemGroup.MISC))));
    public static final RegistryObject<Item> MUSICDISK3 = ITEMS.register("dusty_music_disc_hold_strong", () -> createItem(new MusicDiscItem(1, () -> MSounds.DISC3.get(), new Item.Properties().maxStackSize(1).group(ItemGroup.MISC))));
    public static final RegistryObject<Item> MUSICDISK5 = ITEMS.register("placeholder_disc", () -> createItem(new MusicDiscItem(1, () -> MSounds.DISC4.get(), new Item.Properties().maxStackSize(1).group(ItemGroup.MISC))));
    public static final RegistryObject<Item> DEMAT_CIRCUITMK2 = ITEMS.register("subsystem/dematerialisation_circuit_mk2", () -> createItem(new SubsysItem(Prop.Items.ONE.get().maxDamage(3000).group(TItemGroups.MAINTENANCE).setISTER(() -> DematRenderer::new), TardisConstants.Part.PartType.SUBSYSTEM, false, true)));
    public static final RegistryObject<Item> FLUID_LINKMK2 = ITEMS.register("subsystem/fluid_link_mk2", () -> createItem(new SubsysItem(Prop.Items.ONE.get().maxDamage(1000).group(TItemGroups.MAINTENANCE).setISTER(() -> FluidLinkRenderer::new), TardisConstants.Part.PartType.SUBSYSTEM, false, true)));
    public static final RegistryObject<Item> CHAMELEON_CIRCUITMK2 = ITEMS.register("subsystem/chameleon_circuit_mk2", () -> createItem(new TardisPartItem(Prop.Items.ONE.get().maxDamage(1000).group(TItemGroups.MAINTENANCE), TardisConstants.Part.PartType.SUBSYSTEM, false, true)));
    public static final RegistryObject<Item> INTERSTITIAL_ANTENNAMK2 = ITEMS.register("subsystem/interstitial_antenna_mk2", () -> createItem(new TardisPartItem(Prop.Items.ONE.get().maxDamage(1000).group(TItemGroups.MAINTENANCE), TardisConstants.Part.PartType.SUBSYSTEM, false, true)));
    public static final RegistryObject<Item> TEMPORAL_GRACEMK2 = ITEMS.register("subsystem/temporal_grace_mk2", () -> createItem(new TardisPartItem(Prop.Items.ONE.get().maxDamage(1000).group(TItemGroups.MAINTENANCE), TardisConstants.Part.PartType.SUBSYSTEM, false, true)));
    public static final RegistryObject<Item> SHEILD_GENERATORMK2 = ITEMS.register("subsystem/shield_generator_mk2", () -> createItem(new TardisPartItem(Prop.Items.ONE.get().maxDamage(1000).group(TItemGroups.MAINTENANCE), TardisConstants.Part.PartType.SUBSYSTEM, false, true)));
    public static final RegistryObject<Item> STABILIZERSMK2 = ITEMS.register("subsystem/stabilizer_mk2", () -> createItem(new TardisPartItem(Prop.Items.ONE.get().maxDamage(1000).group(TItemGroups.MAINTENANCE), TardisConstants.Part.PartType.SUBSYSTEM, false, true)));
    public static final RegistryObject<Item> NAV_COMMK2 = ITEMS.register("subsystem/nav_com_mk2", () -> createItem(new TardisPartItem(Prop.Items.ONE.get().maxDamage(1000).group(TItemGroups.MAINTENANCE), TardisConstants.Part.PartType.SUBSYSTEM, false, true)));
    public static final RegistryObject<Item> POWERAXE = ITEMS.register("power_axe", () -> createItem(new PowerAxe(MItemTier.POWERAXE, 1,-3f, new Item.Properties().group(ItemGroup.COMBAT).isImmuneToFire().addToolType(ToolType.AXE, 10))));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    private static <T extends Item> T createItem(T item) {
        return item;
    }

}
