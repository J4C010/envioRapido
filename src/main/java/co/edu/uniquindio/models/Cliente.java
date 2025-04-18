package co.edu.uniquindio.models;

import java.util.List;
import java.util.ArrayList;


public class Cliente {
    private String nombre;
    private String cedula;
    private String correo;
    private String direccion;

    private List<Envio> envios = new ArrayList<>();
    private Envio envio;

    public Cliente(String cedula, String nombre, String correo, String direccion) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.direccion = direccion;
        this.envios = new ArrayList<>();

    }

    public void agregarEnvio(Envio envio) {
        if (envio != null) {
            envios.add(envio);
        }
    }

    public List<Envio> getEnvios() {
        return envios;
    }

    public void setEnvios(List<Envio> envios) {
        this.envios = envios;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


}
