package net.tadditions.mod.items;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import net.tadditions.mod.cap.MCapabilities;
import net.tadditions.mod.container.DataDriveContainer;
import net.tadditions.mod.screens.DataDriveScreen;
import net.tadditions.mod.screens.MConstants;
import net.tadditions.mod.world.MDimensions;
import net.tardis.mod.client.ClientHelper;
import net.tardis.mod.constants.TardisConstants;

import javax.annotation.Nullable;

public class DataDriveItem extends Item {

    public DataDriveItem(Properties builderIn) {
        super(builderIn);
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

    @Nullable
    @Override
    public CompoundNBT getShareTag(ItemStack stack) { //sync capability to client
        CompoundNBT tag = stack.getOrCreateTag();
        stack.getCapability(MCapabilities.OPENER_CAPABILITY).ifPresent(cap ->
        {
            tag.put("dimdata", cap.serializeNBT());
        });
        return tag;
    }

    @Override
    public void readShareTag(ItemStack stack, @Nullable CompoundNBT nbt) {
        super.readShareTag(stack, nbt);
        if (nbt != null) {
            if (nbt.contains("dimdata")) {
                stack.getCapability(MCapabilities.OPENER_CAPABILITY).ifPresent(handler -> handler.deserializeNBT(nbt.getCompound("data")));
            }
        }
    }



    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (!worldIn.isRemote) {
            if (entityIn instanceof PlayerEntity) {
                stack.getCapability(MCapabilities.OPENER_CAPABILITY).ifPresent(cap -> {
                    cap.tick(worldIn, entityIn);
                });
            }
            if (worldIn.getGameTime() % 20 == 0) {
                syncCapability(stack); //sync capabilities each second instead of every tick
            }
        }
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity player, Hand handIn) {
        ItemStack stack = player.getHeldItem(handIn);
        if (stack != ItemStack.EMPTY) {
            if (!worldIn.isRemote && player instanceof ServerPlayerEntity) {
                if (!player.getCooldownTracker().hasCooldown(this) && player.isSneaking()) {
                    NetworkHooks.openGui((ServerPlayerEntity) player, new INamedContainerProvider() {
                        @Override
                        public ITextComponent getDisplayName() {
                            return new TranslationTextComponent("data_drive");
                        }

                        @Nullable
                        @Override
                        public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
                            return new DataDriveContainer(id, inventory, stack);
                        }
                    }, buf -> buf.writeItemStack(stack));
                }
            }
        }
        return new ActionResult<>(ActionResultType.SUCCESS, stack);
    }
}
