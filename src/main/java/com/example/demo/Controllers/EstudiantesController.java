package com.example.demo.Controllers;

import com.example.demo.Models.Estudiantes;
import com.example.demo.Services.EstudiantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/estudiante")
public class EstudiantesController {

    @Autowired
    EstudiantesService estudiantesService;

    @GetMapping("all")
    public ArrayList<Estudiantes> obtenerEstudiantes(){
        return estudiantesService.obtenerEstudiantes();
    }

    @GetMapping(path = "/{id}")
    public Optional<Estudiantes> obtenerEstudiantes(@PathVariable("id") Long id){
        return this.estudiantesService.obtenerEstudianteId(id);
    }

    @PostMapping("/save")
    public Estudiantes guardarEstudiante(@RequestBody Estudiantes estudiante){
        return this.estudiantesService.guardarEstudiantes(estudiante);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarEstudiante(@PathVariable("id") Long id){
        boolean ok = this.estudiantesService.eliminarEstudiante(id);
        if(ok){
            return "Se elimino el estudiante con el id: " + id;
        }else{
            return "no se pudo eliminar al estudiante ";
        }
    }

}
