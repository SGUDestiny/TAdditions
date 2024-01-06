package net.tadditions.mixin;

import com.google.common.collect.Maps;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.concurrent.TickDelayedTask;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.items.ItemStackHandler;
import net.tadditions.mod.enchantments.TAEnchants;
import net.tadditions.mod.helper.IConsoleHelp;
import net.tadditions.mod.helper.MExteriorAnimationRegistry;
import net.tadditions.mod.helper.MExteriorRegistry;
import net.tadditions.mod.helper.MSoundSchemeRegistry;
import net.tadditions.mod.items.ModItems;
import net.tadditions.mod.tileentity.ToyotaPoliceBoxExteriorTile;
import net.tadditions.mod.upgrades.FrameStabUpgrade;
import net.tadditions.mod.world.MDimensions;
import net.tardis.mod.ars.ConsoleRoom;
import net.tardis.mod.cap.Capabilities;
import net.tardis.mod.config.TConfig;
import net.tardis.mod.constants.TardisConstants;
import net.tardis.mod.controls.ThrottleControl;
import net.tardis.mod.entity.ControlEntity;
import net.tardis.mod.entity.DoorEntity;
import net.tardis.mod.entity.TardisEntity;
import net.tardis.mod.exterior.AbstractExterior;
import net.tardis.mod.flight.FlightEvent;
import net.tardis.mod.flight.TardisCollideInstigate;
import net.tardis.mod.flight.TardisCollideRecieve;
import net.tardis.mod.helper.TardisHelper;
import net.tardis.mod.helper.WorldHelper;
import net.tardis.mod.items.ArtronCapacitorItem;
import net.tardis.mod.items.TItems;
import net.tardis.mod.misc.*;
import net.tardis.mod.network.Network;
import net.tardis.mod.network.packets.ConsoleUpdateMessage;
import net.tardis.mod.network.packets.console.DataTypes;
import net.tardis.mod.network.packets.console.Fuel;
import net.tardis.mod.network.packets.console.NavComData;
import net.tardis.mod.registries.*;
import net.tardis.mod.sounds.AbstractSoundScheme;
import net.tardis.mod.sounds.TSounds;
import net.tardis.mod.subsystem.*;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.tileentities.console.misc.*;
import net.tardis.mod.tileentities.exteriors.ExteriorTile;
import net.tardis.mod.tileentities.inventory.PanelInventory;
import net.tardis.mod.upgrades.Upgrade;
import net.tardis.mod.upgrades.UpgradeEntry;
import net.tardis.mod.world.dimensions.TDimensions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import javax.xml.ws.Holder;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static net.tardis.mod.tileentities.ConsoleTile.rand;

@Mixin(ConsoleTile.class)
public abstract class ConsoleMixin extends TileEntity implements IConsoleHelp {

    @Shadow public abstract RegistryKey<World> getCurrentDimension();

    @Shadow public abstract InteriorManager getInteriorManager();

    @Shadow public abstract void setNextConsoleRoomToChange(ConsoleRoom room);

    @Shadow public abstract void setStartChangingInterior(boolean startChangingInterior);

    @Shadow public abstract void onPowerDown(boolean shutDown);

    @Shadow public abstract LazyOptional<DoorEntity> getDoor();

    @Shadow public abstract LazyOptional<ExteriorTile> getOrFindExteriorTile();

    @Shadow public abstract ArtronUse getOrCreateArtronUse(ArtronUse.IArtronType type);

    @Shadow public abstract List<Subsystem> getSubSystems();

    @Shadow public abstract boolean isCrashing();

    public int flightTicks = 0;
    private int reachDestinationTick = 0;
    private EmotionHandler emotionHandler;
    private InteriorManager interiorManager;
    private List<PlayerEntity> players = new ArrayList<PlayerEntity>();
    private List<ITickable> tickers = new ArrayList<ITickable>();
    private HashMap<ResourceLocation, INBTSerializable<CompoundNBT>> dataHandlers = new HashMap<ResourceLocation, INBTSerializable<CompoundNBT>>();
    private ArrayList<ControlEntity> controls = new ArrayList<ControlEntity>();
    private ArrayList<ControlRegistry.ControlEntry> controlEntries = new ArrayList<ControlRegistry.ControlEntry>();
    private AbstractExterior exterior;
    private AbstractSoundScheme scheme;
    private BlockPos location = BlockPos.ZERO;
    private BlockPos destination = BlockPos.ZERO;
    private RegistryKey<World> dimension;
    private RegistryKey<World> destinationDimension;
    private Direction facing = Direction.NORTH;
    private float max_artron = 0;
    private float artron = 0;
    private float rechargeMod = 1F;
    private ConsoleRoom consoleRoom = ConsoleRoom.STEAM;
    private List<Subsystem> subsystems = new ArrayList<>();
    private List<Upgrade> upgrades = new ArrayList<>();
    private String customName = "";
    private ExteriorPropertyManager exteriorProps;
    private SpaceTimeCoord returnLocation = SpaceTimeCoord.UNIVERAL_CENTER;
    private FlightEvent currentEvent = null;
    private List<DistressSignal> distressSignal = new ArrayList<DistressSignal>();
    private ItemStack sonic = ItemStack.EMPTY;
    protected TexVariant[] variants = {};
    private int variant = 0;
    private boolean antiGravs = false;
    private UUID tardisEntityID = null;
    private TardisEntity tardisEntity = null;
    private SparkingLevel sparkLevel = SparkingLevel.NONE;
    private String landingCode = "";
    private int landTime = 0;
    private HashMap<ArtronUse.IArtronType, ArtronUse> artronUses = Maps.newHashMap();
    private LazyOptional<ExteriorTile> exteriorHolder = LazyOptional.empty();
    private boolean dimData = false;
    private boolean didVoidCrash = false;
    private UnlockManager unlockManager;
    protected HashMap<Class<?>, ControlOverride> controlOverrides = Maps.newHashMap();
    private boolean hasPoweredDown = false;
    private boolean hasNavCom = false;
    private boolean isBeingTowed = false;
    private BlockPos takeoffLocation = BlockPos.ZERO;
    /**
     * If the console has been force loaded. Internal use only
     */
    private boolean hasForcedChunksToRemove = false;

