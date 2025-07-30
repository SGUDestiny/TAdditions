package net.tadditions.mod.network;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.network.NetworkEvent;
import net.tadditions.mod.block_entities.QuantascopeEntity;
import net.tardis.mod.blockentities.machines.QuantiscopeTile;
import net.tardis.mod.cap.Capabilities;
import net.tardis.mod.cap.items.ISonicCapability;

import java.util.function.Supplier;

public record SonicUpgradeQuantascopeMessage(BlockPos position, boolean state) {

    public static void write(SonicUpgradeQuantascopeMessage mes, FriendlyByteBuf buf){
        buf.writeBlockPos(mes.position());
        buf.writeBoolean(mes.state());
    }

    public static SonicUpgradeQuantascopeMessage read(FriendlyByteBuf buf){
        return new SonicUpgradeQuantascopeMessage(buf.readBlockPos(), buf.readBoolean());
    }

    public static void handle(SonicUpgradeQuantascopeMessage mes, Supplier<NetworkEvent.Context> context)
    {
        context.get().setPacketHandled(true);
        context.get().enqueueWork(() ->
        {
            if (context.get().getSender().level().getBlockEntity(mes.position()) instanceof QuantascopeEntity tile)
            {
                tile.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(inv ->
                {
                    LazyOptional<ISonicCapability> sonicHolder = inv.getStackInSlot(6).getCapability(Capabilities.SONIC);
                    if (sonicHolder.isPresent())
                    {
                        //If turning on, load all upgrades
                        if (mes.state())
                        {
                            for (int i = 0; i < 6; ++i)
                            {
                                sonicHolder.orElseThrow(NullPointerException::new).getUpgradeInv().insertItem(i, inv.extractItem(i, 100, false), false);
                            }
                        }
                        if(!mes.state())
                        {
                            for(int i = 0; i < 6; ++i)
                            {
                                inv.insertItem(i, sonicHolder.orElseThrow(NullPointerException::new).getUpgradeInv().extractItem(i, 100, false), false);
                            }
                        }
                    }
                });
            }
        });
    }

}
