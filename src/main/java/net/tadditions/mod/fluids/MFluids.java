package net.tadditions.mod.fluids;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.blocks.ModBlocks;
import net.tadditions.mod.items.ModItems;

public class MFluids {


    public static final DeferredRegister<Fluid> FLUIDS
            = DeferredRegister.create(ForgeRegistries.FLUIDS, QolMod.MOD_ID);


    public static final RegistryObject<Fluid> MERCURY_FLUID = FLUIDS.register("blaze_juice", MercuryFluid.Source::new);
    public static final RegistryObject<FlowingFluid> MERCURY_FLUID_FLOWING = FLUIDS.register("flowing_blaze_juice", MercuryFluid.Flowing::new);





    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }

}
