package com.example.demo.Models;

import javax.persistence.*;

@Entity // hace padre esta tabla
@Table(name = "materias") // el nombre que le vas a poner tabla en la BD
public class Materias {

    @Id // ESTA ES LA PROPIEDAD DE ID
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id_materia;

    @Column(nullable = false)
    private String nombre;


    public Long getId_materia() {
        return id_materia;
    }

    public void setId_materia(Long id_materia) {
        this.id_materia = id_materia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
