package net.stachesebastian.mekanismascended.client;

import mekanism.client.ClientRegistrationUtil;
import mekanism.client.render.item.TransmitterTypeDecorator;
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
import net.stachesebastian.mekanismascended.MekanismAscended;
import net.stachesebastian.mekanismascended.common.registries.AscendedBlocks;
import net.stachesebastian.mekanismascended.common.registries.AscendedTileEntityTypes;

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
    }

    @SubscribeEvent
    public static void registerItemDecorations(RegisterItemDecorationsEvent event) {
        TransmitterTypeDecorator.registerDecorators(event, AscendedBlocks.ASCENDED_UNIVERSAL_CABLE, AscendedBlocks.ASCENDED_PRESSURIZED_TUBE,
              AscendedBlocks.ASCENDED_THERMODYNAMIC_CONDUCTOR);
    }

    @SubscribeEvent
    public static void registerBlockColorHandlers(RegisterColorHandlersEvent.Block event) {
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
}
