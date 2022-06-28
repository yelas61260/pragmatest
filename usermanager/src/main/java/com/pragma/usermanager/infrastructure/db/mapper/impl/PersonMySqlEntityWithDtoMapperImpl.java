package com.pragma.usermanager.infrastructure.db.mapper.impl;

import org.springframework.stereotype.Component;

import com.pragma.usermanager.application.constant.UserManagerGobalConstant;
import com.pragma.usermanager.application.dto.entity.PersonDTO;
import com.pragma.usermanager.infrastructure.db.entity.CityMySqlEntity;
import com.pragma.usermanager.infrastructure.db.entity.PersonMySqlEntity;
import com.pragma.usermanager.infrastructure.db.entity.ProfileMySqlEntity;
import com.pragma.usermanager.infrastructure.db.mapper.PersonMySqlEntityWithDtoMapper;

@Component
public class PersonMySqlEntityWithDtoMapperImpl implements PersonMySqlEntityWithDtoMapper {

	@Override
	public PersonDTO toDto(PersonMySqlEntity entity) {
		return PersonDTO.builder()
				.id(entity.getId())
				.name(entity.getName())
				.email(entity.getEmail())
				.cityId(entity.getCityId()!=null?entity.getCityId().getId():UserManagerGobalConstant.CITY_NULL_ID)
				.cityName(entity.getCityId()!=null?entity.getCityId().getName():UserManagerGobalConstant.CITY_NULL_TEXT)
				.profileId(entity.getProfileId().getId())
				.profileName(entity.getProfileId().getName())
				.image(entity.getImage())
				.createDate(entity.getCreateDate())
				.updateDate(entity.getUpdateDate())
				.build();
	}

	@Override
	public PersonMySqlEntity toMySqlEntity(PersonDTO dto) {
		return PersonMySqlEntity.builder()
				.id(dto.getId())
				.name(dto.getName())
				.email(dto.getEmail())
				.cityId(
						dto.getCityId()==0
						?null
						:CityMySqlEntity.builder().id(dto.getCityId()).build()
						)
				.profileId(
						ProfileMySqlEntity.builder().id(dto.getProfileId()).build()
						)
				.image(dto.getImage())
				.build();
	}

}
