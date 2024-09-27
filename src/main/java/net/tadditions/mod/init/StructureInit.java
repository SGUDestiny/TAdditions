package net.tadditions.mod.init;

import com.mojang.serialization.Codec;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.tadditions.mod.TemporalAdditionsMod;
import net.tadditions.mod.worldgen.structures.VergeGateStructure;

public class StructureInit {

    public static final DeferredRegister<StructureType<?>> STRUCTURES = DeferredRegister.create(Registries.STRUCTURE_TYPE, TemporalAdditionsMod.MOD_ID);

    public static final RegistryObject<StructureType<?>> VERGE_GATE = STRUCTURES
            .register("verge_gate", () -> typeConvert(VergeGateStructure.CODEC));

    public static <S extends Structure> StructureType<S> typeConvert(Codec<S> codec)
    {
        return () -> codec;
    }

    public static void register(IEventBus eventBus)
    {
        STRUCTURES.register(eventBus);
    }

}
