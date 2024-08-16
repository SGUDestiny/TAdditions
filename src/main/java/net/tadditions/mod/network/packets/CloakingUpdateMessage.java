package net.tadditions.mod.network.packets;

import net.minecraft.network.PacketBuffer;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkEvent;
import net.tadditions.mod.helper.IConsoleHelp;
import net.tardis.mod.client.ClientHelper;
import net.tardis.mod.helper.TardisHelper;

import java.util.function.Supplier;

public class CloakingUpdateMessage
{
    public boolean cloaking;

    public CloakingUpdateMessage(boolean cloaking) {
        this.cloaking = cloaking;
    }

    public static void encode(CloakingUpdateMessage mes, PacketBuffer buff) {
        buff.writeBoolean(mes.cloaking);
    }

    public static CloakingUpdateMessage decode(PacketBuffer buff) {
        boolean cloaking = buff.readBoolean();

        return new CloakingUpdateMessage(cloaking);
    }

    public static void handle(CloakingUpdateMessage mes, Supplier<NetworkEvent.Context> cont) {
        cont.get().enqueueWork(() -> {
            TardisHelper.getConsoleInWorld(getWorld(cont.get())).ifPresent(tile -> {
                ((IConsoleHelp) tile).setCloakState(mes.cloaking);
            });
        });
        cont.get().setPacketHandled(true);
    }

    public static World getWorld(NetworkEvent.Context context) {

        if(context.getDirection() == NetworkDirection.PLAY_TO_SERVER) {
            return context.getSender().getServerWorld();
        }

        return ClientHelper.getClientWorld();

    }

}
