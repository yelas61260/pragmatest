package com.pragma.usermanager.infrastructure.db.repository;

import java.util.List;

import com.pragma.usermanager.application.dto.entity.PersonDTO;

public interface PersonRepository {
	
	public List<PersonDTO> getAll();
	public PersonDTO getById(int personId);
	
	public PersonDTO create(PersonDTO person);
	public PersonDTO update(PersonDTO person);

}
