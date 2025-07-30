package net.tadditions.mod.network;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.network.NetworkEvent;
import net.tadditions.mod.block_entities.QuantascopeEntity;
import net.tardis.mod.blockentities.machines.QuantiscopeTile;
import net.tardis.mod.blockentities.machines.quantiscope_settings.SonicQuantiscopeSetting;
import net.tardis.mod.cap.Capabilities;
import net.tardis.mod.registry.SonicPartRegistry;

import java.util.function.Supplier;

public record SonicChangeModelMessage(BlockPos position, SonicPartRegistry.SonicPartType part) {

    public static void write(SonicChangeModelMessage mes, FriendlyByteBuf buf){
        buf.writeBlockPos(mes.position());
        buf.writeRegistryId(SonicPartRegistry.REGISTRY.get(), mes.part());
    }

    public static SonicChangeModelMessage read(FriendlyByteBuf buf){
        return new SonicChangeModelMessage(buf.readBlockPos(), buf.readRegistryId());
    }

    public static void handle(SonicChangeModelMessage mes, Supplier<NetworkEvent.Context> context){
        context.get().setPacketHandled(true);
        context.get().enqueueWork(() -> {
            if(context.get().getSender().level().getBlockEntity(mes.position()) instanceof QuantascopeEntity tile)
            {
                tile.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(
                handler -> {
                    handler.getStackInSlot(0).getCapability(Capabilities.SONIC).ifPresent(
                    sonic -> {
                                sonic.setSonicPart(mes.part.getSlot(), mes.part());
                    });
                });
            }
        });
    }

}
