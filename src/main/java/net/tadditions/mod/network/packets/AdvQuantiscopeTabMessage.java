package net.tadditions.mod.network.packets;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.network.NetworkHooks;
import net.tadditions.mod.tileentity.AdvQuantiscopeTile;
import net.tadditions.mod.tileentity.AdvQuantiscopeTile.EnumMode;

import java.util.function.Supplier;

public class AdvQuantiscopeTabMessage {

	private BlockPos pos;
	private EnumMode mode;

	public AdvQuantiscopeTabMessage(BlockPos pos, EnumMode mode) {
		this.pos = pos;
		this.mode = mode;
	}
	
	public static AdvQuantiscopeTabMessage decode(PacketBuffer buf) {
		return new AdvQuantiscopeTabMessage(buf.readBlockPos(), EnumMode.values()[buf.readInt()]);
	}
	
	public static void encode(AdvQuantiscopeTabMessage mes, PacketBuffer buf) {
		buf.writeBlockPos(mes.pos);
		buf.writeInt(mes.mode.ordinal());
	}
	
	public static void handle(AdvQuantiscopeTabMessage mes, Supplier<NetworkEvent.Context> cont) {
		cont.get().enqueueWork(() -> {
			TileEntity te = cont.get().getSender().world.getTileEntity(mes.pos);
			if(te instanceof AdvQuantiscopeTile) {
				((AdvQuantiscopeTile)te).setMode(mes.mode);
				NetworkHooks.openGui(cont.get().getSender(), new INamedContainerProvider() {

					@Override
					public Container createMenu(int id, PlayerInventory inv, PlayerEntity entity) {
						return ((AdvQuantiscopeTile)te).createContainer(id, inv);
					}

					@Override
					public ITextComponent getDisplayName() {
						return new StringTextComponent("");
					}
					
				}, mes.pos);
			}
		});
		cont.get().setPacketHandled(true);
	}

}
