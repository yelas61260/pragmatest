package com.pragma.usermanager.domain.repository;

import java.util.List;

import com.pragma.usermanager.domain.entity.PersonEntity;

public interface PersonRepository {
	
	public List<PersonEntity> getAll();
	public PersonEntity getById(int personId);
	
	public PersonEntity create(PersonEntity person);
	public PersonEntity update(PersonEntity person);

}
