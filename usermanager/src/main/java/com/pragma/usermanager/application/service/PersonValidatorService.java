package com.pragma.usermanager.service;

import com.pragma.usermanager.model.dto.PersonDTO;

public interface PersonValidatorService {
	
	public void validateToCreate(PersonDTO personDTO);
	public void validateToUpdate(PersonDTO personDTO);

}
