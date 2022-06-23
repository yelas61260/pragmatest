package com.pragma.imagemanager.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pragma.imagemanager.model.dto.ImageDTO;
import com.pragma.imagemanager.service.ImageService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/image")
public class ImageReadController {

	private final ImageService imageService;
	
	@GetMapping("/{associationType}/{resourceId}/base64")
	public @ResponseBody String getImageBase64(@PathVariable("associationType") int associationType, @PathVariable("resourceId") int resourceId) {
		ImageDTO imageDTO = imageService.getByAssociationTypeAndResourceId(associationType, resourceId);
		return imageDTO.getImageBase64();
	}
	
	@GetMapping(value = "/{associationType}/{resourceId}/file", produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody byte[] getImageFile(@PathVariable("associationType") int associationType, @PathVariable("resourceId") int resourceId) {
		ImageDTO imageDTO = imageService.getByAssociationTypeAndResourceId(associationType, resourceId);
		return imageService.convertBase64StringToImageFile(imageDTO.getImageBase64());
	}
	
}
