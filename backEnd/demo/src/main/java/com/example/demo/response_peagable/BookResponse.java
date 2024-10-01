package com.example.demo.response_peagable;

import java.util.List;

import com.example.demo.Dtos.BookDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookResponse {
    
    public List<BookDto> books;
    public Integer page;
    public Integer nbPages;
    public Integer pageSize;
    public boolean last;
}
