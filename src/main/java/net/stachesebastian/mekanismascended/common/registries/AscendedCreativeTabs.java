package net.stachesebastian.mekanismascended.common.registries;

import mekanism.common.registries.MekanismCreativeTabs;
import mekanism.common.registration.impl.CreativeTabDeferredRegister;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.stachesebastian.mekanismascended.MekanismAscended;

public class AscendedCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(
          Registries.CREATIVE_MODE_TAB,
          MekanismAscended.MODID
    );

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MEKANISM_ASCENDED = CREATIVE_MODE_TABS.register(
          MekanismAscended.MODID,
          () -> CreativeModeTab.builder()
                  .title(Component.translatable("itemGroup.mekanismascended"))
                  .icon(() -> AscendedItems.ALLOY_TRANSCENDENT.get().getDefaultInstance())
                  .withTabsBefore(MekanismCreativeTabs.MEKANISM.getKey())
                  .displayItems((parameters, output) -> {
                      CreativeTabDeferredRegister.addToDisplay(AscendedItems.ITEMS, output);
                      CreativeTabDeferredRegister.addToDisplay(AscendedBlocks.BLOCKS, output);
                  })
                  .build()
    );

    private AscendedCreativeTabs() {}

    public static void register(IEventBus modEventBus) {
        CREATIVE_MODE_TABS.register(modEventBus);
    }
}
