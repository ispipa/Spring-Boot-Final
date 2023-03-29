package com.example.proyectofinalback.controllers;

import com.example.proyectofinalback.entities.Task;
import com.example.proyectofinalback.entities.User;
import com.example.proyectofinalback.payload.request.TaskRequest;
import com.example.proyectofinalback.payload.response.MessageResponse;
import com.example.proyectofinalback.services.TasksServices;
import com.example.proyectofinalback.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/tasks")
public class TasksController{

    @Autowired
    private TasksServices service;

    @GetMapping("/getAllTasks")
    @PreAuthorize(value = "hasRole('ROLE_USER')")
    public ResponseEntity<?> findAll(@AuthenticationPrincipal UserDetailsImpl user) {
        List<TaskRequest> task = service.findAll()
                .stream()
                .filter(t -> t.getId_User().equals(user.getId()))
                .collect(Collectors.toList());
         //return ResponseEntity.ok(service.findAll());
         return ResponseEntity.ok(task);
    }

    @GetMapping("/getTaskById/{id}")
    @PreAuthorize(value = "hasRole('ROLE_USER')")
    public ResponseEntity<?> findById(@AuthenticationPrincipal UserDetailsImpl user, @PathVariable("id") Long id){
        TaskRequest task = service.findById(id);
        if(task==null){
            return ResponseEntity.status(404).body(new MessageResponse("Task not found"));
        }
        if(!task.getId_User().equals(user.getId())){
            //return ResponseEntity.ok("No tiene permisos para ver esta tarea");
            return ResponseEntity.status(401).body(new MessageResponse("You do not have permission to edit this task"));
        }
        return ResponseEntity.ok(task);
    }

    @PostMapping("/addTask")
    @PreAuthorize(value = "hasRole('ROLE_USER')")
    public ResponseEntity<?> save(@AuthenticationPrincipal UserDetailsImpl user, @RequestBody TaskRequest task) {
        if( task.getId_User() != null && !task.getId_User().equals(user.getId())){
            return ResponseEntity.status(401).body(new MessageResponse("You do not have permission to create this task for another user"));
        }
        task.setId_User(user.getId());
         //return ResponseEntity.ok(service.save(task));
         return ResponseEntity.ok(service.save(task));
    }

    @PutMapping("/updateTask")
    @PreAuthorize(value = "hasRole('ROLE_USER')")
    public ResponseEntity<?> update(@AuthenticationPrincipal UserDetailsImpl user, @RequestBody TaskRequest task) {
        if(!task.getId_User().equals(user.getId())) {
            return ResponseEntity.status(401).body(new MessageResponse("You do not have permission to edit this task"));
        }

         return ResponseEntity.ok(service.update(task));
    }

    @DeleteMapping("/deleteTask/{id}")
    @PreAuthorize(value = "hasRole('ROLE_USER')")
    public ResponseEntity<?> delete(@AuthenticationPrincipal UserDetailsImpl user, @PathVariable("id") Long idTask) {
        TaskRequest task = service.findById(idTask);
        if(!task.getId_User().equals(user.getId())) {
            return ResponseEntity.status(401).body(new MessageResponse("You do not have permission to delete this task"));
        }
         return ResponseEntity.ok(service.delete(idTask));
    }

}
