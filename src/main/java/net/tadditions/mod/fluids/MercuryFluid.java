package net.tadditions.mod.fluids;

import net.minecraft.entity.Entity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateContainer;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.blocks.ModBlocks;
import net.tadditions.mod.items.ModItems;

import static net.minecraft.block.FlowingFluidBlock.LEVEL;

public abstract class MercuryFluid extends ForgeFlowingFluid {
    public static final ResourceLocation MERCURY_STILL_RL = new ResourceLocation(QolMod.MOD_ID,"fluid/mercury_still");
    public static final ResourceLocation MERCURY_FLOWING_RL = new ResourceLocation(QolMod.MOD_ID,"fluid/mercury_flow");
    public static final ResourceLocation MERCURY_OVERLAY_RL = new ResourceLocation(QolMod.MOD_ID,"fluid/mercury_overlay");

    protected MercuryFluid() {
        super(new Properties(() -> MFluids.MERCURY_FLUID.get(), () -> MFluids.MERCURY_FLUID_FLOWING.get(), FluidAttributes.builder(MERCURY_STILL_RL, MERCURY_FLOWING_RL).viscosity(800).sound(SoundEvents.ITEM_BUCKET_FILL, SoundEvents.ITEM_BUCKET_EMPTY)).block(() -> ModBlocks.MERCURY_BLOCK.get()));
    }

    @Override
    public Item getFilledBucket() {
        return ModItems.MERCURY_BUCKET.get();
    }

    public static class Source extends MercuryFluid
    {

        @Override
        public boolean isSource(FluidState state)
        {
            return true;
        }

        @Override
        public int getLevel(FluidState state)
        {
            return 8;
        }
    }

    public static class Flowing extends MercuryFluid
    {

        @Override
        protected void fillStateContainer(StateContainer.Builder<Fluid, FluidState> state) {
            super.fillStateContainer(state);
            state.add(LEVEL);
        }

        @Override
        public int getLevel(FluidState state)
        {
            return state.get(LEVEL);
        }

        @Override
        public boolean isSource(FluidState state)
        {
            return false;
        }
    }
}
