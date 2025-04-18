package co.edu.uniquindio.models;

public class Motocicleta extends Vehiculo {
    private int cilindrada;

    public Motocicleta(String placa, String marca, String modelo, int cilindrada) {
        super(placa, marca, modelo);
        this.cilindrada = cilindrada;
    }

    @Override
    public double calcularCostoEnvio(Envio envio, Ruta ruta) {
        int cantidadPaquetes = envio.getPaquetes().size();
        double costoFijo = envio.getZona() == Zona.RURAL ? 15000 : 8000;
        return cantidadPaquetes * costoFijo;
    }

}