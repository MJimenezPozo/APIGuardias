/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Guardias.serviceImpl;

import com.Guardias.model.Horario;
import com.Guardias.repository.HorarioRepository;
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
public class HorarioServiceImpl implements IBaseService<Horario>  {
    
    @Autowired
    private HorarioRepository hRepository;

    //Método que devuelve todos los horarios no es pageable
    public ArrayList<Horario> consultarTodos() {
        return (ArrayList<Horario>) hRepository.findAll();
    }

    @Override
    public Horario registrar(Horario h) {
        return hRepository.save(h);
    }

    @Override
    public Horario actualizar(Horario h) {
        return hRepository.save(h);
    }

    @Override
    public void eliminar(Integer id) {
        hRepository.deleteById(id);
    }

    @Override
    public Horario consultar(Integer id) {
        Optional<Horario> op = hRepository.findById(id);
        return op.isPresent() ? op.get() : new Horario();
    }
}
