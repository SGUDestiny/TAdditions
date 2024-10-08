package net.tadditions.mod.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ArtronCapacitorItem extends net.tardis.mod.item.components.ArtronCapacitorItem
{
    public final float refuelRate;

    public ArtronCapacitorItem(Properties pProperties, int maxArtron, float refuelRate)
    {
        super(pProperties, maxArtron);
        this.refuelRate = refuelRate;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced)
    {
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
        pTooltipComponents.add(Component.translatable("tadditions.artron_capacitor.refuel_rate").append(Component.literal(String.valueOf(this.refuelRate))).withStyle(Style.EMPTY.applyFormat(ChatFormatting.DARK_AQUA)));
    }


}
