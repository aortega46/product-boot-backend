package com.example.productboot.persistence.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.productboot.entities.Product;
import com.example.productboot.persistence.IProductDAO;
import com.example.productboot.repositories.IProductRespository;

@Component
public class ProductDAOImpl implements IProductDAO {

  @Autowired
  private IProductRespository productRespository;

  @Override
  public List<Product> findAll() {
    return productRespository.findAll();
  }

  @Override
  public Optional<Product> findById(Long id) {
    return productRespository.findById(id);
  }

  @Override
  public List<Product> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice) {
    return productRespository.findByPriceBetween(minPrice, maxPrice);
  }

  @Override
  public Product save(Product product) {
    return productRespository.save(product);
  }

  @Override
  public void deleteById(Long id) {
    productRespository.deleteById(id);
  }

}
