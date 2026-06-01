package net.stachesebastian.mekanismascended.common.registries;

import mekanism.common.MekanismLang;
import mekanism.common.block.attribute.AttributeParticleFX;
import mekanism.common.block.attribute.AttributeStateActive;
import mekanism.common.block.attribute.AttributeStateFacing;
import mekanism.common.block.attribute.AttributeUpgradeSupport;
import mekanism.common.block.attribute.AttributeUpgradeable;
import mekanism.common.block.attribute.AttributeTier;
import mekanism.common.block.attribute.Attributes.AttributeRedstone;
import mekanism.common.block.attribute.AttributeSideConfig;
import mekanism.common.content.blocktype.BlockShapes;
import mekanism.common.content.blocktype.BlockTypeTile;
import mekanism.common.content.blocktype.Machine;
import mekanism.common.content.blocktype.Machine.MachineBuilder;
import mekanism.common.lib.transmitter.TransmissionType;
import mekanism.common.tier.ChemicalTankTier;
import mekanism.common.tier.CableTier;
import mekanism.common.tier.ConductorTier;
import mekanism.common.tier.FluidTankTier;
import mekanism.common.tier.PipeTier;
import mekanism.common.tier.TransporterTier;
import mekanism.common.tier.TubeTier;
import mekanism.common.tile.TileEntityChemicalTank;
import mekanism.common.tile.TileEntityFluidTank;
import net.stachesebastian.mekanismascended.common.tile.transmitter.AscendedTELogisticalTransporter;
import net.stachesebastian.mekanismascended.common.tile.transmitter.AscendedTEMechanicalPipe;
import net.stachesebastian.mekanismascended.common.tile.transmitter.AscendedTEPressurizedTube;
import net.stachesebastian.mekanismascended.common.tile.transmitter.AscendedTEThermodynamicConductor;
import net.stachesebastian.mekanismascended.common.tile.transmitter.AscendedTEUniversalCable;

public class AscendedBlockTypes {

    public static final Machine<TileEntityFluidTank> ASCENDED_FLUID_TANK =
            MachineBuilder.createMachine(
                            () -> AscendedTileEntityTypes.ASCENDED_FLUID_TANK,
                            MekanismLang.DESCRIPTION_FLUID_TANK
                    )
                    .withGui(() -> mekanism.common.registries.MekanismContainerTypes.FLUID_TANK)
                    .withCustomShape(BlockShapes.FLUID_TANK)
                    .with(new AttributeTier<>(FluidTankTier.ULTIMATE), new AttributeUpgradeable(null))
                    .without(AttributeParticleFX.class, AttributeStateFacing.class, AttributeRedstone.class, AttributeUpgradeSupport.class)
                    .withComputerSupport(FluidTankTier.ULTIMATE, "FluidTank")
                    .build();

    public static final Machine<TileEntityChemicalTank> ASCENDED_CHEMICAL_TANK =
            MachineBuilder.createMachine(
                            () -> AscendedTileEntityTypes.ASCENDED_CHEMICAL_TANK,
                            MekanismLang.DESCRIPTION_CHEMICAL_TANK
                    )
                    .withGui(() -> mekanism.common.registries.MekanismContainerTypes.CHEMICAL_TANK)
                    .withCustomShape(BlockShapes.CHEMICAL_TANK)
                    .with(new AttributeTier<>(ChemicalTankTier.ULTIMATE), new AttributeUpgradeable(null))
                    .withSideConfig(TransmissionType.CHEMICAL, TransmissionType.ITEM)
                    .without(AttributeParticleFX.class, AttributeStateActive.class, AttributeUpgradeSupport.class)
                    .withComputerSupport(ChemicalTankTier.ULTIMATE, "ChemicalTank")
                    .build();

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
