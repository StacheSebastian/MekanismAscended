package net.stachesebastian.mekanismascended.common.registries;

import mekanism.common.MekanismLang;
import mekanism.common.block.attribute.AttributeTier;
import mekanism.common.content.blocktype.BlockTypeTile;
import mekanism.common.tier.CableTier;
import net.stachesebastian.mekanismascended.common.tile.transmitter.AscendedTEUniversalCable;

public class AscendedBlockTypes {

    public static final BlockTypeTile<AscendedTEUniversalCable> ASCENDED_UNIVERSAL_CABLE =
            BlockTypeTile.BlockTileBuilder
                    .createBlock(
                            () -> AscendedTileEntityTypes.ASCENDED_UNIVERSAL_CABLE,
                            MekanismLang.DESCRIPTION_CABLE
                    )
                    .with(new AttributeTier<>(CableTier.ULTIMATE))
                    .build();

    private AscendedBlockTypes() {}

}
