package net.stachesebastian.mekanismascended.common.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import net.stachesebastian.mekanismascended.common.tier.AscendedTierValues;

public class AscendedItem extends Item {
    public AscendedItem(Properties properties) {
        super(properties);
    }

    @NotNull
    @Override
    public Component getName(@NotNull ItemStack stack) {
        return super.getName(stack).copy().withStyle(style -> style.withColor(AscendedTierValues.ascendedTextColor()));
    }
}
