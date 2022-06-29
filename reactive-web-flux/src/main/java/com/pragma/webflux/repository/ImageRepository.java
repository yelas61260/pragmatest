package com.pragma.webflux.repository;

import com.pragma.webflux.model.entity.ImageMongoEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ImageRepository {
	
	public Mono<ImageMongoEntity> getById(ImageMongoEntity imageDTO);
	public Mono<ImageMongoEntity> create(ImageMongoEntity imageDTO);
	public Mono<ImageMongoEntity> update(ImageMongoEntity imageDTO);
	public Flux<ImageMongoEntity> getAll();

}
