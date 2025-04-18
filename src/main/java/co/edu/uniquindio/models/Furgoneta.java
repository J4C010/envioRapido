package co.edu.uniquindio.models;

public class Furgoneta extends Vehiculo {
    private Transmision transmision;

    public Furgoneta(String placa, String marca, String modelo, Transmision transmision) {
        super(placa, marca, modelo);
        this.transmision = transmision;
    }

    @Override
    public double calcularCostoEnvio(Envio envio, Ruta ruta) {
        double costoCombustible = ruta.getDistanciaKm() * 3000;
        return costoCombustible + 10000;
    }
    public Transmision getTransmision() {
        return transmision;
    }
}

