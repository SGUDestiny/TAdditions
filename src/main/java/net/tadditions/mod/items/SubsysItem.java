package net.tadditions.mod.items;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.*;
import net.minecraft.world.World;
import net.tardis.mod.constants.TardisConstants;
import net.tardis.mod.items.misc.TooltipProviderItem;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import java.util.List;

//basically TardisPartItem but with Geckolib
public class SubsysItem extends TooltipProviderItem implements IAnimatable  {
    public AnimationFactory factory = GeckoLibUtil.createFactory(this);
    protected TardisConstants.Part.PartType type;
    protected boolean requiredForFlight;
    protected boolean requiresRepair;
    protected TranslationTextComponent dependentItem;
    protected boolean isDisabled = false;

    public SubsysItem(Item.Properties prop, TardisConstants.Part.PartType type, boolean requiredForFlight, boolean requiresRepair, TranslationTextComponent dependentItem, boolean isDisabled) {
        super(prop);
        this.type = type;
        this.requiredForFlight = requiredForFlight;
        this.requiresRepair = requiresRepair;
        this.dependentItem = dependentItem;
        this.isDisabled = isDisabled;
        this.setShowTooltips(true);
        this.setHasStatisticsTooltips(true);
        this.setHasDescriptionTooltips(true);
    }

    public SubsysItem(Item.Properties prop, TardisConstants.Part.PartType type, boolean requiredForFlight, boolean requiresRepair, TranslationTextComponent dependentItem) {
        this(prop, type, requiredForFlight, requiresRepair, dependentItem, false);
    }

    public SubsysItem(Item.Properties prop, TardisConstants.Part.PartType type, boolean requiredForFlight, boolean requiresRepair, boolean isDisabled) {
        this(prop, type, requiredForFlight, requiresRepair, new TranslationTextComponent(""), isDisabled);
    }

    public SubsysItem(Item.Properties prop, TardisConstants.Part.PartType type, boolean requiredForFlight, boolean requiresRepair) {
        this(prop, type, requiredForFlight, requiresRepair, false);
    }

    @Override
    public void createStatisticTooltips(ItemStack stack, World worldIn, List<ITextComponent> tooltip,
                                        ITooltipFlag flagIn) {
        String typeName = this.type.toString().toLowerCase();
        String typeFriendlyName = typeName.substring(0, 1).toUpperCase() + typeName.substring(1);
        StringTextComponent panelName = new StringTextComponent(this.type == TardisConstants.Part.PartType.SUBSYSTEM ? "Components" : "Upgrades");
        tooltip.add(new TranslationTextComponent("tooltip.part.type").appendSibling(new StringTextComponent(typeFriendlyName).mergeStyle(TextFormatting.LIGHT_PURPLE)));

        if (type != TardisConstants.Part.PartType.UPGRADE)
            tooltip.add(new TranslationTextComponent("tooltip.part.flight.required").appendSibling(new StringTextComponent(String.valueOf(this.requiredForFlight)).mergeStyle(TextFormatting.LIGHT_PURPLE)));

        tooltip.add(new TranslationTextComponent("tooltip.part.repair.required").appendSibling(new StringTextComponent(String.valueOf(this.requiresRepair)).mergeStyle(TextFormatting.LIGHT_PURPLE)));
        if (this.type == TardisConstants.Part.PartType.UPGRADE && !this.dependentItem.getKey().isEmpty()) {
            tooltip.add(new TranslationTextComponent("tooltip.part.dependency").appendSibling(dependentItem != null ? dependentItem.mergeStyle(TextFormatting.LIGHT_PURPLE) : new StringTextComponent("None").mergeStyle(TextFormatting.LIGHT_PURPLE)));
        }
        tooltip.add(new TranslationTextComponent("tooltip.part.engine_panel").appendSibling(panelName.mergeStyle(this.type == TardisConstants.Part.PartType.SUBSYSTEM ? TextFormatting.BLUE : TextFormatting.GREEN)));
    }

    @Override
    public void createDescriptionTooltips(ItemStack stack, World worldIn, List<ITextComponent> tooltip,
                                          ITooltipFlag flagIn) {
        tooltip.add(TardisConstants.Prefix.TOOLTIP_ITEM_DESCRIPTION.deepCopy().appendSibling(new TranslationTextComponent("tooltip.part." + this.getRegistryName().getPath() + ".description").mergeStyle(TextFormatting.GRAY)));
    }

    @Override
    public void createDefaultTooltips(ItemStack stack, World worldIn, List<ITextComponent> tooltip,
                                      ITooltipFlag flagIn) {
        if (this.isDisabled) {
            tooltip.add(TardisConstants.Translations.TOOLTIP_DISABLED_ITEM.mergeStyle(TextFormatting.RED));
        }
    }

    private <P extends Item & IAnimatable> PlayState predicate(AnimationEvent<P> event) {
        event.getController().setAnimation((new AnimationBuilder()).addAnimation("loop", ILoopType.EDefaultLoopTypes.LOOP));

        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<>(this, "controller", 20, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }
}
