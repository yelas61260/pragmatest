package com.pragma.imagemanager.infrastructure.db.mapper.impl;

import org.springframework.stereotype.Component;

import com.pragma.imagemanager.application.constant.ImageManagerGlobalConstant;
import com.pragma.imagemanager.application.constant.ImageResourceType;
import com.pragma.imagemanager.application.dto.entity.ImageDTO;
import com.pragma.imagemanager.infrastructure.db.entity.ImageMongoEntity;
import com.pragma.imagemanager.infrastructure.db.mapper.ImageMongoEntityWithDtoMapper;

@Component
public class ImageMongoEntityWithDtoMapperImpl implements ImageMongoEntityWithDtoMapper {

	@Override
	public ImageDTO toDto(ImageMongoEntity imageEntity) {
		String[] identifierSplit = imageEntity.getId().split(ImageManagerGlobalConstant.IMAGE_ID_SPLIT_CHART);

		ImageResourceType resourceType = ImageResourceType
				.findByPrefix(identifierSplit[ImageManagerGlobalConstant.IMAGE_ID_TYPE_INDEX]);
		
		int resourceId = Integer.parseInt(identifierSplit[ImageManagerGlobalConstant.IMAGE_ID_RESOURCE_ID_INDEX]);

		return ImageDTO.builder()
				.imageBase64(imageEntity.getBodyBase64())
				.associationType(resourceType.getId())
				.resourceId(resourceId)
				.imageName(imageEntity.getImageName())
				.build();
	}

	@Override
	public ImageMongoEntity toMongoEntity(ImageDTO imageDTO) {
		ImageResourceType resourceType = 
				ImageResourceType.findById(
						imageDTO.getAssociationType()
						);

		return ImageMongoEntity.builder()
				.id(
						resourceType.getPrefix()+
						ImageManagerGlobalConstant.IMAGE_ID_SPLIT_CHART+
						imageDTO.getResourceId()
						)
				.imageName(imageDTO.getImageName())
				.bodyBase64(imageDTO.getImageBase64())
				.build();
	}

}
