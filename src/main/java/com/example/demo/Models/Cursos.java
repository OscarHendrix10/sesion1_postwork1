package com.example.demo.Models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name = "cursos")
public class Cursos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id_curso;

    private Character ciclo;

    @ManyToOne()
    @JoinColumn(name = "id_materia")
    private Materias materias;

    //relacion
    @ElementCollection
    @CollectionTable(name = "cursos_has_estudiantes", joinColumns = {@JoinColumn(name = "cursos_fk",
            referencedColumnName = "id_curso")})
    @MapKeyJoinColumn(name = "estudiantes_fk", referencedColumnName = "id_estudiante")
    @Column(name = "calificacion")
    private Map<Estudiantes, Integer> calificaciones;
    // fin relacion

    public Long getId_curso() {
        return id_curso;
    }

    public void setId_curso(Long id_curso) {
        this.id_curso = id_curso;
    }

    public Character getCiclo() {
        return ciclo;
    }

    public void setCiclo(Character ciclo) {
        this.ciclo = ciclo;
    }

    public Materias getMaterias() {
        return materias;
    }

    public void setMaterias(Materias materias) {
        this.materias = materias;
    }

    public Map<Estudiantes, Integer> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(Map<Estudiantes, Integer> calificaciones) {
        this.calificaciones = calificaciones;
    }
}
