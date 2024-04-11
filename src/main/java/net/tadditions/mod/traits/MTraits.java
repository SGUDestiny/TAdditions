package net.tadditions.mod.traits;

import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;
import net.tadditions.mod.QolMod;
import net.tardis.mod.Tardis;
import net.tardis.mod.misc.rng.RarityPool;
import net.tardis.mod.registries.TraitRegistry;
import net.tardis.mod.traits.*;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MTraits extends TraitRegistry {
    public static final RarityPool<TardisTraitType> RARITIES = new RarityPool<>();

    public static final DeferredRegister<TardisTraitType> TRAITS = DeferredRegister.create(TardisTraitType.class, QolMod.MOD_ID);

    public static final RegistryObject<TardisTraitType> PEL = TRAITS.register("petlover", () -> setupTrait(PetLoverTrait::new, test -> test.getTraitClass() == PetHaterTrait.class));
    public static final RegistryObject<TardisTraitType> PEH = TRAITS.register("zoophobic", () -> setupTrait(PetHaterTrait::new, test -> test.getTraitClass() == PetLoverTrait.class));
    public static final RegistryObject<TardisTraitType> HYDROPHOBIC = TRAITS.register("hydrophobic", () -> setupTrait(HydrophobicTrait::new, test -> test.getTraitClass() == WetTrait.class));
    public static final RegistryObject<TardisTraitType> INTROVERT = TRAITS.register("introvert", () -> setupTrait(IntrovertTrait::new, test -> test.getTraitClass() == ExtrovertTrait.class));
    public static final RegistryObject<TardisTraitType> EXTROVERT = TRAITS.register("extrovert", () -> setupTrait(ExtrovertTrait::new, test -> test.getTraitClass() == IntrovertTrait.class));


    public static TardisTraitType setupTrait(Function<TardisTraitType, TardisTrait> supplier, Predicate<TardisTraitType> test){
        TardisTraitType type = new TardisTraitType(supplier, test);
        return type;
    }

    public static TardisTraitType setupTrait(Function<TardisTraitType, TardisTrait> supplier) {
        return setupTrait(supplier, test -> false);
    }

    public static void registerRarities(){

        RARITIES.addChance(50, PEL.get());
        RARITIES.addChance(10, PEH.get());
        RARITIES.addChance(66, HYDROPHOBIC.get());
        RARITIES.addChance(8, INTROVERT.get());
        RARITIES.addChance(8, EXTROVERT.get());
    }
}
