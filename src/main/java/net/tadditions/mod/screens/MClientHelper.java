package net.tadditions.mod.screens;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.tadditions.mod.screens.manual.UpgradesManualScreen;
import net.tardis.mod.misc.GuiContext;

public class MClientHelper {

    public static void openGUI(int guiId, GuiContext context) {
        switch (guiId) {
            case MConstants.Gui.MANUAL:
                Minecraft.getInstance().displayGuiScreen(new UpgradesManualScreen(context));
            case MConstants.Gui.FOODMAKER:
                Minecraft.getInstance().displayGuiScreen(new FoodMakerScreen());
                break;
        }
    }
}
