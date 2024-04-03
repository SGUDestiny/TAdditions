package net.tadditions.mod.commands;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.ArgumentSerializer;
import net.minecraft.command.arguments.ArgumentTypes;
import net.tardis.mod.Tardis;
import net.tardis.mod.commands.argument.*;
import net.tardis.mod.commands.subcommands.*;
import net.tardis.mod.helper.Helper;

public class TACommands {
    public static void register(CommandDispatcher<CommandSource> dispatcher){
        dispatcher.register(
                Commands.literal(Tardis.MODID)
                        .then(SetTraitsCommand.register(dispatcher))
        );
    }

    /** Register our custom Argument Types to allow for proper serialisation on the server
     * <br> Do this in FMLCommonSetup, enqueueWork lambda*/
    public static void registerCustomArgumentTypes() {
        ArgumentTypes.register(Helper.createRLString("trait_argument"), TardisTraitArgument.class, new ArgumentSerializer<>(TardisTraitArgument::getTraitArgument));
        }
}
