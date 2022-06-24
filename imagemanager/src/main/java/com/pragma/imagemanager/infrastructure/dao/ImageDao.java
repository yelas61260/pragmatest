package com.pragma.imagemanager.infrastructure.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pragma.imagemanager.domain.entity.ImageEntity;

public interface ImageDao extends MongoRepository<ImageEntity, String> {

}
