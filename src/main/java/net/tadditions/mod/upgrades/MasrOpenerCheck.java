package net.tadditions.mod.upgrades;

import net.tadditions.mod.flightevents.MFlightEvent;
import net.tardis.mod.misc.ITickable;
import net.tardis.mod.subsystem.Subsystem;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.upgrades.Upgrade;
import net.tardis.mod.upgrades.UpgradeEntry;


public class MasrOpenerCheck extends Upgrade implements ITickable {


    public MasrOpenerCheck(UpgradeEntry entry, ConsoleTile tile, Class<? extends Subsystem> clazz) {
        super(entry, tile, clazz);
        tile.registerTicker(this);
    }

    @Override
    public void onLand() {

    }

    @Override
    public void onTakeoff() {

    }

    @Override
    public void onFlightSecond() {

    }

    @Override
    public void tick(ConsoleTile console) {
        if(!console.getWorld().isRemote){
           if (!console.getWorld().isRemote && this.isUsable() && this.isActivated() && console.isInFlight() && console.getTimeInFlight() > 800 && console.getPercentageJourney() > 0.4) {
               console.setFlightEvent(MFlightEvent.DRIVECORE.get().create(console));
               this.getStack().shrink(1);
           }
        }
    }


}
