package net.tadditions.mod.init;

import com.mojang.serialization.Codec;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.tadditions.mod.TemporalAdditionsMod;

public class StructureInit {

    public static final DeferredRegister<StructureType<?>> DEFERRED_REGISTRY_STRUCTURE = DeferredRegister.create(Registries.STRUCTURE_TYPE, TemporalAdditionsMod.MOD_ID);

    public static <S extends Structure> StructureType<S> typeConvert(Codec<S> codec)
    {
        return () -> codec;
    }

    public static void register(IEventBus eventBus)
    {
        DEFERRED_REGISTRY_STRUCTURE.register(eventBus);
    }

}
