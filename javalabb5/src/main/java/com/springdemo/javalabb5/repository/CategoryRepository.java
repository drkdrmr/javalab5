package com.springdemo.javalabb5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository<Category> extends JpaRepository<Category, Long> {
}