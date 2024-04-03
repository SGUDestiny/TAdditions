package net.tadditions.mod.commands;

import com.google.common.collect.Lists;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.ISuggestionProvider;
import net.minecraft.command.arguments.DimensionArgument;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.tadditions.mixin.EHMixin;
import net.tadditions.mod.helper.IEmotionHelp;
import net.tardis.mod.Tardis;
import net.tardis.mod.cap.Capabilities;
import net.tardis.mod.commands.subcommands.TCommand;
import net.tardis.mod.constants.TardisConstants;
import net.tardis.mod.helper.CommandHelper;
import net.tardis.mod.helper.TardisHelper;
import net.tardis.mod.helper.TextHelper;
import net.tardis.mod.registries.TraitRegistry;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.traits.TardisTrait;
import net.tardis.mod.traits.TardisTraitType;

import java.util.*;

import static net.tardis.mod.helper.TardisHelper.TARDIS_POS;

public class SetTraitsCommand extends TCommand {

    private static int setTardisTraits(CommandContext<CommandSource> context, ServerWorld world, ArrayList<TardisTrait> traites){
        CommandSource source = context.getSource();
        if (TardisHelper.getConsole(context.getSource().getServer(), world).isPresent()) {
            Optional<ConsoleTile> console = TardisHelper.getConsoleInWorld(world);
            console.ifPresent(tile -> tile.getWorld().getCapability(Capabilities.TARDIS_DATA).ifPresent(data -> {

                ((IEmotionHelp) tile.getEmotionHandler()).setTraits(traites);

                StringBuilder traits = new StringBuilder();

                // for each loop
                TardisTrait[] tardisTraits = tile.getEmotionHandler().getTraits();
                for (TardisTrait trait : tardisTraits) {
                    if (trait == null)
                        continue;
                    traits.append(trait.getType().getRegistryName().toString()).append("\n");
                }
                TextComponent tardisIdentifier = TextHelper.getTardisDimObject(world, data);
                source.sendFeedback(new TranslationTextComponent("command.tardis.traits.set", tardisIdentifier), true);
            }));
        }
        else {
            context.getSource().sendErrorMessage(new TranslationTextComponent(TardisConstants.Translations.NO_TARDIS_FOUND, world.getDimensionKey().getLocation().toString()));
            return 0;
        }
        return Command.SINGLE_SUCCESS;
        }

    public static ArgumentBuilder<CommandSource, ?> register(CommandDispatcher<CommandSource> dispatcher){
        return Commands.literal("set_trait").requires(context -> context.hasPermissionLevel(2))
                .then(Commands.argument("tardis", DimensionArgument.getDimension()).suggests((context, suggestionBuilder) -> ISuggestionProvider.suggest(Collections.emptyList(), CommandHelper.addTardisKeysWithNameTooltip(suggestionBuilder, context.getSource().getServer())))
                        .then(Commands.argument("trait1", TardisTraitArgument.getTraitArgument())
                                .then(Commands.argument("trait2", TardisTraitArgument.getTraitArgument())
                                        .then(Commands.argument("trait3", TardisTraitArgument.getTraitArgument())
                                                .then(Commands.argument("trait4", TardisTraitArgument.getTraitArgument())
                                                        .executes(context -> setTardisTraits(context, DimensionArgument.getDimensionArgument(context, "tardis"), Lists.newArrayList(TardisTraitArgument.getTrait(context, "trait1").create(), TardisTraitArgument.getTrait(context, "trait2").create(), TardisTraitArgument.getTrait(context, "trait3").create(), TardisTraitArgument.getTrait(context, "trait4").create())))
                                                )
                                        )
                                )
                        )
                );
    }

    public static SuggestionsBuilder addTraits(SuggestionsBuilder builder, MinecraftServer server) {
        Map<TardisTraitType, String> map = getTardisTraitsAndNames(server);
        map.entrySet().forEach(entry -> {
            builder.suggest(entry.getKey().getRegistryName().toString(), new StringTextComponent(entry.getValue()).modifyStyle((style) -> style.setFormatting(TextFormatting.DARK_PURPLE)));
        });
        builder.buildFuture();
        return builder;
    }

    public static Map<TardisTraitType, String> getTardisTraitsAndNames(MinecraftServer server){
        Map<TardisTraitType, String> map = new HashMap<>();
        TraitRegistry.TRAIT_REGISTRY.get().getValues().forEach(key -> {
            map.put(key, key.getRegistryName().getNamespace());
        });
        return map;
    }

}
