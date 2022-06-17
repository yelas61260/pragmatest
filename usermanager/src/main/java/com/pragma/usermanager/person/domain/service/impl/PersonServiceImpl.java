package com.pragma.usermanager.person.domain.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pragma.usermanager.person.domain.dto.PersonDTO;
import com.pragma.usermanager.person.domain.entity.PersonEntity;
import com.pragma.usermanager.person.domain.mapper.PersonMapper;
import com.pragma.usermanager.person.domain.repository.RepositoryPerson;
import com.pragma.usermanager.person.domain.service.PersonService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService{
	
	private final RepositoryPerson repositoryPerson;
	private PersonMapper personMapper;

	@Override
	public List<PersonDTO> getAllPerson() {
		return personMapper.toDtoList((List<PersonEntity>) repositoryPerson.findAll());
	}

	@Override
	public PersonDTO getPersonById(int personId) {
		Optional<PersonEntity> personFind = repositoryPerson.findById(personId);
		if (personFind.isEmpty()) {
			return null;
		}else {
			return personMapper.toDto(personFind.get());
		}
	}	

}
