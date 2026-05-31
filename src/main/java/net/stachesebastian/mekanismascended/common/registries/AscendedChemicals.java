package net.stachesebastian.mekanismascended.common.registries;

import mekanism.api.chemical.Chemical;
import mekanism.common.registration.impl.ChemicalDeferredRegister;
import mekanism.common.registration.impl.DeferredChemical;
import net.neoforged.bus.api.IEventBus;
import net.stachesebastian.mekanismascended.MekanismAscended;

public class AscendedChemicals {

    public static final ChemicalDeferredRegister CHEMICALS = new ChemicalDeferredRegister(MekanismAscended.MODID);

    public static final DeferredChemical<Chemical> TRANSCENDENT_ESSENCE = CHEMICALS.registerInfuse("transcendent_essence", 0xD9F2FF);

    AscendedChemicals() {}

    public static void register(IEventBus modEventBus) {
        CHEMICALS.register(modEventBus);
    }
}
