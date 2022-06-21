package com.pragma.imagemanager.service;

import com.pragma.imagemanager.model.dto.ImageDTO;

public interface ImageService {
	
	public ImageDTO getById(String imageId);
	public ImageDTO getByAssociationTypeAndResourceId(int associationType, int resourceId);
	public ImageDTO create(ImageDTO imageDTO);
	public ImageDTO update(ImageDTO imageDTO);
	public String convertImageFileToBase64String(byte[] imageFile);
	public byte[] convertBase64StringToImageFile(String imageString);

}