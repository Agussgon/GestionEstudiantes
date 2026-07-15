package com.poo.cfp2.estudiantes.service;


import com.poo.cfp2.estudiantes.controller.EstudianteController;
import com.poo.cfp2.estudiantes.entity.Estudiante;
import com.poo.cfp2.estudiantes.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Service
public class EstudianteService {

    //no creo el constructor -- implicito

    @Autowired
    private EstudianteRepository estudianteRepository;

    public EstudianteService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }


    //    public EstudianteService() {
//    }

    public List<Estudiante> consultarEstudiantes()
    {
        return estudianteRepository.findAll();
    }


    public Estudiante getEstudiante(Long id){
        return estudianteRepository.getById(id);
    }

    public Estudiante createEstudiante(Estudiante estudiante){
        //esta validación debería realizarse en el controlador

        Estudiante nuevo=null;

        if(estudiante != null){
            nuevo=estudianteRepository.save(estudiante);
        }
        return nuevo;
    }
    //eliminar
    public Boolean deleteEstudiante(Long id){
        //acá se implementa la lógica bscar por id antes
       estudianteRepository.deleteById(id);
       return estudianteRepository.existsById(id);
    }


}
