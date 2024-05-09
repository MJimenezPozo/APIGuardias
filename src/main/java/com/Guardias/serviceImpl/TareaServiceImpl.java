/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Guardias.serviceImpl;

import com.Guardias.model.Tarea;
import com.Guardias.repository.TareaRepository;
import com.Guardias.service.TareaService;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author maria
 */
@Service
public class TareaServiceImpl implements TareaService{

    
    @Autowired
    private TareaRepository tRepository;

    @Override
    public Tarea registrar(Tarea tarea) {
        return tRepository.save(tarea);
    }

    @Override
    public Tarea modificar(Tarea tarea) {
        return tRepository.save(tarea);
    }

    @Override
    public ArrayList<Tarea> listar() {
        return (ArrayList<Tarea>) tRepository.findAll();
    }

    @Override
    public Tarea obtener(String clave) {
        Optional<Tarea> op = tRepository.findByClave(clave);
        return op.isPresent()?op.get():new Tarea();
    }

    @Override
    public void eliminar(String clave) {
        tRepository.deleteByClave(clave);
    }
}
