package net.stachesebastian.mekanismascended.mixin;

import mekanism.common.content.network.transmitter.MechanicalPipe;
import mekanism.common.tier.PipeTier;
import net.stachesebastian.mekanismascended.common.content.network.transmitter.IMechanicalPipeTierProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(MechanicalPipe.class)
public abstract class MechanicalPipeMixin {

    @Redirect(
          method = "getAvailablePull",
          at = @At(value = "INVOKE", target = "Lmekanism/common/tier/PipeTier;getPipePullAmount()I")
    )
    private int mekanismAscended$getPipePullAmount(PipeTier tier) {
        if (this instanceof IMechanicalPipeTierProvider provider) {
            return provider.getPipePullAmount();
        }
        return tier.getPipePullAmount();
    }
}
