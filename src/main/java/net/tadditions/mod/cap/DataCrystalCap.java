package net.tadditions.mod.cap;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemStackHandler;
import net.tardis.mod.helper.WorldHelper;

public class DataCrystalCap implements ICrystal {

    private RegistryKey<World> dimdata;
    private boolean used;
    private int type;
    private BlockPos coord;
    private int model;

    public DataCrystalCap() {
        this.dimdata = World.OVERWORLD;
        this.used = false;
        this.type = 0;
        this.coord = BlockPos.ZERO;
        this.model = 0;
    }


    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT tag = new CompoundNBT();
        tag.putString("dimdata", this.dimdata.getLocation().toString());
        tag.putBoolean("used", this.used);
        tag.putInt("type", this.type);
        tag.put("coord",NBTUtil.writeBlockPos(coord));
        tag.putInt("CustomModelData", model);
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        this.dimdata = WorldHelper.getWorldKeyFromRL(ResourceLocation.tryCreate(nbt.getString("dimdata")));
        this.used = nbt.getBoolean("used");
        this.type = nbt.getInt("type");
        this.coord = NBTUtil.readBlockPos(nbt.getCompound("coord"));
        this.model = nbt.getInt("CustomModelData");
    }


    @Override
    public RegistryKey<World> getDimData() {
        return dimdata;
    }

    @Override
    public void setModelID(int model) {
        this.model = model;
    }

    @Override
    public int getModelID() {
        return model;
    }

    @Override
    public void setCoords(BlockPos pos) {
        this.coord = pos;
    }

    @Override
    public BlockPos getCoords() {
        return coord;
    }

    @Override
    public int getType() {
        return type;
    }

    @Override
    public void setType(int type) {
        this.type = type;
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
                this.type = getType();
                this.coord = getCoords();
                this.model = getModelID();
                this.serializeNBT();
                if(this.getUsed()){
                    this.setModelID(0);
                } else if(this.getType() == 0 && !this.getUsed()){
                    this.setModelID(1);
                } else if(this.getType() == 1 && !this.getUsed()) {
                    this.setModelID(2);
                }
            }
        }
    }

}
