package net.stachesebastian.mekanismascended.mixin;

import mekanism.common.inventory.container.tile.FactoryContainer;
import mekanism.common.inventory.container.tile.MekanismTileContainer;
import mekanism.common.registries.MekanismContainerTypes;
import mekanism.common.tile.factory.TileEntityFactory;
import net.minecraft.world.entity.player.Inventory;
import net.stachesebastian.mekanismascended.common.util.AscendedFactoryUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FactoryContainer.class)
public abstract class FactoryContainerMixin extends MekanismTileContainer<TileEntityFactory<?>> {

    protected FactoryContainerMixin(int id, Inventory inv, TileEntityFactory<?> tile) {
        super(MekanismContainerTypes.FACTORY, id, inv, tile);
    }

    @Inject(method = "getInventoryXOffset", at = @At("HEAD"), cancellable = true)
    private void mekanismAscended$getInventoryXOffset(CallbackInfoReturnable<Integer> cir) {
        if (AscendedFactoryUtil.isAscendedFactory(tile)) {
            cir.setReturnValue(AscendedFactoryUtil.getInventoryXOffset(tile));
        }
    }
}
