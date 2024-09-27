package net.tadditions.mod.event;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerContainerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.items.ItemStackHandler;
import net.tadditions.mod.TemporalAdditionsMod;
import net.tadditions.mod.init.ItemInit;
import net.tardis.api.events.TardisEvent;
import net.tardis.mod.cap.level.ITardisLevel;
import net.tardis.mod.misc.tardis.TardisEngine;

@Mod.EventBusSubscriber(modid = TemporalAdditionsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {

    @SubscribeEvent
    public static void refuelRate(TardisEvent.CalcRechargeEvent event)
    {
        ITardisLevel tardis = event.getTARDIS();
        ItemStackHandler capacitorHandler = tardis.getEngine().getInventoryFor(TardisEngine.EngineSide.CAPACITORS);
        for(int i = 0; i < capacitorHandler.getSlots(); i++)
        {
            ItemStack capacitor = capacitorHandler.getStackInSlot(i);
            if(capacitor.getItem().equals(ItemInit.ARTRON_CAPACITOR_VORTEX.get()))
                event.setRechargeRate(event.getRechargeRate()+0.025f);
            if(capacitor.getItem().equals(ItemInit.ARTRON_CAPACITOR_QUANTUM.get()))
                event.setRechargeRate(event.getRechargeRate()-0.025f);
            if(capacitor.getItem().equals(ItemInit.ARTRON_CAPACITOR_TEMPORAL.get()))
                event.setRechargeRate(event.getRechargeRate()+0.05f);
        }
    }

}
