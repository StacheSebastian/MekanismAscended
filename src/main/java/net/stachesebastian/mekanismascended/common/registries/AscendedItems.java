package net.stachesebastian.mekanismascended.common.registries;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.stachesebastian.mekanismascended.MekanismAscended;
import net.stachesebastian.mekanismascended.common.item.AscendedItem;

public class AscendedItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MekanismAscended.MODID);

    //Items
    public static final DeferredItem<AscendedItem> ALLOY_ASCENDED = ITEMS.register(
          "alloy_ascended",
          () -> new AscendedItem(new Item.Properties().rarity(Rarity.EPIC))
    );

    public static final DeferredItem<AscendedItem> ASCENDED_CONTROL_CIRCUIT = ITEMS.register(
            "ascended_control_circuit",
            () -> new AscendedItem(new Item.Properties().rarity(Rarity.EPIC))
    );

    public static final DeferredItem<AscendedItem> ASCENDED_TIER_INSTALLER = ITEMS.register(
            "ascended_tier_installer",
            () -> new AscendedItem(new Item.Properties().rarity(Rarity.EPIC))
    );


    //BlockItems


    private AscendedItems() {}

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
