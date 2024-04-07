package com.example.productboot.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.productboot.dto.CategoryDTO;
import com.example.productboot.entities.Category;
import com.example.productboot.services.ICategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

  @Autowired
  private ICategoryService categoryService;

  @GetMapping("/{id}")
  public ResponseEntity<?> findById(@PathVariable Long id) {
    Optional<Category> categoryOptional = categoryService.findById(id);

    if (categoryOptional.isEmpty())
      return ResponseEntity.notFound().build();

    Category category = categoryOptional.get();
    CategoryDTO categoryDTO = new CategoryDTO(category.getId(), category.getName(), category.getProducts());

    return ResponseEntity.ok(categoryDTO);
  }

  @GetMapping
  public ResponseEntity<?> findAll() {
    List<CategoryDTO> categoriesDTO = categoryService.findAll()
        .stream()
        .map(cat -> new CategoryDTO(cat.getId(), cat.getName(), cat.getProducts()))
        .toList();

    return ResponseEntity.ok(categoriesDTO);
  }

  @PostMapping
  public ResponseEntity<?> save(@Validated @RequestBody CategoryDTO categoryDTO) throws URISyntaxException {

    Category category = new Category();
    category.setName(categoryDTO.getName());
    category.setProducts(categoryDTO.getProducts());

    Category newCategory = categoryService.save(category);

    URI location = new URI("/api/categories/" + newCategory.getId());

    return ResponseEntity.created(location).body(newCategory);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(@PathVariable Long id, @Validated @RequestBody CategoryDTO categoryDTO) {
    Optional<Category> categoryOptional = categoryService.findById(id);

    if (categoryOptional.isEmpty())
      return ResponseEntity.notFound().build();

    Category category = categoryOptional.get();
    category.setName(categoryDTO.getName());
    category.setProducts(categoryDTO.getProducts());

    Category newCategory = categoryService.save(category);

    return ResponseEntity.ok(newCategory);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Long id) {
    Optional<Category> categoryOptional = categoryService.findById(id);

    if (categoryOptional.isEmpty())
      return ResponseEntity.notFound().build();

    categoryService.deleteById(id);

    return ResponseEntity.ok("Category removed");
  }

}
