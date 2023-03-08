package net.tadditions.mod.protocol;

import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;
import net.tardis.mod.Tardis;
import net.tardis.mod.protocols.*;
import net.tardis.mod.registries.ProtocolRegistry;

import java.util.function.Supplier;

public class MProtocolRegistry extends ProtocolRegistry {
	
    public static final DeferredRegister<Protocol> PROTOCOLS = DeferredRegister.create(Protocol.class, Tardis.MODID);

	//public static final RegistryObject<Protocol> INT_GRAV = PROTOCOLS.register("int_grav", () -> new IntGravProtocol());
}
