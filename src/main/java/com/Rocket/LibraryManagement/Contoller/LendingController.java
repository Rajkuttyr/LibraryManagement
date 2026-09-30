package com.Rocket.LibraryManagement.Contoller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Rocket.LibraryManagement.Entity.Lending;
import com.Rocket.LibraryManagement.Entity.UserLending;
import com.Rocket.LibraryManagement.Service.LendingService;

@RestController
@RequestMapping("/lending")
public class LendingController {

    private final LendingService lendingService;

    public LendingController(LendingService lendingService) {
        this.lendingService = lendingService;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserLending>> findByUserId(
            @PathVariable long userId) {

        List<UserLending> lendings =
                lendingService.findByUserId(userId);

        return ResponseEntity.ok(lendings);
    }

    @GetMapping("/book/{bookId}")
    public ResponseEntity<List<UserLending>> findByBookId(
            @PathVariable long bookId) {

        List<UserLending> lendings =
                lendingService.findByBookId(bookId);

        return ResponseEntity.ok(lendings);
    }

    @PostMapping("/new")
    public ResponseEntity<Lending> addLending(
            @RequestBody UserLending userLending) {

        Lending lending = lendingService.addLending(userLending);

        return ResponseEntity.ok(lending);
    }
}