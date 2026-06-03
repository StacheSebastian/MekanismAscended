package net.stachesebastian.mekanismascended.common.item.block;

import mekanism.api.text.EnumColor;
import mekanism.common.MekanismLang;
import mekanism.common.attachments.containers.item.ComponentBackedBinInventorySlot;
import mekanism.common.block.basic.BlockBin;
import mekanism.common.inventory.slot.BinInventorySlot;
import mekanism.common.item.block.ItemBlockBin;
import mekanism.common.util.text.TextUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.stachesebastian.mekanismascended.common.tier.AscendedTierValues;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AscendedItemBlockBin extends ItemBlockBin {

    public AscendedItemBlockBin(BlockBin block, Properties properties) {
        super(block, properties);
    }

    @Override
    protected void addStats(@NotNull ItemStack stack, @NotNull Item.TooltipContext context, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        ComponentBackedBinInventorySlot slot = BinInventorySlot.getForStack(stack);
        if (slot != null) {
            if (slot.isEmpty()) {
                tooltip.add(MekanismLang.EMPTY.translateColored(EnumColor.DARK_RED));
            } else {
                tooltip.add(MekanismLang.STORING.translateColored(EnumColor.BRIGHT_GREEN, EnumColor.GRAY, slot.getStack()));
                tooltip.add(MekanismLang.ITEM_AMOUNT.translateColored(EnumColor.PURPLE, EnumColor.GRAY, TextUtils.format(slot.getCount())));
            }
            ItemStack lockStack = slot.getLockStack();
            if (!lockStack.isEmpty()) {
                tooltip.add(MekanismLang.LOCKED.translateColored(EnumColor.AQUA, EnumColor.GRAY, lockStack));
            }
            tooltip.add(MekanismLang.CAPACITY_ITEMS.translateColored(EnumColor.INDIGO, EnumColor.GRAY, TextUtils.format(AscendedTierValues.ASCENDED_BIN_CAPACITY)));
        }
    }

    @NotNull
    @Override
    public Component getName(@NotNull ItemStack stack) {
        return super.getName(stack).copy().withStyle(ChatFormatting.GOLD);
    }
}
