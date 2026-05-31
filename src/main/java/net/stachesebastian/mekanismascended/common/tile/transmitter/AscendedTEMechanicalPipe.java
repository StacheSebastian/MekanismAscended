package net.stachesebastian.mekanismascended.common.tile.transmitter;

import mekanism.common.content.network.transmitter.MechanicalPipe;
import mekanism.common.tile.transmitter.TileEntityMechanicalPipe;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.stachesebastian.mekanismascended.common.content.network.transmitter.AscendedMechanicalPipe;

public class AscendedTEMechanicalPipe extends TileEntityMechanicalPipe {
    public AscendedTEMechanicalPipe(Holder<Block> blockProvider, BlockPos pos, BlockState state) {
        super(blockProvider, pos, state);
    }

    @Override
    protected MechanicalPipe createTransmitter(Holder<Block> blockProvider) {
        return new AscendedMechanicalPipe(blockProvider, this);
    }

    @Override
    public MechanicalPipe getTransmitter() {
        return (AscendedMechanicalPipe) super.getTransmitter();
    }
}
