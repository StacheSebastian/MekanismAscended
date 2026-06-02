package net.stachesebastian.mekanismascended.common.item.block;

import mekanism.api.text.EnumColor;
import mekanism.common.MekanismLang;
import mekanism.common.block.prefab.BlockTile;
import mekanism.common.content.blocktype.BlockTypeTile;
import mekanism.common.item.block.ItemBlockInductionCell;
import mekanism.common.tile.multiblock.TileEntityInductionCell;
import mekanism.common.util.StorageUtils;
import mekanism.common.util.text.EnergyDisplay;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.stachesebastian.mekanismascended.common.tier.AscendedTierValues;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AscendedItemBlockInductionCell extends ItemBlockInductionCell {

    public AscendedItemBlockInductionCell(BlockTile<TileEntityInductionCell, BlockTypeTile<TileEntityInductionCell>> block, Properties properties) {
        super(block, properties);
    }

    @Override
    protected void addStats(@NotNull ItemStack stack, @NotNull Item.TooltipContext context, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        tooltip.add(MekanismLang.CAPACITY.translateColored(TextColor.fromLegacyFormat(ChatFormatting.GOLD), EnumColor.GRAY, EnergyDisplay.of(AscendedTierValues.ASCENDED_INDUCTION_CELL_CAPACITY)));
        StorageUtils.addStoredEnergy(stack, tooltip, false);
    }

    @NotNull
    @Override
    public Component getName(@NotNull ItemStack stack) {
        return super.getName(stack).copy().withStyle(ChatFormatting.GOLD);
    }
}
