package net.stachesebastian.mekanismascended.common.tile.transmitter;

import mekanism.common.tile.transmitter.TileEntityLogisticalTransporter;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.stachesebastian.mekanismascended.common.content.network.transmitter.AscendedLogisticalTransporter;

public class AscendedTELogisticalTransporter extends TileEntityLogisticalTransporter {
    public AscendedTELogisticalTransporter(Holder<Block> blockProvider, BlockPos pos, BlockState state) {
        super(blockProvider, pos, state);
    }

    @Override
    protected AscendedLogisticalTransporter createTransmitter(Holder<Block> blockProvider) {
        return new AscendedLogisticalTransporter(blockProvider, this);
    }

    @Override
    public AscendedLogisticalTransporter getTransmitter() {
        return (AscendedLogisticalTransporter) super.getTransmitter();
    }
}
