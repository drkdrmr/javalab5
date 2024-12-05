package com.springdemo.javalabb5.service;



import com.springdemo.javalabb5.exception.UserNotFoundException;
import com.springdemo.javalabb5.model.User;
import com.springdemo.javalabb5.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Get a user by ID, returns Optional
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Register a user
    public void registerUser(User user) {
        // You could add checks (e.g., if the email already exists)
        userRepository.save(user);
    }

    // Update a user
    public Optional<User> updateUser(Long id, User userDetails) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            User user = existingUser.get();
            user.setUsername(userDetails.getUsername());
            user.setEmail(userDetails.getEmail());
            user.setPassword(userDetails.getPassword());
            userRepository.save(user);  // Save updated user
            return Optional.of(user);
        } else {
            return Optional.empty();  // User not found
        }
    }

    // Delete a user by ID
    public boolean deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
            return true;
        } else {
            return false;  // User not found
        }
    }

    public Object getAllUsers() {
        return null;
    }

    public boolean loginUser(User user) {
        return false;
    }
}
