package com.pragma.usermanager.application.exception.notfound;

import com.pragma.usermanager.application.exception.UserManagerException;

public class UserManagerPersonNotFoundException extends UserManagerException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserManagerPersonNotFoundException() {
		super("Person Not Found");
	}

}