    /**
     * If this Tardis console should start changing its interior
     */
    private boolean shouldStartChangingInterior = false;
    /**
     * The ConsoleRoom that we will be changing the current to
     */
    private ConsoleRoom nextRoomToChange = ConsoleRoom.STEAM;

    /**
     * What ever you do do not save / sync this (If you use onLoad() the world won't load)
     */
    private int timeUntilControlSpawn = 10;

    /**
     * Last player to interact with a control, used for loyalty
     */
    private PlayerEntity pilot;

    /**
     * Data handlers Read from this
     */
    private Runnable onLoadAction;

    public ConsoleMixin(TileEntityType<?> type) {
        super(type);
        this.emotionHandler = new EmotionHandler(((ConsoleTile) (Object) this));
        this.interiorManager = new InteriorManager(((ConsoleTile) (Object) this));
        this.exteriorProps = new ExteriorPropertyManager(((ConsoleTile) (Object) this));
        this.exterior = ExteriorRegistry.STEAMPUNK.get();
        this.dimension = World.OVERWORLD;
        this.destinationDimension = World.OVERWORLD;
        this.unlockManager = new UnlockManager(((ConsoleTile) (Object) this));
        this.scheme = SoundSchemeRegistry.BASIC.get();
        ((ConsoleTile) (Object) this).registerControlEntry(ControlRegistry.HANDBRAKE.get());
        ((ConsoleTile) (Object) this).registerControlEntry(ControlRegistry.THROTTLE.get());
        ((ConsoleTile) (Object) this).registerControlEntry(ControlRegistry.RANDOM.get());
        ((ConsoleTile) (Object) this).registerControlEntry(ControlRegistry.DIMENSION.get());
        ((ConsoleTile) (Object) this).registerControlEntry(ControlRegistry.FACING.get());
        ((ConsoleTile) (Object) this).registerControlEntry(ControlRegistry.X.get());
        ((ConsoleTile) (Object) this).registerControlEntry(ControlRegistry.Y.get());
        ((ConsoleTile) (Object) this).registerControlEntry(ControlRegistry.Z.get());
        ((ConsoleTile) (Object) this).registerControlEntry(ControlRegistry.INC_MOD.get());
        ((ConsoleTile) (Object) this).registerControlEntry(ControlRegistry.LAND_TYPE.get());
        ((ConsoleTile) (Object) this).registerControlEntry(ControlRegistry.REFUELER.get());
        ((ConsoleTile) (Object) this).registerControlEntry(ControlRegistry.FAST_RETURN.get());
        ((ConsoleTile) (Object) this).registerControlEntry(ControlRegistry.TELEPATHIC.get());
        ((ConsoleTile) (Object) this).registerControlEntry(ControlRegistry.STABILIZERS.get());
        ((ConsoleTile) (Object) this).registerControlEntry(ControlRegistry.SONIC_PORT.get());
        ((ConsoleTile) (Object) this).registerControlEntry(ControlRegistry.COMMUNICATOR.get());
        ((ConsoleTile) (Object) this).registerControlEntry(ControlRegistry.DOOR.get());

        for (SubsystemEntry entry : SubsystemRegistry.SUBSYSTEM_REGISTRY.get().getValues()) {
            this.subsystems.add(entry.create(((ConsoleTile) (Object) this)));
        }

        for (UpgradeEntry entry : UpgradeRegistry.UPGRADE_REGISTRY.get().getValues()) {
            this.upgrades.add(entry.create(((ConsoleTile) (Object) this)));
        }

        ((ConsoleTile) (Object) this).registerControlOverrides();
    }

    @SuppressWarnings("unchecked")
    public <T extends Subsystem> LazyOptional<T> getSubsystem(Class<T> clazz) {
        for(Subsystem sys : this.getSubSystems()) {
            if(sys.getClass() == clazz || sys.getClass().isInstance(clazz))
                return LazyOptional.of(() -> (T)sys);
        }
        return LazyOptional.empty();
    }

