package com.example.productboot.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productboot.entities.Image;
import com.example.productboot.persistence.IImageDAO;
import com.example.productboot.services.IImageService;

@Service
public class ImageServiceImpl implements IImageService {

  @Autowired
  private IImageDAO imageDAO;

  @Override
  public List<Image> findAll() {
    return imageDAO.findAll();
  }

  @Override
  public Optional<Image> findById(String id) {
    return imageDAO.findById(id);
  }

  @Override
  public Image save(Image image) {
    return imageDAO.save(image);
  }

  @Override
  public void deleteById(String id) {
    imageDAO.deleteById(id);
  }

}
