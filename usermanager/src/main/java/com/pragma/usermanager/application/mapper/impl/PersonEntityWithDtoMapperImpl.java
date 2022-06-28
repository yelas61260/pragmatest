package com.pragma.usermanager.application.mapper.impl;

import com.pragma.usermanager.application.dto.entity.PersonDTO;
import com.pragma.usermanager.application.mapper.PersonEntityWithDtoMapper;
import com.pragma.usermanager.domain.entity.PersonEntity;

public class PersonEntityWithDtoMapperImpl implements PersonEntityWithDtoMapper {

	@Override
	public PersonDTO toDto(PersonEntity entity) {
		return PersonDTO.builder()
				.id(entity.getId())
				.name(entity.getName())
				.email(entity.getEmail())
				.image(entity.getImage())
				.cityId(entity.getCityId())
				.cityName(entity.getCityName())
				.profileId(entity.getProfileId())
				.profileName(entity.getProfileName())
				.createDate(entity.getCreateDate())
				.updateDate(entity.getUpdateDate())
				.build();
	}

	@Override
	public PersonEntity toEntity(PersonDTO dto) {
		return PersonEntity.builder()
				.id(dto.getId())
				.name(dto.getName())
				.email(dto.getEmail())
				.image(dto.getImage())
				.cityId(dto.getCityId())
				.cityName(dto.getCityName())
				.profileId(dto.getProfileId())
				.profileName(dto.getProfileName())
				.createDate(dto.getCreateDate())
				.updateDate(dto.getUpdateDate())
				.build();
	}

}