    public void setupInteriorChangeProperties(ConsoleRoom roomToSpawn, boolean cancelProcess, boolean isInstantChange) {
        int processingTicks = TConfig.SERVER.interiorChangeProcessTime.get() * 20;
        //If we want "instant" change, minimum ticks should be no lower than 20 ticks (1 second).
        //If the time is lower than this, the console will not be able to serialise things that quickly, and the deadlock kicking mechanic will loop forever.
        this.getInteriorManager().setInteriorProcessingTime(cancelProcess ?  InteriorManager.resetInteriorChangeProcessTime :  (isInstantChange ? 60 : processingTicks)); //Set how much time to elapse before the console can fully finish its interior change
        this.setNextConsoleRoomToChange(cancelProcess ? this.consoleRoom : roomToSpawn); //Set the next room to be the one inputted
        this.setStartChangingInterior(cancelProcess ? false : true);
        this.onPowerDown(!cancelProcess);
        //Handle edge case of fuel where player somehow gets inside and cancels the interior change process
        //We want to stop the Tardis from continuing to use fuel if the change process is already underway
        if (cancelProcess) {
            //Reset the interior change fuel usage
            ArtronUse use = this.getOrCreateArtronUse(ArtronUse.ArtronType.INTERIOR_CHANGE);
            use.setArtronUsePerTick(0);
            use.setTicksToDrain(0);
            this.getDoor().ifPresent(door -> {
                door.setAdditionalLockLevel(0);
                door.setLocked(false);
            });
            this.getOrFindExteriorTile().ifPresent(ext -> {
                ext.setAdditionalLockLevel(0);
                ext.setLocked(false);
                ext.setInteriorRegenerating(false);
            });
        }
        else {
            //Setup the Artron Use before the player exits the doors, but don't let it start yet by not setting the ticks
            int fuelUsage = TConfig.SERVER.interiorChangeArtronUse.get();
            ArtronUse artronUse = this.getOrCreateArtronUse(ArtronUse.ArtronType.INTERIOR_CHANGE);
            artronUse.setArtronUsePerTick((float)((float)fuelUsage/(float)processingTicks));
        }
        AxisAlignedBB radius = new AxisAlignedBB(this.getPos()).grow(30);
        for (PlayerEntity player : this.getWorld().getEntitiesWithinAABB(PlayerEntity.class, radius)){
            if (player != null) {
                if (cancelProcess) {
                    player.sendStatusMessage(TardisConstants.Translations.CANCEL_INTERIOR_CHANGE, false);
                }
                else {
                    player.sendStatusMessage(new TranslationTextComponent(TardisConstants.Translations.START_INTERIOR_CHANGE, this.nextRoomToChange.getRegistryName().toString()), false);
                    player.playSound(TSounds.TARDIS_SHUT_DOWN.get(), SoundCategory.PLAYERS, 0.6F, 1F);
                }
            }
        }
    }

