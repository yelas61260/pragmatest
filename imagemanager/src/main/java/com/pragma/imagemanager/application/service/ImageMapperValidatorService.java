package com.pragma.imagemanager.application.service;

import com.pragma.imagemanager.application.dto.ImageDTO;
import com.pragma.imagemanager.domain.entity.ImageEntity;

public interface ImageMapperValidatorService {
	
	public void toDto(ImageEntity imageEntity);
	public void toEntity(ImageDTO imageDTO);

}
