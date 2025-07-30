package net.tadditions.mod.network;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.inventory.MenuConstructor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkHooks;
import net.tadditions.mod.block_entities.QuantascopeEntity;
import net.tadditions.mod.menu.PhasingQuantascopeMenu;
import net.tadditions.mod.menu.SonicQuantascopeMenu;
import net.tadditions.mod.menu.SonicUpgradeQuantascopeMenu;
import net.tadditions.mod.menu.WeldingQuantascopeMenu;

import java.util.Optional;
import java.util.function.Supplier;

public record QuantascopeModeChangeMessage(BlockPos pos, int mode) {

    public static void write(QuantascopeModeChangeMessage mes, FriendlyByteBuf buf){
        buf.writeBlockPos(mes.pos());
        buf.writeInt(mes.mode);
    }

    public static QuantascopeModeChangeMessage read(FriendlyByteBuf buf)
    {
        return new QuantascopeModeChangeMessage(buf.readBlockPos(), buf.readInt());
    }

    public static void handle(QuantascopeModeChangeMessage mes, Supplier<NetworkEvent.Context> context)
    {
        context.get().setPacketHandled(true);
        context.get().enqueueWork(() -> {
            if(context.get().getSender().level().getBlockEntity(mes.pos()) instanceof QuantascopeEntity tile){
                tile.setMode(mes.mode);
                getMenu(mes.mode, tile).ifPresent(menu -> NetworkHooks.openScreen(context.get().getSender(), new SimpleMenuProvider(menu, tile.getBlockState().getBlock().getName()), tile.getBlockPos()));

            }
        });
    }

    public static Optional<MenuConstructor> getMenu(int mode, QuantascopeEntity tile)
    {
        return switch(mode)
        {
            case 0 -> Optional.of((windowId, inventory, player) -> new PhasingQuantascopeMenu(windowId, inventory, tile));
            case 1 -> Optional.of((windowId, inventory, player) -> new WeldingQuantascopeMenu(windowId, inventory, tile));
            case 2 -> Optional.of((windowId, inventory, player) -> new SonicQuantascopeMenu(windowId, inventory, tile));
            case 3 -> Optional.of((windowId, inventory, player) -> new SonicUpgradeQuantascopeMenu(windowId, inventory, tile));
            default -> throw new IllegalStateException("Unexpected Quantascope Mode: " + mode);
        };
    }


}
