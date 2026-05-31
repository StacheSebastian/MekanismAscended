package net.stachesebastian.mekanismascended.common.tile.transmitter;

import mekanism.common.content.network.transmitter.PressurizedTube;
import mekanism.common.tile.transmitter.TileEntityPressurizedTube;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.stachesebastian.mekanismascended.common.content.network.transmitter.AscendedPressurizedTube;

public class AscendedTEPressurizedTube extends TileEntityPressurizedTube {
    public AscendedTEPressurizedTube(Holder<Block> blockProvider, BlockPos pos, BlockState state) {
        super(blockProvider, pos, state);
    }

    @Override
    protected PressurizedTube createTransmitter(Holder<Block> blockProvider) {
        return new AscendedPressurizedTube(blockProvider, this);
    }

    @Override
    public PressurizedTube getTransmitter() {
        return (AscendedPressurizedTube) super.getTransmitter();
    }
}
