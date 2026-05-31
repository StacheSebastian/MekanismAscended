package net.stachesebastian.mekanismascended.common.content.network.transmitter;

import mekanism.api.Action;
import mekanism.common.content.network.transmitter.MechanicalPipe;
import mekanism.common.lib.transmitter.ConnectionType;
import mekanism.common.lib.transmitter.acceptor.AcceptorCache;
import mekanism.common.tile.transmitter.TileEntityTransmitter;
import mekanism.common.util.EnumUtils;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.stachesebastian.mekanismascended.common.tier.transmitter.AscendedTierValues;

public class AscendedMechanicalPipe extends MechanicalPipe {
    public AscendedMechanicalPipe(Holder<Block> blockProvider, TileEntityTransmitter tile) {
        super(blockProvider, tile);
    }

    @Override
    public long getCapacity() {
        return AscendedTierValues.ASCENDED_MECHANICAL_PIPE_CAPACITY;
    }


    @Override
    public void pullFromAcceptors() {
        if (!hasPullSide || getAvailablePull() <= 0) {
            return;
        }
        AcceptorCache<IFluidHandler> acceptorCache = getAcceptorCache();
        for (Direction side : EnumUtils.DIRECTIONS) {
            if (!isConnectionType(side, ConnectionType.PULL)) {
                continue;
            }
            IFluidHandler connectedAcceptor = acceptorCache.getConnectedAcceptor(side);
            if (connectedAcceptor != null) {
                FluidStack received;
                //Note: We recheck the buffer each time in case we ended up accepting fluid somewhere
                // and our buffer changed and is no longer empty
                FluidStack bufferWithFallback = getBufferWithFallback();
                if (bufferWithFallback.isEmpty()) {
                    //If we don't have a fluid stored try pulling as much as we are able to
                    received = connectedAcceptor.drain(getAvailablePull(), FluidAction.SIMULATE);
                } else {
                    //Otherwise, try draining the same type of fluid we have stored requesting up to as much as we are able to pull
                    // We do this to better support multiple tanks in case the fluid we have stored we could pull out of a block's
                    // second tank but just asking to drain a specific amount
                    received = connectedAcceptor.drain(bufferWithFallback.copyWithAmount(getAvailablePull()), FluidAction.SIMULATE);
                }
                if (!received.isEmpty() && takeFluid(received, Action.SIMULATE).isEmpty()) {
                    //If we received some fluid and are able to insert it all, then actually extract it and insert it into our thing.
                    // Note: We extract first after simulating ourselves because if the target gave a faulty simulation value, we want to handle it properly
                    // and not accidentally dupe anything, and we know our simulation we just performed on taking it is valid
                    takeFluid(connectedAcceptor.drain(received.copy(), FluidAction.EXECUTE), Action.EXECUTE);
                }
            }
        }
    }

    private int getAvailablePull() {
        if (hasTransmitterNetwork()) {
            return Math.min(AscendedTierValues.ASCENDED_MECHANICAL_PIPE_PULL_AMOUNT, getTransmitterNetwork().fluidTank.getNeeded());
        }
        return Math.min(AscendedTierValues.ASCENDED_MECHANICAL_PIPE_PULL_AMOUNT, buffer.getNeeded());
    }
}
