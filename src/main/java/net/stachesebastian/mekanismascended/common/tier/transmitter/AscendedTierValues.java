package net.stachesebastian.mekanismascended.common.tier.transmitter;

import mekanism.api.heat.HeatAPI;
import net.neoforged.neoforge.fluids.FluidType;

public class AscendedTierValues {

    //Universal Cable
    public static long ASCENDED_UNIVERSAL_CABLE_CAPACITY = 16 * 8192000L; //ULTIMATE: 8192000L

    //Mechanical Pipe
    public static long ASCENDED_MECHANICAL_PIPE_CAPACITY = 16 * 128 * FluidType.BUCKET_VOLUME; //ULTIMATE: 128 * FluidType.BUCKET_VOLUME
    public static int ASCENDED_MECHANICAL_PIPE_PULL_AMOUNT = 16 * 32 * FluidType.BUCKET_VOLUME; //ULTIMATE: 32 * FluidType.BUCKET_VOLUME

    //Thermodynamic Conductor
    public static double ASCENDED_THERMODYNAMIC_CONDUCTOR_CONDUCTION = 5; //ULTIMATE: 5
    public static double ASCENDED_THERMODYNAMIC_CONDUCTOR_HEAT_CAPACITY = HeatAPI.DEFAULT_HEAT_CAPACITY; //ULTIMATE: HeatAPI.DEFAULT_HEAT_CAPACITY (1)
    public static double ASCENDED_THERMODYNAMIC_CONDUCTOR_INSULATION = 100 * 100000; //ULTIMATE: 100000

    public static int ASCENDED_LOGISTICAL_TRANSPORTER_SPEED = 50; //ULTIMATE: 50 (Max: 100, any bigger value would need multiple updates per tick, workaround not worth performance risk) (Animation is skipped at 100)
    public static int ASCENDED_LOGISTICAL_TRANSPORTER_PULL_AMOUNT = 4 * 64; //ULTIMATE: 64

    public static int ASCENDED_PRESSURIZED_TUBE_CAPACITY = 16 * 1024 * FluidType.BUCKET_VOLUME; //ULTIMATE: 1024 * FluidType.BUCKET_VOLUME
    public static int ASCENDED_PRESSURIZED_TUBE_PULL_AMOUNT = 16 * 256 * FluidType.BUCKET_VOLUME; //ULTIMATE: 256 * FluidType.BUCKET_VOLUME

    public AscendedTierValues() {}
}
