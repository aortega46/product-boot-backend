package com.example.productboot.persistence.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.productboot.entities.Image;
import com.example.productboot.persistence.IImageDAO;
import com.example.productboot.repositories.IImageRespository;

@Component
public class ImageDAOImpl implements IImageDAO {

  @Autowired
  private IImageRespository imageRespository;

  @Override
  public List<Image> findAll() {
    return imageRespository.findAll();
  }

  @Override
  public Optional<Image> findById(String id) {
    return imageRespository.findById(id);
  }

  @Override
  public Image save(Image image) {
    return imageRespository.save(image);
  }

  @Override
  public void deleteById(String id) {
    imageRespository.deleteById(id);
  }

}
