package net.tadditions.mod.client.phenomena;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.util.Mth;
import net.tadditions.mod.init.UpgradeInit;
import net.tardis.mod.cap.Capabilities;
import net.tardis.mod.cap.level.ITardisLevel;
import net.tardis.mod.client.gui.monitor.vortex_phenomena.DefaultVortexPhenomenaRenderer;
import net.tardis.mod.client.gui.monitor.vortex_phenomena.VortexPhenomenaRenderer;
import net.tardis.mod.misc.tardis.vortex.VortexPhenomenaType;
import net.tardis.mod.upgrade.Upgrade;
import net.tardis.mod.upgrade.tardis.BaseSubsytemTardisUpgrade;

public class EntropicDriftPhenomenaRenderer extends DefaultVortexPhenomenaRenderer
{
    @Override
    public void render(PoseStack stack, VortexPhenomenaType<?> type, int x, int y, int radius)
    {
        ClientLevel level = Minecraft.getInstance().level;
        if(level != null)
        {
            level.getCapability(Capabilities.TARDIS).ifPresent(tardis ->
            {
                for(Upgrade<ITardisLevel> upgrade : tardis.getUpgrades())
                {
                    if(upgrade.getType().equals(UpgradeInit.TARDIS_DRIFT.get()) && UpgradeInit.TARDIS_DRIFT.get().canBeUsed(tardis))
                    {
                        final float aspect = (float) 58 / 52;
                        final int width = radius * 2;

                        Gui.blit(stack, x - radius, y - radius, width, Mth.floor(width * aspect), 178, 1, 58, 52, 256, 256);

                        return;
                    }
                }
            });
        }

    }
}
