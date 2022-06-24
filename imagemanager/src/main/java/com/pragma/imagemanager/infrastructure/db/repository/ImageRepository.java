package com.pragma.imagemanager.infrastructure.db.repository;

import com.pragma.imagemanager.application.dto.entity.ImageDTO;

public interface ImageRepository {
	
	public ImageDTO getById(ImageDTO imageDTO);
	public ImageDTO create(ImageDTO imageDTO);
	public ImageDTO update(ImageDTO imageDTO);

}
