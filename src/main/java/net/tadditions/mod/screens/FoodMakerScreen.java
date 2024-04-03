package net.tadditions.mod.screens;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.gui.widget.button.ChangePageButton;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.StringTextComponent;
import net.tadditions.mod.helper.MHelper;
import net.tadditions.mod.tags.MItemTags;
import net.tardis.mod.Tardis;
import net.tardis.mod.client.guis.widgets.ItemButton;
import net.tadditions.mod.network.MNetwork;
import net.tadditions.mod.network.packets.FoodSpawnMessage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FoodMakerScreen extends Screen {

    public static final StringTextComponent TITLE = new StringTextComponent("Food Cube Machine");
    public static final ResourceLocation TEXTURE = new ResourceLocation(Tardis.MODID, "textures/gui/ars.png");

    public static int WIDTH = 256, HEIGHT = 256, SLOTS = 30;
    public int page = 0;

    public FoodMakerScreen() {
        super(TITLE);
    }

    @Override
    protected void init() {
        super.init();

        this.reloadButtons();
    }

    public void reloadButtons() {

        //Shouldn't exist, but you can only get items from the front page other wise
        for (Widget w : this.buttons) {
            w.active = false;
        }
        buttons.clear();

        int centerX = width / 2 - 8, centerY = height / 2 - 8;

        List<Item> items = MItemTags.FOODMAKER.getAllElements();
        items = new ArrayList<Item>(items); //Make list modifiable
        int maxPages = (int) Math.ceil(items.size() / SLOTS);
        if (items.size() > page * SLOTS) {
            items = items.subList(page * SLOTS, items.size());
        }

        List<Item> leftOver = this.addButtonToCircle(items, centerX, centerY, 90, 25);
        leftOver = this.addButtonToCircle(leftOver, centerX, centerY, 70, 16);
        leftOver = this.addButtonToCircle(leftOver, centerX, centerY, 50, 10);

        this.addButton(new ChangePageButton(width / 2, height / 2, true, button -> {
            page = MathHelper.clamp(page + 1, 0, maxPages);
            this.reloadButtons();
        }, false));

        this.addButton(new ChangePageButton(width / 2 - 20, height / 2, false, button -> {
            page = MathHelper.clamp(page - 1, 0, maxPages);
            this.reloadButtons();
        }, false));

    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        this.minecraft.textureManager.bindTexture(TEXTURE);
        this.blit(matrixStack, width / 2 - WIDTH / 2, height / 2 - HEIGHT / 2, 0, 0, WIDTH, HEIGHT);

        Iterator<Widget> buttons = this.buttons.iterator();
        while (buttons.hasNext()) {
            buttons.next().render(matrixStack, mouseX, mouseY, partialTicks);
        }

        Iterator<Widget> tooltip = this.buttons.iterator();
        while (tooltip.hasNext()) {
            Widget butt = tooltip.next();
            if (butt instanceof ItemButton && MHelper.isInBounds(mouseX, mouseY, butt.x, butt.y, butt.x + butt.getWidth(), butt.y + butt.getHeight()))
                this.renderTooltip(matrixStack, ((ItemButton) butt).getItemStack(), mouseX, mouseY);
        }

    }

    public List<Item> addButtonToCircle(List<Item> list, int startX, int startY, int radius, int max) {
        int index = 0;

        if (max == 0)
            return list;

        if (max > list.size())
            max = list.size();
        
        Iterator<Item> it = list.iterator();
        while (it.hasNext()) {
            double angle = Math.toRadians((360.0 / max) * index);
            int x = (int) (Math.sin(angle) * radius), y = (int) (Math.cos(angle) * radius);
            Item item = it.next();
            this.addButton(new ItemButton(startX + x, startY + y, new ItemStack(item), new StringTextComponent(""), button -> {
                MNetwork.sendToServer(new FoodSpawnMessage(item, Screen.hasShiftDown() ? true : false));
            }));
            it.remove();

            ++index;
            if (index >= max)
                return list;
        }
        return list;
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
