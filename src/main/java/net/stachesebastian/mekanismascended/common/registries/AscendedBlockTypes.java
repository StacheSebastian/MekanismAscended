package net.stachesebastian.mekanismascended.common.registries;

import mekanism.common.MekanismLang;
import mekanism.common.block.attribute.AttributeTier;
import mekanism.common.content.blocktype.BlockTypeTile;
import mekanism.common.tier.CableTier;
import mekanism.common.tier.ConductorTier;
import mekanism.common.tier.PipeTier;
import mekanism.common.tier.TransporterTier;
import mekanism.common.tier.TubeTier;
import net.stachesebastian.mekanismascended.common.tile.transmitter.AscendedTELogisticalTransporter;
import net.stachesebastian.mekanismascended.common.tile.transmitter.AscendedTEMechanicalPipe;
import net.stachesebastian.mekanismascended.common.tile.transmitter.AscendedTEPressurizedTube;
import net.stachesebastian.mekanismascended.common.tile.transmitter.AscendedTEThermodynamicConductor;
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

    public static final BlockTypeTile<AscendedTEPressurizedTube> ASCENDED_PRESSURIZED_TUBE =
            BlockTypeTile.BlockTileBuilder
                    .createBlock(
                            () -> AscendedTileEntityTypes.ASCENDED_PRESSURIZED_TUBE,
                            MekanismLang.DESCRIPTION_TUBE
                    )
                    .with(new AttributeTier<>(TubeTier.ULTIMATE))
                    .build();

    public static final BlockTypeTile<AscendedTEThermodynamicConductor> ASCENDED_THERMODYNAMIC_CONDUCTOR =
            BlockTypeTile.BlockTileBuilder
                    .createBlock(
                            () -> AscendedTileEntityTypes.ASCENDED_THERMODYNAMIC_CONDUCTOR,
                            MekanismLang.DESCRIPTION_CONDUCTOR
                    )
                    .with(new AttributeTier<>(ConductorTier.ULTIMATE))
                    .build();

    public static final BlockTypeTile<AscendedTEMechanicalPipe> ASCENDED_MECHANICAL_PIPE =
            BlockTypeTile.BlockTileBuilder
                    .createBlock(
                            () -> AscendedTileEntityTypes.ASCENDED_MECHANICAL_PIPE,
                            MekanismLang.DESCRIPTION_PIPE
                    )
                    .with(new AttributeTier<>(PipeTier.ULTIMATE))
                    .build();

    public static final BlockTypeTile<AscendedTELogisticalTransporter> ASCENDED_LOGISTICAL_TRANSPORTER =
            BlockTypeTile.BlockTileBuilder
                    .createBlock(
                            () -> AscendedTileEntityTypes.ASCENDED_LOGISTICAL_TRANSPORTER,
                            MekanismLang.DESCRIPTION_TRANSPORTER
                    )
                    .with(new AttributeTier<>(TransporterTier.ULTIMATE))
                    .build();

    private AscendedBlockTypes() {}

}
