package net.stachesebastian.mekanismascended.common.util;

import mekanism.common.tile.factory.TileEntityFactory;
import net.stachesebastian.mekanismascended.common.tier.AscendedTierValues;
import net.stachesebastian.mekanismascended.common.tile.factory.IAscendedFactoryTE;

public final class AscendedFactoryUtil {
    private static final int ULTIMATE_FACTORY_PROCESSES = 9;
    private static final int FACTORY_LANE_SPACING = 19;
    private static final int ULTIMATE_FACTORY_INVENTORY_X_OFFSET = 26;

    private AscendedFactoryUtil() {
    }

    public static boolean isAscendedFactory(TileEntityFactory<?> tile) {
        return tile instanceof IAscendedFactoryTE;
    }

    public static int getProcesses(TileEntityFactory<?> tile) {
        return isAscendedFactory(tile) ? AscendedTierValues.ascendedFactoryProcesses() : tile.tier.processes;
    }

    public static int getExtraGuiWidth(TileEntityFactory<?> tile) {
        if (!isAscendedFactory(tile)) {
            return 0;
        }
        return Math.max(0, getProcesses(tile) - ULTIMATE_FACTORY_PROCESSES) * FACTORY_LANE_SPACING;
    }

    public static int getInventoryXOffset(TileEntityFactory<?> tile) {
        if (!isAscendedFactory(tile)) {
            return tile.tier.processes == ULTIMATE_FACTORY_PROCESSES ? ULTIMATE_FACTORY_INVENTORY_X_OFFSET : 8;
        }
        return ULTIMATE_FACTORY_INVENTORY_X_OFFSET + getExtraGuiWidth(tile) / 2;
    }
}
