/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Guardias.service;

import com.Guardias.model.Horario;
import com.Guardias.model.ResultadoObtenerHorarioTareas;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author maria
 */
public interface HorarioService {
    ArrayList<Horario> list();
    
    /**
     * Método que trae los horarios de un profesor para un día en concreto
     * @return 
     */
    List<ResultadoObtenerHorarioTareas> listaHorarios(String id_profesor, String dia);
}
