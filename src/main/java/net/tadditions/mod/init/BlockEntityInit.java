package net.tadditions.mod.init;

import net.minecraftforge.registries.RegistryObject;
import net.tadditions.mod.TemporalAdditionsMod;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.tadditions.mod.block_entities.QuantascopeEntity;

public class BlockEntityInit
{
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, TemporalAdditionsMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<QuantascopeEntity>> QUANTASCOPE =
            BLOCK_ENTITIES.register("quantascope", () -> 
                    BlockEntityType.Builder.of(QuantascopeEntity::new,
                            BlockInit.QUANTASCOPE.get()).build(null));

    public static void register(IEventBus eventBus)
    {
        BLOCK_ENTITIES.register(eventBus);
    }
}
