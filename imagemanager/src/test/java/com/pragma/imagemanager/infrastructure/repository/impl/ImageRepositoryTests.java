package com.pragma.imagemanager.infrastructure.repository.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.imagemanager.domain.entity.ImageEntity;
import com.pragma.imagemanager.domain.repository.ImageRepository;
import com.pragma.imagemanager.infrastructure.dao.ImageDao;

@SpringBootTest
public class ImageRepositoryTests {
	
	@Mock
	private ImageDao imageDao;
	
	private ImageRepository imageRepository;
	
	@BeforeEach
	public void setup() {
		imageRepository = new ImageRepositoryImpl(imageDao);
		
		ImageEntity imageEntity = ImageEntity.builder()
				.id("PI-1")
				.bodyBase64("content")
				.imageName("image")
				.build();
		
		Mockito.when(imageDao.findById("PI-0"))
		.thenReturn(Optional.empty());
		Mockito.when(imageDao.findById("PI-1"))
		.thenReturn(Optional.of(imageEntity));
		Mockito.when(imageDao.insert(imageEntity))
		.thenReturn(imageEntity);
		Mockito.when(imageDao.save(imageEntity))
		.thenReturn(imageEntity);
	}
	
	@Test
	public void getById() {
		ImageEntity imageEntity1 = imageRepository.getById("PI-0");
		assertNull(imageEntity1);
		
		ImageEntity imageEntity2 = imageRepository.getById("PI-1");
		assertThat(imageEntity2.getId()).isEqualTo("PI-1");
		assertThat(imageEntity2.getBodyBase64()).isEqualTo("content");
	}
	
	@Test
	public void create() {
		ImageEntity imageEntityCreate = ImageEntity.builder()
				.id("PI-1")
				.bodyBase64("content")
				.imageName("image")
				.build();
		ImageEntity imageEntity = imageRepository.create(imageEntityCreate);
		assertThat(imageEntity.getId()).isEqualTo("PI-1");
	}
	
	@Test
	public void update() {
		ImageEntity imageEntityUpdate = ImageEntity.builder()
				.id("PI-1")
				.bodyBase64("content")
				.imageName("image")
				.build();
		ImageEntity imageEntity = imageRepository.update(imageEntityUpdate);
		assertThat(imageEntity.getId()).isEqualTo("PI-1");
	}

}
