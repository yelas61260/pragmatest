package com.pragma.webflux.controller;

import java.time.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pragma.webflux.model.entity.ImageMongoEntity;
import com.pragma.webflux.repository.ImageRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/")
public class ImageRestController {
	
	private static final Logger log = LoggerFactory.getLogger(ImageRestController.class);
	
	@Autowired
	private ImageRepository imageRepository;
	
	@GetMapping("listar")
	public Flux<ImageMongoEntity> listar(Model model) {
		Flux<ImageMongoEntity> images = imageRepository.getAll()
				.map(image -> {
					image.setImageName(image.getImageName().toUpperCase());
					return image;
				}).doOnNext(image -> log.info(image.toString()));
		
		return images;
	}
	
	@GetMapping("/{imageId}")
	public Mono<ImageMongoEntity> getImageBase64(@PathVariable("imageId") int imageId) {
		ImageMongoEntity entity = new ImageMongoEntity();
		entity.setId("TEST-"+imageId);
		Mono<ImageMongoEntity> image = imageRepository.getById(entity)
				.doOnNext(img -> log.info(img.toString()));
		
		/*
		Flux<ImageMongoEntity> images = imageRepository.getAll();
		Mono<ImageMongoEntity> image = images.filter(img -> img.getId().equals("TEST-"+imageId))
				.next()
				.doOnNext(img -> log.info(img.toString()));
				*/
		
		return image;
	}
}
