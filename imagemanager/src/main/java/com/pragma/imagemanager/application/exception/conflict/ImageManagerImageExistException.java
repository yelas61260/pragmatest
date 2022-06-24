package com.pragma.imagemanager.model.exception.conflict;

import com.pragma.imagemanager.model.exception.ImageManagerException;

public class ImageManagerImageExistException extends ImageManagerException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ImageManagerImageExistException() {
		super("Image id exist");
	}

}
