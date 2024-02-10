package net.tadditions.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.DimensionType;
import net.minecraftforge.registries.ForgeRegistries;
import net.tadditions.mod.cap.MCapabilities;
import net.tadditions.mod.helper.IConsoleHelp;
import net.tadditions.mod.items.ModItems;
import net.tardis.mod.cap.Capabilities;
import net.tardis.mod.controls.SonicPortControl;
import net.tardis.mod.items.TItems;
import net.tardis.mod.schematics.Schematic;
import net.tardis.mod.tileentities.ConsoleTile;
import org.spongepowered.asm.mixin.Mixin;

import javax.swing.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Mixin(SonicPortControl.class)
public class SPMixin {
    public boolean onRightClicked(ConsoleTile console, PlayerEntity player) {
        if(!console.getWorld().isRemote()) {
            if(player.getHeldItemMainhand().getItem() == TItems.SONIC.get() && console.getSonicItem().isEmpty() || player.getHeldItemMainhand().getItem() == ModItems.BOOS_UPGRADE.get() && console.getSonicItem().isEmpty()) {
                if(player.getHeldItemMainhand().getItem() == ModItems.BOOS_UPGRADE.get()){
                    player.getHeldItemMainhand().getCapability(MCapabilities.OPENER_CAPABILITY).ifPresent(cap -> {
                       Optional<DimensionType> type = DynamicRegistries.func_239770_b_().getRegistry(Registry.DIMENSION_TYPE_KEY).getOptional(cap.getDimdata());
                       if(type.isPresent()){
                           if(((IConsoleHelp) console).getBlocked().contains(type.get())){
                               ((IConsoleHelp) console).removeBlocked(type.get());
                           }
                       }
                    });
                }
                console.setSonicItem(player.getHeldItemMainhand());
                player.setHeldItem(Hand.MAIN_HAND, ItemStack.EMPTY);
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
            }
            else if(player.getHeldItemMainhand().isEmpty() && !console.getSonicItem().isEmpty()) {
                InventoryHelper.spawnItemStack(console.getWorld(), player.getPosX(), player.getPosY(), player.getPosZ(), console.getSonicItem());
                console.setSonicItem(ItemStack.EMPTY);
            }
        }
        return true;
    }
}
