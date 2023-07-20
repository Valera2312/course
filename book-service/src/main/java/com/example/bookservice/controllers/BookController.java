package com.example.bookservice.controllers;

import com.example.bookservice.entity.Book;
import com.example.bookservice.repositories.Bookrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    Bookrepository bookrepository;

    @Autowired
    public BookController(Bookrepository bookrepository) {
        this.bookrepository = bookrepository;
    }

    @GetMapping("/books")
    List<Book> test() {
        return bookrepository.findAll();
    }
}
