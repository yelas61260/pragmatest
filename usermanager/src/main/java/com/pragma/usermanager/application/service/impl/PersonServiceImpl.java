package com.pragma.usermanager.application.service.impl;

import java.util.List;

import com.pragma.usermanager.application.constant.UserManagerGobalConstant;
import com.pragma.usermanager.application.dto.PersonDTO;
import com.pragma.usermanager.application.exception.notfound.UserManagerPersonNotFoundException;
import com.pragma.usermanager.application.mapper.PersonMapper;
import com.pragma.usermanager.application.service.PersonService;
import com.pragma.usermanager.application.service.PersonValidatorService;
import com.pragma.usermanager.domain.entity.PersonEntity;
import com.pragma.usermanager.domain.service.PersonDomainService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PersonServiceImpl implements PersonService{
	
	private final PersonDomainService personDomainService;
	private final PersonValidatorService personValidatorService;
	private final PersonMapper personMapper;

	@Override
	public List<PersonDTO> getAll() {
		return personMapper.toDtoList(personDomainService.getAll());
	}

	@Override
	public PersonDTO getById(int personId) {
		PersonEntity personFind = personDomainService.getById(personId);
		if (personFind == null) {
			throw new UserManagerPersonNotFoundException();
		}else {
			return personMapper.toDto(personFind);
		}
	}

	@Override
	public PersonDTO create(PersonDTO person) {
		person.setId(UserManagerGobalConstant.ID_TO_CREATE_PERSON);
		personValidatorService.validateToCreate(person);
		
		return personMapper.toDto(
				personDomainService.create(personMapper.toEntity(person))
				);
	}

	@Override
	public PersonDTO update(PersonDTO person) {
		personValidatorService.validateToUpdate(person);
		
		return personMapper.toDto(
				personDomainService.update(personMapper.toEntity(person))
				);
	}

}