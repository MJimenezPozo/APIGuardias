/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Guardias.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(name = "id")
    @Basic(optional = false)
    private int id;
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
    @JsonIgnore
    private List<Horario> horarioList;

    public Profesor() {
    }

    public Profesor(int id) {
        this.id = id;
    }

    public Profesor(int id,String idProfesor, String nombreProfesor, String apellidosProfesor) {
        this.id = id;
        this.idProfesor = idProfesor;
        this.nombreProfesor = nombreProfesor;
        this.apellidosProfesor = apellidosProfesor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Profesor other = (Profesor) obj;
        return this.id == other.id;
    }
    
    @Override
    public String toString() {
        return "com.Guardias.model.Profesor[ id=" + id + " ]";
    }
    
}
