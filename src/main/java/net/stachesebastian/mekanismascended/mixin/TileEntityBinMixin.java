package net.stachesebastian.mekanismascended.mixin;

import mekanism.api.IContentsListener;
import mekanism.common.inventory.slot.BinInventorySlot;
import mekanism.common.tier.BinTier;
import mekanism.common.tile.TileEntityBin;
import net.stachesebastian.mekanismascended.common.tier.AscendedTierValues;
import net.stachesebastian.mekanismascended.common.tile.AscendedTEBin;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(TileEntityBin.class)
public abstract class TileEntityBinMixin {

    @Redirect(
            method = "getInitialInventory",
            at = @At(
                    value = "INVOKE",
                    target = "Lmekanism/common/inventory/slot/BinInventorySlot;create(Lmekanism/api/IContentsListener;Lmekanism/common/tier/BinTier;)Lmekanism/common/inventory/slot/BinInventorySlot;"
            )
    )
    private BinInventorySlot mekanismAscended$createBinSlot(IContentsListener listener, BinTier tier) {
        BinInventorySlot slot = BinInventorySlot.create(listener, tier);
        if ((Object) this instanceof AscendedTEBin) {
            ((BasicInventorySlotAccessor) slot)
                    .mekanismAscended$setLimit(AscendedTierValues.ascendedBinCapacity());
        }
        return slot;
    }
}