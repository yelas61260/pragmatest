package com.pragma.usermanager.application.exception.notfound;

public class UserManagerProfileNotFoundException extends UserManagerNotFoundException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserManagerProfileNotFoundException() {
		super("Profile Not Found");
	}

}
