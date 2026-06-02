package net.stachesebastian.mekanismascended.common.tile;

import mekanism.api.IContentsListener;
import mekanism.common.capabilities.energy.EnergyCubeEnergyContainer;
import mekanism.common.capabilities.holder.energy.EnergyContainerHelper;
import mekanism.common.capabilities.holder.energy.IEnergyContainerHolder;
import mekanism.common.tile.TileEntityEnergyCube;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.stachesebastian.mekanismascended.common.tier.AscendedTierValues;
import net.stachesebastian.mekanismascended.mixin.BasicEnergyContainerAccessor;
import net.stachesebastian.mekanismascended.mixin.EnergyCubeEnergyContainerAccessor;
import net.stachesebastian.mekanismascended.mixin.TileEntityEnergyCubeAccessor;
import org.jetbrains.annotations.NotNull;

public class AscendedTEEnergyCube extends TileEntityEnergyCube {

    public AscendedTEEnergyCube(Holder<Block> blockProvider, BlockPos pos, BlockState state) {
        super(blockProvider, pos, state);
    }

    @NotNull
    @Override
    protected IEnergyContainerHolder getInitialEnergyContainers(IContentsListener listener) {
        EnergyContainerHelper builder = EnergyContainerHelper.forSideWithConfig(this);
        EnergyCubeEnergyContainer energyContainer = EnergyCubeEnergyContainer.create(getTier(), listener);
        ((BasicEnergyContainerAccessor) (Object) energyContainer).mekanismAscended$setMaxEnergy(AscendedTierValues.ASCENDED_ENERGY_CUBE_CAPACITY);
        ((EnergyCubeEnergyContainerAccessor) (Object) energyContainer).mekanismAscended$setRate(() -> AscendedTierValues.ASCENDED_ENERGY_CUBE_OUTPUT);
        ((TileEntityEnergyCubeAccessor) this).mekanismAscended$setEnergyContainer(energyContainer);
        builder.addContainer(energyContainer);
        return builder.build();
    }
}
