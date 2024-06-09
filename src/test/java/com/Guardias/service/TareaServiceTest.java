/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Guardias.service;

import com.Guardias.model.Tarea;
import com.Guardias.repository.TareaRepository;
import com.Guardias.serviceImpl.TareaServiceImpl;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Andrea
 */
public class TareaServiceTest {
    
    @Mock
    TareaRepository tareaRepository;
    TareaServiceImpl tareaService;
    AutoCloseable autoCloseable;
    
    public TareaServiceTest(){
        
    }
    
    @BeforeAll
    public static void setUpClass(){
        
    }
    
    @AfterAll
    public static void tearDownClass(){
        
    }
    
    @BeforeEach
    public void setUp(){
       autoCloseable = MockitoAnnotations.openMocks(this);
       tareaService = new TareaServiceImpl(tareaRepository);
    }
    
    @AfterEach
    public void tearDown() throws Exception {
        autoCloseable.close();
    }
    
    /**
     * Lista de los métodos del test, de la clase TareaService
     */
    @Test
    public void registrarTest() {
        //Given
        Tarea tarea = new Tarea("LPAL", "Prácticas de lengua extranjera Alemán I");
        
        //When
        tareaService.registrar(tarea);
        
        //Then
        verify(tareaRepository).save(tarea);
    }
    
    @Test
    public void eliminarTest(){
        //Given
        Tarea tarea = new Tarea("LPAL", "Prácticas de lengua extranjera Alemán I");
        
        //When
        tareaService.eliminar(tarea.getClave());
        
        //Then
        verify(tareaRepository).deleteByClave(tarea.getClave());
    }
    
    @Test
    public void obtenerTest(){
        //Given
        Tarea tarea = new Tarea("LFCT","Períodos dedicados a la FCT del alumnado de F.P.");
        
        //When
        tareaService.obtener(tarea.getClave());
        
        //Then
        verify(tareaRepository).findByClave(tarea.getClave());
    }
    
    
    
}
