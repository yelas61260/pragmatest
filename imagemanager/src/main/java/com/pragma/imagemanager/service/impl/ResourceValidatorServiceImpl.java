package com.pragma.imagemanager.service.impl;

import org.springframework.stereotype.Service;

import com.pragma.imagemanager.model.constant.ImageResourceType;
import com.pragma.imagemanager.model.exception.notfound.ImageManagerResourceTypeNotFoundException;
import com.pragma.imagemanager.service.ResourceValidatorService;

@Service
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
