
package com.Guardias.service;

import com.Guardias.model.Tarea;
import java.util.Optional;

/**
 *
 * @author maria
 */
public interface TareaService {
    Optional<Tarea> findByClave(String clave);
    
    void deleteByClave(String clave);
}
