/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Guardias.repository;

import com.Guardias.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author maria
 */
public interface ProfesorRepository extends JpaRepository<Profesor, Integer>{
    
}