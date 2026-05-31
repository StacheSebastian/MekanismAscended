package net.stachesebastian.mekanismascended.common.content.network.transmitter;

import mekanism.api.Action;
import mekanism.api.AutomationType;
import mekanism.api.chemical.ChemicalStack;
import mekanism.api.chemical.IChemicalHandler;
import mekanism.api.chemical.IChemicalTank;
import mekanism.common.content.network.transmitter.PressurizedTube;
import mekanism.common.lib.transmitter.ConnectionType;
import mekanism.common.lib.transmitter.acceptor.AcceptorCache;
import mekanism.common.tile.transmitter.TileEntityTransmitter;
import mekanism.common.util.EnumUtils;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.stachesebastian.mekanismascended.common.tier.transmitter.AscendedTierValues;

public class AscendedPressurizedTube extends PressurizedTube {
    public AscendedPressurizedTube(Holder<Block> blockProvider, TileEntityTransmitter tile) {
        super(blockProvider, tile);
    }

    @Override
    public long getCapacity() {
        return AscendedTierValues.ASCENDED_PRESSURIZED_TUBE_CAPACITY;
    }

    @Override
    public void pullFromAcceptors() {
        if (!hasPullSide || getAvailablePull() <= 0) {
            return;
        }
        AcceptorCache<IChemicalHandler> acceptorCache = getAcceptorCache();
        for (Direction side : EnumUtils.DIRECTIONS) {
            if (!isConnectionType(side, ConnectionType.PULL)) {
                continue;
            }
            IChemicalHandler connectedAcceptor = acceptorCache.getConnectedAcceptor(side);
            if (connectedAcceptor != null) {
                //Note: We recheck the buffer each time in case we ended up accepting chemical somewhere
                // and our buffer changed and is no longer empty
                ChemicalStack bufferWithFallback = getBufferWithFallback();
                pullFromAcceptor(connectedAcceptor, bufferWithFallback, bufferWithFallback.isEmpty());
            }
        }
    }

    /**
     * @param connectedAcceptor  The acceptor
     * @param bufferWithFallback The buffer of the network
     * @param bufferIsEmpty      {@code true} if the buffer is empty, {@code false} otherwise
     *
     * @return {@code true} if we successfully pulled a chemical, {@code false} if we were unable to pull a chemical.
     */
    private boolean pullFromAcceptor(IChemicalHandler connectedAcceptor, ChemicalStack bufferWithFallback, boolean bufferIsEmpty) {
        if (connectedAcceptor == null) {
            return false;
        }
        long availablePull = getAvailablePull();
        ChemicalStack received;
        if (bufferIsEmpty) {
            //If we don't have a chemical stored try pulling as much as we are able to
            received = connectedAcceptor.extractChemical(availablePull, Action.SIMULATE);
        } else {
            //Otherwise, try draining the same type of chemical we have stored requesting up to as much as we are able to pull
            // We do this to better support multiple tanks in case the chemical we have stored we could pull out of a block's
            // second tank but just asking to drain a specific amount
            received = connectedAcceptor.extractChemical(bufferWithFallback.copyWithAmount(availablePull), Action.SIMULATE);
        }
        if (!received.isEmpty() && takeChemical(received, Action.SIMULATE).isEmpty()) {
            //If we received some chemical and are able to insert it all, then actually extract it and insert it into our thing.
            // Note: We extract first after simulating ourselves because if the target gave a faulty simulation value, we want to handle it properly
            // and not accidentally dupe anything, and we know our simulation we just performed on taking it is valid
            takeChemical(connectedAcceptor.extractChemical(received, Action.EXECUTE), Action.EXECUTE);
            return true;
        }
        return false;
    }

    private long getAvailablePull() {
        if (hasTransmitterNetwork()) {
            return Math.min(AscendedTierValues.ASCENDED_PRESSURIZED_TUBE_PULL_AMOUNT, getTransmitterNetwork().chemicalTank.getNeeded());
        }
        return Math.min(AscendedTierValues.ASCENDED_PRESSURIZED_TUBE_PULL_AMOUNT, chemicalTank.getNeeded());
    }

    private ChemicalStack takeChemical(ChemicalStack stack, Action action) {
        IChemicalTank tank;
        if (hasTransmitterNetwork()) {
            tank = getTransmitterNetwork().chemicalTank;
        } else {
            tank = chemicalTank;
        }
        return tank.insert(stack, action, AutomationType.INTERNAL);
    }
}
