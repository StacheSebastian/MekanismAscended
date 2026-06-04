package net.stachesebastian.mekanismascended.common.item.block;

import mekanism.api.text.EnumColor;
import mekanism.common.MekanismLang;
import mekanism.common.block.prefab.BlockTile;
import mekanism.common.content.blocktype.BlockTypeTile;
import mekanism.common.item.block.ItemBlockInductionProvider;
import mekanism.common.tile.multiblock.TileEntityInductionProvider;
import mekanism.common.util.text.EnergyDisplay;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.stachesebastian.mekanismascended.common.tier.AscendedTierValues;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AscendedItemBlockInductionProvider extends ItemBlockInductionProvider {

    public AscendedItemBlockInductionProvider(BlockTile<TileEntityInductionProvider, BlockTypeTile<TileEntityInductionProvider>> block, Properties properties) {
        super(block, properties);
    }

    @Override
    protected void addStats(@NotNull ItemStack stack, @NotNull Item.TooltipContext context, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        tooltip.add(MekanismLang.INDUCTION_PORT_OUTPUT_RATE.translateColored(AscendedTierValues.ascendedTextColor(), EnumColor.GRAY, EnergyDisplay.of(AscendedTierValues.ascendedInductionProviderOutput())));
    }

    @NotNull
    @Override
    public Component getName(@NotNull ItemStack stack) {
        return super.getName(stack).copy().withStyle(style -> style.withColor(AscendedTierValues.ascendedTextColor()));
    }
}