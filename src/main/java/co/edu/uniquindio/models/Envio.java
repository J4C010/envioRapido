package co.edu.uniquindio.models;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;


public class Envio {
    private String codigoEnvio;
    private double costoTotal;
    private Zona zona;
    private LocalDate fechaEnvio;
    private List<Paquete> paquetes;
    private Cliente cliente;
    private Ruta ruta;

    private Vehiculo vehiculo; // Atributo nuevo

    public Envio(String codigoEnvio, Zona zona, LocalDate fechaEnvio,
                 List<Paquete> paquetes, Vehiculo vehiculo, Ruta ruta) {
        this.codigoEnvio = codigoEnvio;
        this.zona = zona;
        this.fechaEnvio = fechaEnvio;
        this.paquetes = paquetes != null ? paquetes : new ArrayList<>();
        this.ruta = ruta;
        this.vehiculo = vehiculo;
        this.cliente = null;
    }

    // Getter para mostrar el tipo de vehículo
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    // Método para agregar paquetes
    public void agregarPaquete(Paquete p) {
        paquetes.add(p);
    }

    // Método para obtener el peso total de los paquetes
    public double obtenerPesoTotal() {
        return paquetes.stream().mapToDouble(Paquete::getPeso).sum();
    }

    public List<Paquete> getPaquetes() {
        return paquetes;
    }

    public Zona getZona() {
        return zona;
    }


    public void calcularCosto(Vehiculo vehiculo) {
        this.costoTotal = vehiculo.calcularCostoEnvio(this, ruta);
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public String getCodigoEnvio() {
        return codigoEnvio;
    }

    public void setCodigoEnvio(String codigoEnvio) {
        this.codigoEnvio = codigoEnvio;
    }

    public LocalDate getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDate fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCostoTotal(double costoCamion) {
    }

}


