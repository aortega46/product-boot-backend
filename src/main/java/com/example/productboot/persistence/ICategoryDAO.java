package com.example.productboot.persistence;

import java.util.List;
import java.util.Optional;

import com.example.productboot.entities.Category;

public interface ICategoryDAO {

  List<Category> findAll();

  Optional<Category> findById(Long id);

  void save(Category category);

  void deleteById(Long id);
}