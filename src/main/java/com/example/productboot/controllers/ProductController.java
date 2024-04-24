package com.example.productboot.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.productboot.dto.ProductDTO;
import com.example.productboot.entities.Product;
import com.example.productboot.exceptions.CategoryNotFoundException;
import com.example.productboot.services.IProductService;

import jakarta.validation.constraints.Size;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductController {

  @Autowired
  private IProductService productService;

  @GetMapping("/{id}")
  public ResponseEntity<?> findById(@PathVariable Long id) {
    Optional<Product> productOptional = productService.findById(id);

    if (productOptional.isEmpty())
      return ResponseEntity.notFound().build();

    Product product = productOptional.get();
    ProductDTO productDTO = productService.fromProduct(product);

    return ResponseEntity.ok(productDTO);
  }

  @GetMapping
  public ResponseEntity<?> findAll() {
    List<ProductDTO> productsDTO = productService.findAll()
        .stream()
        .map(product -> productService.fromProduct(product))
        .toList();

    return ResponseEntity.ok(productsDTO);
  }

  @PostMapping
  public ResponseEntity<?> save(@Validated @RequestBody ProductDTO productDTO) throws URISyntaxException {
    try {
      Product product = productService.save(productService.fromDTO(productDTO));
      ProductDTO newProductDTO = productService.fromProduct(product);

      URI location = new URI("/api/products/" + newProductDTO.getId());

      return ResponseEntity.created(location).body(newProductDTO);

    } catch (CategoryNotFoundException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    } catch (Exception e) {
      return ResponseEntity.internalServerError().body("Something bad happened with your request");
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updateProduct(@PathVariable Long id, @Validated @RequestBody ProductDTO productDTO) {
    try {
      Optional<Product> productOptional = productService.findById(id);

      if (productOptional.isEmpty())
        return ResponseEntity.notFound().build();

      Product updatedProduct = productService.updateFromDTO(productOptional.get(), productDTO);

      return ResponseEntity.ok(productService.fromProduct(updatedProduct));
    } catch (CategoryNotFoundException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    } catch (Exception e) {
      return ResponseEntity.internalServerError().body("Something bad happened with your request");
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Long id) {
    try {
      productService.deleteById(id);

      return ResponseEntity.ok("Product removed");
    } catch (Exception e) {
      return ResponseEntity.internalServerError().body("Failed to delete product " + e.getMessage());
    }
  }

  @GetMapping("/search")
  public ResponseEntity<?> findProductsByName(
      @RequestParam(name = "name", required = false) @Size(min = 3) String name) {
    List<ProductDTO> productsDTO = productService.findProductsByName(name).stream()
        .map(product -> productService.fromProduct(product)).toList();

    return ResponseEntity.ok(productsDTO);
  }

}
