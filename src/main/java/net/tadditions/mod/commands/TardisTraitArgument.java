package net.tadditions.mod.commands;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import net.minecraft.command.CommandSource;
import net.minecraft.command.ISuggestionProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;
import net.tardis.mod.commands.argument.ExteriorArgument;
import net.tardis.mod.exterior.AbstractExterior;
import net.tardis.mod.registries.ExteriorRegistry;
import net.tardis.mod.registries.TraitRegistry;
import net.tardis.mod.traits.TardisTraitType;

import java.util.Collection;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TardisTraitArgument implements ArgumentType<ResourceLocation> {

    private static final DynamicCommandExceptionType INVALID_TRAIT_EXCEPTION = new DynamicCommandExceptionType((trait) -> {
        return new TranslationTextComponent("argument.tardis.trait.invalid", trait);
    });

    @Override
    public ResourceLocation parse(StringReader reader) throws CommandSyntaxException {
        return ResourceLocation.read(reader);
    }

    @Override
    public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> context, SuggestionsBuilder builder) {
        Collection<ResourceLocation> traits = TraitRegistry.TRAIT_REGISTRY.get().getKeys();
        return context.getSource() instanceof ISuggestionProvider ? ISuggestionProvider.func_212476_a(traits.stream(), builder) : Suggestions.empty();
    }

    @Override
    public Collection<String> getExamples() {
        return Stream.of(TraitRegistry.JEALOUS, TraitRegistry.MURDEROUS).map(trait -> trait.get().getRegistryName().toString()).collect(Collectors.toList());
    }

    public static TardisTraitArgument getTraitArgument() {
        return new TardisTraitArgument();
    }

    public static TardisTraitType getTrait(CommandContext<CommandSource> context, String name) throws CommandSyntaxException {
        ResourceLocation resourcelocation = context.getArgument(name, ResourceLocation.class);
        TardisTraitType trait = TraitRegistry.TRAIT_REGISTRY.get().getValue(resourcelocation);
        if (trait == null)
            throw INVALID_TRAIT_EXCEPTION.create(resourcelocation);
        else
            return trait;
    }
}
