package net.stachesebastian.mekanismascended.common.registries;

import mekanism.common.registration.impl.ItemDeferredRegister;
import mekanism.common.registration.impl.ItemRegistryObject;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.stachesebastian.mekanismascended.MekanismAscended;
import net.stachesebastian.mekanismascended.common.item.AscendedItem;
import net.stachesebastian.mekanismascended.common.item.AscendedItemAlloy;
import net.stachesebastian.mekanismascended.common.item.AscendedItemTierInstaller;
import net.stachesebastian.mekanismascended.common.tier.AscendedAlloyTier;

public class AscendedItems {
    public static final ItemDeferredRegister ITEMS = new ItemDeferredRegister(MekanismAscended.MODID);

    //Items
    public static final ItemRegistryObject<AscendedItemAlloy> ALLOY_TRANSCENDENT = ITEMS.register(
          "alloy_transcendent",
          () -> new AscendedItemAlloy(AscendedAlloyTier.TRANSCENDENT, new Item.Properties().rarity(Rarity.EPIC))
    );

    public static final ItemRegistryObject<AscendedItem> ASCENDED_CONTROL_CIRCUIT = ITEMS.register(
            "ascended_control_circuit",
            () -> new AscendedItem(new Item.Properties().rarity(Rarity.EPIC))
    );

    public static final ItemRegistryObject<AscendedItemTierInstaller> ASCENDED_TIER_INSTALLER = ITEMS.register(
            "ascended_tier_installer",
            () -> new AscendedItemTierInstaller(new Item.Properties().rarity(Rarity.EPIC))
    );

    public static final ItemRegistryObject<Item> ENRICHED_NETHER_STAR = ITEMS.register(
            "enriched_nether_star",
            () -> new Item(new Item.Properties())
    );

    //BlockItems


    private AscendedItems() {}

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
