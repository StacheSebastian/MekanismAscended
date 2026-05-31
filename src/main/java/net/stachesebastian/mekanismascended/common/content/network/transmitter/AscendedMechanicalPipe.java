package net.stachesebastian.mekanismascended.common.content.network.transmitter;

import mekanism.common.content.network.transmitter.MechanicalPipe;
import mekanism.common.tile.transmitter.TileEntityTransmitter;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.stachesebastian.mekanismascended.common.tier.transmitter.AscendedTierValues;

public class AscendedMechanicalPipe extends MechanicalPipe implements IMechanicalPipeTierProvider {
    public AscendedMechanicalPipe(Holder<Block> blockProvider, TileEntityTransmitter tile) {
        super(blockProvider, tile);
    }

    @Override
    public long getCapacity() {
        return AscendedTierValues.ASCENDED_MECHANICAL_PIPE_CAPACITY;
    }

    @Override
    public int getPipePullAmount() {
        return AscendedTierValues.ASCENDED_MECHANICAL_PIPE_PULL_AMOUNT;
    }
}
