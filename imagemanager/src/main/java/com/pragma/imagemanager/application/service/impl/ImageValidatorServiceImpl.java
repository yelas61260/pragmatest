package com.pragma.imagemanager.application.service.impl;

import com.pragma.imagemanager.application.dto.entity.ImageDTO;
import com.pragma.imagemanager.application.exception.conflict.ImageManagerImageConvertException;
import com.pragma.imagemanager.application.exception.conflict.ImageManagerResourceIdInvalidException;
import com.pragma.imagemanager.application.mapper.ImageEntityWithDtoMapper;
import com.pragma.imagemanager.application.service.ImageValidatorService;
import com.pragma.imagemanager.application.service.ResourceValidatorService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ImageValidatorServiceImpl implements ImageValidatorService {
	
	private final ResourceValidatorService resourceValidatorService;
	private final ImageEntityWithDtoMapper imageEntityWithDtoMapper;

	@Override
	public void validateImage(ImageDTO imageDto) {
		if (imageDto.getResourceId() <= 0) {
			throw new ImageManagerResourceIdInvalidException();
		}
		resourceValidatorService.validateResourceTypeById(imageDto.getAssociationType());
		try {
			imageEntityWithDtoMapper.toEntity(imageDto);
		} catch (Exception e) {
			throw new ImageManagerImageConvertException();
		}
	}

}
