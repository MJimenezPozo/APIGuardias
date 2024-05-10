/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Guardias.controller;

import com.Guardias.DTO.HorarioDto;
import com.Guardias.model.Horario;
import com.Guardias.serviceImpl.HorarioServiceImpl;
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
@RequestMapping("/api/guardias/horario")
public class HorarioController {
    
    @Autowired
    HorarioServiceImpl hService;
    
    @GetMapping("/horarios")
    public ResponseEntity<ArrayList<HorarioDto>> getHorarios(){
        
        ArrayList<Horario> horarios = hService.consultarTodos();
        
        ArrayList<HorarioDto> horariosDevolver = new ArrayList<>();
        
        for(Horario horario : horarios){
            
            horariosDevolver.add(HorarioDto.toHorarioDto(horario));
            
        }
        
        return new ResponseEntity<>(horariosDevolver, HttpStatus.OK);
    }
}
