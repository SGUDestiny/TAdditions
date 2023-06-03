package net.tadditions.mod.helper;

import net.minecraft.util.ResourceLocation;
import net.tadditions.mod.QolMod;
import net.tardis.mod.misc.TexVariant;

public class MTextureVariants {

    public static final ResourceLocation NORMAL = new ResourceLocation(QolMod.MOD_ID,"textures/exteriors/toyota_exterior.png");
    public static final ResourceLocation NORMALDOOR = new ResourceLocation(QolMod.MOD_ID,"textures/exteriors/toyota_door.png");
    public static final ResourceLocation ELEVEN = new ResourceLocation(QolMod.MOD_ID,"textures/exteriors/variants/toyota_exterior11.png");
    public static final ResourceLocation ELEVENDOOR = new ResourceLocation(QolMod.MOD_ID,"textures/exteriors/variants/toyota_door11.png");
    public static final ResourceLocation VELWE = new ResourceLocation(QolMod.MOD_ID,"textures/exteriors/variants/toyota_exterior12.png");
    public static final ResourceLocation VELWEDOOR = new ResourceLocation(QolMod.MOD_ID,"textures/exteriors/variants/toyota_door12.png");

    public static final TexVariant[] TOYOTA = {
            new TexVariant(NORMAL, "exterior.toyota").addInteriorDoorVariant(NORMALDOOR),
            new TexVariant(ELEVEN, "exterior.toyota.11").addInteriorDoorVariant(ELEVENDOOR),
            new TexVariant(VELWE, "exterior.toyota.12").addInteriorDoorVariant(VELWEDOOR)
    };
}
