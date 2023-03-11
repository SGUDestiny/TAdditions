package net.tadditions.mod.events;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.cap.*;
import net.tadditions.mod.items.ModItems;
import net.tadditions.mod.world.MDimensions;
import net.tardis.mod.Tardis;
import net.tardis.mod.cap.*;
import net.tardis.mod.config.TConfig;
import net.tardis.mod.constants.TardisConstants;
import net.tardis.mod.events.MissingMappingsLookup;

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
    public static void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
        PlayerEntity player = event.getPlayer();
        if (player.world.isRemote()) {

            }
        }

    public static void getAllMappingEntries(){
        JsonObject obj = MissingMappingsLookup.getMissingMappings();
        for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
            remappedEntries.put(new ResourceLocation(QolMod.MOD_ID, entry.getKey()), new ResourceLocation(QolMod.MOD_ID, entry.getValue().getAsString()));
        }
    }

}
