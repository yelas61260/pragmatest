package com.pragma.imagemanager.infrastructure.db.repository.impl;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.pragma.imagemanager.application.dto.entity.ImageDTO;
import com.pragma.imagemanager.infrastructure.db.dao.ImageDao;
import com.pragma.imagemanager.infrastructure.db.entity.ImageMongoEntity;
import com.pragma.imagemanager.infrastructure.db.mapper.ImageMongoEntityWithDtoMapper;
import com.pragma.imagemanager.infrastructure.db.repository.ImageRepository;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class ImageRepositoryImpl implements ImageRepository {
	
	private final ImageDao imageDao;
	private final ImageMongoEntityWithDtoMapper imageMongoEntityWithDtoMapper;

	@Override
	public ImageDTO getById(ImageDTO imageDTO) {
		ImageMongoEntity imageMongoEntity = imageMongoEntityWithDtoMapper.toMongoEntity(imageDTO);
		Optional<ImageMongoEntity> imageEntity = imageDao.findById(imageMongoEntity.getId());
		if (imageEntity.isEmpty()) {
			return null;
		} else {
			return imageMongoEntityWithDtoMapper.toDto(imageEntity.get());
		}
	}

	@Override
	public ImageDTO create(ImageDTO imageDTO) {
		ImageMongoEntity imageMongoEntity = imageMongoEntityWithDtoMapper.toMongoEntity(imageDTO);
		return imageMongoEntityWithDtoMapper.toDto(imageDao.insert(imageMongoEntity));
	}

	@Override
	public ImageDTO update(ImageDTO imageDTO) {
		ImageMongoEntity imageMongoEntity = imageMongoEntityWithDtoMapper.toMongoEntity(imageDTO);
		return imageMongoEntityWithDtoMapper.toDto(imageDao.save(imageMongoEntity));
	}

}
