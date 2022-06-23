package com.pragma.usermanager.application.exception.notfound;

import com.pragma.usermanager.application.exception.UserManagerException;

public class UserManagerProfileNotFoundException extends UserManagerException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserManagerProfileNotFoundException() {
		super("Profile Not Found");
	}

}
