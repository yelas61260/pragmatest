package com.pragma.usermanager.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pragma.usermanager.model.dto.PersonDTO;
import com.pragma.usermanager.model.entity.PersonEntity;
import com.pragma.usermanager.model.entity.constant.UserManagerGobalConstant;
import com.pragma.usermanager.model.exception.notfound.UserManagerCityNotFoundException;
import com.pragma.usermanager.model.exception.notfound.UserManagerPersonNotFoundException;
import com.pragma.usermanager.model.exception.notfound.UserManagerProfileNotFoundException;
import com.pragma.usermanager.model.exception.required.UserManagerProfileRequiredException;
import com.pragma.usermanager.repository.PersonRepository;
import com.pragma.usermanager.service.CityService;
import com.pragma.usermanager.service.PersonValidatorService;
import com.pragma.usermanager.service.ProfileService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PersonValidatorServiceImpl implements PersonValidatorService {

	private final PersonRepository repositoryPerson;
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
		Optional<PersonEntity> personExist = repositoryPerson.findById(personDTO.getId());
		if (personExist.isEmpty()) {
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
