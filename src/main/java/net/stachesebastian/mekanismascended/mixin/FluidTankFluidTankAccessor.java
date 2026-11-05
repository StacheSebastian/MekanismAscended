package net.stachesebastian.mekanismascended.mixin;

import java.util.function.IntSupplier;
import mekanism.common.capabilities.fluid.FluidTankFluidTank;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(FluidTankFluidTank.class)
public interface FluidTankFluidTankAccessor {

    @Mutable
    @Accessor("rate")
    void mekanismAscended$setRate(IntSupplier rate);
}
