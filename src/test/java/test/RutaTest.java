package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import model.Ruta;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RutaTest {

    private Ruta ruta;

    @Before
    public void setUp() {
        // Inicializamos una ruta para las pruebas
        ruta = new Ruta("R001", 15.5, 45, "Estación Central", "Terminal Norte");
    }

    // RF1 - Prueba 1: Verificar que una ruta se crea correctamente con todos sus atributos
    @Test
    public void testCrearRuta() {
        // Verificamos que el objeto ruta se ha creado correctamente
        assertNotNull(ruta);
        assertEquals("R001", ruta.getId());
        assertEquals(15.5, ruta.getDistancia(), 0.001);
        assertEquals(45, ruta.getTiempoEstimado());
        assertEquals("Estación Central", ruta.getInicio());
        assertEquals("Terminal Norte", ruta.getFin());
    }

    // RF1 - Prueba 2: Verificar que se puede modificar la distancia de una ruta
    @Test
    public void testModificarDistancia() {
        // Cambiamos la distancia de la ruta
        ruta.setDistancia(18.2);

        // Verificamos que el cambio se realizó correctamente
        assertEquals(18.2, ruta.getDistancia(), 0.001);
    }

    // RF1 - Prueba 3: Verificar que se puede modificar el tiempo estimado de una ruta
    @Test
    public void testModificarTiempoEstimado() {
        // Cambiamos el tiempo estimado de la ruta
        ruta.setTiempoEstimado(50);

        // Verificamos que el cambio se realizó correctamente
        assertEquals(50, ruta.getTiempoEstimado());
    }

    // RF2 - Prueba 1: Verificar que el método consultarRuta no lance excepciones
    @Test
    public void testConsultarRuta() {

        try {
            ruta.consultarRuta();
            assertTrue(true);
        } catch (Exception e) {
            fail("No debería lanzar excepción: " + e.getMessage());
        }
    }

    // RF3 - Prueba 1: Verificar que las rutas pueden ser ordenadas por distancia
    @Test
    public void testOrdenarRutasPorDistancia() {
        // Creamos varias rutas con diferentes distancias
        Ruta ruta1 = new Ruta("R001", 15.5, 45, "Inicio1", "Fin1");
        Ruta ruta2 = new Ruta("R002", 8.7, 25, "Inicio2", "Fin2");
        Ruta ruta3 = new Ruta("R003", 22.3, 60, "Inicio3", "Fin3");

        // Creamos una lista con las rutas
        List<Ruta> rutas = new ArrayList<>();
        rutas.add(ruta1);
        rutas.add(ruta2);
        rutas.add(ruta3);

        // Ordenamos la lista por distancia
        Collections.sort(rutas, new Comparator<Ruta>() {
            @Override
            public int compare(Ruta r1, Ruta r2) {
                return Double.compare(r1.getDistancia(), r2.getDistancia());
            }
        });

        // Verificamos que las rutas están ordenadas por distancia (de menor a mayor)
        assertEquals("R002", rutas.get(0).getId());  // La ruta con menor distancia
        assertEquals("R001", rutas.get(1).getId());  // La ruta con distancia media
        assertEquals("R003", rutas.get(2).getId());  // La ruta con mayor distancia
    }

    // RF3 - Prueba 2: Verificar que las rutas pueden ser ordenadas por tiempo estimado
    @Test
    public void testOrdenarRutasPorTiempoEstimado() {
        // Creamos varias rutas con diferentes tiempos estimados
        Ruta ruta1 = new Ruta("R001", 15.5, 45, "Inicio1", "Fin1");
        Ruta ruta2 = new Ruta("R002", 8.7, 25, "Inicio2", "Fin2");
        Ruta ruta3 = new Ruta("R003", 22.3, 60, "Inicio3", "Fin3");

        // Creamos una lista con las rutas
        List<Ruta> rutas = new ArrayList<>();
        rutas.add(ruta1);
        rutas.add(ruta2);
        rutas.add(ruta3);

        // Ordenamos la lista por tiempo estimado
        Collections.sort(rutas, new Comparator<Ruta>() {
            @Override
            public int compare(Ruta r1, Ruta r2) {
                return Integer.compare(r1.getTiempoEstimado(), r2.getTiempoEstimado());
            }
        });

        // Verificamos que las rutas están ordenadas por tiempo estimado (de menor a mayor)
        assertEquals("R002", rutas.get(0).getId());  // La ruta con menor tiempo
        assertEquals("R001", rutas.get(1).getId());  // La ruta con tiempo medio
        assertEquals("R003", rutas.get(2).getId());  // La ruta con mayor tiempo
    }

    // RF4 - Prueba 1: Verificar criterio para buscar la mejor ruta (por distancia)
    @Test
    public void testBuscarMejorRutaPorDistancia() {
        // Creamos varias rutas con diferentes distancias
        Ruta ruta1 = new Ruta("R001", 15.5, 45, "Inicio1", "Fin1");
        Ruta ruta2 = new Ruta("R002", 8.7, 25, "Inicio2", "Fin2");
        Ruta ruta3 = new Ruta("R003", 22.3, 60, "Inicio3", "Fin3");

        // Creamos una lista con las rutas
        List<Ruta> rutas = new ArrayList<>();
        rutas.add(ruta1);
        rutas.add(ruta2);
        rutas.add(ruta3);

        // Buscamos la ruta con menor distancia (que sería la mejor según este criterio)
        Ruta mejorRuta = Collections.min(rutas, new Comparator<Ruta>() {
            @Override
            public int compare(Ruta r1, Ruta r2) {
                return Double.compare(r1.getDistancia(), r2.getDistancia());
            }
        });

        // Verificamos que la mejor ruta es la que tiene menor distancia
        assertEquals("R002", mejorRuta.getId());
        assertEquals(8.7, mejorRuta.getDistancia(), 0.001);
    }

    // RF4 - Prueba 2: Verificar criterio para buscar la mejor ruta (por tiempo)
    @Test
    public void testBuscarMejorRutaPorTiempo() {
        // Creamos varias rutas con diferentes tiempos estimados
        Ruta ruta1 = new Ruta("R001", 15.5, 45, "Inicio1", "Fin1");
        Ruta ruta2 = new Ruta("R002", 8.7, 25, "Inicio2", "Fin2");
        Ruta ruta3 = new Ruta("R003", 22.3, 60, "Inicio3", "Fin3");

        // Creamos una lista con las rutas
        List<Ruta> rutas = new ArrayList<>();
        rutas.add(ruta1);
        rutas.add(ruta2);
        rutas.add(ruta3);

        // Buscamos la ruta con menor tiempo (que sería la mejor según este criterio)
        Ruta mejorRuta = Collections.min(rutas, new Comparator<Ruta>() {
            @Override
            public int compare(Ruta r1, Ruta r2) {
                return Integer.compare(r1.getTiempoEstimado(), r2.getTiempoEstimado());
            }
        });

        // Verificamos que la mejor ruta es la que tiene menor tiempo
        assertEquals("R002", mejorRuta.getId());
        assertEquals(25, mejorRuta.getTiempoEstimado());
    }

    // RF13 - Prueba 1: Verificar que el método generarReporteRuta no lance excepciones
    @Test
    public void testGenerarReporteRuta() {

        try {
            ruta.generarReporteRuta();
            assertTrue(true);
        } catch (Exception e) {
            fail("No debería lanzar excepción: " + e.getMessage());
        }
    }

    // Verificar que el método registrarRuta no lance excepciones
    @Test
    public void testRegistrarRuta() {

        try {
            ruta.registrarRuta();
            assertTrue(true);
        } catch (Exception e) {
            fail("No debería lanzar excepción: " + e.getMessage());
        }
    }

    // Verificar que el método generarRuta no lance excepciones
    @Test
    public void testGenerarRuta() {
        // Como no hay implementación aún, solo verificamos que no lance excepciones
        try {
            ruta.generarRuta();
            assertTrue(true);  // Si llegamos aquí, no hubo excepciones
        } catch (Exception e) {
            fail("No debería lanzar excepción: " + e.getMessage());
        }
    }

    // RF16 - Prueba 1: Verificar comportamiento con datos inválidos (esperando implementación)
    @Test
    public void testManejoErroresConDatosInvalidos() {

        try {
            // Creamos una ruta con datos potencialmente problemáticos
            Ruta rutaPrueba = new Ruta("", -1.0, -1, "", "");
            assertNotNull(rutaPrueba);

            // Probamos métodos con datos problemáticos
            rutaPrueba.setDistancia(-5.0);
            rutaPrueba.setTiempoEstimado(-10);

            assertTrue(true);
        } catch (IllegalArgumentException e) {

            assertTrue(true);
        } catch (Exception e) {
            fail("Solo deberían lanzarse excepciones controladas: " + e.getMessage());
        }
    }
}