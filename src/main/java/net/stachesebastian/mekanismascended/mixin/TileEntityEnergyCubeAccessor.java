package net.stachesebastian.mekanismascended.mixin;

import mekanism.common.capabilities.energy.EnergyCubeEnergyContainer;
import mekanism.common.tile.TileEntityEnergyCube;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(TileEntityEnergyCube.class)
public interface TileEntityEnergyCubeAccessor {

    @Accessor("energyContainer")
    void mekanismAscended$setEnergyContainer(EnergyCubeEnergyContainer energyContainer);
}