package com.pragma.usermanager.application.service.impl;

import com.pragma.usermanager.application.constant.UserManagerGobalConstant;
import com.pragma.usermanager.application.dto.entity.PersonDTO;
import com.pragma.usermanager.application.exception.conflict.UserManagerPersonConvertException;
import com.pragma.usermanager.application.exception.conflict.UserManagerProfileRequiredException;
import com.pragma.usermanager.application.exception.notfound.UserManagerCityNotFoundException;
import com.pragma.usermanager.application.exception.notfound.UserManagerPersonNotFoundException;
import com.pragma.usermanager.application.exception.notfound.UserManagerProfileNotFoundException;
import com.pragma.usermanager.application.mapper.PersonEntityWithDtoMapper;
import com.pragma.usermanager.application.service.CityService;
import com.pragma.usermanager.application.service.PersonValidatorService;
import com.pragma.usermanager.application.service.ProfileService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PersonValidatorServiceImpl implements PersonValidatorService {

	private final CityService cityService;
	private final ProfileService profileService;
	private final PersonEntityWithDtoMapper personEntityWithDtoMapper;
	
	@Override
	public void validateToCreate(PersonDTO personDTO) {
		validateEntityRequired(personDTO);
		
		try {
			personEntityWithDtoMapper.toEntity(personDTO);
		} catch (Exception e) {
			throw new UserManagerPersonConvertException();
		}
	}

	@Override
	public void validateToUpdate(PersonDTO personDTO) {
		if (personDTO.getId() <= UserManagerGobalConstant.ID_TO_CREATE_PERSON) {
			throw new UserManagerPersonNotFoundException();
		}
		
		try {
			personEntityWithDtoMapper.toEntity(personDTO);
		} catch (Exception e) {
			throw new UserManagerPersonConvertException();
		}
	}
	
	private void validateEntityRequired(PersonDTO personDTO) {
		if (personDTO.getCityId() != UserManagerGobalConstant.CITY_NULL_ID && !cityService.exist(personDTO.getCityId())) {
			throw new UserManagerCityNotFoundException();
		}
		if (personDTO.getProfileId() == UserManagerGobalConstant.PROFILE_NULL_ID) {
			throw new UserManagerProfileRequiredException();
		} else if (!profileService.exist(personDTO.getProfileId())) {
			throw new UserManagerProfileNotFoundException();
		}
	}

}