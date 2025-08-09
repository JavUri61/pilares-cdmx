package mx.cdmx.pilares.services;

import mx.cdmx.pilares.models.Sede;
import javax.persistence.*;
import java.util.List;

public class SedeService {
    
    private final EntityManager em; // Inyectar o inicializar según tu configuración

    public List<Sede> getAllSedes() {
        return em.createQuery("SELECT s FROM Sede s", Sede.class).getResultList();
    }

    public Sede getSedeById(Long id) {
        return em.find(Sede.class, id);
    }

    public List<Sede> getRecomendaciones(Double latitud, Double longitud, String actividad) {
        String query = "SELECT s FROM Sede s JOIN s.actividades a WHERE " +
                       "a.nombre = :actividad ORDER BY " +
                       "SQRT(POWER(s.latitud - :lat, 2) + POWER(s.longitud - :lng, 2)) ASC";
        
        return em.createQuery(query, Sede.class)
                .setParameter("actividad", actividad)
                .setParameter("lat", latitud)
                .setParameter("lng", longitud)
                .setMaxResults(3)
                .getResultList();
    }
}