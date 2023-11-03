package net.tadditions.mod.helper;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.gen.feature.jigsaw.JigsawPattern;
import java.util.function.Supplier;

public class FancyJigsawConfig {
    public static final Codec<FancyJigsawConfig> CODEC = RecordCodecBuilder.create((codecBuilder) -> codecBuilder
            .group(
                    JigsawPattern.field_244392_b_.fieldOf("start_pool").forGetter(FancyJigsawConfig::getStartPoolSupplier),
                    Codec.intRange(0, 7).fieldOf("size").forGetter(FancyJigsawConfig::getMaxChainPieceLength))
            .apply(codecBuilder, FancyJigsawConfig::new));

    private final Supplier<JigsawPattern> startPoolSupplier;
    private final int size;

    public FancyJigsawConfig(Supplier<JigsawPattern> startPoolSupplier, int size) {
        this.startPoolSupplier = startPoolSupplier;
        this.size = size;
    }

    public int getMaxChainPieceLength() {
        return this.size;
    }

    public Supplier<JigsawPattern> getStartPoolSupplier() {
        return this.startPoolSupplier;
    }
}
