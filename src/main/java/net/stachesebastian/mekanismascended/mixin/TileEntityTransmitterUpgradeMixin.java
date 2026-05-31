package net.stachesebastian.mekanismascended.mixin;

import mekanism.api.tier.BaseTier;
import mekanism.common.block.states.BlockStateHelper;
import mekanism.common.block.states.TransmitterType;
import mekanism.common.tile.transmitter.TileEntityLogisticalTransporter;
import mekanism.common.tile.transmitter.TileEntityMechanicalPipe;
import mekanism.common.tile.transmitter.TileEntityPressurizedTube;
import mekanism.common.tile.transmitter.TileEntityThermodynamicConductor;
import mekanism.common.tile.transmitter.TileEntityTransmitter;
import mekanism.common.tile.transmitter.TileEntityUniversalCable;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.stachesebastian.mekanismascended.common.registries.AscendedBlocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({
      TileEntityUniversalCable.class,
      TileEntityMechanicalPipe.class,
      TileEntityPressurizedTube.class,
      TileEntityThermodynamicConductor.class,
      TileEntityLogisticalTransporter.class
})
public abstract class TileEntityTransmitterUpgradeMixin {

    @Inject(
          method = "upgradeResult(Lnet/minecraft/world/level/block/state/BlockState;Lmekanism/api/tier/BaseTier;)Lnet/minecraft/world/level/block/state/BlockState;",
          at = @At("HEAD"),
          cancellable = true
    )
    private void mekanismAscended$upgradeResult(BlockState current, BaseTier tier, CallbackInfoReturnable<BlockState> cir) {
        if (tier != BaseTier.CREATIVE) {
            return;
        }
        TransmitterType transmitterType = ((TileEntityTransmitter) (Object) this).getTransmitterType();
        Holder<Block> upgradedBlock = switch (transmitterType) {
            case UNIVERSAL_CABLE -> AscendedBlocks.ASCENDED_UNIVERSAL_CABLE;
            case MECHANICAL_PIPE -> AscendedBlocks.ASCENDED_MECHANICAL_PIPE;
            case PRESSURIZED_TUBE -> AscendedBlocks.ASCENDED_PRESSURIZED_TUBE;
            case THERMODYNAMIC_CONDUCTOR -> AscendedBlocks.ASCENDED_THERMODYNAMIC_CONDUCTOR;
            case LOGISTICAL_TRANSPORTER -> AscendedBlocks.ASCENDED_LOGISTICAL_TRANSPORTER;
            default -> null;
        };
        if (upgradedBlock != null) {
            cir.setReturnValue(BlockStateHelper.copyStateData(current, upgradedBlock));
        }
    }
}
