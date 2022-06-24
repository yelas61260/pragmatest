package com.pragma.imagemanager.application.exception.conflict;

import com.pragma.imagemanager.application.exception.ImageManagerException;

public class ImageManagerImageExistException extends ImageManagerException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ImageManagerImageExistException() {
		super("Image id exist");
	}

}
