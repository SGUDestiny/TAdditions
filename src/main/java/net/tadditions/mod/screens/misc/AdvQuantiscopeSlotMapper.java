package net.tadditions.mod.screens.misc;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Slot;
import net.tadditions.mod.container.AdvQuantiscopeContainer;

public abstract class AdvQuantiscopeSlotMapper {

    public void addPlayerSlots(AdvQuantiscopeContainer container, PlayerInventory inv){
        //Add Main inv
        for(int row = 0; row < 3; ++row) {
            for(int slot = 0; slot < 9; ++slot) {
                container.addSlot(new Slot(inv, slot + row * 9 + 9, 8 + slot * 18, 81 + row * 18 + 3));
            }
        }

        //Add hot bar
        for(int i1 = 0; i1 < 9; ++i1) {
            container.addSlot(new Slot(inv, i1, 8 + i1 * 18, 139 + 3));
        }
    }

}
