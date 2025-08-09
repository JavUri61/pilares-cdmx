package mx.cdmx.pilares.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "sedes")
public class Sede {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nombre;
    
    @Column(nullable = false)
    private String direccion;
    
    @Column(nullable = false)
    private Double latitud;
    
    @Column(nullable = false)
    private Double longitud;
    
    // Relación con actividades (OneToMany/ManyToMany según tu modelo)
    @OneToMany(mappedBy = "sede", cascade = CascadeType.ALL)
    private Set<Actividad> actividades;
    
    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    // ... (generar para todos los campos)
}