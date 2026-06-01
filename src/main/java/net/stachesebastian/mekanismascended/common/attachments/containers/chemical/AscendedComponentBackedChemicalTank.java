package net.stachesebastian.mekanismascended.common.attachments.containers.chemical;

import mekanism.api.functions.ConstantPredicates;
import mekanism.common.attachments.containers.ContainerType;
import mekanism.common.attachments.containers.chemical.ComponentBackedChemicalTank;
import net.minecraft.world.item.ItemStack;
import net.stachesebastian.mekanismascended.common.tier.transmitter.AscendedTierValues;

public class AscendedComponentBackedChemicalTank extends ComponentBackedChemicalTank {

    public static AscendedComponentBackedChemicalTank create(ContainerType<?, ?, ?> ignored, ItemStack attachedTo, int tankIndex) {
        return new AscendedComponentBackedChemicalTank(attachedTo, tankIndex);
    }

    private AscendedComponentBackedChemicalTank(ItemStack attachedTo, int tankIndex) {
        super(attachedTo, tankIndex, ConstantPredicates.alwaysTrueBi(), ConstantPredicates.alwaysTrueBi(), ConstantPredicates.alwaysTrue(),
              () -> AscendedTierValues.ASCENDED_CHEMICAL_TANK_OUTPUT, () -> AscendedTierValues.ASCENDED_CHEMICAL_TANK_CAPACITY, null);
    }
}
