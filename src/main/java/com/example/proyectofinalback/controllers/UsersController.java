package com.example.proyectofinalback.controllers;

import com.example.proyectofinalback.entities.User;
import com.example.proyectofinalback.services.UsersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsersController {

    @Autowired
    private UsersServices service;

    @GetMapping("/getAllUsers")
    public ResponseEntity<?>findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/getUserTasks/{id}")
    public ResponseEntity<?>findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.findById(id));
    }


    @PostMapping("/login")
    public ResponseEntity<?>login(@RequestBody User user){
        return ResponseEntity.ok(service.login(user));
    }

    @PostMapping("/addUser")
    public ResponseEntity<?>save(@RequestBody User user){
        return ResponseEntity.ok(service.register(user));
    }

}
