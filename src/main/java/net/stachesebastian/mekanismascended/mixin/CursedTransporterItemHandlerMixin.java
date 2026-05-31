package net.stachesebastian.mekanismascended.mixin;

import mekanism.common.capabilities.item.CursedTransporterItemHandler;
import mekanism.common.content.network.transmitter.LogisticalTransporterBase;
import mekanism.common.tier.TransporterTier;
import net.stachesebastian.mekanismascended.common.content.network.transmitter.ILogisticalTransporterTierProvider;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(CursedTransporterItemHandler.class)
public abstract class CursedTransporterItemHandlerMixin {

    @Shadow
    @Final
    private LogisticalTransporterBase transporter;

    @Redirect(
          method = "getSlotLimit",
          at = @At(value = "INVOKE", target = "Lmekanism/common/tier/TransporterTier;getPullAmount()I")
    )
    private int mekanismAscended$getTransporterPullAmount(TransporterTier tier) {
        if (transporter instanceof ILogisticalTransporterTierProvider provider) {
            return provider.getTransporterPullAmount();
        }
        return tier.getPullAmount();
    }
}
