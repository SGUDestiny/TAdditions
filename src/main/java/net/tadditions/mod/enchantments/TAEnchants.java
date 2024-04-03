package net.tadditions.mod.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.VanishingCurseEnchantment;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.items.SubsysItem;
import net.tardis.mod.items.ArtronCapacitorItem;
import net.tardis.mod.items.ArtronItemStackBatteryItem;
import net.tardis.mod.items.TardisPartItem;

public class TAEnchants {

    public static final DeferredRegister<Enchantment> ENCHANT = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, QolMod.MOD_ID);

    public static final RegistryObject<Enchantment> SUBSPACE_POCKET = ENCHANT.register("subspace_pocket",() -> new SubspaceCapEnchant(Enchantment.Rarity.RARE, TAEnchants.ARTRON, EquipmentSlotType.values()));
    public static final RegistryObject<Enchantment> SUBSPACE_LINK = ENCHANT.register("subspace_link",() -> new SubspaceLinkEnchant(Enchantment.Rarity.RARE, TAEnchants.ARTRON, EquipmentSlotType.values()));
    public static final RegistryObject<Enchantment> BLESSING_OF_FLOW = ENCHANT.register("blessing_of_temporal_flow",() -> new BlessingOfTemporalFlow(Enchantment.Rarity.RARE, TAEnchants.SUBSYSTEM));
    public static final RegistryObject<Enchantment> CURSE_OF_WINDS = ENCHANT.register("curse_of_temporal_winds",() -> new CurseOfTemporalWinds(Enchantment.Rarity.RARE, TAEnchants.SUBSYSTEM));


    public static void register(IEventBus eventBus) {
        ENCHANT.register(eventBus);
    }

    public static EnchantmentType ARTRON = EnchantmentType.create("artron", type -> type instanceof ArtronCapacitorItem || type instanceof ArtronItemStackBatteryItem);
    public static EnchantmentType SUBSYSTEM = EnchantmentType.create("subsystem", type -> type instanceof TardisPartItem || type instanceof SubsysItem);


}
