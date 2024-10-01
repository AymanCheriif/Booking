package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Order;

public interface OrderRepo extends JpaRepository<Order, Long> {
    
}
