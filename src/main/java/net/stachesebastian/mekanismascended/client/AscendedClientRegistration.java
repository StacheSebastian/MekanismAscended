package net.stachesebastian.mekanismascended.client;

import mekanism.client.ClientRegistrationUtil;
import mekanism.client.render.RenderPropertiesProvider.MekRenderProperties;
import mekanism.client.render.item.TransmitterTypeDecorator;
import mekanism.client.render.item.block.RenderEnergyCubeItem;
import mekanism.client.render.item.block.RenderFluidTankItem;
import mekanism.client.render.tileentity.RenderEnergyCube;
import mekanism.client.render.tileentity.RenderFluidTank;
import mekanism.client.render.transmitter.RenderLogisticalTransporter;
import mekanism.client.render.transmitter.RenderMechanicalPipe;
import mekanism.client.render.transmitter.RenderPressurizedTube;
import mekanism.client.render.transmitter.RenderThermodynamicConductor;
import mekanism.client.render.transmitter.RenderUniversalCable;
import mekanism.common.tile.transmitter.TileEntityLogisticalTransporter;
import mekanism.common.util.WorldUtils;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.event.RegisterItemDecorationsEvent;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.stachesebastian.mekanismascended.MekanismAscended;
import net.stachesebastian.mekanismascended.common.registries.AscendedBlocks;
import net.stachesebastian.mekanismascended.common.registries.AscendedTileEntityTypes;
import net.stachesebastian.mekanismascended.common.tier.transmitter.AscendedTierValues;

@EventBusSubscriber(modid = MekanismAscended.MODID, value = Dist.CLIENT)
public class AscendedClientRegistration {

    private AscendedClientRegistration() {}

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        ClientRegistrationUtil.bindTileEntityRenderer(event, RenderUniversalCable::new, AscendedTileEntityTypes.ASCENDED_UNIVERSAL_CABLE);
        ClientRegistrationUtil.bindTileEntityRenderer(event, RenderPressurizedTube::new, AscendedTileEntityTypes.ASCENDED_PRESSURIZED_TUBE);
        ClientRegistrationUtil.bindTileEntityRenderer(event, RenderThermodynamicConductor::new, AscendedTileEntityTypes.ASCENDED_THERMODYNAMIC_CONDUCTOR);
        ClientRegistrationUtil.bindTileEntityRenderer(event, RenderMechanicalPipe::new, AscendedTileEntityTypes.ASCENDED_MECHANICAL_PIPE);
        ClientRegistrationUtil.bindTileEntityRenderer(event, RenderLogisticalTransporter::new, AscendedTileEntityTypes.ASCENDED_LOGISTICAL_TRANSPORTER);
        ClientRegistrationUtil.bindTileEntityRenderer(event, RenderFluidTank::new, AscendedTileEntityTypes.ASCENDED_FLUID_TANK);
        ClientRegistrationUtil.bindTileEntityRenderer(event, RenderEnergyCube::new, AscendedTileEntityTypes.ASCENDED_ENERGY_CUBE);
    }

    @SubscribeEvent
    public static void registerItemDecorations(RegisterItemDecorationsEvent event) {
        TransmitterTypeDecorator.registerDecorators(event, AscendedBlocks.ASCENDED_UNIVERSAL_CABLE, AscendedBlocks.ASCENDED_PRESSURIZED_TUBE,
              AscendedBlocks.ASCENDED_THERMODYNAMIC_CONDUCTOR);
    }

    @SubscribeEvent
    public static void registerBlockColorHandlers(RegisterColorHandlersEvent.Block event) {
        ClientRegistrationUtil.registerBlockColorHandler(event, (state, world, pos, tintIndex) -> {
            if (tintIndex == 1) {
                return AscendedTierValues.ASCENDED_FLUID_TANK_COLOR;
            }
            return -1;
        }, AscendedBlocks.ASCENDED_FLUID_TANK);
        ClientRegistrationUtil.registerBlockColorHandler(event, (state, world, pos, tintIndex) -> {
            if (tintIndex == 1 && pos != null) {
                TileEntityLogisticalTransporter transporter = WorldUtils.getTileEntity(TileEntityLogisticalTransporter.class, world, pos);
                if (transporter != null && transporter.getTransmitter().getColor() != null) {
                    return transporter.getTransmitter().getColor().getPackedColor();
                }
            }
            return -1;
        }, AscendedBlocks.ASCENDED_LOGISTICAL_TRANSPORTER);
    }

    @SubscribeEvent
    public static void registerItemColorHandlers(RegisterColorHandlersEvent.Item event) {
        ClientRegistrationUtil.registerItemColorHandler(event, (stack, tintIndex) -> {
            if (tintIndex == 1) {
                return AscendedTierValues.ASCENDED_FLUID_TANK_COLOR;
            }
            return -1;
        }, AscendedBlocks.ASCENDED_FLUID_TANK);
    }

    @SubscribeEvent
    public static void registerClientExtensions(RegisterClientExtensionsEvent event) {
        ClientRegistrationUtil.registerItemExtensions(event, new MekRenderProperties(RenderFluidTankItem.RENDERER), AscendedBlocks.ASCENDED_FLUID_TANK);
        ClientRegistrationUtil.registerItemExtensions(event, new MekRenderProperties(RenderEnergyCubeItem.RENDERER), AscendedBlocks.ASCENDED_ENERGY_CUBE);
    }
}
