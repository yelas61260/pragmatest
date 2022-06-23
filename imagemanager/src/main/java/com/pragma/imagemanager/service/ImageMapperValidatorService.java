package com.pragma.imagemanager.service;

import com.pragma.imagemanager.model.dto.ImageDTO;
import com.pragma.imagemanager.model.entity.ImageEntity;

public interface ImageMapperValidatorService {
	
	public void toDto(ImageEntity imageEntity);
	public void toEntity(ImageDTO imageDTO);

}
