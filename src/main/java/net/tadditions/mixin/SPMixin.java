package net.tadditions.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.concurrent.TickDelayedTask;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.tadditions.mod.cap.MCapabilities;
import net.tadditions.mod.helper.IConsoleHelp;
import net.tadditions.mod.items.CoordinateDataCrystalItem;
import net.tadditions.mod.items.DimensionalDataCrystalItem;
import net.tadditions.mod.items.ModItems;
import net.tardis.mod.cap.Capabilities;
import net.tardis.mod.controls.HandbrakeControl;
import net.tardis.mod.controls.SonicPortControl;
import net.tardis.mod.controls.ThrottleControl;
import net.tardis.mod.items.TItems;
import net.tardis.mod.misc.SpaceTimeCoord;
import net.tardis.mod.schematics.Schematic;
import net.tardis.mod.sounds.TSounds;
import net.tardis.mod.subsystem.StabilizerSubsystem;
import net.tardis.mod.tileentities.ConsoleTile;
import org.spongepowered.asm.mixin.Mixin;

import java.util.HashSet;
import java.util.Set;

@Mixin(SonicPortControl.class)
public class SPMixin {
    public boolean onRightClicked(ConsoleTile console, PlayerEntity player) {
        if(!console.getWorld().isRemote()) {
            if(player.getHeldItemMainhand().getItem() == TItems.SONIC.get() && console.getSonicItem().isEmpty() || player.getHeldItemMainhand().getItem() == ModItems.BOOS_UPGRADE.get() && console.getSonicItem().isEmpty()) {
                if(player.getHeldItemMainhand().getItem() == ModItems.BOOS_UPGRADE.get()) {
                    player.getHeldItemMainhand().getCapability(MCapabilities.OPENER_CAPABILITY).ifPresent(cap -> {
                        if (!cap.getHandler().getStackInSlot(0).isItemEqual(ItemStack.EMPTY)) {
                            ItemStack crystal = cap.getHandler().getStackInSlot(0);
                            if(crystal.getItem().equals(ModItems.DIMENSIONAL_DATA_CRYSTAL.get())){
                                DimensionalDataCrystalItem crystalItem = (DimensionalDataCrystalItem) crystal.getItem();
                                if (!((IConsoleHelp) console).getAvailable().contains(crystalItem.getDimData(crystal))) {
                                    ((IConsoleHelp) console).addAvailable(crystalItem.getDimData(crystal));
                                    cap.getHandler().setStackInSlot(0, new ItemStack(ModItems.BURNED_DATA_CRYSTAL.get()));
                                    ((SonicPortControl) (Object) this).getEntity().world.playSound(null, ((SonicPortControl) (Object) this).getEntity().getPosition(), TSounds.SCREEN_BEEP_SINGLE.get(), SoundCategory.PLAYERS, 1f, 1f);
                                }
                            }
                            else if(crystal.getItem().equals(ModItems.COORDINATE_DATA_CRYSTAL.get())){
                                CoordinateDataCrystalItem crystalItem = (CoordinateDataCrystalItem) crystal.getItem();
                                if (((IConsoleHelp) console).getAvailable().contains(crystalItem.getDimData(crystal)) && !crystalItem.getCoords(crystal).equals(BlockPos.ZERO)) {
                                    cap.getHandler().setStackInSlot(0, new ItemStack(ModItems.BURNED_DATA_CRYSTAL.get()));
                                    ((SonicPortControl) (Object) this).getEntity().world.playSound(null, ((SonicPortControl) (Object) this).getEntity().getPosition(), TSounds.REACHED_DESTINATION.get(), SoundCategory.PLAYERS, 1f, 1f);
                                    console.getWorld().getServer().enqueue(new TickDelayedTask(30, () -> {
                                        console.setDestination(new SpaceTimeCoord(crystalItem.getDimData(crystal), crystalItem.getCoords(crystal)));
                                        console.getControl(ThrottleControl.class).ifPresent(throttle -> throttle.setAmount(1.0F));
                                        console.getControl(HandbrakeControl.class).ifPresent(handbrake -> handbrake.setFree(true));
                                        console.getSubsystem(StabilizerSubsystem.class).ifPresent(sys -> sys.setControlActivated(true));
                                        console.takeoff();

                                        crystalItem.setDimData(crystal, World.OVERWORLD);
                                        crystalItem.setCoords(crystal, BlockPos.ZERO);
                                    }));
                                } else if (crystalItem.getCoords(crystal).equals(BlockPos.ZERO)) {
                                    ((SonicPortControl) (Object) this).getEntity().world.playSound(null, ((SonicPortControl) (Object) this).getEntity().getPosition(), TSounds.REMOTE_ACCEPT.get(), SoundCategory.PLAYERS, 1f, 1f);
                                    crystalItem.setCoords(crystal, console.getDestinationPosition());
                                    crystalItem.setDimData(crystal, console.getDestinationDimension());
                                } else if (!((IConsoleHelp) console).getAvailable().contains(crystalItem.getDimData(crystal)) && !crystalItem.getCoords(crystal).equals(BlockPos.ZERO)) {
                                    ((SonicPortControl) (Object) this).getEntity().world.playSound(null, ((SonicPortControl) (Object) this).getEntity().getPosition(), TSounds.CANT_START.get(), SoundCategory.PLAYERS, 1f, 1f);
                                    ((SonicPortControl) (Object) this).getEntity().world.playSound(null, ((SonicPortControl) (Object) this).getEntity().getPosition(), TSounds.SINGLE_CLOISTER.get(), SoundCategory.PLAYERS, 1f, 1f);
                                }
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
