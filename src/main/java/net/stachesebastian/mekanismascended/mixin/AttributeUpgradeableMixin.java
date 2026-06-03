package net.stachesebastian.mekanismascended.mixin;

import mekanism.api.tier.BaseTier;
import mekanism.common.block.attribute.AttributeUpgradeable;
import mekanism.common.block.states.BlockStateHelper;
import mekanism.common.content.blocktype.FactoryType;
import mekanism.common.registries.MekanismBlocks;
import mekanism.common.tier.FactoryTier;
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
        if (current.is(MekanismBlocks.ULTIMATE_FLUID_TANK)) {
            cir.setReturnValue(BlockStateHelper.copyStateData(current, AscendedBlocks.ASCENDED_FLUID_TANK));
        } else if (current.is(MekanismBlocks.ULTIMATE_CHEMICAL_TANK)) {
            cir.setReturnValue(BlockStateHelper.copyStateData(current, AscendedBlocks.ASCENDED_CHEMICAL_TANK));
        } else if (current.is(MekanismBlocks.ULTIMATE_ENERGY_CUBE)) {
            cir.setReturnValue(BlockStateHelper.copyStateData(current, AscendedBlocks.ASCENDED_ENERGY_CUBE));
        } else if (current.is(MekanismBlocks.ULTIMATE_BIN)) {
            cir.setReturnValue(BlockStateHelper.copyStateData(current, AscendedBlocks.ASCENDED_BIN));
        } else if (current.is(MekanismBlocks.getFactory(FactoryTier.ULTIMATE, FactoryType.COMPRESSING))) {
            cir.setReturnValue(BlockStateHelper.copyStateData(current, AscendedBlocks.ASCENDED_COMPRESSING_FACTORY));
        } else if (current.is(MekanismBlocks.getFactory(FactoryTier.ULTIMATE, FactoryType.COMBINING))) {
            cir.setReturnValue(BlockStateHelper.copyStateData(current, AscendedBlocks.ASCENDED_COMBINING_FACTORY));
        } else if (current.is(MekanismBlocks.getFactory(FactoryTier.ULTIMATE, FactoryType.CRUSHING))) {
            cir.setReturnValue(BlockStateHelper.copyStateData(current, AscendedBlocks.ASCENDED_CRUSHING_FACTORY));
        } else if (current.is(MekanismBlocks.getFactory(FactoryTier.ULTIMATE, FactoryType.ENRICHING))) {
            cir.setReturnValue(BlockStateHelper.copyStateData(current, AscendedBlocks.ASCENDED_ENRICHING_FACTORY));
        } else if (current.is(MekanismBlocks.getFactory(FactoryTier.ULTIMATE, FactoryType.INFUSING))) {
            cir.setReturnValue(BlockStateHelper.copyStateData(current, AscendedBlocks.ASCENDED_INFUSING_FACTORY));
        } else if (current.is(MekanismBlocks.getFactory(FactoryTier.ULTIMATE, FactoryType.INJECTING))) {
            cir.setReturnValue(BlockStateHelper.copyStateData(current, AscendedBlocks.ASCENDED_INJECTING_FACTORY));
        } else if (current.is(MekanismBlocks.getFactory(FactoryTier.ULTIMATE, FactoryType.PURIFYING))) {
            cir.setReturnValue(BlockStateHelper.copyStateData(current, AscendedBlocks.ASCENDED_PURIFYING_FACTORY));
        } else if (current.is(MekanismBlocks.getFactory(FactoryTier.ULTIMATE, FactoryType.SAWING))) {
            cir.setReturnValue(BlockStateHelper.copyStateData(current, AscendedBlocks.ASCENDED_SAWING_FACTORY));
        } else if (current.is(MekanismBlocks.getFactory(FactoryTier.ULTIMATE, FactoryType.SMELTING))) {
            cir.setReturnValue(BlockStateHelper.copyStateData(current, AscendedBlocks.ASCENDED_SMELTING_FACTORY));
        }
    }
}
