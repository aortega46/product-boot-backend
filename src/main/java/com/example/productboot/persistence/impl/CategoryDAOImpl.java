package com.example.productboot.persistence.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.productboot.entities.Category;
import com.example.productboot.persistence.ICategoryDAO;
import com.example.productboot.repositories.ICategoryRespository;

@Component
public class CategoryDAOImpl implements ICategoryDAO {

  @Autowired
  private ICategoryRespository categoryRespository;

  @Override
  public List<Category> findAll() {
    return categoryRespository.findAll();
  }

  @Override
  public Optional<Category> findById(Long id) {
    return categoryRespository.findById(id);
  }

  @Override
  public void save(Category category) {
    categoryRespository.save(category);
  }

  @Override
  public void deleteById(Long id) {
    categoryRespository.deleteById(id);
  }

}
