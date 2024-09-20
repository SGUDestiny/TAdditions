package net.tadditions.mod.init;

import net.minecraft.world.level.ChunkPos;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.tadditions.mod.TemporalAdditionsMod;
import net.tadditions.mod.phenomena.EntropicDriftPhenomena;
import net.tardis.mod.helpers.Helper;
import net.tardis.mod.misc.tardis.vortex.VortexPhenomenaType;

public class PhenomenaInit
{
    public static final DeferredRegister<VortexPhenomenaType<?>> PHENOMENA = DeferredRegister.create(Helper.createRL("vortex_phenomena"), TemporalAdditionsMod.MOD_ID);

    public static final RegistryObject<VortexPhenomenaType<EntropicDriftPhenomena>> ENTROPIC_DRIFT = PHENOMENA.register("entropic_drift", () ->
            new VortexPhenomenaType<>(EntropicDriftPhenomena::new)
    );

    public static void register(IEventBus bus)
    {
        PHENOMENA.register(bus);
    }
}
