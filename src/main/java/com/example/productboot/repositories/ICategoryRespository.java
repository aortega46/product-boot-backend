package com.example.productboot.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.productboot.entities.Category;

public interface ICategoryRespository extends JpaRepository<Category, Long> {

  Optional<Category> findByName(String categoryName);

}
