package net.stachesebastian.mekanismascended.common.capabilities.chemical;

import mekanism.api.AutomationType;
import mekanism.api.IContentsListener;
import mekanism.api.chemical.BasicChemicalTank;
import mekanism.api.functions.ConstantPredicates;
import net.stachesebastian.mekanismascended.common.tier.AscendedTierValues;
import org.jetbrains.annotations.Nullable;

public class AscendedChemicalTankChemicalTank extends BasicChemicalTank {

    public static AscendedChemicalTankChemicalTank create(@Nullable IContentsListener listener) {
        return new AscendedChemicalTankChemicalTank(listener);
    }

    private AscendedChemicalTankChemicalTank(@Nullable IContentsListener listener) {
        super(AscendedTierValues.ascendedChemicalTankCapacity(), ConstantPredicates.alwaysTrueBi(), ConstantPredicates.alwaysTrueBi(),
              ConstantPredicates.alwaysTrue(), null, listener, null);
    }

    @Override
    protected long getInsertRate(@Nullable AutomationType automationType) {
        //Only limit the internal rate to change the speed at which this can be filled from an item
        return automationType == AutomationType.INTERNAL ? AscendedTierValues.ascendedChemicalTankOutput() : super.getInsertRate(automationType);
    }

    @Override
    protected long getExtractRate(@Nullable AutomationType automationType) {
        //Only limit the internal rate to change the speed at which this can be filled from an item
        return automationType == AutomationType.INTERNAL ? AscendedTierValues.ascendedChemicalTankOutput() : super.getExtractRate(automationType);
    }
}
