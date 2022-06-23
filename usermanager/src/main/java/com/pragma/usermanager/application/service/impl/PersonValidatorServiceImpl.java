package com.pragma.usermanager.application.service.impl;

import com.pragma.usermanager.application.constant.UserManagerGobalConstant;
import com.pragma.usermanager.application.dto.PersonDTO;
import com.pragma.usermanager.application.exception.notfound.UserManagerCityNotFoundException;
import com.pragma.usermanager.application.exception.notfound.UserManagerPersonNotFoundException;
import com.pragma.usermanager.application.exception.notfound.UserManagerProfileNotFoundException;
import com.pragma.usermanager.application.exception.required.UserManagerProfileRequiredException;
import com.pragma.usermanager.application.service.CityService;
import com.pragma.usermanager.application.service.PersonValidatorService;
import com.pragma.usermanager.application.service.ProfileService;
import com.pragma.usermanager.domain.entity.PersonEntity;
import com.pragma.usermanager.domain.service.PersonDomainService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PersonValidatorServiceImpl implements PersonValidatorService {

	private final PersonDomainService personDomainService;
	private final CityService cityService;
	private final ProfileService profileService;
	
	@Override
	public void validateToCreate(PersonDTO personDTO) {
		validateEntityRequired(personDTO);
	}

	@Override
	public void validateToUpdate(PersonDTO personDTO) {
		if (personDTO.getId() <= UserManagerGobalConstant.ID_TO_CREATE_PERSON) {
			throw new UserManagerPersonNotFoundException();
		}
		PersonEntity personExist = personDomainService.getById(personDTO.getId());
		if (personExist == null) {
			throw new UserManagerPersonNotFoundException();
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
