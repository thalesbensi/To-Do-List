package com.thalesbensi.To_Do_List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.thalesbensi.To_Do_List.entities.Task;
import com.thalesbensi.To_Do_List.repositories.TaskRepository;

@SpringBootApplication
public class ToDoListApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToDoListApplication.class, args);
	
	}
}
