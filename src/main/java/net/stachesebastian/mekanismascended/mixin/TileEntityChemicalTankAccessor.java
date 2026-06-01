package net.stachesebastian.mekanismascended.mixin;

import mekanism.api.chemical.IChemicalTank;
import mekanism.common.tile.TileEntityChemicalTank;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(TileEntityChemicalTank.class)
public interface TileEntityChemicalTankAccessor {

    @Accessor("chemicalTank")
    void mekanismAscended$setChemicalTank(IChemicalTank chemicalTank);
}
