package net.tadditions.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.tadditions.mod.cap.MCapabilities;
import net.tadditions.mod.helper.IConsoleHelp;
import net.tadditions.mod.items.ModItems;
import net.tardis.mod.cap.Capabilities;
import net.tardis.mod.controls.SonicPortControl;
import net.tardis.mod.items.TItems;
import net.tardis.mod.schematics.Schematic;
import net.tardis.mod.tileentities.ConsoleTile;
import org.spongepowered.asm.mixin.Mixin;

import java.util.HashSet;
import java.util.Set;

@Mixin(SonicPortControl.class)
public class SPMixin {
    public boolean onRightClicked(ConsoleTile console, PlayerEntity player) {
        if(!console.getWorld().isRemote()) {
            if(player.getHeldItemMainhand().getItem() == TItems.SONIC.get() && console.getSonicItem().isEmpty() || player.getHeldItemMainhand().getItem() == ModItems.BOOS_UPGRADE.get() && console.getSonicItem().isEmpty()) {
                console.setSonicItem(player.getHeldItemMainhand());
                player.setHeldItem(Hand.MAIN_HAND, ItemStack.EMPTY);
                player.abilities.allowFlying = true;
                console.doesConsoleWorldHaveNoPlayers();
                console.getSonicItem().getCapability(Capabilities.SONIC_CAPABILITY).ifPresent(cap -> {
                    cap.setCharge(cap.getMaxCharge());
                    console.setArtron(console.getArtron()-(cap.getMaxCharge()-cap.getCharge()));
                    Set<Schematic> uniqueSchematics = new HashSet<>();
                    uniqueSchematics.addAll(cap.getSchematics());
                    for(Schematic s : uniqueSchematics) {
                        if (s.onConsumedByTARDIS(console, player))
                            cap.getSchematics().remove(s);
                    }
                });
                console.getSonicItem().getCapability(MCapabilities.OPENER_CAPABILITY).ifPresent(cap -> {
                    if(cap.isDimdata()) {
                        cap.setDimdata(false);
                        ((IConsoleHelp) console).setDimOver(true);
                    }
                });

            }
            else if(player.getHeldItemMainhand().isEmpty() && !console.getSonicItem().isEmpty()) {
                InventoryHelper.spawnItemStack(console.getWorld(), player.getPosX(), player.getPosY(), player.getPosZ(), console.getSonicItem());
                console.setSonicItem(ItemStack.EMPTY);
            }
        }
        return true;
    }
}
