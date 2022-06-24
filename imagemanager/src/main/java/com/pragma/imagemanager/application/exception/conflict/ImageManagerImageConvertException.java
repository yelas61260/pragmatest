package com.pragma.imagemanager.application.exception.conflict;

import com.pragma.imagemanager.application.exception.ImageManagerException;

public class ImageManagerImageConvertException extends ImageManagerException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ImageManagerImageConvertException() {
		super("Image cant convert");
	}

}
