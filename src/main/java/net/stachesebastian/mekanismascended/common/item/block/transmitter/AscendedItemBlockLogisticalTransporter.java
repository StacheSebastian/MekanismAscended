package net.stachesebastian.mekanismascended.common.item.block.transmitter;

import mekanism.api.text.EnumColor;
import mekanism.common.MekanismLang;
import mekanism.common.block.transmitter.BlockLargeTransmitter;
import mekanism.common.item.block.transmitter.ItemBlockTransporter;
import mekanism.common.tier.TransporterTier;
import mekanism.common.util.MekanismUtils;
import mekanism.common.util.UnitDisplayUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.SharedConstants;
import net.minecraft.network.chat.Component;
import net.minecraft.world.TickRateManager;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.stachesebastian.mekanismascended.common.tier.transmitter.AscendedTierValues;
import net.stachesebastian.mekanismascended.common.tile.transmitter.AscendedTELogisticalTransporter;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AscendedItemBlockLogisticalTransporter extends ItemBlockTransporter<AscendedTELogisticalTransporter> {

    public AscendedItemBlockLogisticalTransporter(BlockLargeTransmitter<AscendedTELogisticalTransporter> block, Properties properties) {
        super(block, properties);
    }

    @NotNull
    @Override
    public TransporterTier getTier() {
        return TransporterTier.ULTIMATE;
    }

    @Override
    protected void addStats(@NotNull ItemStack stack, @NotNull Item.TooltipContext context, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        super.addStats(stack, context, tooltip, flag);
        //Ensure no one somehow passes in invalid data
        float tickRate = Math.max(context.tickRate(), TickRateManager.MIN_TICKRATE);
        float speed = AscendedTierValues.ASCENDED_LOGISTICAL_TRANSPORTER_SPEED / (5 * SharedConstants.TICKS_PER_SECOND / tickRate);
        float pull = AscendedTierValues.ASCENDED_LOGISTICAL_TRANSPORTER_PULL_AMOUNT * tickRate / MekanismUtils.TICKS_PER_HALF_SECOND;
        tooltip.add(MekanismLang.SPEED.translateColored(EnumColor.INDIGO, EnumColor.GRAY, UnitDisplayUtils.roundDecimals(speed)));
        tooltip.add(MekanismLang.PUMP_RATE.translateColored(EnumColor.INDIGO, EnumColor.GRAY, UnitDisplayUtils.roundDecimals(pull)));
    }

    @NotNull
    @Override
    public Component getName(@NotNull ItemStack stack) {
        return super.getName(stack).copy().withStyle(ChatFormatting.GOLD);
    }
}
