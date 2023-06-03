package net.tadditions.mixin;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import net.minecraft.command.CommandSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;
import net.tadditions.mod.helper.MExteriorRegistry;
import net.tardis.mod.commands.argument.ExteriorArgument;
import net.tardis.mod.exterior.AbstractExterior;
import net.tardis.mod.registries.ExteriorRegistry;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;



@Mixin(ExteriorArgument.class)
public class ExteriorArgumentMixin {

    private static final DynamicCommandExceptionType MINVALID_EXTERIOR_EXCEPTION = new DynamicCommandExceptionType((exterior) -> {
        return new TranslationTextComponent(new ResourceLocation("tadditions","triedmaketoyota").toString());
    });

    @Shadow @Final private static DynamicCommandExceptionType INVALID_EXTERIOR_EXCEPTION;

    /**
     * @author e
     * @reason e
     */
    @Overwrite
    public static AbstractExterior getExterior(CommandContext<CommandSource> context, String name) throws CommandSyntaxException {
        ResourceLocation resourcelocation = context.getArgument(name, ResourceLocation.class);
        AbstractExterior room = ExteriorRegistry.EXTERIOR_REGISTRY.get().getValue(resourcelocation);
        if (room == null)
            throw INVALID_EXTERIOR_EXCEPTION.create(resourcelocation);
       // else if(room == MExteriorRegistry.TOYOTA_POLICE_BOX.get()){
       //     throw MINVALID_EXTERIOR_EXCEPTION.create(resourcelocation);
        //}
        else return room;
    }

}
