package net.stachesebastian.mekanismascended.mixin;

import mekanism.common.content.network.transmitter.PressurizedTube;
import mekanism.common.tier.TubeTier;
import net.stachesebastian.mekanismascended.common.content.network.transmitter.IPressurizedTubeTierProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PressurizedTube.class)
public abstract class PressurizedTubeMixin {

    @Redirect(
          method = "getAvailablePull",
          at = @At(value = "INVOKE", target = "Lmekanism/common/tier/TubeTier;getTubePullAmount()J")
    )
    private long mekanismAscended$getTubePullAmount(TubeTier tier) {
        if (this instanceof IPressurizedTubeTierProvider provider) {
            return provider.getTubePullAmount();
        }
        return tier.getTubePullAmount();
    }
}
