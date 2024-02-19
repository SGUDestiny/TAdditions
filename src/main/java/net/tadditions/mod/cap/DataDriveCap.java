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

    private ItemStackHandler handler;
    private int model;

    public DataDriveCap() {
        handler = new ItemStackHandler();
        this.model = 3;
    }

    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT tag = new CompoundNBT();
        tag.put("crystal", this.handler.serializeNBT());
        tag.putInt("CustomModelData", model);
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        this.handler.deserializeNBT(nbt.getCompound("crystal"));
        this.model = nbt.getInt("CustomModelData");
    }

    @Override
    public void tick(World worldIn, Entity entityIn) {
        if (!worldIn.isRemote) {
            if (worldIn.getGameTime() % 20 == 0) {
                this.handler = getHandler();
                this.model = getModelID();
                this.serializeNBT();
                this.getHandler().getStackInSlot(0).getCapability(MCapabilities.CRYSTAL_CAPABILITY).ifPresent(cap ->{
                    cap.tick(worldIn, entityIn);
                    setModelID(cap.getModelID());
                });
                if(this.getHandler().getStackInSlot(0).isEmpty()){
                    setModelID(3);
                }
            }
        }
    }

    public ItemStackHandler getHandler() {
        return handler;
    }

    @Override
    public void setModelID(int model) {
        this.model = model;
    }

    @Override
    public int getModelID() {
        return model;
    }
}
