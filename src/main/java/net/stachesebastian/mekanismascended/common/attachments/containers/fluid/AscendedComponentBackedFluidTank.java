package net.stachesebastian.mekanismascended.common.attachments.containers.fluid;

import mekanism.api.functions.ConstantPredicates;
import mekanism.common.attachments.containers.ContainerType;
import mekanism.common.attachments.containers.fluid.ComponentBackedFluidTank;
import net.minecraft.world.item.ItemStack;
import net.stachesebastian.mekanismascended.common.tier.AscendedTierValues;

public class AscendedComponentBackedFluidTank extends ComponentBackedFluidTank {

    public static AscendedComponentBackedFluidTank create(ContainerType<?, ?, ?> ignored, ItemStack attachedTo, int tankIndex) {
        return new AscendedComponentBackedFluidTank(attachedTo, tankIndex);
    }

    private AscendedComponentBackedFluidTank(ItemStack attachedTo, int tankIndex) {
        super(attachedTo, tankIndex, ConstantPredicates.alwaysTrueBi(), ConstantPredicates.alwaysTrueBi(), ConstantPredicates.alwaysTrue(),
                AscendedTierValues::ascendedFluidTankOutput, AscendedTierValues::ascendedFluidTankCapacity);
    }
}
