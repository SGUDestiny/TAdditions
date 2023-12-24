package net.tadditions.mod.items;

import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.item.*;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.IModBusEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.blocks.ModBlocks;
import net.tadditions.mod.client.renderers.*;
import net.tadditions.mod.fluids.MFluids;
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

    public static final RegistryObject<Item> FOODCUBE = ITEMS.register("foodcube", () -> createItem(new Item((new Item.Properties()).group(ModItemGroups.TA).food(new Food.Builder().hunger(3).saturation(3F).build()))));
    public static final RegistryObject<Item> IMPULSE_KEY = ITEMS.register("impulse_key", () -> createItem(new CoreKeyItem(Prop.Items.ONE.get().group(ModItemGroups.TA).isImmuneToFire().setISTER(() -> ImpulseKeyRenderer::new))));
    public static final RegistryObject<Item> ARCANE_GUIDEBOOK = ITEMS.register("arcane_guidebook", () -> createItem(new ArcaneGuidebookItem(Prop.Items.ONE.get().group(ModItemGroups.TA).setISTER(() -> ArcaneGuideBookRenderer::new))));
    public static final RegistryObject<Item> ULTRA_HIGH_CAPACITY_ARTRON_CAPACITOR = ITEMS.register("artron_capacitor_ultra",
            () -> new ArtronCapacitorItem(1024F, 0.5F));
    public static final RegistryObject<Item> ULTRA_HIGH_RECHARGE_ARTRON_CAPACITOR = ITEMS.register("artron_capacitor_speed",
            () -> new ArtronCapacitorItem(128F, 4));
    public static final RegistryObject<Item> ARTRON_CAPACITOR_TEMPORAL = ITEMS.register("artron_capacitor_temporal",
            () -> new ArtronCapacitorItem(2048F, 7F));
    public static final RegistryObject<Item> ARTRON_BATTERY_ULTRA = ITEMS.register("artron_battery_ultra", () -> createItem(new ArtronItemStackBatteryItem(3.5F, 0.4F, 6000F, false)));
    public static final RegistryObject<Item> ARTRON_BATTERY_ARTRON_SYPHON = ITEMS.register("artron_battery_speed", () -> createItem(new ArtronItemStackBatteryItem(6F, 0.1F, 750F, false)));
    public static final RegistryObject<Item> ARTRON_BATTERY_TEMPORAL_SYPHON = ITEMS.register("artron_battery_temporal", () -> createItem(new ArtronItemStackBatteryItem(7.5F, 0.17F, 11000F, false)));
    public static final RegistryObject<Item> THERMAL_PROTECTION_UPGRADE = ITEMS.register("upgrades/thermal_protection", () -> createItem(new TardisPartItem(Prop.Items.ONE.get().group(ModItemGroups.TA).maxDamage(1000), TardisConstants.Part.PartType.UPGRADE, false, true, TardisConstants.Translations.TEMPORAL_GRACE)));
    public static final RegistryObject<Item> EC2_UPGRADE = ITEMS.register("upgrades/ec2", () -> createItem(new TardisPartItem(Prop.Items.ONE.get().group(ModItemGroups.TA).maxDamage(1000), TardisConstants.Part.PartType.UPGRADE, false, true, TardisConstants.Translations.TEMPORAL_GRACE)));
    public static final RegistryObject<Item> NOBADOMEN_UPGRADE = ITEMS.register("upgrades/goodomen", () -> createItem(new TardisPartItem(Prop.Items.ONE.get().group(ModItemGroups.TA).maxDamage(1000), TardisConstants.Part.PartType.UPGRADE, true, false, TardisConstants.Translations.TEMPORAL_GRACE)));
    public static final RegistryObject<Item> ZR2_UPGRADE = ITEMS.register("upgrades/zr2", () -> createItem(new TardisPartItem(Prop.Items.ONE.get().group(ModItemGroups.TA).maxDamage(1000), TardisConstants.Part.PartType.UPGRADE, false, true, TardisConstants.Translations.TEMPORAL_GRACE)));
    public static final RegistryObject<Item> FRAME_UPGRADE = ITEMS.register("upgrades/frame_stabilizer", () -> createItem(new TardisPartItem(Prop.Items.ONE.get().group(ModItemGroups.TA).maxDamage(1000), TardisConstants.Part.PartType.UPGRADE, false, true, TardisConstants.Translations.DEMAT_CIRCUIT)));
    public static final RegistryObject<Item> MURASAMA = ITEMS.register("murasama", () -> createItem(new Murasama(MItemTier.MURASAMA, 1,-2f, new Item.Properties().group(ModItemGroups.TA).isImmuneToFire().setISTER(() -> MurasamaRenderer::new))));
    public static final RegistryObject<Item> ONEUSEREMOTE = ITEMS.register("onetimeremote", () -> createItem(new OneUseRemoteItem(Prop.Items.ONE.get().group(ModItemGroups.TA))));
    public static final RegistryObject<Item> BOOS_UPGRADE = ITEMS.register("data_drive", () -> createItem(new VergeOpener(Prop.Items.ONE.get().group(ModItemGroups.TA))));
    public static final RegistryObject<Item> AEON_CRYSTAL = ITEMS.register("aeon_crystal", () -> createItem(new Item(Prop.Items.SIXTY_FOUR.get().group(ModItemGroups.TA))));
    public static final RegistryObject<Item> UNDEADLOCKER = ITEMS.register("undeadlocker", () -> createItem(new UndeadLocker()));
    public static final RegistryObject<Item> data_crystal = ITEMS.register("data_crystal", () -> createItem(new Item(Prop.Items.SIXTY_FOUR.get().group(ModItemGroups.TA))));
    public static final RegistryObject<Item> QUANTUM_EXOTIC_MATTER= ITEMS.register("exotic_matter", () -> createItem(new QuantumExoticMatterItem(Prop.Items.SIXTY_FOUR.get().group(ModItemGroups.TA))));
    public static final RegistryObject<Item> DEMAT_CIRCUITMK2 = ITEMS.register("subsystem/dematerialisation_circuit_overcharged", () -> createItem(new SubsysItem(Prop.Items.ONE.get().maxDamage(5000).group(ModItemGroups.TA).setISTER(() -> DematRenderer::new), TardisConstants.Part.PartType.SUBSYSTEM, false, true)));
    public static final RegistryObject<Item> FLUID_LINKMK2 = ITEMS.register("subsystem/fluid_link_overcharged", () -> createItem(new SubsysItem(Prop.Items.ONE.get().maxDamage(1250).group(ModItemGroups.TA).setISTER(() -> FluidLinkRenderer::new), TardisConstants.Part.PartType.SUBSYSTEM, false, true)));
    public static final RegistryObject<Item> CHAMELEON_CIRCUITMK2 = ITEMS.register("subsystem/chameleon_circuit_overcharged", () -> createItem(new SubsysItem(Prop.Items.ONE.get().maxDamage(1250).group(ModItemGroups.TA).setISTER(() -> ChameleonRenderer::new), TardisConstants.Part.PartType.SUBSYSTEM, false, true)));
    public static final RegistryObject<Item> INTERSTITIAL_ANTENNAMK2 = ITEMS.register("subsystem/interstitial_antenna_overcharged", () -> createItem(new SubsysItem(Prop.Items.ONE.get().maxDamage(1250).group(ModItemGroups.TA).setISTER(() -> AntennaRenderer::new), TardisConstants.Part.PartType.SUBSYSTEM, false, true)));
    public static final RegistryObject<Item> TEMPORAL_GRACEMK2 = ITEMS.register("subsystem/temporal_grace_overcharged", () -> createItem(new SubsysItem(Prop.Items.ONE.get().maxDamage(1250).group(ModItemGroups.TA).setISTER(() -> GraceRenderer::new), TardisConstants.Part.PartType.SUBSYSTEM, false, true)));
    public static final RegistryObject<Item> SHEILD_GENERATORMK2 = ITEMS.register("subsystem/shield_generator_overcharged", () -> createItem(new SubsysItem(Prop.Items.ONE.get().maxDamage(1250).group(ModItemGroups.TA).setISTER(() -> ShieldRenderer::new), TardisConstants.Part.PartType.SUBSYSTEM, false, true)));
    public static final RegistryObject<Item> STABILIZERSMK2 = ITEMS.register("subsystem/stabilizer_overcharged", () -> createItem(new SubsysItem(Prop.Items.ONE.get().maxDamage(1250).group(ModItemGroups.TA).setISTER(() -> StabilizerRenderer::new), TardisConstants.Part.PartType.SUBSYSTEM, false, true)));
    public static final RegistryObject<Item> NAV_COMMK2 = ITEMS.register("subsystem/nav_com_overcharged", () -> createItem(new SubsysItem(Prop.Items.ONE.get().maxDamage(1250).group(ModItemGroups.TA).setISTER(() -> NavComRenderer::new), TardisConstants.Part.PartType.SUBSYSTEM, false, true)));

    public static final RegistryObject<BucketItem> MERCURY_BUCKET = ITEMS.register("mercury_bucket", () -> createItem(new BucketItem(() -> MFluids.MERCURY_FLUID.get(), (new Item.Properties().maxStackSize(1).containerItem(Items.BUCKET).group(ItemGroup.MISC)))));
    //public static final RegistryObject<Item> POWERAXE = ITEMS.register("power_axe", () -> createItem(new PowerAxe(MItemTier.POWERAXE, 1,-2.7f, new Item.Properties().group(ModItemGroups.TA).isImmuneToFire().addToolType(ToolType.AXE, 10))));

    public static final RegistryObject<Item> CREATIVE_CAPACITOR = ITEMS.register("artron_capacitor_creative", () -> createItem(new ArtronCapacitorItem(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static <T extends Item> T createItem(T item) {
        return item;
    }

    public static <T extends BlockItem> T createBlockItem(T item) {
        return item;
    }

}
