package com.pragma.imagemanager.infrastructure.dao;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import com.mongodb.assertions.Assertions;
import com.pragma.imagemanager.domain.entity.ImageEntity;
import com.pragma.imagemanager.infrastructure.dao.ImageDao;

@DataMongoTest
public class ImageDaoTests {
	
	@Autowired
	private ImageDao imageDao;
	
	@Test
	public void getById() {
		Optional<ImageEntity> imageEntity1 = imageDao.findById("PI-1");
		Optional<ImageEntity> imageEntity2 = imageDao.findById("PI-0");
		
		Assertions.assertFalse(imageEntity1.isEmpty());
		Assertions.assertTrue(imageEntity2.isEmpty());
	}
	
	@Test
	public void insert() {
		ImageEntity imageEntityInsert = ImageEntity.builder()
				.id("T-1")
				.bodyBase64("content")
				.imageName("test")
				.build();
		ImageEntity imageEntityResponse = imageDao.insert(imageEntityInsert);
		Assertions.assertTrue(imageEntityResponse.getId().equals("T-1"));
		Assertions.assertTrue(imageEntityResponse.getBodyBase64().equals("content"));
		Assertions.assertTrue(imageEntityResponse.getImageName().equals("test"));
	}
	
	@Test
	public void update() {
		ImageEntity imageEntityInsert = ImageEntity.builder()
				.id("T-1")
				.bodyBase64("contentmodify")
				.imageName("test")
				.build();
		ImageEntity imageEntityResponse = imageDao.save(imageEntityInsert);
		Assertions.assertTrue(imageEntityResponse.getId().equals("T-1"));
		Assertions.assertTrue(imageEntityResponse.getBodyBase64().equals("contentmodify"));
		Assertions.assertTrue(imageEntityResponse.getImageName().equals("test"));
	}

}
