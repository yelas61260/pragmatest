package com.pragma.imagemanager.application.exception.conflict;

import com.pragma.imagemanager.application.exception.ImageManagerException;

public class ImageManagerConflictException extends ImageManagerException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ImageManagerConflictException(String message) {
		super(message);
	}

}
