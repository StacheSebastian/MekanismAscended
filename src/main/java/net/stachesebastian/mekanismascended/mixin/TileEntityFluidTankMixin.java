package net.stachesebastian.mekanismascended.mixin;

import mekanism.common.tier.FluidTankTier;
import mekanism.common.tile.TileEntityFluidTank;
import net.stachesebastian.mekanismascended.common.tier.AscendedTierValues;
import net.stachesebastian.mekanismascended.common.tile.AscendedTEFluidTank;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(TileEntityFluidTank.class)
public abstract class TileEntityFluidTankMixin {

    @Redirect(method = "onUpdateServer", at = @At(value = "INVOKE", target = "Lmekanism/common/tier/FluidTankTier;getOutput()I"))
    private int mekanismAscended$getOutput(FluidTankTier tier) {
        return (Object) this instanceof AscendedTEFluidTank ? AscendedTierValues.ASCENDED_FLUID_TANK_OUTPUT : tier.getOutput();
    }
}
