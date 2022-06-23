package com.pragma.usermanager.domain.service.impl;

import com.pragma.usermanager.domain.repository.CityRepository;
import com.pragma.usermanager.domain.service.CityDomainService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CityDomainServiceImpl implements CityDomainService {
	
	private final CityRepository cityRepository;
	
	@Override
	public boolean exist(int cityId) {
		return cityRepository.exist(cityId);
	}

}
