package mx.cdmx.pilares.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Arrays;
import mx.cdmx.pilares.models.Sede;
import mx.cdmx.pilares.services.RecomendadorService;

public class RecomendadorServiceTest {

    private RecomendadorService recomendadorService;
    private List<Sede> sedesPrueba;

    @BeforeEach
    public void setUp() {
        recomendadorService = new RecomendadorService();
        
        // Datos de prueba
        Sede sede1 = new Sede();
        sede1.setId(1L);
        sede1.setNombre("PILARES Centro");
        sede1.setLatitud(19.4326);
        sede1.setLongitud(-99.1332);
        sede1.setActividades(Arrays.asList("Taller de pintura", "Clases de computación"));

        Sede sede2 = new Sede();
        sede2.setId(2L);
        sede2.setNombre("PILARES Norte");
        sede2.setLatitud(19.4926);
        sede2.setLongitud(-99.1332);
        sede2.setActividades(Arrays.asList("Taller de pintura", "Yoga"));

        sedesPrueba = Arrays.asList(sede1, sede2);
    }

    @Test
    public void testRecomendacionesPorDistancia() {
        // Ubicación cerca del Centro Histórico (cerca de sede1)
        double latUsuario = 19.4340;
        double lngUsuario = -99.1340;
        
        List<Sede> recomendaciones = recomendadorService.filtrarPorDistancia(
            sedesPrueba, 
            latUsuario, 
            lngUsuario
        );

        assertNotNull(recomendaciones);
        assertEquals(2, recomendaciones.size());
        assertEquals(1L, recomendaciones.get(0).getId()); // PILARES Centro debería ser primero
        assertTrue(recomendaciones.get(0).getDistancia() < recomendaciones.get(1).getDistancia());
    }

    @Test
    public void testRecomendacionesPorActividad() {
        List<Sede> recomendaciones = recomendadorService.filtrarPorActividad(
            sedesPrueba, 
            "Taller de pintura"
        );

        assertNotNull(recomendaciones);
        assertEquals(2, recomendaciones.size()); // Ambas sedes ofrecen pintura
    }

    @Test
    public void testRecomendacionesPorActividadInexistente() {
        List<Sede> recomendaciones = recomendadorService.filtrarPorActividad(
            sedesPrueba, 
            "Taller inexistente"
        );

        assertTrue(recomendaciones.isEmpty());
    }

    @Test
    public void testOrdenamientoCorrecto() {
        // Ubicación equidistante entre ambas sedes
        double latUsuario = 19.4626;
        double lngUsuario = -99.1332;
        
        List<Sede> recomendaciones = recomendadorService.filtrarPorDistancia(
            sedesPrueba, 
            latUsuario, 
            lngUsuario
        );

        // Verificar que estén ordenadas por distancia
        for (int i = 0; i < recomendaciones.size() - 1; i++) {
            assertTrue(
                recomendaciones.get(i).getDistancia() <= recomendaciones.get(i + 1).getDistancia(),
                "Las sedes no están ordenadas por distancia"
            );
        }
    }
}