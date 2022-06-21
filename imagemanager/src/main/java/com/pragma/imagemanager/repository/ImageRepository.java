package com.pragma.imagemanager.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pragma.imagemanager.model.entity.ImageEntity;

public interface ImageRepository extends MongoRepository<ImageEntity, String> {

}
