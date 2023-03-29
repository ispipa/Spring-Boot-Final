package com.example.proyectofinalback.repositories;

import com.example.proyectofinalback.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface UsersRepository extends JpaRepository<User, Long> {
     Optional<User> findByUsername(String username);

     Boolean existsByUsername(String username);

     Boolean existsByEmail(String email);

     User findByEmailAndPassword(String email, String password);

     Optional<User> findByEmail(String email);

}
