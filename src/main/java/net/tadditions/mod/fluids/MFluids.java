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

    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation(QolMod.MOD_ID,"fluid/mercury_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation(QolMod.MOD_ID,"fluid/mercury_flow");
    public static final ResourceLocation WATER_OVERLAY_RL = new ResourceLocation(QolMod.MOD_ID,"fluid/mercury_overlay");

    public static final DeferredRegister<Fluid> FLUIDS
            = DeferredRegister.create(ForgeRegistries.FLUIDS, QolMod.MOD_ID);


    public static final RegistryObject<FlowingFluid> MERCURY_FLUID
            = FLUIDS.register("mercury", () -> new ForgeFlowingFluid.Source(MFluids.MERCURY_PROPERTIES));

    public static final RegistryObject<FlowingFluid> MERCURY_FLOWING
            = FLUIDS.register("mercury_flowing", () -> new ForgeFlowingFluid.Flowing(MFluids.MERCURY_PROPERTIES));


    public static final ForgeFlowingFluid.Properties MERCURY_PROPERTIES = new ForgeFlowingFluid.Properties(
            MERCURY_FLUID, MERCURY_FLOWING, FluidAttributes.builder(WATER_STILL_RL, WATER_FLOWING_RL)
            .density(15000).luminosity(0).viscosity(5000).sound(SoundEvents.ITEM_HONEY_BOTTLE_DRINK).overlay(WATER_OVERLAY_RL)).levelDecreasePerBlock(2)
            .block(MFluids.MERCURY_BLOCK)
            .bucket(ModItems.MERCURY_BUCKET);

    public static final RegistryObject<FlowingFluidBlock> MERCURY_BLOCK = ModBlocks.BLOCKS.register("mercury",
            () -> new FlowingFluidBlock(MFluids.MERCURY_FLUID, AbstractBlock.Properties.create(Material.WATER)
                    .doesNotBlockMovement().hardnessAndResistance(100f).noDrops()));

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }

}
