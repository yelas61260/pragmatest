package com.pragma.usermanager.application.exception.conflict;

public class UserManagerProfileRequiredException extends UserManagerConflictException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserManagerProfileRequiredException() {
		super("Profile is required");
	}

}
