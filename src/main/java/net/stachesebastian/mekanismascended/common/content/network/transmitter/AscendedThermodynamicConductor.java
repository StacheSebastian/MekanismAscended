package net.stachesebastian.mekanismascended.common.content.network.transmitter;

import java.util.Collections;
import java.util.List;
import mekanism.api.SerializationConstants;
import mekanism.api.heat.IHeatCapacitor;
import mekanism.common.capabilities.heat.CachedAmbientTemperature;
import mekanism.common.capabilities.heat.VariableHeatCapacitor;
import mekanism.common.content.network.transmitter.ThermodynamicConductor;
import mekanism.common.tile.transmitter.TileEntityTransmitter;
import mekanism.common.upgrade.transmitter.ThermodynamicConductorUpgradeData;
import mekanism.common.util.NBTUtils;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.Block;
import net.stachesebastian.mekanismascended.common.tier.transmitter.AscendedTierValues;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AscendedThermodynamicConductor extends ThermodynamicConductor {

    private final CachedAmbientTemperature ascendedAmbientTemperature = new CachedAmbientTemperature(this::getLevel, this::getBlockPos);
    private double ascendedClientTemperature = -1;
    private final List<IHeatCapacitor> ascendedCapacitors;
    public final VariableHeatCapacitor ascendedBuffer;

    public AscendedThermodynamicConductor(Holder<Block> blockProvider, TileEntityTransmitter tile) {
        super(blockProvider, tile);
        ascendedBuffer = VariableHeatCapacitor.create(
              AscendedTierValues.ASCENDED_THERMODYNAMIC_CONDUCTOR_HEAT_CAPACITY,
              () -> AscendedTierValues.ASCENDED_THERMODYNAMIC_CONDUCTOR_CONDUCTION,
              () -> AscendedTierValues.ASCENDED_THERMODYNAMIC_CONDUCTOR_INSULATION,
              ascendedAmbientTemperature,
              this
        );
        ascendedCapacitors = Collections.singletonList(ascendedBuffer);
    }

    @Nullable
    @Override
    public ThermodynamicConductorUpgradeData getUpgradeData() {
        return new ThermodynamicConductorUpgradeData(redstoneReactive, getConnectionTypesRaw(), ascendedBuffer.getHeat());
    }

    @Override
    public void parseUpgradeData(@NotNull ThermodynamicConductorUpgradeData data) {
        redstoneReactive = data.redstoneReactive;
        setConnectionTypesRaw(data.connectionTypes);
        ascendedBuffer.setHeat(data.heat);
    }

    @NotNull
    @Override
    public CompoundTag getReducedUpdateTag(@NotNull HolderLookup.Provider provider, CompoundTag updateTag) {
        updateTag = super.getReducedUpdateTag(provider, updateTag);
        updateTag.putDouble(SerializationConstants.TEMPERATURE, ascendedBuffer.getHeat());
        return updateTag;
    }

    @Override
    public boolean handleUpdateTag(@NotNull CompoundTag tag, @NotNull HolderLookup.Provider provider) {
        boolean refreshModelData = super.handleUpdateTag(tag, provider);
        NBTUtils.setDoubleIfPresent(tag, SerializationConstants.TEMPERATURE, ascendedBuffer::setHeat);
        return refreshModelData;
    }

    @NotNull
    @Override
    public List<IHeatCapacitor> getHeatCapacitors(Direction side) {
        return ascendedCapacitors;
    }

    @Override
    public void onContentsChanged() {
        if (!isRemote()) {
            if (ascendedClientTemperature == -1) {
                ascendedClientTemperature = ascendedAmbientTemperature.getAsDouble();
            }
            if (Math.abs(ascendedBuffer.getTemperature() - ascendedClientTemperature) > (ascendedBuffer.getTemperature() / 20)) {
                ascendedClientTemperature = ascendedBuffer.getTemperature();
                getTransmitterTile().sendUpdatePacket();
            }
        }
        getTransmitterTile().setChanged();
    }
}
