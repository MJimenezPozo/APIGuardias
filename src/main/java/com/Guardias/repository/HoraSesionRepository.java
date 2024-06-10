/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Guardias.repository;

import com.Guardias.model.HoraSesion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author maria
 */
public interface HoraSesionRepository extends JpaRepository<HoraSesion, Integer>{

    public void deleteBySesion(String sesion);

    public Optional<HoraSesion> findBySesion(String sesion);
    
}
