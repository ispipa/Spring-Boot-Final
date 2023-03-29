package com.example.proyectofinalback.interfaces;

import com.example.proyectofinalback.entities.User;

import java.util.List;

public interface IUsersService {

    public List<User> findAll();

    public User findById(Long id);

    public User login(User user);

    public User register(User user);

    public User update(User user);

    public User delete(Long id);

}
