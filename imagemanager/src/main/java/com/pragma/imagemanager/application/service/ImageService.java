package com.pragma.imagemanager.application.service;

import org.springframework.web.multipart.MultipartFile;

import com.pragma.imagemanager.application.dto.entity.ImageDTO;

public interface ImageService {
	
	public ImageDTO getByAssociationTypeAndResourceId(int associationType, int resourceId);
	public ImageDTO create(int associationType, int resourceId, MultipartFile imageFile);
	public ImageDTO update(int associationType, int resourceId, MultipartFile imageFile);
	public byte[] getImageFileByAssociationTypeAndResourceId(int associationType, int resourceId);
	
}