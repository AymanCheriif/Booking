package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Cart;

public interface CartRepo extends JpaRepository<Cart, Long> {
    
}
