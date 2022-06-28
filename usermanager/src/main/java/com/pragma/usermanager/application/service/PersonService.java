package com.pragma.usermanager.application.service;

import java.util.List;

import com.pragma.usermanager.application.dto.entity.PersonDTO;

public interface PersonService {
	
	public List<PersonDTO> getAll();
	public PersonDTO getById(int personId);
	
	public PersonDTO create(PersonDTO person);
	public PersonDTO update(PersonDTO person);

}
