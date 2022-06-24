package com.pragma.imagemanager.infrastructure.mapper.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.imagemanager.application.constant.ImageResourceType;
import com.pragma.imagemanager.application.dto.entity.ImageDTO;
import com.pragma.imagemanager.infrastructure.db.entity.ImageMongoEntity;
import com.pragma.imagemanager.infrastructure.db.mapper.ImageMongoEntityWithDtoMapper;
import com.pragma.imagemanager.infrastructure.db.mapper.impl.ImageMongoEntityWithDtoMapperImpl;

@SpringBootTest
public class ImageMongoEntityWithDtoMapperTests {
	
	private ImageMongoEntityWithDtoMapper imageMapper;
	
	@BeforeEach
	public void setup() {
		imageMapper = new ImageMongoEntityWithDtoMapperImpl();
	}
	
	@Test
	public void toDtoCorrect() {
		ImageMongoEntity imageEntity = ImageMongoEntity.builder()
				.id("PI-1")
				.bodyBase64("content")
				.imageName("imagen")
				.build();
		
		ImageDTO imageDTO = ImageDTO.builder()
				.associationType(ImageResourceType.PERSON_IMAGE.getId())
				.resourceId(1)
				.imageBase64("content")
				.imageName("imagen")
				.build();
		
		ImageDTO imageDTOResponse = imageMapper.toDto(imageEntity);
		assertTrue(imageDTO.getAssociationType() == imageDTOResponse.getAssociationType());
		assertTrue(imageDTO.getResourceId() == imageDTOResponse.getResourceId());
		assertTrue(imageDTO.getImageBase64().equals(imageDTOResponse.getImageBase64()));
		assertTrue(imageDTO.getImageName().equals(imageDTOResponse.getImageName()));
	}
	
	@Test
	public void toEntityCorrect() {
		ImageMongoEntity imageEntity = ImageMongoEntity.builder()
				.id("PI-1")
				.bodyBase64("content")
				.imageName("imagen")
				.build();
		
		ImageDTO imageDTO = ImageDTO.builder()
				.associationType(ImageResourceType.PERSON_IMAGE.getId())
				.resourceId(1)
				.imageBase64("content")
				.imageName("imagen")
				.build();
		
		ImageMongoEntity imageEntityResponse = imageMapper.toMongoEntity(imageDTO);
		assertTrue(imageEntity.getId().equals(imageEntityResponse.getId()));
		assertTrue(imageEntity.getBodyBase64().equals(imageEntityResponse.getBodyBase64()));
		assertTrue(imageEntity.getImageName().equals(imageEntityResponse.getImageName()));
	}
	
	@Test
	public void toDtoIncorrect() {
		ImageMongoEntity imageEntity = ImageMongoEntity.builder()
				.id("PI-1")
				.bodyBase64("content")
				.imageName("imagen")
				.build();
		
		ImageDTO imageDTO = ImageDTO.builder()
				.associationType(ImageResourceType.PERSON_IMAGE.getId())
				.resourceId(2)
				.imageBase64("content2")
				.imageName("imagen2")
				.build();
		
		ImageDTO imageDTOResponse = imageMapper.toDto(imageEntity);
		assertTrue(imageDTO.getAssociationType() == imageDTOResponse.getAssociationType());
		assertFalse(imageDTO.getResourceId() == imageDTOResponse.getResourceId());
		assertFalse(imageDTO.getImageBase64().equals(imageDTOResponse.getImageBase64()));
		assertFalse(imageDTO.getImageName().equals(imageDTOResponse.getImageName()));
	}
	
	@Test
	public void toEntityIncorrect() {
		ImageMongoEntity imageEntity = ImageMongoEntity.builder()
				.id("PI-1")
				.bodyBase64("content")
				.imageName("imagen")
				.build();
		
		ImageDTO imageDTO = ImageDTO.builder()
				.associationType(ImageResourceType.PERSON_IMAGE.getId())
				.resourceId(2)
				.imageBase64("content2")
				.imageName("imagen2")
				.build();
		
		ImageMongoEntity imageEntityResponse = imageMapper.toMongoEntity(imageDTO);
		assertFalse(imageEntity.getId().equals(imageEntityResponse.getId()));
		assertFalse(imageEntity.getBodyBase64().equals(imageEntityResponse.getBodyBase64()));
		assertFalse(imageEntity.getImageName().equals(imageEntityResponse.getImageName()));
	}

}
