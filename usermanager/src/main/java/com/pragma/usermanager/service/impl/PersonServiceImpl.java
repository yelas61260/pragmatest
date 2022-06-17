package com.pragma.usermanager.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pragma.usermanager.mapper.PersonMapper;
import com.pragma.usermanager.model.dto.PersonDTO;
import com.pragma.usermanager.model.entity.PersonEntity;
import com.pragma.usermanager.model.entity.constant.UserManagerGobalConstant;
import com.pragma.usermanager.repository.RepositoryPerson;
import com.pragma.usermanager.service.PersonService;
import com.pragma.usermanager.service.PersonValidatorService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService{
	
	private final RepositoryPerson repositoryPerson;
	private final PersonValidatorService personValidatorService;
	private final PersonMapper personMapper;

	@Override
	public List<PersonDTO> getAll() {
		return personMapper.toDtoList((List<PersonEntity>) repositoryPerson.findAll());
	}

	@Override
	public PersonDTO getById(int personId) {
		Optional<PersonEntity> personFind = repositoryPerson.findById(personId);
		if (personFind.isEmpty()) {
			return null;
		}else {
			return personMapper.toDto(personFind.get());
		}
	}

	@Override
	public PersonDTO create(PersonDTO person) {
		person.setId(UserManagerGobalConstant.PERSON_CREATOR_ID);
		personValidatorService.validateToCreate(person);
		
		return personMapper.toDto(
				repositoryPerson.save(personMapper.toEntity(person))
				);
	}

	@Override
	public PersonDTO update(PersonDTO person) {
		personValidatorService.validateToUpdate(person);
		
		return personMapper.toDto(
				repositoryPerson.save(personMapper.toEntity(person))
				);
	}

}