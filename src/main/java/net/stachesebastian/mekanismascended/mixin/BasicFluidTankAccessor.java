package net.stachesebastian.mekanismascended.mixin;

import mekanism.common.capabilities.fluid.BasicFluidTank;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(BasicFluidTank.class)
public interface BasicFluidTankAccessor {

    @Mutable
    @Accessor("capacity")
    void mekanismAscended$setCapacity(int capacity);
}
