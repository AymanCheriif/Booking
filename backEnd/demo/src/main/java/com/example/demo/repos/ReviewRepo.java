package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Review;

public interface ReviewRepo extends JpaRepository<Review, Long> {
    
}
