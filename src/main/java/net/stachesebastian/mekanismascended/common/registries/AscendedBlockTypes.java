package net.stachesebastian.mekanismascended.common.registries;

import mekanism.common.MekanismLang;
import mekanism.common.block.attribute.*;
import mekanism.common.block.attribute.Attributes.AttributeRedstone;
import mekanism.api.math.MathUtils;
import mekanism.common.content.blocktype.BlockShapes;
import mekanism.common.content.blocktype.BlockTypeTile;
import mekanism.common.content.blocktype.Factory;
import mekanism.common.content.blocktype.Factory.FactoryBuilder;
import mekanism.common.content.blocktype.FactoryType;
import mekanism.common.content.blocktype.Machine;
import mekanism.common.content.blocktype.Machine.MachineBuilder;
import mekanism.common.lib.transmitter.TransmissionType;
import mekanism.common.registries.MekanismContainerTypes;
import mekanism.common.tier.*;
import mekanism.common.tile.TileEntityBin;
import mekanism.common.tile.TileEntityChemicalTank;
import mekanism.common.tile.TileEntityEnergyCube;
import mekanism.common.tile.TileEntityFluidTank;
import mekanism.common.tile.multiblock.TileEntityInductionCell;
import mekanism.common.tile.multiblock.TileEntityInductionProvider;
import mekanism.common.tile.factory.TileEntityFactory;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.stachesebastian.mekanismascended.common.tier.AscendedTierValues;
import net.stachesebastian.mekanismascended.common.tile.transmitter.AscendedTELogisticalTransporter;
import net.stachesebastian.mekanismascended.common.tile.transmitter.AscendedTEMechanicalPipe;
import net.stachesebastian.mekanismascended.common.tile.transmitter.AscendedTEPressurizedTube;
import net.stachesebastian.mekanismascended.common.tile.transmitter.AscendedTEThermodynamicConductor;
import net.stachesebastian.mekanismascended.common.tile.transmitter.AscendedTEUniversalCable;
import net.stachesebastian.mekanismascended.common.tile.factory.AscendedTECombiningFactory;
import net.stachesebastian.mekanismascended.common.tile.factory.AscendedTEItemStackChemicalToItemStackFactory;
import net.stachesebastian.mekanismascended.common.tile.factory.AscendedTEItemStackToItemStackFactory;
import net.stachesebastian.mekanismascended.common.tile.factory.AscendedTESawingFactory;

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
                    .withComputerSupport("AscendedFluidTank")
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
                    .withComputerSupport("AscendedChemicalTank")
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
                    .withComputerSupport("AscendedEnergyCube")
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

    public static final Machine<TileEntityBin> ASCENDED_BIN =
            MachineBuilder.createMachine(
                            () -> AscendedTileEntityTypes.ASCENDED_BIN,
                            MekanismLang.DESCRIPTION_BIN
                    )
                    .with(new AttributeTier<>(BinTier.ULTIMATE))
                    .without(AttributeParticleFX.class, Attributes.AttributeSecurity.class, AttributeUpgradeSupport.class, AttributeRedstone.class)
                    .withComputerSupport("AscendedBin")
                    .build();

    public static final Factory<AscendedTEItemStackToItemStackFactory> ASCENDED_SMELTING_FACTORY =
            createAscendedFactory(() -> AscendedTileEntityTypes.ASCENDED_SMELTING_FACTORY, FactoryType.SMELTING);
    public static final Factory<AscendedTEItemStackToItemStackFactory> ASCENDED_ENRICHING_FACTORY =
            createAscendedFactory(() -> AscendedTileEntityTypes.ASCENDED_ENRICHING_FACTORY, FactoryType.ENRICHING);
    public static final Factory<AscendedTEItemStackToItemStackFactory> ASCENDED_CRUSHING_FACTORY =
            createAscendedFactory(() -> AscendedTileEntityTypes.ASCENDED_CRUSHING_FACTORY, FactoryType.CRUSHING);
    public static final Factory<AscendedTEItemStackChemicalToItemStackFactory> ASCENDED_COMPRESSING_FACTORY =
            createAscendedFactory(() -> AscendedTileEntityTypes.ASCENDED_COMPRESSING_FACTORY, FactoryType.COMPRESSING);
    public static final Factory<AscendedTECombiningFactory> ASCENDED_COMBINING_FACTORY =
            createAscendedFactory(() -> AscendedTileEntityTypes.ASCENDED_COMBINING_FACTORY, FactoryType.COMBINING);
    public static final Factory<AscendedTEItemStackChemicalToItemStackFactory> ASCENDED_PURIFYING_FACTORY =
            createAscendedFactory(() -> AscendedTileEntityTypes.ASCENDED_PURIFYING_FACTORY, FactoryType.PURIFYING);
    public static final Factory<AscendedTEItemStackChemicalToItemStackFactory> ASCENDED_INJECTING_FACTORY =
            createAscendedFactory(() -> AscendedTileEntityTypes.ASCENDED_INJECTING_FACTORY, FactoryType.INJECTING);
    public static final Factory<AscendedTEItemStackChemicalToItemStackFactory> ASCENDED_INFUSING_FACTORY =
            createAscendedFactory(() -> AscendedTileEntityTypes.ASCENDED_INFUSING_FACTORY, FactoryType.INFUSING);
    public static final Factory<AscendedTESawingFactory> ASCENDED_SAWING_FACTORY =
            createAscendedFactory(() -> AscendedTileEntityTypes.ASCENDED_SAWING_FACTORY, FactoryType.SAWING);

    private static <TILE extends TileEntityFactory<?>> Factory<TILE> createAscendedFactory(java.util.function.Supplier<?> tileEntityRegistrar, FactoryType type) {
        Factory<TILE> factory = FactoryBuilder.<TILE>createFactory(tileEntityRegistrar, type, FactoryTier.ULTIMATE).build();
        factory.remove(AttributeUpgradeable.class);
        AttributeEnergy originalEnergy = type.getBaseMachine().get(AttributeEnergy.class);
        factory.add(new AttributeEnergy(
              originalEnergy::getUsage,
              () -> MathUtils.clampToLong(Math.max(originalEnergy.getConfigStorage() * 0.5, originalEnergy.getUsage()) * AscendedTierValues.ASCENDED_FACTORY_PROCESSES)
        ));
        return factory;
    }

    private AscendedBlockTypes() {}

}
