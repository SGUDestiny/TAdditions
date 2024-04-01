package net.tadditions.mod.helper;

import net.minecraft.block.BlockState;
import net.minecraft.util.ResourceLocation;
import net.tadditions.mod.QolMod;
import net.tardis.mod.misc.Console;

import java.util.function.Supplier;

public class ModConsoles extends Console {
    private ResourceLocation registryName;
    private ResourceLocation imageLocation;
    private Supplier<BlockState> state;

    public ModConsoles(Supplier<BlockState> state, String imageLocation) {
        this(state, new ResourceLocation(QolMod.MOD_ID, "textures/gui/consoles/" + imageLocation + ".png"));
    }

    public ModConsoles(Supplier<BlockState> state, ResourceLocation imageLocation) {
        super(state, imageLocation);
        this.state = state;
        this.imageLocation = imageLocation;
    }

    @Override
    public ResourceLocation getPreviewTexture() {
        return this.imageLocation;
    }


}
