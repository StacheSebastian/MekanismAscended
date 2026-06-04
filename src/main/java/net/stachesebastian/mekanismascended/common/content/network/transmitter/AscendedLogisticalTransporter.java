package net.stachesebastian.mekanismascended.common.content.network.transmitter;

import mekanism.common.content.network.transmitter.LogisticalTransporter;
import mekanism.common.tier.TransporterTier;
import mekanism.common.tile.transmitter.TileEntityTransmitter;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.stachesebastian.mekanismascended.common.tier.AscendedTierValues;

public class AscendedLogisticalTransporter extends LogisticalTransporter implements ILogisticalTransporterTierProvider {

    public AscendedLogisticalTransporter(Holder<Block> blockProvider, TileEntityTransmitter tile) {
        super(blockProvider, tile);
    }

    @Override
    public int getTransporterSpeed() {
        return AscendedTierValues.ascendedLogisticalTransporterSpeed();
    }

    @Override
    public int getTransporterPullAmount() {
        return AscendedTierValues.ascendedLogisticalTransporterPullAmount();
    }

    @Override
    public int getTransporterPullDelay() {
        return AscendedTierValues.ascendedLogisticalTransporterPullDelay();
    }

    @Override
    public double getCost() {
        return TransporterTier.ULTIMATE.getSpeed() / (double) getTransporterSpeed();
    }
}
