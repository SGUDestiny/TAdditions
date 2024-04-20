package net.tadditions.mod.items;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
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
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import net.tadditions.mod.cap.MCapabilities;
import net.tadditions.mod.container.DataDriveContainer;
import net.tardis.mod.constants.TardisConstants;
import net.tardis.mod.helper.WorldHelper;

import javax.annotation.Nullable;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

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
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        stack.getCapability(MCapabilities.OPENER_CAPABILITY).ifPresent(cap -> {
            if(cap.getHandler().getStackInSlot(0).isEmpty()){
                tooltip.add(new TranslationTextComponent("tadditions.data_drive_description"));
                tooltip.add(TardisConstants.Translations.TOOLTIP_HOLD_SHIFT);
                if(Screen.hasShiftDown()) {
                    tooltip.clear();
                    tooltip.add(0, this.getDisplayName(stack));
                    tooltip.add(new TranslationTextComponent("tadditions.data_drive_description"));
                    tooltip.add(new TranslationTextComponent("tadditions.data_drive_status_empty"));
                }
            }
            ItemStack crystal = cap.getHandler().getStackInSlot(0);
            if(crystal.getItem().equals(ModItems.BURNED_DATA_CRYSTAL.get())) {
                tooltip.add(new TranslationTextComponent("tadditions.data_drive_description"));
                tooltip.add(TardisConstants.Translations.TOOLTIP_HOLD_SHIFT);
                if (Screen.hasShiftDown()) {
                    tooltip.clear();
                    tooltip.add(0, this.getDisplayName(stack));
                    tooltip.add(new TranslationTextComponent("tadditions.data_drive_description"));
                    tooltip.add(new TranslationTextComponent("tadditions.data_drive_crystal_type_used"));
                    tooltip.add(new TranslationTextComponent("tadditions.data_drive_status").appendSibling(getStatus(stack)));
                }
            } else if(crystal.getItem().equals(ModItems.DIMENSIONAL_DATA_CRYSTAL.get())) {
                DimensionalDataCrystalItem crystalItem = (DimensionalDataCrystalItem) crystal.getItem();
                tooltip.add(new TranslationTextComponent("tadditions.data_drive_description"));
                tooltip.add(TardisConstants.Translations.TOOLTIP_HOLD_SHIFT);
                if (Screen.hasShiftDown()) {
                    tooltip.clear();
                    tooltip.add(0, this.getDisplayName(stack));
                    tooltip.add(new TranslationTextComponent("tadditions.data_drive_description"));
                    tooltip.add(new TranslationTextComponent("tadditions.data_drive_crystal_type_0"));
                    tooltip.add(new TranslationTextComponent("tadditions.data_drive_dimension").appendSibling(new StringTextComponent(WorldHelper.formatDimName(crystalItem.getDimData(crystal))).mergeStyle(TextFormatting.DARK_PURPLE)));
                    tooltip.add(new TranslationTextComponent("tadditions.data_drive_status").appendSibling(getStatus(stack)));
                }
            } else if(crystal.getItem().equals(ModItems.COORDINATE_DATA_CRYSTAL.get())) {
                CoordinateDataCrystalItem crystalItem = (CoordinateDataCrystalItem) crystal.getItem();
                tooltip.add(new TranslationTextComponent("tadditions.data_drive_description"));
                tooltip.add(TardisConstants.Translations.TOOLTIP_HOLD_SHIFT);
                if (Screen.hasShiftDown()) {
                    tooltip.clear();
                    tooltip.add(0, this.getDisplayName(stack));
                    tooltip.add(new TranslationTextComponent("tadditions.data_drive_description"));
                    tooltip.add(new TranslationTextComponent("tadditions.data_drive_crystal_type_1"));
                    tooltip.add(new TranslationTextComponent("tadditions.data_drive_dimension").appendSibling(new StringTextComponent(WorldHelper.formatDimName(crystalItem.getDimData(crystal))).mergeStyle(TextFormatting.DARK_PURPLE)));
                    tooltip.add(new TranslationTextComponent("tadditions.data_drive_coordinates").appendSibling(new StringTextComponent(crystalItem.getCoords(crystal).getCoordinatesAsString()).mergeStyle(TextFormatting.DARK_AQUA)));
                    tooltip.add(new TranslationTextComponent("tadditions.data_drive_status").appendSibling(getStatus(stack)));
                }
            }
        });
    }

    public ITextComponent getStatus(ItemStack stack){
        AtomicReference<TranslationTextComponent> text = new AtomicReference<>(new TranslationTextComponent("tadditions.data_drive_status_error"));

        stack.getCapability(MCapabilities.OPENER_CAPABILITY).ifPresent(cap -> {
            ItemStack crystal = cap.getHandler().getStackInSlot(0);
            if(crystal.getItem().equals(ModItems.BURNED_DATA_CRYSTAL.get())){
                text.set(new TranslationTextComponent("tadditions.data_drive_status_used"));
            }
            else if (cap.getHandler().getStackInSlot(0).isEmpty()) {
                    text.set(new TranslationTextComponent("tadditions.data_drive_status_empty"));
            } else text.set(new TranslationTextComponent("tadditions.data_drive_status_ready"));
        });
        return text.get();
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity player, Hand handIn) {
        ItemStack stack = player.getHeldItem(handIn);
        if(stack != ItemStack.EMPTY && !player.isSneaking()){
            stack.getCapability(MCapabilities.OPENER_CAPABILITY).ifPresent(cap -> {
                ItemStack crystal = cap.getHandler().getStackInSlot(0);
                if(crystal.getItem() instanceof CoordinateDataCrystalItem){
                    CoordinateDataCrystalItem crystalItem = (CoordinateDataCrystalItem) crystal.getItem();
                    crystalItem.setDimData(crystal, worldIn.getDimensionKey());
                    crystalItem.setCoords(crystal, player.getPosition());
                }
            });
        }
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
