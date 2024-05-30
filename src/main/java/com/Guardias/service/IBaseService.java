/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Guardias.service;

import org.springframework.stereotype.Service;

/**
 *
 * @author Fran
 */
@Service
public interface IBaseService<T> {

    T registrar(T input);

    T actualizar(T input);

    void eliminar(Integer id);
    
//  Page<T> consultarTodos(Pageable pageable);

    T consultar(Integer id);
    

}
