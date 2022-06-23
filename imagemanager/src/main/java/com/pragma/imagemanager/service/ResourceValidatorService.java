package com.pragma.imagemanager.service;

public interface ResourceValidatorService {
	
	public void validateResourceTypeById(int resourceId);
	public void validateResourceTypeByPrefix(String resourcePrefix);

}
