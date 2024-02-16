package net.tadditions.mod.cap;

import com.simibubi.create.foundation.utility.NBTHelper;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemStackHandler;
import net.tadditions.mod.world.MDimensions;
import net.tardis.mod.helper.WorldHelper;

public class DataDriveCap implements IOpener {

    private RegistryKey<World> dimdata;
    private ItemStackHandler handler = new ItemStackHandler();
    private boolean crystalUsed = false;

    public DataDriveCap() {
        dimdata = World.OVERWORLD;
    }


    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT tag = new CompoundNBT();
        tag.putString("dimdata", this.dimdata.getLocation().toString());
        tag.put("crystal", this.handler.serializeNBT());
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        this.dimdata = WorldHelper.getWorldKeyFromRL(ResourceLocation.tryCreate(nbt.getString("dimdata")));
        this.handler.deserializeNBT(nbt);
    }


    @Override
    public RegistryKey<World> getDimdata() {
        return dimdata;
    }

    @Override
    public void setDimdata(RegistryKey<World> type) {
        dimdata = type;
    }

    @Override
    public void tick(World worldIn, Entity entityIn) {
        if (!worldIn.isRemote) {
            if (worldIn.getGameTime() % 20 == 0) {
                this.dimdata = getDimdata();
                this.serializeNBT();
            }
        }
        ItemStack crystal = handler.getStackInSlot(0);
        if(!crystal.isItemEqual(ItemStack.EMPTY)) {
            crystal.getCapability(MCapabilities.CRYSTAL_CAPABILITY).ifPresent(cap -> {
                if (!cap.getUsed()) {
                    this.setDimdata(cap.getDimData());
                }
            });
        }
    }

    public ItemStackHandler getHandler() {
        return handler;
    }
}
