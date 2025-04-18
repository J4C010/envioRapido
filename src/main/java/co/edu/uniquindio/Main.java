package co.edu.uniquindio;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import co.edu.uniquindio.models.*;
import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Crear cliente
        Cliente cliente = new Cliente("Andrea Torres", "1234567890", "andrea@gmail.com", "Cra 45 #12");

        // Paquetes compartidos para pruebas
        Paquete paquete1 = new Paquete("PKG001", 10);
        Paquete paquete2 = new Paquete("PKG002", 12);
        Paquete paquete3 = new Paquete("PKG003", 5);

        // Ruta de prueba
        Ruta ruta = new Ruta(3, 100); // 3 peajes, 100 km

        // === Envío en Camión ===
        Vehiculo camion = new Camion("AAA123", "Volvo", "FH16", 30);
        Envio envioCamion = new Envio("ENV001", Zona.RURAL, LocalDate.now(),
                Arrays.asList(paquete1, paquete2), camion, ruta);
        double costoCamion = camion.calcularCostoEnvio(envioCamion, ruta);
        envioCamion.setCostoTotal(costoCamion);
        cliente.agregarEnvio(envioCamion);

        // === Envío en Furgoneta ===
        Vehiculo furgoneta = new Furgoneta("BBB456", "Renault", "Kangoo", Transmision.MANUAL);
        Envio envioFurgoneta = new Envio("ENV002", Zona.URBANA, LocalDate.now(),
                Arrays.asList(paquete3), furgoneta, ruta);
        double costoFurgoneta = furgoneta.calcularCostoEnvio(envioFurgoneta, ruta);
        envioFurgoneta.setCostoTotal(costoFurgoneta);
        cliente.agregarEnvio(envioFurgoneta);

        // === Envío en Motocicleta ===
        Vehiculo motocicleta = new Motocicleta("CCC789", "Yamaha", "XTZ", 150);
        Envio envioMoto = new Envio("ENV003", Zona.URBANA, LocalDate.now(),
                Arrays.asList(paquete1, paquete3), motocicleta, ruta);
        double costoMoto = motocicleta.calcularCostoEnvio(envioMoto, ruta);
        envioMoto.setCostoTotal(costoMoto);
        cliente.agregarEnvio(envioMoto);

        // === Mostrar los envíos del cliente ===
        System.out.println("📦 Envíos realizados por " + cliente.getNombre() + ":\n");

        for (Envio envio : cliente.getEnvios()) {
            System.out.println("Código: " + envio.getCodigoEnvio());
            System.out.println("Zona: " + envio.getZona());
            System.out.println("Fecha: " + envio.getFechaEnvio());
            System.out.println("Vehículo: " + envio.getVehiculo().getClass().getSimpleName());
            System.out.println("Costo Total: $" + envio.getCostoTotal() + "\n");
        }
    }
}

