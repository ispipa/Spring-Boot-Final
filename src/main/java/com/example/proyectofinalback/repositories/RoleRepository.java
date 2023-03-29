package com.example.proyectofinalback.repositories;

import com.example.proyectofinalback.entities.Role;
import com.example.proyectofinalback.utils.ERole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);

}
