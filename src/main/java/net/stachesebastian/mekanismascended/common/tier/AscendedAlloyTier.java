package net.stachesebastian.mekanismascended.common.tier;

import mekanism.api.tier.BaseTier;
import mekanism.api.tier.IAlloyTier;

public enum AscendedAlloyTier implements IAlloyTier {
    TRANSCENDENT;

    @Override
    public int getBaseTierLevel() {
        return BaseTier.CREATIVE.ordinal();
    }
}
