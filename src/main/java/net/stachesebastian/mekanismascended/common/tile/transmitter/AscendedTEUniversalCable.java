package net.stachesebastian.mekanismascended.common.tile.transmitter;

import mekanism.common.content.network.transmitter.UniversalCable;
import mekanism.common.tile.transmitter.TileEntityUniversalCable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.stachesebastian.mekanismascended.common.content.network.transmitter.AscendedUniversalCable;

public class AscendedTEUniversalCable extends TileEntityUniversalCable {
    public AscendedTEUniversalCable(Holder<Block> blockProvider, BlockPos pos, BlockState state) {
        super(blockProvider, pos, state);
    }

    @Override
    protected UniversalCable createTransmitter(Holder<Block> blockProvider) {
        return new AscendedUniversalCable(blockProvider, this);
    }

    @Override
    public UniversalCable getTransmitter() {
        return (AscendedUniversalCable) super.getTransmitter();
    }
}
