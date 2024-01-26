package net.tadditions.mod.config;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class MConfigs {
    public static final MConfigs.Common COMMON;
    public static final ForgeConfigSpec COMMON_SPEC;
    public static final MConfigs.Server SERVER;
    public static final ForgeConfigSpec SERVER_SPEC;

    static {
        final Pair<MConfigs.Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(MConfigs.Common::new);
        COMMON = specPair.getLeft();
        COMMON_SPEC = specPair.getRight();
        final Pair<MConfigs.Server, ForgeConfigSpec> specServerPair = new ForgeConfigSpec.Builder().configure(MConfigs.Server::new);
        SERVER = specServerPair.getLeft();
        SERVER_SPEC = specServerPair.getRight();
    }

    public static class Server {
        public ForgeConfigSpec.ConfigValue<Boolean> StattenheimRecipe;

        public Server(ForgeConfigSpec.Builder builder) {
            StattenheimRecipe = builder.comment("Changes if the craft of a Stattenheim Remote is available")
                    .translation("config.tadditions.StattenheimRecipe")
                    .define("StattenheimRecipe", true);
        }
    }

    public static class Common {
        public ForgeConfigSpec.ConfigValue<Integer> FoodCubeCost;

        public ForgeConfigSpec.ConfigValue<Integer> AlternatingWindRarity;
        public ForgeConfigSpec.ConfigValue<Integer> VectorErrorRarity;
        public ForgeConfigSpec.ConfigValue<Integer> StormRarity;

        public ForgeConfigSpec.ConfigValue<Boolean> OlimCallInOther;

        public Common(ForgeConfigSpec.Builder builder) {

            FoodCubeCost = builder.comment("Changes the cost of the Food Cube")
                    .translation("config.tadditions.FoodCubeCost")
                    .define("FoodCubeCost", 10);

            VectorErrorRarity = builder.comment("Changes the rarity of the Vector Calculation Error, 0-100")
                    .translation("config.tadditions.VectorErrorRarity")
                    .defineInRange("VectorErrorRarity", 15, 0, 100);

            AlternatingWindRarity = builder.comment("Changes the capacity of the Alternating Time Winds, 0-100")
                    .translation("config.tadditions.AlternatingWindRarity")
                    .defineInRange("AlternatingWindRarity", 10, 0, 100);

            StormRarity  = builder.comment("Changes the rarity of the Time Storm, 0-100")
                    .translation("config.tadditions.StormRarity")
                    .defineInRange("StormRarity", 2, 0, 100);

            OlimCallInOther = builder.comment("Changes if calling a TARDIS into another TARDIS is allowed")
                    .translation("config.tadditions.OlimCallInOther")
                    .define("OlimCallInOther", true);


        }





    }
}
