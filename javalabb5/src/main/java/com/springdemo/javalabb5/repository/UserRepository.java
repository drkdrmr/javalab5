package com.springdemo.javalabb5.repository;
import com.springdemo.javalabb5.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository<User> extends JpaRepository<User, Long> {
    User findByUsername(String username);
}