package com.poo.cfp2.estudiantes.entity;

import com.fasterxml.jackson.annotation.JsonCreator; // esto no resuelve el importar
import com.fasterxml.jackson.annotation.JsonProperty;
import com.poo.cfp2.estudiantes.utils.NotaInvalidaException;
import jakarta.persistence.*;


@Entity
@Table(name="estudiantes")
public class Estudiante implements Comparable<Estudiante> {

    //incluir id para la bd PK
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name="nombre", unique=false , length = 100)
    private String nombre;

    private Integer nota=1;

    public Estudiante(String nombre) {
        this.nombre = nombre;
    }

    //@JsonCreator //@JsonProperty
    public Estudiante( Long id, String nombre,Integer nota) {
        this.id=id;
        this.nombre = nombre;
        this.nota = nota;
    }

    // no olvida si queremos verlo
    public Long getId() {
        return id;
    }

    public Estudiante(){
    }


    public void setNota(Integer nota) {
        if(nota > 10 || nota < 1){
            //System.err.println("Ingresa una nota válida del 1 al 10. ");
            throw new NotaInvalidaException("La nota debe estar en el rango del 1 al 10.");
        }
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getNota() {
        return nota;
    }

    @Override
    public int compareTo(Estudiante o) {
        return Integer.compare(this.nota, o.nota);
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", nota=" + nota +
                '}';
    }
}
