package com.pragma.usermanager.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pragma.usermanager.model.entity.CityEntity;
import com.pragma.usermanager.repository.RepositoryCity;
import com.pragma.usermanager.service.CityService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {
	
	private final RepositoryCity repositoryCity;
	
	@Override
	public boolean exist(int cityId) {
		Optional<CityEntity> cityEntity = this.repositoryCity.findById(cityId);
		return !cityEntity.isEmpty();
	}

}
