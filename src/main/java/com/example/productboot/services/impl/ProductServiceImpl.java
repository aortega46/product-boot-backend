package com.example.productboot.services.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.productboot.dto.ProductDTO;
import com.example.productboot.entities.Category;
import com.example.productboot.entities.Image;
import com.example.productboot.entities.Product;
import com.example.productboot.exceptions.CategoryNotFoundException;
import com.example.productboot.persistence.IProductDAO;
import com.example.productboot.services.ICategoryService;
import com.example.productboot.services.IImageService;
import com.example.productboot.services.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

  @Autowired
  private IProductDAO productDAO;

  @Autowired
  private IImageService imageService;

  @Autowired
  private ICategoryService categoryService;

  @Override
  public List<Product> findAll() {
    return productDAO.findAll();
  }

  @Override
  public Optional<Product> findById(Long id) {
    return productDAO.findById(id);
  }

  @Override
  public List<Product> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice) {
    return productDAO.findByPriceInRange(minPrice, maxPrice);
  }

  @Override
  public Product save(Product product) {
    return productDAO.save(product);
  }

  @Override
  public void deleteById(Long id) {
    Optional<Product> productOptional = productDAO.findById(id);

    if (productOptional.isPresent()) {
      Product product = productOptional.get();

      product.getCategories().forEach(category -> {
        category.getProducts().remove(product);
        categoryService.save(category);
      });

      product.getImages().forEach(image -> imageService.deleteById(image.getId()));

      productDAO.deleteById(id);
    } else {
      throw new RuntimeException(id.toString());
    }
  }

  @Override
  public List<Product> findProductsByName(String productName) {
    if (productName == null || productName.isBlank()) {
      return productDAO.findAll();
    } else {
      return productDAO.findProductsByName(productName);
    }
  }

  @Override
  public ProductDTO fromProduct(Product product) {
    ProductDTO productDTO = new ProductDTO();
    productDTO.setId(product.getId());
    productDTO.setName(product.getName());
    productDTO.setPrice(product.getPrice());
    productDTO.setDescription(product.getDescription());
    productDTO.setThumbnail(product.getThumbnail());
    productDTO.setImages(product.getImages().stream().map(Image::getUrl).toList());
    productDTO.setCategories(product.getCategories().stream().map(Category::getName).toList());

    return productDTO;
  }

  @Transactional
  public Product fromDTO(ProductDTO productDTO) {
    Product product = new Product();
    product.setId(productDTO.getId());
    product.setName(productDTO.getName());
    product.setPrice(productDTO.getPrice());
    product.setDescription(productDTO.getDescription());
    product.setThumbnail(productDTO.getThumbnail());

    Product savedProduct = save(product);

    savedProduct = handleCategoriesAndImages(savedProduct, productDTO);

    return savedProduct;
  }

  @Override
  @Transactional
  public Product updateFromDTO(Product product, ProductDTO productDTO) {
    product.setName(productDTO.getName());
    product.setPrice(productDTO.getPrice());
    product.setDescription(productDTO.getDescription());
    product.setThumbnail(productDTO.getThumbnail());

    product = handleCategoriesAndImages(product, productDTO);

    return save(product);
  }

  private Product handleCategoriesAndImages(Product product, ProductDTO productDTO) {
    // Categories
    List<Category> categories = new ArrayList<>();
    List<Category> allCategories = categoryService.findAll();

    for (String categoryName : productDTO.getCategories()) {
      Optional<Category> categoryOptional = allCategories.stream()
          .filter(category -> category.getName().equals(categoryName)).findFirst();

      if (categoryOptional.isEmpty()) {
        throw new CategoryNotFoundException(categoryName);
      }

      Category category = categoryOptional.get();
      category.getProducts().add(product);
      categories.add(category);
    }

    categoryService.saveAll(categories);

    // Images
    List<Image> allImages = imageService.findAll();
    List<Image> toDelete = allImages.stream().filter(image -> image.getProduct().equals(product)).toList();
    for (Image image : toDelete) {
      imageService.deleteById(image.getId());
    }

    List<Image> images = new ArrayList<>();
    for (String imageUrl : productDTO.getImages()) {
      Image image = new Image();
      image.setUrl(imageUrl);
      image.setProduct(product);

      images.add(image);
    }

    imageService.saveAll(images);

    product.setCategories(categories);
    product.setImages(images);

    return product;
  }

}
