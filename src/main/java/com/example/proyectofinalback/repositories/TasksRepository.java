package com.example.proyectofinalback.repositories;

import com.example.proyectofinalback.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TasksRepository extends JpaRepository<Task, Long> {

}
