package com.Rocket.LibraryManagement.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Rocket.LibraryManagement.Entity.User;

public interface UserRepo extends MongoRepository<User, Long> {
    
}
