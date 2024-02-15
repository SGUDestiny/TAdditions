package net.tadditions.mod.cap;

import com.simibubi.create.foundation.utility.NBTHelper;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.tadditions.mod.world.MDimensions;

public class DataDriveCap implements IOpener {

    private String dimdata = MDimensions.THE_VERGE.getLocation().toString();
    private ItemStack remote;

    public DataDriveCap(ItemStack stack) {
        this.remote = stack;
    }


    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT tag = new CompoundNBT();
        tag.putString("dimdata", this.dimdata);
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        this.dimdata = nbt.getString("dimdata");
    }


    @Override
    public String getDimdata() {
        return dimdata;
    }

    @Override
    public void setDimdata(String type) {
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
    }
}
