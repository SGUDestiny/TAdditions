package net.tadditions.mod.container;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.tadditions.mod.cap.MCapabilities;
import net.tadditions.mod.items.ModItems;
import net.tardis.mod.artron.IArtronItemStackBattery;
import net.tardis.mod.containers.BaseContainer;
import net.tardis.mod.containers.IContainerUtil;
import net.tardis.mod.containers.TContainers;
import net.tardis.mod.containers.slot.SlotItemHandlerFiltered;
import net.tardis.mod.helper.PlayerHelper;
import net.tardis.mod.helper.TInventoryHelper;

/**
 * Created by 50ap5ud5
 * on 22 Apr 2020 @ 8:12:47 pm
 */
public class DataDriveContainer extends BaseContainer {

	private ItemStack datadrive;

    public DataDriveContainer(ContainerType<?> type, int id) {
	    super(type, id);
    }
    /** Client Only constructor */
	public DataDriveContainer(int id, PlayerInventory playerInventoryIn, PacketBuffer buf) {
		 this(id, playerInventoryIn, buf.readItemStack());
	}

	/** Server Only constructor */
	public DataDriveContainer(int id, PlayerInventory playerInventoryIn, ItemStack stack) {
		super(MContainers.DATADRIVE.get(),id);
		
		this.datadrive = stack;
	      
		stack.getCapability(MCapabilities.OPENER_CAPABILITY).ifPresent(cap -> {
			this.addSlot(new SlotItemHandlerFiltered(cap.getHandler(), 0, 81, 45, item -> item.getItem().equals(ModItems.data_crystal.get())));
		});


		TInventoryHelper.addPlayerInvContainer(this, playerInventoryIn,  0, 23);
	}
	
	public ItemStack getStack() {
		return this.datadrive;
	}
}
