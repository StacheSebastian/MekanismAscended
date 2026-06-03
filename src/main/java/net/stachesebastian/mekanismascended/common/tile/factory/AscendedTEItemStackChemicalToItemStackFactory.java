package net.stachesebastian.mekanismascended.common.tile.factory;

import mekanism.common.tile.factory.TileEntityItemStackChemicalToItemStackFactory;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class AscendedTEItemStackChemicalToItemStackFactory extends TileEntityItemStackChemicalToItemStackFactory implements IAscendedFactoryTE {

    public AscendedTEItemStackChemicalToItemStackFactory(Holder<Block> blockProvider, BlockPos pos, BlockState state) {
        super(blockProvider, pos, state);
    }
}
