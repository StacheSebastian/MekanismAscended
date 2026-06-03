package net.stachesebastian.mekanismascended.mixin;

import mekanism.client.gui.GuiConfigurableTile;
import mekanism.client.gui.machine.GuiFactory;
import mekanism.common.inventory.container.tile.MekanismTileContainer;
import mekanism.common.tier.FactoryTier;
import mekanism.common.tile.factory.TileEntityFactory;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.stachesebastian.mekanismascended.common.tier.AscendedTierValues;
import net.stachesebastian.mekanismascended.common.util.AscendedFactoryUtil;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiFactory.class)
public abstract class GuiFactoryMixin extends GuiConfigurableTile<TileEntityFactory<?>, MekanismTileContainer<TileEntityFactory<?>>> {

    protected GuiFactoryMixin(MekanismTileContainer<TileEntityFactory<?>> container, Inventory inv, Component title) {
        super(container, inv, title);
    }

    @Inject(method = "<init>", at = @At("RETURN"))
    private void mekanismAscended$init(MekanismTileContainer<TileEntityFactory<?>> container, Inventory inv, Component title, CallbackInfo ci) {
        if (AscendedFactoryUtil.isAscendedFactory(tile)) {
            imageWidth += AscendedFactoryUtil.getExtraGuiWidth(tile);
            inventoryLabelX = AscendedFactoryUtil.getInventoryXOffset(tile);
        }
    }

    @Redirect(
            method = "addGuiElements",
            at = @At(
                    value = "FIELD",
                    target = "Lmekanism/common/tier/FactoryTier;processes:I",
                    opcode = Opcodes.GETFIELD
            )
    )
    private int mekanismAscended$getProcesses(FactoryTier tier) {
        return AscendedFactoryUtil.isAscendedFactory(tile) ? AscendedTierValues.ASCENDED_FACTORY_PROCESSES : tier.processes;
    }

    @ModifyVariable(method = "addGuiElements", at = @At("STORE"), name = "baseX")
    private int mekanismAscended$getBaseX(int baseX) {
        return AscendedFactoryUtil.isAscendedFactory(tile) ? 27 : baseX;
    }

    @ModifyVariable(method = "addGuiElements", at = @At("STORE"), name = "baseXMult")
    private int mekanismAscended$getBaseXMult(int baseXMult) {
        return AscendedFactoryUtil.isAscendedFactory(tile) ? 19 : baseXMult;
    }

    @ModifyConstant(method = "addGuiElements", constant = @Constant(intValue = 172))
    private int mekanismAscended$getChemicalBarWidth(int width) {
        return AscendedFactoryUtil.isAscendedFactory(tile) ? width + AscendedFactoryUtil.getExtraGuiWidth(tile) : width;
    }

    @ModifyConstant(method = "addGuiElements", constant = @Constant(intValue = 182))
    private int mekanismAscended$getDumpButtonX(int x) {
        return AscendedFactoryUtil.isAscendedFactory(tile) ? x + AscendedFactoryUtil.getExtraGuiWidth(tile) : x;
    }
}
