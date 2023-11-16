package net.tadditions.mod.events;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.serialization.Codec;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.FlatChunkGenerator;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.blocks.ModBlocks;
import net.tadditions.mod.cap.*;
import net.tadditions.mod.items.ModItems;
import net.tadditions.mod.world.MDimensions;
import net.tadditions.mod.world.biomes.MBiomes;
import net.tadditions.mod.world.structures.MStructures;
import net.tardis.mod.Tardis;
import net.tardis.mod.cap.*;
import net.tardis.mod.config.TConfig;
import net.tardis.mod.constants.TardisConstants;
import net.tardis.mod.events.MissingMappingsLookup;
import net.tardis.mod.misc.IDontBreak;
import net.tardis.mod.world.biomes.TBiomes;
import net.tardis.mod.world.dimensions.TDimensions;
import net.tardis.mod.world.feature.TFeatures;
import net.tardis.mod.world.structures.TStructures;

import java.util.HashMap;
import java.util.Map;

import static net.tardis.mod.events.CommonEvents.CHUNK_CAP;
import static net.tardis.mod.events.CommonEvents.SPACE_DIM_CAP;

@Mod.EventBusSubscriber(modid = QolMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CommonEvents {


    public static final ResourceLocation ONEUSEREMOTE_CAP = new ResourceLocation(QolMod.MOD_ID, "oneuseremote");
    public static final ResourceLocation TAGREAOPENER_CAP = new ResourceLocation(QolMod.MOD_ID, "tagreaopener");
    public static final ResourceLocation QUANT_CAP = new ResourceLocation(QolMod.MOD_ID, "quantum");


    private static HashMap<ResourceLocation, ResourceLocation> remappedEntries = new HashMap<ResourceLocation, ResourceLocation>();
    @SubscribeEvent
    public static void attachWorldCaps(AttachCapabilitiesEvent<World> event) {

    }
    @SubscribeEvent
    public static void attachItemStackCap(AttachCapabilitiesEvent<ItemStack> event) {
        if (event.getObject().getItem() == ModItems.ONEUSEREMOTE.get())
            event.addCapability(ONEUSEREMOTE_CAP, new IOneRemote.Provider(new OneUseRemoteCapability(event.getObject())));
        if (event.getObject().getItem() == ModItems.BOOS_UPGRADE.get())
            event.addCapability(TAGREAOPENER_CAP, new IOpener.Provider(new TagreaOpenerCap(event.getObject())));
        if (event.getObject().getItem() == ModItems.QUANTUM_EXOTIC_MATTER.get())
            event.addCapability(QUANT_CAP, new IQuant.Provider(new QuantCapability(event.getObject())));
    }

    @SubscribeEvent
    public static void stopHungerAtVerge(TickEvent.PlayerTickEvent event){
        if(event.player.getEntityWorld().getGameTime() % 20 == 0) {
            if (event.player.getEntityWorld().getDimensionKey() == MDimensions.THE_VERGE) {
                if (event.player.getFoodStats().getFoodLevel() < 10)
                    event.player.getFoodStats().setFoodLevel(10);
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
        if (event.getState().getBlock() instanceof IDontBreak) {
            event.setCanceled(true);
        }

        if (event.getWorld() instanceof World) {
            World world = (World) event.getWorld();
            if (!world.isRemote()) {
                if(world.getBlockState(event.getPos()) == ModBlocks.zero_point_field_normal.get().getDefaultState()) {
                    world.setBlockState(event.getPos(), ModBlocks.zero_point_field_broken.get().getDefaultState());
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
