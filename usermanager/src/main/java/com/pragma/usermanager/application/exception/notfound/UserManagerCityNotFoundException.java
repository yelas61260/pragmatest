package com.pragma.usermanager.application.exception.notfound;

import com.pragma.usermanager.application.exception.UserManagerException;

public class UserManagerCityNotFoundException extends UserManagerException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserManagerCityNotFoundException() {
		super("City Not found");
	}

}
