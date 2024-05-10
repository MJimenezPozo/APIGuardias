/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Guardias.controller;

import com.Guardias.DTO.TareaSimpleDto;
import com.Guardias.model.Tarea;
import com.Guardias.serviceImpl.TareaServiceImpl;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
 * @author maria
 */
@Transactional
@RestController
@RequestMapping("/api/tarea")
public class TareaController {
    
    @Autowired
    TareaServiceImpl tService;
    
    @GetMapping("/tareas")
    public ResponseEntity<ArrayList<TareaSimpleDto>> getTareaSimple(){
        ArrayList<Tarea> allTareas = tService.consultarTodos();
        ArrayList<TareaSimpleDto> listaTareas = new ArrayList<TareaSimpleDto>();
        for (Tarea tareas : allTareas){
            listaTareas.add(new TareaSimpleDto(tareas));
        }
        return ResponseEntity.ok(listaTareas);
    }
    
    @GetMapping("/tareas/{clave}")
    public ResponseEntity<TareaSimpleDto> getTareaPorClave(@PathVariable String clave){
        Tarea tarea = tService.obtener(clave);
        TareaSimpleDto tareasimple = new TareaSimpleDto(tarea);
        if (tarea.getClave() == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(tareasimple);
    }
    
    
    @PostMapping("/newTarea")
    public ResponseEntity<TareaSimpleDto> postTarea(@RequestBody TareaSimpleDto tareaDTO){ 
        Tarea tarea = new Tarea();
        
        tarea.setClave(tareaDTO.getClave());
        tarea.setDescripcion(tareaDTO.getDescripcion());
 
        if(tarea.getClave()!= null){
            Tarea tareaYaExite = tService.obtener(tarea.getClave());
            if (tareaYaExite.getClave()!= null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        Tarea tareaDevolver = tService.registrar(tarea);
        TareaSimpleDto tareaDevDTO = new TareaSimpleDto(tareaDevolver);
  
        return new ResponseEntity<>(tareaDevDTO, HttpStatus.CREATED);
    }
    
    
    @DeleteMapping("/tareaEliminar/{clave}")
    public ResponseEntity<Tarea> deleteTarea(@PathVariable String clave){
        Tarea tarea = tService.obtener(clave);
        if (tarea.getClave() == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        tService.eliminar(clave);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @PutMapping("/tareas/{clave}")
    public ResponseEntity<TareaSimpleDto> actualizaTarea(@RequestBody TareaSimpleDto tareaSimple,
            @PathVariable String clave) {
        
        Tarea tarea = tService.obtener(clave);
         
        if (tarea.getClave() == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        tarea.setDescripcion(tareaSimple.getDescripcion());
        tService.registrar(tarea);
  
        return new ResponseEntity<>(tareaSimple,HttpStatus.CREATED);
    }
}
