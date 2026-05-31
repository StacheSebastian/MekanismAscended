package net.stachesebastian.mekanismascended.common.item;

import mekanism.api.tier.IAlloyTier;
import mekanism.common.item.ItemAlloy;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class AscendedItemAlloy extends ItemAlloy {
    public AscendedItemAlloy(IAlloyTier tier, Properties properties) {
        super(tier, properties);
    }

    @NotNull
    @Override
    public Component getName(@NotNull ItemStack stack) {
        return super.getName(stack).copy().withStyle(ChatFormatting.GOLD);
    }
}
