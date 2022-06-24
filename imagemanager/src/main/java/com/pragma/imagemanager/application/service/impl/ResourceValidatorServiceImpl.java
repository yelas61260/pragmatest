package com.pragma.imagemanager.application.service.impl;

import com.pragma.imagemanager.application.constant.ImageResourceType;
import com.pragma.imagemanager.application.exception.notfound.ImageManagerResourceTypeNotFoundException;
import com.pragma.imagemanager.application.service.ResourceValidatorService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ResourceValidatorServiceImpl implements ResourceValidatorService {

	@Override
	public void validateResourceTypeById(int resourceId) {
		ImageResourceType resourceType = 
				ImageResourceType.findById(resourceId);
		if (resourceType == null) {
			throw new ImageManagerResourceTypeNotFoundException();
		}
	}

	@Override
	public void validateResourceTypeByPrefix(String resourcePrefix) {
		ImageResourceType resourceType = 
				ImageResourceType.findByPrefix(resourcePrefix);
		if (resourceType == null) {
			throw new ImageManagerResourceTypeNotFoundException();
		}
	}

}
