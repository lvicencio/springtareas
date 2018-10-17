package com.tareas.springtareas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tareas.springtareas.entities.Tarea;

public interface TareaRepository extends JpaRepository<Tarea, Long>{

}
