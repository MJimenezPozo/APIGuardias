/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.Guardias.service;

import com.Guardias.model.HoraSesion;
import com.Guardias.repository.HoraSesionRepository;
import com.Guardias.serviceImpl.HoraSesionServiceImpl;
import com.Guardias.serviceImpl.ProfesorServiceImpl;
import java.util.ArrayList;
import java.util.Date;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Valeria
 */
public class HoraSesionServiceTest {
    @Mock
    HoraSesionRepository horaSesionRepository;
    /**
     * Instancia del servicio de profesores que se va a probar.
     */
    HoraSesionServiceImpl horaSesionService;
    /**
     * Controla los recursos cerrables creados por Mockito.
     */
    AutoCloseable autocloseable;
    
    public HoraSesionServiceTest() {
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
        horaSesionService= new HoraSesionServiceImpl(horaSesionRepository);
    }
    
    @AfterEach
    public void tearDown() throws Exception {
        autocloseable.close();
    }

    @Test
    public void consultarTodosTest() {
        //When
        horaSesionService.consultarTodos();
        
        //Then
        verify(horaSesionRepository).findAll();
    }
    @Test
    public void registrarTest() {
        //Given
        HoraSesion horasesion = new HoraSesion("Test1", new Date(), new Date());
        //When
        horaSesionService.registrar(horasesion);
        //Then
        verify(horaSesionRepository).save(horasesion);
    }
     @Test
    public void actualizarTest() {
        //Given
        HoraSesion horasesion = new HoraSesion("Test1", new Date(), new Date());
        
        //When
        horaSesionService.actualizar(horasesion);
        
        //Then
        verify(horaSesionRepository).save(horasesion);   
    }
    @Test
    public void eliminarTest() {
        //Given
        HoraSesion horasesion = new HoraSesion("Test1", new Date(), new Date());
        
        //When
        horaSesionService.eliminar(horasesion.getSesion());
        
        //Then
        verify(horaSesionRepository).deleteBySesion(horasesion.getSesion());  
    }
    @Test
    public void consultarTest() {
        //Given
        HoraSesion horasesion = new HoraSesion("Test1", new Date(), new Date());
        
        //When
        horaSesionService.consultar(horasesion.getSesion());
        
        //Then
        verify(horaSesionRepository).findBySesion(horasesion.getSesion());
    }

    
    
}
