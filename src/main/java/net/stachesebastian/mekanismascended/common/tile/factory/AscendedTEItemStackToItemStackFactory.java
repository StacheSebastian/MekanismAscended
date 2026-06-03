package net.stachesebastian.mekanismascended.common.tile.factory;

import mekanism.common.tile.factory.TileEntityItemStackToItemStackFactory;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class AscendedTEItemStackToItemStackFactory extends TileEntityItemStackToItemStackFactory implements IAscendedFactoryTE {

    public AscendedTEItemStackToItemStackFactory(Holder<Block> blockProvider, BlockPos pos, BlockState state) {
        super(blockProvider, pos, state);
    }
}
