package net.tadditions.mod.cap;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemStackHandler;
import net.tardis.mod.helper.WorldHelper;

public class DataCrystalCap implements ICrystal {

    private RegistryKey<World> dimdata;
    private boolean used;

    public DataCrystalCap() {
        this.dimdata = World.OVERWORLD;
        this.used = false;
    }


    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT tag = new CompoundNBT();
        tag.putString("dimdata", this.dimdata.getLocation().toString());
        tag.putBoolean("used", this.used);
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        this.dimdata = WorldHelper.getWorldKeyFromRL(ResourceLocation.tryCreate(nbt.getString("dimdata")));
        this.used = nbt.getBoolean("used");
    }


    @Override
    public RegistryKey<World> getDimData() {
        return dimdata;
    }

    @Override
    public void setDimData(RegistryKey<World> type) {
        dimdata = type;
    }

    @Override
    public boolean getUsed() {
        return used;
    }

    @Override
    public void setUsed(boolean used) {
        this.used = used;
    }

    @Override
    public void tick(World worldIn, Entity entityIn) {
        if (!worldIn.isRemote) {
            if (worldIn.getGameTime() % 20 == 0) {
                this.dimdata = getDimData();
                this.used = getUsed();
                this.serializeNBT();
            }
        }
    }

}
