/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Guardias.controller;

import com.Guardias.model.Profesor;
import com.Guardias.serviceImpl.ProfesorServiceImpl;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Valeria
 */

@ComponentScan
@RestController
@RequestMapping("/api/guardias/profesor")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ProfesorController {
    
    @Autowired
    ProfesorServiceImpl profesorService;
    
    /**
     * 1. Actualizar datos de un profesor
     * @param profesor
     * @return 
     */
    @PutMapping("/actualizarProfesor")
    public ResponseEntity<Profesor> actualizaProfesor(@RequestBody Profesor profesor) {
        if (profesor.getId()==0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);  
        }
        Profesor prof=profesorService.consultar(profesor.getId());
        if (prof.getId()==0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);           
        }
        
        prof.setIdProfesor(profesor.getIdProfesor());
        prof.setApellidosProfesor(profesor.getApellidosProfesor());
        prof.setNombreProfesor(profesor.getNombreProfesor());
        prof.setPasswordProfesor(profesor.getPasswordProfesor());
        //Añadir los horarios
        Profesor profDevolver=profesorService.actualizar(prof);
        return new ResponseEntity<>(profDevolver,HttpStatus.CREATED);
        
    }
    /**
     * 2. Consultar todos los profesores
     * @return 
     */
    @GetMapping("/listarProfesores")
    public ResponseEntity<ArrayList<Profesor>> getProfesores(){
        ArrayList<Profesor> profesores = profesorService.consultarTodos();
        return ResponseEntity.ok(profesores);
    }
    /**
     * 3. Eliminar un profesor por id
     * @param id
     * @return 
     */
    @DeleteMapping("/eliminarProfesor/{id}")
    public ResponseEntity<Profesor> eliminarProfesor(@PathVariable Integer id){
        
        Profesor profesor=profesorService.consultar(id);
        if (profesor.getId()==0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);    
        }else{
            profesorService.eliminar(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
    /**
     * 4. Consultar un profesor por su id
     * @return 
     */
    @GetMapping("/obtenerProfesor/{id}")
    public ResponseEntity<Profesor>getProfesor(@PathVariable int id){
       Profesor profesor = profesorService.consultar(id);
        if (profesor.getId()==0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(profesor);
    }
    /**
     * 5. Insertar profesor
     * @param profesor
     * @return 
     */
    @PostMapping("/insertarProfesor")
    public ResponseEntity<Profesor> insertarProfesor (@RequestBody Profesor profesor) {
        boolean profesorValido=profesor.getId()!=0;
        if (profesorValido){
            Profesor profesorExists = profesorService.consultar(profesor.getId());
            if (profesorExists.getId()!=0){
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
        }
        Profesor profesorDevolver = profesorService.registrar(profesor);
        return new ResponseEntity<>(profesorDevolver,HttpStatus.CREATED); 
    }
    
    
    
    
}
