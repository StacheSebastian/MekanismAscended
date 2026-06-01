package net.stachesebastian.mekanismascended.mixin;

import java.util.function.LongSupplier;
import mekanism.common.capabilities.energy.EnergyCubeEnergyContainer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(EnergyCubeEnergyContainer.class)
public interface EnergyCubeEnergyContainerAccessor {

    @Mutable
    @Accessor("rate")
    void mekanismAscended$setRate(LongSupplier rate);
}
