package com.pragma.imagemanager.model.exception.conflict;

import com.pragma.imagemanager.model.exception.ImageManagerException;

public class ImageManagerImageConvertException extends ImageManagerException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ImageManagerImageConvertException() {
		super("Image cant convert");
	}

}
