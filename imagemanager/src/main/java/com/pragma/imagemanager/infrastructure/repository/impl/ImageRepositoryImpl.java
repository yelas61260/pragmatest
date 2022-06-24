package com.pragma.imagemanager.infrastructure.repository.impl;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.pragma.imagemanager.domain.entity.ImageEntity;
import com.pragma.imagemanager.domain.repository.ImageRepository;
import com.pragma.imagemanager.infrastructure.dao.ImageDao;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class ImageRepositoryImpl implements ImageRepository {
	
	private final ImageDao imageDao;

	@Override
	public ImageEntity getById(String imageId) {
		Optional<ImageEntity> imageEntity = imageDao.findById(imageId);
		if (imageEntity.isEmpty()) {
			return null;
		} else {
			return imageEntity.get();
		}
	}

	@Override
	public ImageEntity create(ImageEntity imageEntity) {
		return imageDao.insert(imageEntity);
	}

	@Override
	public ImageEntity update(ImageEntity imageEntity) {
		return imageDao.save(imageEntity);
	}

}
