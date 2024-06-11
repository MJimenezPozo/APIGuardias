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
    
    /**
     * Repositorio de horaSesion simulado para interactuar con {@link HoraSesionServiceImpl}.
     */
    @Mock
    HoraSesionRepository horaSesionRepository;
    /**
     * Instancia del servicio de horaSesison que se va a probar.
     */
    HoraSesionServiceImpl horaSesionService;
    /**
     * Controla los recursos cerrables creados por Mockito.
     */
    AutoCloseable autocloseable;
    
    /**
     * Constructor por defecto.
     */
    public HoraSesionServiceTest() {
    }
    
    /**
     * Configuración inicial de la clase de prueba. Se ejecuta una vez antes de todas las pruebas.
     */
    @BeforeAll
    public static void setUpClass() {
    }
    
    /**
     * Limpieza final de la clase de prueba. Se ejecuta una vez después de todas las pruebas.
     */
    @AfterAll
    public static void tearDownClass() {
    }
    
    /**
     * Configura el entorno de prueba inicializando los mocks y creando una instancia de {@link HoraSesionServiceImpl}
     * antes de cada prueba.
     */
    @BeforeEach
    public void setUp() {
        autocloseable = MockitoAnnotations.openMocks(this);
        horaSesionService= new HoraSesionServiceImpl(horaSesionRepository);
    }
    
    /**
     * Limpia los recursos de los mocks después de cada prueba.
     * 
     * @throws Exception si ocurre un error al cerrar los recursos.
     */
    @AfterEach
    public void tearDown() throws Exception {
        autocloseable.close();
    }

    /**
     * Prueba del método {@link HoraSesionServiceImpl#consultarTodos()}.
     * <p>
     * Verifica que el servicio llama al método `findAll` del repositorio.
     * </p>
     */
    @Test
    public void consultarTodosTest() {
        //When
        horaSesionService.consultarTodos();
        
        //Then
        verify(horaSesionRepository).findAll();
    }
    
    /**
     * Prueba del método {@link HorarioSesionServiceImpl#registrar(HoraSesion)}.
     * <p>
     * Verifica que el servicio llama al método `save` del repositorio con la sesion proporcionada.
     * </p>
     */
    @Test
    public void registrarTest() {
        //Given
        HoraSesion horasesion = new HoraSesion("Test1", new Date(), new Date());
        //When
        horaSesionService.registrar(horasesion);
        //Then
        verify(horaSesionRepository).save(horasesion);
    }
    
    /**
     * Prueba del método {@link HorarioSesionServiceImpl#actualizar(HoraSesion)}.
     * <p>
     * Verifica que el servicio llama al método `save` del repositorio con la sesion actualizada.
     * </p>
     */
    @Test
    public void actualizarTest() {
        //Given
        HoraSesion horasesion = new HoraSesion("Test1", new Date(), new Date());
        
        //When
        horaSesionService.actualizar(horasesion);
        
        //Then
        verify(horaSesionRepository).save(horasesion);   
    }
    
    /**
     * Prueba del método {@link HoraSesionServiceImpl#eliminar(String)}.
     * <p>
     * Verifica que el servicio llama al método `deleteBySesion` del repositorio con el ID de la sesion proporcionada.
     * </p>
     */
    @Test
    public void eliminarTest() {
        //Given
        HoraSesion horasesion = new HoraSesion("Test1", new Date(), new Date());
        
        //When
        horaSesionService.eliminar(horasesion.getSesion());
        
        //Then
        verify(horaSesionRepository).deleteBySesion(horasesion.getSesion());  
    }
    
    /**
     * Prueba del método {@link HoraSesionServiceImpl#consultar(String)}.
     * <p>
     * Verifica que el servicio llama al método `findBySesion` del repositorio con el ID de la sesion proporcionada.
     * </p>
     */
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
