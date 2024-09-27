package net.tadditions.mod.init;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tadditions.mod.TemporalAdditionsMod;
import net.tadditions.mod.item.ArtronCapacitorItem;
import net.tadditions.mod.upgrades.EntropicDriftingUpgrade;
import net.tardis.mod.item.components.UpgradeItem;
import net.tardis.mod.upgrade.types.TardisUpgradeType;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TemporalAdditionsMod.MOD_ID);

    public static final RegistryObject<ArtronCapacitorItem> ARTRON_CAPACITOR_TEMPORAL = ITEMS.register("artron_capacitors/temporal",
            () -> new ArtronCapacitorItem(new Item.Properties().stacksTo(1), 2048, 0.5f));
    public static final RegistryObject<ArtronCapacitorItem> ARTRON_CAPACITOR_VORTEX = ITEMS.register("artron_capacitors/vortex",
            () -> new ArtronCapacitorItem(new Item.Properties().stacksTo(1), 512, 0.025f));
    public static final RegistryObject<ArtronCapacitorItem> ARTRON_CAPACITOR_QUANTUM = ITEMS.register("artron_capacitors/quantum",
            () -> new ArtronCapacitorItem(new Item.Properties().stacksTo(1), 1024, -0.025f));

    public static final RegistryObject<UpgradeItem<TardisUpgradeType<EntropicDriftingUpgrade>, EntropicDriftingUpgrade>> UPGRADE_ENTROPIC_DRIFTING = ITEMS.register("upgrades/entropic_drift",
            () -> UpgradeItem.create(UpgradeInit.TARDIS_DRIFT));


    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
