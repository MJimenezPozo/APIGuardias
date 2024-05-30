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
   private Integer sesion;
   private Date inicio;
   private Date fin;
   private String tarea;
   private String descripcion;
   private String aula;
   private String grupos;

    public ResultadoObtenerHorarioTareas(Integer sesion, Date inicio, Date fin, String tarea, String descripcion, String aula, String grupos) {
        this.sesion = sesion;
        this.inicio = inicio;
        this.fin = fin;
        this.tarea = tarea;
        this.descripcion = descripcion;
        this.aula = aula;
        this.grupos = grupos;
    }
   
   

    public Integer getSesion() {
        return sesion;
    }

    public void setSesion(Integer sesion) {
        this.sesion = sesion;
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

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
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

    public String getGrupos() {
        return grupos;
    }

    public void setGrupos(String grupos) {
        this.grupos = grupos;
    }
}
