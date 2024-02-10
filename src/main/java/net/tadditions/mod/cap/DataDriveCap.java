package net.tadditions.mod.cap;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;

public class DataDriveCap implements IOpener {

    private ResourceLocation dimdata = World.OVERWORLD.getLocation();
    private ItemStack remote;

    public DataDriveCap(ItemStack stack) {
        this.remote = stack;
    }


    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT tag = new CompoundNBT();
        tag.putString("dimdata", this.dimdata.getPath());
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        this.dimdata = ResourceLocation.tryCreate(nbt.getString("dimdata"));
    }


    @Override
    public ResourceLocation getDimdata() {
        return dimdata;
    }

    @Override
    public void setDimdata(ResourceLocation type) {
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
