package com.example.productboot.exceptions;

public class CategoryNotFoundException extends RuntimeException {
  public CategoryNotFoundException(String categoryName) {
    super("Category not found: " + categoryName);
  }
}
