package com.example.demo.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.example.demo.Dtos.BookDto;
import com.example.demo.Dtos.CartDto;
import com.example.demo.Dtos.CategoryDto;
import com.example.demo.Dtos.OrderDto;
import com.example.demo.Dtos.Order_itemDto;
import com.example.demo.Dtos.ReviewDto;
import com.example.demo.models.Book;
import com.example.demo.models.Cart;
import com.example.demo.models.Category;
import com.example.demo.models.Order;
import com.example.demo.models.Order_item;
import com.example.demo.models.Review;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MapperStruct {
    private final ModelMapper modelMapper;

    public BookDto toDtoBook(Book book){
        return modelMapper.map(book, BookDto.class);
    }

    public Book toEntityBook(BookDto dto){
        return modelMapper.map(dto, Book.class);
    }

    public CategoryDto toDtoCategory(Category category){
        return modelMapper.map(category, CategoryDto.class);
    }

    public Category toEntityCategory(CategoryDto dto){
        return modelMapper.map(dto, Category.class);
    }

    public ReviewDto toDtoReview(Review review){
        return modelMapper.map(review, ReviewDto.class);
    }

    public Review toEntityReview(ReviewDto dto){
        return modelMapper.map(dto, Review.class);
    }

    public OrderDto toDtoOrder(Order order){
        return modelMapper.map(order, OrderDto.class);
    }

    public Order toEntityOrder(OrderDto dto){
        return modelMapper.map(dto, Order.class);
    }

    public Order_itemDto toDtoOrder_item(Order_item order_item){
        return modelMapper.map(order_item, Order_itemDto.class);
    }

    public Order_item toEntityOrder_item(Order_itemDto tdo){
        return modelMapper.map(tdo, Order_item.class);
    }

    public CartDto toDtoCart(Cart Cart){
        return modelMapper.map(Cart, CartDto.class);
    }

    public Cart toEntityCart(CartDto dto){
        return modelMapper.map(dto, Cart.class);
    }
}
