package com.Rocket.LibraryManagement.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Rocket.LibraryManagement.Entity.Lending;

public interface LendingRepo extends MongoRepository<Lending,Long> {
    Optional<Lending> findByUserIdAndBookId(long userId, long bookId);
    List<Lending> findByUserId(long userId);
    List<Lending> findByBookId(long bookId);
    
}
