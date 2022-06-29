package com.pragma.webflux.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.pragma.webflux.model.entity.ImageMongoEntity;

public interface ImageDao extends ReactiveMongoRepository<ImageMongoEntity, String> {

}
