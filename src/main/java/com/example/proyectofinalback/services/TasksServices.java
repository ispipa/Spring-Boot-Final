package com.example.proyectofinalback.services;

import com.example.proyectofinalback.entities.Task;
import com.example.proyectofinalback.entities.User;
import com.example.proyectofinalback.interfaces.ITasksService;
import com.example.proyectofinalback.payload.request.TaskRequest;
import com.example.proyectofinalback.repositories.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TasksServices implements ITasksService {

    @Autowired
    private TasksRepository tasksRepository;

    @Autowired
    private UsersServices usersServices;


    private List<TaskRequest> listTaskToTaskRequest(List<Task> tasks){
        List<TaskRequest> taskRequests = new ArrayList<>();
        for (Task task: tasks) {
            TaskRequest taskRequest = new TaskRequest();
            taskRequest.setId_Task(task.getId_Task());
            taskRequest.setTitle(task.getTitle());
            taskRequest.setDescription(task.getDescription());
            taskRequest.setExpiration_date(task.getExpiration_date());
            taskRequest.setState(task.getState());
            taskRequest.setId_User(task.getUser().getId_User());
            taskRequests.add(taskRequest);
        }
        return taskRequests;
    }

    private TaskRequest taskToTaskRequest(Task task){
        TaskRequest taskRequest = new TaskRequest();
        taskRequest.setId_Task(task.getId_Task());
        taskRequest.setTitle(task.getTitle());
        taskRequest.setDescription(task.getDescription());
        taskRequest.setExpiration_date(task.getExpiration_date());
        taskRequest.setState(task.getState());
        taskRequest.setId_User(task.getUser().getId_User());
        return taskRequest;
    }


    @Override
    public List<TaskRequest> findAll() {
        List<Task> taks = tasksRepository.findAll();
        List<TaskRequest> taskRequests = listTaskToTaskRequest(taks);

       return taskRequests;
    }

    @Override
    public TaskRequest findById(Long id) {
        Task task = tasksRepository.findById(id).orElse(null);
        if(task == null){
            return null;
        }
        TaskRequest taskRequest = taskToTaskRequest(task);
        return taskRequest;
    }

    @Override
    public TaskRequest save(TaskRequest task) {
        User user =  usersServices.findById(task.getId_User());
        Task newTask = new Task();
        newTask.setTitle(task.getTitle());
        newTask.setDescription(task.getDescription());
        newTask.setState(task.getState());
        newTask.setExpiration_date(task.getExpiration_date());
        newTask.setUser(user);
        tasksRepository.save(newTask);
        task = taskToTaskRequest(newTask);
        return task;
    }


    @Override
    public TaskRequest update(TaskRequest task)
    {
        Task taskDB = tasksRepository.findById(task.getId_Task()).get();
        taskDB.setTitle(task.getTitle());
        taskDB.setDescription(task.getDescription());
        taskDB.setState(task.getState());
        taskDB.setExpiration_date(task.getExpiration_date());
        taskDB.setUser(taskDB.getUser());
        tasksRepository.save(taskDB);
        TaskRequest taskRequest = taskToTaskRequest(taskDB);
        return taskRequest;
    }

    @Override
    public TaskRequest delete(Long id) {
        Task task = tasksRepository.findById(id).get();
        TaskRequest taskRequest = taskToTaskRequest(task);
        tasksRepository.delete(task);
       return taskRequest;
    }
}
