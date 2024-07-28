package net.tadditions.mod.events;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.block.Block;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.FlatChunkGenerator;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.AdvancementEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartedEvent;
import net.minecraftforge.fml.event.server.ServerLifecycleEvent;
import net.minecraftforge.fml.server.ServerLifecycleHooks;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.blocks.ContainmentChamberBlock;
import net.tadditions.mod.blocks.ModBlocks;
import net.tadditions.mod.cap.*;
import net.tadditions.mod.commands.TACommands;
import net.tadditions.mod.helper.IConsoleHelp;
import net.tadditions.mod.helper.MHelper;
import net.tadditions.mod.items.ModItems;
import net.tadditions.mod.sound.MSounds;
import net.tadditions.mod.world.MDimensions;
import net.tadditions.mod.world.structures.MStructures;
import net.tardis.mod.cap.Capabilities;
import net.tardis.mod.client.ClientHelper;
import net.tardis.mod.controls.CommunicatorControl;
import net.tardis.mod.damagesources.TDamageSources;
import net.tardis.mod.events.LivingEvents;
import net.tardis.mod.events.MissingMappingsLookup;
import net.tardis.mod.helper.PlayerHelper;
import net.tardis.mod.helper.TardisHelper;
import net.tardis.mod.items.ISpaceHelmet;
import net.tardis.mod.items.TItems;
import net.tardis.mod.misc.IDontBreak;
import net.tardis.mod.sounds.TSounds;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.world.biomes.TBiomes;
import net.tardis.mod.world.dimensions.TDimensions;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.ConsoleHandler;

