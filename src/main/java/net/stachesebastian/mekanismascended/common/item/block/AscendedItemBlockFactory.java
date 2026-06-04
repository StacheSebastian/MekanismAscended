package net.stachesebastian.mekanismascended.common.item.block;

import mekanism.common.block.prefab.BlockFactoryMachine;
import mekanism.common.item.block.machine.ItemBlockFactory;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import net.stachesebastian.mekanismascended.common.tier.AscendedTierValues;

public class AscendedItemBlockFactory extends ItemBlockFactory {

    public AscendedItemBlockFactory(BlockFactoryMachine.BlockFactory<?> block, Properties properties) {
        super(block, properties);
    }

    @NotNull
    @Override
    public Component getName(@NotNull ItemStack stack) {
        return super.getName(stack).copy().withStyle(style -> style.withColor(AscendedTierValues.ascendedTextColor()));
    }
}
