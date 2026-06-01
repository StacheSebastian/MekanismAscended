package net.stachesebastian.mekanismascended.mixin;

import mekanism.api.tier.BaseTier;
import mekanism.common.block.attribute.AttributeUpgradeable;
import mekanism.common.block.states.BlockStateHelper;
import mekanism.common.registries.MekanismBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.stachesebastian.mekanismascended.common.registries.AscendedBlocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AttributeUpgradeable.class)
public abstract class AttributeUpgradeableMixin {

    @Inject(method = "upgradeResult", at = @At("HEAD"), cancellable = true)
    private void mekanismAscended$upgradeResult(BlockState current, BaseTier tier, CallbackInfoReturnable<BlockState> cir) {
        if (tier != BaseTier.CREATIVE) {
            return;
        }
        switch (current.getBlock()) {
            case Block block when current.is(MekanismBlocks.ULTIMATE_FLUID_TANK) ->
                    cir.setReturnValue(BlockStateHelper.copyStateData(current, AscendedBlocks.ASCENDED_FLUID_TANK));
            case Block block when current.is(MekanismBlocks.ULTIMATE_CHEMICAL_TANK) ->
                    cir.setReturnValue(BlockStateHelper.copyStateData(current, AscendedBlocks.ASCENDED_CHEMICAL_TANK));
            default -> {
            }
        }
    }
}
