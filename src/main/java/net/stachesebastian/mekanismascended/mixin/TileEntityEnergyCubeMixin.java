package net.stachesebastian.mekanismascended.mixin;

import mekanism.common.tier.EnergyCubeTier;
import mekanism.common.tile.TileEntityEnergyCube;
import net.stachesebastian.mekanismascended.common.tier.AscendedTierValues;
import net.stachesebastian.mekanismascended.common.tile.AscendedTEEnergyCube;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(TileEntityEnergyCube.class)
public abstract class TileEntityEnergyCubeMixin {

    @Redirect(method = "lambda$new$0", at = @At(value = "INVOKE", target = "Lmekanism/common/tier/EnergyCubeTier;getOutput()J"))
    private long mekanismAscended$getOutput(EnergyCubeTier tier) {
        return (Object) this instanceof AscendedTEEnergyCube ? AscendedTierValues.ascendedEnergyCubeOutput() : tier.getOutput();
    }
}
