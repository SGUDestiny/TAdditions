package net.tadditions.mod.container;

import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.tadditions.mod.QolMod;

public class MContainers {
    public static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, QolMod.MOD_ID);

    public static final RegistryObject<ContainerType<AdvQuantiscopeWeldContainer>> ADVQUANTISCOPE_WELD = CONTAINERS.register("advquantiscope_weld", () -> registerContainer(AdvQuantiscopeWeldContainer::new));
    public static final RegistryObject<ContainerType<DataDriveContainer>> DATADRIVE = CONTAINERS.register("data_drive", () -> registerContainer(DataDriveContainer::new));

    public static <T extends Container> ContainerType<T> registerContainer(IContainerFactory<T> fact){
        ContainerType<T> type = new ContainerType<T>(fact);
        return type;
    }
}
