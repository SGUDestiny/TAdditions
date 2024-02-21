package net.tadditions.mod.compat.create;

import com.simibubi.create.content.contraptions.itemAssembly.SequencedAssemblyItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.client.model.incomplete.ChameleonIncompleteModel;
import net.tadditions.mod.client.renderers.*;
import net.tadditions.mod.items.ModItemGroups;
import net.tadditions.mod.items.ModItems;

public class CreateItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, QolMod.MOD_ID);

    public static final RegistryObject<Item> INCOMPLETE_DEMAT = ITEMS.register("dematerialisation_circuit_incomplete", () -> createItem(new SequencedAssemblyItem((new Item.Properties()).group(ModItemGroups.TA))));
    public static final RegistryObject<Item> INCOMPLETE_FLUID = ITEMS.register("fluid_link_incomplete", () -> createItem(new SequencedAssemblyItem((new Item.Properties()).group(ModItemGroups.TA))));
    public static final RegistryObject<Item> INCOMPLETE_NAVCOM = ITEMS.register("nav_com_incomplete", () -> createItem(new SequencedAssemblyItem((new Item.Properties()).group(ModItemGroups.TA))));
    public static final RegistryObject<Item> INCOMPLETE_STAB = ITEMS.register("stabilizer_incomplete", () -> createItem(new SequencedAssemblyItem((new Item.Properties()).group(ModItemGroups.TA))));
    public static final RegistryObject<Item> INCOMPLETE_SHIELD = ITEMS.register("shield_generator_incomplete", () -> createItem(new SequencedAssemblyItem((new Item.Properties()).group(ModItemGroups.TA))));
    public static final RegistryObject<Item> INCOMPLETE_GRACE = ITEMS.register("temporal_grace_incomplete", () -> createItem(new SequencedAssemblyItem((new Item.Properties()).group(ModItemGroups.TA))));
    public static final RegistryObject<Item> INCOMPLETE_ANTENNA = ITEMS.register("interstitial_antenna_incomplete", () -> createItem(new SequencedAssemblyItem((new Item.Properties()).group(ModItemGroups.TA))));
    public static final RegistryObject<Item> INCOMPLETE_CHAMELEON = ITEMS.register("chameleon_circuit_incomplete", () -> createItem(new SequencedAssemblyItem((new Item.Properties()).group(ModItemGroups.TA))));
    public static final RegistryObject<Item> INCOMPLETE_DEMAT2 = ITEMS.register("dematerialisation_circuit_overcharged_incomplete", () -> createItem(new AnimatedSequenceAssemblyItem((new Item.Properties()).group(ModItemGroups.TA).setISTER(() -> IncompleteDematRenderer::new))));
    public static final RegistryObject<Item> INCOMPLETE_FLUID2 = ITEMS.register("fluid_link_overcharged_incomplete", () -> createItem(new AnimatedSequenceAssemblyItem((new Item.Properties()).group(ModItemGroups.TA).setISTER(() -> IncompleteFluidLinkRenderer::new))));
    public static final RegistryObject<Item> INCOMPLETE_NAVCOM2 = ITEMS.register("nav_com_overcharged_incomplete", () -> createItem(new AnimatedSequenceAssemblyItem((new Item.Properties()).group(ModItemGroups.TA).setISTER(() -> IncompleteNavComRenderer::new))));
    public static final RegistryObject<Item> INCOMPLETE_STAB2 = ITEMS.register("stabilizer_overcharged_incomplete", () -> createItem(new AnimatedSequenceAssemblyItem((new Item.Properties()).group(ModItemGroups.TA).setISTER(() -> IncompleteStabilizerRenderer::new))));
    public static final RegistryObject<Item> INCOMPLETE_SHIELD2 = ITEMS.register("shield_generator_overcharged_incomplete", () -> createItem(new AnimatedSequenceAssemblyItem((new Item.Properties()).group(ModItemGroups.TA).setISTER(() -> IncompleteShieldRenderer::new))));
    public static final RegistryObject<Item> INCOMPLETE_GRACE2 = ITEMS.register("temporal_grace_overcharged_incomplete", () -> createItem(new AnimatedSequenceAssemblyItem((new Item.Properties()).group(ModItemGroups.TA).setISTER(() -> IncompleteGraceRenderer::new))));
    public static final RegistryObject<Item> INCOMPLETE_ANTENNA2 = ITEMS.register("interstitial_antenna_overcharged_incomplete", () -> createItem(new AnimatedSequenceAssemblyItem((new Item.Properties()).group(ModItemGroups.TA).setISTER(() -> IncompleteAntennaRenderer::new))));
    public static final RegistryObject<Item> INCOMPLETE_CHAMELEON2 = ITEMS.register("chameleon_circuit_overcharged_incomplete", () -> createItem(new AnimatedSequenceAssemblyItem((new Item.Properties()).group(ModItemGroups.TA).setISTER(() -> IncompleteChameleonRenderer::new))));
    public static final RegistryObject<Item> INCOMPLETE_CAP1 = ITEMS.register("artron_capacitor_incomplete", () -> createItem(new SequencedAssemblyItem((new Item.Properties()).group(ModItemGroups.TA))));
    public static final RegistryObject<Item> INCOMPLETE_CAP2 = ITEMS.register("artron_capacitor_mid_incomplete", () -> createItem(new SequencedAssemblyItem((new Item.Properties()).group(ModItemGroups.TA))));
    public static final RegistryObject<Item> INCOMPLETE_CAP3 = ITEMS.register("artron_capacitor_high_incomplete", () -> createItem(new SequencedAssemblyItem((new Item.Properties()).group(ModItemGroups.TA))));
    public static final RegistryObject<Item> INCOMPLETE_CAP4 = ITEMS.register("artron_capacitor_speed_incomplete", () -> createItem(new SequencedAssemblyItem((new Item.Properties()).group(ModItemGroups.TA))));
    public static final RegistryObject<Item> INCOMPLETE_CAP5 = ITEMS.register("artron_capacitor_ultra_incomplete", () -> createItem(new SequencedAssemblyItem((new Item.Properties()).group(ModItemGroups.TA))));
    public static final RegistryObject<Item> INCOMPLETE_CAP6 = ITEMS.register("artron_capacitor_temporal_incomplete", () -> createItem(new SequencedAssemblyItem((new Item.Properties()).group(ModItemGroups.TA))));
    public static final RegistryObject<Item> INCOMPLETE_BAT1 = ITEMS.register("artron_battery_incomplete", () -> createItem(new SequencedAssemblyItem((new Item.Properties()).group(ModItemGroups.TA))));
    public static final RegistryObject<Item> INCOMPLETE_BAT2 = ITEMS.register("artron_battery_medium_incomplete", () -> createItem(new SequencedAssemblyItem((new Item.Properties()).group(ModItemGroups.TA))));
    public static final RegistryObject<Item> INCOMPLETE_BAT3 = ITEMS.register("artron_battery_high_incomplete", () -> createItem(new SequencedAssemblyItem((new Item.Properties()).group(ModItemGroups.TA))));
    public static final RegistryObject<Item> INCOMPLETE_BAT4 = ITEMS.register("artron_battery_speed_incomplete", () -> createItem(new SequencedAssemblyItem((new Item.Properties()).group(ModItemGroups.TA))));
    public static final RegistryObject<Item> INCOMPLETE_BAT5 = ITEMS.register("artron_battery_ultra_incomplete", () -> createItem(new SequencedAssemblyItem((new Item.Properties()).group(ModItemGroups.TA))));
    public static final RegistryObject<Item> INCOMPLETE_BAT6 = ITEMS.register("artron_battery_temporal_incomplete", () -> createItem(new SequencedAssemblyItem((new Item.Properties()).group(ModItemGroups.TA))));


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
