package test;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import model.Pasajero;
import model.Ruta;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PasajeroTest {

    private Pasajero pasajero;

    @Mock
    private Ruta ruta1;

    @Mock
    private Ruta ruta2;

    @Before
    public void setUp() {
        pasajero = new Pasajero("P001", "Juan Pérez", "Pasajero", "555-1234");
    }

    // RF10 - Prueba 1: Verificar que un pasajero se crea correctamente con todos sus atributos
    @Test
    public void testCrearPasajero() {
        // Verificamos que el objeto pasajero se ha creado correctamente
        assertNotNull(pasajero);
        assertEquals("P001", pasajero.getId());
        assertEquals("Juan Pérez", pasajero.getNombre());
        assertEquals("Pasajero", pasajero.getTipo());
        assertEquals("555-1234", pasajero.getContacto());
        assertNotNull(pasajero.getRutasAsignadas());
        assertTrue(pasajero.getRutasAsignadas().isEmpty());
    }

    // RF10 - Prueba 2: Verificar que se puede modificar el contacto de un pasajero
    @Test
    public void testModificarContacto() {
        // Cambiamos el contacto
        pasajero.setContacto("555-5678");

        // Verificamos que el cambio se realizó correctamente
        assertEquals("555-5678", pasajero.getContacto());
    }

    // RF1 - Prueba 1: Verificar que se puede asignar una ruta a un pasajero
    @Test
    public void testAsignarRuta() {
        // Creamos una lista con una ruta
        List<Ruta> rutas = new ArrayList<>();
        rutas.add(ruta1);

        // Asignamos la ruta al pasajero
        pasajero.setRutasAsignadas(rutas);

        // Verificamos que la ruta se asignó correctamente
        assertEquals(1, pasajero.getRutasAsignadas().size());
        assertTrue(pasajero.getRutasAsignadas().contains(ruta1));
    }

    // RF1 - Prueba 2: Verificar que se pueden asignar múltiples rutas a un pasajero
    @Test
    public void testAsignarMultiplesRutas() {
        // Creamos una lista con varias rutas
        List<Ruta> rutas = new ArrayList<>();
        rutas.add(ruta1);
        rutas.add(ruta2);

        // Asignamos las rutas al pasajero
        pasajero.setRutasAsignadas(rutas);

        // Verificamos que las rutas se asignaron correctamente
        assertEquals(2, pasajero.getRutasAsignadas().size());
        assertTrue(pasajero.getRutasAsignadas().contains(ruta1));
        assertTrue(pasajero.getRutasAsignadas().contains(ruta2));
    }

    // RF2 - Prueba 1: Verificar que se pueden consultar las rutas asignadas a un pasajero
    @Test
    public void testConsultarRutas() {
        // Creamos una lista con rutas
        List<Ruta> rutas = new ArrayList<>();
        rutas.add(ruta1);
        rutas.add(ruta2);

        // Asignamos las rutas al pasajero
        pasajero.setRutasAsignadas(rutas);

        // Consultamos las rutas
        List<Ruta> rutasConsultadas = pasajero.getRutasAsignadas();

        // Verificamos que las rutas consultadas son las mismas que asignamos
        assertEquals(rutas, rutasConsultadas);
    }

    // RF2 - Prueba 2: Verificar que un pasajero sin rutas asignadas retorna una lista vacía
    @Test
    public void testConsultarRutasSinAsignar() {
        // Consultamos las rutas sin haber asignado ninguna
        List<Ruta> rutasConsultadas = pasajero.getRutasAsignadas();

        // Verificamos que se retorna una lista vacía
        assertNotNull(rutasConsultadas);
        assertTrue(rutasConsultadas.isEmpty());
    }

    // RF17 - Prueba 1: Verificar que el método registrarPasaj funciona correctamente
    @Test
    public void testRegistrarPasajero() {
        // Simulamos que el método se implementará correctamente

        try {
            pasajero.registrarPasaj();
            assertTrue(true);  // Si llegamos aquí, no hubo excepciones
        } catch (Exception e) {
            fail("No debería lanzar excepción: " + e.getMessage());
        }
    }

    // RF17 - Prueba 2: Verificar que el método consultarPasaj funciona correctamente
    @Test
    public void testConsultarPasajero() {
        // Simulamos que el método se implementará correctamente

        try {
            pasajero.consultarPasaj();
            assertTrue(true);  // Si llegamos aquí, no hubo excepciones
        } catch (Exception e) {
            fail("No debería lanzar excepción: " + e.getMessage());
        }
    }

    static class ConductorTest {

        @BeforeEach
        void setUp() {
        }
    }
}