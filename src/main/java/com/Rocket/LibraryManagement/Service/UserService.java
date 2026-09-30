package com.Rocket.LibraryManagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Rocket.LibraryManagement.Entity.User;
import com.Rocket.LibraryManagement.Repository.UserRepo;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    public User addUser(User user) {
        return userRepo.save(user);
    }
    public Optional<User> getUser(long userId) {
        return userRepo.findById(userId);
    }
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
    public void deleteUser(long userId) {
        userRepo.deleteById(userId);
    }
        public User updateUser(long userId, User updatedUser) {

        User existingUser = userRepo.findById(userId)

                .orElseThrow(() ->

                        new RuntimeException("User not found"));

        existingUser.setName(updatedUser.getName());

        existingUser.setAddress(updatedUser.getAddress());

        existingUser.setPhoneNumber(updatedUser.getPhoneNumber());

        existingUser.setDob(updatedUser.getDob());

        return userRepo.save(existingUser);

    }
}