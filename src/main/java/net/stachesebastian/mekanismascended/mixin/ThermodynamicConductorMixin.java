package net.stachesebastian.mekanismascended.mixin;

import java.util.function.DoubleSupplier;
import mekanism.api.IContentsListener;
import mekanism.common.capabilities.heat.VariableHeatCapacitor;
import mekanism.common.content.network.transmitter.ThermodynamicConductor;
import net.stachesebastian.mekanismascended.common.content.network.transmitter.IThermodynamicConductorTierProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ThermodynamicConductor.class)
public abstract class ThermodynamicConductorMixin {

    @Redirect(
          method = "<init>",
          at = @At(
                value = "INVOKE",
                target = "Lmekanism/common/capabilities/heat/VariableHeatCapacitor;create(DLjava/util/function/DoubleSupplier;Ljava/util/function/DoubleSupplier;Ljava/util/function/DoubleSupplier;Lmekanism/api/IContentsListener;)Lmekanism/common/capabilities/heat/VariableHeatCapacitor;"
          )
    )
    private VariableHeatCapacitor mekanismAscended$createBuffer(double heatCapacity, DoubleSupplier inverseConduction,
          DoubleSupplier inverseInsulation, DoubleSupplier ambientTemperature, IContentsListener listener) {
        if (this instanceof IThermodynamicConductorTierProvider provider) {
            return VariableHeatCapacitor.create(provider.getHeatCapacity(), provider::getInverseConduction,
                  provider::getInverseConductionInsulation, ambientTemperature, listener);
        }
        return VariableHeatCapacitor.create(heatCapacity, inverseConduction, inverseInsulation, ambientTemperature, listener);
    }
}
