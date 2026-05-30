package net.stachesebastian.mekanismascended.common.registries;

import mekanism.common.block.transmitter.BlockSmallTransmitter;
import mekanism.common.registration.impl.BlockDeferredRegister;
import mekanism.common.registration.impl.BlockRegistryObject;
import net.neoforged.bus.api.IEventBus;
import net.stachesebastian.mekanismascended.MekanismAscended;
import net.stachesebastian.mekanismascended.common.item.block.transmitter.AscendedItemBlockUniversalCable;
import net.stachesebastian.mekanismascended.common.tile.transmitter.AscendedTEUniversalCable;

public class AscendedBlocks {
    public static final BlockDeferredRegister BLOCKS = new BlockDeferredRegister(MekanismAscended.MODID);

    public static final BlockRegistryObject<BlockSmallTransmitter<AscendedTEUniversalCable>, AscendedItemBlockUniversalCable> ASCENDED_UNIVERSAL_CABLE = BLOCKS.register("ascended_universal_cable", () -> new BlockSmallTransmitter<>(AscendedBlockTypes.ASCENDED_UNIVERSAL_CABLE), AscendedItemBlockUniversalCable::new);

    private AscendedBlocks() {}

    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
    }
}
