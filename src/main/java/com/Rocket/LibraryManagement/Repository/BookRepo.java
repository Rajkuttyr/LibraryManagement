package com.Rocket.LibraryManagement.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Rocket.LibraryManagement.Entity.Book;

public interface BookRepo extends MongoRepository<Book,Long> {
    
}
