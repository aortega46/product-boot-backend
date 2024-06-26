package com.example.productboot.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.productboot.entities.Category;
import com.example.productboot.persistence.ICategoryDAO;
import com.example.productboot.services.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService {

  @Autowired
  private ICategoryDAO categoryDAO;

  @Override
  public List<Category> findAll() {
    return categoryDAO.findAll();
  }

  @Override
  public Optional<Category> findById(Long id) {
    return categoryDAO.findById(id);
  }

  @Override
  public Category save(Category category) {
    return categoryDAO.save(category);
  }

  @Override
  public void deleteById(Long id) {
    categoryDAO.deleteById(id);
  }

  @Override
  public Optional<Category> findByName(String categoryName) {
    return categoryDAO.findByName(categoryName);
  }

  @Override
  @Transactional
  public List<Category> saveAll(List<Category> categories) {
    List<Category> savedCategories = new ArrayList<>();
    for (Category category : categories) {
      savedCategories.add(save(category));
    }

    return savedCategories;
  }
}
