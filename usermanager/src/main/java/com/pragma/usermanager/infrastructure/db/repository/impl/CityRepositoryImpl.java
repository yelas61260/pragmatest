package com.pragma.usermanager.infrastructure.db.repository.impl;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.pragma.usermanager.infrastructure.db.dao.CityDao;
import com.pragma.usermanager.infrastructure.db.entity.CityMySqlEntity;
import com.pragma.usermanager.infrastructure.db.repository.CityRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CityRepositoryImpl implements CityRepository {
	
	private final CityDao cityDao;
	
	@Override
	public boolean exist(int cityId) {
		Optional<CityMySqlEntity> cityEntity = this.cityDao.findById(cityId);
		return !cityEntity.isEmpty();
	}

}
