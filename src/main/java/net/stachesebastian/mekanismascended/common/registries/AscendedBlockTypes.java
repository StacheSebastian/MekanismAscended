package net.stachesebastian.mekanismascended.common.registries;

import mekanism.common.MekanismLang;
import mekanism.common.block.attribute.AttributeParticleFX;
import mekanism.common.block.attribute.AttributeStateActive;
import mekanism.common.block.attribute.AttributeStateFacing;
import mekanism.common.block.attribute.AttributeUpgradeSupport;
import mekanism.common.block.attribute.AttributeTier;
import mekanism.common.block.attribute.Attributes.AttributeRedstone;
import mekanism.common.content.blocktype.BlockShapes;
import mekanism.common.content.blocktype.BlockTypeTile;
import mekanism.common.content.blocktype.Machine;
import mekanism.common.content.blocktype.Machine.MachineBuilder;
import mekanism.common.lib.transmitter.TransmissionType;
import mekanism.common.registries.MekanismContainerTypes;
import mekanism.common.tier.*;
import mekanism.common.tile.TileEntityChemicalTank;
import mekanism.common.tile.TileEntityEnergyCube;
import mekanism.common.tile.TileEntityFluidTank;
import mekanism.common.tile.multiblock.TileEntityInductionCell;
import mekanism.common.tile.multiblock.TileEntityInductionProvider;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.stachesebastian.mekanismascended.common.tier.AscendedTierValues;
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


    public static final Machine<TileEntityFluidTank> ASCENDED_FLUID_TANK =
            MachineBuilder.createMachine(
                            () -> AscendedTileEntityTypes.ASCENDED_FLUID_TANK,
                            MekanismLang.DESCRIPTION_FLUID_TANK
                    )
                    .withGui(() -> mekanism.common.registries.MekanismContainerTypes.FLUID_TANK)
                    .withCustomShape(BlockShapes.FLUID_TANK)
                    .with(new AttributeTier<>(FluidTankTier.ULTIMATE))
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
                    .with(new AttributeTier<>(ChemicalTankTier.ULTIMATE))
                    .withSideConfig(TransmissionType.CHEMICAL, TransmissionType.ITEM)
                    .without(AttributeParticleFX.class, AttributeStateActive.class, AttributeUpgradeSupport.class)
                    .withComputerSupport(ChemicalTankTier.ULTIMATE, "ChemicalTank")
                    .build();

    public static final Machine<TileEntityEnergyCube> ASCENDED_ENERGY_CUBE =
            MachineBuilder.createMachine(() -> AscendedTileEntityTypes.ASCENDED_ENERGY_CUBE,
                            MekanismLang.DESCRIPTION_ENERGY_CUBE
                    )
                    .withGui(() -> MekanismContainerTypes.ENERGY_CUBE)
                    .withEnergyConfig(() -> AscendedTierValues.ASCENDED_ENERGY_CUBE_CAPACITY)
                    .with(new AttributeTier<>(EnergyCubeTier.ULTIMATE), new AttributeStateFacing(BlockStateProperties.FACING))
                    .withSideConfig(TransmissionType.ENERGY, TransmissionType.ITEM)
                    .without(AttributeParticleFX.class, AttributeStateActive.class, AttributeUpgradeSupport.class)
                    .withComputerSupport(EnergyCubeTier.ULTIMATE, "EnergyCube")
                    .build();


    public static final BlockTypeTile<TileEntityInductionCell> ASCENDED_INDUCTION_CELL =
            BlockTypeTile.BlockTileBuilder.createBlock(() -> AscendedTileEntityTypes.ASCENDED_INDUCTION_CELL, MekanismLang.DESCRIPTION_INDUCTION_CELL)
                    .withEnergyConfig(() -> AscendedTierValues.ASCENDED_INDUCTION_CELL_CAPACITY)
                    .with(new AttributeTier<>(InductionCellTier.ULTIMATE))
                    .internalMultiblock()
                    .build();

    public static final BlockTypeTile<TileEntityInductionProvider> ASCENDED_INDUCTION_PROVIDER =
            BlockTypeTile.BlockTileBuilder.createBlock(() -> AscendedTileEntityTypes.ASCENDED_INDUCTION_PROVIDER, MekanismLang.DESCRIPTION_INDUCTION_PROVIDER)
                    .with(new AttributeTier<>(InductionProviderTier.ULTIMATE))
                    .internalMultiblock()
                    .build();

    private AscendedBlockTypes() {}

}
