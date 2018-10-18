package com.tareas.springtareas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tareas.springtareas.entities.Tarea;
import com.tareas.springtareas.entities.User;

public interface TareaRepository extends JpaRepository<Tarea, Long>{

	List<Tarea> findByUser(User user);

}
