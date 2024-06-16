package net.tadditions.mod.world;


import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.tadditions.mod.QolMod;
import net.tardis.mod.Tardis;


@Mod.EventBusSubscriber(modid = QolMod.MOD_ID , bus = Bus.MOD)
public class MDimensions {
	public static RegistryKey<World> MARS = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
			new ResourceLocation(QolMod.MOD_ID, "mars"));

	public static RegistryKey<World> THE_VERGE = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
			new ResourceLocation(QolMod.MOD_ID, "the_verge_of_reality"));

	public static final ResourceLocation MARS_SKY_PROPERTY_KEY = new ResourceLocation(QolMod.MOD_ID, "mars_sky_property");
	public static final ResourceLocation THE_VERG_SKY_PROPERTY_KEY = new ResourceLocation(QolMod.MOD_ID, "the_verge_of_reality_sky_property");

}

