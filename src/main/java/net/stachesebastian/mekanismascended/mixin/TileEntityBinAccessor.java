package net.stachesebastian.mekanismascended.mixin;

import mekanism.common.inventory.slot.BinInventorySlot;
import mekanism.common.tile.TileEntityBin;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(TileEntityBin.class)
public interface TileEntityBinAccessor {

    @Accessor("binSlot")
    void mekanismAscended$setBinSlot(BinInventorySlot binSlot);
}
