/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Guardias.controller;

import com.Guardias.DTO.HoraSesionDto;
import com.Guardias.model.HoraSesion;
import com.Guardias.serviceImpl.HoraSesionServiceImpl;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author maria
 */
@ComponentScan
@RestController
@RequestMapping("/api/guardias/sesion")
public class HoraSesionController {
    
    @Autowired
    HoraSesionServiceImpl hsService;
    
    @GetMapping("/sesiones")
    public ResponseEntity<ArrayList<HoraSesionDto>> getSesiones(){
        
        ArrayList<HoraSesion> sesiones = hsService.consultarTodos();
        
        ArrayList<HoraSesionDto> sesionesDevolver = new ArrayList<>();
        
        for(HoraSesion horaSesion : sesiones){
            
            sesionesDevolver.add(HoraSesionDto.toHoraSesionDto(horaSesion));
            
        }
        
        return new ResponseEntity<>(sesionesDevolver, HttpStatus.OK);
    }
    
}
