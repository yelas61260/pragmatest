package com.pragma.usermanager.infrastructure.db.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;

import com.pragma.usermanager.application.dto.entity.PersonDTO;
import com.pragma.usermanager.infrastructure.db.entity.PersonMySqlEntity;

@Mapper
public interface PersonMySqlEntityWithDtoMapper {
	
	PersonDTO toDto(PersonMySqlEntity entity);
	PersonMySqlEntity toMySqlEntity(PersonDTO dto);
	
	default List<PersonDTO> toDtoList(List<PersonMySqlEntity> entities) {
		if (entities == null) {
			return new ArrayList<>();
		}
		return entities.stream().map(this::toDto).collect(Collectors.toList());
	}

}
