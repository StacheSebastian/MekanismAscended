package net.stachesebastian.mekanismascended.common.content.network.transmitter;

import mekanism.common.content.network.transmitter.ThermodynamicConductor;
import mekanism.common.tile.transmitter.TileEntityTransmitter;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.stachesebastian.mekanismascended.common.tier.AscendedTierValues;

public class AscendedThermodynamicConductor extends ThermodynamicConductor implements IThermodynamicConductorTierProvider {
    public AscendedThermodynamicConductor(Holder<Block> blockProvider, TileEntityTransmitter tile) {
        super(blockProvider, tile);
    }

    @Override
    public double getHeatCapacity() {
        return AscendedTierValues.ascendedThermodynamicConductorHeatCapacity();
    }

    @Override
    public double getInverseConduction() {
        return AscendedTierValues.ascendedThermodynamicConductorConduction();
    }

    @Override
    public double getInverseConductionInsulation() {
        return AscendedTierValues.ascendedThermodynamicConductorInsulation();
    }
}
