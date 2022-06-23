package com.pragma.usermanager.model.exception.notfound;

import com.pragma.usermanager.model.exception.UserManagerException;

public class UserManagerProfileNotFoundException extends UserManagerException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserManagerProfileNotFoundException() {
		super("Profile Not Found");
	}

}
