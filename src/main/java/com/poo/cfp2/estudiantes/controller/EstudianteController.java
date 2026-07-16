package com.poo.cfp2.estudiantes.controller;


import com.poo.cfp2.estudiantes.entity.Estudiante;
import com.poo.cfp2.estudiantes.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
//@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private final EstudianteService estudianteService;

    public EstudianteController(EstudianteService estudianteService) {

        this.estudianteService = estudianteService;
    }

    //métodos http
    @GetMapping //("?id=1")
    public ResponseEntity<?> getEstudianteId(@RequestParam Long id){
        Estudiante estudianteBuscado=  estudianteService.getEstudiante(id);

        if(estudianteBuscado == null){
            return  ResponseEntity.status(404).body("Estudiante inexistente.");
        }else{
            return ResponseEntity.ok(estudianteBuscado); //200
        }

    }

    //Especificar endpoint para no duplicar la ruta del método get
    @GetMapping("/lista")
    public ResponseEntity<?> getEstudiantes(){
        List<Estudiante> estudiantes = estudianteService.consultarEstudiantes();
        if(estudiantes.isEmpty()){
            return ResponseEntity.status(404).body("no existe.");
        }else{ return ResponseEntity.ok(estudiantes);}
    }

    @PostMapping
    public ResponseEntity<?> createEstudiante( @RequestBody Estudiante estudiante  ){

        //faltan validaciones

        Estudiante estudianteCreado= estudianteService.createEstudiante(estudiante);

        if(estudianteCreado == null){
            return  ResponseEntity.status(400).body("No se creo.");
        }else{
            return ResponseEntity.status(201).body(estudianteCreado); //200
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEstudiante( @PathVariable Long id){
        // de busqueda si no esta ya avisamos
        Boolean elimina=estudianteService.deleteEstudiante(id);
        if(elimina) return ResponseEntity.ok("eliminado.");
        else{ return ResponseEntity.status(404).body("no existe."); }

    }


//    @GetMapping("/saludo")
//    public String saludo(){
//        return "holaa";
//
//    }
//
//    @GetMapping("/index")
//    public String saludar(Model modelo){
//        modelo.addAttribute("saludo","Hola POO.");
////        modelo.addAttribute("estudiantes", estudianteService.consultarEstudiantes() );
//        return "index";
//
//    }
//
//    @GetMapping("/estudiantes")
//    public String listar(Model modelo ){
//        modelo.addAttribute("estudiantes",estudianteService.consultarEstudiantes());
//        return "estudiantes";
//    }





//
//    public List<Estudiante> traerEstudiantes(){
//        return  estudianteService.consultarEstudiantes() ;
//
//    }


}
