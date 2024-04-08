package net.tadditions.mixin;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.Constants;
import net.tadditions.mod.helper.IEmotionHelp;
import net.tardis.mod.registries.TraitRegistry;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.tileentities.console.misc.EmotionHandler;
import net.tardis.mod.tileentities.console.misc.PlayerTelepathicConnection;
import net.tardis.mod.traits.TardisTrait;
import net.tardis.mod.traits.TardisTraitType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.*;

@Mixin(EmotionHandler.class)
public abstract class EHMixin implements IEmotionHelp {
    @Shadow private boolean hasGeneratedTraits;
    @Shadow private HashMap<UUID, Integer> loyalties;
    @Shadow private ConsoleTile tile;
    @Shadow private double mood;
    /** The last time a player occupied this TARDIS interior */
    @Shadow private long lastTimePlayerInTardis;
    /** If the Tardis already has existing traits*/
    @Shadow private Map<UUID, PlayerTelepathicConnection> connectedPlayers;
    private TardisTrait[] traits = new TardisTrait[6];

    @Shadow
    protected abstract boolean hasIncompatibleTrait(TardisTraitType type);

    /**
     * @author mistersecret312
     * @reason EH changes
     */
    @Overwrite(remap = false)
    private void generateTardisTraits() {
        traits = new TardisTrait[6];

        int i = 0;
        //Make a copy of registered traits
        List<TardisTraitType> possibleTraits = Lists.newArrayList(TraitRegistry.TRAIT_REGISTRY.get().getValues());

        for(int x = 0; x < 25; ++x) {
            //If there are no traits to choose from or the TARDIS has four, stop
            if(possibleTraits.isEmpty() || x >= 4)
                break;

            //Generated Type
            TardisTraitType type = possibleTraits.get(ConsoleTile.rand.nextInt(possibleTraits.size()));

            //If this TARDIS already has a trait that conflicts with this one
            if(hasIncompatibleTrait(type))
                continue;

            this.traits[i] = type.create().setWeight(ConsoleTile.rand.nextDouble());
            possibleTraits.remove(type);
            ++i;

        }

        this.hasGeneratedTraits = true;
    }

    /**
     * @author mistersecret312
     * @reason EH changes
     */
    @Overwrite(remap = false)
    public void deserializeNBT(CompoundNBT tag) {
        ListNBT loyaltyList = tag.getList("loyalties", Constants.NBT.TAG_COMPOUND);
        for(INBT l : loyaltyList) {
            CompoundNBT loyaltyTag = (CompoundNBT)l;
            this.loyalties.put(UUID.fromString(loyaltyTag.getString("id")), loyaltyTag.getInt("loyalty"));
        }

        this.mood = tag.getInt("mood");
        this.hasGeneratedTraits = tag.getBoolean("has_generated_traits");

        traits = new TardisTrait[6];

        if(tag.contains("trait_list")) {
            ListNBT list = tag.getList("trait_list", Constants.NBT.TAG_COMPOUND);
            int i = 0;
            for(INBT base : list) {
                CompoundNBT nbt = (CompoundNBT)base;
                TardisTrait trait = TraitRegistry.TRAIT_REGISTRY.get().getValue(new ResourceLocation(nbt.getString("registry_name"))).create();
                trait.setWeight(nbt.getDouble("weight"));
                this.traits[i] = trait;
                ++i;
            }
        }

        ListNBT connectedList = tag.getList("connectedPlayers", Constants.NBT.TAG_COMPOUND);
        this.connectedPlayers.clear();
        for(INBT con : connectedList) {
            CompoundNBT conTag = (CompoundNBT)con;
            UUID id = conTag.getUniqueId("id");
            CompoundNBT connectionInfo = (CompoundNBT) conTag.get("connection_info");
            this.connectedPlayers.put(id, new PlayerTelepathicConnection(this.tile, connectionInfo));
        }
    }

    /**
     * @author mistersecret312
     * @reason EH changes
     */
    @Overwrite(remap = false)
    public CompoundNBT serializeNBT() {
        CompoundNBT tag = new CompoundNBT();

        ListNBT loyaltyList = new ListNBT();
        for(Map.Entry<UUID, Integer> loyalty : this.loyalties.entrySet()) {
            CompoundNBT loyTag = new CompoundNBT();

            loyTag.putString("id", loyalty.getKey().toString());
            loyTag.putInt("loyalty", loyalty.getValue());

            loyaltyList.add(loyTag);
        }
        tag.put("loyalties", loyaltyList);

        tag.putDouble("mood", this.mood);
        tag.putBoolean("has_generated_traits", this.hasGeneratedTraits);

        ListNBT traits = new ListNBT();
        for(TardisTrait trait : this.traits) {
            if(trait != null) {
                CompoundNBT traitTag = new CompoundNBT();
                traitTag.putString("registry_name", trait.getType().getRegistryName().toString());
                traitTag.putDouble("weight", trait.getWeight());
                traits.add(traitTag);
            }
        }
        tag.put("trait_list", traits);

        ListNBT connectedList = new ListNBT();
        for(Map.Entry<UUID, PlayerTelepathicConnection> con : this.connectedPlayers.entrySet()) {
            CompoundNBT connectionTag = new CompoundNBT();
            connectionTag.putUniqueId("id", con.getKey());
            connectionTag.put("connection_info", con.getValue().serializeNBT());
            connectedList.add(connectionTag);
        }
        tag.put("connectedPlayers", connectedList);
        return tag;
    }

    @Override
    public void setTraits(ArrayList<TardisTrait> traits) {
        this.traits = traits.toArray(new TardisTrait[0]);
    }
}
