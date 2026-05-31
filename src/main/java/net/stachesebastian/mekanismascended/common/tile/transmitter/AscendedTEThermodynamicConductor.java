package net.stachesebastian.mekanismascended.common.tile.transmitter;

import mekanism.common.content.network.transmitter.ThermodynamicConductor;
import mekanism.common.tile.transmitter.TileEntityThermodynamicConductor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.stachesebastian.mekanismascended.common.content.network.transmitter.AscendedThermodynamicConductor;

public class AscendedTEThermodynamicConductor extends TileEntityThermodynamicConductor {
    public AscendedTEThermodynamicConductor(Holder<Block> blockProvider, BlockPos pos, BlockState state) {
        super(blockProvider, pos, state);
    }

    @Override
    protected ThermodynamicConductor createTransmitter(Holder<Block> blockProvider) {
        return new AscendedThermodynamicConductor(blockProvider, this);
    }

    @Override
    public ThermodynamicConductor getTransmitter() {
        return (AscendedThermodynamicConductor) super.getTransmitter();
    }
}
