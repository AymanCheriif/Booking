package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Order_item;

public interface Order_itemRepo extends JpaRepository<Order_item, Long>{
     
}
