/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Guardias.service;

import com.Guardias.model.Tarea;
import java.util.ArrayList;
/**
 *
 * @author maria
 */
public interface TareaService {
    Tarea registrar (Tarea tarea);
    Tarea modificar (Tarea tarea);
    ArrayList<Tarea> listar();
    Tarea obtener (String clave);
    void eliminar (String clave);
}
