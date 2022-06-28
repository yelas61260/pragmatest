package com.pragma.usermanager.application.mapper;

import org.mapstruct.Mapper;

import com.pragma.usermanager.application.dto.entity.PersonDTO;
import com.pragma.usermanager.domain.entity.PersonEntity;

@Mapper
public interface PersonEntityWithDtoMapper {
	
	PersonDTO toDto(PersonEntity entity);
	PersonEntity toEntity(PersonDTO dto);

}
