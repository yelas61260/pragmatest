package com.pragma.usermanager.application.service.impl;

import com.pragma.usermanager.application.service.CityService;
import com.pragma.usermanager.domain.service.CityDomainService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CityServiceImpl implements CityService {
	
	private final CityDomainService cityDomainService;
	
	@Override
	public boolean exist(int cityId) {
		return cityDomainService.exist(cityId);
	}

}
