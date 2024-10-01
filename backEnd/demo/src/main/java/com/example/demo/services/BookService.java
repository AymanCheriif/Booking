package com.example.demo.services;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Dtos.BookDto;
import com.example.demo.mappers.MapperStruct;
import com.example.demo.models.Book;
import com.example.demo.repos.BookRepo;
import com.example.demo.response_peagable.BookResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {
    
    private final BookRepo repo;
    private final MapperStruct mapper;

    public BookResponse findAllBooks(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Book> _page = repo.findAll(pageable);

        BookResponse bookResponse = new BookResponse();

        bookResponse.setBooks(
            _page.getContent().stream().map(mapper::toDtoBook).toList()
        );
        bookResponse.setNbPages(_page.getTotalPages());
        bookResponse.setPage(_page.getNumber());
        bookResponse.setPageSize(_page.getNumberOfElements());
        bookResponse.setLast(_page.isLast());
        
        return bookResponse;
    }

    public BookResponse findAllBooksByCategory(int page, int size, String category){
        Pageable pageable = PageRequest.of(page, size);
        Page<Book> _page = repo.findByCategoryName(category, pageable);

        BookResponse bookResponse = new BookResponse();

        bookResponse.setBooks(
            _page.getContent().stream().map(mapper::toDtoBook).toList()
        );
        bookResponse.setNbPages(_page.getTotalPages());
        bookResponse.setPage(_page.getNumber());
        bookResponse.setPageSize(_page.getNumberOfElements());
        bookResponse.setLast(_page.isLast());
        
        return bookResponse;
    }

    public BookResponse findAllBooksBySearch(int page, int size, String search){
        Pageable pageable = PageRequest.of(page, size);
        Page<Book> _page = repo.findBySearch(search, pageable);

        BookResponse bookResponse = new BookResponse();

        bookResponse.setBooks(
            _page.getContent().stream().map(mapper::toDtoBook).toList()
        );
        bookResponse.setNbPages(_page.getTotalPages());
        bookResponse.setPage(_page.getNumber());
        bookResponse.setPageSize(_page.getNumberOfElements());
        bookResponse.setLast(_page.isLast());
        
        return bookResponse;
    }

    public ResponseEntity<?> saveBook(BookDto bookDto){
        bookDto.setCreatedAt(LocalDateTime.now());
        Book book = mapper.toEntityBook(bookDto);
        repo.save(book);
        return ResponseEntity.ok("Your book has been saved succefully !");
    }

    public ResponseEntity<?> updateBook(BookDto bookDto){
        bookDto.setUpdatedAt(LocalDateTime.now());
        Book book = mapper.toEntityBook(bookDto);
        repo.save(book);
        return ResponseEntity.ok("Your book has been updated succefully !");
    }

    public ResponseEntity<?> deleteBook(Long id){
        repo.deleteById(id);
        return ResponseEntity.ok("Your book has been deleted succefully !");
    }
}
