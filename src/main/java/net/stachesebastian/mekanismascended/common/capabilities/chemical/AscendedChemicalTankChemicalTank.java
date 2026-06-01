package net.stachesebastian.mekanismascended.common.capabilities.chemical;

import mekanism.api.AutomationType;
import mekanism.api.IContentsListener;
import mekanism.api.chemical.BasicChemicalTank;
import mekanism.api.functions.ConstantPredicates;
import net.stachesebastian.mekanismascended.common.tier.transmitter.AscendedTierValues;
import org.jetbrains.annotations.Nullable;

public class AscendedChemicalTankChemicalTank extends BasicChemicalTank {

    public static AscendedChemicalTankChemicalTank create(@Nullable IContentsListener listener) {
        return new AscendedChemicalTankChemicalTank(listener);
    }

    private AscendedChemicalTankChemicalTank(@Nullable IContentsListener listener) {
        super(AscendedTierValues.ASCENDED_CHEMICAL_TANK_CAPACITY, ConstantPredicates.alwaysTrueBi(), ConstantPredicates.alwaysTrueBi(),
              ConstantPredicates.alwaysTrue(), null, listener, null);
    }

    @Override
    protected long getInsertRate(@Nullable AutomationType automationType) {
        return automationType == AutomationType.INTERNAL ? AscendedTierValues.ASCENDED_CHEMICAL_TANK_OUTPUT : super.getInsertRate(automationType);
    }

    @Override
    protected long getExtractRate(@Nullable AutomationType automationType) {
        return automationType == AutomationType.INTERNAL ? AscendedTierValues.ASCENDED_CHEMICAL_TANK_OUTPUT : super.getExtractRate(automationType);
    }
}
