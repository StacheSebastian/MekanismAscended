package net.stachesebastian.mekanismascended.common.content.network.transmitter;

public interface IThermodynamicConductorTierProvider {
    double getHeatCapacity();

    double getInverseConduction();

    double getInverseConductionInsulation();
}
