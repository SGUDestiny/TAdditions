package net.tadditions.mod.tileentity;

import com.google.common.base.Supplier;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.blocks.ModBlocks;
import net.tardis.mod.blocks.TileBlock;

public class ModTileEntitys {

    public static final DeferredRegister<TileEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, QolMod.MOD_ID);


    public static final RegistryObject<TileEntityType<RoundelContainerTileEntity>> ROUNDELCON = TILES.register("roundelcon", () -> registerTiles(RoundelContainerTileEntity::new, ModBlocks.roundelcon_alabaster.get()));

    public static final RegistryObject<TileEntityType<AdvQuantiscopeTile>> ADVQ = TILES.register("advq", () -> registerTiles(AdvQuantiscopeTile::new, ModBlocks.advanced_quantiscope_iron.get()));

    public static final RegistryObject<TileEntityType<SolenoidConTileEntity>> SOLENOID = TILES.register("solenoid", () -> registerTiles(SolenoidConTileEntity::new, ModBlocks.electromagnetic_solenoid_container.get()));






    private static <T extends TileEntity> TileEntityType<T> registerTiles(Supplier<T> tile, Block... validBlock) {
        TileEntityType<T> type = TileEntityType.Builder.create(tile, validBlock).build(null);
        for(Block block : validBlock) {
            if(block instanceof TileBlock) {
                ((TileBlock)block).setTileEntity(type);
            }
        }
        return type;
    }
}
