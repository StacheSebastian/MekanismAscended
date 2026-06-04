package net.stachesebastian.mekanismascended.common.item;

import mekanism.api.tier.BaseTier;
import mekanism.common.item.ItemTierInstaller;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import net.stachesebastian.mekanismascended.common.tier.AscendedTierValues;

public class AscendedItemTierInstaller extends ItemTierInstaller {

    public AscendedItemTierInstaller(Properties properties) {
        super(BaseTier.ULTIMATE, BaseTier.CREATIVE, properties);
    }

    @NotNull
    @Override
    public Component getName(@NotNull ItemStack stack) {
        return super.getName(stack).copy().withStyle(style -> style.withColor(AscendedTierValues.ascendedTextColor()));
    }
}
