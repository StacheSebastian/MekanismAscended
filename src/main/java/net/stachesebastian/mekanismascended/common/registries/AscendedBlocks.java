package net.stachesebastian.mekanismascended.common.registries;

import mekanism.common.block.transmitter.BlockLargeTransmitter;
import mekanism.common.block.transmitter.BlockSmallTransmitter;
import mekanism.common.registration.impl.BlockDeferredRegister;
import mekanism.common.registration.impl.BlockRegistryObject;
import net.neoforged.bus.api.IEventBus;
import net.stachesebastian.mekanismascended.MekanismAscended;
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

public class AscendedBlocks {
    public static final BlockDeferredRegister BLOCKS = new BlockDeferredRegister(MekanismAscended.MODID);

    public static final BlockRegistryObject<BlockSmallTransmitter<AscendedTEUniversalCable>, AscendedItemBlockUniversalCable> ASCENDED_UNIVERSAL_CABLE = BLOCKS.register("ascended_universal_cable", () -> new BlockSmallTransmitter<>(AscendedBlockTypes.ASCENDED_UNIVERSAL_CABLE), AscendedItemBlockUniversalCable::new);
    public static final BlockRegistryObject<BlockSmallTransmitter<AscendedTEPressurizedTube>, AscendedItemBlockPressurizedTube> ASCENDED_PRESSURIZED_TUBE = BLOCKS.register("ascended_pressurized_tube", () -> new BlockSmallTransmitter<>(AscendedBlockTypes.ASCENDED_PRESSURIZED_TUBE), AscendedItemBlockPressurizedTube::new);
    public static final BlockRegistryObject<BlockSmallTransmitter<AscendedTEThermodynamicConductor>, AscendedItemBlockThermodynamicConductor> ASCENDED_THERMODYNAMIC_CONDUCTOR = BLOCKS.register("ascended_thermodynamic_conductor", () -> new BlockSmallTransmitter<>(AscendedBlockTypes.ASCENDED_THERMODYNAMIC_CONDUCTOR), AscendedItemBlockThermodynamicConductor::new);

    public static final BlockRegistryObject<BlockLargeTransmitter<AscendedTEMechanicalPipe>, AscendedItemBlockMechanicalPipe> ASCENDED_MECHANICAL_PIPE = BLOCKS.register("ascended_mechanical_pipe", () -> new BlockLargeTransmitter<>(AscendedBlockTypes.ASCENDED_MECHANICAL_PIPE), AscendedItemBlockMechanicalPipe::new);
    public static final BlockRegistryObject<BlockLargeTransmitter<AscendedTELogisticalTransporter>, AscendedItemBlockLogisticalTransporter> ASCENDED_LOGISTICAL_TRANSPORTER = BLOCKS.register("ascended_logistical_transporter", () -> new BlockLargeTransmitter<>(AscendedBlockTypes.ASCENDED_LOGISTICAL_TRANSPORTER), AscendedItemBlockLogisticalTransporter::new);

    private AscendedBlocks() {}

    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
    }
}
