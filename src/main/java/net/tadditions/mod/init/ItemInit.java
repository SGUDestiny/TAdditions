package net.tadditions.mod.init;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tadditions.mod.TemporalAdditionsMod;
import net.tadditions.mod.upgrades.EntropicDriftingUpgrade;
import net.tardis.mod.item.components.ArtronCapacitorItem;
import net.tardis.mod.item.components.UpgradeItem;
import net.tardis.mod.registry.UpgradeRegistry;
import net.tardis.mod.upgrade.tardis.NanoGeneTardisUpgrade;
import net.tardis.mod.upgrade.types.TardisUpgradeType;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TemporalAdditionsMod.MOD_ID);

    public static final RegistryObject<ArtronCapacitorItem> ARTRON_CAPACITOR_TEMPORAL = ITEMS.register("artron_capacitors/temporal",
            () -> new ArtronCapacitorItem(new Item.Properties().stacksTo(1), 2048));
    public static final RegistryObject<ArtronCapacitorItem> ARTRON_CAPACITOR_SPEED = ITEMS.register("artron_capacitors/speed",
            () -> new ArtronCapacitorItem(new Item.Properties().stacksTo(1), 128));
    public static final RegistryObject<ArtronCapacitorItem> ARTRON_CAPACITOR_ULTRA = ITEMS.register("artron_capacitors/ultra",
            () -> new ArtronCapacitorItem(new Item.Properties().stacksTo(1), 1024));

    public static final RegistryObject<UpgradeItem<TardisUpgradeType<EntropicDriftingUpgrade>, EntropicDriftingUpgrade>> UPGRADE_ENTROPIC_DRIFTING = ITEMS.register("upgrades/entropic_drift",
            () -> UpgradeItem.create(UpgradeInit.TARDIS_DRIFT));


    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
