/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Guardias.DTO;

import com.Guardias.model.Tarea;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Andrea
 */
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class TareaSimpleDTO {
    private String clave;
    private String descripcion;
    
    public TareaSimpleDTO(Tarea t){
        this.clave = t.getClave();
        this.descripcion = t.getDescripcion();
    }
}