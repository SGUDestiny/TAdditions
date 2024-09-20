package net.tadditions.mod.upgrades;

import net.tardis.mod.cap.level.ITardisLevel;
import net.tardis.mod.registry.SubsystemRegistry;
import net.tardis.mod.upgrade.tardis.BaseSubsytemTardisUpgrade;
import net.tardis.mod.upgrade.types.UpgradeType;

public class EntropicDriftingUpgrade extends BaseSubsytemTardisUpgrade
{

    public EntropicDriftingUpgrade(UpgradeType<ITardisLevel, ?> type, ITardisLevel instance)
    {
        super(type, instance, SubsystemRegistry.FLIGHT_TYPE::get);
    }

    @Override
    public void onBreak()
    {
    }

    @Override
    public void onTick()
    {

    }
}
