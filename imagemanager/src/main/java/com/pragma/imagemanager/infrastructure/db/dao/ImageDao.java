package com.pragma.imagemanager.infrastructure.db.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pragma.imagemanager.infrastructure.db.entity.ImageMongoEntity;

public interface ImageDao extends MongoRepository<ImageMongoEntity, String> {

}
