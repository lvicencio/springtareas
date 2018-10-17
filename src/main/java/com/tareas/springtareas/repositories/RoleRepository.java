package com.tareas.springtareas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tareas.springtareas.entities.Role;

public interface RoleRepository extends JpaRepository<Role, String> {

}
