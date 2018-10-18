package com.tareas.springtareas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tareas.springtareas.entities.Tarea;
import com.tareas.springtareas.entities.User;
import com.tareas.springtareas.services.TareaService;
import com.tareas.springtareas.services.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringtareasApplicationTests {

	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TareaService tareaService;
	
	@org.junit.Before
	public void initData() {
		{
			User newUser = new User("testUser@gmail.com", "testUser", "12345", "calle de testUser","7711640" );
			userService.createUser(newUser);
		}
		{
			User newUser = new User("testAdmin@gmail.com", "testAdmin", "12345", "calle de testAdmin","7711640" );
			userService.createAdmin(newUser);
		}
		
		Tarea userTarea = new Tarea("01/01/2018", "08:00", "12:00", "Estudiar JAVA Spring ");
		//Optional<User> user = userService.findOne("testUser@gmail.com");
		User user = userService.findByEmail("testUser@gmail.com");
		tareaService.guardarTarea(userTarea, user);
	}
	
	@Test
	public void testUser() {
		User user = userService.findByEmail("testUser@gmail.com");
		assertNotNull(user);
		User admin = userService.findByEmail("testAdmin@gmail.com");
		assertEquals(admin.getEmail(), "testAdmin@gmail.com");
	}
	
	@Test
	public void testTarea() {
		User user = userService.findByEmail("testUser@gmail.com");
		List<Tarea> tarea = tareaService.findUserTarea(user);
		assertNotNull(tarea);
	}
	
}
