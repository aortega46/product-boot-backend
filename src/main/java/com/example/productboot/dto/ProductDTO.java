package com.example.productboot.dto;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.validator.constraints.URL;

import com.example.productboot.entities.Category;
import com.example.productboot.entities.Image;

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

  @NotBlank(message = "must be not empty")
  private String name;

  @NotNull(message = "price is required")
  @DecimalMin("0.01")
  private BigDecimal price;

  @NotNull(message = "description is required")
  private String  description;
  
  @URL(message = "must be an url")
  private String thumnail;
  private List<Image> images;
  
  private List<Category> categories;

}
