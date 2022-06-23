package com.pragma.usermanager.application.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;

import com.pragma.usermanager.application.dto.PersonDTO;
import com.pragma.usermanager.domain.entity.PersonEntity;

@Mapper
public interface PersonMapper {
	
	PersonDTO toDto(PersonEntity entity);
	PersonEntity toEntity(PersonDTO dto);
	
	default List<PersonDTO> toDtoList(List<PersonEntity> entities) {
		if (entities == null) {
			return new ArrayList<>();
		}
		return entities.stream().map(this::toDto).collect(Collectors.toList());
	}

}
