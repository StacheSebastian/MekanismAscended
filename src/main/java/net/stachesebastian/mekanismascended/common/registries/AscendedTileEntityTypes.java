package net.stachesebastian.mekanismascended.common.registries;

import mekanism.api.functions.ConstantPredicates;
import mekanism.common.Mekanism;
import mekanism.common.capabilities.Capabilities;
import mekanism.common.integration.computer.ComputerCapabilityHelper;
import mekanism.common.integration.energy.EnergyCompatUtils;
import mekanism.common.registration.impl.TileEntityTypeDeferredRegister;
import mekanism.common.registration.impl.TileEntityTypeRegistryObject;
import mekanism.common.tile.TileEntityBin;
import mekanism.common.tile.TileEntityEnergyCube;
import mekanism.common.tile.base.CapabilityTileEntity;
import mekanism.common.tile.base.TileEntityMekanism;
import mekanism.common.tile.TileEntityChemicalTank;
import mekanism.common.tile.TileEntityFluidTank;
import mekanism.common.tile.multiblock.TileEntityInductionCell;
import mekanism.common.tile.multiblock.TileEntityInductionProvider;
import mekanism.common.tile.factory.TileEntityFactory;
import mekanism.common.tile.transmitter.TileEntityTransmitter;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.stachesebastian.mekanismascended.MekanismAscended;
import net.stachesebastian.mekanismascended.common.tile.AscendedTEBin;
import net.stachesebastian.mekanismascended.common.tile.AscendedTEChemicalTank;
import net.stachesebastian.mekanismascended.common.tile.AscendedTEEnergyCube;
import net.stachesebastian.mekanismascended.common.tile.AscendedTEFluidTank;
import net.stachesebastian.mekanismascended.common.tile.factory.AscendedTECombiningFactory;
import net.stachesebastian.mekanismascended.common.tile.factory.AscendedTEItemStackChemicalToItemStackFactory;
import net.stachesebastian.mekanismascended.common.tile.factory.AscendedTEItemStackToItemStackFactory;
import net.stachesebastian.mekanismascended.common.tile.factory.AscendedTESawingFactory;
import net.stachesebastian.mekanismascended.common.tile.transmitter.AscendedTELogisticalTransporter;
import net.stachesebastian.mekanismascended.common.tile.transmitter.AscendedTEMechanicalPipe;
import net.stachesebastian.mekanismascended.common.tile.transmitter.AscendedTEPressurizedTube;
import net.stachesebastian.mekanismascended.common.tile.transmitter.AscendedTEThermodynamicConductor;
import net.stachesebastian.mekanismascended.common.tile.transmitter.AscendedTEUniversalCable;

public class AscendedTileEntityTypes {
    public static final TileEntityTypeDeferredRegister TILE_ENTITY_TYPES = new TileEntityTypeDeferredRegister(MekanismAscended.MODID);

    public static final TileEntityTypeRegistryObject<AscendedTEUniversalCable> ASCENDED_UNIVERSAL_CABLE = registerCable();
    public static final TileEntityTypeRegistryObject<AscendedTEMechanicalPipe> ASCENDED_MECHANICAL_PIPE = registerPipe();
    public static final TileEntityTypeRegistryObject<AscendedTEPressurizedTube> ASCENDED_PRESSURIZED_TUBE = registerTube();
    public static final TileEntityTypeRegistryObject<AscendedTEThermodynamicConductor> ASCENDED_THERMODYNAMIC_CONDUCTOR = registerConductor();
    public static final TileEntityTypeRegistryObject<AscendedTELogisticalTransporter> ASCENDED_LOGISTICAL_TRANSPORTER = registerTransporter();

    public static final TileEntityTypeRegistryObject<TileEntityFluidTank> ASCENDED_FLUID_TANK =
            TILE_ENTITY_TYPES.<TileEntityFluidTank>mekBuilder(AscendedBlocks.ASCENDED_FLUID_TANK, (pos, state) -> new AscendedTEFluidTank(AscendedBlocks.ASCENDED_FLUID_TANK, pos, state))
                    .clientTicker(TileEntityMekanism::tickClient)
                    .serverTicker(TileEntityMekanism::tickServer)
                    .withSimple(Capabilities.CONFIG_CARD)
                    .withSimple(Capabilities.CONFIGURABLE)
                    .build();

