/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Guardias.serviceImpl;

import com.Guardias.repository.ProfesorRepository;
import com.Guardias.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author maria
 */
@Service
public class ProfesorServiceImpl implements ProfesorService {
    @Autowired
    private ProfesorRepository pRepository;
}
