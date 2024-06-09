/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Guardias.serviceImpl;

import com.Guardias.model.Tarea;
import com.Guardias.repository.TareaRepository;
import com.Guardias.service.IBaseService;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author maria
 */
@Service
public class TareaServiceImpl implements IBaseService<Tarea>{
    
    public TareaServiceImpl(TareaRepository tareaRepository){
        tRepository = tareaRepository;
    }
    
    @Autowired
    private TareaRepository tRepository;
    
    @Override
    public Tarea registrar(Tarea tarea) {
        return tRepository.save(tarea);
    }

    @Override
    public Tarea actualizar(Tarea tarea) {
        return tRepository.save(tarea);
    }

     public ArrayList<Tarea> consultarTodos() {
        return (ArrayList<Tarea>) tRepository.findAll();
    }

    public Tarea obtener(String clave) {
        Optional<Tarea> op = tRepository.findByClave(clave);
        return op.isPresent()?op.get():new Tarea();
    }
    
    public void eliminar(String clave) {
        tRepository.deleteByClave(clave);
    }

    @Override
    public void eliminar(Integer id) {
        
    }

    @Override
    public Tarea consultar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

