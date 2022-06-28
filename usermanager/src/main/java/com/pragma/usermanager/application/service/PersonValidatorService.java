package com.pragma.usermanager.application.service;

import com.pragma.usermanager.application.dto.entity.PersonDTO;

public interface PersonValidatorService {
	
	public void validateToCreate(PersonDTO personDTO);
	public void validateToUpdate(PersonDTO personDTO);

}
