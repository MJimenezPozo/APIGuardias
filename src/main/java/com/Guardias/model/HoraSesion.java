/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Guardias.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import jakarta.persistence.*;
import java.util.Date;


/**
 *
 * @author maria
 */
@Entity
@Table(name = "hora_sesion")
@NamedQueries({
    @NamedQuery(name = "HoraSesion.findAll", query = "SELECT h FROM HoraSesion h"),
    @NamedQuery(name = "HoraSesion.findBySesion", query = "SELECT h FROM HoraSesion h WHERE h.sesion = :sesion"),
    @NamedQuery(name = "HoraSesion.findByInicio", query = "SELECT h FROM HoraSesion h WHERE h.inicio = :inicio"),
    @NamedQuery(name = "HoraSesion.findByFin", query = "SELECT h FROM HoraSesion h WHERE h.fin = :fin")})
public class HoraSesion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "sesion")
    private String sesion;
    @Basic(optional = false)
    @Column(name = "inicio")
    @Temporal(TemporalType.TIME)
    private Date inicio;
    @Basic(optional = false)
    @Column(name = "fin")
    @Temporal(TemporalType.TIME)
    private Date fin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "horaSesion")
    @JsonIgnore
    private List<Horario> horarioList;

    public HoraSesion() {
    }

    public HoraSesion(String sesion) {
        this.sesion = sesion;
    }

    public HoraSesion(String sesion, Date inicio, Date fin) {
        this.sesion = sesion;
        this.inicio = inicio;
        this.fin = fin;
    }

    public String getSesion() {
        return sesion;
    }

    public void setSesion(String sesion) {
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

    public List<Horario> getHorarioList() {
        return horarioList;
    }

    public void setHorarioList(List<Horario> horarioList) {
        this.horarioList = horarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sesion != null ? sesion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HoraSesion)) {
            return false;
        }
        HoraSesion other = (HoraSesion) object;
        if ((this.sesion == null && other.sesion != null) || (this.sesion != null && !this.sesion.equals(other.sesion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Sesión: id: " + this.sesion + ", inicio: "+this.inicio+", fin: "+this.fin;
    }
    
}
