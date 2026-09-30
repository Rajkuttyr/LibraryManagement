package com.Rocket.LibraryManagement.Service;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Rocket.LibraryManagement.Entity.Book;
import com.Rocket.LibraryManagement.Entity.Lending;
import com.Rocket.LibraryManagement.Entity.User;
import com.Rocket.LibraryManagement.Entity.UserLending;
import com.Rocket.LibraryManagement.Repository.BookRepo;
import com.Rocket.LibraryManagement.Repository.LendingRepo;
import com.Rocket.LibraryManagement.Repository.UserRepo;

@Service
public class LendingService {

    private final LendingRepo lendingRepo;
    private final UserRepo userRepository;
    private final BookRepo bookRepository;

    public LendingService(
            LendingRepo lendingRepo,
            UserRepo userRepository,
            BookRepo bookRepository) {

        this.lendingRepo = lendingRepo;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    public List<UserLending> findByUserId(long userId) {

        List<Lending> lendings = lendingRepo.findByUserId(userId);

        return lendings.stream()
                .map(this::buildUserLending)
                .toList();
    }

    public List<UserLending> findByBookId(long bookId) {

        List<Lending> lendings = lendingRepo.findByBookId(bookId);

        return lendings.stream()
                .map(this::buildUserLending)
                .toList();
    }

    private UserLending buildUserLending(Lending lending) {

        User user = userRepository.findById(lending.getUserID())
                .orElseThrow();

        Book book = bookRepository.findById(lending.getBookId())
                .orElseThrow();

        return new UserLending.Builder()
                .userId(user.getUserID())
                .userName(user.getName())
                .bookId(book.getBookId())
                .bookName(book.getBookName())
                .issueDate(lending.getIssuedDate())
                .returnDate(lending.getReturnDate())
                .returnedOn(lending.getReturnedOn())
                .returned(lending.isReturned())
                .build();
    }
public Lending addLending(UserLending userLending) {

    Lending lending = new Lending();

    lending.setUserId(userLending.getUserId());
    lending.setBookId(userLending.getBookId());
    lending.setIssuedDate(userLending.getIssueDate());
    lending.setReturnDate(userLending.getReturnDate());
    lending.setReturned(userLending.isReturned());
    lending.setReturnedOn(userLending.getReturnedOn());

    return lendingRepo.save(lending);
}
}