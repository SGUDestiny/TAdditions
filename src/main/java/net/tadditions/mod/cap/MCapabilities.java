package net.tadditions.mod.cap;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class MCapabilities extends net.tardis.mod.cap.Capabilities {

    @CapabilityInject(IOneRemote.class)
    public static final Capability<IOneRemote> ONE_REMOTE_CAPABILITY = null;

    @CapabilityInject(IOpener.class)
    public static final Capability<IOpener> OPENER_CAPABILITY = null;

    @CapabilityInject(IQuant.class)
    public static final Capability<IQuant> QUANT_CAPABILITY = null;

}