    public void tick() {

        //Cycle through tickable objects
        for(ITickable tick : this.tickers) {
            tick.tick(((ConsoleTile) (Object) this));
        }

        ((ConsoleTile) (Object) this).prevFlightTicks = this.flightTicks;
        if(((ConsoleTile) (Object) this).isInFlight()) {
            fly();
        }
        this.getOrFindExteriorTile().ifPresent(ex -> {
            World world = ex.getWorld();
            if (WorldHelper.areDimensionTypesSame(world, TDimensions.DimensionTypes.TARDIS_TYPE)) {
                TardisHelper.getConsoleInWorld(world).ifPresent(tile -> {
                    if(tile.shouldStartChangingInterior()){
                        tile.setStartChangingInterior(false);
                    }
                });
            }
        });

        if(((ConsoleTile) (Object) this).getExteriorManager().getExteriorAnimation() == MExteriorAnimationRegistry.FULLNEW_WHO.getId() && ((ConsoleTile) (Object) this).getSoundScheme() != MSoundSchemeRegistry.FULL.get()){
            ((ConsoleTile) (Object) this).setSoundScheme(MSoundSchemeRegistry.FULL.get());
        }
        if(((ConsoleTile) (Object) this).getSoundScheme() == MSoundSchemeRegistry.FULL.get() && ((ConsoleTile) (Object) this).getExteriorManager().getExteriorAnimation() != MExteriorAnimationRegistry.FULLNEW_WHO.getId()){
            ((ConsoleTile) (Object) this).getExteriorManager().setExteriorAnimation(MExteriorAnimationRegistry.FULLNEW_WHO.getId());
        }

        this.playAmbientNoises();

        this.handleRefueling();

        if(world.getGameTime() % 200 == 0) {
            if(world.isRemote || controls.isEmpty())
                ((ConsoleTile) (Object) this).getOrCreateControls();
        }

        if(timeUntilControlSpawn > 0) {
            --timeUntilControlSpawn;
            if(timeUntilControlSpawn == 0) {
                ((ConsoleTile) (Object) this).getOrCreateControls();
                if(this.onLoadAction != null)
                    this.onLoadAction.run();
            }
        }

        //Loop for things that need to be polled semi-constantly
        if(!world.isRemote && world.getGameTime() % 40 == 0) {
            this.updateArtronValues();

            //Loop for sparking
            SparkingLevel spark = SparkingLevel.NONE;
            for(Subsystem s : this.subsystems) {
                if(s.getSparkState().ordinal() > spark.ordinal())
                    spark = s.getSparkState();
            }

            if(this.sparkLevel != spark) {
                this.sparkLevel = spark;
                ((ConsoleTile) (Object) this).updateClient();
            }

            //Force Field Drain
            ((ConsoleTile) (Object) this).getSubsystem(ShieldGeneratorSubsystem.class).ifPresent(shield -> {
                if(shield.canBeUsed() && shield.isActivated() && shield.isForceFieldActivated() && this.artron > 1.0F) {
                    ArtronUse use = ((ConsoleTile) (Object) this).getOrCreateArtronUse(ArtronUse.ArtronType.FORCEFIELD);
                    use.setArtronUsePerTick(0.05F);
                    use.setTicksToDrain(42);
                    shield.damage((ServerPlayerEntity)((ConsoleTile) (Object) this).getPilot(), 1);
                }
                else shield.setForceFieldActivated(false);
            });

            //Anti-gravs
            if(((ConsoleTile) (Object) this).getAntiGrav()) {
                ArtronUse use = ((ConsoleTile) (Object) this).getOrCreateArtronUse(ArtronUse.ArtronType.ANTIGRAVS);
                use.setArtronUsePerTick(0.03F);
                use.setTicksToDrain(42);
            }
        }

        //Artron Drains
        if(!world.isRemote) {
            world.getServer().enqueue(new TickDelayedTask(0, () -> {
                float oldArtron = this.artron;
                for(ArtronUse use : this.artronUses.values()) {
                    use.tick(((ConsoleTile) (Object) this));
                }
                if(oldArtron != this.artron && world.getGameTime() + 4 % 20 == 0) {
                    if(this.artron <= 0.0 && !this.hasPoweredDown)
                        ((ConsoleTile) (Object) this).onPowerDown(true);
                    else if(artron > 0)
                        this.hasPoweredDown = false;
                }
            }));
        }

        if(world.isRemote &&  world.getGameTime() % 5 == 0) {
            if(this.sparkLevel != SparkingLevel.NONE) {

                if(this.sparkLevel != SparkingLevel.NONE) {
                    for(int i = 0; i < 30; ++i) {

                        float angle = (float)Math.toRadians(rand.nextFloat() * 360.0F);

                        world.addParticle(ParticleTypes.SMOKE, pos.getX() + 0.5 + Math.sin(angle), pos.getY() + 1, pos.getZ() + 0.5 + Math.cos(angle), 0, 0, 0);
                    }
                }
                if(this.sparkLevel == SparkingLevel.SPARKS) {
                    world.addParticle(ParticleTypes.LAVA, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, 0, 1, 0);
                }
            }
        }

        if(!world.isRemote && !((ConsoleTile) (Object) this).isInFlight()) {
            ((ConsoleTile) (Object) this).getSubsystem(AntennaSubsystem.class).ifPresent(sys -> {
                if(sys.canBeUsed()) {
                    if(world.getGameTime() % 2880 == 0) {
                        this.findNewMission();
                    }
                }
            });
        }

        if(!world.isRemote && didVoidCrash){
                handleDelay();
                didVoidCrash = false;
        }

        //Nav Com
        if(!world.isRemote && world.getGameTime() % 20 == 0) {
            ((ConsoleTile) (Object) this).getSubsystem(NavComSubsystem.class).ifPresent(sys -> {
                boolean oldVal = this.hasNavCom;
                this.hasNavCom = sys.canBeUsed();
                if(oldVal != this.hasNavCom)
                    Network.sendToAllInWorld(new ConsoleUpdateMessage(DataTypes.NAV_COM, new NavComData(this.hasNavCom)), (ServerWorld)world);
            });
        }
        //This is still needed because we want to unforce the 35 other chunks we loaded when we were trying to find the interior door during right clicking the exterior block
        this.handleAutoLoadOrUnloadChunks();

    }



    /*public boolean canFly() {

        if(this.isBeingTowed)
            return true;

        for(Subsystem s : this.subsystems) {
            if((s.getItem().getItem() == TItems.DEMAT_CIRCUIT.get() || s.getItem().getItem() == ModItems.DEMAT_CIRCUITMK2.get()) && (s.getItem().getItem() == TItems.NAV_COM.get() || s.getItem().getItem() == ModItems.NAV_COMMK2.get()) && (s.getItem().getItem() == TItems.FLUID_LINK.get() || s.getItem().getItem() == ModItems.FLUID_LINKMK2.get())) {
                return s.canBeUsed() && s.isActivated();
            }
        }
        if (this.shouldStartChangingInterior && this.interiorManager.isInteriorStillRegenerating()) {
            return false;
        }
        return this.artron > 0;
    }*/

