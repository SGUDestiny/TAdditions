package net.tadditions.mod.init;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.tadditions.mod.TemporalAdditionsMod;
import net.tadditions.mod.upgrades.EntropicDriftingUpgrade;
import net.tardis.mod.helpers.Helper;
import net.tardis.mod.registry.UpgradeRegistry;
import net.tardis.mod.upgrade.Upgrade;
import net.tardis.mod.upgrade.types.TardisUpgradeType;
import net.tardis.mod.upgrade.types.UpgradeType;

public class UpgradeInit
{
    public static final DeferredRegister<UpgradeType<?, ? extends Upgrade<?>>> UPGRADES = DeferredRegister.create(UpgradeRegistry.REGISTRY.get(), TemporalAdditionsMod.MOD_ID);

    public static RegistryObject<TardisUpgradeType<EntropicDriftingUpgrade>> TARDIS_DRIFT = UPGRADES.register("tardis/drift", () ->
            new TardisUpgradeType<>(stack -> stack.getItem() == ItemInit.UPGRADE_ENTROPIC_DRIFTING.get(), EntropicDriftingUpgrade::new));

    public static void register(IEventBus bus)
    {
        UPGRADES.register(bus);
    }

}
