package net.tadditions.mixin;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.tadditions.mod.world.MDimensions;
import net.tardis.mod.config.TConfig;
import net.tardis.mod.helper.WorldHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.List;

@Mixin(WorldHelper.class)
public class WorldHelperMixin {

    /**
     * @author mistersecret312
     * @reason ban our dimension
     */
    @Overwrite
    public static boolean canVMTravelToDimension(RegistryKey<World> worldKey) {
        ResourceLocation key = worldKey.getLocation();
        if(key == null)
            return false;
        if(key == MDimensions.THE_VERGE.getLocation())
            return false;
        if (TConfig.SERVER.toggleVMWhitelistDims.get()) { //If using whitelist
            List<? extends String> whitelist = TConfig.SERVER.whitelistedVMDims.get();
            for(String s : whitelist) {
                if(key.toString().contentEquals(s))
                    return true;
            }
            return false;
        }
        else if (!TConfig.SERVER.toggleVMWhitelistDims.get()){ //If using blacklist
            List<? extends String> blacklist = TConfig.SERVER.blacklistedVMDims.get();
            for(String s : blacklist) {
                if(key.toString().contentEquals(s))
                    return false;
            }
            return true;
        }
        return false;
    }

}
