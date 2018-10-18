package com.tareas.springtareas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tareas.springtareas.entities.User;

public interface UserRepository extends JpaRepository<User, String>{

	User findByEmail(String email);

}
