package net.stachesebastian.mekanismascended.common.item.block;

import mekanism.common.block.basic.BlockFluidTank;
import mekanism.common.MekanismLang;
import mekanism.common.item.block.machine.ItemBlockFluidTank;
import mekanism.api.text.EnumColor;
import mekanism.common.util.StorageUtils;
import mekanism.common.util.text.TextUtils;
import java.util.List;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.neoforge.fluids.FluidStack;
import net.stachesebastian.mekanismascended.common.tier.AscendedTierValues;
import org.jetbrains.annotations.NotNull;

public class AscendedItemBlockFluidTank extends ItemBlockFluidTank {

    public AscendedItemBlockFluidTank(BlockFluidTank block, Item.Properties properties) {
        super(block, properties);
    }

    @Override
    protected void addStats(@NotNull ItemStack stack, @NotNull Item.TooltipContext context, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        FluidStack fluidStack = StorageUtils.getStoredFluidFromAttachment(stack);
        if (fluidStack.isEmpty()) {
            tooltip.add(MekanismLang.EMPTY.translateColored(EnumColor.DARK_RED));
        } else {
            tooltip.add(MekanismLang.GENERIC_STORED_MB.translateColored(EnumColor.PINK, fluidStack, EnumColor.GRAY, TextUtils.format(fluidStack.getAmount())));
        }
        tooltip.add(MekanismLang.CAPACITY_MB.translateColored(EnumColor.INDIGO, EnumColor.GRAY, TextUtils.format(AscendedTierValues.ASCENDED_FLUID_TANK_CAPACITY)));
    }

    @NotNull
    @Override
    public Component getName(@NotNull ItemStack stack) {
        return super.getName(stack).copy().withStyle(style -> style.withColor(AscendedTierValues.ASCENDED_TEXT_COLOR));
    }
}
