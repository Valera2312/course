package com.example.bookservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "book")
@Getter
@Setter
@AllArgsConstructor
public class Book {
    @Id
    ObjectId id;

    String title;

}
