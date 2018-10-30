package com.tareas.springtareas.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tareas.springtareas.entities.User;
import com.tareas.springtareas.services.TareaService;
import com.tareas.springtareas.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private TareaService tareaService;
	
	@GetMapping("/users")
	private String listUsers(Model model, @RequestParam(defaultValue="") String name ) {
		model.addAttribute("users", userService.findByName(name));
		return "views/listausuarios";
		
	}
	
	@GetMapping("/perfil")
	private String verPerfil(Model model, Principal principal) {
		
		String email = principal.getName();
		User user = userService.findByEmail(email);
		
		model.addAttribute("tareas", tareaService.findUserTarea(user));
		
		return "views/perfil";
	}
	
	
}
