package com.example.controller;


import com.example.entity.Book;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/save")
    public Book saveBook (@RequestBody Book book){
        return bookService.saveBook(book);
    }
    @PutMapping("/updatestock")
    public Book updateStock(@RequestParam long bookId, int amount){
        return bookService.updateStock(bookId,amount);
    }
}
