package net.stachesebastian.mekanismascended.common.item.block.transmitter;

import mekanism.api.text.EnumColor;
import mekanism.common.MekanismLang;
import mekanism.common.block.transmitter.BlockLargeTransmitter;
import mekanism.common.item.block.ItemBlockTooltip;
import mekanism.common.tier.PipeTier;
import mekanism.common.util.text.TextUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.stachesebastian.mekanismascended.common.tier.AscendedTierValues;
import net.stachesebastian.mekanismascended.common.tile.transmitter.AscendedTEMechanicalPipe;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AscendedItemBlockMechanicalPipe extends ItemBlockTooltip<BlockLargeTransmitter<AscendedTEMechanicalPipe>> {

    public AscendedItemBlockMechanicalPipe(BlockLargeTransmitter<AscendedTEMechanicalPipe> block, Properties properties) {
        super(block, true, properties);
    }

    @NotNull
    @Override
    public PipeTier getTier() {
        return PipeTier.ULTIMATE;
    }

    @Override
    protected void addDetails(@NotNull ItemStack stack, @NotNull Item.TooltipContext context, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        super.addDetails(stack, context, tooltip, flag);
        tooltip.add(MekanismLang.CAPABLE_OF_TRANSFERRING.translateColored(EnumColor.DARK_GRAY));
        tooltip.add(MekanismLang.FLUIDS.translateColored(EnumColor.PURPLE, EnumColor.GRAY, MekanismLang.FORGE));
    }

    @Override
    protected void addStats(@NotNull ItemStack stack, @NotNull Item.TooltipContext context, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        super.addStats(stack, context, tooltip, flag);
        tooltip.add(MekanismLang.CAPACITY_MB_PER_TICK.translateColored(EnumColor.INDIGO, EnumColor.GRAY, TextUtils.format(AscendedTierValues.ASCENDED_MECHANICAL_PIPE_CAPACITY)));
        tooltip.add(MekanismLang.PUMP_RATE_MB.translateColored(EnumColor.INDIGO, EnumColor.GRAY, TextUtils.format(AscendedTierValues.ASCENDED_MECHANICAL_PIPE_PULL_AMOUNT)));
    }

    @NotNull
    @Override
    public Component getName(@NotNull ItemStack stack) {
        return super.getName(stack).copy().withStyle(style -> style.withColor(AscendedTierValues.ASCENDED_TEXT_COLOR));
    }
}
