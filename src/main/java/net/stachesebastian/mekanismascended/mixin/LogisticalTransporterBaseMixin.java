package net.stachesebastian.mekanismascended.mixin;

import mekanism.common.content.network.transmitter.LogisticalTransporterBase;
import mekanism.common.tier.TransporterTier;
import net.stachesebastian.mekanismascended.common.content.network.transmitter.ILogisticalTransporterTierProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LogisticalTransporterBase.class)
public abstract class LogisticalTransporterBaseMixin {

    @Redirect(
          method = {"onUpdateClient", "onUpdateServer"},
          at = @At(value = "INVOKE", target = "Lmekanism/common/tier/TransporterTier;getSpeed()I")
    )
    private int mekanismAscended$getTransporterSpeed(TransporterTier tier) {
        if (this instanceof ILogisticalTransporterTierProvider provider) {
            return provider.getTransporterSpeed();
        }
        return tier.getSpeed();
    }

    @Redirect(
          method = "onUpdateServer",
          at = @At(value = "INVOKE", target = "Lmekanism/common/tier/TransporterTier;getPullAmount()I")
    )
    private int mekanismAscended$getTransporterPullAmount(TransporterTier tier) {
        if (this instanceof ILogisticalTransporterTierProvider provider) {
            return provider.getTransporterPullAmount();
        }
        return tier.getPullAmount();
    }
}
