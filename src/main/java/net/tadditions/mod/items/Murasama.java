package net.tadditions.mod.items;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.text.*;
import net.minecraft.world.World;
import net.tardis.mod.constants.TardisConstants;
import net.tardis.mod.helper.TextHelper;

import javax.annotation.Nullable;
import java.util.List;

public class Murasama extends SwordItem {


    public Murasama(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn) {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {

        if(Screen.hasShiftDown()) {
            tooltip.add(new TranslationTextComponent("tooltip.tadditions.murasama_shift"));
        } else {
            tooltip.add(new TranslationTextComponent("tooltip.tadditions.murasama"));
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

}
