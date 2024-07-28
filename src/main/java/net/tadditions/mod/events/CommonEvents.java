package net.tadditions.mod.events;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.*;
import net.minecraft.util.concurrent.TickDelayedTask;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.Dimension;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.FlatChunkGenerator;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.AdvancementEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
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
import net.minecraftforge.items.ItemStackHandler;
import net.mistersecret312.temporal_api.events.ControlEvent;
import net.mistersecret312.temporal_api.events.MinigameStartEvent;
import net.mistersecret312.temporal_api.events.TardisEvent;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.blocks.ContainmentChamberBlock;
import net.tadditions.mod.blocks.ContainmentChamberPartBlock;
import net.tadditions.mod.blocks.ModBlocks;
import net.tadditions.mod.cap.*;
import net.tadditions.mod.commands.TACommands;
import net.tadditions.mod.enchantments.TAEnchants;
import net.tadditions.mod.helper.IConsoleHelp;
import net.tadditions.mod.helper.IMonitorHelp;
import net.tadditions.mod.helper.MHelper;
import net.tadditions.mod.items.CoordinateDataCrystalItem;
import net.tadditions.mod.items.DimensionalDataCrystalItem;
import net.tadditions.mod.items.ModItems;
import net.tadditions.mod.sound.MSounds;
import net.tadditions.mod.tileentity.FourteenthConsoleTile;
import net.tadditions.mod.upgrades.FrameStabUpgrade;
import net.tadditions.mod.upgrades.MUpgradeRegistry;
import net.tadditions.mod.world.MDimensions;
import net.tadditions.mod.world.structures.MStructures;
import net.tardis.mod.cap.Capabilities;
import net.tardis.mod.client.ClientHelper;
import net.tardis.mod.controls.*;
import net.tardis.mod.damagesources.TDamageSources;
import net.tardis.mod.entity.ControlEntity;
import net.tardis.mod.entity.TEntities;
import net.tardis.mod.events.LivingEvents;
import net.tardis.mod.events.MissingMappingsLookup;
import net.tardis.mod.helper.PlayerHelper;
import net.tardis.mod.helper.TardisHelper;
import net.tardis.mod.items.ISpaceHelmet;
import net.tardis.mod.items.TItems;
import net.tardis.mod.misc.*;
import net.tardis.mod.registries.ControlRegistry;
import net.tardis.mod.sounds.TSounds;
import net.tardis.mod.subsystem.FlightSubsystem;
import net.tardis.mod.subsystem.StabilizerSubsystem;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.tileentities.console.misc.MonitorOverride;
import net.tardis.mod.upgrades.Upgrade;
import net.tardis.mod.world.biomes.TBiomes;
import net.tardis.mod.world.dimensions.TDimensions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
                if (!event.getState().get(ContainmentChamberBlock.BROKEN)) {
                    if (!(EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, event.getPlayer().getHeldItemMainhand()) > 0)) {
                        for (ContainmentChamberBlock.ChamberPart part : ContainmentChamberBlock.ChamberPart.values()) {
                            BlockPos piecePos = ContainmentChamberBlock.ChamberPart.getPartPos(event.getPos(), event.getState().get(ContainmentChamberBlock.PART), part);
                            BlockState pieceState = world.getBlockState(piecePos);
                            if (!pieceState.get(ContainmentChamberBlock.BROKEN))
                                world.setBlockState(piecePos, pieceState.with(ContainmentChamberBlock.BROKEN, true).with(ContainmentChamberBlock.PART, part));
                        }
                        Block.spawnAsEntity(world, event.getPos(), new ItemStack(ModItems.QUANTUM_EXOTIC_MATTER.get()));
                        world.setBlockState(event.getPos(), ModBlocks.containment_chamber.get().getDefaultState().cycleValue(ContainmentChamberBlock.BROKEN));
                        event.setCanceled(true);
                    } else {
                        for (ContainmentChamberBlock.ChamberPart part : ContainmentChamberBlock.ChamberPart.values()) {
                            BlockPos piecePos = ContainmentChamberBlock.ChamberPart.getPartPos(event.getPos(), event.getState().get(ContainmentChamberBlock.PART), part);
                            world.setBlockState(piecePos, Blocks.AIR.getDefaultState());
                        }
                        ContainmentChamberBlock.spawnItem(world, event.getPos(), event.getState().get(ContainmentChamberPartBlock.BROKEN));
                    }
                } else {
                    for (ContainmentChamberBlock.ChamberPart part : ContainmentChamberBlock.ChamberPart.values()) {
                        BlockPos piecePos = ContainmentChamberBlock.ChamberPart.getPartPos(event.getPos(), event.getState().get(ContainmentChamberBlock.PART), part);
                        BlockState pieceState = world.getBlockState(piecePos);
                        if (pieceState.get(ContainmentChamberBlock.BROKEN))
                            world.setBlockState(piecePos, Blocks.AIR.getDefaultState());
                    }
                }
            }

            if(!world.isRemote() && event.getState().getBlock().matchesBlock(ModBlocks.containment_chamber_part.get()))
            {
                if(!(EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, event.getPlayer().getHeldItemMainhand()) > 0)) {
                    event.setCanceled(true);
                    if (!event.getState().get(ContainmentChamberPartBlock.BROKEN)) {
                        for (ContainmentChamberBlock.ChamberPart part : ContainmentChamberBlock.ChamberPart.values()) {
                            BlockPos piecePos = ContainmentChamberBlock.ChamberPart.getPartPos(event.getPos(), event.getState().get(ContainmentChamberBlock.PART), part);
                            BlockState pieceState = world.getBlockState(piecePos);
                            if(pieceState.getBlock() != Blocks.AIR)
                                world.setBlockState(piecePos, pieceState.with(ContainmentChamberBlock.BROKEN, true).with(ContainmentChamberBlock.PART, part));
                        }
                        Block.spawnAsEntity(world, event.getPos(), new ItemStack(ModItems.QUANTUM_EXOTIC_MATTER.get()));
                    } else {
                        for (ContainmentChamberBlock.ChamberPart part : ContainmentChamberBlock.ChamberPart.values()) {
                            BlockPos piecePos = ContainmentChamberBlock.ChamberPart.getPartPos(event.getPos(), event.getState().get(ContainmentChamberBlock.PART), part);
                            world.setBlockState(piecePos, Blocks.AIR.getDefaultState());
                        }
                    }
                } else {
                    for (ContainmentChamberBlock.ChamberPart part : ContainmentChamberBlock.ChamberPart.values()) {
                        BlockPos piecePos = ContainmentChamberBlock.ChamberPart.getPartPos(event.getPos(), event.getState().get(ContainmentChamberBlock.PART), part);
                        world.setBlockState(piecePos, Blocks.AIR.getDefaultState());
                    }
                    ContainmentChamberBlock.spawnItem(world, event.getPos(), event.getState().get(ContainmentChamberPartBlock.BROKEN));

                }
            }
        }
    }

    @SubscribeEvent
    public static void onTakeoff(TardisEvent.TakeoffEvent event)
    {
        ((IConsoleHelp) event.getConsole()).setCloakState(false);

        if(event.getConsole().getDestinationDimension().equals(World.THE_END) && !event.getConsole().getUpgrade(FrameStabUpgrade.class).isPresent())
        {
            event.setCanceled(true);
            event.getConsole().getWorld().playSound(null, event.getConsole().getPos(), TSounds.CANT_START.get(), SoundCategory.BLOCKS, 1F, 1F);
        }
    }

    @SubscribeEvent
    public static void onLanding(TardisEvent.LandEvent event)
    {
        if (!event.getConsole().getWorld().isRemote && event.getConsole().getDestinationDimension() == MDimensions.THE_VERGE)
        {
            if (event.getConsole().getUpgrade(FrameStabUpgrade.class).isPresent()) {
                event.getConsole().getUpgrade(FrameStabUpgrade.class).ifPresent(up -> {
                    if (up.isActivated() && up.isUsable()) {
                        up.damage(10, Upgrade.DamageType.ITEM, null);
                    } else {
                        event.setCanceled(true);
                        voidCrash(event.getConsole());
                    }
                });
            } else {
                event.setCanceled(true);
                voidCrash(event.getConsole());
            }
        }

        if(!event.getConsole().getWorld().isRemote && event.getConsole().getDestinationDimension() == World.THE_END)
        {

            if(event.getConsole().getUpgrade(FrameStabUpgrade.class).isPresent()){
                event.getConsole().getUpgrade(FrameStabUpgrade.class).ifPresent(up -> {
                    if(up.isActivated() && up.isUsable()) {
                        up.damage(1, Upgrade.DamageType.ITEM, null);
                    } else {
                        event.setCanceled(true);
                        event.getConsole().setDestination(event.getConsole().getReturnLocation());
                        event.getConsole().setDestinationReachedTick(100);
                        event.getConsole().crash(CrashTypes.DEFAULT);
                    }
                });
            } else {
                event.setCanceled(true);
                event.getConsole().setDestination(event.getConsole().getReturnLocation());
                event.getConsole().setDestinationReachedTick(100);
                event.getConsole().crash(CrashTypes.DEFAULT);
            }
        }
    }

    @SubscribeEvent
    public static void onSpeedCalculate(TardisEvent.SpeedCalculationEvent event)
    {
        ObjectWrapper<Float> speedmod = new ObjectWrapper<>(1.0F);
        event.getConsole().getWorld().getCapability(Capabilities.TARDIS_DATA).ifPresent(tard -> {
            ItemStackHandler handler = tard.getEngineInventoryForSide(Direction.NORTH).getHandler();
            for(int i = 0; i<handler.getSlots(); i++){
                if(handler.getStackInSlot(i).getItem().getRegistryName().toString().contains("overcharged")){
                    speedmod.setValue(speedmod.getValue()+0.125F);
                }
                if(EnchantmentHelper.getEnchantmentLevel(TAEnchants.BLESSING_OF_FLOW.get(), handler.getStackInSlot(i)) > 0){
                    speedmod.setValue(speedmod.getValue()*1.25F);
                }
                if(EnchantmentHelper.getEnchantmentLevel(TAEnchants.CURSE_OF_WINDS.get(), handler.getStackInSlot(i)) > 0){
                    speedmod.setValue(speedmod.getValue()*0.75F);
                }
            }
        });
        if(((IConsoleHelp) event.getConsole()).getRecentTimeStormCompletion())
            speedmod.setValue(speedmod.getValue()*4);

        event.speed *= speedmod.getValue();
    }

    @SubscribeEvent
    public static void onControlHit(ControlEvent.ControlHitEvent event)
    {
        if((event.getControl().getEntry().equals(ControlRegistry.X.get()) || event.getControl().getEntry().equals(ControlRegistry.Y.get()) || event.getControl().getEntry().equals(ControlRegistry.Z.get())) && event.getControl().getConsole().hasNavCom())
        {
            BlockPos position = event.getControl().getConsole().getDestinationPosition();
            TranslationTextComponent target = new TranslationTextComponent("tardis.axis_control.interact.target_change");
            IFormattableTextComponent x = new StringTextComponent("X - ").appendString(String.valueOf(position.getX())).mergeStyle(TextFormatting.LIGHT_PURPLE);
            IFormattableTextComponent y = new StringTextComponent(", Y - ").appendString(String.valueOf(position.getY())).mergeStyle(TextFormatting.LIGHT_PURPLE);
            IFormattableTextComponent z = new StringTextComponent(", Z - ").appendString(String.valueOf(position.getZ())).mergeStyle(TextFormatting.LIGHT_PURPLE);
            target.appendSibling(x).appendSibling(y).appendSibling(z);
            event.getPlayer().sendStatusMessage(target, true);
        }
        if(event.getControl().getEntry().equals(ControlRegistry.MONITOR.get()) && event.getPlayer().isSneaking())
        {
            event.setCanceled(true);
            if(event.getControl().getConsole() instanceof FourteenthConsoleTile) {
                BlockPos pos = event.getControl().getConsole().getPos();
                Vector3d p = event.getPlayer().getPositionVec().subtract(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5).normalize();

                float hype = (float) Math.sqrt(p.x * p.x + p.z * p.z);
                float rot;
                if (p.z < 0)
                    rot = (float) Math.toDegrees(Math.asin(p.x / hype));
                else rot = -(float) Math.toDegrees(Math.asin(p.x / hype)) - 180;
                rot = (rot + 180);
                if (rot < 0)
                    rot = rot + 360;

                if (rot < 30)
                    rot = 0;
                if (rot >= 30 && rot < 90)
                    rot = 60;
                if (rot >= 90 && rot < 180)
                    rot = 120;
                if (rot >= 180 && rot < 270)
                    rot = -120;
                if (rot >= 270 && rot < 330)
                    rot = -60;
                if (rot >= 330)
                    rot = 0;
                ((IMonitorHelp) event.getControl()).setRotAngle(rot);
            }
        }

    }

    @SubscribeEvent
    public static void onControlInteract(PlayerInteractEvent.EntityInteractSpecific event)
    {
        if(event.getTarget().getType().equals(TEntities.CONTROL.get()) && (((ControlEntity) event.getTarget()).getControl().getEntry().equals(ControlRegistry.X.get()) || (((ControlEntity) event.getTarget()).getControl().getEntry().equals(ControlRegistry.Y.get()) || (((ControlEntity) event.getTarget()).getControl().getEntry().equals(ControlRegistry.Z.get())) && (((ControlEntity) event.getTarget()).getControl().getConsole().hasNavCom()))))
        {
            BlockPos position = (((ControlEntity) event.getTarget()).getControl().getConsole().getDestinationPosition());
            TranslationTextComponent target = new TranslationTextComponent("tardis.axis_control.interact.target_change");
            IFormattableTextComponent x = new StringTextComponent(" X - ").appendString(String.valueOf(position.getX())).mergeStyle(TextFormatting.LIGHT_PURPLE);
            IFormattableTextComponent y = new StringTextComponent(", Y - ").appendString(String.valueOf(position.getY())).mergeStyle(TextFormatting.LIGHT_PURPLE);
            IFormattableTextComponent z = new StringTextComponent(", Z - ").appendString(String.valueOf(position.getZ())).mergeStyle(TextFormatting.LIGHT_PURPLE);
            target.appendSibling(x).appendSibling(y).appendSibling(z);
            event.getPlayer().sendStatusMessage(target, true);
        }

        if(event.getTarget().getType().equals(TEntities.CONTROL.get()) && ((ControlEntity) event.getTarget()).getControl().getEntry().equals(ControlRegistry.MONITOR.get()) && event.getPlayer().isSneaking())
        {
            AbstractControl control = ((ControlEntity) event.getTarget()).getControl();
            event.setCanceled(true);
            if(control.getConsole() instanceof FourteenthConsoleTile) {
                BlockPos pos = control.getConsole().getPos();
                Vector3d p = event.getPlayer().getPositionVec().subtract(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5).normalize();

                float hype = (float) Math.sqrt(p.x * p.x + p.z * p.z);
                float rot;
                double degrees = Math.toDegrees(Math.asin(p.x / hype));
                if (p.z < 0)
                    rot = (float) degrees;
                else rot = -(float) degrees - 180;
                rot = (rot + 180);
                if (rot < 0)
                    rot = rot + 360;

                if (rot < 30)
                    rot = 0;
                if (rot >= 30 && rot < 90)
                    rot = 60;
                if (rot >= 90 && rot < 180)
                    rot = 120;
                if (rot >= 180 && rot < 270)
                    rot = -120;
                if (rot >= 270 && rot < 330)
                    rot = -60;
                if (rot >= 330)
                    rot = 0;
                ((IMonitorHelp) control).setRotAngle(rot);
            }
        }
    }

    @SubscribeEvent
    public static void onMinigame(MinigameStartEvent event)
    {
        if(event.getPlayer().isCreative())
            event.setCanceled(true);
    }

    @SubscribeEvent
    public static void onDataDrive(ControlEvent.SonicPutEvent event)
    {
        ItemStack stack = event.getItemStack();
        ConsoleTile console = event.getControl().getConsole();

        stack.getCapability(MCapabilities.OPENER_CAPABILITY).ifPresent(cap -> {
            if (!cap.getHandler().getStackInSlot(0).isItemEqual(ItemStack.EMPTY)) {
                ItemStack crystal = cap.getHandler().getStackInSlot(0);
                if(crystal.getItem().equals(ModItems.DIMENSIONAL_DATA_CRYSTAL.get())){
                    DimensionalDataCrystalItem crystalItem = (DimensionalDataCrystalItem) crystal.getItem();
                    if (!((IConsoleHelp) console).getAvailable().contains(crystalItem.getDimData(crystal))) {
                        ((IConsoleHelp) console).addAvailable(crystalItem.getDimData(crystal));
                        cap.getHandler().setStackInSlot(0, new ItemStack(ModItems.BURNED_DATA_CRYSTAL.get()));
                        event.getControl().getEntity().world.playSound(null, event.getControl().getEntity().getPosition(), TSounds.SCREEN_BEEP_SINGLE.get(), SoundCategory.PLAYERS, 1f, 1f);
                    }
                }
                else if(crystal.getItem().equals(ModItems.COORDINATE_DATA_CRYSTAL.get())){
                    CoordinateDataCrystalItem crystalItem = (CoordinateDataCrystalItem) crystal.getItem();
                    if (((IConsoleHelp) console).getAvailable().contains(crystalItem.getDimData(crystal)) && !crystalItem.getCoords(crystal).equals(BlockPos.ZERO)) {
                        cap.getHandler().setStackInSlot(0, new ItemStack(ModItems.BURNED_DATA_CRYSTAL.get()));
                        event.getControl().getEntity().world.playSound(null, event.getControl().getEntity().getPosition(), TSounds.REACHED_DESTINATION.get(), SoundCategory.PLAYERS, 1f, 1f);
                        console.getWorld().getServer().enqueue(new TickDelayedTask(30, () -> {
                            console.setDestination(new SpaceTimeCoord(crystalItem.getDimData(crystal), crystalItem.getCoords(crystal)));
                            console.getControl(ThrottleControl.class).ifPresent(throttle -> throttle.setAmount(1.0F));
                            console.getControl(HandbrakeControl.class).ifPresent(handbrake -> handbrake.setFree(true));
                            console.getSubsystem(StabilizerSubsystem.class).ifPresent(sys -> sys.setControlActivated(true));
                            console.takeoff();

                            crystalItem.setDimData(crystal, World.OVERWORLD);
                            crystalItem.setCoords(crystal, BlockPos.ZERO);
                        }));
                    } else if (crystalItem.getCoords(crystal).equals(BlockPos.ZERO)) {
                        event.getControl().getEntity().world.playSound(null, event.getControl().getEntity().getPosition(), TSounds.REMOTE_ACCEPT.get(), SoundCategory.PLAYERS, 1f, 1f);
                        crystalItem.setCoords(crystal, console.getDestinationPosition());
                        crystalItem.setDimData(crystal, console.getDestinationDimension());
                    } else if (!((IConsoleHelp) console).getAvailable().contains(crystalItem.getDimData(crystal)) && !crystalItem.getCoords(crystal).equals(BlockPos.ZERO)) {
                        event.getControl().getEntity().world.playSound(null, event.getControl().getEntity().getPosition(), TSounds.CANT_START.get(), SoundCategory.PLAYERS, 1f, 1f);
                        event.getControl().getEntity().world.playSound(null, event.getControl().getEntity().getPosition(), TSounds.SINGLE_CLOISTER.get(), SoundCategory.PLAYERS, 1f, 1f);
                    }
                }
            }
        });

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


    public static void voidCrash(ConsoleTile console) {

        console.crash(new CrashType(100, 0, true));
        console.getSubSystems().forEach(sub -> sub.damage(null, 38));

        console.getSubsystem(FlightSubsystem.class).ifPresent(fly -> fly.damage(null, 650));

        List<String> list = new ArrayList<>();
        list.add(new TranslationTextComponent("warning.spatial_rupture.line1").getString());
        list.add(new TranslationTextComponent("warning.spatial_rupture.line2").getString());
        console.getInteriorManager().setMonitorOverrides(new MonitorOverride(console, 200, list));

        console.getWorld().getServer().enqueue(new TickDelayedTask(400, () -> {
            console.getInteriorManager().setAlarmOn(false);
            console.getInteriorManager().setLight(0);
            console.getWorld().playSound(null, console.getPos(), TSounds.POWER_DOWN.get(), SoundCategory.BLOCKS, 20F, 1F);
            console.updateClient();
        }));    }
}
