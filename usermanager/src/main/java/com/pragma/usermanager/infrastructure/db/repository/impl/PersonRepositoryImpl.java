package com.pragma.usermanager.infrastructure.db.repository.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.pragma.usermanager.application.dto.entity.PersonDTO;
import com.pragma.usermanager.infrastructure.db.dao.PersonDao;
import com.pragma.usermanager.infrastructure.db.entity.PersonMySqlEntity;
import com.pragma.usermanager.infrastructure.db.mapper.impl.PersonMySqlEntityWithDtoMapperImpl;
import com.pragma.usermanager.infrastructure.db.repository.PersonRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class PersonRepositoryImpl implements PersonRepository {
	
	private final PersonDao personDao;
	private final PersonMySqlEntityWithDtoMapperImpl personMySqlEntityWithDtoMapperImpl;

	@Override
	public List<PersonDTO> getAll() {
		return personMySqlEntityWithDtoMapperImpl.toDtoList((List<PersonMySqlEntity>) personDao.findAll());
	}

	@Override
	public PersonDTO getById(int personId) {
		Optional<PersonMySqlEntity> personFind = personDao.findById(personId);
		if (personFind.isEmpty()) {
			return null;
		}else {
			return personMySqlEntityWithDtoMapperImpl.toDto(personFind.get());
		}
	}

	@Override
	public PersonDTO create(PersonDTO person) {
		PersonMySqlEntity personMySqlEntity = personMySqlEntityWithDtoMapperImpl.toMySqlEntity(person);
		return personMySqlEntityWithDtoMapperImpl.toDto(personDao.save(personMySqlEntity));
	}

	@Override
	public PersonDTO update(PersonDTO person) {
		PersonMySqlEntity personMySqlEntity = personMySqlEntityWithDtoMapperImpl.toMySqlEntity(person);
		return personMySqlEntityWithDtoMapperImpl.toDto(personDao.save(personMySqlEntity));
	}

}
