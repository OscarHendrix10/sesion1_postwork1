package com.example.demo.Services;

import com.example.demo.Models.Estudiantes;
import com.example.demo.Models.Materias;
import com.example.demo.Repositories.EstudiantesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EstudiantesService {

    @Autowired
    EstudiantesRepository estudiantesRepository;

    public ArrayList<Estudiantes> obtenerEstudiantes(){
        return (ArrayList<Estudiantes>) estudiantesRepository.findAll();
    }

    public Estudiantes guardarEstudiantes(Estudiantes estudiante){
        return estudiantesRepository.save(estudiante);
    }

    public Optional<Estudiantes> obtenerEstudianteId(Long id){
        return estudiantesRepository.findById(id);
    }

    public boolean eliminarEstudiante(Long id){
        try{
            estudiantesRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
