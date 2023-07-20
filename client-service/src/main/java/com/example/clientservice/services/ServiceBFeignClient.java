package com.example.clientservice.services;

import com.example.clientservice.entities.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;


import java.util.List;
import java.util.Map;

@FeignClient("book-service")
public interface ServiceBFeignClient {
    @GetMapping("/books")
    List<Book> getAllBooks(@RequestHeader("spring-cloud-course") String headerValue);

    @GetMapping("/headers")
    Map<String, String> getHeaders(@RequestHeader("spring-cloud-course") String headerValue);

}

