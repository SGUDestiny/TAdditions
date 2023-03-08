package net.tadditions.mod.items;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.tadditions.mod.screens.MClientHelper;
import net.tadditions.mod.screens.MConstants;
import net.tardis.mod.constants.TardisConstants;
import net.tardis.mod.contexts.gui.GuiItemContext;
import net.tardis.mod.helper.TextHelper;
import net.tardis.mod.itemgroups.TItemGroups;
import net.tardis.mod.items.ManualItem;
import net.tardis.mod.properties.Prop;

import java.util.List;

public class UpgradeManualItem extends Item{

    public UpgradeManualItem() {
        super(Prop.Items.ONE.get().group(TItemGroups.MAINTENANCE));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (worldIn.isRemote) {
        	if (handIn == Hand.MAIN_HAND)
                MClientHelper.openGUI(MConstants.Gui.MANUAL, new GuiItemContext(playerIn.getHeldItem(handIn)));
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    protected final IFormattableTextComponent descriptionTooltip = TextHelper.createDescriptionItemTooltip(new TranslationTextComponent("tooltip.upgrades_manual.info"));

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);


        tooltip.add(TardisConstants.Translations.TOOLTIP_CONTROL);
        if (Screen.hasControlDown()) {
            tooltip.clear();
            tooltip.add(0, this.getDisplayName(stack));
            tooltip.add(descriptionTooltip);
        }
    }
}
