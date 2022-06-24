package com.pragma.imagemanager.application.service.impl;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.imagemanager.application.exception.notfound.ImageManagerResourceTypeNotFoundException;
import com.pragma.imagemanager.application.service.ResourceValidatorService;

@SpringBootTest
public class ResourceValidatorServiceTests {
	
	private ResourceValidatorService resourceValidatorService;
	
	@BeforeEach
	public void setup() {
		resourceValidatorService = new ResourceValidatorServiceImpl();
	}
	
	@Test
	public void validateResourceTypeByIdCorrect() {
		assertDoesNotThrow(() -> resourceValidatorService.validateResourceTypeById(1));
	}
	
	@Test
	public void validateResourceTypeByIdIncorrect() {
		assertThrows(ImageManagerResourceTypeNotFoundException.class, () -> resourceValidatorService.validateResourceTypeById(2));
	}

}
