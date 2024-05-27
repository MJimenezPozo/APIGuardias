/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Guardias.model;

import java.util.Date;

/**
 *
 * @author Valeria
 */

public class ResultadoObtenerHorarioTareas {
   private Integer horaSesion;
   private Date inicio;
   private Date fin;
   private String clave;
   private String descripcion;
   private String aula;
   private String subgrupo;

    public ResultadoObtenerHorarioTareas(Integer horaSesion, Date inicio, Date fin, String clave, String descripcion, String aula, String subgrupo) {
        this.horaSesion = horaSesion;
        this.inicio = inicio;
        this.fin = fin;
        this.clave = clave;
        this.descripcion = descripcion;
        this.aula = aula;
        this.subgrupo = subgrupo;
    }
   
   

    public Integer getHoraSesion() {
        return horaSesion;
    }

    public void setHoraSesion(Integer horaSesion) {
        this.horaSesion = horaSesion;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public String getSubgrupo() {
        return subgrupo;
    }

    public void setSubgrupo(String subgrupo) {
        this.subgrupo = subgrupo;
    }
   
   
    
}
