/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Guardias.serviceImpl;

import com.Guardias.model.HoraSesion;
import com.Guardias.repository.HoraSesionRepository;
import com.Guardias.service.HoraSesionService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author maria
 */
@Service
public class HoraSesionServiceImpl implements HoraSesionService {
    
    @Autowired
    private HoraSesionRepository horaSesionRepository;
    

    @Override
    public ArrayList<HoraSesion> list() {
        return (ArrayList<HoraSesion>) horaSesionRepository.findAll();
    }
    
}
