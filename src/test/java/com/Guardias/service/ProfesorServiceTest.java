/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.Guardias.service;

import com.Guardias.model.Profesor;
import com.Guardias.repository.ProfesorRepository;
import com.Guardias.serviceImpl.ProfesorServiceImpl;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author profe
 */
//@ContextConfiguration(locations={"/applicationContext-test.xml"})
public class ProfesorServiceTest {
    
    @Mock
    ProfesorRepository profesorRepository;
    ProfesorServiceImpl profesorService;
    AutoCloseable autocloseable;
    
    public ProfesorServiceTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        autocloseable = MockitoAnnotations.openMocks(this);
        profesorService= new ProfesorServiceImpl(profesorRepository);
    }
    
    @AfterEach
    public void tearDown() throws Exception {
        autocloseable.close();
    }

    /**
     * Test of list method, of class ProfesorService.
     */
    @Test
    public void registrarTest() {
        //Given
        Profesor profesor = new Profesor("PROF018","Juan", "Pérez", "null");
        
        //When
        profesorService.registrar(profesor);
        
        //Then
        verify(profesorRepository).save(profesor); 
    }
    @Test
    public void actualizarTest() {
        //Given
        Profesor profesor = new Profesor("PROF018","Juan", "Pérez", "null");
        
        //When
        profesorService.actualizar(profesor);
        
        //Then
        verify(profesorRepository).save(profesor);   
    }
    
    @Test
    public void eliminarTest() {
        //Given
        Profesor profesor = new Profesor("PROF018","Juan", "Pérez", "null");
        
        //When
        profesorService.eliminar(profesor.getId());
        
        //Then
        verify(profesorRepository).deleteById(profesor.getId());  
    }
    @Test
    public void consultarTest() {
        //Given
        Profesor profesor = new Profesor("PROF018","Juan", "Pérez", "null");
        
        //When
        profesorService.consultar(profesor.getId());
        
        //Then
        verify(profesorRepository).findById(profesor.getId()) ;
    }
    
}
