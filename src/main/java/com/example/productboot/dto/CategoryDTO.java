package com.example.productboot.dto;

import java.util.List;

import com.example.productboot.entities.Product;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {

  private Long id;

  @NotBlank
  private String name;
  private List<Product> products;

}
