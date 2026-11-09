package net.stachesebastian.mekanismascended.mixin;

import mekanism.common.tier.FactoryTier;
import mekanism.common.tile.factory.TileEntityItemToItemFactory;
import net.stachesebastian.mekanismascended.common.tier.AscendedTierValues;
import net.stachesebastian.mekanismascended.common.tile.factory.IAscendedFactoryTE;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(TileEntityItemToItemFactory.class)
public abstract class TileEntityItemToItemFactoryMixin {

    @Redirect(
            method = "addSlots",
            at = @At(
                    value = "FIELD",
                    target = "Lmekanism/common/tier/FactoryTier;processes:I",
                    opcode = Opcodes.GETFIELD)
    )
    private int mekanismAscended$getProcesses(FactoryTier tier) {
        return (Object) this instanceof IAscendedFactoryTE ? AscendedTierValues.ascendedFactoryProcesses() : tier.processes;
    }
}
