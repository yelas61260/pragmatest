package com.pragma.imagemanager.application.mapper;

import org.mapstruct.Mapper;

import com.pragma.imagemanager.application.dto.entity.ImageDTO;
import com.pragma.imagemanager.domain.entity.ImageEntity;

@Mapper
public interface ImageEntityWithDtoMapper {
	
	ImageDTO toDto(ImageEntity imageEntity);
	ImageEntity toEntity(ImageDTO imageDTO);

}
