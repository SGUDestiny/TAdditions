package net.tadditions.mod.init;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tadditions.mod.TemporalAdditionsMod;
import net.tadditions.mod.block.QuantascopeBlock;

import java.util.function.Supplier;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TemporalAdditionsMod.MOD_ID);

    public static final RegistryObject<Block> QUANTASCOPE = registerBlock("quantascope", () -> new QuantascopeBlock(BlockBehaviour.Properties.of()));
    
    public static final RegistryObject<Block> ASH = registerBlock("ash", () -> new FallingBlock(BlockBehaviour.Properties.of().sound(SoundType.SAND)));
    public static final RegistryObject<Block> DENSE_ASH = registerBlock("dense_ash", () -> new Block(BlockBehaviour.Properties.of()));

    public static final RegistryObject<Block> FROSTBEARING_DUST = registerBlock("frostbearing_dust", () -> new FallingBlock(
            BlockBehaviour.Properties.of()
                    .sound(SoundType.SNOW)
                    .instabreak()
    ));
    public static final RegistryObject<Block> FROSTBEARING_ROCK = registerBlock("frostbearing_rock", () -> new Block(
            BlockBehaviour.Properties.of()
                    .sound(SoundType.GLASS)
                    .instabreak()
    ));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block)
    {
        return ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()));
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}
