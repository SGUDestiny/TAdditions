package net.tadditions.mod.items;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.tardis.mod.constants.TardisConstants;
import net.tardis.mod.enums.EnumDoorState;
import net.tardis.mod.helper.PlayerHelper;
import net.tardis.mod.helper.TardisHelper;
import net.tardis.mod.itemgroups.TItemGroups;
import net.tardis.mod.items.misc.ConsoleBoundWithTooltipItem;
import net.tardis.mod.sounds.TSounds;
import net.tardis.mod.tileentities.exteriors.ExteriorTile;
import net.tardis.mod.upgrades.KeyFobUpgrade;

import javax.annotation.Nullable;
import java.util.List;

public class UndeadLocker extends ConsoleBoundWithTooltipItem {

    public static TranslationTextComponent UNDEADLOCKED = new TranslationTextComponent("message.tadditions.door.undeadlocked");


    public UndeadLocker() {
        super(new Properties().maxStackSize(1).group(TItemGroups.MAIN));
    }

    @Override
    public ResourceLocation getTardis(ItemStack stack) {
        if (stack.getTag() != null && stack.getTag().contains(TardisConstants.TARDIS_KEY_NBT_KEY)) {
            return new ResourceLocation(stack.getTag().getString(TardisConstants.TARDIS_KEY_NBT_KEY));
        } else {
            return null;
        }
    }

    @Override
    public void setTardis(ItemStack stack, ResourceLocation world) {
        stack.getOrCreateTag().putString(TardisConstants.TARDIS_KEY_NBT_KEY, world.toString());
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        if (stack.getItem() instanceof UndeadLocker) {
            if (!worldIn.isRemote) {
                if (getTardis(stack) != null) {
                    TardisHelper.getConsole(worldIn.getServer(), getTardis(stack)).ifPresent(tile -> {
                        tile.getUpgrade(KeyFobUpgrade.class).ifPresent(fob -> {
                            if (fob.isUsable() && fob.isActivated()) {
                                //Open near the exterior
                                if (tile.getCurrentLocation().withinDistance(playerIn.getPosition(), 16) && tile.getCurrentDimension() == playerIn.world.getDimensionKey()) {
                                    ExteriorTile ext = tile.getExteriorType().getExteriorTile(tile);
                                    if (ext != null) {
                                        ext.setAdditionalLockLevel(0);
                                        ext.setLocked(false);
                                        ext.setDoorState(EnumDoorState.CLOSED);
                                        ext.copyDoorStateToInteriorDoor();
                                        worldIn.playSound(null, playerIn.getPosition(), TSounds.CAR_LOCK.get(), SoundCategory.BLOCKS, 1F, 1F);
                                        playerIn.sendStatusMessage(UNDEADLOCKED, true);
                                    }
                                }
                                //Open in the TARDIS dimension
                                else if (playerIn.world == tile.getWorld()) {
                                    tile.getDoor().ifPresent(door -> {
                                        door.setAdditionalLockLevel(0);
                                        door.setLocked(false);
                                        door.setOpenState(EnumDoorState.CLOSED);
                                        door.updateExteriorDoorData();
                                        worldIn.playSound(null, playerIn.getPosition(), TSounds.CAR_LOCK.get(), SoundCategory.BLOCKS, 1F, 1F);
                                    });
                                }
                            }
                        });
                    });
                }
                if (getTardis(stack) == null) {
                    PlayerHelper.sendMessageToPlayer(playerIn, TardisConstants.Translations.ITEM_NOT_ATTUNED, true);
                }
            }
            return ActionResult.resultSuccess(stack);
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {

            tooltip.add(new TranslationTextComponent("tooltip.tadditions.undeadlocker"));

            super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}
