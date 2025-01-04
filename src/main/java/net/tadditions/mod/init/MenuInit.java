package net.tadditions.mod.init;

import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tadditions.mod.TemporalAdditionsMod;
import net.tadditions.mod.menu.PhasingQuantascopeMenu;

public class MenuInit
{
    public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, TemporalAdditionsMod.MOD_ID);

    public static final RegistryObject<MenuType<PhasingQuantascopeMenu>> PHASING_QUANTASCOPE =
            registerMenuType(PhasingQuantascopeMenu::new, "phasing_quantascope");

    private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> registerMenuType(IContainerFactory<T> factory, String name)
    {
        return CONTAINERS.register(name, () -> IForgeMenuType.create(factory));
    }


    public static void register(IEventBus eventBus)
    {
        CONTAINERS.register(eventBus);
    }
}

