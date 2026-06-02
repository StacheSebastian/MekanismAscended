package net.stachesebastian.mekanismascended.mixin;

import java.util.HashMap;
import java.util.Map;
import mekanism.common.content.blocktype.BlockType;
import mekanism.common.content.matrix.MatrixEnergyContainer;
import mekanism.common.tier.InductionProviderTier;
import mekanism.common.tile.multiblock.TileEntityInductionProvider;
import net.minecraft.core.BlockPos;
import net.stachesebastian.mekanismascended.common.registries.AscendedBlockTypes;
import net.stachesebastian.mekanismascended.common.tier.AscendedTierValues;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MatrixEnergyContainer.class)
public abstract class MatrixEnergyContainerMixin {

    @Unique
    private final Map<BlockPos, Long> mekanismAscended$providerOutputs = new HashMap<>();

    @Inject(method = "addProvider", at = @At("HEAD"))
    private void mekanismAscended$addProvider(BlockPos pos, TileEntityInductionProvider provider, CallbackInfo ci) {
        if (BlockType.is(provider.getBlockState().getBlock(), AscendedBlockTypes.ASCENDED_INDUCTION_PROVIDER)) {
            mekanismAscended$providerOutputs.put(pos, AscendedTierValues.ASCENDED_INDUCTION_PROVIDER_OUTPUT);
        } else {
            mekanismAscended$providerOutputs.remove(pos);
        }
    }

    @Redirect(
          method = "addProvider",
          at = @At(value = "INVOKE", target = "Lmekanism/common/tier/InductionProviderTier;getOutput()J")
    )
    private long mekanismAscended$getAddedProviderOutput(InductionProviderTier tier, BlockPos pos, TileEntityInductionProvider provider) {
        return mekanismAscended$getProviderOutput(tier, pos);
    }

    @Redirect(
          method = "removeInternal",
          at = @At(value = "INVOKE", target = "Lmekanism/common/tier/InductionProviderTier;getOutput()J")
    )
    private long mekanismAscended$getProviderOutput(InductionProviderTier tier, BlockPos pos) {
        Long output = mekanismAscended$providerOutputs.get(pos);
        return output == null ? tier.getOutput() : output;
    }

    @Inject(method = "removeInternal", at = @At("RETURN"))
    private void mekanismAscended$removeProviderOutput(BlockPos pos, CallbackInfo ci) {
        mekanismAscended$providerOutputs.remove(pos);
    }

    @Inject(method = "invalidate", at = @At("RETURN"))
    private void mekanismAscended$clearProviderOutputs(CallbackInfo ci) {
        mekanismAscended$providerOutputs.clear();
    }
}
