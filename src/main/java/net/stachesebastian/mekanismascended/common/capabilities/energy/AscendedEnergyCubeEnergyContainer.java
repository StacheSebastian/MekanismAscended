package net.stachesebastian.mekanismascended.common.capabilities.energy;

import mekanism.api.AutomationType;
import mekanism.api.IContentsListener;
import mekanism.api.functions.ConstantPredicates;
import mekanism.common.capabilities.energy.BasicEnergyContainer;
import net.stachesebastian.mekanismascended.common.tier.AscendedTierValues;
import org.jetbrains.annotations.Nullable;


public class AscendedEnergyCubeEnergyContainer extends BasicEnergyContainer {

    public static AscendedEnergyCubeEnergyContainer create(@Nullable IContentsListener listener) {
        return new AscendedEnergyCubeEnergyContainer(listener);
    }

    private AscendedEnergyCubeEnergyContainer(@Nullable IContentsListener listener) {
        super(AscendedTierValues.ASCENDED_ENERGY_CUBE_CAPACITY, ConstantPredicates.alwaysTrue(), ConstantPredicates.alwaysTrue(), listener);
    }

    @Override
    protected long getInsertRate(@Nullable AutomationType automationType) {
        //Only limit the internal rate to change the speed at which this can be filled from an item
        return automationType == AutomationType.INTERNAL ? AscendedTierValues.ASCENDED_ENERGY_CUBE_OUTPUT : super.getInsertRate(automationType);
    }

    @Override
    protected long getExtractRate(@Nullable AutomationType automationType) {
        //Only limit the internal rate to change the speed at which this can be filled from an item
        return automationType == AutomationType.INTERNAL ? AscendedTierValues.ASCENDED_ENERGY_CUBE_OUTPUT : super.getExtractRate(automationType);
    }
}
