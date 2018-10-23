package com.tareas.springtareas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tareas.springtareas.entities.User;
import com.tareas.springtareas.services.UserService;

@Controller
public class RegistroController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/registrar")
	//@RequestMapping(value="/registrar", method = RequestMethod.GET)
	public String formularioRegistro(Model model) {
		
		model.addAttribute("user", new User() );		
		return "views/formularioregistro";
	}
	
	@PostMapping("/registrar")
	//@RequestMapping(value = "/registrar", method = RequestMethod.POST)
	public String registrarUser(@Valid User user, BindingResult br, Model model) {
		if (br.hasErrors()) {
			return "views/formularioregistro";
		}
		if (userService.isUserPresent(user.getEmail())) {
			model.addAttribute("existeEmail", true);
			return "views/formularioregistro";
		}
		userService.createUser(user);
		
		return "views/entrar";
		
	}
}
