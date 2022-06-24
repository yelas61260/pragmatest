package com.pragma.imagemanager.application.exception.notfound;

import com.pragma.imagemanager.application.exception.ImageManagerException;

public class ImageManagerNotFoundException extends ImageManagerException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ImageManagerNotFoundException(String message) {
		super(message);
	}

}