    public static final TileEntityTypeRegistryObject<TileEntityChemicalTank> ASCENDED_CHEMICAL_TANK =
            TILE_ENTITY_TYPES.<TileEntityChemicalTank>mekBuilder(AscendedBlocks.ASCENDED_CHEMICAL_TANK, (pos, state) -> new AscendedTEChemicalTank(AscendedBlocks.ASCENDED_CHEMICAL_TANK, pos, state))
                    .serverTicker(TileEntityMekanism::tickServer)
                    .withSimple(Capabilities.CONFIG_CARD)
                    .build();

    public static final TileEntityTypeRegistryObject<TileEntityEnergyCube> ASCENDED_ENERGY_CUBE =
            TILE_ENTITY_TYPES.<TileEntityEnergyCube>mekBuilder(AscendedBlocks.ASCENDED_ENERGY_CUBE, (pos, state) -> new AscendedTEEnergyCube(AscendedBlocks.ASCENDED_ENERGY_CUBE, pos, state))
                    .serverTicker(TileEntityMekanism::tickServer)
                    .withSimple(Capabilities.CONFIG_CARD)
                    .build();

    public static final TileEntityTypeRegistryObject<TileEntityInductionCell> ASCENDED_INDUCTION_CELL = TILE_ENTITY_TYPES.builder(AscendedBlocks.ASCENDED_INDUCTION_CELL, (pos, state) -> new TileEntityInductionCell(AscendedBlocks.ASCENDED_INDUCTION_CELL, pos, state)).build();
    public static final TileEntityTypeRegistryObject<TileEntityInductionProvider> ASCENDED_INDUCTION_PROVIDER = TILE_ENTITY_TYPES.builder(AscendedBlocks.ASCENDED_INDUCTION_PROVIDER, (pos, state) -> new TileEntityInductionProvider(AscendedBlocks.ASCENDED_INDUCTION_PROVIDER, pos, state)).build();

    public static final TileEntityTypeRegistryObject<TileEntityBin> ASCENDED_BIN =
            TILE_ENTITY_TYPES.<TileEntityBin>mekBuilder(AscendedBlocks.ASCENDED_BIN, (pos, state) -> new AscendedTEBin(AscendedBlocks.ASCENDED_BIN, pos, state))
                    .serverTicker(TileEntityMekanism::tickServer)
                    .withSimple(Capabilities.CONFIGURABLE)
                    .build();

    public static final TileEntityTypeRegistryObject<AscendedTEItemStackToItemStackFactory> ASCENDED_SMELTING_FACTORY =
            registerFactory(AscendedBlocks.ASCENDED_SMELTING_FACTORY, AscendedTEItemStackToItemStackFactory::new);
    public static final TileEntityTypeRegistryObject<AscendedTEItemStackToItemStackFactory> ASCENDED_ENRICHING_FACTORY =
            registerFactory(AscendedBlocks.ASCENDED_ENRICHING_FACTORY, AscendedTEItemStackToItemStackFactory::new);
    public static final TileEntityTypeRegistryObject<AscendedTEItemStackToItemStackFactory> ASCENDED_CRUSHING_FACTORY =
            registerFactory(AscendedBlocks.ASCENDED_CRUSHING_FACTORY, AscendedTEItemStackToItemStackFactory::new);
    public static final TileEntityTypeRegistryObject<AscendedTEItemStackChemicalToItemStackFactory> ASCENDED_COMPRESSING_FACTORY =
            registerFactory(AscendedBlocks.ASCENDED_COMPRESSING_FACTORY, AscendedTEItemStackChemicalToItemStackFactory::new);
    public static final TileEntityTypeRegistryObject<AscendedTECombiningFactory> ASCENDED_COMBINING_FACTORY =
            registerFactory(AscendedBlocks.ASCENDED_COMBINING_FACTORY, AscendedTECombiningFactory::new);
    public static final TileEntityTypeRegistryObject<AscendedTEItemStackChemicalToItemStackFactory> ASCENDED_PURIFYING_FACTORY =
            registerFactory(AscendedBlocks.ASCENDED_PURIFYING_FACTORY, AscendedTEItemStackChemicalToItemStackFactory::new);
    public static final TileEntityTypeRegistryObject<AscendedTEItemStackChemicalToItemStackFactory> ASCENDED_INJECTING_FACTORY =
            registerFactory(AscendedBlocks.ASCENDED_INJECTING_FACTORY, AscendedTEItemStackChemicalToItemStackFactory::new);
    public static final TileEntityTypeRegistryObject<AscendedTEItemStackChemicalToItemStackFactory> ASCENDED_INFUSING_FACTORY =
            registerFactory(AscendedBlocks.ASCENDED_INFUSING_FACTORY, AscendedTEItemStackChemicalToItemStackFactory::new);
    public static final TileEntityTypeRegistryObject<AscendedTESawingFactory> ASCENDED_SAWING_FACTORY =
            registerFactory(AscendedBlocks.ASCENDED_SAWING_FACTORY, AscendedTESawingFactory::new);

