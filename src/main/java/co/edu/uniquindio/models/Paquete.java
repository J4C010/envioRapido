package co.edu.uniquindio.models;

public class Paquete {
    private String codigo;
    private double peso;

    public Paquete(String codigo, double peso) {
        this.codigo = codigo;
        this.peso = peso;
    }

    public double getPeso() {
        return peso;
    }
}
