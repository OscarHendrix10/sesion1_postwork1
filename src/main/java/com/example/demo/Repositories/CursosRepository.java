package com.example.demo.Repositories;

import com.example.demo.Models.Cursos;
import com.example.demo.Models.Estudiantes;
import com.example.demo.Models.Materias;
import com.example.demo.Multithreading.CalcularPromedio;
import org.springframework.data.repository.CrudRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public interface CursosRepository extends CrudRepository<Cursos, Long> {

    default boolean ejecutarThead(){
        try {
            Random rnd = new Random();
            ExecutorService pool = Executors.newCachedThreadPool();
            Cursos[] cursos = new Cursos[]{
                    crearCurso(rnd, "Matematicas",1),
                    crearCurso(rnd, "Espaniol",2),
                    crearCurso(rnd, "Historia",3),
                    crearCurso(rnd, "Educacion fisica", 4)
            };
            for(Cursos curso : cursos){
                pool.execute(new CalcularPromedio(curso));
            }
            pool.shutdown();
        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }

    private static Cursos crearCurso(Random rnd, String nombreMateria, int id) {
        Cursos curso = new Cursos();
        curso.setId_curso((long) id);
        Materias materia = new Materias();
        materia.setNombre(nombreMateria);
        curso.setMaterias(materia);

        Map<Estudiantes, Integer> calificaciones = new HashMap<>();
        for (int i = 0; i < 20; i++) {
            Estudiantes estudiante = new Estudiantes();
            estudiante.setId_estudiante((long)i);
            estudiante.setNombre_completo("Estudiante " + i);
            calificaciones.put(estudiante, rnd.nextInt(10));
        }
        curso.setCalificaciones(calificaciones);
        return curso;
    }
}
