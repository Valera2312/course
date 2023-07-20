package com.example.clientservice.controllers;

import com.example.clientservice.entities.Book;
import com.example.clientservice.services.ServiceBFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/client")
public class ClientBookController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientBookController.class);
    @Autowired
    ServiceBFeignClient client;

    @GetMapping("/books")
    List<Book> getAllBooksFromClient() {
        client.getAllBooks("books").forEach(book -> LOGGER.debug(book.getTitle()));
       return client.getAllBooks("books");
    }
    @GetMapping("/headers")
    Map<String, String> getAllHeadersFromClient() {
        return client.getHeaders("headers");
    }
}
