package net.stachesebastian.mekanismascended.client;

import mekanism.client.ClientRegistrationUtil;
import mekanism.client.render.item.TransmitterTypeDecorator;
import mekanism.client.render.transmitter.RenderUniversalCable;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
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
    }

    @SubscribeEvent
    public static void registerItemDecorations(RegisterItemDecorationsEvent event) {
        TransmitterTypeDecorator.registerDecorators(event, AscendedBlocks.ASCENDED_UNIVERSAL_CABLE);
    }
}
