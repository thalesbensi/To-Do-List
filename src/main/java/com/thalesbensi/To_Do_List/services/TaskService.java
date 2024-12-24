package com.thalesbensi.To_Do_List.services;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thalesbensi.To_Do_List.entities.Task;
import com.thalesbensi.To_Do_List.repositories.TaskRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public List<Task> findAll(){
        return taskRepository.findAll();
    }

    public Task findById(Long id){
        return taskRepository.findById(id).get();
    }

    public Task addTask(@Valid Task task){
        return taskRepository.save(task);
    }

    public Task updateTask(@Valid Task task, Long id) {
        Task updatedTask = taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Task not found for ID: " + id));

        
        updatedTask.setTitle(task.getTitle());
        updatedTask.setDescription(task.getDescription());
        updatedTask.setStatus(task.getStatus());
        updatedTask.setUpdatedAt(new Date()); 

        return taskRepository.save(updatedTask);
    }
    
    public void deleteTask(Long id) {
    	 taskRepository.deleteById(id);
    }
}
