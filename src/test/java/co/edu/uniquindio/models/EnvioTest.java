package co.edu.uniquindio.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.*;


class EnvioTest {

    @Test
    public void testCalcularCostoEnvio_Camion() {
        Cliente cliente = new Cliente("123456789", "Carlos Perez", "carlos@gmail.com", "Calle 123"); // Suponiendo constructor
        Ruta ruta = new Ruta(2, 0);
        Envio envio = new Envio("E001", Zona.RURAL, LocalDate.now(), cliente, ruta);
        envio.agregarPaquete(new Paquete("P001", 10));
        envio.agregarPaquete(new Paquete("P002", 5));

        Vehiculo camion = new Camion("ABC123", "Volvo", "X", 1000);
        envio.calcularCosto(camion);

        double esperado = (2 * 12000) + ((10 + 5) * 7000);
        assertEquals(esperado, envio.getCostoTotal(), 0.01);
    }

    @Test
    public void testObtenerEnviosPesoMayor50() {
        Cliente cliente = new Cliente("123456789", "Carlos Perez", "carlos@gmail.com", "Calle 123");
        Ruta ruta = new Ruta(0, 0);
        Envio envio1 = new Envio("E001", Zona.URBANA, LocalDate.now(), cliente, ruta);
        Envio envio2 = new Envio("E002", Zona.RURAL, LocalDate.now(), cliente, ruta);

        for (int i = 0; i < 10; i++) {
            envio1.agregarPaquete(new Paquete("P" + i, 3)); // Total 30kg
            envio2.agregarPaquete(new Paquete("Q" + i, 6)); // Total 60kg
        }

        List<Envio> todos = List.of(envio1, envio2);

        List<Envio> mayores50 = todos.stream()
                .filter(e -> e.obtenerPesoTotal() > 50)
                .toList();

        assertEquals(1, mayores50.size());
        assertEquals("E002", mayores50.get(0).codigo);
    }

}

