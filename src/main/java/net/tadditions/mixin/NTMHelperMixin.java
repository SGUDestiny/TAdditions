package net.tadditions.mixin;

import net.tardis.mod.constants.TardisConstants;
import net.tardis.mod.helper.Helper;
import net.tardis.mod.helper.WorldHelper;
import net.tardis.mod.tileentities.ConsoleTile;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(Helper.class)
public class NTMHelperMixin {

    @Overwrite(remap = false)
    public static String[] getConsoleText(ConsoleTile console) {

        if(console.getFlightEvent() != null)
            return new String[] {
                    "",
                    console.getFlightEvent().getTranslation().getString()
            };

        if(console.getInteriorManager().getMonitorOverrides() != null)
            return console.getInteriorManager().getMonitorOverrides().getText();

        boolean hasNav = console.hasNavCom();

        return new String[] {
                TardisConstants.Translations.LOCATION.getString() + (hasNav ? WorldHelper.formatBlockPos(console.getCurrentLocation()): TardisConstants.Translations.UNKNOWN.getString()),
                TardisConstants.Translations.DIMENSION.getString() + (hasNav ? WorldHelper.formatDimName(console.getCurrentDimension()) : TardisConstants.Translations.UNKNOWN.getString()),
                TardisConstants.Translations.FACING.getString() + console.getExteriorFacingDirection().getName2().toUpperCase(),
                TardisConstants.Translations.TARGET.getString() + (hasNav ? WorldHelper.formatBlockPos(console.getDestinationPosition()) : TardisConstants.Translations.UNKNOWN.getString()),
                TardisConstants.Translations.TARGET_DIM.getString() + (hasNav ? WorldHelper.formatDimName(console.getDestinationDimension()) : TardisConstants.Translations.UNKNOWN.getString()),
                TardisConstants.Translations.ARTRON.getString() + (console.getArtron() == Float.MAX_VALUE ? "Infinity AU" : TardisConstants.TEXT_FORMAT_NO_DECIMALS.format(console.getArtron()) + "AU"),
                TardisConstants.Translations.JOURNEY.getString() + TardisConstants.TEXT_FORMAT_NO_DECIMALS.format(console.getPercentageJourney() * 100.0F) + "%"
        };
    }

}
