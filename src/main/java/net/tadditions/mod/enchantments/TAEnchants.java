package net.tadditions.mod.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.VanishingCurseEnchantment;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.tadditions.mod.QolMod;

public class TAEnchants {

    public static final DeferredRegister<Enchantment> ENCHANT = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, QolMod.MOD_ID);

    public static final RegistryObject<Enchantment> SUBSPACE_POCKET = ENCHANT.register("subspace_pocket",() -> new SubspaceCapEnchant(Enchantment.Rarity.RARE, EquipmentSlotType.values()));
    public static final RegistryObject<Enchantment> SUBSPACE_LINK = ENCHANT.register("subspace_link",() -> new SubspaceLinkEnchant(Enchantment.Rarity.RARE, EquipmentSlotType.values()));


    public static void register(IEventBus eventBus) {
        ENCHANT.register(eventBus);
    }



}
