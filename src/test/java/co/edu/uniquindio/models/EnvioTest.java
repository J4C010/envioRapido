package co.edu.uniquindio.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.*;

class EnvioTest {

    @Test
    public void testCalcularCostoEnvio_Camion() {
        Cliente cliente = new Cliente("123456789", "Carlos Perez", "carlos@gmail.com", "Calle 123");
        Ruta ruta = new Ruta(2, 0);

        List<Paquete> paquetes = Arrays.asList(
                new Paquete("P001", 10),
                new Paquete("P002", 5)
        );

        Vehiculo camion = new Camion("ABC123", "Volvo", "X", 1000);
        Envio envio = new Envio("E001", Zona.RURAL, LocalDate.now(), paquetes, camion, ruta);
        envio.calcularCosto(camion);

        double esperado = (2 * 12000) + ((10 + 5) * 7000);
        assertEquals(esperado, envio.getCostoTotal(), 0.01);
    }

    @Test
    public void testObtenerEnviosPesoMayor50() {
        Cliente cliente = new Cliente("123456789", "Carlos Perez", "carlos@gmail.com", "Calle 123");
        Ruta ruta = new Ruta(0, 0);

        List<Paquete> paquetes1 = new ArrayList<>();
        List<Paquete> paquetes2 = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            paquetes1.add(new Paquete("P" + i, 3)); // Total 30kg
            paquetes2.add(new Paquete("Q" + i, 6)); // Total 60kg
        }

        Vehiculo camion = new Camion("ABC123", "Volvo", "X", 1000); // se puede reutilizar

        Envio envio1 = new Envio("E001", Zona.URBANA, LocalDate.now(), paquetes1, camion, ruta);
        Envio envio2 = new Envio("E002", Zona.RURAL, LocalDate.now(), paquetes2, camion, ruta);

        List<Envio> todos = List.of(envio1, envio2);

        List<Envio> mayores50 = todos.stream()
                .filter(e -> e.obtenerPesoTotal() > 50)
                .toList();

        assertEquals(1, mayores50.size());
        assertEquals("E002", mayores50.get(0).getCodigoEnvio());
    }
}


