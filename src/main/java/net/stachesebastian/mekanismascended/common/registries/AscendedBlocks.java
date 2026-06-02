package net.stachesebastian.mekanismascended.common.registries;

import mekanism.api.tier.ITier;
import mekanism.common.attachments.containers.ContainerType;
import mekanism.common.attachments.containers.chemical.ChemicalTanksBuilder;
import mekanism.common.attachments.containers.fluid.FluidTanksBuilder;
import mekanism.common.attachments.containers.item.ItemSlotsBuilder;
import mekanism.common.block.BlockEnergyCube;
import mekanism.common.block.attribute.AttributeTier;
import mekanism.common.block.basic.BlockFluidTank;
import mekanism.common.block.prefab.BlockTile;
import mekanism.common.block.transmitter.BlockLargeTransmitter;
import mekanism.common.block.transmitter.BlockSmallTransmitter;
import mekanism.common.content.blocktype.BlockType;
import mekanism.common.content.blocktype.BlockTypeTile;
import mekanism.common.content.blocktype.Machine;
import mekanism.common.item.block.ItemBlockInductionCell;
import mekanism.common.item.block.ItemBlockInductionProvider;
import mekanism.common.registration.impl.BlockDeferredRegister;
import mekanism.common.registration.impl.BlockRegistryObject;
import mekanism.common.registries.MekanismBlockTypes;
import mekanism.common.tile.TileEntityChemicalTank;
import mekanism.common.tile.TileEntityEnergyCube;
import mekanism.common.tile.TileEntityFluidTank;
import mekanism.common.tile.multiblock.TileEntityInductionCell;
import mekanism.common.tile.multiblock.TileEntityInductionProvider;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.stachesebastian.mekanismascended.MekanismAscended;
import net.stachesebastian.mekanismascended.common.attachments.containers.chemical.AscendedComponentBackedChemicalTank;
import net.stachesebastian.mekanismascended.common.attachments.containers.fluid.AscendedComponentBackedFluidTank;
import net.stachesebastian.mekanismascended.common.item.block.*;
import net.stachesebastian.mekanismascended.common.item.block.transmitter.AscendedItemBlockLogisticalTransporter;
import net.stachesebastian.mekanismascended.common.item.block.transmitter.AscendedItemBlockMechanicalPipe;
import net.stachesebastian.mekanismascended.common.item.block.transmitter.AscendedItemBlockPressurizedTube;
import net.stachesebastian.mekanismascended.common.item.block.transmitter.AscendedItemBlockThermodynamicConductor;
import net.stachesebastian.mekanismascended.common.item.block.transmitter.AscendedItemBlockUniversalCable;
import net.stachesebastian.mekanismascended.common.tile.transmitter.AscendedTELogisticalTransporter;
import net.stachesebastian.mekanismascended.common.tile.transmitter.AscendedTEMechanicalPipe;
import net.stachesebastian.mekanismascended.common.tile.transmitter.AscendedTEPressurizedTube;
import net.stachesebastian.mekanismascended.common.tile.transmitter.AscendedTEThermodynamicConductor;
import net.stachesebastian.mekanismascended.common.tile.transmitter.AscendedTEUniversalCable;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class AscendedBlocks {
    public static final BlockDeferredRegister BLOCKS = new BlockDeferredRegister(MekanismAscended.MODID);

    public static final BlockRegistryObject<BlockSmallTransmitter<AscendedTEUniversalCable>, AscendedItemBlockUniversalCable> ASCENDED_UNIVERSAL_CABLE = BLOCKS.register("ascended_universal_cable", () -> new BlockSmallTransmitter<>(AscendedBlockTypes.ASCENDED_UNIVERSAL_CABLE), AscendedItemBlockUniversalCable::new);
    public static final BlockRegistryObject<BlockSmallTransmitter<AscendedTEPressurizedTube>, AscendedItemBlockPressurizedTube> ASCENDED_PRESSURIZED_TUBE = BLOCKS.register("ascended_pressurized_tube", () -> new BlockSmallTransmitter<>(AscendedBlockTypes.ASCENDED_PRESSURIZED_TUBE), AscendedItemBlockPressurizedTube::new);
    public static final BlockRegistryObject<BlockSmallTransmitter<AscendedTEThermodynamicConductor>, AscendedItemBlockThermodynamicConductor> ASCENDED_THERMODYNAMIC_CONDUCTOR = BLOCKS.register("ascended_thermodynamic_conductor", () -> new BlockSmallTransmitter<>(AscendedBlockTypes.ASCENDED_THERMODYNAMIC_CONDUCTOR), AscendedItemBlockThermodynamicConductor::new);

    public static final BlockRegistryObject<BlockLargeTransmitter<AscendedTEMechanicalPipe>, AscendedItemBlockMechanicalPipe> ASCENDED_MECHANICAL_PIPE = BLOCKS.register("ascended_mechanical_pipe", () -> new BlockLargeTransmitter<>(AscendedBlockTypes.ASCENDED_MECHANICAL_PIPE), AscendedItemBlockMechanicalPipe::new);
    public static final BlockRegistryObject<BlockLargeTransmitter<AscendedTELogisticalTransporter>, AscendedItemBlockLogisticalTransporter> ASCENDED_LOGISTICAL_TRANSPORTER = BLOCKS.register("ascended_logistical_transporter", () -> new BlockLargeTransmitter<>(AscendedBlockTypes.ASCENDED_LOGISTICAL_TRANSPORTER), AscendedItemBlockLogisticalTransporter::new);

    public static final BlockRegistryObject<BlockFluidTank, AscendedItemBlockFluidTank> ASCENDED_FLUID_TANK = BLOCKS.register("ascended_fluid_tank", () -> new BlockFluidTank(AscendedBlockTypes.ASCENDED_FLUID_TANK), AscendedItemBlockFluidTank::new)
            .forItemHolder(holder -> holder
                    .addAttachedContainerCapabilities(ContainerType.FLUID, () -> FluidTanksBuilder.builder()
                            .addTank(AscendedComponentBackedFluidTank::create)
                            .build()
                    ).addAttachmentOnlyContainers(ContainerType.ITEM, () -> ItemSlotsBuilder.builder()
                            .addFluidInputSlot(0)
                            .addOutput()
                            .build()
                    )
            );

    public static final BlockRegistryObject<BlockTile.BlockTileModel<TileEntityChemicalTank, Machine<TileEntityChemicalTank>>, AscendedItemBlockChemicalTank> ASCENDED_CHEMICAL_TANK = BLOCKS.register("ascended_chemical_tank", () -> new BlockTile.BlockTileModel<>(AscendedBlockTypes.ASCENDED_CHEMICAL_TANK, properties -> properties.mapColor(MapColor.GOLD)), AscendedItemBlockChemicalTank::new)
            .forItemHolder(holder -> holder
                    .addAttachedContainerCapabilities(ContainerType.CHEMICAL, () -> ChemicalTanksBuilder.builder()
                            .addTank(AscendedComponentBackedChemicalTank::create).build()
                    ).addAttachmentOnlyContainers(ContainerType.ITEM, () -> ItemSlotsBuilder.builder()
                            .addChemicalDrainSlot(0)
                            .addChemicalFillSlot(0)
                            .build()
                    )
            );

    public static final BlockRegistryObject<BlockEnergyCube, AscendedItemBlockEnergyCube> ASCENDED_ENERGY_CUBE = BLOCKS.register("ascended_energy_cube", () -> new BlockEnergyCube(AscendedBlockTypes.ASCENDED_ENERGY_CUBE), AscendedItemBlockEnergyCube::new)
            .forItemHolder(holder -> holder
                    .addAttachmentOnlyContainers(ContainerType.ITEM, () -> ItemSlotsBuilder.builder()
                            .addEnergy()
                            .addDrainEnergy()
                            .build()
            ));

    public static final BlockRegistryObject<BlockTile<TileEntityInductionCell, BlockTypeTile<TileEntityInductionCell>>, AscendedItemBlockInductionCell> ASCENDED_INDUCTION_CELL = BLOCKS.register("ascended_induction_cell", () -> new BlockTile.BlockTileModel<>(AscendedBlockTypes.ASCENDED_INDUCTION_CELL, properties -> properties.mapColor(MapColor.GOLD)), AscendedItemBlockInductionCell::new);
    public static final BlockRegistryObject<BlockTile<TileEntityInductionProvider, BlockTypeTile<TileEntityInductionProvider>>, AscendedItemBlockInductionProvider> ASCENDED_INDUCTION_PROVIDER = BLOCKS.register("ascended_induction_provider", () -> new BlockTile.BlockTileModel<>(AscendedBlockTypes.ASCENDED_INDUCTION_PROVIDER, properties -> properties.mapColor(MapColor.GOLD)), AscendedItemBlockInductionProvider::new);


    private AscendedBlocks() {}

    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
    }
}
