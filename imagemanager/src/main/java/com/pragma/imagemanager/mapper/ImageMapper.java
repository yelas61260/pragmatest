package com.pragma.imagemanager.mapper;

import org.mapstruct.Mapper;

import com.pragma.imagemanager.model.dto.ImageDTO;
import com.pragma.imagemanager.model.entity.ImageEntity;

@Mapper
public interface ImageMapper {
	
	ImageDTO toDto(ImageEntity imageEntity);
	ImageEntity toEntity(ImageDTO imageDTO);

}
