package net.tadditions.mod.init;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tadditions.mod.TemporalAdditionsMod;
import net.tadditions.mod.phenomena.EntropicDriftPhenomena;
import net.tadditions.mod.phenomena.TimeStormPhenomena;
import net.tardis.mod.helpers.Helper;
import net.tardis.mod.misc.tardis.vortex.VortexPhenomenaType;
import net.tardis.mod.registry.VortexPhenomenaRegistry;

public class PhenomenaInit
{
    public static final DeferredRegister<VortexPhenomenaType<?>> PHENOMENA = DeferredRegister.create(VortexPhenomenaRegistry.REGISTRY.get(), TemporalAdditionsMod.MOD_ID);

    public static final RegistryObject<VortexPhenomenaType<EntropicDriftPhenomena>> ENTROPIC_DRIFT = PHENOMENA.register("entropic_drift", () ->
            new VortexPhenomenaType<>(EntropicDriftPhenomena::new)
    );

    public static final RegistryObject<VortexPhenomenaType<TimeStormPhenomena>> TIME_STORM = PHENOMENA.register("time_storm", () ->
            new VortexPhenomenaType<>(TimeStormPhenomena::new)
    );

    public static void register(IEventBus bus)
    {
        PHENOMENA.register(bus);
    }
}
