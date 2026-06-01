package net.stachesebastian.mekanismascended.mixin;

import mekanism.common.capabilities.energy.BasicEnergyContainer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(BasicEnergyContainer.class)
public interface BasicEnergyContainerAccessor {

    @Mutable
    @Accessor("maxEnergy")
    void mekanismAscended$setMaxEnergy(long maxEnergy);
}
