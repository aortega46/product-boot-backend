package com.example.productboot.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.productboot.entities.Product;

public interface IProductRespository extends JpaRepository<Product, Long> {

  public List<Product> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);

}
