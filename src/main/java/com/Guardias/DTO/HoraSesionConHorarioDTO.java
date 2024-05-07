/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Guardias.DTO;

import com.Guardias.model.HoraSesion;
import com.Guardias.model.Horario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author maria
 */
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class HoraSesionConHorarioDTO {
    private String sesion;
    private Date inicio;
    private Date fin; 
    private List<Horario> horarioList = new ArrayList<Horario>(); //Debería ser horario dto, explorar esto
    
    public HoraSesionConHorarioDTO(HoraSesion hs){
        this.sesion = hs.getSesion();
        this.inicio = hs.getInicio();
        this.fin = hs.getFin();
//        List<Horario> horarios = hs.getHorarioList();
//        for (Horario h : horarios){
//            Horario hSin = new Horario(h);
//            horarioList.add(hSin);
//        }
    }
}
