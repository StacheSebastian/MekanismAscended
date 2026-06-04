package net.stachesebastian.mekanismascended;

import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {

    private static final double MAX_MULTIPLIER = 1_048_576.0;
    private static final String RGB_HEX_PATTERN = "#?[0-9a-fA-F]{6}";
    private static final String ARGB_HEX_PATTERN = "#?[0-9a-fA-F]{8}";

    public static final ModConfigSpec CLIENT_SPEC;
    public static final Client CLIENT;
    public static final ModConfigSpec SERVER_SPEC;
    public static final Server SERVER;

    static {
        ModConfigSpec.Builder clientBuilder = new ModConfigSpec.Builder();
        CLIENT = new Client(clientBuilder);
        CLIENT_SPEC = clientBuilder.build();

        ModConfigSpec.Builder serverBuilder = new ModConfigSpec.Builder();
        SERVER = new Server(serverBuilder);
        SERVER_SPEC = serverBuilder.build();
    }

    public static int getClientOrDefault(ModConfigSpec.IntValue value) {
        return CLIENT_SPEC.isLoaded() ? value.get() : value.getDefault();
    }

    public static String getClientOrDefault(ModConfigSpec.ConfigValue<String> value) {
        return CLIENT_SPEC.isLoaded() ? value.get() : value.getDefault();
    }

    public static int getServerOrDefault(ModConfigSpec.IntValue value) {
        return SERVER_SPEC.isLoaded() ? value.get() : value.getDefault();
    }

    public static double getServerOrDefault(ModConfigSpec.DoubleValue value) {
        return SERVER_SPEC.isLoaded() ? value.get() : value.getDefault();
    }

    public static class Client {
        public final ModConfigSpec.ConfigValue<String> ascendedTextColor;
        public final ModConfigSpec.ConfigValue<String> fluidTankColor;

        private Client(ModConfigSpec.Builder builder) {
            builder.push("visuals");

            ascendedTextColor = builder
                  .comment("RGB hex text color used for Ascended tier names. Format: RRGGBB or #RRGGBB.")
                  .define("textColor", "FAD64A", value -> value instanceof String string && string.matches(RGB_HEX_PATTERN));
            fluidTankColor = builder
                  .comment("ARGB hex color used by the Ascended Fluid Tank renderer. Format: AARRGGBB or #AARRGGBB.")
                  .define("fluidTankColor", "FFFFAA00", value -> value instanceof String string && string.matches(ARGB_HEX_PATTERN));

            builder.pop();
        }
    }

    public static class Server {
        public final ModConfigSpec.DoubleValue universalCableCapacityMultiplier;

        public final ModConfigSpec.DoubleValue mechanicalPipeCapacityMultiplier;
        public final ModConfigSpec.DoubleValue mechanicalPipePullAmountMultiplier;

        public final ModConfigSpec.DoubleValue thermodynamicConductorConductionMultiplier;
        public final ModConfigSpec.DoubleValue thermodynamicConductorHeatCapacityMultiplier;
        public final ModConfigSpec.DoubleValue thermodynamicConductorInsulationMultiplier;

        public final ModConfigSpec.IntValue logisticalTransporterSpeed;
        public final ModConfigSpec.DoubleValue logisticalTransporterPullAmountMultiplier;
        public final ModConfigSpec.IntValue logisticalTransporterPullDelay;

        public final ModConfigSpec.DoubleValue pressurizedTubeCapacityMultiplier;
        public final ModConfigSpec.DoubleValue pressurizedTubePullAmountMultiplier;

        public final ModConfigSpec.DoubleValue fluidTankCapacityMultiplier;
        public final ModConfigSpec.DoubleValue fluidTankOutputMultiplier;

        public final ModConfigSpec.DoubleValue chemicalTankCapacityMultiplier;
        public final ModConfigSpec.DoubleValue chemicalTankOutputMultiplier;

        public final ModConfigSpec.DoubleValue energyCubeCapacityMultiplier;
        public final ModConfigSpec.DoubleValue energyCubeOutputMultiplier;

        public final ModConfigSpec.DoubleValue inductionCellCapacityMultiplier;
        public final ModConfigSpec.DoubleValue inductionProviderOutputMultiplier;

        public final ModConfigSpec.DoubleValue binCapacityMultiplier;
        public final ModConfigSpec.IntValue factoryProcesses;

        private Server(ModConfigSpec.Builder builder) {
            builder.push("transmitters");

            builder.push("universal_cable");
            universalCableCapacityMultiplier = multiplier(builder, "universalCableCapacityMultiplier", 16.0, "Multiplier against Ultimate Universal Cable capacity.");
            builder.pop();

            builder.push("mechanical_pipe");
            mechanicalPipeCapacityMultiplier = multiplier(builder, "mechanicalPipeCapacityMultiplier", 16.0, "Multiplier against Ultimate Mechanical Pipe capacity.");
            mechanicalPipePullAmountMultiplier = multiplier(builder, "mechanicalPipePullAmountMultiplier", 16.0, "Multiplier against Ultimate Mechanical Pipe pull amount.");
            builder.pop();

            builder.push("thermodynamic_conductor");
            thermodynamicConductorConductionMultiplier = multiplier(builder, "thermodynamicConductorConductionMultiplier", 1.0, "Multiplier against Ultimate Thermodynamic Conductor conduction.");
            thermodynamicConductorHeatCapacityMultiplier = multiplier(builder, "thermodynamicConductorHeatCapacityMultiplier", 1.0, "Multiplier against Ultimate Thermodynamic Conductor heat capacity.");
            thermodynamicConductorInsulationMultiplier = multiplier(builder, "thermodynamicConductorInsulationMultiplier", 100.0, "Multiplier against Ultimate Thermodynamic Conductor insulation.");
            builder.pop();

            builder.push("logistical_transporter");
            logisticalTransporterSpeed = builder
                  .worldRestart()
                  .comment("Ascended Logistical Transporter speed. Values above 100 require multiple updates per tick and are intentionally not supported.")
                  .defineInRange("logisticalTransporterSpeed", 50, 1, 100);
            logisticalTransporterPullAmountMultiplier = multiplier(builder, "logisticalTransporterPullAmountMultiplier", 4.0, "Multiplier against Ultimate Logistical Transporter pull amount.");
            logisticalTransporterPullDelay = builder
                  .worldRestart()
                  .comment("Ascended Logistical Transporter pull delay in ticks. Mekanism standard is 10 ticks for all tiers.")
                  .defineInRange("logisticalTransporterPullDelay", 5, 1, Integer.MAX_VALUE);
            builder.pop();

            builder.push("pressurized_tube");
            pressurizedTubeCapacityMultiplier = multiplier(builder, "pressurizedTubeCapacityMultiplier", 16.0, "Multiplier against Ultimate Pressurized Tube capacity.");
            pressurizedTubePullAmountMultiplier = multiplier(builder, "pressurizedTubePullAmountMultiplier", 16.0, "Multiplier against Ultimate Pressurized Tube pull amount.");
            builder.pop();
            builder.pop();

            builder.push("storage");

            builder.push("fluid_tank");
            fluidTankCapacityMultiplier = multiplier(builder, "fluidTankCapacityMultiplier", 16.0, "Multiplier against Ultimate Fluid Tank capacity.");
            fluidTankOutputMultiplier = multiplier(builder, "fluidTankOutputMultiplier", 16.0, "Multiplier against Ultimate Fluid Tank output.");
            builder.pop();

            builder.push("chemical_tank");
            chemicalTankCapacityMultiplier = multiplier(builder, "chemicalTankCapacityMultiplier", 16.0, "Multiplier against Ultimate Chemical Tank capacity.");
            chemicalTankOutputMultiplier = multiplier(builder, "chemicalTankOutputMultiplier", 16.0, "Multiplier against Ultimate Chemical Tank output.");
            builder.pop();

            builder.push("energy_cube");
            energyCubeCapacityMultiplier = multiplier(builder, "energyCubeCapacityMultiplier", 16.0, "Multiplier against Ultimate Energy Cube capacity.");
            energyCubeOutputMultiplier = multiplier(builder, "energyCubeOutputMultiplier", 16.0, "Multiplier against Ultimate Energy Cube output.");
            builder.pop();

            builder.push("induction_matrix");
            inductionCellCapacityMultiplier = multiplier(builder, "inductionCellCapacityMultiplier", 16.0, "Multiplier against Ultimate Induction Cell capacity.");
            inductionProviderOutputMultiplier = multiplier(builder, "inductionProviderOutputMultiplier", 16.0, "Multiplier against Ultimate Induction Provider output.");
            builder.pop();

            builder.push("item_bin");
            binCapacityMultiplier = multiplier(builder, "binCapacityMultiplier", 16.0, "Multiplier against Ultimate Bin capacity.");
            builder.pop();
            builder.pop();

            factoryProcesses = builder
                  .worldRestart()
                  .comment("Number of processing slots in Ascended Factories.")
                  .defineInRange("factoryProcesses", 15, 1, 64);
        }

        private static ModConfigSpec.DoubleValue multiplier(ModConfigSpec.Builder builder, String name, double defaultValue, String comment) {
            return builder.worldRestart().comment(comment).defineInRange(name, defaultValue, 0.0, MAX_MULTIPLIER);
        }
    }
}
