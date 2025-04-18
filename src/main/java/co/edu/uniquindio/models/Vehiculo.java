package co.edu.uniquindio.models;

public abstract class Vehiculo {
    protected String placa;
    protected String marca;
    protected String modelo;

    public Vehiculo(String placa, String marca, String modelo) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
    }

    public abstract double calcularCostoEnvio(Envio envio, Ruta ruta);


}

