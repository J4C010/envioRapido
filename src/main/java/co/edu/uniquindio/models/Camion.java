package co.edu.uniquindio.models;

public class Camion extends Vehiculo {
    private double capacidadCarga;

    public Camion(String placa, String marca, String modelo, double capacidadCarga) {
        super(placa, marca, modelo);
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public double calcularCostoEnvio(Envio envio, Ruta ruta) {
        double costoPeajes = ruta.getNumeroPeajes() * 12000;
        double costoPeso = envio.obtenerPesoTotal() * 7000;
        return costoPeajes + costoPeso;
    }
}