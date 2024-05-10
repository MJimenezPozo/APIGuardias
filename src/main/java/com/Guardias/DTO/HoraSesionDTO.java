/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Guardias.DTO;

import com.Guardias.model.HoraSesion;
import com.Guardias.utilidades.HorasUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author maria
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HoraSesionDto {
    private String sesion;
    private String inicio;
    private String fin; 
    //private List<Horario> horarioList = new ArrayList<Horario>(); //Debería ser horario dto, explorar esto
    
    public HoraSesionDto(HoraSesion hs){
        this.sesion = hs.getSesion();
        this.inicio = HorasUtil.DateToHorasMinutos(hs.getInicio());
        this.fin = HorasUtil.DateToHorasMinutos(hs.getFin());
//        List<Horario> horarios = hs.getHorarioList();
//        for (Horario h : horarios){
//            Horario hSin = new Horario(h);
//            horarioList.add(hSin);
//        }
    }
    
    public static HoraSesionDto toHoraSesionDto (HoraSesion horaSesion){
        
        return new HoraSesionDto(horaSesion.getSesion(),
                HorasUtil.DateToHorasMinutos(horaSesion.getInicio()),
                HorasUtil.DateToHorasMinutos(horaSesion.getFin()));
        
    }
    
}
