package com.tareas.springtareas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tareas.springtareas.entities.Tarea;
import com.tareas.springtareas.entities.User;
import com.tareas.springtareas.repositories.TareaRepository;

@Service
public class TareaService {

	@Autowired
	private TareaRepository tareaRepository;
	
	public void agregarTarea(Tarea tarea, User user) {
		tarea.setUser(user);
		tareaRepository.save(tarea);		
	}
	
	public List<Tarea> findUserTarea(User user){
		return tareaRepository.findByUser(user);
	}

	public void guardarTarea(Tarea userTarea, User user) {
		// TODO Auto-generated method stub
		userTarea.setUser(user);
		tareaRepository.save(userTarea);
		
	}
}
