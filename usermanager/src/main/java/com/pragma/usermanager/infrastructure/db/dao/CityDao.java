package com.pragma.usermanager.infrastructure.db.dao;

import org.springframework.data.repository.CrudRepository;

import com.pragma.usermanager.infrastructure.db.entity.CityMySqlEntity;

public interface CityDao extends CrudRepository<CityMySqlEntity, Integer> {

}
