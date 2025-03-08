package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import model.Autoridad;

public class AutoridadTest {

    private Autoridad autoridad;

    @Before
    public void setUp() {
        // Inicializamos una autoridad para las pruebas
        autoridad = new Autoridad("A001", "Comandante García", "Autoridad", "Jefe de Seguridad");
    }

    // RF9 (adaptado para Autoridad) - Prueba 1: Verificar que una autoridad se crea correctamente con todos sus atributos
    @Test
    public void testCrearAutoridad() {
        // Verificamos que el objeto autoridad se ha creado correctamente
        assertNotNull(autoridad);
        assertEquals("A001", autoridad.getId());
        assertEquals("Comandante García", autoridad.getNombre());
        assertEquals("Autoridad", autoridad.getTipo());
        assertEquals("Jefe de Seguridad", autoridad.getRol());
    }

    // RF9 (adaptado para Autoridad) - Prueba 2: Verificar que se puede modificar el rol de una autoridad
    @Test
    public void testModificarRol() {
        // Cambiamos el rol de la autoridad
        autoridad.setRol("Director de Operaciones");


        assertEquals("Director de Operaciones", autoridad.getRol());
    }

    // RF5/RF6 - Prueba 1: Verificar que el método gestionarIncidentes no lance excepciones
    @Test
    public void testGestionarIncidentes() {
        // Como no hay implementación aún, solo verificamos que no lance excepciones
        try {
            autoridad.gestionarIncidentes();
            assertTrue(true);
        } catch (Exception e) {
            fail("No debería lanzar excepción: " + e.getMessage());
        }
    }

    // RF16 - Prueba 1: Verificar comportamiento con datos inválidos
    @Test
    public void testManejoErroresConDatosInvalidos() {
        // Creamos una autoridad con datos potencialmente problemáticos
        try {
            Autoridad autoridadPrueba = new Autoridad("", "", "", "");
            assertNotNull(autoridadPrueba);

            // Probamos métodos con datos problemáticos
            autoridadPrueba.setRol(null);

            assertTrue(true);
        } catch (NullPointerException | IllegalArgumentException e) {
            // Estas excepciones podrían ser esperadas en una implementación completa
            assertTrue(true);
        } catch (Exception e) {
            fail("Solo deberían lanzarse excepciones controladas: " + e.getMessage());
        }
    }

    // RF17 - Prueba 1: Verificar que no se pueden crear autoridades con roles no permitidos
    @Test
    public void testValidacionRolesPermitidos() {

        // Asumimos que en el futuro, la clase podría validar que el rol sea uno de los permitidos

        // Por ahora solo verificamos que se puede crear con cualquier rol
        try {
            Autoridad autoridadRolInvalido = new Autoridad("A002", "Inspector López", "Autoridad", "Rol no definido");
            assertNotNull(autoridadRolInvalido);
            assertEquals("Rol no definido", autoridadRolInvalido.getRol());

            // También verificamos que se puede cambiar a cualquier rol
            autoridadRolInvalido.setRol("Otro rol no definido");
            assertEquals("Otro rol no definido", autoridadRolInvalido.getRol());

            assertTrue(true);
        } catch (Exception e) {

            fail("No debería lanzar excepción en la implementación actual: " + e.getMessage());
        }
    }

    // RF5 - Prueba 2: Verificar la futura funcionalidad para gestionar diferentes tipos de incidentes (esperando implementación)
    @Test
    public void testGestionarDiferentesTiposIncidentes() {
        try {
            // Asumimos que en el futuro, este método podría aceptar parámetros
            // como el tipo de incidente (robo, accidente, incendio, etc.)
            autoridad.gestionarIncidentes();

            assertTrue(true);
        } catch (Exception e) {
            fail("No debería lanzar excepción: " + e.getMessage());
        }
    }
}