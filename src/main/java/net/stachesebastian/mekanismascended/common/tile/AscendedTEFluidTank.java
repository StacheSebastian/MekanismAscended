package net.stachesebastian.mekanismascended.common.tile;

import mekanism.common.tile.TileEntityFluidTank;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class AscendedTEFluidTank extends TileEntityFluidTank {

    public AscendedTEFluidTank(Holder<Block> blockProvider, BlockPos pos, BlockState state) {
        super(blockProvider, pos, state);
    }
}
