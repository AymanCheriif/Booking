package com.example.demo.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.demo.models.Book;

public interface BookRepo extends JpaRepository<Book, Long> {
    
    @Query("SELECT b FROM Book b WHERE b.category.name = :category")
    Page<Book> findByCategoryName(String category, Pageable page);

    @Query("SELECT b FROM Book b WHERE (b.author = :search or b.title = :search)")
    Page<Book> findBySearch(String search, Pageable page);

}
