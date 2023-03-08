package net.tadditions.mod.flightevents;

import com.google.common.collect.Lists;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;
import net.tadditions.mod.upgrades.MasrOpenerCheck;
import net.tardis.mod.cap.Capabilities;
import net.tardis.mod.config.TConfig;
import net.tardis.mod.controls.ThrottleControl;
import net.tardis.mod.flight.FlightEvent;
import net.tardis.mod.flight.FlightEventFactory;
import net.tardis.mod.items.ArtronCapacitorItem;
import net.tardis.mod.items.TItems;
import net.tardis.mod.misc.ObjectWrapper;
import net.tardis.mod.registries.ControlRegistry;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.tileentities.console.misc.ArtronUse;
import net.tardis.mod.tileentities.inventory.PanelInventory;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Supplier;

public class Basins extends FlightEvent {

    public Basins(FlightEventFactory entry, ArrayList<ResourceLocation> loc) {
        super(entry, loc);
    }

    public static final Supplier<ArrayList<ResourceLocation>> CONTROLS = () -> Lists.newArrayList(
            ControlRegistry.REFUELER.get().getRegistryName(),
            ControlRegistry.STABILIZERS.get().getRegistryName()
    );

    public boolean onComplete(ConsoleTile tile) {
        boolean complete = super.onComplete(tile);

        if(complete) {

            tile.damage(300F);
            tile.onPowerDown(true);
            ArtronUse use = tile.getOrCreateArtronUse(new ArtronUse.IArtronType() {
                @Override
                public float getUse() {
                    return 4;
                }

                @Override
                public TranslationTextComponent getTranslation() {
                    return new TranslationTextComponent("artronuse.tadditions.leak");
                }

                @Override
                public String getId() {
                    return "leak";
                }
            });
            use.setArtronUsePerTick(0.4F);
            use.setTicksToDrain(3600);
            tile.updateClient();
        }

        return complete;
    }

    @Override
    public void onMiss(ConsoleTile tile) {
        super.onMiss(tile);
        tile.damage(300F);
        tile.onPowerDown(true);
        ArtronUse use = tile.getOrCreateArtronUse(new ArtronUse.IArtronType() {
            @Override
            public float getUse() {
                return 4;
            }

            @Override
            public TranslationTextComponent getTranslation() {
                return new TranslationTextComponent("artronuse.tadditions.leak");
            }

            @Override
            public String getId() {
                return "leak";
            }
        });
        use.setArtronUsePerTick(0.4F);
        use.setTicksToDrain(3600);
        Random rand = tile.getWorld().rand;

        //Blow out capacitor
        if(rand.nextFloat() < 0.70) {
            tile.getWorld().getCapability(Capabilities.TARDIS_DATA).ifPresent(cap -> {
                PanelInventory inv = cap.getEngineInventoryForSide(Direction.WEST);
                for(int i = 0; i < inv.getSlots(); ++i) {
                    if(inv.getStackInSlot(i).getItem() instanceof ArtronCapacitorItem && inv.getStackInSlot(i).getItem() != TItems.LEAKY_ARTRON_CAPACITOR.get()) {
                        inv.setStackInSlot(i, new ItemStack(TItems.LEAKY_ARTRON_CAPACITOR.get()));
                        break;
                    }
                }
            });
        }

        tile.setArtron(tile.getArtron() - (32 + (rand.nextFloat() * 32)));
        tile.updateClient();
    }

    @Override
    public int calcTime(ConsoleTile console) {

        ObjectWrapper<Float> wrapper = new ObjectWrapper<Float>(0.0F);

        console.getControl(ThrottleControl.class).ifPresent(throt -> wrapper.setValue(throt.getAmount()));
        float amt = wrapper.getValue();

        int seconds = TConfig.SERVER.controlTime.get() * 60;

        //flight time + 5 seconds for base + 0-5 seconds depending on throttle
        return this.timeUntilMiss = console.flightTicks + seconds + (int)Math.floor((1.0F - amt) * seconds);
    }
}
