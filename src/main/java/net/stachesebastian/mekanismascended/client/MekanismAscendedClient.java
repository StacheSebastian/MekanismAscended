package net.stachesebastian.mekanismascended.client;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.stachesebastian.mekanismascended.MekanismAscended;

@Mod(value = MekanismAscended.MODID, dist = Dist.CLIENT)
public class MekanismAscendedClient {

    public MekanismAscendedClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }
}
