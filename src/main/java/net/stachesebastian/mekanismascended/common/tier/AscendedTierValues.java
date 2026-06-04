package net.stachesebastian.mekanismascended.common.tier;

import mekanism.common.tier.BinTier;
import mekanism.common.tier.CableTier;
import mekanism.common.tier.ChemicalTankTier;
import mekanism.common.tier.ConductorTier;
import mekanism.common.tier.EnergyCubeTier;
import mekanism.common.tier.FluidTankTier;
import mekanism.common.tier.InductionCellTier;
import mekanism.common.tier.InductionProviderTier;
import mekanism.common.tier.PipeTier;
import mekanism.common.tier.TransporterTier;
import mekanism.common.tier.TubeTier;
import net.minecraft.network.chat.TextColor;
import net.stachesebastian.mekanismascended.Config;

public class AscendedTierValues {

    public static TextColor ascendedTextColor() {
        return TextColor.fromRgb(parseHexColor(Config.getClientOrDefault(Config.CLIENT.ascendedTextColor)));
    }

    public static long ascendedUniversalCableCapacity() {
        return multiplyLong(CableTier.ULTIMATE.getCableCapacity(), Config.getServerOrDefault(Config.SERVER.universalCableCapacityMultiplier));
    }

    public static long ascendedMechanicalPipeCapacity() {
        return multiplyLong(PipeTier.ULTIMATE.getPipeCapacity(), Config.getServerOrDefault(Config.SERVER.mechanicalPipeCapacityMultiplier));
    }

    public static int ascendedMechanicalPipePullAmount() {
        return multiplyInt(PipeTier.ULTIMATE.getPipePullAmount(), Config.getServerOrDefault(Config.SERVER.mechanicalPipePullAmountMultiplier));
    }

    public static double ascendedThermodynamicConductorConduction() {
        return ConductorTier.ULTIMATE.getInverseConduction() * Config.getServerOrDefault(Config.SERVER.thermodynamicConductorConductionMultiplier);
    }

    public static double ascendedThermodynamicConductorHeatCapacity() {
        return ConductorTier.ULTIMATE.getHeatCapacity() * Config.getServerOrDefault(Config.SERVER.thermodynamicConductorHeatCapacityMultiplier);
    }

    public static double ascendedThermodynamicConductorInsulation() {
        return ConductorTier.ULTIMATE.getInverseConductionInsulation() * Config.getServerOrDefault(Config.SERVER.thermodynamicConductorInsulationMultiplier);
    }

    public static int ascendedLogisticalTransporterSpeed() {
        return Config.getServerOrDefault(Config.SERVER.logisticalTransporterSpeed);
    }

    public static int ascendedLogisticalTransporterPullAmount() {
        return multiplyInt(TransporterTier.ULTIMATE.getPullAmount(), Config.getServerOrDefault(Config.SERVER.logisticalTransporterPullAmountMultiplier));
    }

    public static int ascendedLogisticalTransporterPullDelay() {
        return Config.getServerOrDefault(Config.SERVER.logisticalTransporterPullDelay);
    }

    public static int ascendedPressurizedTubeCapacity() {
        return multiplyInt(TubeTier.ULTIMATE.getTubeCapacity(), Config.getServerOrDefault(Config.SERVER.pressurizedTubeCapacityMultiplier));
    }

    public static int ascendedPressurizedTubePullAmount() {
        return multiplyInt(TubeTier.ULTIMATE.getTubePullAmount(), Config.getServerOrDefault(Config.SERVER.pressurizedTubePullAmountMultiplier));
    }

    public static int ascendedFluidTankColor() {
        return parseHexColor(Config.getClientOrDefault(Config.CLIENT.fluidTankColor));
    }

    public static int ascendedFluidTankCapacity() {
        return multiplyInt(FluidTankTier.ULTIMATE.getStorage(), Config.getServerOrDefault(Config.SERVER.fluidTankCapacityMultiplier));
    }

    public static int ascendedFluidTankOutput() {
        return multiplyInt(FluidTankTier.ULTIMATE.getOutput(), Config.getServerOrDefault(Config.SERVER.fluidTankOutputMultiplier));
    }

    public static long ascendedChemicalTankCapacity() {
        return multiplyLong(ChemicalTankTier.ULTIMATE.getStorage(), Config.getServerOrDefault(Config.SERVER.chemicalTankCapacityMultiplier));
    }

    public static long ascendedChemicalTankOutput() {
        return multiplyLong(ChemicalTankTier.ULTIMATE.getOutput(), Config.getServerOrDefault(Config.SERVER.chemicalTankOutputMultiplier));
    }

    public static long ascendedEnergyCubeCapacity() {
        return multiplyLong(EnergyCubeTier.ULTIMATE.getMaxEnergy(), Config.getServerOrDefault(Config.SERVER.energyCubeCapacityMultiplier));
    }

    public static long ascendedEnergyCubeOutput() {
        return multiplyLong(EnergyCubeTier.ULTIMATE.getOutput(), Config.getServerOrDefault(Config.SERVER.energyCubeOutputMultiplier));
    }

    public static long ascendedInductionCellCapacity() {
        return multiplyLong(InductionCellTier.ULTIMATE.getMaxEnergy(), Config.getServerOrDefault(Config.SERVER.inductionCellCapacityMultiplier));
    }

    public static long ascendedInductionProviderOutput() {
        return multiplyLong(InductionProviderTier.ULTIMATE.getOutput(), Config.getServerOrDefault(Config.SERVER.inductionProviderOutputMultiplier));
    }

    public static int ascendedBinCapacity() {
        return multiplyInt(BinTier.ULTIMATE.getStorage(), Config.getServerOrDefault(Config.SERVER.binCapacityMultiplier));
    }

    public static int ascendedFactoryProcesses() {
        return Config.getServerOrDefault(Config.SERVER.factoryProcesses);
    }

    private static int multiplyInt(int base, double multiplier) {
        return Math.toIntExact(Math.min(Integer.MAX_VALUE, multiplyLong(base, multiplier)));
    }

    private static int multiplyInt(long base, double multiplier) {
        return Math.toIntExact(Math.min(Integer.MAX_VALUE, multiplyLong(base, multiplier)));
    }

    private static long multiplyLong(long base, double multiplier) {
        return Math.round(base * multiplier);
    }

    private static int parseHexColor(String value) {
        String color = value.startsWith("#") ? value.substring(1) : value;
        return (int) Long.parseLong(color, 16);
    }

    private AscendedTierValues() {}
}
