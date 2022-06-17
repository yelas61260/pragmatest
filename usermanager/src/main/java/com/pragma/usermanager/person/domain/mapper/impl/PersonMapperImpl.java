package com.pragma.usermanager.person.domain.mapper.impl;

import org.springframework.stereotype.Component;

import com.pragma.usermanager.city.domain.UserManagerConstant;
import com.pragma.usermanager.person.domain.dto.PersonDTO;
import com.pragma.usermanager.person.domain.entity.CityEntity;
import com.pragma.usermanager.person.domain.entity.PersonEntity;
import com.pragma.usermanager.person.domain.mapper.PersonMapper;
import com.pragma.usermanager.profile.domain.entity.ProfileEntity;

@Component
public class PersonMapperImpl implements PersonMapper {

	@Override
	public PersonDTO toDto(PersonEntity entity) {
		return PersonDTO.builder()
				.id(entity.getId())
				.name(entity.getName())
				.email(entity.getEmail())
				.cityId(entity.getCityId()!=null?entity.getCityId().getId():UserManagerConstant.CITY_NULL.getId())
				.cityName(entity.getCityId()!=null?entity.getCityId().getName():UserManagerConstant.CITY_NULL.getValue())
				.profileId(entity.getProfileId().getId())
				.profileName(entity.getProfileId().getName())
				.image(entity.getImage())
				.createDate(entity.getCreateDate())
				.updateDate(entity.getUpdateDate())
				.build();
	}

	@Override
	public PersonEntity toEntity(PersonDTO dto) {
		PersonEntity entity = new PersonEntity();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setCityId(new CityEntity(dto.getCityId()));
		entity.setProfileId(new ProfileEntity(dto.getProfileId()));
		entity.setImage(dto.getImage());
		return entity;
	}

}
