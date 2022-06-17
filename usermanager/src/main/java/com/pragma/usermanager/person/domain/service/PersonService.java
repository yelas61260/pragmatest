package com.pragma.usermanager.person.domain.service;

import java.util.List;

import com.pragma.usermanager.person.domain.dto.PersonDTO;

public interface PersonService {
	
	public List<PersonDTO> getAllPerson();
	public PersonDTO getPersonById(int personId);

}
