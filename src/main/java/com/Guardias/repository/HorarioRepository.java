/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Guardias.repository;

import com.Guardias.DTO.HorarioGuardiasDto;
import com.Guardias.model.Horario;
import com.Guardias.model.ResultadoObtenerHorarioTareas;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
/**
 *
 * @author maria
 */
public interface HorarioRepository extends JpaRepository<Horario, Integer>{
    @Query(nativeQuery = true, name = "invoca_obtener_horario_tareas")
    List<ResultadoObtenerHorarioTareas> getHorarioTareas(@Param("profesor_id") String profesor_id,@Param("dia") String dia);
    
    @Query("SELECT new com.Guardias.DTO.HorarioGuardiasDto("
            + "h.horaSesion.sesion,"
            + "CONCAT(p.nombreProfesor, ' ', p.apellidosProfesor)) "
            + "FROM Horario h "
            + "JOIN h.profesor p "
            + "WHERE h.tipoTarea.clave = 'G' AND h.diaSemana = :dia "
            + "ORDER BY h.horaSesion.sesion")
    List<HorarioGuardiasDto> findPorfesoresGuardia(String dia);
}
