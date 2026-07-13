package com.poo.cfp2.estudiantes.repository;

import com.poo.cfp2.estudiantes.entity.Estudiante;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstudiante extends JpaRepository<Estudiante,Long> {
}
