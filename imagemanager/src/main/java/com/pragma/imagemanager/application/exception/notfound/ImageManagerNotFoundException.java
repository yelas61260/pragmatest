package com.pragma.imagemanager.model.exception.notfound;

import com.pragma.imagemanager.model.exception.ImageManagerException;

public class ImageManagerNotFoundException extends ImageManagerException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ImageManagerNotFoundException(String message) {
		super(message);
	}

}
