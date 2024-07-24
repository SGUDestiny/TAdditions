package net.tadditions.mod.init;

import net.tadditions.mod.TemporalAdditionsMod;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockEntityInit
{
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, TemporalAdditionsMod.MOD_ID);

    //public static final RegistryObject<BlockEntityType<AnimatedBlockEntity>> ANIMATED_BLOCK_ENTITY =
    //        BLOCK_ENTITIES.register("animated_block_entity", () ->
    //                BlockEntityType.Builder.of(AnimatedBlockEntity::new,
    //                        ModBlocks.ANIMATED_BLOCK.get()).build(null));

    public static void register(IEventBus eventBus)
    {
        BLOCK_ENTITIES.register(eventBus);
    }
}
