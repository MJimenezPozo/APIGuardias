/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Guardias.DTO;

import com.Guardias.model.Horario;
import com.Guardias.model.Profesor;
import com.Guardias.model.Tarea;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Fran
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HorarioDto {
    
    private Integer idSesion;
    private int horario;
    private String curso;
    private String diaSemana;
    private String materia;
    private String grupo;
    private String subgrupo;
    private String aula;
    private HoraSesionDto horaSesion;
    private Profesor profesor;
    private Tarea tipoTarea;
    
    public static HorarioDto toHorarioDto(Horario horario){
        
        return new HorarioDto(horario.getIdSesion(), horario.getHorario(), horario.getCurso(), horario.getDiaSemana(),
                horario.getMateria(), horario.getGrupo(), horario.getSubgrupo(), horario.getAula(),
                HoraSesionDto.toHoraSesionDto(horario.getHoraSesion()), horario.getProfesor(), horario.getTipoTarea());
        
    }
    
}
