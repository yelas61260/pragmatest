package com.pragma.imagemanager.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pragma.imagemanager.application.mapper.ImageEntityWithDtoMapper;
import com.pragma.imagemanager.application.service.ImageValidatorService;
import com.pragma.imagemanager.application.service.ResourceValidatorService;
import com.pragma.imagemanager.application.service.impl.ImageServiceImpl;
import com.pragma.imagemanager.application.service.impl.ImageValidatorServiceImpl;
import com.pragma.imagemanager.application.service.impl.ResourceValidatorServiceImpl;
import com.pragma.imagemanager.infrastructure.db.repository.ImageRepository;

@Configuration
public class BeanApplicationConfiguration {
	
	@Bean
	public ImageValidatorServiceImpl imageMapperValidatorService(ResourceValidatorService resourceValidatorService, ImageEntityWithDtoMapper imageEntityWithDtoMapper) {
		return new ImageValidatorServiceImpl(resourceValidatorService, imageEntityWithDtoMapper);
	}
	
	@Bean
	public ImageServiceImpl imageService(ImageRepository imageRepository, ImageValidatorService imageValidatorService) {
		return new ImageServiceImpl(imageRepository, imageValidatorService);
	}
	
	@Bean
	public ResourceValidatorServiceImpl resourceValidatorService() {
		return new ResourceValidatorServiceImpl();
	}

}
