package com.Rocket.LibraryManagement.Contoller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Rocket.LibraryManagement.Entity.User;
import com.Rocket.LibraryManagement.Service.UserService;

@RestController
@RequestMapping("/user")
public class UserContoller {

    private final UserService userService;

    public UserContoller(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {

        User savedUser = userService.addUser(user);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedUser);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable long userId) {

        return userService.getUser(userId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {

        List<User> users = userService.getAllUsers();

        return ResponseEntity.ok(users);
    }
    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(
            @PathVariable long userId,
            @RequestBody User user) {

        User updatedUser = userService.updateUser(userId, user);

        return ResponseEntity.ok(updatedUser);
    }
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable long userId) {

        userService.deleteUser(userId);

        return ResponseEntity.noContent().build();
    }
}