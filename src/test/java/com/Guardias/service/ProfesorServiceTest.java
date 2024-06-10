/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.Guardias.service;

import com.Guardias.model.Profesor;
import com.Guardias.repository.ProfesorRepository;
import com.Guardias.serviceImpl.ProfesorServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Valeria
 */
//@ContextConfiguration(locations={"/applicationContext-test.xml"})
public class ProfesorServiceTest {
    
    /**
     * Repositorio de profesores simulado para interactuar con {@link ProfesorServiceImpl}.
     */
    @Mock
    ProfesorRepository profesorRepository;
    /**
     * Instancia del servicio de profesores que se va a probar.
     */
    ProfesorServiceImpl profesorService;
    /**
     * Controla los recursos cerrables creados por Mockito.
     */
    AutoCloseable autocloseable;
    /**
     * Constructor por defecto.
     */
    public ProfesorServiceTest() {
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
     * Configura el entorno de prueba inicializando los mocks y creando una instancia de {@link ProfesorServiceImpl}
     * antes de cada prueba.
     */
    @BeforeEach
    public void setUp() {
        autocloseable = MockitoAnnotations.openMocks(this);
        profesorService= new ProfesorServiceImpl(profesorRepository);
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
     * Prueba del método {@link ProfesorServiceImpl#registrar(Profesor)}.
     * <p>
     * Verifica que el servicio llama al método `save` del repositorio con el profesor proporcionado.
     * </p>
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
    /**
     * Prueba del método {@link ProfesorServiceImpl#actualizar(Profesor)}.
     * <p>
     * Verifica que el servicio llama al método `save` del repositorio con el profesor actualizado.
     * </p>
     */
    @Test
    public void actualizarTest() {
        //Given
        Profesor profesor = new Profesor("PROF018","Juan", "Pérez", "null");
        
        //When
        profesorService.actualizar(profesor);
        
        //Then
        verify(profesorRepository).save(profesor);   
    }
     /**
     * Prueba del método {@link ProfesorServiceImpl#eliminar(String)}.
     * <p>
     * Verifica que el servicio llama al método `deleteById` del repositorio con el ID del profesor proporcionado.
     * </p>
     */
    @Test
    public void eliminarTest() {
        //Given
        Profesor profesor = new Profesor("PROF018","Juan", "Pérez", "null");
        
        //When
        profesorService.eliminar(profesor.getId());
        
        //Then
        verify(profesorRepository).deleteById(profesor.getId());  
    }
    /**
     * Prueba del método {@link ProfesorServiceImpl#consultar(String)}.
     * <p>
     * Verifica que el servicio llama al método `findById` del repositorio con el ID del profesor proporcionado.
     * </p>
     */
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
