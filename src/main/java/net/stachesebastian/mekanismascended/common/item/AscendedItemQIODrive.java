package net.stachesebastian.mekanismascended.common.item;

import mekanism.api.text.EnumColor;
import mekanism.common.MekanismLang;
import mekanism.common.attachments.qio.DriveMetadata;
import mekanism.common.item.ItemQIODrive;
import mekanism.common.registries.MekanismDataComponents;
import mekanism.common.tier.QIODriveTier;
import mekanism.common.util.text.TextUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.stachesebastian.mekanismascended.common.tier.AscendedTierValues;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AscendedItemQIODrive extends ItemQIODrive {


    public AscendedItemQIODrive(QIODriveTier tier, Properties properties) {
        super(tier, properties);
    }

    @Override
    public long getCountCapacity(ItemStack stack) {
        return AscendedTierValues.ascendedQIODriveCount();
    }

    @Override
    public int getTypeCapacity(ItemStack stack) {
        return AscendedTierValues.ascendedQIODriveTypes();
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @NotNull Item.TooltipContext context, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        DriveMetadata meta = stack.getOrDefault(MekanismDataComponents.DRIVE_METADATA, DriveMetadata.EMPTY);
        tooltip.add(MekanismLang.QIO_ITEMS_DETAIL.translateColored(EnumColor.GRAY, EnumColor.INDIGO,
                TextUtils.format(meta.count()), TextUtils.format(getCountCapacity(stack))));
        tooltip.add(MekanismLang.QIO_TYPES_DETAIL.translateColored(EnumColor.GRAY, EnumColor.INDIGO,
                TextUtils.format(meta.types()), TextUtils.format(getTypeCapacity(stack))));
    }

    @NotNull
    @Override
    public Component getName(@NotNull ItemStack stack) {
        return super.getName(stack).copy().withStyle(style -> style.withColor(AscendedTierValues.ascendedTextColor()));
    }
}
