/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Guardias.serviceImpl;
import com.Guardias.model.Profesor;
import com.Guardias.repository.ProfesorRepository;
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
public class ProfesorServiceImpl implements IBaseService<Profesor> {
    public ArrayList<Profesor> consultarTodos() {
        return (ArrayList<Profesor>) pRepository.findAll();
    }
    @Autowired
    private ProfesorRepository pRepository;

    @Override
    public Profesor registrar(Profesor p) {
        return pRepository.save(p);
    }

    @Override
    public Profesor actualizar(Profesor p) {
        return pRepository.save(p);
    }

    @Override
    public void eliminar(Integer id) {
        pRepository.deleteById(id);
    }

    @Override
    public Profesor consultar(Integer id) {
        Optional<Profesor> op = pRepository.findById(id);
        return op.isPresent() ? op.get() : new Profesor();
    }

    
}
