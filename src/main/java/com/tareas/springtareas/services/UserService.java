package com.tareas.springtareas.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tareas.springtareas.entities.Role;
import com.tareas.springtareas.entities.User;
import com.tareas.springtareas.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public void createUser(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		Role userRole = new Role("USER");
		List<Role> roles = new ArrayList<>();
		roles.add(userRole);
		user.setRoles(roles);
		userRepository.save(user);
		
	}
	
	public void createAdmin(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		Role userRole = new Role("ADMIN");
		List<Role> roles = new ArrayList<>();
		roles.add(userRole);
		user.setRoles(roles);
		userRepository.save(user);
		
	}
	
	public Optional<User> findOne(String email) {
		return userRepository.findById(email);
	}
	
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public boolean isUserPresent(String email) {
		// TODO Auto-generated method stub
		User u = userRepository.findByEmail(email);
		if (u!=null) {
			return true;
		} else {
			return false;
		}
		
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	public List<User> findByName(String name) {
		// TODO Auto-generated method stub
		return userRepository.findByNameLike("%"+name+"%");
	}
}
