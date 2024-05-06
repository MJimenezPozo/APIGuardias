/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Guardias.model;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.*;

/**
 *
 * @author maria
 */
@Entity
@Table(name = "profesor")
@NamedQueries({
    @NamedQuery(name = "Profesor.findAll", query = "SELECT p FROM Profesor p"),
    @NamedQuery(name = "Profesor.findByIdProfesor", query = "SELECT p FROM Profesor p WHERE p.idProfesor = :idProfesor"),
    @NamedQuery(name = "Profesor.findByNombreProfesor", query = "SELECT p FROM Profesor p WHERE p.nombreProfesor = :nombreProfesor"),
    @NamedQuery(name = "Profesor.findByApellidosProfesor", query = "SELECT p FROM Profesor p WHERE p.apellidosProfesor = :apellidosProfesor"),
    @NamedQuery(name = "Profesor.findByPasswordProfesor", query = "SELECT p FROM Profesor p WHERE p.passwordProfesor = :passwordProfesor")})
public class Profesor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_profesor")
    private String idProfesor;
    @Basic(optional = false)
    @Column(name = "nombre_profesor")
    private String nombreProfesor;
    @Basic(optional = false)
    @Column(name = "apellidos_profesor")
    private String apellidosProfesor;
    @Column(name = "password_profesor")
    private String passwordProfesor;
    @OneToMany(mappedBy = "profesor")
    private List<Horario> horarioList;

    public Profesor() {
    }

    public Profesor(String idProfesor) {
        this.idProfesor = idProfesor;
    }

    public Profesor(String idProfesor, String nombreProfesor, String apellidosProfesor) {
        this.idProfesor = idProfesor;
        this.nombreProfesor = nombreProfesor;
        this.apellidosProfesor = apellidosProfesor;
    }

    public String getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(String idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public String getApellidosProfesor() {
        return apellidosProfesor;
    }

    public void setApellidosProfesor(String apellidosProfesor) {
        this.apellidosProfesor = apellidosProfesor;
    }

    public String getPasswordProfesor() {
        return passwordProfesor;
    }

    public void setPasswordProfesor(String passwordProfesor) {
        this.passwordProfesor = passwordProfesor;
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
        hash += (idProfesor != null ? idProfesor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesor)) {
            return false;
        }
        Profesor other = (Profesor) object;
        if ((this.idProfesor == null && other.idProfesor != null) || (this.idProfesor != null && !this.idProfesor.equals(other.idProfesor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.Guardias.model.Profesor[ idProfesor=" + idProfesor + " ]";
    }
    
}
