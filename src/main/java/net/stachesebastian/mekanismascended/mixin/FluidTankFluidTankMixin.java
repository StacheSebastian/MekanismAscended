package net.stachesebastian.mekanismascended.mixin;

import java.util.function.IntSupplier;
import mekanism.api.IContentsListener;
import mekanism.common.capabilities.fluid.FluidTankFluidTank;
import mekanism.common.tile.TileEntityFluidTank;
import net.stachesebastian.mekanismascended.common.tier.AscendedTierValues;
import net.stachesebastian.mekanismascended.common.tile.AscendedTEFluidTank;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FluidTankFluidTank.class)
public abstract class FluidTankFluidTankMixin {

    @Mutable
    @Final
    @Shadow
    private IntSupplier rate;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void mekanismAscended$applyTankValues(TileEntityFluidTank tile, IContentsListener listener, CallbackInfo ci) {
        if (tile instanceof AscendedTEFluidTank) {
            ((BasicFluidTankAccessor) this).mekanismAscended$setCapacity(AscendedTierValues.ASCENDED_FLUID_TANK_CAPACITY);
            rate = () -> AscendedTierValues.ASCENDED_FLUID_TANK_OUTPUT;
        }
    }
}
