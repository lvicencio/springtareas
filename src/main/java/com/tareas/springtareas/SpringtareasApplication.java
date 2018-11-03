package com.tareas.springtareas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class SpringtareasApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringtareasApplication.class, args);
	}
}
