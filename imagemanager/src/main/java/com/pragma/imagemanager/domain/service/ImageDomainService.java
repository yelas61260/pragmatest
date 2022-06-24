package com.pragma.imagemanager.domain.service;

import com.pragma.imagemanager.domain.entity.ImageEntity;

public interface ImageDomainService {
	
	public ImageEntity getById(String imageId);
	public ImageEntity create(ImageEntity imageEntity);
	public ImageEntity update(ImageEntity imageEntity);

}
