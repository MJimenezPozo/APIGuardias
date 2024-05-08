/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Guardias.serviceImpl;

import com.Guardias.model.HoraSesion;
import com.Guardias.repository.HoraSesionRepository;
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
public class HoraSesionServiceImpl implements IBaseService<HoraSesion> {

    @Autowired
    private HoraSesionRepository horaSesionRepository;

    public ArrayList<HoraSesion> consultarTodos() {
        return (ArrayList<HoraSesion>) horaSesionRepository.findAll();
    }

    @Override
    public HoraSesion registrar(HoraSesion sesion) {
        return horaSesionRepository.save(sesion);
    }

    @Override
    public HoraSesion actualizar(HoraSesion input) {
        return horaSesionRepository.save(input);
    }

    @Override
    public void eliminar(Integer id) {
       horaSesionRepository.deleteById(id);
    }

    @Override
    public HoraSesion consultar(Integer id) {
        Optional<HoraSesion> optional = horaSesionRepository.findById(id);
        return optional.isPresent() ? optional.get() : new HoraSesion();
    }

}
