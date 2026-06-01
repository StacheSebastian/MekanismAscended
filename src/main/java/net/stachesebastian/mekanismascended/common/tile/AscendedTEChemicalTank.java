package net.stachesebastian.mekanismascended.common.tile;

import mekanism.api.IContentsListener;
import mekanism.api.chemical.IChemicalTank;
import mekanism.common.capabilities.holder.chemical.ChemicalTankHelper;
import mekanism.common.capabilities.holder.chemical.IChemicalTankHolder;
import mekanism.common.tile.TileEntityChemicalTank;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.stachesebastian.mekanismascended.common.capabilities.chemical.AscendedChemicalTankChemicalTank;
import net.stachesebastian.mekanismascended.mixin.TileEntityChemicalTankAccessor;
import org.jetbrains.annotations.Nullable;

public class AscendedTEChemicalTank extends TileEntityChemicalTank {

    public AscendedTEChemicalTank(Holder<Block> blockProvider, BlockPos pos, BlockState state) {
        super(blockProvider, pos, state);
    }

    @Override
    public @Nullable IChemicalTankHolder getInitialChemicalTanks(IContentsListener listener) {
        ChemicalTankHelper builder = ChemicalTankHelper.forSideWithConfig(this);
        IChemicalTank chemicalTank = AscendedChemicalTankChemicalTank.create(listener);
        ((TileEntityChemicalTankAccessor) this).mekanismAscended$setChemicalTank(chemicalTank);
        builder.addTank(chemicalTank);
        return builder.build();
    }
}
