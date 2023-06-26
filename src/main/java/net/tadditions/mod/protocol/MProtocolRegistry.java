package net.tadditions.mod.protocol;

import net.minecraftforge.registries.DeferredRegister;
import net.tadditions.mod.QolMod;
import net.tardis.mod.protocols.Protocol;
import net.tardis.mod.registries.ProtocolRegistry;

public class MProtocolRegistry extends ProtocolRegistry {
	
        public static final DeferredRegister<Protocol> PROTOCOLS = DeferredRegister.create(Protocol.class, QolMod.MOD_ID);
}
