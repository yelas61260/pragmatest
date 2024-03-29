package com.pragma.imagemanager.application.mapper.impl;

import com.pragma.imagemanager.application.dto.entity.ImageDTO;
import com.pragma.imagemanager.application.mapper.ImageEntityWithDtoMapper;
import com.pragma.imagemanager.domain.entity.ImageEntity;

public class ImageEntityWithDtoMapperImpl implements ImageEntityWithDtoMapper {

	@Override
	public ImageDTO toDto(ImageEntity imageEntity) {
		return ImageDTO.builder()
				.imageBase64(imageEntity.getBodyBase64())
				.associationType(imageEntity.getAssociationType())
				.resourceId(imageEntity.getResourceId())
				.imageName(imageEntity.getImageName())
				.build();
	}

	@Override
	public ImageEntity toEntity(ImageDTO imageDTO) {
		return ImageEntity.builder()
				.bodyBase64(imageDTO.getImageBase64())
				.associationType(imageDTO.getAssociationType())
				.resourceId(imageDTO.getResourceId())
				.imageName(imageDTO.getImageName())
				.build();
	}

}
