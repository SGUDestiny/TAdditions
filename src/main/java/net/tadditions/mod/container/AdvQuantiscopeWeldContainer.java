package net.tadditions.mod.container;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.items.SlotItemHandler;
import net.tadditions.mod.tileentity.AdvQuantiscopeTile;
import net.tardis.mod.helper.TInventoryHelper;

public class AdvQuantiscopeWeldContainer extends AdvQuantiscopeContainer {
	
	protected AdvQuantiscopeWeldContainer(ContainerType<?> type, int id) {
		super(type, id);
	}
	/** Client Only constructor */
	public AdvQuantiscopeWeldContainer(int id, PlayerInventory inv, PacketBuffer buf) {
		super(MContainers.ADVQUANTISCOPE_WELD.get(), id);
		this.init(inv, (AdvQuantiscopeTile)inv.player.world.getTileEntity(buf.readBlockPos()));
	}
	/** Server Only constructor */
	public AdvQuantiscopeWeldContainer(int id, PlayerInventory inv, AdvQuantiscopeTile tile) {
		super(MContainers.ADVQUANTISCOPE_WELD.get(), id);
		this.init(inv, tile);
	}
	
	public void init(PlayerInventory inv, AdvQuantiscopeTile quantiscope) {
		
		blockEntity = quantiscope;
		
		//Parts
		this.addSlot(new SlotItemHandler(quantiscope, 0, 8, 4));
		this.addSlot(new SlotItemHandler(quantiscope, 1, 21, -16));
		this.addSlot(new SlotItemHandler(quantiscope, 2, 42, -16));
		this.addSlot(new SlotItemHandler(quantiscope, 3, 21, 24));
		this.addSlot(new SlotItemHandler(quantiscope, 4, 42, 24));
		
		//Thing to repair
		this.addSlot(new SlotItemHandler(quantiscope, 5, 56, 4));

		this.addSlot(new SlotItemHandler(quantiscope, 6, 151, 4));
		this.addSlot(new SlotItemHandler(quantiscope, 7, 137, -16));
		this.addSlot(new SlotItemHandler(quantiscope, 8, 116, -16));
		this.addSlot(new SlotItemHandler(quantiscope, 9, 137, 24));
		this.addSlot(new SlotItemHandler(quantiscope, 10, 116, 24));

		//Thing to repair
		this.addSlot(new SlotItemHandler(quantiscope, 11, 103, 4));

		//Repaired Item
		this.addSlot(new SlotItemHandler(quantiscope, 12, 80, 49));
		
		//Player Inv
	    TInventoryHelper.addPlayerInvContainer(this, inv, 0, 23);
	     
	}
}
