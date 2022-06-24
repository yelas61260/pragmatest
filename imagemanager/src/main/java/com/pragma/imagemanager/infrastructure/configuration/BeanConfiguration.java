package com.pragma.imagemanager.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pragma.imagemanager.application.mapper.ImageMapper;
import com.pragma.imagemanager.application.service.ImageMapperValidatorService;
import com.pragma.imagemanager.application.service.ResourceValidatorService;
import com.pragma.imagemanager.application.service.impl.ImageMapperValidatorServiceImpl;
import com.pragma.imagemanager.application.service.impl.ImageServiceImpl;
import com.pragma.imagemanager.application.service.impl.ResourceValidatorServiceImpl;
import com.pragma.imagemanager.domain.repository.ImageRepository;
import com.pragma.imagemanager.domain.service.ImageDomainService;
import com.pragma.imagemanager.domain.service.impl.ImageDomainServiceImpl;

@Configuration
public class BeanConfiguration {
	
	@Bean
	public ImageMapperValidatorServiceImpl imageMapperValidatorService(ResourceValidatorService resourceValidatorService) {
		return new ImageMapperValidatorServiceImpl(resourceValidatorService);
	}
	
	@Bean
	public ImageServiceImpl imageService(ImageDomainService imageDomainService, ImageMapperValidatorService imageMapperValidatorService, ImageMapper imageMapper) {
		return new ImageServiceImpl(imageDomainService, imageMapperValidatorService, imageMapper);
	}
	
	@Bean
	public ResourceValidatorServiceImpl resourceValidatorService() {
		return new ResourceValidatorServiceImpl();
	}
	
	@Bean
	public ImageDomainServiceImpl imageDomainService(ImageRepository imageRepository) {
		return new ImageDomainServiceImpl(imageRepository);
	}

}
