package net.stachesebastian.mekanismascended.mixin;

import mekanism.common.tier.FactoryTier;
import mekanism.common.tile.factory.TileEntityItemToItemFactory;
import net.stachesebastian.mekanismascended.common.tier.AscendedTierValues;
import net.stachesebastian.mekanismascended.common.tile.factory.IAscendedFactoryTE;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
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
        return (Object) this instanceof IAscendedFactoryTE ? AscendedTierValues.ASCENDED_FACTORY_PROCESSES : tier.processes;
    }

    @ModifyVariable(method = "addSlots", at = @At("STORE"), name = "baseX")
    private int mekanismAscended$getBaseX(int baseX) {
        return (Object) this instanceof IAscendedFactoryTE ? mekanismAscended$baseX() : baseX;
    }

    @ModifyVariable(method = "addSlots", at = @At("STORE"), name = "baseXMult")
    private int mekanismAscended$getBaseXMult(int baseXMult) {
        return (Object) this instanceof IAscendedFactoryTE ? mekanismAscended$baseXMult() : baseXMult;
    }

    private static int mekanismAscended$baseX() {
        // Match Ultimate's left margin; wider Ascended GUI/container patches should expand around this.
        return 27;
    }

    private static int mekanismAscended$baseXMult() {
        // 19 is Mekanism's minimum non-overlapping lane spacing for Ultimate factories.
        return 19;
    }

}