    private AscendedTileEntityTypes() {}

    public static void register(IEventBus modEventBus) {
        TILE_ENTITY_TYPES.register(modEventBus);
    }

    private static TileEntityTypeRegistryObject<AscendedTEUniversalCable> registerCable() {
        TileEntityTypeDeferredRegister.BlockEntityTypeBuilder<AscendedTEUniversalCable> builder = transmitterBuilder(AscendedBlocks.ASCENDED_UNIVERSAL_CABLE, AscendedTEUniversalCable::new);
        EnergyCompatUtils.addBlockCapabilities(builder);
        if (Mekanism.hooks.computerCompatEnabled()) {
            ComputerCapabilityHelper.addComputerCapabilities(builder, ConstantPredicates.ALWAYS_TRUE);
        }
        return builder.build();
    }

    private static TileEntityTypeRegistryObject<AscendedTEMechanicalPipe> registerPipe() {
        TileEntityTypeDeferredRegister.BlockEntityTypeBuilder<AscendedTEMechanicalPipe> builder = transmitterBuilder(AscendedBlocks.ASCENDED_MECHANICAL_PIPE, AscendedTEMechanicalPipe::new)
                .with(Capabilities.FLUID.block(), CapabilityTileEntity.FLUID_HANDLER_PROVIDER);
        if (Mekanism.hooks.computerCompatEnabled()) {
            ComputerCapabilityHelper.addComputerCapabilities(builder, ConstantPredicates.ALWAYS_TRUE);
        }
        return builder.build();
    }

    private static TileEntityTypeRegistryObject<AscendedTEPressurizedTube> registerTube() {
        TileEntityTypeDeferredRegister.BlockEntityTypeBuilder<AscendedTEPressurizedTube> builder = transmitterBuilder(AscendedBlocks.ASCENDED_PRESSURIZED_TUBE, AscendedTEPressurizedTube::new)
                .with(Capabilities.CHEMICAL.block(), CapabilityTileEntity.CHEMICAL_HANDLER_PROVIDER);
        if (Mekanism.hooks.computerCompatEnabled()) {
            ComputerCapabilityHelper.addComputerCapabilities(builder, ConstantPredicates.ALWAYS_TRUE);
        }
        return builder.build();
    }

    private static TileEntityTypeRegistryObject<AscendedTEThermodynamicConductor> registerConductor() {
        return transmitterBuilder(AscendedBlocks.ASCENDED_THERMODYNAMIC_CONDUCTOR, AscendedTEThermodynamicConductor::new)
                .with(Capabilities.HEAT, CapabilityTileEntity.HEAT_HANDLER_PROVIDER)
                .build();
    }

    private static TileEntityTypeRegistryObject<AscendedTELogisticalTransporter> registerTransporter() {
        return transmitterBuilder(AscendedBlocks.ASCENDED_LOGISTICAL_TRANSPORTER, AscendedTELogisticalTransporter::new)
                .clientTicker(AscendedTELogisticalTransporter::tickClient)
                .with(Capabilities.ITEM.block(), CapabilityTileEntity.ITEM_HANDLER_PROVIDER)
                .build();
    }

    private static <BE extends TileEntityTransmitter> TileEntityTypeDeferredRegister.BlockEntityTypeBuilder<BE> transmitterBuilder(DeferredHolder<Block, ?> block, BlockEntityFactory<BE> factory) {
        return TILE_ENTITY_TYPES.builder(block, (pos, state) -> factory.create(block, pos, state))
                .serverTicker(TileEntityTransmitter::tickServer)
                .withSimple(Capabilities.ALLOY_INTERACTION)
                .with(Capabilities.CONFIGURABLE, TileEntityTransmitter.CONFIGURABLE_PROVIDER);
    }

    private static <BE extends TileEntityFactory<?>> TileEntityTypeRegistryObject<BE> registerFactory(DeferredHolder<Block, ?> block, BlockEntityFactory<BE> factory) {
        return TILE_ENTITY_TYPES.mekBuilder(block, (pos, state) -> factory.create(block, pos, state))
                .clientTicker(TileEntityMekanism::tickClient)
                .serverTicker(TileEntityMekanism::tickServer)
                .withSimple(Capabilities.CONFIG_CARD)
                .build();
    }

    @FunctionalInterface
    private interface BlockEntityFactory<BE extends BlockEntity> {
        BE create(Holder<Block> blockProvider, BlockPos pos, BlockState state);
    }

}
