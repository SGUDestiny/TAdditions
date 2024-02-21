package net.tadditions.mod.compat.create;

import com.simibubi.create.foundation.utility.Color;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class AnimatedSequenceAssemblyItem extends Item implements IAnimatable {
    public AnimationFactory factory = GeckoLibUtil.createFactory(this);

    public AnimatedSequenceAssemblyItem(Properties prop) {
        super(prop.maxStackSize(1));
    }

    public void fillItemGroup(ItemGroup p_150895_1_, NonNullList<ItemStack> p_150895_2_) {
    }

    public double getDurabilityForDisplay(ItemStack stack) {
        if (!stack.hasTag()) {
            return 1.0D;
        } else {
            CompoundNBT tag = stack.getTag();
            return !tag.contains("SequencedAssembly") ? 1.0D : (double) MathHelper.lerp(tag.getCompound("SequencedAssembly").getFloat("Progress"), 1.0F, 0.0F);
        }
    }

    public boolean showDurabilityBar(ItemStack stack) {
        return true;
    }

    public int getRGBDurabilityForDisplay(ItemStack stack) {
        return Color.mixColors(-12124192, -16268, (float) this.getDurabilityForDisplay(stack));
    }

    private <P extends Item & IAnimatable> PlayState predicate(AnimationEvent<P> event) {
        event.getController().setAnimation((new AnimationBuilder()).addAnimation("loop", ILoopType.EDefaultLoopTypes.LOOP));

        return PlayState.STOP;
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