    public void scaleDestination() {

        //Demat if landing
        if(((ConsoleTile) (Object) this).isInFlight() && this.landTime > 0) {
            ExteriorTile ext = this.exterior.getExteriorTile(((ConsoleTile) (Object) this));
            if(ext != null)
                ext.demat(((ConsoleTile) (Object) this).getSoundScheme().getTakeoffTime());
        }

        double per = ((ConsoleTile) (Object) this).getPercentageJourney();
        if(per < 0)
            this.destination = ((ConsoleTile) (Object) this).getCurrentLocation();

        //Reset dimension if less than half way there
        if(per < 0.5) {
            this.destinationDimension = this.dimension;
        }
        if(per > 0.5 && per < 0.9 && destinationDimension == MDimensions.THE_VERGE && !this.isCrashing() && !didVoidCrash){
            VoidCrash();
        }

        BlockPos diff = this.destination.subtract(((ConsoleTile) (Object) this).getCurrentLocation());
        this.destination = ((ConsoleTile) (Object) this).getCurrentLocation().add(new BlockPos(diff.getX() * per, diff.getY() * per, diff.getZ() * per)).toImmutable();
    }

    public void read(BlockState state, CompoundNBT compound) {
        super.read(state, compound);
        //Things registered to save
        for (Map.Entry<ResourceLocation, INBTSerializable<CompoundNBT>> saved : this.dataHandlers.entrySet()) {
            saved.getValue().deserializeNBT(compound.getCompound(saved.getKey().toString()));
        }

        //Subsystems
        ListNBT subsystemList = compound.getList("subsystems", Constants.NBT.TAG_COMPOUND);
        for (INBT base : subsystemList) {
            CompoundNBT nbt = (CompoundNBT) base;
            ResourceLocation key = new ResourceLocation(nbt.getString("name"));
            ((ConsoleTile) (Object) this).getSubsystem(key).ifPresent(sys -> sys.deserializeNBT(nbt));
        }

        if (compound.contains("unlock_manager"))
            this.unlockManager.deserializeNBT(compound.getCompound("unlock_manager"));

        this.location = BlockPos.fromLong(compound.getLong("location"));
        this.destination = BlockPos.fromLong(compound.getLong("destination"));
        this.dimension = WorldHelper.getWorldKeyFromRL(new ResourceLocation(compound.getString("dimension")));
        this.destinationDimension = WorldHelper.getWorldKeyFromRL(new ResourceLocation(compound.getString("dest_dim")));
        this.flightTicks = compound.getInt("flight_ticks");
        this.reachDestinationTick = compound.getInt("max_flight_ticks");
        this.exterior = ExteriorRegistry.getExterior(new ResourceLocation(compound.getString("exterior")));
        this.artron = compound.getFloat("artron");
        if (compound.contains("console_room")) {
            ConsoleRoom room = ConsoleRoom.getRegistry().get(new ResourceLocation(compound.getString("console_room")));
            if (room != null)
                this.consoleRoom = room;
        }
        if (compound.contains("next_console_room")) {
            ConsoleRoom nextRoom = ConsoleRoom.getRegistry().get(new ResourceLocation(compound.getString("next_console_room")));
            if (nextRoom != null)
                this.nextRoomToChange = nextRoom;
        }

        this.customName = compound.getString("custom_name");
        this.returnLocation = SpaceTimeCoord.deserialize(compound.getCompound("return_pos"));
        this.facing = Direction.values()[compound.getInt("facing")];
        this.sonic = ItemStack.read(compound.getCompound("sonic_item"));
        ListNBT distressList = compound.getList("distress_list_initial", Constants.NBT.TAG_COMPOUND);
        this.distressSignal.clear();
        for (INBT dis : distressList) {
            this.distressSignal.add(DistressSignal.deserializeNBT((CompoundNBT) dis));
        }

        this.max_artron = compound.getFloat("max_artron");
        this.rechargeMod = compound.getFloat("recharge_modifier");
        this.variant = compound.getInt("texture_variant");
        this.antiGravs = compound.getBoolean("anti_gravs");
        this.hasForcedChunksToRemove = compound.getBoolean("has_forced_chunks");
        this.hasNavCom = compound.getBoolean("nav_com");
        this.dimData = compound.getBoolean("dimdata");
        this.shouldStartChangingInterior = compound.getBoolean("start_changing_interior");

        ListNBT artronUsesList = compound.getList("artron_uses", Constants.NBT.TAG_COMPOUND);
        for (INBT base : artronUsesList) {
            CompoundNBT nbt = (CompoundNBT) base;
            ArtronUse use = ArtronUse.deserialiseNBT(nbt);
            ArtronUse.IArtronType type = use.getType();
            if (type != null) {
                this.artronUses.put(type, use);
            }
        }

        if (compound.contains("tardis_entity_id"))
            this.tardisEntityID = compound.getUniqueId("tardis_entity_id");
        this.sparkLevel = SparkingLevel.getFromIndex(compound.getInt("spark_level"));
        this.landingCode = compound.getString("landing_code");
        this.landTime = compound.getInt("landing_time");
        this.takeoffLocation = BlockPos.fromLong(compound.getLong("takeoff_location"));
        if (compound.contains("sound_scheme"))
            this.scheme = SoundSchemeRegistry.SOUND_SCHEME_REGISTRY.get().getValue(new ResourceLocation(compound.getString("sound_scheme")));

        this.onLoadAction = () -> {
            for (Map.Entry<ResourceLocation, INBTSerializable<CompoundNBT>> saved : this.dataHandlers.entrySet()) {
                saved.getValue().deserializeNBT(compound.getCompound(saved.getKey().toString()));
            }
        };
    }


