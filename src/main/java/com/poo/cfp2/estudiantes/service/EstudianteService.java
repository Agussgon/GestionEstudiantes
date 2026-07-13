package com.poo.cfp2.estudiantes.service;


import com.poo.cfp2.estudiantes.controller.EstudianteController;
import com.poo.cfp2.estudiantes.entity.Estudiante;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class EstudianteService {

    //no creo el constructor -- implicito

//    public EstudianteService() {
//    }

    private Estudiante estudiante1= new Estudiante("Juan",7);
    private Estudiante estudiante2= new Estudiante("Juli",6);
    private List<Estudiante> estudiantes=
            new ArrayList<>(Arrays.asList(estudiante1,estudiante2));


    public List<Estudiante> consultarEstudiantes()
    {
        return estudiantes;
    }


    public Estudiante getEstudiante(Long id){
        return estudiante1;
    }

    public Estudiante createEstudiante(Estudiante estudiante){
        if(estudiante != null){
            estudiantes.add(estudiante);
        }
        return estudiante;
    }
    //eliminar
    public Boolean deleteEstudiante(Long id){
        return true;
    }


}
