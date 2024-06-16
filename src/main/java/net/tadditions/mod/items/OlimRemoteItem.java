package net.tadditions.mod.items;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.*;
import net.minecraft.world.World;
import net.tadditions.mod.cap.IOneRemote;
import net.tadditions.mod.cap.MCapabilities;
import net.tardis.mod.artron.IArtronItemStackBattery;
import net.tardis.mod.constants.TardisConstants;
import net.tardis.mod.helper.TextHelper;
import net.tardis.mod.helper.WorldHelper;
import net.tardis.mod.items.misc.ConsoleBoundItem;
import net.tardis.mod.tileentities.ConsoleTile;

import javax.annotation.Nullable;
import java.text.DecimalFormat;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class OlimRemoteItem extends ConsoleBoundItem implements IArtronItemStackBattery {

    public static final DecimalFormat FORMAT = new DecimalFormat("###");
    private static final IFormattableTextComponent USAGE = TextHelper.createDescriptionItemTooltip(new TranslationTextComponent("tooltip.stat_remote.use"));


    public OlimRemoteItem(Properties properties) {
        super(properties);
    }

    public static void syncCapability(ItemStack stack) {
        if (stack.getShareTag() != null) {
            stack.getOrCreateTag().merge(stack.getShareTag());
        }
    }

    public static void readCapability(ItemStack stack) {
        if (stack.getShareTag() != null) {
            stack.readShareTag(stack.getOrCreateTag());
        }

    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        if (!context.getWorld().isRemote()) {
            context.getItem().getCapability(MCapabilities.ONE_REMOTE_CAPABILITY).ifPresent(cap -> {
                cap.onClick(context.getWorld(), context.getPlayer(), context.getPos());
            });
            return ActionResultType.SUCCESS;
        } else if (!context.getWorld().isRemote()) {
            context.getPlayer().sendStatusMessage(TardisConstants.Translations.CANT_USE_IN_DIM, true);
            return ActionResultType.FAIL;
        }
        return ActionResultType.SUCCESS;
    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
    	tooltip.add(TardisConstants.Translations.TOOLTIP_HOLD_SHIFT);
        tooltip.add(TardisConstants.Translations.TOOLTIP_CONTROL);
        assert MCapabilities.ONE_REMOTE_CAPABILITY != null;
        stack.getCapability(MCapabilities.ONE_REMOTE_CAPABILITY).ifPresent(cap -> {
            String flightStatus = cap.isInFlight() ? "Destination" : "Current";
            if (cap.getTardis() != null) {
            	if (Screen.hasShiftDown()) {
            		tooltip.clear();
                    tooltip.add(0, this.getDisplayName(stack));
                    tooltip.add(new TranslationTextComponent("tooltip.stat_remote.tardis_owner").appendSibling(new StringTextComponent(getTardisName(stack)).mergeStyle(TextFormatting.LIGHT_PURPLE)));
                    tooltip.add(new StringTextComponent(flightStatus).appendSibling(new TranslationTextComponent("tooltip.stat_remote.exterior_dim").appendSibling(new StringTextComponent(WorldHelper.formatDimName(cap.getExteriorDim())).mergeStyle(TextFormatting.LIGHT_PURPLE))));
                    tooltip.add(new StringTextComponent(flightStatus).appendSibling(new TranslationTextComponent("tooltip.stat_remote.exterior_pos").appendSibling(new StringTextComponent(WorldHelper.formatBlockPos(cap.getExteriorPos())).mergeStyle(TextFormatting.LIGHT_PURPLE))));
                    tooltip.add(new TranslationTextComponent("tooltip.stat_remote.in_flight").appendSibling(new StringTextComponent(String.valueOf(cap.isInFlight())).mergeStyle(TextFormatting.LIGHT_PURPLE)));
                    tooltip.add(new TranslationTextComponent("tooltip.stat_remote.journey").appendSibling(new StringTextComponent(String.valueOf(FORMAT.format(cap.getJourney() * 100.0))).mergeStyle(TextFormatting.LIGHT_PURPLE)));
                    tooltip.add(new TranslationTextComponent("tooltip.stat_remote.fuel").appendSibling(new StringTextComponent(String.valueOf(FORMAT.format(cap.getFuel()))).mergeStyle(TextFormatting.LIGHT_PURPLE).appendSibling(TardisConstants.Suffix.ARTRON_UNITS)));
            	    tooltip.add(new TranslationTextComponent("tooltip.olim_charge").appendSibling(new StringTextComponent(String.valueOf(FORMAT.format(cap.getCharge())))).mergeStyle(TextFormatting.LIGHT_PURPLE).appendSibling(TardisConstants.Suffix.ARTRON_UNITS));
                }
            }
            else {
                tooltip.add(TardisConstants.Translations.TOOLTIP_NO_ATTUNED);
            }
        });
        if (Screen.hasControlDown()) {
            tooltip.clear();
            tooltip.add(0, this.getDisplayName(stack));
            tooltip.add(USAGE);
        }
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return false;
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (!worldIn.isRemote) {
            if (entityIn instanceof PlayerEntity) {
                stack.getCapability(MCapabilities.ONE_REMOTE_CAPABILITY).ifPresent(cap -> {
                    cap.tick(worldIn, entityIn);
                });
            }
            if (worldIn.getGameTime() % 20 == 0) {
                syncCapability(stack); //sync capabilities each second instead of every tick
            }
        }
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
    }

    @Nullable
    @Override
    public CompoundNBT getShareTag(ItemStack stack) { //sync capability to client
        CompoundNBT tag = stack.getOrCreateTag();
        stack.getCapability(MCapabilities.ONE_REMOTE_CAPABILITY).ifPresent(cap ->
        {
            tag.put("cap_sync", cap.serializeNBT());
        });
        return tag;
    }

    @Override
    public void readShareTag(ItemStack stack, @Nullable CompoundNBT nbt) {
        super.readShareTag(stack, nbt);
        if (nbt != null) {
            if (nbt.contains("cap_sync")) {
                stack.getCapability(MCapabilities.ONE_REMOTE_CAPABILITY).ifPresent(handler -> handler.deserializeNBT(nbt.getCompound("cap_sync")));
            }
        }
    }

	@Override
	public ItemStack onAttuned(ItemStack stack, ConsoleTile tile) {
		setTardis(stack, tile.getWorld().getDimensionKey().getLocation());
		tile.getWorld().getCapability(net.tardis.mod.cap.Capabilities.TARDIS_DATA).ifPresent(data -> setTardisName(stack, data.getTARDISName()));
		return stack;
	}

	@Override
	public int getAttunementTime() {
		return 300;
	}

	@Override
	public ResourceLocation getTardis(ItemStack stack) {
		IOneRemote remote = stack.getCapability(MCapabilities.ONE_REMOTE_CAPABILITY).orElse(null);
		if(remote == null)
			return null;
		return remote.getTardis();
	}

	@Override
	public void setTardis(ItemStack stack, ResourceLocation world) {
		stack.getCapability(MCapabilities.ONE_REMOTE_CAPABILITY).ifPresent(remote -> remote.setTardis(world));
	}

	@Override
	public String getTardisName(ItemStack stack) {
		if(stack.getTag() != null && stack.getTag().contains("tardis_name")) {
			return stack.getTag().getString("tardis_name");
		}
		return null;
	}

	@Override
	public void setTardisName(ItemStack stack, String name) {
		stack.getOrCreateTag().putString("tardis_name", name);
	}

    @Override
    public float charge(ItemStack stack, float amount, boolean simulate) {
        stack.getCapability(MCapabilities.ONE_REMOTE_CAPABILITY).ifPresent(cap -> cap.charge(stack, amount, simulate));
        return amount;
    }

    @Override
    public float discharge(ItemStack stack, float amount, boolean simulate) {
        stack.getCapability(MCapabilities.ONE_REMOTE_CAPABILITY).ifPresent(cap -> cap.discharge(stack, amount, simulate));

        return amount;
    }

    @Override
    public float getMaxCharge(ItemStack stack) {
        AtomicReference<Float> maxCharge = new AtomicReference<>();
        stack.getCapability(MCapabilities.ONE_REMOTE_CAPABILITY).ifPresent(cap -> maxCharge.set(cap.getMaxCharge(stack)));
        return maxCharge.get();
    }

    @Override
    public float getCharge(ItemStack stack) {
        AtomicReference<Float> charge = new AtomicReference<>();
        stack.getCapability(MCapabilities.ONE_REMOTE_CAPABILITY).ifPresent(cap -> charge.set(cap.getCharge(stack)));
        return charge.get();
    }
}
