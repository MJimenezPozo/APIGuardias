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
    
    
    public HoraSesionDto(HoraSesion hs){
        this.sesion = hs.getSesion();
        this.inicio = HorasUtil.DateToHorasMinutos(hs.getInicio());
        this.fin = HorasUtil.DateToHorasMinutos(hs.getFin());
    }
    
    public static HoraSesionDto toHoraSesionDto (HoraSesion horaSesion){
        
        return new HoraSesionDto(horaSesion.getSesion(),
                HorasUtil.DateToHorasMinutos(horaSesion.getInicio()),
                HorasUtil.DateToHorasMinutos(horaSesion.getFin()));
        
    }
    
}
