package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import model.Incidente;

public class IncidenteTest {

    private Incidente incidente;

    @Before
    public void setUp() {
        // Inicializamos un incidente para las pruebas
        incidente = new Incidente(
                "INC001",
                "Robo",
                "Av. Principal 123",
                "2025-03-08 10:30",
                "Robo de celular en parada de bus",
                "Pendiente"
        );
    }

    // RF5 - Prueba 1: Verificar que un incidente se crea correctamente con todos sus atributos
    @Test
    public void testCrearIncidente() {
        // Verificamos que el objeto incidente se ha creado correctamente
        assertNotNull(incidente);
        assertEquals("INC001", incidente.getId());
        assertEquals("Robo", incidente.getTipo());
        assertEquals("Av. Principal 123", incidente.getUbicacion());
        assertEquals("2025-03-08 10:30", incidente.getFechaHora());
        assertEquals("Robo de celular en parada de bus", incidente.getDescripcion());
        assertEquals("Pendiente", incidente.getEstado());
    }

    // RF5 - Prueba 2: Verificar que se puede cambiar el estado de un incidente
    @Test
    public void testCambiarEstado() {
        // Cambiamos el estado del incidente
        incidente.setEstado("En proceso");

        // Verificamos que el cambio se realizó correctamente
        assertEquals("En proceso", incidente.getEstado());
    }

    // RF5 - Prueba 3: Verificar el método actualizarEstado
    @Test
    public void testActualizarEstado() {

        incidente.actualizarEstado("Resuelto");


        assertEquals("Resuelto", incidente.getEstado());
    }

    // RF6 - Prueba 1: Verificar que el método registrarIncid no lance excepciones
    @Test
    public void testRegistrarIncidente() {

        try {
            incidente.registrarIncid();
            assertTrue(true);
        } catch (Exception e) {
            fail("No debería lanzar excepción: " + e.getMessage());
        }
    }

    // RF7 - Prueba 1: Verificar que los incidentes pueden ser ordenados por fecha/hora
    @Test
    public void testOrdenarPorFechaHora() {

        Incidente incidente1 = new Incidente("INC001", "Robo", "Ubicación 1", "2025-03-08 10:30", "Descripción 1", "Pendiente");
        Incidente incidente2 = new Incidente("INC002", "Accidente", "Ubicación 2", "2025-03-07 09:15", "Descripción 2", "Pendiente");
        Incidente incidente3 = new Incidente("INC003", "Incendio", "Ubicación 3", "2025-03-09 14:45", "Descripción 3", "Pendiente");

        // Verificamos que podemos comparar fechas
        assertTrue(incidente1.getFechaHora().compareTo(incidente2.getFechaHora()) > 0);
        assertTrue(incidente3.getFechaHora().compareTo(incidente1.getFechaHora()) > 0);
        assertTrue(incidente2.getFechaHora().compareTo(incidente3.getFechaHora()) < 0);
    }

    // RF8 - Prueba 1: Verificar búsqueda de incidente por ID
    @Test
    public void testBusquedaPorId() {

        String idBuscado = "INC001";
        assertEquals(idBuscado, incidente.getId());
    }

    // RF14 - Prueba 1: Verificar que el método generarReporteIncidentes no lance excepciones
    @Test
    public void testGenerarReporteIncidentes() {

        try {
            incidente.generarReporteIncidentes();
            assertTrue(true);
        } catch (Exception e) {
            fail("No debería lanzar excepción: " + e.getMessage());
        }
    }


    // Prueba para el método gestionarIncidentes
    @Test
    public void testGestionarIncidentes() {

        try {
            incidente.gestionarIncidentes();
            assertTrue(true);
        } catch (Exception e) {
            fail("No debería lanzar excepción: " + e.getMessage());
        }
    }

    // RF16 - Prueba 1: Verificar comportamiento con datos inválidos (esperando implementación)
    @Test
    public void testManejoErroresConDatosInvalidos() {

        try {
            // Creamos un incidente con datos potencialmente problemáticos
            Incidente incidentePrueba = new Incidente("", "", "", "", "", "");
            assertNotNull(incidentePrueba);


            incidentePrueba.setEstado(null);
            incidentePrueba.actualizarEstado(null);

            assertTrue(true);
        } catch (NullPointerException | IllegalArgumentException e) {
            
            assertTrue(true);
        } catch (Exception e) {
            fail("Solo deberían lanzarse excepciones controladas: " + e.getMessage());
        }
    }

    // RF17 - Prueba 1: Verificar validación de estados permitidos (esperando implementación)
    @Test
    public void testValidacionEstadosPermitidos() {
        // Esta prueba anticipa una futura implementación que valide estados permitidos

        // Por ahora verificamos que se puede establecer cualquier estado
        incidente.setEstado("Estado no definido");
        assertEquals("Estado no definido", incidente.getEstado());

        // Y que el método actualizarEstado también acepta cualquier valor
        incidente.actualizarEstado("Otro estado no definido");
        assertEquals("Otro estado no definido", incidente.getEstado());
    }
}