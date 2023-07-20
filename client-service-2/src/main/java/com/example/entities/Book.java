package com.example.entities;


import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;




@Getter
@Setter
public class Book {

    public Book(ObjectId id, String title) {
        this.id = id;
        this.title = title;
    }

    ObjectId id;

    String title;

}
