package com.example.service;


import com.example.entity.Book;
import com.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class BookService {
@Autowired
private BookRepository bookRepository;

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }
    public Book updateStock(long id,int amount){
        Book book=bookRepository.findById(id).orElse(null);
        if(!ObjectUtils.isEmpty(book)){
            book.setStock(book.getStock()-amount);
            return bookRepository.save(book);
        }
        return null;
    }
}
