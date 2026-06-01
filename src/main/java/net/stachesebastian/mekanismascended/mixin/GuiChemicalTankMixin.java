package net.stachesebastian.mekanismascended.mixin;

import mekanism.client.gui.GuiChemicalTank;
import mekanism.common.tier.ChemicalTankTier;
import net.stachesebastian.mekanismascended.common.tier.transmitter.AscendedTierValues;
import net.stachesebastian.mekanismascended.common.tile.AscendedTEChemicalTank;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(GuiChemicalTank.class)
public abstract class GuiChemicalTankMixin {

    @Redirect(method = "lambda$addGuiElements$0", at = @At(value = "INVOKE", target = "Lmekanism/common/tier/ChemicalTankTier;getStorage()J"))
    private long mekanismAscended$getStorage(ChemicalTankTier tier) {
        GuiChemicalTank gui = (GuiChemicalTank) (Object) this;
        return gui.getTileEntity() instanceof AscendedTEChemicalTank ? AscendedTierValues.ASCENDED_CHEMICAL_TANK_CAPACITY : tier.getStorage();
    }
}
