package com.pragma.imagemanager.model.exception.conflict;

import com.pragma.imagemanager.model.exception.ImageManagerException;

public class ImageManagerConflictException extends ImageManagerException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ImageManagerConflictException(String message) {
		super(message);
	}

}
