package com.pragma.imagemanager.infrastructure.db.mapper;

import org.mapstruct.Mapper;

import com.pragma.imagemanager.application.dto.entity.ImageDTO;
import com.pragma.imagemanager.infrastructure.db.entity.ImageMongoEntity;

@Mapper
public interface ImageMongoEntityWithDtoMapper {
	
	ImageDTO toDto(ImageMongoEntity imageEntity);
	ImageMongoEntity toMongoEntity(ImageDTO imageDTO);

}
