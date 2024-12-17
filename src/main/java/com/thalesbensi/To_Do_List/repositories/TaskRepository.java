package com.thalesbensi.To_Do_List.repositories;

import com.thalesbensi.To_Do_List.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepository extends JpaRepository<Task, Long> {
}
