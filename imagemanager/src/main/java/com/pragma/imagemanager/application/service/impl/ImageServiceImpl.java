package com.pragma.imagemanager.application.service.impl;

import java.io.IOException;
import java.util.Base64;

import org.springframework.web.multipart.MultipartFile;

import com.pragma.imagemanager.application.dto.ImageDTO;
import com.pragma.imagemanager.application.exception.conflict.ImageManagerImageConvertException;
import com.pragma.imagemanager.application.exception.conflict.ImageManagerImageExistException;
import com.pragma.imagemanager.application.exception.notfound.ImageManagerImageNotFoundException;
import com.pragma.imagemanager.application.mapper.ImageMapper;
import com.pragma.imagemanager.application.service.ImageMapperValidatorService;
import com.pragma.imagemanager.application.service.ImageService;
import com.pragma.imagemanager.domain.entity.ImageEntity;
import com.pragma.imagemanager.domain.service.ImageDomainService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ImageServiceImpl implements ImageService {
	
	private final ImageDomainService imageDomainService;
	private final ImageMapperValidatorService imageMapperValidatorService;
	private final ImageMapper imageMapper;

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
	
	private ImageDTO convertEntityToDto(ImageEntity imageEntity) {
		imageMapperValidatorService.toDto(imageEntity);
		return imageMapper.toDto(imageEntity);
	}
	
	private ImageEntity convertDtoToEntity(ImageDTO imageDTO) {
		imageMapperValidatorService.toEntity(imageDTO);
		return imageMapper.toEntity(imageDTO);
	}

	@Override
	public ImageDTO getById(String imageId) {
		ImageEntity image = imageDomainService.getById(imageId);
		if (image == null) {
			throw new ImageManagerImageNotFoundException();
		}else {
			return this.convertEntityToDto(image);
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
		
		ImageEntity imageEntity = this.convertDtoToEntity(imageDTO);		
		ImageEntity imageEntityFind = imageDomainService.getById(imageEntity.getId());
		if (imageEntityFind == null) {
			return this.convertEntityToDto(imageDomainService.create(imageEntity));
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
		
		ImageEntity imageEntity = this.convertDtoToEntity(imageDTO);
		ImageEntity imageEntityFind = imageDomainService.getById(imageEntity.getId());
		if (imageEntityFind != null) {
			return this.convertEntityToDto(imageDomainService.update(imageEntity));
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
		
		ImageEntity imageEntity = this.convertDtoToEntity(imageDTO);
		
		return this.getById(imageEntity.getId());
	}

	@Override
	public byte[] getImageFileByAssociationTypeAndResourceId(int associationType, int resourceId) {
		ImageDTO imageDTO = this.getByAssociationTypeAndResourceId(associationType, resourceId);
		return convertBase64StringToImageFile(imageDTO.getImageBase64());
	}

}
