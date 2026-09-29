package com.Rocket.LibraryManagement.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Rocket.LibraryManagement.Entity.Lending;

public interface LendingRepo extends MongoRepository<Lending,Long> {
    
}
