package com.poo.cfp2.estudiantes.entity;

import com.poo.cfp2.estudiantes.utils.ListaVaciaException;

import java.util.ArrayList;
import java.util.Collections;

public class RegistroNotas {

    private ArrayList<Estudiante> estudiantes= new ArrayList<>();



    public void agregarEstudiante(Estudiante estudianteNuevo){
        estudiantes.add(estudianteNuevo);
    }

    //ordenar
    public void ordenarPorNota(){
        Collections.sort(estudiantes, Collections.reverseOrder());
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    //acceder por i
    public Estudiante getEstudiante(int i){
       if(i >= estudiantes.size() || i< 0){
           System.out.println("Ingresó un índice inexistente."); //serr otra salida...
           return null;
       }

        return estudiantes.get(i);}


    //calcular promedio

    public Double calcularPromedio () throws ListaVaciaException {
        if(estudiantes.isEmpty()) throw new ListaVaciaException("no hay elementos.");

        Integer suma=0;
        for (Estudiante estudiante:estudiantes){
            suma += estudiante.getNota();
        }
        Double promedio= (double) (suma/ estudiantes.size());
        return promedio;
    }


}
