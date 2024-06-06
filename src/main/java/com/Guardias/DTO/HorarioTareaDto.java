/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Guardias.DTO;

import com.Guardias.model.ResultadoObtenerHorarioTareas;
import com.Guardias.utilidades.HorasUtil;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Fran
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HorarioTareaDto {
    
   private HoraSesionDto horaSesionDto;
   private String tarea;
   private String descripcion;
   private String aula;
   private String grupos;
   
   
   public static HorarioTareaDto toHorarioTareaDto(ResultadoObtenerHorarioTareas resultadoObtenerHorarioTareas){
       
       HoraSesionDto horaSesionDto = new HoraSesionDto(resultadoObtenerHorarioTareas.getSesion().toString(), HorasUtil.DateToHorasMinutos(resultadoObtenerHorarioTareas.getInicio()), 
                HorasUtil.DateToHorasMinutos(resultadoObtenerHorarioTareas.getFin()));
       
       return new HorarioTareaDto(horaSesionDto, resultadoObtenerHorarioTareas.getTarea(), resultadoObtenerHorarioTareas.getDescripcion(), resultadoObtenerHorarioTareas.getAula(),
       resultadoObtenerHorarioTareas.getGrupos());
       
   }
    
}
