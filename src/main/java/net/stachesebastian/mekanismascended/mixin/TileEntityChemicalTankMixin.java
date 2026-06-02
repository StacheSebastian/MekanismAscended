package net.stachesebastian.mekanismascended.mixin;

import mekanism.common.tier.ChemicalTankTier;
import mekanism.common.tile.TileEntityChemicalTank;
import net.stachesebastian.mekanismascended.common.tier.AscendedTierValues;
import net.stachesebastian.mekanismascended.common.tile.AscendedTEChemicalTank;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(TileEntityChemicalTank.class)
public abstract class TileEntityChemicalTankMixin {

    @Redirect(method = {"onUpdateServer", "lambda$new$0"}, at = @At(value = "INVOKE", target = "Lmekanism/common/tier/ChemicalTankTier;getOutput()J"))
    private long mekanismAscended$getOutput(ChemicalTankTier tier) {
        return (Object) this instanceof AscendedTEChemicalTank ? AscendedTierValues.ASCENDED_CHEMICAL_TANK_OUTPUT : tier.getOutput();
    }

    @Redirect(method = "onUpdateServer", at = @At(value = "INVOKE", target = "Lmekanism/common/tier/ChemicalTankTier;getStorage()J"))
    private long mekanismAscended$getStorage(ChemicalTankTier tier) {
        return (Object) this instanceof AscendedTEChemicalTank ? AscendedTierValues.ASCENDED_CHEMICAL_TANK_CAPACITY : tier.getStorage();
    }
}
