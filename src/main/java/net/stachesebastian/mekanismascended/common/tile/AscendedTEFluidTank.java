package net.stachesebastian.mekanismascended.common.tile;

import mekanism.api.IContentsListener;
import mekanism.common.capabilities.fluid.FluidTankFluidTank;
import mekanism.common.capabilities.holder.fluid.FluidTankHelper;
import mekanism.common.capabilities.holder.fluid.IFluidTankHolder;
import mekanism.common.tile.TileEntityFluidTank;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.stachesebastian.mekanismascended.common.tier.AscendedTierValues;
import net.stachesebastian.mekanismascended.mixin.BasicFluidTankAccessor;
import net.stachesebastian.mekanismascended.mixin.FluidTankFluidTankAccessor;
import org.jetbrains.annotations.NotNull;

public class AscendedTEFluidTank extends TileEntityFluidTank {

    public AscendedTEFluidTank(Holder<Block> blockProvider, BlockPos pos, BlockState state) {
        super(blockProvider, pos, state);
    }

    @NotNull
    @Override
    protected IFluidTankHolder getInitialFluidTanks(IContentsListener listener) {
        FluidTankHelper builder = FluidTankHelper.forSide(facingSupplier);
        FluidTankFluidTank tank = FluidTankFluidTank.create(this, listener);
        ((BasicFluidTankAccessor) tank).mekanismAscended$setCapacity(AscendedTierValues.ascendedFluidTankCapacity());
        ((FluidTankFluidTankAccessor) tank).mekanismAscended$setRate(AscendedTierValues::ascendedFluidTankOutput);
        fluidTank = tank;
        builder.addTank(tank);
        return builder.build();
    }
}
