package com.example.demo.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Dtos.CategoryDto;
import com.example.demo.mappers.MapperStruct;
import com.example.demo.models.Category;
import com.example.demo.repos.CategoryRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {
    
    private final CategoryRepo categoryRepo;
    private final MapperStruct mapper;


    public List<CategoryDto> findAllCategories(){
        List<CategoryDto> categories = categoryRepo.findAll().stream().map(mapper::toDtoCategory).toList();
        return categories;
    }

    public ResponseEntity<?> saveCategory(CategoryDto category){
        Category categoryEntity = mapper.toEntityCategory(category);
        categoryRepo.save(categoryEntity);
        return ResponseEntity.ok("Your category haas been succelly saved !");
    }

    public ResponseEntity<?> updateCategory(CategoryDto category){
        Category categoryEntity = mapper.toEntityCategory(category);
        categoryRepo.save(categoryEntity);
        return ResponseEntity.ok("Your category haas been succelly updated !");
    }

    public ResponseEntity<?> deleteCategory(Long id){
        categoryRepo.deleteById(id);
        return ResponseEntity.ok("Your category haas been succelly deleted !");
    }
}
