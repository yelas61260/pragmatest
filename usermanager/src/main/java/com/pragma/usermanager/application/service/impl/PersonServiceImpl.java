package com.pragma.usermanager.application.service.impl;

import java.util.List;

import com.pragma.usermanager.application.constant.UserManagerGobalConstant;
import com.pragma.usermanager.application.dto.entity.PersonDTO;
import com.pragma.usermanager.application.exception.notfound.UserManagerPersonNotFoundException;
import com.pragma.usermanager.application.service.PersonService;
import com.pragma.usermanager.application.service.PersonValidatorService;
import com.pragma.usermanager.infrastructure.db.repository.PersonRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PersonServiceImpl implements PersonService{
	
	private final PersonRepository personRepository;
	private final PersonValidatorService personValidatorService;

	@Override
	public List<PersonDTO> getAll() {
		return personRepository.getAll();
	}

	@Override
	public PersonDTO getById(int personId) {
		PersonDTO personFind = personRepository.getById(personId);
		if (personFind == null) {
			throw new UserManagerPersonNotFoundException();
		}else {
			return personFind;
		}
	}

	@Override
	public PersonDTO create(PersonDTO person) {
		person.setId(UserManagerGobalConstant.ID_TO_CREATE_PERSON);
		personValidatorService.validateToCreate(person);
		
		return personRepository.create(person);
	}

	@Override
	public PersonDTO update(PersonDTO person) {
		personValidatorService.validateToUpdate(person);

		PersonDTO personExist = personRepository.getById(person.getId());
		if (personExist == null) {
			throw new UserManagerPersonNotFoundException();
		}
		return personRepository.update(person);
	}

}