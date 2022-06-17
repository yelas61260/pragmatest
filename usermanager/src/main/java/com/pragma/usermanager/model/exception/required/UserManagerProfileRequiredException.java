package com.pragma.usermanager.model.exception.required;

import com.pragma.usermanager.model.exception.UserManagerException;

public class UserManagerProfileRequiredException extends UserManagerException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserManagerProfileRequiredException() {
		super("Profile is required");
	}

}
