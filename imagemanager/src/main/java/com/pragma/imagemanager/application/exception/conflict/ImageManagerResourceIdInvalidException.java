package com.pragma.imagemanager.application.exception.conflict;

import com.pragma.imagemanager.application.exception.ImageManagerException;

public class ImageManagerResourceIdInvalidException extends ImageManagerException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ImageManagerResourceIdInvalidException() {
		super("Invalid image ID");
	}

}