    public CompoundNBT write(CompoundNBT compound) {
        for (Map.Entry<ResourceLocation, INBTSerializable<CompoundNBT>> entry : this.dataHandlers.entrySet()) {
            compound.put(entry.getKey().toString(), entry.getValue().serializeNBT());
        }

        //Subsystems
        ListNBT subsystemList = new ListNBT();
        for (Subsystem s : this.subsystems) {
            CompoundNBT nbt = s.serializeNBT();
            nbt.putString("name", s.getEntry().getRegistryName().toString());
            subsystemList.add(nbt);
        }
        compound.put("subsystems", subsystemList);

        compound.put("unlock_manager", this.unlockManager.serializeNBT());

        compound.putLong("location", this.location.toLong());
        compound.putLong("destination", this.destination.toLong());
        compound.putInt("flight_ticks", this.flightTicks);
        compound.putInt("max_flight_ticks", this.reachDestinationTick);
        compound.putString("exterior", this.exterior.getRegistryName().toString());
        compound.putString("dimension", this.dimension.getLocation().toString());
        compound.putString("dest_dim", this.destinationDimension.getLocation().toString());
        compound.putFloat("artron", this.artron);
        compound.putString("console_room", this.consoleRoom.getRegistryName().toString());
        compound.putString("next_console_room", this.nextRoomToChange.getRegistryName().toString());
        compound.putString("custom_name", this.customName);
        compound.put("return_pos", this.returnLocation.serialize());
        compound.putInt("facing", this.facing.ordinal());
        compound.putLong("takeoff_location", this.takeoffLocation.toLong());

        compound.put("sonic_item", this.sonic.serializeNBT());

        //SOSes
        ListNBT distress = new ListNBT();
        for (DistressSignal dis : this.distressSignal)
            distress.add(dis.serializeNBT());
        compound.put("distress_list_initial", distress);

        compound.putFloat("max_artron", this.max_artron);
        compound.putFloat("recharge_modifier", this.rechargeMod);
        compound.putInt("texture_variant", this.variant);
        compound.putBoolean("anti_gravs", this.antiGravs);
        if (this.tardisEntityID != null)
            compound.putUniqueId("tardis_entity_id", this.tardisEntityID);
        compound.putInt("spark_level", this.sparkLevel.ordinal());
        compound.putString("landing_code", this.landingCode);
        compound.putInt("landing_time", this.landTime);
        compound.putString("sound_scheme", this.scheme.getRegistryName().toString());
        compound.putBoolean("nav_com", this.hasNavCom);
        compound.putBoolean("dimdata", this.dimData);
        compound.putBoolean("has_forced_chunks", this.hasForcedChunksToRemove);
        compound.putBoolean("start_changing_interior", this.shouldStartChangingInterior);
        ListNBT artronUseList = new ListNBT();
        for (Map.Entry<ArtronUse.IArtronType, ArtronUse> entry : this.artronUses.entrySet()) {
            CompoundNBT nbt = entry.getValue().serialiseNBT();
            artronUseList.add(nbt);
        }
        compound.put("artron_uses", artronUseList);
        return super.write(compound);
    }

