package com.pragma.imagemanager.controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pragma.imagemanager.model.dto.ImageDTO;
import com.pragma.imagemanager.model.dto.ResponseDTO;
import com.pragma.imagemanager.model.exception.conflict.ImageManagerImageConvertException;
import com.pragma.imagemanager.service.ImageService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/image")
public class ImageWriteController {
	
	private final ImageService imageService;
	
	@PostMapping("/{associationType}/{resourceId}")
	public ResponseEntity<ResponseDTO> create(@PathVariable("associationType") int associationType, @PathVariable("resourceId") int resourceId,
			@RequestParam(value = "image", required = true) MultipartFile imageFile) {
		try {
			ImageDTO imageDTO = ImageDTO.builder()
					.associationType(associationType)
					.resourceId(resourceId)
					.imageName(imageFile.getName())
					.imageBase64(imageService.convertImageFileToBase64String(imageFile.getBytes()))
					.build();

			ResponseDTO response = new ResponseDTO(imageService.create(imageDTO), HttpStatus.OK.value(), "success");
			return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
		} catch (IOException e) {
			throw new ImageManagerImageConvertException();
		}
	}
	
	@PutMapping("/{associationType}/{resourceId}")
	public ResponseEntity<ResponseDTO> update(@PathVariable("associationType") int associationType, @PathVariable("resourceId") int resourceId,
			@RequestParam(value = "image", required = true) MultipartFile imageFile) {
		try {
			ImageDTO imageDTO = ImageDTO.builder()
					.associationType(associationType)
					.resourceId(resourceId)
					.imageName(imageFile.getName())
					.imageBase64(imageService.convertImageFileToBase64String(imageFile.getBytes()))
					.build();

			ResponseDTO response = new ResponseDTO(imageService.update(imageDTO), HttpStatus.OK.value(), "success");
			return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
		} catch (IOException e) {
			throw new ImageManagerImageConvertException();
		}
	}

}
