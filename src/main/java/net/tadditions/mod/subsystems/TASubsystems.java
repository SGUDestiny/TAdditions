package net.tadditions.mod.subsystems;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;
import net.minecraftforge.registries.RegistryObject;
import net.tardis.mod.Constants;
import net.tardis.mod.helpers.Helper;
import net.tardis.mod.item.ItemRegistry;
import net.tardis.mod.registry.SubsystemRegistry;
import net.tardis.mod.subsystem.BasicSubsystem;
import net.tardis.mod.subsystem.SubsystemType;

import java.util.function.Supplier;

public class TASubsystems {
    public TASubsystems()
    {}

    public static void registerSubsystems() {
        ((SubsystemType) SubsystemRegistry.FLIGHT_TYPE.get()).registerSubsystem((stack) -> {
            return stack.getItem() == ItemRegistry.DEMAT_CIRCUIT.get();
        }, BasicSubsystem::new);
    }

}
