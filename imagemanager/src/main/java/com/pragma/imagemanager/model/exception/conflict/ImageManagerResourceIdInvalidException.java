package com.pragma.imagemanager.model.exception.conflict;

import com.pragma.imagemanager.model.exception.ImageManagerException;

public class ImageManagerResourceIdInvalidException extends ImageManagerException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ImageManagerResourceIdInvalidException() {
		super("Invalid image ID");
	}

}
