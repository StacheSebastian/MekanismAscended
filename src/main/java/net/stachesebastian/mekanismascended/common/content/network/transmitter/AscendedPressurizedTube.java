package net.stachesebastian.mekanismascended.common.content.network.transmitter;

import mekanism.common.content.network.transmitter.PressurizedTube;
import mekanism.common.tile.transmitter.TileEntityTransmitter;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.stachesebastian.mekanismascended.common.tier.transmitter.AscendedTierValues;

public class AscendedPressurizedTube extends PressurizedTube implements IPressurizedTubeTierProvider {
    public AscendedPressurizedTube(Holder<Block> blockProvider, TileEntityTransmitter tile) {
        super(blockProvider, tile);
    }

    @Override
    public long getCapacity() {
        return AscendedTierValues.ASCENDED_PRESSURIZED_TUBE_CAPACITY;
    }

    @Override
    public long getTubePullAmount() {
        return AscendedTierValues.ASCENDED_PRESSURIZED_TUBE_PULL_AMOUNT;
    }
}
