package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dtos.BookDto;
import com.example.demo.response_peagable.BookResponse;
import com.example.demo.services.BookService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("book")
@RequiredArgsConstructor
public class BookController {
    
    private final BookService service;

    @GetMapping("get/all")
    public BookResponse getAllBooks(@RequestParam int size, @RequestParam int page) {
        return service.findAllBooks(page, size);
    }

    @GetMapping("get/all/{search}")
    public BookResponse getAllBooksBySearch(@RequestParam int size, @RequestParam int page, @PathVariable String search) {
        return service.findAllBooksBySearch(page, size, search);
    }

    @GetMapping("get/all/category/{category}")
    public BookResponse getAllBooksByCategory(@RequestParam int size, @RequestParam int page, @PathVariable String category) {
        return service.findAllBooksByCategory(page, size, category);
    }

    @PostMapping("save")
    public ResponseEntity<?> saveBook(@RequestBody BookDto bookDto) {
        return service.saveBook(bookDto);
    }

    @PutMapping("save")
    public ResponseEntity<?> updateBook(@RequestBody BookDto bookDto) {
        return service.updateBook(bookDto);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        return service.deleteBook(id);
    }
    
    
    
}
