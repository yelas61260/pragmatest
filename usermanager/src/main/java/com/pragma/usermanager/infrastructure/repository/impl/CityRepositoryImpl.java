package com.pragma.usermanager.infrastructure.repository.impl;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.pragma.usermanager.domain.entity.CityEntity;
import com.pragma.usermanager.domain.repository.CityRepository;
import com.pragma.usermanager.infrastructure.dao.CityDao;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CityRepositoryImpl implements CityRepository {
	
	private final CityDao cityDao;
	
	@Override
	public boolean exist(int cityId) {
		Optional<CityEntity> cityEntity = this.cityDao.findById(cityId);
		return !cityEntity.isEmpty();
	}

}
