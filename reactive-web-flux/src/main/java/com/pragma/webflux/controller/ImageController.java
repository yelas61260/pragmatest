package com.pragma.webflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pragma.webflux.model.entity.ImageMongoEntity;
import com.pragma.webflux.repository.ImageRepository;

import reactor.core.publisher.Flux;

@Controller
public class ImageController {
	
	@Autowired
	private ImageRepository imageRepository;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		Flux<ImageMongoEntity> images = imageRepository.getAll();
		
		model.addAttribute("images", images);
		model.addAttribute("titulo", "Listado de imagenes");
		return "listar";
	}

}
