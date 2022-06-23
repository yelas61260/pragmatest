package com.pragma.usermanager.domain.service;

import java.util.List;

import com.pragma.usermanager.domain.entity.PersonEntity;

public interface PersonDomainService {
	
	public List<PersonEntity> getAll();
	public PersonEntity getById(int personId);
	
	public PersonEntity create(PersonEntity person);
	public PersonEntity update(PersonEntity person);

}