    /**
     * Fly loop, called every tick
     */
    public void fly() {
        if (((ConsoleTile) (Object) this).isInFlight()) {

            ((ConsoleTile) (Object) this).prevFlightTicks = this.flightTicks;
            ++this.flightTicks;

            if (((ConsoleTile) (Object) this).isLanding())
                this.location = ((ConsoleTile) (Object) this).getPositionInFlight().getPos();

            //If crashing, play crash effects
            if (((ConsoleTile) (Object) this).isCrashing())
                ((ConsoleTile) (Object) this).playCrashEffects();

            //Land if reached destination and stabilized
            if (!world.isRemote && this.flightTicks >= this.reachDestinationTick && landTime <= 0) {
                if (this.isBeingTowed) {
                    ((ConsoleTile) (Object) this).initLand();
                }
                ((ConsoleTile) (Object) this).getSubsystem(StabilizerSubsystem.class).ifPresent(sys -> {
                    if (sys.isControlActivated()) {
                        //Only call land if we're not being towed.
                        //Prevents land being called twice, which could cause the Tardis' position to get recalculated
                        if (!this.isBeingTowed) {
                            ((ConsoleTile) (Object) this).initLand();
                        }
                    }
                });
            }

            if (!world.isRemote && ((ConsoleTile) (Object) this).getDestinationDimension() == MDimensions.THE_VERGE && ((ConsoleTile) (Object) this).getPercentageJourney() >= 0.9 && !((ConsoleTile) (Object) this).isLanding()) {
                if (((ConsoleTile) (Object) this).getUpgrade(FrameStabUpgrade.class).isPresent()) {
                    ((ConsoleTile) (Object) this).getUpgrade(FrameStabUpgrade.class).ifPresent(up -> {
                        if (up.isActivated() && up.isUsable()) {
                            up.damage(10, Upgrade.DamageType.ITEM, null);
                            ((ConsoleTile) (Object) this).setDestinationReachedTick(0);
                        } else VoidCrash();
                    });
                } else VoidCrash();
            }

            if (!world.isRemote && this.flightTicks > this.landTime && this.landTime > 0) {
                this.flightTicks = this.reachDestinationTick = this.landTime = 0;
                ((ConsoleTile) (Object) this).updateClient();
            }

            //Crash if it can't fly
            if (!world.isRemote && !((ConsoleTile) (Object) this).canFly()) {
                ((ConsoleTile) (Object) this).crash(CrashTypes.DEFAULT);
                return;
            }

            //Artron usage
            if (!world.isRemote) {
                ArtronUse use = ((ConsoleTile) (Object) this).getOrCreateArtronUse(ArtronUse.ArtronType.FLIGHT);
                use.setArtronUsePerTick(((ConsoleTile) (Object) this).calcFuelUse());
                use.setTicksToDrain(1);

                if (this.flightTicks % 20 == 0) {
                    for (Subsystem sub : ((ConsoleTile) (Object) this).getSubSystems()) {
                        sub.onFlightSecond();
                    }
                    for (Upgrade up : ((ConsoleTile) (Object) this).getUpgrades()) {
                        up.onFlightSecond();
                    }
                }

                if (world.getGameTime() % 20 == 0)
                    Network.sendToAllAround(new ConsoleUpdateMessage(DataTypes.FUEL, new Fuel(this.artron, this.max_artron)), world.getDimensionKey(), this.getPos(), 20);

            }

            if (!world.isRemote) {

                //If this has an event and it's time, complete it
                if (!this.isBeingTowed && currentEvent != null && this.currentEvent.getMissedTime() < this.flightTicks) {
                    currentEvent.onComplete(((ConsoleTile) (Object) this));

                    //Search for collisions
                    this.currentEvent = null;

                    //If Not landing
                    if (this.landTime <= 0) {
                        ObjectWrapper<Boolean> collided = new ObjectWrapper<>(false);
                        Iterator<ServerWorld> it = world.getServer().getWorlds().iterator();
                        while (it.hasNext()) {
                            ServerWorld world = it.next();

                            //Stop if found one to collide with
                            if (collided.getValue())
                                break;

                            TardisHelper.getConsoleInWorld(world).ifPresent(tile -> {
                                //if unstabilized and not ourselves
                                ((ConsoleTile) (Object) this).getSubsystem(StabilizerSubsystem.class).ifPresent(sys -> {
                                    if (tile != ((ConsoleTile) (Object) this) && tile.isInFlight() && !sys.isControlActivated()) {
                                        //If not landing and not already colliding
                                        if (tile.getLandTime() == 0 && !(tile.getFlightEvent() instanceof TardisCollideInstigate) && !(tile.getFlightEvent() instanceof TardisCollideRecieve)) {
                                            if (tile.getPositionInFlight().getPos().withinDistance(((ConsoleTile) (Object) this).getPositionInFlight().getPos(), TConfig.SERVER.collisionRange.get())) {
                                                ((ConsoleTile) (Object) this).setFlightEvent(((TardisCollideInstigate) FlightEventRegistry.COLLIDE_INSTIGATE.get().create(((ConsoleTile) (Object) this))).setOtherTARDIS(tile));
                                                collided.setValue(true);
                                            }
                                        }
                                    }
                                });
                            });
                        }
                    }

                    if (((ConsoleTile) (Object) this).canGiveNewEvent() && this.currentEvent == null)
                        ((ConsoleTile) (Object) this).setFlightEvent(FlightEventRegistry.getRandomEvent(rand).create(((ConsoleTile) (Object) this)));

                } else if (this.currentEvent == null && ((ConsoleTile) (Object) this).canGiveNewEvent())
                    ((ConsoleTile) (Object) this).setFlightEvent(FlightEventRegistry.getRandomEvent(rand).create(((ConsoleTile) (Object) this)));

            }

            //Shake
            if (!world.isRemote && world.getGameTime() % 3 == 0) {
                if (this.currentEvent != null && !this.currentEvent.getControls().isEmpty())
                    for (PlayerEntity player : world.getPlayers()) {
                        player.getCapability(Capabilities.PLAYER_DATA).ifPresent(cap -> {
                            cap.setShaking(5);
                            cap.update();
                        });
                    }
            }
        }

        ((ConsoleTile) (Object) this).playFlightLoop();

        //Fuck TARDIS abusers
        if (!world.isRemote && this.sparkLevel != SparkingLevel.NONE && world.getGameTime() % 60 == 0) {
            if (((ConsoleTile) (Object) this).getEmotionHandler().getMood() > EmotionHandler.EnumHappyState.DISCONTENT.getTreshold())
                ((ConsoleTile) (Object) this).getEmotionHandler().addMood(-1);
        }


    }

