package com.thalesbensi.To_Do_List.controllers;


import com.thalesbensi.To_Do_List.entities.Task;
import com.thalesbensi.To_Do_List.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping()
    public List<Task> findAll(){
        return taskService.findAll();
    }

    @GetMapping("/{id}")
    public Task findById(@PathVariable Long id){
        return taskService.findById(id);
    }

    @PostMapping
    public Task addTask(@RequestBody  Task task ){
            return taskService.addTask(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@RequestBody Task task, @PathVariable Long id) throws Exception {
        return taskService.updateTask(task, id);
    }
}
