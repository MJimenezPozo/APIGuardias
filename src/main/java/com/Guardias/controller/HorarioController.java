/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Guardias.controller;

import com.Guardias.DTO.HorarioDto;
import com.Guardias.DTO.HorarioTareaDto;
import com.Guardias.exception.ResourceNotFoundException;
import com.Guardias.model.Horario;
import com.Guardias.model.ResultadoObtenerHorarioTareas;
import com.Guardias.serviceImpl.HorarioServiceImpl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        
        if(horarios.isEmpty()){
            
            throw new ResourceNotFoundException("No se encontraron horarios");
            
        }
        
        ArrayList<HorarioDto> horariosDevolver = new ArrayList<>();
        
        for(Horario horario : horarios){
            
            horariosDevolver.add(HorarioDto.toHorarioDto(horario));
            
        }
        
        return new ResponseEntity<>(horariosDevolver, HttpStatus.OK);
    }
    
    @GetMapping("/horarios/{id}")
    public ResponseEntity<HorarioDto> getHorarioById(Integer id){
        
        Horario horario = hService.consultar(id);
        
        if(horario.getIdSesion() == null){
            
            throw new ResourceNotFoundException("Horario", "id", id);
            
        }
        
        HorarioDto horarioDevolver = HorarioDto.toHorarioDto(horario);
        
        return new ResponseEntity<>(horarioDevolver, HttpStatus.OK);
        
    }
    
//    @PostMapping
//    public ResponseEntity<HorarioDto> postHorario(@RequestBody HorarioDto horarioDto){
//        
//        
//        
//    }
    
    @DeleteMapping()
    public void deleteHorario(Integer id){
        hService.eliminar(id);
    }
    
    @GetMapping("/HorarioTareas")
    public ResponseEntity<ArrayList<HorarioTareaDto>> getHorarioTareas (@RequestParam String id_profesor, @RequestParam String dia){
        List<ResultadoObtenerHorarioTareas> listaResultados;
        listaResultados = hService.listaHorarios(id_profesor, dia);
        
        ArrayList<HorarioTareaDto> horariosDevolver = new ArrayList<>();
        
        for(ResultadoObtenerHorarioTareas resultado : listaResultados){
            
            horariosDevolver.add(HorarioTareaDto.toHorarioTareaDto(resultado));
            
        }
        
        return new ResponseEntity<>(horariosDevolver, HttpStatus.OK);
    }
    
}
