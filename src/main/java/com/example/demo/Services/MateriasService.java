package com.example.demo.Services;

import com.example.demo.Models.Materias;
import com.example.demo.Repositories.MateriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MateriasService {

    @Autowired
    MateriasRepository materiaRepository;

    public ArrayList<Materias> obtenerMaterias(){
        return (ArrayList<Materias>) materiaRepository.findAll();
    }

    public Materias guardarMateria(Materias materia){
        return materiaRepository.save(materia);
    }

    public Optional<Materias> obtenerMateriaId(Long id){
        return materiaRepository.findById(id);
    }

    public boolean eliminarMateria(Long id){
        try{
            materiaRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
