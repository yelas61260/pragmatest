package com.pragma.usermanager.application.service;

import com.pragma.usermanager.application.dto.PersonDTO;

public interface PersonValidatorService {
	
	public void validateToCreate(PersonDTO personDTO);
	public void validateToUpdate(PersonDTO personDTO);

}
