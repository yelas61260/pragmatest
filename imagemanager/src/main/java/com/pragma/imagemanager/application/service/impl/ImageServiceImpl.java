package com.pragma.imagemanager.service.impl;

import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pragma.imagemanager.mapper.ImageMapper;
import com.pragma.imagemanager.model.dto.ImageDTO;
import com.pragma.imagemanager.model.entity.ImageEntity;
import com.pragma.imagemanager.model.exception.conflict.ImageManagerImageConvertException;
import com.pragma.imagemanager.model.exception.conflict.ImageManagerImageExistException;
import com.pragma.imagemanager.model.exception.notfound.ImageManagerImageNotFoundException;
import com.pragma.imagemanager.repository.ImageRepository;
import com.pragma.imagemanager.service.ImageMapperValidatorService;
import com.pragma.imagemanager.service.ImageService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ImageServiceImpl implements ImageService {
	
	private ImageRepository imageRepository;
	private ImageMapperValidatorService imageMapperValidatorService;
	private ImageMapper imageMapper;

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
		Optional<ImageEntity> image = imageRepository.findById(imageId);
		if (image.isEmpty()) {
			throw new ImageManagerImageNotFoundException();
		}else {
			return this.convertEntityToDto(image.get());
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
		if (!imageRepository.existsById(imageEntity.getId())) {
			return this.convertEntityToDto(imageRepository.insert(imageEntity));
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
		if (imageRepository.existsById(imageEntity.getId())) {
			return this.convertEntityToDto(imageRepository.save(imageEntity));
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
