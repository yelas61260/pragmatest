package com.pragma.imagemanager.service.impl;

import java.util.Base64;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pragma.imagemanager.mapper.ImageMapper;
import com.pragma.imagemanager.model.dto.ImageDTO;
import com.pragma.imagemanager.model.entity.ImageEntity;
import com.pragma.imagemanager.model.exception.conflict.ImageManagerImageConvertException;
import com.pragma.imagemanager.model.exception.conflict.ImageManagerImageExistException;
import com.pragma.imagemanager.model.exception.notfound.ImageManagerImageNotFoundException;
import com.pragma.imagemanager.repository.ImageRepository;
import com.pragma.imagemanager.service.ImageService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ImageServiceImpl implements ImageService {
	
	private ImageRepository imageRepository;
	private ImageMapper imageMapper;

	@Override
	public ImageDTO getById(String imageId) {
		Optional<ImageEntity> image = imageRepository.findById(imageId);
		if (image.isEmpty()) {
			throw new ImageManagerImageNotFoundException();
		}else {
			return imageMapper.toDto(image.get());
		}
	}

	@Override
	public ImageDTO create(ImageDTO imageDTO) {
		ImageEntity imageEntity = imageMapper.toEntity(imageDTO);
		if (!imageRepository.existsById(imageEntity.getId())) {
			return imageMapper.toDto(imageRepository.insert(imageEntity));
		} else {
			throw new ImageManagerImageExistException();
		}
	}

	@Override
	public ImageDTO update(ImageDTO imageDTO) {
		ImageEntity imageEntity = imageMapper.toEntity(imageDTO);
		if (imageRepository.existsById(imageEntity.getId())) {
			return imageMapper.toDto(imageRepository.save(imageEntity));
		} else {
			throw new ImageManagerImageNotFoundException();
		}
	}

	@Override
	public String convertImageFileToBase64String(byte[] imageFile) {
		try {
			return Base64.getEncoder().encodeToString(imageFile);
		} catch (Exception e) {
			throw new ImageManagerImageConvertException();
		}
	}

	@Override
	public byte[] convertBase64StringToImageFile(String imageString) {
		try {			
			return Base64.getDecoder().decode(imageString);
		} catch (Exception e) {
			throw new ImageManagerImageConvertException();
		}
	}

	@Override
	public ImageDTO getByAssociationTypeAndResourceId(int associationType, int resourceId) {
		ImageDTO imageDTO = ImageDTO.builder()
				.associationType(associationType)
				.resourceId(resourceId)
				.build();
		
		ImageEntity imageEntity = imageMapper.toEntity(imageDTO);
		
		return this.getById(imageEntity.getId());
	}

}