@Mod.EventBusSubscriber(modid = QolMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CommonEvents {


    public static final ResourceLocation ONEUSEREMOTE_CAP = new ResourceLocation(QolMod.MOD_ID, "olim_remote");
    public static final ResourceLocation TAGREAOPENER_CAP = new ResourceLocation(QolMod.MOD_ID, "data_drive");
    public static final ResourceLocation QUANT_CAP = new ResourceLocation(QolMod.MOD_ID, "quantum");


    private static HashMap<ResourceLocation, ResourceLocation> remappedEntries = new HashMap<ResourceLocation, ResourceLocation>();
    @SubscribeEvent
    public static void attachWorldCaps(AttachCapabilitiesEvent<World> event) {

    }

    @SubscribeEvent
    public static void attachItemStackCap(AttachCapabilitiesEvent<ItemStack> event) {
        if (event.getObject().getItem() == ModItems.OLIM_REMOTE.get())
            event.addCapability(ONEUSEREMOTE_CAP, new IOneRemote.Provider(new OneUseRemoteCapability(event.getObject())));
        if (event.getObject().getItem() == ModItems.DATA_DRIVE.get())
            event.addCapability(TAGREAOPENER_CAP, new IOpener.Provider(new DataDriveCap()));
        if (event.getObject().getItem() == ModItems.QUANTUM_EXOTIC_MATTER.get())
            event.addCapability(QUANT_CAP, new IQuant.Provider(new QuantCapability(event.getObject())));
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event){
        if(event.player.getEntityWorld().getGameTime() % 20 == 0) {
            if (event.player.getEntityWorld().getDimensionKey() == MDimensions.THE_VERGE) {
                if (event.player.getFoodStats().getFoodLevel() < 10)
                    event.player.getFoodStats().setFoodLevel(10);
            }
            if(event.player.getEntityWorld().getDimensionKey() == TDimensions.VORTEX_DIM) {
                if (event.player.getHealth() != 1) {
                    boolean has_vortex_manip = false;
                    for(int i = 0; i < 9; i++){
                        if(event.player.inventory.getStackInSlot(i).getItem().equals(TItems.VORTEX_MANIP.get()))
                            has_vortex_manip = true;
                    }
                    if (!has_vortex_manip) {
                        event.player.attackEntityFrom(DamageSource.OUT_OF_WORLD, 1);
                    }
                }
            }
        }
    }
    
    //@SubscribeEvent
    //public static void onServerStart(FMLServerStartedEvent event) {
    //    MHelper.removeWorlds.add(MDimensions.THE_VERGE);
    //}

    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {
        MinecraftServer server = ServerLifecycleHooks.getCurrentServer();
        if (server != null && server.isServerRunning() && event.phase == TickEvent.Phase.START) {
            for (World world : server.getWorlds()) {
                if (world.getCapability(Capabilities.TARDIS_DATA).isPresent() && world.getGameTime() % 40 == 0) {
                    ConsoleTile tile = TardisHelper.getConsole(server, world).orElse(null);
                    if (tile.getInteriorManager().isAlarmOn()) {
                        tile.getOrFindExteriorTile().ifPresent(ext -> ext.getWorld().playSound(null, ext.getPos(), TSounds.SINGLE_CLOISTER.get(), SoundCategory.BLOCKS, 5F, 0.5F));
                    }
                }
                if(world.getCapability(Capabilities.TARDIS_DATA).isPresent() && world.getGameTime() % 100 == 0){
                    ConsoleTile tile = TardisHelper.getConsole(server, world).orElse(null);
                    if (!tile.getDistressSignals().isEmpty() && !tile.getInteriorManager().isAlarmOn()) {
                        if(tile.getControl(CommunicatorControl.class).get().usePhoneSounds(tile)) {
                            tile.getOrFindExteriorTile().ifPresent(ext -> ext.getWorld().playSound(null, ext.getPos(), TSounds.COMMUNICATOR_RING.get(), SoundCategory.BLOCKS, 1F, 1F));
                        } else {
                            tile.getOrFindExteriorTile().ifPresent(ext -> ext.getWorld().playSound(null, ext.getPos(), TSounds.COMMUNICATOR_BEEP.get(), SoundCategory.BLOCKS, 1F, 1F));
                        }
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void registerCommands(RegisterCommandsEvent event) {
        TACommands.register(event.getDispatcher());
    }

    @SubscribeEvent
    public static void onLivingDead(LivingDeathEvent event){
        if(event.getEntity() instanceof EnderDragonEntity && !MHelper.hasEnd){
            MHelper.hasEnd = true;
            for(World world : ServerLifecycleHooks.getCurrentServer().getWorlds()){
                if(world.getCapability(Capabilities.TARDIS_DATA).isPresent()){
                    ConsoleTile tile = TardisHelper.getConsole(ServerLifecycleHooks.getCurrentServer(), world).orElse(null);
                    ((IConsoleHelp) tile).addAvailable(World.THE_END);
                }
            }
        }
    };

    @SubscribeEvent
    public static void onLivingTick(LivingEvent.LivingUpdateEvent event){
        LivingEntity entity = event.getEntityLiving();
        if (entity instanceof PlayerEntity) {

            //Oxygen
            if (entity.getEntityWorld().getDimensionKey() == MDimensions.MARS) {
                if (entity.ticksExisted % 20 == 0) {

                    ItemStack helm = event.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.HEAD);
                    if (helm.getItem() instanceof ISpaceHelmet)
                        if (!((ISpaceHelmet) helm.getItem()).shouldSufficate(entity))
                            return;

                    if (!MinecraftForge.EVENT_BUS.post(new LivingEvents.SpaceAir(entity)))
                        entity.attackEntityFrom(TDamageSources.SPACE, 2);
                }
            }
        }
    }

    public static void getAllMappingEntries(){
        JsonObject obj = MissingMappingsLookup.getMissingMappings();
        for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
            remappedEntries.put(new ResourceLocation(QolMod.MOD_ID, entry.getKey()), new ResourceLocation(QolMod.MOD_ID, entry.getValue().getAsString()));
        }
    }

    /**
     * Add World Gen Objects to existing vanilla biomes or other mod biomes here
     * If we want to configure things, we must use the COMMON config as everything else fires too late.
     * <p> If a feature/structure is added in a json biome added by our mod, don't add it here
     * @param event
     */
    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void onBiomeLoad(BiomeLoadingEvent event) {
        RegistryKey<Biome> biomeRegistryKey = RegistryKey.getOrCreateKey(Registry.BIOME_KEY, event.getName());
        Biome.Category biomeCategory = event.getCategory();
        if (biomeRegistryKey == TBiomes.MOON_BIOME_KEY) {
            event.getGeneration().getStructures().add(() -> MStructures.ConfiguredStructures.CONFIGURED_MOONTEMPLE);
        }
    }

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        if (event.getWorld() instanceof World) {
            World world = (World) event.getWorld();
            if (!world.isRemote() && event.getState().getBlock().matchesBlock(ModBlocks.containment_chamber.get())) {
                if (!event.getState().get(ContainmentChamberBlock.BROKEN))
                {
                    Block.spawnAsEntity(world, event.getPos(), new ItemStack(ModItems.QUANTUM_EXOTIC_MATTER.get()));
                    world.setBlockState(event.getPos(), ModBlocks.containment_chamber.get().getDefaultState().cycleValue(ContainmentChamberBlock.BROKEN));
                    event.setCanceled(true);
                }
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void addDimensionalSpacing(final WorldEvent.Load event) {
        if (event.getWorld() instanceof ServerWorld) {
            ServerWorld serverWorld = (ServerWorld) event.getWorld();

            /* Prevent spawning our structure in Vanilla's superflat world as
             * people seem to want their superflat worlds free of modded structures.
             * Also, vanilla superflat is really tricky and buggy to work with as mentioned in TStructures#registerConfiguredStructure
             * BiomeModificationEvent does not seem to fire for superflat biomes...you can't add structures to superflat without mixin it seems.
             * */
            if (serverWorld.getChunkProvider().getChunkGenerator() instanceof FlatChunkGenerator &&
                    serverWorld.getDimensionKey().equals(World.OVERWORLD)) {
                return;
            }

            if (serverWorld.getDimensionKey().equals(TDimensions.MOON_DIM)) {
                Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(serverWorld.getChunkProvider().generator.func_235957_b_().func_236195_a_());
                tempMap.put(MStructures.Structures.MOON_TEMPLE.get(), DimensionStructuresSettings.field_236191_b_.get(MStructures.Structures.MOON_TEMPLE.get()));
                serverWorld.getChunkProvider().generator.func_235957_b_().field_236193_d_ = tempMap;
            }
        }
    }

}
