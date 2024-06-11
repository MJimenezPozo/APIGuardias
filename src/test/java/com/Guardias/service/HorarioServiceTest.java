/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Guardias.service;

import com.Guardias.DTO.HorarioGuardiasDto;
import com.Guardias.model.Horario;
import com.Guardias.model.ResultadoObtenerHorarioTareas;
import com.Guardias.repository.HorarioRepository;
import com.Guardias.serviceImpl.HorarioServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author maria
 */
@ExtendWith(MockitoExtension.class)
public class HorarioServiceTest {
    
    /**
     * Repositorio de profesores simulado para interactuar con {@link HorarioServiceImpl}.
     */
    @Mock
    private HorarioRepository hRepository;
    /**
     * Instancia del servicio de horario que se va a probar.
     */
    @InjectMocks
    private HorarioServiceImpl hService;
    /**
     * Controla los recursos cerrables creados por Mockito.
     */
    private Horario horario;
    /**
     * Configura el entorno de prueba inicializando los mocks y creando una instancia de {@link HorarioServiceImpl}
     * antes de cada prueba.
     */
    @BeforeEach
    public void setUp() {
        horario = new Horario();
        horario.setIdSesion(7);
    }
    /**
     * Prueba del método {@link HorarioServiceImpl#consultarTodos()}.
     * <p>
     * Verifica que el servicio llama al método `findAll` del repositorio.
     * </p>
     */
    @Test
    public void testConsultarTodos() {
        List<Horario> horarios = new ArrayList<>();
        horarios.add(horario);
        when(hRepository.findAll()).thenReturn(horarios);

        List<Horario> result = hService.consultarTodos();

        assertEquals(1, result.size());
        verify(hRepository, times(1)).findAll();
    }
    
    /**
     * Prueba del método {@link HorarioServiceImpl#registrar(Horario)}.
     * <p>
     * Verifica que el servicio llama al método `save` del repositorio con el horario proporcionado.
     * </p>
     */
    @Test
    public void testRegistrar() {
        when(hRepository.save(any(Horario.class))).thenReturn(horario);

        Horario result = hService.registrar(horario);

        assertEquals(horario, result);
        verify(hRepository, times(1)).save(horario);
    }
    
    /**
     * Prueba del método {@link HorarioServiceImpl#actualizar(Horario)}.
     * <p>
     * Verifica que el servicio llama al método `save` del repositorio con el horario actualizado.
     * </p>
     */
    @Test
    public void testActualizar() {
        when(hRepository.save(any(Horario.class))).thenReturn(horario);

        Horario result = hService.actualizar(horario);

        assertEquals(horario, result);
        verify(hRepository, times(1)).save(horario);
    }
    
    /**
     * Prueba del método {@link HorarioServiceImpl#eliminar(int)}.
     * <p>
     * Verifica que el servicio llama al método `deleteById` del repositorio con el ID del horario proporcionado.
     * </p>
     */
    @Test
    public void testEliminar() {
        doNothing().when(hRepository).deleteById(anyInt());

        hService.eliminar(1);

        verify(hRepository, times(1)).deleteById(1);
    }
    
    /**
     * Prueba del método {@link HorarioServiceImpl#consultar(int)}.
     * <p>
     * Verifica que el servicio llama al método `findById` del repositorio con el ID del horario proporcionado.
     * </p>
     */
    @Test
    public void testConsultar() {
        when(hRepository.findById(anyInt())).thenReturn(Optional.of(horario));

        Horario result = hService.consultar(1);

        assertEquals(horario, result);
        verify(hRepository, times(1)).findById(1);
    }
    
    /**
     * Prueba del método {@link HorarioServiceImpl#consultar(int)}.
     * <p>
     * Verifica que el servicio llama al método `findById` del repositorio con el ID del horario proporcionado.
     * </p>
     */
    @Test
    public void testConsultarNotFound() {
        when(hRepository.findById(anyInt())).thenReturn(Optional.empty());

        Horario result = hService.consultar(1);

        assertNotNull(result);
        verify(hRepository, times(1)).findById(1);
    }
    
    /**
     * Prueba del método {@link HorarioServiceImpl#ListaHorarios(String, String)}.
     * <p>
     * Verifica que el servicio llama al método `getHorarioTareas` del repositorio y obtiene el horario para ese profesor y ese día.
     * </p>
     */
    @Test
    public void testListaHorarios() {
        List<ResultadoObtenerHorarioTareas> resultados = new ArrayList<>();
        when(hRepository.getHorarioTareas(anyString(), anyString())).thenReturn(resultados);

        List<ResultadoObtenerHorarioTareas> result = hService.listaHorarios("PROF001", "L");

        assertEquals(resultados, result);
        verify(hRepository, times(1)).getHorarioTareas("PROF001", "L");
    }
    
    /**
     * Prueba del método {@link HorarioServiceImpl#GetProfesoresGuardia(String)}.
     * <p>
     * Verifica que el servicio llama al método `findProfesoreGuardia` del repositorio y obtiene el día que tiene guardia ese profesor.
     * </p>
     */
    @Test
    public void testGetProfesoresGuardia() {
        List<HorarioGuardiasDto> guardias = new ArrayList<>();
        when(hRepository.findPorfesoresGuardia(anyString())).thenReturn(guardias);

        List<HorarioGuardiasDto> result = hService.getProfesoresGuardia("lunes");

        assertEquals(guardias, result);
        verify(hRepository, times(1)).findPorfesoresGuardia("lunes");
    }

    
}
