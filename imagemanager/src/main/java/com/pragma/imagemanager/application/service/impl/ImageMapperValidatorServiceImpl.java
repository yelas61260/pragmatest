package com.pragma.imagemanager.application.service.impl;

import com.pragma.imagemanager.application.constant.ImageManagerGlobalConstant;
import com.pragma.imagemanager.application.dto.ImageDTO;
import com.pragma.imagemanager.application.exception.conflict.ImageManagerResourceIdInvalidException;
import com.pragma.imagemanager.application.service.ImageMapperValidatorService;
import com.pragma.imagemanager.application.service.ResourceValidatorService;
import com.pragma.imagemanager.domain.entity.ImageEntity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ImageMapperValidatorServiceImpl implements ImageMapperValidatorService {
	
	private final ResourceValidatorService resourceValidatorService;

	@Override
	public void toDto(ImageEntity imageEntity) {
		if (!imageEntity.getId().matches(ImageManagerGlobalConstant.VALIDATE_IMAGE_ID_REGEX)) {
			throw new ImageManagerResourceIdInvalidException();
		}
		String[] identifierSplit = imageEntity.getId().split(ImageManagerGlobalConstant.IMAGE_ID_SPLIT_CHART);
		resourceValidatorService.validateResourceTypeByPrefix(identifierSplit[ImageManagerGlobalConstant.IMAGE_ID_TYPE_INDEX]);
	}

	@Override
	public void toEntity(ImageDTO imageDTO) {
		resourceValidatorService.validateResourceTypeById(imageDTO.getAssociationType());
	}

}
