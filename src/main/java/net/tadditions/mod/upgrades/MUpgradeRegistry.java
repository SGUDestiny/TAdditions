package net.tadditions.mod.upgrades;

import com.google.common.collect.Lists;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.items.ModItems;
import net.tardis.mod.registries.UpgradeRegistry;
import net.tardis.mod.subsystem.FlightSubsystem;
import net.tardis.mod.subsystem.StabilizerSubsystem;
import net.tardis.mod.subsystem.Subsystem;
import net.tardis.mod.subsystem.TemporalGraceSubsystem;
import net.tardis.mod.upgrades.Upgrade;
import net.tardis.mod.upgrades.UpgradeEntry;
import net.tardis.mod.upgrades.UpgradeEntry.IConsoleSpawner;

import java.util.List;

public class MUpgradeRegistry extends UpgradeRegistry {

    public static final DeferredRegister<UpgradeEntry> UPGRADES = DeferredRegister.create(UpgradeEntry.class, QolMod.MOD_ID);

    public static final RegistryObject<UpgradeEntry> THERMAL_PROTECTION = UPGRADES.register("thermal_protection",  () -> setupUpgrade(ThermalProtectionUpgrade::new, ModItems.THERMAL_PROTECTION_UPGRADE.get(), TemporalGraceSubsystem.class));
    public static final RegistryObject<UpgradeEntry> ZR2 = UPGRADES.register("zr2",  () -> setupUpgrade(ZR2U::new, ModItems.ZR2_UPGRADE.get(), TemporalGraceSubsystem.class));
    public static final RegistryObject<UpgradeEntry> EC2 = UPGRADES.register("ec2",  () -> setupUpgrade(EC2U::new, ModItems.EC2_UPGRADE.get(), TemporalGraceSubsystem.class));
    public static final RegistryObject<UpgradeEntry> NOBADOMEN = UPGRADES.register("nobadomen",  () -> setupUpgrade(NoBadOmenU::new, ModItems.NOBADOMEN_UPGRADE.get(), TemporalGraceSubsystem.class));
    public static final RegistryObject<UpgradeEntry> FRAMES = UPGRADES.register("frames",  () -> setupUpgrade(FrameStabUpgrade::new, ModItems.FRAME_UPGRADE.get(), StabilizerSubsystem.class));


    public static UpgradeEntry setupUpgrade(IConsoleSpawner<Upgrade> spawn, Item item, Class<? extends Subsystem> sys){
        UpgradeEntry entry = new UpgradeEntry(spawn, item, sys);
        return entry;
    }


}