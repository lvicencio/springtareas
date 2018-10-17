package com.tareas.springtareas.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;



@Entity
public class User {
	
	@Id
	@Email
	@NotEmpty
	@Column(unique=true)
	private String email;
	
	@NotEmpty
	private String name;
	
	@Size(min=3)
	private String password;
	private String direccion;
	private String phone;
	
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	private List<Tarea> tareas;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="USER_ROLES", joinColumns= {
			@JoinColumn(name="USER_EMAIL", referencedColumnName="email")
	}, inverseJoinColumns= {@JoinColumn(name="ROLE_NAME", referencedColumnName="name")})
	private List<Role> roles;
		
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public List<Tarea> getTareas() {
		return tareas;
	}
	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public User(String email, String name, String password, String direccion, String phone) {
		this.email = email;
		this.name = name;
		this.password = password;
		this.direccion = direccion;
		this.phone = phone;
	}
	
	public User() {}
}
