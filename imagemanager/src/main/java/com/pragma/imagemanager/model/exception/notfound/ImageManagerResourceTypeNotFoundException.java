package com.pragma.imagemanager.model.exception.notfound;

public class ImageManagerResourceTypeNotFoundException extends ImageManagerNotFoundException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ImageManagerResourceTypeNotFoundException() {
		super("Invalid resource prefix");
	}

}
