package com.Rocket.LibraryManagement.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data 
@Document("Book")
public class Book {
    @Id 
    long bookId;
    String BookName;
}
