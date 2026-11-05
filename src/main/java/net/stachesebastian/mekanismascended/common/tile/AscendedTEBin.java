package net.stachesebastian.mekanismascended.common.tile;

import mekanism.api.IContentsListener;
import mekanism.common.capabilities.holder.slot.IInventorySlotHolder;
import mekanism.common.capabilities.holder.slot.InventorySlotHelper;
import mekanism.common.inventory.slot.BinInventorySlot;
import mekanism.common.tile.TileEntityBin;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.stachesebastian.mekanismascended.common.tier.AscendedTierValues;
import net.stachesebastian.mekanismascended.mixin.BasicInventorySlotAccessor;
import net.stachesebastian.mekanismascended.mixin.TileEntityBinAccessor;
import org.jetbrains.annotations.NotNull;

public class AscendedTEBin extends TileEntityBin {

    public AscendedTEBin(Holder<Block> blockProvider, BlockPos pos, BlockState state) {
        super(blockProvider, pos, state);
    }

    @NotNull
    @Override
    protected IInventorySlotHolder getInitialInventory(IContentsListener listener) {
        InventorySlotHelper builder = InventorySlotHelper.forSide(facingSupplier);
        BinInventorySlot binSlot = BinInventorySlot.create(listener, getTier());
        ((BasicInventorySlotAccessor) binSlot).mekanismAscended$setLimit(AscendedTierValues.ascendedBinCapacity());
        ((TileEntityBinAccessor) this).mekanismAscended$setBinSlot(binSlot);
        builder.addSlot(binSlot);
        return builder.build();
    }
}
