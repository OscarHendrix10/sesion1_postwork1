package com.example.demo.Controllers;

import com.example.demo.Models.Cursos;
import com.example.demo.Services.CursosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/cursos")
public class CursosController {

    @Autowired
    CursosService cursosServices;

    @GetMapping("/all")
    public ArrayList<Cursos> obtenerCursos(){
        return cursosServices.obtenerCursos();
    }

    @GetMapping(path = "/{id}")
    public Optional<Cursos> obtenerCursoId(@PathVariable("id") Long id){
        return this.cursosServices.obtenerCursoId(id);
    }

    @PostMapping("/save")
    public Cursos guardarCursos(@RequestBody Cursos curso){
        return this.cursosServices.guardarCursoss(curso);
    }


    @DeleteMapping(path = "/{id}")
    public String eliminarCurso(@PathVariable("id") Long id){
        boolean ok = this.cursosServices.eliminarCursos(id);
        if(ok){
            return "Se elimino el curso con el id: " + id;
        }else{
            return "no se pudo eliminar el curso ";
        }
    }

    @GetMapping("/promedio")
    public String ejecutarHilo(){
        boolean ok = this.cursosServices.ejecutarHilo();
        if(ok){
            return "Tarea terminada";
        }else{
            return "ocurrio algo :c";
        }
    }
}
