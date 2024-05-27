/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Guardias.repository;

import com.Guardias.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Valeria
 */
public interface ProfesorRepository extends JpaRepository<Profesor, Integer>{
    @Query("SELECT nextval('public.profesor_id_seq')")
    Integer nextIdProfesor();
}
