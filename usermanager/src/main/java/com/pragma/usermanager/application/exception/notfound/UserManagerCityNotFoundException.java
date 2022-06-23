package com.pragma.usermanager.model.exception.notfound;

import com.pragma.usermanager.model.exception.UserManagerException;

public class UserManagerCityNotFoundException extends UserManagerException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserManagerCityNotFoundException() {
		super("City Not found");
	}

}
