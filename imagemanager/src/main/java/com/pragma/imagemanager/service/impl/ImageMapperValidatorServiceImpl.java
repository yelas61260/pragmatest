package com.pragma.imagemanager.service.impl;

import org.springframework.stereotype.Service;

import com.pragma.imagemanager.model.constant.ImageManagerGlobalConstant;
import com.pragma.imagemanager.model.dto.ImageDTO;
import com.pragma.imagemanager.model.entity.ImageEntity;
import com.pragma.imagemanager.model.exception.conflict.ImageManagerResourceIdInvalidException;
import com.pragma.imagemanager.service.ImageMapperValidatorService;
import com.pragma.imagemanager.service.ResourceValidatorService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ImageMapperValidatorServiceImpl implements ImageMapperValidatorService {
	
	private ResourceValidatorService resourceValidatorService;

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
