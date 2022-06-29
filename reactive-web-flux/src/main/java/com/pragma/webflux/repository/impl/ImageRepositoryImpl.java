package com.pragma.webflux.repository.impl;

import org.springframework.stereotype.Repository;

import com.pragma.webflux.dao.ImageDao;
import com.pragma.webflux.model.entity.ImageMongoEntity;
import com.pragma.webflux.repository.ImageRepository;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@AllArgsConstructor
public class ImageRepositoryImpl implements ImageRepository {
	
	private final ImageDao imageDao;

	@Override
	public Mono<ImageMongoEntity> getById(ImageMongoEntity imageMongoEntity) {
		return imageDao.findById(imageMongoEntity.getId());
	}

	@Override
	public Mono<ImageMongoEntity> create(ImageMongoEntity imageMongoEntity) {
		return imageDao.insert(imageMongoEntity);
	}

	@Override
	public Mono<ImageMongoEntity> update(ImageMongoEntity imageMongoEntity) {
		return imageDao.save(imageMongoEntity);
	}

	@Override
	public Flux<ImageMongoEntity> getAll() {
		return imageDao.findAll();
	}

}
