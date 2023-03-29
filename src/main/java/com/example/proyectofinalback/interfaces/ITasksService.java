package com.example.proyectofinalback.interfaces;

import com.example.proyectofinalback.entities.Task;
import com.example.proyectofinalback.payload.request.TaskRequest;

import java.util.List;

public interface ITasksService {

    public List<TaskRequest> findAll();

    public TaskRequest findById(Long id);

    public TaskRequest save(TaskRequest task);


    public TaskRequest update(TaskRequest task);

    public TaskRequest delete(Long id);

}
