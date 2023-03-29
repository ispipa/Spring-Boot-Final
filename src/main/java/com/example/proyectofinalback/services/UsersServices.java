package com.example.proyectofinalback.services;

import com.example.proyectofinalback.entities.User;
import com.example.proyectofinalback.interfaces.IUsersService;
import com.example.proyectofinalback.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServices implements IUsersService {

    @Autowired
    private UsersRepository usersRepository;


    @Override
    public List<User> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return usersRepository.findById(id).orElse(null);
    }

    @Override
    public User login(User user){
        /*User userDB = usersRepository.findByEmailAndPassword( user.getEmail(), user.getPassword() );
        if(userDB == null){
            System.out.println("No existe el usuario");
        }
        System.out.println(userDB);
        return userDB;*/
        return null;
    }

    @Override
    public User register(User user) {
        /*User userDB = usersRepository.findByEmail(user.getEmail());
        if(userDB == null){
            System.out.println(userDB);
            return usersRepository.save(user);
        }
        return userDB;*/
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public User delete(Long id) {
        return null;
    }

}
