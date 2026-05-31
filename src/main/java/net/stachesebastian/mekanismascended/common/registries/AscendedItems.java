package net.stachesebastian.mekanismascended.common.registries;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.stachesebastian.mekanismascended.MekanismAscended;
import net.stachesebastian.mekanismascended.common.item.AscendedItem;
import net.stachesebastian.mekanismascended.common.item.AscendedItemAlloy;
import net.stachesebastian.mekanismascended.common.tier.AscendedAlloyTier;

public class AscendedItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MekanismAscended.MODID);

    //Items
    public static final DeferredItem<AscendedItemAlloy> ALLOY_TRANSCENDENT = ITEMS.register(
          "alloy_transcendent",
          () -> new AscendedItemAlloy(AscendedAlloyTier.TRANSCENDENT, new Item.Properties().rarity(Rarity.EPIC))
    );

    public static final DeferredItem<AscendedItem> ASCENDED_CONTROL_CIRCUIT = ITEMS.register(
            "ascended_control_circuit",
            () -> new AscendedItem(new Item.Properties().rarity(Rarity.EPIC))
    );

    public static final DeferredItem<AscendedItem> ASCENDED_TIER_INSTALLER = ITEMS.register(
            "ascended_tier_installer",
            () -> new AscendedItem(new Item.Properties().rarity(Rarity.EPIC))
    );

    public static final DeferredItem<Item> ENRICHED_NETHER_STAR = ITEMS.register(
            "enriched_nether_star",
            () -> new Item(new Item.Properties().rarity(Rarity.EPIC))
    );

    //BlockItems


    private AscendedItems() {}

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
