package net.stachesebastian.mekanismascended.common.tier.transmitter;

import mekanism.api.heat.HeatAPI;

public class AscendedTierValues {

    //Universal Cable
    public static long ASCENDED_UNIVERSAL_CABLE_CAPACITY = 131072000L;

    //Mechanical Pipe
    public static long ASCENDED_MECHANICAL_PIPE_CAPACITY = 2048000L;
    public static int ASCENDED_MECHANICAL_PIPE_PULL_AMOUNT = 512000;

    //Thermal Conductor
    public static long ASCENDED_THERMAL_CONDUCTOR_CONDUCTION = 5L;
    public static long ASCENDED_THERMAL_CONDUCTOR_HEAT_CAPACITY = (long) HeatAPI.DEFAULT_HEAT_CAPACITY;
    public static long ASCENDED_THERMAL_CONDUCTOR_INSULATION = 10000000L;

    public AscendedTierValues() {}
}
