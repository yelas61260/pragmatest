package com.pragma.imagemanager.application.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.imagemanager.application.mapper.ImageEntityWithDtoMapper;
import com.pragma.imagemanager.application.service.ImageValidatorService;
import com.pragma.imagemanager.application.service.ResourceValidatorService;

@SpringBootTest
public class ImageValidatorServiceTests {
	
	private ImageValidatorService imageValidatorService;
	
	@Mock
	private ResourceValidatorService resourceValidatorService;
	private ImageEntityWithDtoMapper imageEntityWithDtoMapper;
	
	@BeforeEach
	public void setup() {
		imageValidatorService = new ImageValidatorServiceImpl(resourceValidatorService, imageEntityWithDtoMapper);
	}

}