    /**
     * Calculate flight speed for the Tardis
     * @return Speed in blocks a tick B/T
     */
    public float calcSpeed() {
        ObjectWrapper<Float> throttle = new ObjectWrapper<>(0.0F);
        ObjectWrapper<Float> speedmod = new ObjectWrapper<>(1.0F);
        ((ConsoleTile) (Object) this).getWorld().getCapability(Capabilities.TARDIS_DATA).ifPresent(tard -> {
            ItemStackHandler handler = tard.getEngineInventoryForSide(Direction.NORTH).getHandler();
            for(int i = 0; i<handler.getSlots(); i++){
                if(handler.getStackInSlot(i).getItem().getRegistryName().toString().contains("overcharged")){
                    speedmod.setValue(speedmod.getValue()+0.125F);
                }
                if(EnchantmentHelper.getEnchantmentLevel(TAEnchants.BLESSING_OF_FLOW.get(), handler.getStackInSlot(i)) > 0){
                    speedmod.setValue(speedmod.getValue()+0.25F);
                };
                if(EnchantmentHelper.getEnchantmentLevel(TAEnchants.CURSE_OF_WINDS.get(), handler.getStackInSlot(i)) > 0){
                    speedmod.setValue(speedmod.getValue()-0.25F);
                };
            }
        });
        ((ConsoleTile) (Object) this).getControl(ThrottleControl.class).ifPresent(throt -> throttle.setValue(throt.getAmount()));
        return ConsoleTile.TARDIS_MAX_SPEED * MathHelper.clamp(throttle.getValue(), 0.1F, 1.0F)*MathHelper.clamp(speedmod.getValue(), 0f, 4f);
    }

    public void updateArtronValues() {

        this.world.getCapability(Capabilities.TARDIS_DATA).ifPresent(cap -> {

            float newMax = 0;
            float rate = 0;

            int numCap = 0;

            PanelInventory inv = cap.getEngineInventoryForSide(Direction.WEST);
            for(int i = 0; i < inv.getSlots(); ++i) {
                ItemStack stack = inv.getStackInSlot(i);
                if(stack.getItem() instanceof ArtronCapacitorItem) {

                    int enchantLevelR = EnchantmentHelper.getEnchantmentLevel(TAEnchants.SUBSPACE_LINK.get(), stack);
                    int enchantLevelS = EnchantmentHelper.getEnchantmentLevel(TAEnchants.SUBSPACE_POCKET.get(), stack);

                    int r = 0;
                    int s = 0;

                    if(enchantLevelR > 0){
                        r = enchantLevelR;
                    }
                    if(enchantLevelS > 0){
                        s = enchantLevelS*128;
                    }

                    ArtronCapacitorItem item = (ArtronCapacitorItem)stack.getItem();
                    newMax += item.getMaxStorage()+s;
                    rate += item.getRechargeModifier()+r;
                    ++numCap;
                }
            }

            this.max_artron = newMax;

            this.rechargeMod = (rate / (float)numCap);

            if(artron > this.max_artron)
                this.artron = this.max_artron;

        });
    }

    @Override
    public boolean isDimOver() {
        return this.dimData;
    }

    @Override
    public void setDimOver(boolean DimOver) {
        this.dimData = DimOver;
        this.markDirty();
    }

    public void VoidCrash() {

        ((ConsoleTile) (Object) this).crash(new CrashType(100, 0, true));
        ((ConsoleTile) (Object) this).getSubSystems().forEach(sub -> {
            sub.damage(null, 38);
        });

        ((ConsoleTile) (Object) this).getSubsystem(FlightSubsystem.class).ifPresent(fly -> {
            fly.damage(null, 650);
        });

        List<String> list = new ArrayList<>();
        list.add(new TranslationTextComponent("warning.spatial_rupture.line1").getString());
        list.add(new TranslationTextComponent("warning.spatial_rupture.line2").getString());
        ((ConsoleTile) (Object) this).getInteriorManager().setMonitorOverrides(new MonitorOverride(((ConsoleTile) (Object) this), 200, list));

        didVoidCrash = true;
    }

    public void handleDelay() {
        world.getServer().enqueue(new TickDelayedTask(400, () -> {
            ((ConsoleTile) (Object) this).getInteriorManager().setAlarmOn(false);
            ((ConsoleTile) (Object) this).getInteriorManager().setLight(0);
            world.playSound(null, this.getPos(), TSounds.POWER_DOWN.get(), SoundCategory.BLOCKS, 20F, 1F);
            ((ConsoleTile) (Object) this).updateClient();
        }));
        //Runnable myTask = () -> {
        //    ((ConsoleTile) (Object) this).getInteriorManager().setAlarmOn(false);
        //    ((ConsoleTile) (Object) this).getInteriorManager().setLight(0);
        //    world.playSound(null, this.getPos(), TSounds.POWER_DOWN.get(), SoundCategory.BLOCKS, 20F, 1F);
        //    ((ConsoleTile) (Object) this).updateClient();
        //};
        //long delayTicks = 400; // 20 seconds delay, assuming 20 ticks per second
        //scheduleTaskWithDelay(myTask, delayTicks);
    }

    @Shadow
    protected void handleRefueling(){}

    @Shadow
    private void playAmbientNoises() {
    }

    @Shadow
    private void handleAutoLoadOrUnloadChunks() {
    }

    @Shadow
    private void findNewMission(){
    }


}

