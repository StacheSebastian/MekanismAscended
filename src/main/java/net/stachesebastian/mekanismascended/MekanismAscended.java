package net.stachesebastian.mekanismascended;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.stachesebastian.mekanismascended.common.registries.AscendedBlocks;
import net.stachesebastian.mekanismascended.common.registries.AscendedChemicals;
import net.stachesebastian.mekanismascended.common.registries.AscendedCreativeTabs;
import net.stachesebastian.mekanismascended.common.registries.AscendedItems;
import net.stachesebastian.mekanismascended.common.registries.AscendedTileEntityTypes;

@Mod(MekanismAscended.MODID)
public class MekanismAscended {
    public static final String MODID = "mekanismascended";

    public MekanismAscended(IEventBus modEventBus, ModContainer modContainer) {
        AscendedBlocks.register(modEventBus);
        AscendedItems.register(modEventBus);
        AscendedChemicals.register(modEventBus);
        AscendedTileEntityTypes.register(modEventBus);
        AscendedCreativeTabs.register(modEventBus);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
}
