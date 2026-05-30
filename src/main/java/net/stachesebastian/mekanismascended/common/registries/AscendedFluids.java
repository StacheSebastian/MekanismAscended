package net.stachesebastian.mekanismascended.common.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.stachesebastian.mekanismascended.MekanismAscended;

public class AscendedFluids {
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(Registries.FLUID, MekanismAscended.MODID);

    private AscendedFluids() {}

    public static void register(IEventBus modEventBus) {
        FLUIDS.register(modEventBus);
    }
}
