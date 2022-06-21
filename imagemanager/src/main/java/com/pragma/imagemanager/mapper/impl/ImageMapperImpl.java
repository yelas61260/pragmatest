package com.pragma.imagemanager.mapper.impl;

import org.springframework.stereotype.Component;

import com.pragma.imagemanager.mapper.ImageMapper;
import com.pragma.imagemanager.model.constant.ImageManagerGlobalConstant;
import com.pragma.imagemanager.model.constant.ImageResourceType;
import com.pragma.imagemanager.model.dto.ImageDTO;
import com.pragma.imagemanager.model.entity.ImageEntity;
import com.pragma.imagemanager.model.exception.conflict.ImageManagerResourceIdInvalidException;
import com.pragma.imagemanager.model.exception.notfound.ImageManagerResourceTypeNotFoundException;

@Component
public class ImageMapperImpl implements ImageMapper {

	@Override
	public ImageDTO toDto(ImageEntity imageEntity) {
		if (imageEntity.getId().matches(ImageManagerGlobalConstant.VALIDATE_IMAGE_ID_REGEX)) {
			String[] identifierSplit = imageEntity.getId().split(ImageManagerGlobalConstant.IMAGE_ID_SPLIT_CHART);
			
			ImageResourceType resourceType = 
					ImageResourceType.findByPrefix(
							identifierSplit[ImageManagerGlobalConstant.IMAGE_ID_TYPE_INDEX]
									);
			if (resourceType != null) {
				int resourceId = 
						Integer.parseInt(
								identifierSplit[ImageManagerGlobalConstant.IMAGE_ID_RESOURCE_ID_INDEX]
										);
				
				return ImageDTO.builder()
						.imageBase64(imageEntity.getBodyBase64())
						.associationType(resourceType.getId())
						.resourceId(resourceId)
						.imageName(imageEntity.getImageName())
						.build();
			} else {
				throw new ImageManagerResourceTypeNotFoundException();
			}
		} else {
			throw new ImageManagerResourceIdInvalidException();
		}		
	}

	@Override
	public ImageEntity toEntity(ImageDTO imageDTO) {
		ImageResourceType resourceType = 
				ImageResourceType.findById(
						imageDTO.getAssociationType()
								);
		
		if (resourceType != null) {						
			return new ImageEntity(
					(
						resourceType.getPrefix()+
						ImageManagerGlobalConstant.IMAGE_ID_SPLIT_CHART+
						imageDTO.getResourceId()
					), 
					imageDTO.getImageName(), 
					imageDTO.getImageBase64());
		} else {
			throw new ImageManagerResourceTypeNotFoundException();
		}
	}

}
