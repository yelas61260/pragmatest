package com.pragma.imagemanager.domain.repository;

import com.pragma.imagemanager.domain.entity.ImageEntity;

public interface ImageRepository {
	
	public ImageEntity getById(String imageId);
	public ImageEntity create(ImageEntity imageEntity);
	public ImageEntity update(ImageEntity imageEntity);

}
