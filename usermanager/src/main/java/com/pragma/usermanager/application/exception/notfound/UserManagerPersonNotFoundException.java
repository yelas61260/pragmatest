package com.pragma.usermanager.application.exception.notfound;

public class UserManagerPersonNotFoundException extends UserManagerNotFoundException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserManagerPersonNotFoundException() {
		super("Person Not Found");
	}

}
