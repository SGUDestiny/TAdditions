package net.tadditions.mod.item;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;

public class VergeGateOpener extends Item
{

    public VergeGateOpener(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if(context.getLevel().isClientSide())
            return InteractionResult.PASS;



        return super.useOn(context);
    }
}
