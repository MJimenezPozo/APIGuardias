/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Guardias.model;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 *
 * @author maria
 */
@Entity
@Table(name = "horario")
@NamedQueries({
    @NamedQuery(name = "Horario.findAll", query = "SELECT h FROM Horario h"),
    @NamedQuery(name = "Horario.findByIdSesion", query = "SELECT h FROM Horario h WHERE h.idSesion = :idSesion"),
    @NamedQuery(name = "Horario.findByHorario", query = "SELECT h FROM Horario h WHERE h.horario = :horario"),
    @NamedQuery(name = "Horario.findByCurso", query = "SELECT h FROM Horario h WHERE h.curso = :curso"),
    @NamedQuery(name = "Horario.findByDiaSemana", query = "SELECT h FROM Horario h WHERE h.diaSemana = :diaSemana"),
    @NamedQuery(name = "Horario.findByMateria", query = "SELECT h FROM Horario h WHERE h.materia = :materia"),
    @NamedQuery(name = "Horario.findByGrupo", query = "SELECT h FROM Horario h WHERE h.grupo = :grupo"),
    @NamedQuery(name = "Horario.findBySubgrupo", query = "SELECT h FROM Horario h WHERE h.subgrupo = :subgrupo"),
    @NamedQuery(name = "Horario.findByAula", query = "SELECT h FROM Horario h WHERE h.aula = :aula")})
public class Horario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sesion")
    private Integer idSesion;
    @Basic(optional = false)
    @Column(name = "horario")
    private int horario;
    @Basic(optional = false)
    @Column(name = "curso")
    private String curso;
    @Basic(optional = false)
    @Column(name = "dia_semana")
    private String diaSemana;
    @Column(name = "materia")
    private String materia;
    @Column(name = "grupo")
    private String grupo;
    @Column(name = "subgrupo")
    private String subgrupo;
    @Column(name = "aula")
    private String aula;
    @JoinColumn(name = "hora_sesion", referencedColumnName = "sesion")
    @ManyToOne(optional = false)
    private HoraSesion horaSesion;
    @JoinColumn(name = "profesor", referencedColumnName = "id_profesor")
    @ManyToOne
    private Profesor profesor;
    @JoinColumn(name = "tipo_tarea", referencedColumnName = "clave")
    @ManyToOne(optional = false)
    private Tarea tipoTarea;

    public Horario() {
    }

    public Horario(Integer idSesion) {
        this.idSesion = idSesion;
    }

    public Horario(Integer idSesion, int horario, String curso, String diaSemana) {
        this.idSesion = idSesion;
        this.horario = horario;
        this.curso = curso;
        this.diaSemana = diaSemana;
    }

    public Integer getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(Integer idSesion) {
        this.idSesion = idSesion;
    }

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getSubgrupo() {
        return subgrupo;
    }

    public void setSubgrupo(String subgrupo) {
        this.subgrupo = subgrupo;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public HoraSesion getHoraSesion() {
        return horaSesion;
    }

    public void setHoraSesion(HoraSesion horaSesion) {
        this.horaSesion = horaSesion;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Tarea getTipoTarea() {
        return tipoTarea;
    }

    public void setTipoTarea(Tarea tipoTarea) {
        this.tipoTarea = tipoTarea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSesion != null ? idSesion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horario)) {
            return false;
        }
        Horario other = (Horario) object;
        if ((this.idSesion == null && other.idSesion != null) || (this.idSesion != null && !this.idSesion.equals(other.idSesion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.Guardias.model.Horario[ idSesion=" + idSesion + " ]";
    }
    
}
