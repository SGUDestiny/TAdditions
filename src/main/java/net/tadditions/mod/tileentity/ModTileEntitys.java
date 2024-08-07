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

    public static final RegistryObject<TileEntityType<ToyotaPoliceBoxExteriorTile>> EXTERIOR_TOYOTA_POLICE_BOX = TILES.register("exterior_toyota_police_box", () ->  registerTiles(ToyotaPoliceBoxExteriorTile::new, ModBlocks.exterior_toyota_police_box.get()));
    public static final RegistryObject<TileEntityType<FourteenthPoliceBoxExteriorTile>> EXTERIOR_FOURTEENTH_POLICE_BOX = TILES.register("exterior_fourteenth_police_box", () ->  registerTiles(FourteenthPoliceBoxExteriorTile::new, ModBlocks.exterior_fourteenth_police_box.get()));
    public static final RegistryObject<TileEntityType<CoralExteriorTile>> EXTERIOR_CORAL_POLICE_BOX = TILES.register("exterior_coral_police_box", () ->  registerTiles(CoralExteriorTile::new, ModBlocks.exterior_coral_police_box.get()));
    public static final RegistryObject<TileEntityType<FourteenthConsoleTile>> FOURTEENTH_CONSOLE = TILES.register("console_fourteenth", () -> registerTiles(FourteenthConsoleTile::new, ModBlocks.fourteenth_console.get()));
    public static final RegistryObject<TileEntityType<ToyotaPoliceBoxDecoTile>> DECORATIVE_TOYOTA_POLICE_BOX = TILES.register("decorative_toyota_police_box", () ->  registerTiles(ToyotaPoliceBoxDecoTile::new, ModBlocks.decorative_toyota_police_box.get()));
    public static final RegistryObject<TileEntityType<FourteenthPoliceBoxDecoTile>> DECORATIVE_FOURTEENTH_POLICE_BOX = TILES.register("decorative_fourteenth_police_box", () ->  registerTiles(FourteenthPoliceBoxDecoTile::new, ModBlocks.decorative_fourteenth_police_box.get()));

    public static final RegistryObject<TileEntityType<FlightEventDetectorTile>> FLIGHT_EVENT_DETECTOR = TILES.register("flight_event_detector", () ->  registerTiles(FlightEventDetectorTile::new, ModBlocks.flight_event_detector.get()));


    public static final RegistryObject<TileEntityType<WeaponHolderBE>> WPH = TILES.register("wph", () -> registerTiles(WeaponHolderBE::new, ModBlocks.weaponholder.get()));

    public static final RegistryObject<TileEntityType<VergeBarrierTile>> BARRIER = TILES.register("barrier", () -> registerTiles(VergeBarrierTile::new, ModBlocks.barrier.get()));

    public static final RegistryObject<TileEntityType<ContainmentChamberTile>> CONTAINMENT_CHAMBER = TILES.register("containment_chamber", () -> registerTiles(ContainmentChamberTile::new, ModBlocks.containment_chamber.get()));

    public static final RegistryObject<TileEntityType<SolenoidFilledTile>> SolenoidFilled = TILES.register("solenoid_filled", () -> registerTiles(SolenoidFilledTile::new, ModBlocks.filled_electromagnetic_solenoid_container.get()));



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
