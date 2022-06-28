package com.pragma.usermanager.application.exception.notfound;

import com.pragma.usermanager.application.exception.UserManagerException;

public class UserManagerNotFoundException extends UserManagerException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserManagerNotFoundException(String message) {
		super(message);
	}

}
