package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import com.example.demo.models.Token;

public interface TokenRepository extends JpaRepository<Token, Long>{
    Optional<Token> findByToken(String token);
}
