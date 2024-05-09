/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Guardias.controller;

import com.Guardias.DTO.TareaSimpleDTO;
import com.Guardias.model.Tarea;
import com.Guardias.serviceImpl.TareaServiceImpl;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author maria
 */

@RestController
@RequestMapping("/api/tarea")
public class TareaController {
    
    @Autowired
    TareaServiceImpl tService;
    
    @GetMapping("/tareas")
    public ResponseEntity<ArrayList<TareaSimpleDTO>> getTareaSimple(){
        ArrayList<Tarea> allTareas = tService.listar();
        ArrayList<TareaSimpleDTO> listaTareas = new ArrayList<TareaSimpleDTO>();
        for (Tarea tareas : allTareas){
            listaTareas.add(new TareaSimpleDTO(tareas));
        }
        return ResponseEntity.ok(listaTareas);
    }
    
    @GetMapping("/tareas/{clave}")
    public ResponseEntity<Tarea> getTareaPorClave(@PathVariable String clave){
        Tarea tarea = tService.obtener(clave);
        if (tarea.getClave() == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(tarea);
    }
    
    
    
    
    
    
    
}
