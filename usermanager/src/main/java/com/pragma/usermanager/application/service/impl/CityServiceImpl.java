package com.pragma.usermanager.application.service.impl;

import com.pragma.usermanager.application.service.CityService;
import com.pragma.usermanager.infrastructure.db.repository.CityRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CityServiceImpl implements CityService {
	
	private final CityRepository cityRepository;
	
	@Override
	public boolean exist(int cityId) {
		return cityRepository.exist(cityId);
	}

}
