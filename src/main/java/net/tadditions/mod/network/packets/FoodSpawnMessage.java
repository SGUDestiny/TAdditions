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

public class FoodSpawnMessage {
    public Item key;
    private boolean useMaxStack;

    public FoodSpawnMessage(Item item, boolean useMaxStack) {
        this.key = item;
        this.useMaxStack = useMaxStack;
    }

    public static void encode(FoodSpawnMessage mes, PacketBuffer buf) {
        buf.writeResourceLocation(mes.key.getRegistryName());
        buf.writeBoolean(mes.useMaxStack);
    }

    public static FoodSpawnMessage decode(PacketBuffer buf) {
        return new FoodSpawnMessage(ForgeRegistries.ITEMS.getValue(buf.readResourceLocation()), buf.readBoolean());
    }

    public static void handle(FoodSpawnMessage mes, Supplier<NetworkEvent.Context> con) {
        con.get().enqueueWork(() -> {
            ServerWorld world = con.get().getSender().getServerWorld();
            if(world.getTileEntity(TardisHelper.TARDIS_POS) instanceof ConsoleTile) {
                ConsoleTile console = (ConsoleTile)world.getTileEntity(TardisHelper.TARDIS_POS);
                //TODO: Set an actual value
                ItemStack stack = new ItemStack(mes.key);
                if(mes.key instanceof Item && mes.key.isIn(MItemTags.FOODMAKER)) {
                    int tempAmount = mes.useMaxStack ? 16 : 1; //Use 16 if shift is held down in the gui, otherwise 1.
                    int amount = stack.getMaxStackSize() > tempAmount ? tempAmount : stack.getMaxStackSize();
                    if(console.getArtron() >= amount) {
                        console.setArtron(console.getArtron() -(amount * MConfigs.COMMON.FoodCubeCost.get()));
                        InventoryHelper.spawnItemStack(world,
                                con.get().getSender().getPosX(),
                                con.get().getSender().getPosY(),
                                con.get().getSender().getPosZ(),
                                new ItemStack(mes.key, amount));
                    }
                    else con.get().getSender().sendStatusMessage(new TranslationTextComponent(TardisConstants.Translations.NOT_ENOUGH_ARTRON, stack.getMaxStackSize()), true);
                }
            }
        });
        con.get().setPacketHandled(true);
    }
}
