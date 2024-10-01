package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.example.demo.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(String role);
    
}
