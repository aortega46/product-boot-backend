package com.example.productboot.dto;

import java.math.BigDecimal;
import java.util.List;

import com.example.productboot.entities.Category;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class ProductDTO {

  private Long id;

  @NotBlank
  private String name;

  @NotNull
  @DecimalMin("0.01")
  private BigDecimal price;
  
  private List<Category> categories;

}
