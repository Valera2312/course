package com.example.controllers;

import com.example.entities.Book;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import java.util.List;


@RestController
@RequestMapping("/api/client")
public class ClientBookController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientBookController.class);

    @GetMapping("/books")
    List<Book> getAllBooksFromClient() {
       return List.of(new Book(new ObjectId("5f348fe1cc83f9342c3f65a7"),"MyBook"));
    }

}
