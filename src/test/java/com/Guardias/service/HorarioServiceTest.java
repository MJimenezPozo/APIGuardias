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
    
    @Mock
    private HorarioRepository hRepository;
    
    @InjectMocks
    private HorarioServiceImpl hService;
    
    private Horario horario;
    
    @BeforeEach
    public void setUp() {
        horario = new Horario();
        horario.setIdSesion(7);
    }

    @Test
    public void testConsultarTodos() {
        List<Horario> horarios = new ArrayList<>();
        horarios.add(horario);
        when(hRepository.findAll()).thenReturn(horarios);

        List<Horario> result = hService.consultarTodos();

        assertEquals(1, result.size());
        verify(hRepository, times(1)).findAll();
    }
    
    @Test
    public void testRegistrar() {
        when(hRepository.save(any(Horario.class))).thenReturn(horario);

        Horario result = hService.registrar(horario);

        assertEquals(horario, result);
        verify(hRepository, times(1)).save(horario);
    }
    
    @Test
    public void testActualizar() {
        when(hRepository.save(any(Horario.class))).thenReturn(horario);

        Horario result = hService.actualizar(horario);

        assertEquals(horario, result);
        verify(hRepository, times(1)).save(horario);
    }
    
    @Test
    public void testEliminar() {
        doNothing().when(hRepository).deleteById(anyInt());

        hService.eliminar(1);

        verify(hRepository, times(1)).deleteById(1);
    }
    
    @Test
    public void testConsultar() {
        when(hRepository.findById(anyInt())).thenReturn(Optional.of(horario));

        Horario result = hService.consultar(1);

        assertEquals(horario, result);
        verify(hRepository, times(1)).findById(1);
    }
    
    @Test
    public void testConsultarNotFound() {
        when(hRepository.findById(anyInt())).thenReturn(Optional.empty());

        Horario result = hService.consultar(1);

        assertNotNull(result);
        verify(hRepository, times(1)).findById(1);
    }
    
    
    @Test
    public void testListaHorarios() {
        List<ResultadoObtenerHorarioTareas> resultados = new ArrayList<>();
        when(hRepository.getHorarioTareas(anyString(), anyString())).thenReturn(resultados);

        List<ResultadoObtenerHorarioTareas> result = hService.listaHorarios("PROF001", "L");

        assertEquals(resultados, result);
        verify(hRepository, times(1)).getHorarioTareas("PROF001", "L");
    }
    
    @Test
    public void testGetProfesoresGuardia() {
        List<HorarioGuardiasDto> guardias = new ArrayList<>();
        when(hRepository.findPorfesoresGuardia(anyString())).thenReturn(guardias);

        List<HorarioGuardiasDto> result = hService.getProfesoresGuardia("lunes");

        assertEquals(guardias, result);
        verify(hRepository, times(1)).findPorfesoresGuardia("lunes");
    }

    
}
