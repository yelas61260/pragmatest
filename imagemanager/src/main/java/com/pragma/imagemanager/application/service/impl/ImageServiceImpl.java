package com.pragma.imagemanager.application.service.impl;

import java.io.IOException;
import java.util.Base64;

import org.springframework.web.multipart.MultipartFile;

import com.pragma.imagemanager.application.dto.entity.ImageDTO;
import com.pragma.imagemanager.application.exception.conflict.ImageManagerImageConvertException;
import com.pragma.imagemanager.application.exception.conflict.ImageManagerImageExistException;
import com.pragma.imagemanager.application.exception.notfound.ImageManagerImageNotFoundException;
import com.pragma.imagemanager.application.service.ImageService;
import com.pragma.imagemanager.application.service.ImageValidatorService;
import com.pragma.imagemanager.infrastructure.db.repository.ImageRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ImageServiceImpl implements ImageService {
	
	private final ImageRepository imageRepository;
	private final ImageValidatorService imageValidatorService;

	private String convertImageFileToBase64String(byte[] imageFile) {
		try {
			return Base64.getEncoder().encodeToString(imageFile);
		} catch (Exception e) {
			throw new ImageManagerImageConvertException();
		}
	}

	private byte[] convertBase64StringToImageFile(String imageString) {
		try {			
			return Base64.getDecoder().decode(imageString);
		} catch (Exception e) {
			throw new ImageManagerImageConvertException();
		}
	}

	@Override
	public ImageDTO create(int associationType, int resourceId, MultipartFile imageFile) {
		ImageDTO imageDTO = null;
		try {
			imageDTO = ImageDTO.builder()
					.associationType(associationType)
					.resourceId(resourceId)
					.imageName(imageFile.getName())
					.imageBase64(this.convertImageFileToBase64String(imageFile.getBytes()))
					.build();
		} catch (IOException e) {
			throw new ImageManagerImageConvertException();
		}
		
		imageValidatorService.validateImage(imageDTO);
			
		ImageDTO imageEntityFind = imageRepository.getById(imageDTO);
		if (imageEntityFind == null) {
			return imageRepository.create(imageDTO);
		} else {
			throw new ImageManagerImageExistException();
		}
	}

	@Override
	public ImageDTO update(int associationType, int resourceId, MultipartFile imageFile) {
		ImageDTO imageDTO = null;
		try {
			imageDTO = ImageDTO.builder()
					.associationType(associationType)
					.resourceId(resourceId)
					.imageName(imageFile.getName())
					.imageBase64(this.convertImageFileToBase64String(imageFile.getBytes()))
					.build();
		} catch (IOException e) {
			throw new ImageManagerImageConvertException();
		}
		
		imageValidatorService.validateImage(imageDTO);

		ImageDTO imageEntityFind = imageRepository.getById(imageDTO);
		if (imageEntityFind != null) {
			return imageRepository.update(imageDTO);
		} else {
			throw new ImageManagerImageNotFoundException();
		}
	}

	@Override
	public ImageDTO getByAssociationTypeAndResourceId(int associationType, int resourceId) {
		ImageDTO imageDTO = ImageDTO.builder()
				.associationType(associationType)
				.resourceId(resourceId)
				.build();
		
		imageValidatorService.validateImage(imageDTO);
		
		ImageDTO image = imageRepository.getById(imageDTO);
		if (image == null) {
			throw new ImageManagerImageNotFoundException();
		}else {
			return image;
		}
	}

	@Override
	public byte[] getImageFileByAssociationTypeAndResourceId(int associationType, int resourceId) {
		ImageDTO imageDTO = this.getByAssociationTypeAndResourceId(associationType, resourceId);
		return convertBase64StringToImageFile(imageDTO.getImageBase64());
	}

}
