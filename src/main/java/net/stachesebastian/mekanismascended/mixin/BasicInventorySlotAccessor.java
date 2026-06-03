package net.stachesebastian.mekanismascended.mixin;

import mekanism.common.inventory.slot.BasicInventorySlot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(BasicInventorySlot.class)
public interface BasicInventorySlotAccessor {

    @Mutable
    @Accessor("limit")
    void mekanismAscended$setLimit(int limit);
}