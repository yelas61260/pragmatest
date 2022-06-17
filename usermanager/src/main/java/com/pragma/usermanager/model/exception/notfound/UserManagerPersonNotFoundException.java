package com.pragma.usermanager.model.exception.notfound;

import com.pragma.usermanager.model.exception.UserManagerException;

public class UserManagerPersonNotFoundException extends UserManagerException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserManagerPersonNotFoundException() {
		super("Person Not Found");
	}

}
