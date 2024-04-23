package com.example.productboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.productboot.entities.Image;

public interface IImageRespository extends JpaRepository<Image, String> {
}
