package com.thalesbensi.To_Do_List.services;


import com.thalesbensi.To_Do_List.entities.Task;
import com.thalesbensi.To_Do_List.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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

    public Task addTask(Task task){
        return taskRepository.save(task);
    }

    public Task updateTask(Task task) throws Exception {
        Date date = new Date();
        Task updatedTask = taskRepository.findById(task.getId()).orElseThrow(
                () -> new Exception("No tasks found for this ID"));
        updatedTask.setTitle(task.getTitle());
        updatedTask.setDescription(task.getDescription());
        updatedTask.setStatus(task.getStatus());
        updatedTask.setUpdatedAt(date);
        return taskRepository.save(updatedTask);
    }
}
