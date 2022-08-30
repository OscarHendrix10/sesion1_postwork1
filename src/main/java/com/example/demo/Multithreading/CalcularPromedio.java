package com.example.demo.Multithreading;

import com.example.demo.Models.Cursos;

public class CalcularPromedio implements Runnable{


    private Cursos curso;
    private double promedio;

    public CalcularPromedio(Cursos curso) {
        this.curso = curso;
    }

    @Override
    public void run() {
        int numAlumnos = 0;
        for(Integer i : curso.getCalificaciones().values()){
            promedio += i;
            numAlumnos++;
        }
        promedio /= numAlumnos;

        System.out.println("Promedio del curso: " + curso.getId_curso() + " " +
                curso.getMaterias().getNombre() + " = " + promedio);
    }
}
