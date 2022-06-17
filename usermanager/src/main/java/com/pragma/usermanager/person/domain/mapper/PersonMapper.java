package com.pragma.usermanager.person.domain.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;

import com.pragma.usermanager.person.domain.dto.PersonDTO;
import com.pragma.usermanager.person.domain.entity.PersonEntity;

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
