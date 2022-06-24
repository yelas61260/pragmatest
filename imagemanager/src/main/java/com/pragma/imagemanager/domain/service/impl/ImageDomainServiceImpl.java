package com.pragma.imagemanager.domain.service.impl;

import com.pragma.imagemanager.domain.entity.ImageEntity;
import com.pragma.imagemanager.domain.repository.ImageRepository;
import com.pragma.imagemanager.domain.service.ImageDomainService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ImageDomainServiceImpl implements ImageDomainService {
	
	private final ImageRepository imageRepository;
	
	@Override
	public ImageEntity getById(String imageId) {
		return imageRepository.getById(imageId);
	}

	@Override
	public ImageEntity create(ImageEntity imageEntity) {
		return imageRepository.create(imageEntity);
	}

	@Override
	public ImageEntity update(ImageEntity imageEntity) {
		return imageRepository.update(imageEntity);
	}

}
