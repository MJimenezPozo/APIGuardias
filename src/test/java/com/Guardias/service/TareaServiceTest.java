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
    
    /**
     * Repositorio de profesores simulado para interactuar con {@link TareaServiceImpl}.
     */
    @Mock
    TareaRepository tareaRepository;
    /**
     * Instancia del servicio de tarea que se va a probar.
     */
    TareaServiceImpl tareaService;
    /**
     * Controla los recursos cerrables creados por Mockito.
     */
    AutoCloseable autoCloseable;
    
    /**
     * Constructor por defecto.
     */
    public TareaServiceTest(){
        
    }
    
    /**
     * Configuración inicial de la clase de prueba. Se ejecuta una vez antes de todas las pruebas.
     */
    @BeforeAll
    public static void setUpClass(){
        
    }
    
    /**
     * Limpieza final de la clase de prueba. Se ejecuta una vez después de todas las pruebas.
     */
    @AfterAll
    public static void tearDownClass(){
        
    }
    
    /**
     * Configura el entorno de prueba inicializando los mocks y creando una instancia de {@link TareaServiceImpl}
     * antes de cada prueba.
     */
    @BeforeEach
    public void setUp(){
       autoCloseable = MockitoAnnotations.openMocks(this);
       tareaService = new TareaServiceImpl(tareaRepository);
    }
    
    /**
     * Limpia los recursos de los mocks después de cada prueba.
     * 
     * @throws Exception si ocurre un error al cerrar los recursos.
     */
    @AfterEach
    public void tearDown() throws Exception {
        autoCloseable.close();
    }
    
    /**
     * Prueba del método {@link TareaServiceImpl#registrar(Tarea)}.
     * <p>
     * Verifica que el servicio llama al método `save` del repositorio con la tarea proporcionado.
     * </p>
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
    
    /**
     * Prueba del método {@link TareaServiceImpl#eliminar(String)}.
     * <p>
     * Verifica que el servicio llama al método `deleteByClave` del repositorio con la clave de la tarea proporcionada.
     * </p>
     */
    @Test
    public void eliminarTest(){
        //Given
        Tarea tarea = new Tarea("LPAL", "Prácticas de lengua extranjera Alemán I");
        
        //When
        tareaService.eliminar(tarea.getClave());
        
        //Then
        verify(tareaRepository).deleteByClave(tarea.getClave());
    }
    
    /**
     * Prueba del método {@link TareaServiceImpl#obtener(String)}.
     * <p>
     * Verifica que el servicio llama al método `findByClave` del repositorio con la clave de la tarea proporcionada.
     * </p>
     */
    @Test
    public void obtenerTest(){
        //Given
        Tarea tarea = new Tarea("LFCT","Períodos dedicados a la FCT del alumnado de F.P.");
        
        //When
        tareaService.obtener(tarea.getClave());
        
        //Then
        verify(tareaRepository).findByClave(tarea.getClave());
    }
    
    /**
     * Prueba del método {@link TareaServiceImpl#actualizar(Tarea)}.
     * <p>
     * Verifica que el servicio llama al método `save` del repositorio con la tarea actualizada.
     * </p>
     */
    @Test
    public void actualizarTest() {
        //Given
        Tarea tarea = new Tarea("AORG", "Apoyos genéricos de orientación");
        
        //When
        tareaService.actualizar(tarea);
        
        //Then
        verify(tareaRepository).save(tarea);   
    }
 
}
