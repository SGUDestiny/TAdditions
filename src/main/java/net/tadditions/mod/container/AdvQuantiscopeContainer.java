package net.tadditions.mod.container;

import net.minecraft.inventory.container.ContainerType;
import net.tadditions.mod.tileentity.AdvQuantiscopeTile;
import net.tardis.mod.containers.BlockEntityContextContainer;

import javax.annotation.Nullable;

public abstract class AdvQuantiscopeContainer extends BlockEntityContextContainer<AdvQuantiscopeTile> {

    protected AdvQuantiscopeContainer(@Nullable ContainerType<?> type, int id) {
        super(type, id);
    }
}
