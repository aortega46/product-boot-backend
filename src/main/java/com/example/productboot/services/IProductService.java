package com.example.productboot.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.example.productboot.entities.Product;

public interface IProductService {

  List<Product> findAll();

  Optional<Product> findById(Long id);

  List<Product> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice);

  Product save(Product product);

  void deleteById(Long id);

  List<Product> findProductsByName(String productName);

}
