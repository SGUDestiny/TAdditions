package net.tadditions.mod.client.phenomena;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.util.Mth;
import net.tadditions.mod.init.PhenomenaInit;
import net.tadditions.mod.init.UpgradeInit;
import net.tardis.mod.cap.Capabilities;
import net.tardis.mod.cap.level.ITardisLevel;
import net.tardis.mod.client.gui.monitor.vortex_phenomena.DefaultVortexPhenomenaRenderer;
import net.tardis.mod.client.gui.monitor.vortex_phenomena.VortexPhenomenaRenderer;
import net.tardis.mod.misc.tardis.vortex.VortexPhenomenaType;
import net.tardis.mod.upgrade.Upgrade;
import net.tardis.mod.upgrade.tardis.BaseSubsytemTardisUpgrade;

import static net.tardis.mod.client.gui.monitor.vortex_phenomena.DefaultVortexPhenomenaRenderer.TEXTURE;

public class EntropicDriftPhenomenaRenderer implements VortexPhenomenaRenderer
{
    @Override
    public boolean isValid(VortexPhenomenaType<?> type)
    {
        return type.equals(PhenomenaInit.ENTROPIC_DRIFT.get());
    }

    @Override
    public void render(GuiGraphics graphics, VortexPhenomenaType<?> type, int x, int y, int radius)
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

                        graphics.blit(TEXTURE, x - radius, y - radius, width, Mth.floor(width * aspect), 178, 1, 58, 52, 256, 256);

                        return;
                    }
                }
            });
        }

    }

    @Override
    public void setupRenderer(PoseStack stack)
    {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderTexture(0, TEXTURE);
    }

    @Override
    public void endRenderer(PoseStack stack)
    {

    }
}
