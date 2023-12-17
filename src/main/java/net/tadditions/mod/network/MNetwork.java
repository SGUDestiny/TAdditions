package net.tadditions.mod.network;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.network.packets.AdvQuantiscopeTabMessage;
import net.tadditions.mod.network.packets.FoodSpawnMessage;
import net.tadditions.mod.network.packets.QuanSpawnMessage;

public class MNetwork {

	private static int ID = 0;
    private static final String PROTOCOL_VERSION = Integer.toString(1);
    private static final SimpleChannel NETWORK_CHANNEL = NetworkRegistry.newSimpleChannel(new ResourceLocation(QolMod.MOD_ID, "main_channel"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);

    
    public static void init() {
        NETWORK_CHANNEL.registerMessage(nextId(), FoodSpawnMessage.class, FoodSpawnMessage::encode, FoodSpawnMessage::decode, FoodSpawnMessage::handle);
        NETWORK_CHANNEL.registerMessage(nextId(), AdvQuantiscopeTabMessage.class, AdvQuantiscopeTabMessage::encode, AdvQuantiscopeTabMessage::decode, AdvQuantiscopeTabMessage::handle);
        NETWORK_CHANNEL.registerMessage(nextId(), QuanSpawnMessage.class, QuanSpawnMessage::encode, QuanSpawnMessage::decode, QuanSpawnMessage::handle);
    }

    /**
     * Sends a packet to the server.<br>
     * Must be called Client side.
     */
    public static void sendToServer(Object msg) {
        NETWORK_CHANNEL.sendToServer(msg);
    }

    public static int nextId(){
        return ++ID;
    }

}
