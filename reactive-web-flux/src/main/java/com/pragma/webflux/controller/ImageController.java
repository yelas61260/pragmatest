package com.pragma.webflux.controller;

import java.time.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;

import com.pragma.webflux.model.entity.ImageMongoEntity;
import com.pragma.webflux.repository.ImageRepository;

import reactor.core.publisher.Flux;

@Controller
public class ImageController {
	
	private static final Logger log = LoggerFactory.getLogger(ImageController.class);
	
	@Autowired
	private ImageRepository imageRepository;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		Flux<ImageMongoEntity> images = imageRepository.getAll()
				.map(image -> {
					image.setImageName(image.getImageName().toUpperCase());
					return image;
				});
		
		images.subscribe(
				image -> log.info(image.toString())
				);
		
		model.addAttribute("images", images);
		model.addAttribute("titulo", "Listado de imagenes");
		return "listar";
	}
	
	@GetMapping("/listar-data-driver")
	public String listarDataDriver(Model model) {
		Flux<ImageMongoEntity> images = imageRepository.getAll()
				.map(image -> {
					image.setImageName(image.getImageName().toUpperCase());
					return image;
				}).delayElements(Duration.ofSeconds(2));
		
		images.subscribe(
				image -> log.info(image.toString())
				);
		
		model.addAttribute("images", new ReactiveDataDriverContextVariable(images, 1));
		model.addAttribute("titulo", "Listado de imagenes");
		return "listar";
	}
	
	@GetMapping("/listar-full")
	public String listarFull(Model model) {
		Flux<ImageMongoEntity> images = imageRepository.getAll()
				.map(image -> {
					image.setImageName(image.getImageName().toUpperCase());
					return image;
				}).repeat(10000);
		
		model.addAttribute("images", images);
		model.addAttribute("titulo", "Listado de imagenes");
		return "listar";
	}
	
	@GetMapping("/listar-chunked")
	public String listarChunked(Model model) {
		Flux<ImageMongoEntity> images = imageRepository.getAll()
				.map(image -> {
					image.setImageName(image.getImageName().toUpperCase());
					return image;
				}).repeat(10000);
		
		model.addAttribute("images", images);
		model.addAttribute("titulo", "Listado de imagenes");
		return "listar-chunked";
	}

}
