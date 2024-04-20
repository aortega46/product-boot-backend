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
    ProductDTO productDTO = new ProductDTO(product.getId(), product.getName(), product.getPrice(),
        product.getDescription(), product.getThumbnail(), product.getImages(), product.getCategories());

    return ResponseEntity.ok(productDTO);
  }

  @GetMapping
  public ResponseEntity<?> findAll() {
    List<ProductDTO> productsDTO = productService.findAll()
        .stream()
        .map(product -> new ProductDTO(product.getId(),
            product.getName(),
            product.getPrice(),
            product.getDescription(),
            product.getThumbnail(),
            product.getImages(),
            product.getCategories()))
        .toList();

    return ResponseEntity.ok(productsDTO);
  }

  @PostMapping
  public ResponseEntity<?> save(@Validated @RequestBody ProductDTO productDTO) throws URISyntaxException {
    if (productDTO.getName().isBlank())
      return ResponseEntity.badRequest().build();

    Product product = new Product();
    product.setName(productDTO.getName());
    product.setPrice(productDTO.getPrice());
    product.setDescription(productDTO.getDescription());
    product.setThumbnail(productDTO.getThumbnail());
    product.setImages(productDTO.getImages());
    product.setCategories(productDTO.getCategories());

    Product newProduct = productService.save(product);

    URI location = new URI("/api/products/" + newProduct.getId());

    return ResponseEntity.created(location).body(newProduct);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updateProduct(@PathVariable Long id, @Validated @RequestBody ProductDTO productDTO) {
    Optional<Product> productOptional = productService.findById(id);

    if (productOptional.isEmpty())
      return ResponseEntity.notFound().build();

    Product product = productOptional.get();
    product.setName(productDTO.getName());
    product.setPrice(productDTO.getPrice());
    product.setDescription(productDTO.getDescription());
    product.setThumbnail(productDTO.getThumbnail());
    product.setImages(productDTO.getImages());
    product.setCategories(productDTO.getCategories());

    Product newProduct = productService.save(product);

    return ResponseEntity.ok(newProduct);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Long id) {
    if (id == null)
      return ResponseEntity.badRequest().build();

    Optional<Product> productOptional = productService.findById(id);

    if (productOptional.isEmpty())
      return ResponseEntity.notFound().build();

    productService.deleteById(id);

    return ResponseEntity.ok("Product removed");
  }

  @GetMapping("/search")
  public ResponseEntity<?> findProductsByName(
      @RequestParam(name = "name", required = false) @Size(min = 3) String name) {
    List<Product> products = productService.findProductsByName(name);

    return ResponseEntity.ok(products);
  }

}
