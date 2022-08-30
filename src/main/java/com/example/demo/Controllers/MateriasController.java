package com.example.demo.Controllers;


import com.example.demo.Models.Materias;
import com.example.demo.Services.MateriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/materia")
public class MateriasController {

    @Autowired
    MateriasService materiaServices;

    @GetMapping("all")
    public ArrayList<Materias> obtenerMaterias(){
        return materiaServices.obtenerMaterias();
    }

    @GetMapping(path = "/{id}")
    public Optional<Materias> obtenerMateria(@PathVariable("id") Long id){
        return this.materiaServices.obtenerMateriaId(id);
    }

    @PostMapping("/save")
    public Materias guardarMateria(@RequestBody Materias materia){
        return this.materiaServices.guardarMateria(materia);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarMateriaPorId(@PathVariable("id") Long id){
        boolean ok = this.materiaServices.eliminarMateria(id);
        if(ok){
            return "Se elimino la materia con el id: " + id;
        }else{
            return "no se pudo eliminar la materia ";
        }
    }
}
