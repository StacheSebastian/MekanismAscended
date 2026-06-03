package net.stachesebastian.mekanismascended.mixin;

import mekanism.common.attachments.containers.item.ComponentBackedBinInventorySlot;
import mekanism.common.tier.BinTier;
import net.minecraft.world.item.ItemStack;
import net.stachesebastian.mekanismascended.common.item.block.AscendedItemBlockBin;
import net.stachesebastian.mekanismascended.common.tier.AscendedTierValues;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ComponentBackedBinInventorySlot.class)
public abstract class ComponentBackedBinInventorySlotMixin {

    @Redirect(
          method = "<init>",
          at = @At(value = "INVOKE", target = "Lmekanism/common/tier/BinTier;getStorage()I")
    )
    private static int mekanismAscended$getStorage(BinTier tier, ItemStack attachedTo, int slotIndex, BinTier originalTier) {
        return attachedTo.getItem() instanceof AscendedItemBlockBin ? AscendedTierValues.ASCENDED_BIN_CAPACITY : tier.getStorage();
    }
}
