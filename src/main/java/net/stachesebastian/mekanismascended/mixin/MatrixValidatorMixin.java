package net.stachesebastian.mekanismascended.mixin;

import mekanism.common.content.blocktype.BlockType;
import mekanism.common.content.matrix.MatrixValidator;
import net.minecraft.world.level.block.Block;
import net.stachesebastian.mekanismascended.common.registries.AscendedBlockTypes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(MatrixValidator.class)
public abstract class MatrixValidatorMixin {

    @Redirect(
          method = "validateInner",
          at = @At(value = "INVOKE", target = "Lmekanism/common/content/blocktype/BlockType;is(Lnet/minecraft/world/level/block/Block;[Lmekanism/common/content/blocktype/BlockType;)Z")
    )
    private boolean mekanismAscended$isInductionComponent(Block block, BlockType[] types) {
        return BlockType.is(block, types) || BlockType.is(block, AscendedBlockTypes.ASCENDED_INDUCTION_CELL, AscendedBlockTypes.ASCENDED_INDUCTION_PROVIDER);
    }
}
