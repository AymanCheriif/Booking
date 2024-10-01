package com.example.demo.Dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private Long id;
    private String title;
    private String author;
    private String description;
    private String image;
    private Float price;
    private Integer stock;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private UserDto seller;

    private CategoryDto category;
}
