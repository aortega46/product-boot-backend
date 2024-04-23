package com.example.productboot.services;

import java.util.List;
import java.util.Optional;

import com.example.productboot.entities.Image;

public interface IImageService {

  List<Image> findAll();

  Optional<Image> findById(String id);

  Image save(Image image);

  void deleteById(String id);
}
