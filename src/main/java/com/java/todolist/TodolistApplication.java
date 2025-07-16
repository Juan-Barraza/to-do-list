package com.java.todolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
// Expluyo de momento el secury de spring para pruebas, cuando implemente el jwt lo integro nuevamnete
// para proteccion de los endpoints
@EnableAutoConfiguration(exclude = { SecurityAutoConfiguration.class })  
public class TodolistApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}

}
