package com.example.productboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.productboot.entities.Category;

public interface ICategoryRespository extends JpaRepository<Category, Long> {

  Category findByName(String categoryName);

}
