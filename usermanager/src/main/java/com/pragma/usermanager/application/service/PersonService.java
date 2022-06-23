package com.pragma.usermanager.service;

import java.util.List;

import com.pragma.usermanager.model.dto.PersonDTO;

public interface PersonService {
	
	public List<PersonDTO> getAll();
	public PersonDTO getById(int personId);
	
	public PersonDTO create(PersonDTO person);
	public PersonDTO update(PersonDTO person);

}
