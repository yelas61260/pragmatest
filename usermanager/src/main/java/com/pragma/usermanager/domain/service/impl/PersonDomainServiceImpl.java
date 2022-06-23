package com.pragma.usermanager.domain.service.impl;

import java.util.List;

import com.pragma.usermanager.domain.entity.PersonEntity;
import com.pragma.usermanager.domain.repository.PersonRepository;
import com.pragma.usermanager.domain.service.PersonDomainService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PersonDomainServiceImpl implements PersonDomainService{
	
	private final PersonRepository personRepository;

	@Override
	public List<PersonEntity> getAll() {
		return personRepository.getAll();
	}

	@Override
	public PersonEntity getById(int personId) {
		return personRepository.getById(personId);
	}

	@Override
	public PersonEntity create(PersonEntity person) {
		return personRepository.create(person);
	}

	@Override
	public PersonEntity update(PersonEntity person) {
		return update(person);
	}

}