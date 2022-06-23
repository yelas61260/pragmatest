package com.pragma.usermanager.infrastructure.dao;

import org.springframework.data.repository.CrudRepository;

import com.pragma.usermanager.domain.entity.CityEntity;

public interface CityDao extends CrudRepository<CityEntity, Integer> {

}
