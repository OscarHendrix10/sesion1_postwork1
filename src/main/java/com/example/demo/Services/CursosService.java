package com.example.demo.Services;

import com.example.demo.Models.Cursos;
import com.example.demo.Repositories.CursosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CursosService {
    @Autowired
    CursosRepository cursosRepository;

    public ArrayList<Cursos> obtenerCursos(){
        return (ArrayList<Cursos>) cursosRepository.findAll();
    }

    public Cursos guardarCursoss(Cursos curso){
        return cursosRepository.save(curso);
    }

    public Optional<Cursos> obtenerCursoId(Long id){
        return cursosRepository.findById(id);
    }

    public boolean eliminarCursos(Long id){
        try{
            cursosRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean ejecutarHilo(){
        return cursosRepository.ejecutarThead();
    }

}
