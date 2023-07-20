package com.example.bookservice.repositories;

import com.example.bookservice.entity.Book;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Bookrepository extends MongoRepository<Book, ObjectId> {
    @Override
    List<Book> findAll();
}
