package com.pragma.usermanager.infrastructure.repository.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.pragma.usermanager.domain.entity.PersonEntity;
import com.pragma.usermanager.domain.repository.PersonRepository;
import com.pragma.usermanager.infrastructure.dao.PersonDao;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class PersonRepositoryImpl implements PersonRepository {
	
	private final PersonDao personDao;

	@Override
	public List<PersonEntity> getAll() {
		return (List<PersonEntity>) personDao.findAll();
	}

	@Override
	public PersonEntity getById(int personId) {
		Optional<PersonEntity> personFind = personDao.findById(personId);
		if (personFind.isEmpty()) {
			return null;
		}else {
			return personFind.get();
		}
	}

	@Override
	public PersonEntity create(PersonEntity person) {		
		return personDao.save(person);
	}

	@Override
	public PersonEntity update(PersonEntity person) {		
		return personDao.save(person);
	}

}
