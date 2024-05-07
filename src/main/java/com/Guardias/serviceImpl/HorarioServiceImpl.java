/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Guardias.serviceImpl;

import com.Guardias.model.Horario;
import com.Guardias.repository.HorarioRepository;
import com.Guardias.service.HorarioService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author maria
 */
@Service
public class HorarioServiceImpl implements HorarioService  {
    
    @Autowired
    private HorarioRepository hRepository;

    @Override
    public ArrayList<Horario> list() {
        return (ArrayList<Horario>) hRepository.findAll();
    }
}
