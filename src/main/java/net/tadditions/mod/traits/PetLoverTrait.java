package net.tadditions.mod.traits;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.server.ServerWorld;
import net.tardis.mod.helper.TardisHelper;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.tileentities.console.misc.EmotionHandler;
import net.tardis.mod.tileentities.exteriors.ExteriorTile;
import net.tardis.mod.traits.AbstractEntityDeathTrait;
import net.tardis.mod.traits.TardisTraitType;

public class PetLoverTrait extends AbstractEntityDeathTrait {

    public ServerWorld world;

    public PetLoverTrait(TardisTraitType type) {
        super(type);
    }

    @Override
    public void tick(ConsoleTile tile) {
        if(tile.getWorld().getGameTime() + 23 % 200 == 0) {
            ConsoleTile ext = (ConsoleTile)world.getTileEntity(TardisHelper.TARDIS_POS);
            double mod = 1.0 - this.getWeight();
            if(ext != null) {
                if(!ext.getWorld().getEntitiesWithinAABB(TameableEntity.class, new AxisAlignedBB(ext.getPos()).grow(8)).isEmpty()) {
                    if(tile.getEmotionHandler().getMood() < EmotionHandler.EnumHappyState.DISCONTENT.getTreshold())
                        tile.getEmotionHandler().addMood((1 + (int)Math.round(4 * mod)));
                }
            }
        }
    }

    @Override
    public void onPlayerKilledEntity(PlayerEntity player, ConsoleTile tardis, LivingEntity victim) {
        double mod = 1.0 - this.getWeight();
        if(victim instanceof TameableEntity && tardis.getEmotionHandler().getMood() > EmotionHandler.EnumHappyState.CONTENT.getTreshold())
            tardis.getEmotionHandler().addMood(-(4 + (4 * mod)));
    }
}
