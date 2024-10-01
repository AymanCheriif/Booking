package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dtos.CategoryDto;
import com.example.demo.services.CategoryService;

import org.springframework.web.bind.annotation.RequestBody;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("category")
@RequiredArgsConstructor
public class CategoryController {
    
    private final CategoryService service;

    @GetMapping("get/all")
    public List<CategoryDto> getAllCategories() {
        return service.findAllCategories();
    }
    
    @PostMapping("save")
    public ResponseEntity<?> saveCategory(@RequestBody CategoryDto categoryDto) {
        return service.saveCategory(categoryDto);
    }

    @PutMapping("update")
    public ResponseEntity<?> updateCategory(@RequestBody CategoryDto categoryDto) {
        return service.updateCategory(categoryDto);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        return service.deleteCategory(id);
    }
    
}
