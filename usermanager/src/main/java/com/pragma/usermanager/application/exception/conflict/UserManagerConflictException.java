package com.pragma.usermanager.application.exception.conflict;

import com.pragma.usermanager.application.exception.UserManagerException;

public class UserManagerConflictException extends UserManagerException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserManagerConflictException(String message) {
		super(message);
	}

}
