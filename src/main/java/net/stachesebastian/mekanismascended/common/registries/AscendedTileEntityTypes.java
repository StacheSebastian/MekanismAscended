package net.stachesebastian.mekanismascended.common.registries;

import mekanism.api.functions.ConstantPredicates;
import mekanism.common.Mekanism;
import mekanism.common.capabilities.Capabilities;
import mekanism.common.integration.computer.ComputerCapabilityHelper;
import mekanism.common.integration.energy.EnergyCompatUtils;
import mekanism.common.registration.impl.TileEntityTypeDeferredRegister;
import mekanism.common.registration.impl.TileEntityTypeRegistryObject;
import mekanism.common.tile.transmitter.TileEntityTransmitter;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.stachesebastian.mekanismascended.MekanismAscended;
import net.stachesebastian.mekanismascended.common.tile.transmitter.AscendedTEUniversalCable;

public class AscendedTileEntityTypes {
    public static final TileEntityTypeDeferredRegister TILE_ENTITY_TYPES = new TileEntityTypeDeferredRegister(MekanismAscended.MODID);

    public static final TileEntityTypeRegistryObject<AscendedTEUniversalCable> ASCENDED_UNIVERSAL_CABLE = registerCable();

    private AscendedTileEntityTypes() {}

    public static void register(IEventBus modEventBus) {
        TILE_ENTITY_TYPES.register(modEventBus);
    }

    private static TileEntityTypeRegistryObject<AscendedTEUniversalCable> registerCable() {
        TileEntityTypeDeferredRegister.BlockEntityTypeBuilder<AscendedTEUniversalCable> builder = transmitterBuilder(AscendedBlocks.ASCENDED_UNIVERSAL_CABLE, AscendedTEUniversalCable::new);
        EnergyCompatUtils.addBlockCapabilities(builder);
        if (Mekanism.hooks.computerCompatEnabled()) {
            ComputerCapabilityHelper.addComputerCapabilities(builder, ConstantPredicates.ALWAYS_TRUE);
        }
        return builder.build();
    }

    private static <BE extends TileEntityTransmitter> TileEntityTypeDeferredRegister.BlockEntityTypeBuilder<BE> transmitterBuilder(DeferredHolder<Block, ?> block, BlockEntityFactory<BE> factory) {
        return TILE_ENTITY_TYPES.builder(block, (pos, state) -> factory.create(block, pos, state))
                .serverTicker(TileEntityTransmitter::tickServer)
                .withSimple(Capabilities.ALLOY_INTERACTION)
                .with(Capabilities.CONFIGURABLE, TileEntityTransmitter.CONFIGURABLE_PROVIDER);
    }



    @FunctionalInterface
    private interface BlockEntityFactory<BE extends TileEntityTransmitter> {
        BE create(Holder<Block> blockProvider, BlockPos pos, BlockState state);
    }

}