package net.tadditions.mod.network.packets;

import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.tadditions.mod.config.MConfigs;
import net.tadditions.mod.tags.MItemTags;
import net.tardis.mod.constants.TardisConstants;
import net.tardis.mod.helper.TardisHelper;
import net.tardis.mod.tileentities.ConsoleTile;

import java.util.function.Supplier;

public class QuanSpawnMessage {
    public Item key;

    public QuanSpawnMessage(Item item) {
        this.key = item;
    }

    public static void encode(QuanSpawnMessage mes, PacketBuffer buf) {
        buf.writeResourceLocation(mes.key.getRegistryName());
    }

    public static QuanSpawnMessage decode(PacketBuffer buf) {
        return new QuanSpawnMessage(ForgeRegistries.ITEMS.getValue(buf.readResourceLocation()));
    }

    public static void handle(QuanSpawnMessage mes, Supplier<NetworkEvent.Context> con) {
        con.get().enqueueWork(() -> {
            ServerWorld world = con.get().getSender().getServerWorld();
            ItemStack stack = new ItemStack(mes.key);
                if(mes.key != null) {
                    int amount = Math.min(stack.getMaxStackSize(), 1);
                    System.out.print("ItemPain");
                        InventoryHelper.spawnItemStack(world,
                                con.get().getSender().getPosX(),
                                con.get().getSender().getPosY(),
                                con.get().getSender().getPosZ(),
                                new ItemStack(mes.key, amount));
                }
        });
        con.get().setPacketHandled(true);
    }
}
