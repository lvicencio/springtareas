package com.tareas.springtareas.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tareas.springtareas.entities.Tarea;
import com.tareas.springtareas.services.TareaService;
import com.tareas.springtareas.services.UserService;

@Controller
public class TareaController {

	@Autowired
	private TareaService tareaService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/agregartarea")
	public String tareaFormulario(String email, Model model, HttpSession session) {
		session.setAttribute("email", email);
		model.addAttribute("tarea", new Tarea());
		
		return "views/tareaformulario";
	}
	
	@PostMapping("/agregartarea")
	public String agregarTarea(@Valid Tarea tarea, BindingResult br, HttpSession session) {
		if (br.hasErrors()) {
			return "views/tareaformulario";
		}
		String email = (String) session.getAttribute("email");
		tareaService.agregarTarea(tarea, userService.findByEmail(email));
		
		return "redirect:/users";
	
	}
	
	
}
