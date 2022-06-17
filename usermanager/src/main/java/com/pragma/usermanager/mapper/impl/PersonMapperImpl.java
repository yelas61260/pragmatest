package com.pragma.usermanager.mapper.impl;

import org.springframework.stereotype.Component;

import com.pragma.usermanager.mapper.PersonMapper;
import com.pragma.usermanager.model.dto.PersonDTO;
import com.pragma.usermanager.model.entity.CityEntity;
import com.pragma.usermanager.model.entity.PersonEntity;
import com.pragma.usermanager.model.entity.ProfileEntity;
import com.pragma.usermanager.model.entity.constant.UserManagerGobalConstant;

@Component
public class PersonMapperImpl implements PersonMapper {

	@Override
	public PersonDTO toDto(PersonEntity entity) {
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
	public PersonEntity toEntity(PersonDTO dto) {
		PersonEntity entity = new PersonEntity();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setCityId(dto.getCityId()==0?null:new CityEntity(dto.getCityId()));
		entity.setProfileId(new ProfileEntity(dto.getProfileId()));
		entity.setImage(dto.getImage());
		return entity;
	}

}
