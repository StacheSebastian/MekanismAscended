package net.stachesebastian.mekanismascended.common.item.block.transmitter;

import mekanism.api.text.EnumColor;
import mekanism.common.MekanismLang;
import mekanism.common.block.transmitter.BlockSmallTransmitter;
import mekanism.common.item.block.ItemBlockTooltip;
import mekanism.common.tier.ConductorTier;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.stachesebastian.mekanismascended.common.tier.AscendedTierValues;
import net.stachesebastian.mekanismascended.common.tile.transmitter.AscendedTEThermodynamicConductor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AscendedItemBlockThermodynamicConductor extends ItemBlockTooltip<BlockSmallTransmitter<AscendedTEThermodynamicConductor>> {

    public AscendedItemBlockThermodynamicConductor(BlockSmallTransmitter<AscendedTEThermodynamicConductor> block, Properties properties) {
        super(block, true, properties);
    }

    @NotNull
    @Override
    public ConductorTier getTier() {
        return ConductorTier.ULTIMATE;
    }

    @Override
    protected void addDetails(@NotNull ItemStack stack, @NotNull Item.TooltipContext context, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        super.addDetails(stack, context, tooltip, flag);
        tooltip.add(MekanismLang.CAPABLE_OF_TRANSFERRING.translateColored(EnumColor.DARK_GRAY));
        tooltip.add(MekanismLang.HEAT.translateColored(EnumColor.PURPLE, MekanismLang.MEKANISM));
    }

    @Override
    protected void addStats(@NotNull ItemStack stack, @NotNull Item.TooltipContext context, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        super.addStats(stack, context, tooltip, flag);
        tooltip.add(MekanismLang.CONDUCTION.translateColored(EnumColor.INDIGO, EnumColor.GRAY, AscendedTierValues.ascendedThermodynamicConductorConduction()));
        tooltip.add(MekanismLang.INSULATION.translateColored(EnumColor.INDIGO, EnumColor.GRAY, AscendedTierValues.ascendedThermodynamicConductorInsulation()));
        tooltip.add(MekanismLang.HEAT_CAPACITY.translateColored(EnumColor.INDIGO, EnumColor.GRAY, AscendedTierValues.ascendedThermodynamicConductorHeatCapacity()));
    }

    @NotNull
    @Override
    public Component getName(@NotNull ItemStack stack) {
        return super.getName(stack).copy().withStyle(style -> style.withColor(AscendedTierValues.ascendedTextColor()));
    }
}
